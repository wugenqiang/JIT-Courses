#include <stdio.h>
#include <math.h>
int main()
{
	double m,n=1.0,a;
	printf("ÇëÊäÈëaµÄÖµ:\n");
	scanf("%lf",&a);
	while (fabs(n-m)>1e-6)
	{
		m=n;
		n=(m+a/m)/2;
	}
	printf("%7.5lf\n",n);
	return 0;
}