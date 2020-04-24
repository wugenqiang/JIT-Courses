#include <DallasTemperature.h>
#include <OneWire.h>
// 定义DS18B20数据口连接arduino的2号IO上
#define ONE_WIRE_BUS 2 
// 初始连接在单总线上的单总线设备
OneWire oneWire(ONE_WIRE_BUS);
DallasTemperature sensors(&oneWire);
int temp;
void setup() {
    Serial.begin(9600);
   pinMode(2, INPUT);
   pinMode(4,INPUT);
}

void loop() {
  sensors.requestTemperatures(); // 发送命令获取温度
  Serial.println(sensors.getTempCByIndex(0));
  delay(100);
  //Serial.end();
  int n = digitalRead(4);
  if(n==HIGH)
  {  
       sensors.requestTemperatures(); // 发送命令获取温度
       Serial.println(sensors.getTempCByIndex(0));  
       delay(2000);
  }
}
