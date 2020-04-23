#include  <conio.h>
#include  <stdio.h>
#include  <string.h>
void fun (char  s[], char  t[])
{
  int   i, d;
  d =strlen(s);
  for (i = 0; i<d; i++)
       t[i] = s[d - 1 - i ];
    for (i = 0; i<d; i++)
       t[ d + i ] = s[i];
    t[2*d] = '\0';
}
main()
{
  char   s[100], t[100];
  printf("\nPlease enter string S:");
  scanf("%s", s);
  fun(s,t);
    printf("\nThe result is: %s\n", t);
}
