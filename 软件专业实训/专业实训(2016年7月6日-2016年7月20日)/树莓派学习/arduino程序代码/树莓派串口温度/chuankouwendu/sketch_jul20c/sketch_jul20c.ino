#define pinSound A1
#define pinLight A2
#define pinLed 11
boolean ledState = LOW; 
int Sound=0;
int Light=0;
void setup() {
  pinMode(pinSound,INPUT);
  pinMode(pinLight,INPUT);
  pinMode(pinLed,OUTPUT);
  Serial.begin(9600);
}
void loop() {
  Light=analogRead(pinLight);
  Sound=analogRead(pinSound);
  Serial.print("a");
  Serial.print(Sound);
  Serial.print("b");
  Serial.print(Light);
  Serial.println();
  delay(500);
  
if(Sound>10&&ledState==LOW&&Light<10)
{
  digitalWrite(pinLed, HIGH);
Serial.print("c1");
  ledState=!ledState;
  }
  else if(ledState==HIGH&& Sound>10)
  {
    digitalWrite(pinLed, LOW);
Serial.print("c2");
    ledState=!ledState;
    }
  
}  
