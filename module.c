#include <stdio.h>
#include <stdlib.h>
#include "module.h"

void print(studentBase *base, int index)
{
    int i;
    int k;
    if (base != NULL)
    {
        for(i = 1; i <= index; i++)
        {
            int j = 0;
            printf("Student %d\n",i);
            printf("Name:");
            while(base[i-1].name[j] != '\0')
            {
                printf("%c", base[i-1].name[j]);
                j++;
            }
            printf("\n");
            printf("Age:%d\n", base[i-1].age);
            printf("Degree:%d\n", base[i-1].degree);
            printf("Section:%d\n", base[i-1].section);
            printf("\n---------------------------------------------\n");
        }
    }
    else
    {
        printf("Base is empty:\n");
    }
}
