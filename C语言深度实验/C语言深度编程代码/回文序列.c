#include <stdio.h>
int huiwen_1(int n)
{
	int m,s=0;
	m=n;
	while(m>0)
	{
		s=s*10+m%10;
		m=m/10;
	}
	return s;
}
int main()
{
	int n;
	printf("please enter a integer:\n");
	scanf("%d",&n);
	if(huiwen_1(n)==n)
		printf("%d is a integer of huiwen integers\n",n);
	else 
		printf("%d isn't a integer of huiwen integers\n",n);
	return 0;
}