int ledPin = 13;         //定义D13为LED正极口
void setup()            //只运行一次
{
     pinMode(ledPin, OUTPUT); // 设定数字IO口的模式，OUTPUT 为输出
}
void loop() //反复
{
      digitalWrite(ledPin, HIGH); // 设定PIN13 脚为HIGH = 4V
      delay(1000);                // 设定延时时间，1000 = 1 秒
      digitalWrite(ledPin, LOW); // 设定PIN13 脚为LOW = 0V
      delay(1000);               //设定延时时间
}

