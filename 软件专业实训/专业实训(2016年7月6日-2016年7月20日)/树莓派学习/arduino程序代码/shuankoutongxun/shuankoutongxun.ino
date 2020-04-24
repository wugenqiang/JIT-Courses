void setup() {
  
  Serial.begin(9600);         //使用9600速率进行串口通讯
}

void loop() {

  int n = analogRead(8);    //读取A0口的电压值

  float vol = n * (5.0 / 1023.0*100);   //使用浮点数存储温度数据，温度数据由电压值换算得到

  Serial.println(vol);                   //串口输出温度数据
  delay(2000);                           //等待2秒，控制刷新速度
}
