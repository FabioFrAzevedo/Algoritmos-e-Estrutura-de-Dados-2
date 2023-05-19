#include <stdio.h>
#include <stdlib.h>

int main(void){
    int n;
    scanf("%d", &n);

    FILE *arq;
    arq = fopen("arq.txt", "w+");

    for(int i = 0; i < n; i++){

        float r;
        scanf("%f", &r);

        if(i != n-1){
            fprintf(arq, "%g\n", r);
        }else{
            fprintf(arq, "%g", r);
        }
    }

    fseek(arq, 0, SEEK_END);

    for(int j = ftell(arq); j > 0; j--){
        float num;

        if(fgetc(arq) == '\n'){

            fseek(arq, j + 2, SEEK_SET);

            fscanf(arq, "%f", &num);
            printf("%g\n", num);
        }else if(j == 1){
            fseek(arq, j - 1, SEEK_SET);
            fscanf(arq, "%f", &num);
            printf("%g\n", num);
        }
        
        fseek(arq, j, SEEK_SET);
    }
    fclose(arq);
    return 0;
}