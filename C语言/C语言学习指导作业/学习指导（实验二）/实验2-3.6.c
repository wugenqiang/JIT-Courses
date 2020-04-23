#include <stdio.h>
void fun(int array[3][3])
{
         int i,j,temp;
         for(i=0;i<3;i++)
         {
             for(j=0;j<3;j++)
             {
                 temp=array[i][j];
                 array[i][j]=array[j][i];
                 array[i][j]=temp;
             }
         }
}

void main()
{
    int i,j,array[3][3];
    printf("please input 3*3 numbers:\n");
    for(i=0;i<3;i++)
    {
        for(j=0;j<3;j++)
        {
            scanf("%d",&array[i][j]);
        }
    }
    fun(array);
    for(j=0;j<3;j++)
    {
        for(i=0;i<3;i++)
        {
            printf("%4d",array[i][j]);

        }
        printf("\n");
    }
}
