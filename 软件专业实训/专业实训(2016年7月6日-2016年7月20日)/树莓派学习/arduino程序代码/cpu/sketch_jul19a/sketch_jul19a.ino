#include <DallasTemperature.h>
#include <OneWire.h>
byte number=0;
// 定义DS18B20数据口连接arduino的2号IO上


byte seven_seg_digits[11] ={
  B00000011,B10011111,B00100101,B00001101,B10011001,B01001001,B01000001,B00011111,B00000001,B00001001,B11111110};
int latchPin = 6;  //ST_CP移位
int clockPin = 5;  //SH_CP时钟
int dataPin = 4;  //DS数据串口
int temp=0;
int i=0;
int time[7];
void setup() {
   // 设置串口通信波特率
  Serial.begin(9600);
  Serial.println("Dallas Temperature IC Control Library Demo");
 


  pinMode(latchPin, OUTPUT); //移位输出
  pinMode(clockPin, OUTPUT); //时钟输出 
  pinMode(dataPin, OUTPUT); //数码管串口输出 
  pinMode(8, OUTPUT); //片选1输出
  pinMode(9, OUTPUT); //片选2输出 
  pinMode(10, OUTPUT);//片选3输出
  pinMode(11, OUTPUT);//片选4输出  
 
}

void sevenSegWrite(byte digit, int b) {
   
  digitalWrite(8, HIGH);  //全暗  
  digitalWrite(9, HIGH);
  digitalWrite(10, HIGH); 
  digitalWrite(11, HIGH);
    
  digitalWrite(latchPin, LOW); //移位低
  shiftOut(dataPin, clockPin, LSBFIRST,seven_seg_digits[digit]); //移位  
  digitalWrite(latchPin, HIGH); //移位高，完成写入 
  digitalWrite(b, LOW); //点亮b（片选） 
}

void showNum(int num) {
   
    int b = 11; //数码管移位操作次数-实际以数据位数决定  
    while(1) {
    if(b==9)
   { sevenSegWrite(10,9);}
    sevenSegWrite(num % 10, b); //将num逐位写到b位数码管
    b -= 1;  //数码管移一位 
    if(num/10 > 0){ //数值移一位 
      num /= 10;
    }
       
      else {
      break;
    }
     
  }
}

void loop() {
  i=0;
  while(i<4){
    if (Serial.available()){
      time[i]=Serial.read()-'0';
      i++;
    } 
  }
  time[4]=time[0]*1000+time[1]*100+time[2]*10+time[3];
  //time[5]=time[0]*10+time[1];
  //time[6]=time[2]*10+time[3];
  //Serial.print("Temperatures is:");
  //Serial.print(time[5]);
  //Serial.print(":");
  //Serial.println(time[6]);
    for(i=0;i<1050;i++)
      showNum(time[4]);
      time[4]=0;
  delay(1000);
}

