byte ledPin[ ] = {2, 3, 4, 5, 7, 8, 9, 10, 11};     //以LED引脚创建数组

int ledDelay(2500);    //变换灯之间的延时，你爱多少写多少（毫秒）

int dir = 1;

int currentLED = 0;

unsigned long changeTime;

void setup() {

    for (int x=0; x<9; x++)    //设置所有引脚为输出模式

    {

      pinMode(ledPin[x], OUTPUT);

    }

    changeTime = millis();

}

void loop()  

{       

  if((millis() - changeTime) > ledDelay)    //如果过了ledDelay毫秒，执行以下程序

  {

    changeLED();

    changeTime = millis();

  }

}

 

void changeLED() {  

  for (int x=0; x<9; x++) {   //关闭所有灯

    digitalWrite(ledPin[x], HIGH);

  }

digitalWrite(ledPin[currentLED], LOW);    //开一个灯

currentLED+=dir;

if (currentLED == 8) {dir = -1;}

if (currentLED == 0) {dir = 1;}     //让灯轮流亮，到底换方向

}

