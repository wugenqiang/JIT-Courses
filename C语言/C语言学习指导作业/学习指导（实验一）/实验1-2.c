#include <stdio.h>
main()
{ char mark='A';
  switch(mark)
  { case  'A':
     case  'B':
     case  'C': printf(">=60\n");break;
     case  'D': printf("<60\n");break;
     default:  printf("Error\n");
    }
  }
