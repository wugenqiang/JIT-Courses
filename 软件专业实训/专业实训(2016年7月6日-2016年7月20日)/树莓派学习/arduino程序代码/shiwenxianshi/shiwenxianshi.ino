#include <DallasTemperature.h> 
DallasTemperature  tempSensor; 
void setup(void)   {  
     Serial.begin(9600);  
     tempSensor.begin(12);
   }  
   void loop(void)  
 {  
        switch(tempSensor.isValid())   
        {  
        case 1:  
            Serial.println("Invalid CRC");  
            tempSensor.reset();          
            return;         
            case 2:  
            Serial.println("Not a valid device");             
          tempSensor.reset();            
        return;      
      }  
  Serial.print(tempSensor.getTemperature()); 
  Serial.print("C");   
  Serial.println();
  } 
