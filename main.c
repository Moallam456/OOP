#include <stdio.h>
#include <stdlib.h>
#include "module.h"

int main()
{
    int numberOfStudent;
    int i;
    studentBase B1[studentNumber];
    printf("Enter the number of students to be entered:\n");
    scanf("%d", &numberOfStudent);

    if (numberOfStudent <= studentNumber)
    {
        for (i = 1; i <=numberOfStudent; i++ )
        {
                int j = 0;
                printf("Student %d\n",i);
                printf("Name:\n");
                getchar();
                for (int j = 0; j < nameSize; j++)
                {
                    scanf("%c", &((B1+(i-1))->name[j]));
                    if((B1+(i-1))->name[j] == '\n')
                    {
                        break;
                    }
                }
                B1[i-1].name[j] = '\0';

                printf("Age:\n");
                getchar();
                scanf("%d", &((B1+(i-1))->age));

                printf("Degree:\n");
                getchar();
                scanf("%d", &((B1+(i-1))->degree));

                printf("Section:\n");
                getchar();
                scanf("%d", &((B1+(i-1))->section));


                printf("\n");
                printf("\n---------------------------------------------\n");
        }

    print(&B1, numberOfStudent);
    }
}
