
#include <OneWire.h>
#include <DallasTemperature.h>
 
// 定义DS18B20数据口连接arduino的2号IO上
#define ONE_WIRE_BUS 2

// 初始连接在单总线上的单总线设备
OneWire oneWire(ONE_WIRE_BUS);
DallasTemperature sensors(&oneWire);

int latchPin = 6;  //ST_CP移位
int clockPin = 5;  //SH_CP时钟
int dataPin = 4;  //DS数据串口
byte number = 0;


void setup() {

  Serial.println("Dallas Temperature IC Control Library Demo");
 
  sensors.begin();


  pinMode(latchPin, OUTPUT);  //移位输出
  pinMode(clockPin, OUTPUT); //时钟输出
  pinMode(dataPin, OUTPUT); //数码管串口输出
  pinMode(8, OUTPUT); //片选1输出
  pinMode(9, OUTPUT); //片选2输出
  pinMode(10, OUTPUT); //片选3输出
  pinMode(11, OUTPUT); //片选4输出
  Serial.begin(9600); //树莓派串口传输速率
//  pinMode(2, INPUT);  //温度传感器采集口
}

 
// 0-9 10个显示数字与小数点（DP）
byte seven_seg_digits[11] =
	             {		B00000011,  // = 0
                              B10011111,  // = 1
                              B00100101,  // = 2
                              B00001101,  // = 3
                              B10011001,  // = 4
                              B01001001,  // = 5
                              B01000001,  // = 6
                              B00011111,  // = 7
                              B00000001,  // = 8
                              B00001001,   // = 9
		              B11111110
                             };


void sevenSegWrite(byte digit, int b) {
  
  digitalWrite(8, HIGH);  //全暗
  digitalWrite(9, HIGH);
  digitalWrite(10, HIGH);
  digitalWrite(11, HIGH);
  
  digitalWrite(latchPin, LOW); //移位低
  shiftOut(dataPin, clockPin, LSBFIRST, seven_seg_digits[digit]); //移位  
  digitalWrite(latchPin, HIGH); //移位高，完成写入
  digitalWrite(b, LOW); //点亮b（片选）
}

void shiftOut(uint8_t dataPin, uint8_t clockPin, uint8_t bitOrder, uint8_t val)
{
      uint8_t i;
      for (i = 0; i < 8; i++) 
      {
                  if (bitOrder == LSBFIRST)
                             digitalWrite(dataPin, !!(val & (1 << i)));
                  else     
                             digitalWrite(dataPin, !!(val & (1 << (7 - i))));
                  digitalWrite(clockPin, HIGH);
                  digitalWrite(clockPin, LOW);           
      }
}
void showNum(int num) {
  int b = 11; //数码管移位操作次数-实际以数据位数决定
  while(1) {
    sevenSegWrite(num % 10, b); //将num逐位写到b位数码管
    b -= 1;  //数码管移一位
    num /= 10;

    if(b==7) {
      break;
    }
  }
}



void loop(void)
{ 
    int num = 0, i = 0;
    while(i<4)
    {
      if (Serial.available()) 
         number = Serial.read() - 48; //读取串口（来自树莓派）
      num = num * 10 + number;
      i++;
    }
    Serial.print("time is ");
    Serial.print(num);
  //Serial.print("character recieved: "); //送回串口接收到的字符
//  Serial.println(num, DEC);
   showNum(num);
   num = 0;
delay(1000);
  // Serial.print("Requesting temperatures...");
  sensors.requestTemperatures(); // 发送命令获取温度
  //Serial.println("DONE");
   
 Serial.print("Temperature for the device 1 (index 0) is: ");
 Serial.println(sensors.getTempCByIndex(0));  
showNum(sensors.getTempCByIndex(0)*100);
delay(1000);

}

