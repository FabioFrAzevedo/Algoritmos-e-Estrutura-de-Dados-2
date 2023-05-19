#include <stdio.h>  
#include <string.h> 
#include <stdlib.h> 
#include <stdbool.h> 
#include <locale.h>

int indice = 0;
int indiceLista = 0;
struct Fila fila;

struct Personagem{
    char *name;
    int height;
    float weigth;
    char *colorHair;
    char *colorSkin;
    char *colorEye;
    char *birthYear;
    char *gender;
    char *homeWorld;
};

struct Celula{
    struct Personagem registro;
    struct Celula *prox;
};

struct Fila{
    struct Celula primeiro;
    struct Celula *ultimo;
    int quant;
};


char *subString(char line[], int pos, int pos2);
char *isComma(char line[]);
char *name(char line[]);
int height(char line[]);
float weight(char line[]);
char *colorHair(char line[]);
char *skinColor(char line[]);
char *eyeColor(char line[]);
char *birthYear(char line[]);
char *gender(char line[]);
char *homeWorld(char line[]);
bool isFIM(char line[]);
void printPerson(struct Personagem person);
struct Personagem readPerson(char line[]);
struct Personagem clone(struct Personagem clonar);
void inserir(char line[]);
struct Personagem remover();
void printMedia();
void printElements();

char *subString(char line[], int pos, int pos2){
    char *str = (char*)malloc(((pos2-pos)+1)*sizeof(char));
    int j = 0;
    for(int i = 0; i <= pos2;i++){
        if(i >= pos){
            str[j] = line[i];
            j++;
        }
    }
    str[j] = '\0';
    return str;
}

char *isComma(char line[]){
    bool comma = 0;
    for(int j = 0; j < strlen(line); j++){
        if(line[j] == ',')
            comma = 1;
        
    }
    if(comma == 1){
        char *str = malloc(strlen(line)-2*sizeof(char));
        for(int i = 0; i < strlen(line)-1;i++){
            if(line[i] != ','){
                str[i] = line[i];
                str[strlen(line)] = '\0';

            }
        }
        return str;
    }
    return line; 
}

char *name(char line[]){
    char *str = (char*)malloc(100*(sizeof(char)));
    int pos, pos2;
    for(int i = indice; i < strlen(line)-1;i++){
        if(line[i] == 'n' && line[i+1] == 'a' && line[i+2] == 'm' && line[i+3] == 'e'){
            pos = i+8;
            for(int j = i+8;j < strlen(line)-1;j++){
                if(line[j+1] == '\''){
                    indice = j+2;
                    pos2 = j;
                    j = strlen(line);
                    i = strlen(line);
                }
            }
        }
    }
    str = subString(line,pos,pos2);
    return str;
}

int height(char line[]){
    char *str = (char*)malloc(100*(sizeof(char)));
    int pos, pos2;
    for(int i = indice; i < strlen(line)-1;i++){
        if(line[i] == 'h' && line[i+1] == 'e' && line[i+2] == 'i' && line[i+3] == 'g' && line[i+4] == 'h' && 
        line[i+5] == 't'){
            i = i+10;
            for(int j = i; j < strlen(line)-1;j++){
                if(line[j+1] == '\''){
                    indice = j+3;
                    pos2 = j;
                    pos = i;
                    j = strlen(line);
                    i = strlen(line);
                }
            }
        }
    }
    str = subString(line,pos,pos2);
    if(strcmp(str, "unknown") == 1){
        return 0;
    }
    return atoi(str);

}

float weight(char line[]){
    char *str = (char*)malloc(100*(sizeof(char)));
    int pos, pos2;
    for(int i = indice; i < strlen(line)-1; i++){
        if(line[i] == 'm' && line[i+1] == 'a' && line[i+2] == 's' && line[i+3] == 's'){
            i+=8;
            for(int j = i; j < strlen(line)-1;j++){
                if(line[j+1] == '\''){
                    indice = j+2;
                    pos = i;
                    pos2 = j;
                    j = strlen(line);
                    i = strlen(line);
                }
            }
            
        }
    }
    str = subString(line,pos,pos2);
    if(strcmp(str,"unknwon") == 1){
        return 0;
    }
    str = isComma(str); 
    return atof(str); 
}

char *colorHair(char line[]){
    char *str =(char*)malloc(100*(sizeof(char)));
    int pos, pos2;
    for(int i = indice; i < strlen(line)-1;i++){
        if(line[i] == 'h' && line[i+1] == 'a' && line[i+2] == 'i' && line[i+3] == 'r'){
            i += 14; 
            for(int j = i; i < strlen(line)-1; j++){
                if(line[j+1] == '\''){
                    indice = j+2;
                    pos = i;
                    pos2 = j;
                    i = strlen(line);
                    j = strlen(line);
                }
            }
        }
    }
    str = subString(line,pos,pos2);
    return str;
}

char *skinColor(char line[]){
    char *str = (char*)malloc(100*(sizeof(char)));
    int pos,pos2;
    for(int i = indice; i < strlen(line)-1; i++){
        if(line[i] == 's' && line[i+1] == 'k' && line[i+2] == 'i' && line[i+3] == 'n'){
            i += 14;
            pos = i;
            for(int j = i; j < strlen(line)-1; j++){
                if(line[j+1] == '\''){
                    indice = j+2;
                    pos2 = j;
                    j = strlen(line);
                    i = j;
                }
                
            }
        }
    }
    str = subString(line,pos,pos2);
    return str;
}

char *eyeColor(char line[]){
    char *str = (char*)malloc(100*(sizeof(char)));
    int pos, pos2;
    for(int i = indice; i < strlen(line)-1; i++){
        if(line[i] == 'e' && line[i+1] == 'y' && line[i+2] == 'e'){
            i+=13;
            for(int j = i; j < strlen(line)-1; j++){
                if(line[j+1] == '\''){
                    indice = j+2;
                    pos = i;
                    pos2 = j;
                    i = strlen(line);
                    j = i;
                }
            }
        }
    }
    str = subString(line,pos,pos2);
    return str;
}

char *birthYear(char line[]){
    char *str = (char*)malloc(100*(sizeof(char)));
    int pos, pos2;
    for(int i = indice; i < strlen(line)-1; i++){
        if(line[i] == 'b' && line[i+1] == 'i' && line[i+2] == 'r' && line[i+3] == 't' && line[i+4] == 'h'){
            i += 14;
            for(int j = i; j < strlen(line)-1;j++){
                if(line[j+1] == '\''){
                    pos = i;
                    pos2 = j;
                    indice = pos2+3;
                    j = strlen(line);
                    i = j;
                }
            }
        }
    }
    str = subString(line,pos,pos2);
    return str;
}

char *gender(char line[]){
    char *str = (char*)malloc(100*(sizeof(char)));
    int pos,pos2;
    for(int i = indice; i < strlen(line)-1; i++){
        if(line[i] == 'g' && line[i+1] == 'e' && line[i+2] == 'n' && line[i+3] == 'd' 
        && line[i+4] == 'e' && line[i+5] == 'r'){
        i+=10;
            for(int j = i; j < strlen(line)-1; j++){
                if(line[j+1] == '\''){
                    pos = i;
                    pos2 = j;
                    indice = pos2+3;
                    j = strlen(line);
                    i = j;
                }
            }
        }
    }
    str = subString(line,pos,pos2);
    return str;
}

char *homeWorld(char line[]){
    char *str = (char*)malloc(100*(sizeof(char)));
    int pos,pos2;
    for(int i = indice; i < strlen(line)-1; i++){
        if(line[i] == 'h' && line[i+1] == 'o' && line[i+2] == 'm' && line[i+3] == 'e' && line[i+4] == 'w' && line[i+5] == 'o'
        && line[i+6] == 'r' && line[i+7] == 'l' && line[i+8] == 'd'){
            i+=13;
            for(int j = i; j < strlen(line)-1; j++){
                if(line[j+1] == '\''){
                pos = i;
                pos2 = j;
                indice = j+2;
                j = strlen(line);
                i = j;
                }
            }
        }
    }
    str = subString(line,pos,pos2);
    return str;
}

bool isFIM(char line[]){
    if(strlen(line) == 3 && line[0] == 'F' && line[1] == 'I' && line[2] == 'M')
        return true;
    return false;
}

void printPerson(struct Personagem person){
    printf("## %s ## %d ## %g ## %s ## %s ## %s ## %s ## %s ## %s ##\n",
    person.name, person.height, person.weigth, person.colorHair, person.colorSkin, person.colorEye,
    person.birthYear, person.gender, person.homeWorld);
}

struct Personagem readPerson(char line[]){
    struct Personagem returnPerson;
    char *tmp;

    //name
    tmp = name(line);
    returnPerson.name = malloc(sizeof(char)*strlen(tmp));
    strcpy(returnPerson.name, tmp);
    // heigth && weight
    returnPerson.height = height(line);
    returnPerson.weigth = weight(line);
    //Hair
    tmp = colorHair(line);
    returnPerson.colorHair = (char*)malloc(sizeof(char)*strlen(tmp));
    strcpy(returnPerson.colorHair,tmp);
    //skin
    tmp = skinColor(line);
    returnPerson.colorSkin = (char*)malloc(sizeof(char)*strlen(tmp));
    strcpy(returnPerson.colorSkin, tmp);
    //eye
    tmp = eyeColor(line);
    returnPerson.colorEye = malloc(sizeof(char)*(strlen(tmp)));
    strcpy(returnPerson.colorEye,tmp);
    //birthyear
    tmp = birthYear(line);
    returnPerson.birthYear = malloc(sizeof(char)*strlen(tmp));
    strcpy(returnPerson.birthYear, tmp);
    //gender
    tmp = gender(line);
    returnPerson.gender = malloc(sizeof(char)*strlen(tmp));
    strcpy(returnPerson.gender,tmp);
    //homeworld
    tmp = homeWorld(line);
    returnPerson.homeWorld = malloc(sizeof(char)*strlen(tmp));
    strcpy(returnPerson.homeWorld,tmp);
    
    indice = 0;
    return returnPerson;
}

struct Personagem clone(struct Personagem clonar){
    struct Personagem clonado;
    clonado = clonar;
    return clonado;
}

struct Celula *alocar(char line[]){
    struct Celula *celula = (struct Celula*) malloc(sizeof(struct Celula)*1);
    celula->registro = readPerson(line);
    celula->prox = NULL;
    return celula;
}

void inserir(char line[]){
    if(fila.quant == 5)
        remover();
        
    fila.ultimo->prox = alocar(line);
    fila.ultimo = fila.ultimo->prox;

    fila.quant++;

    printMedia();

}

struct Personagem remover(){
    if(fila.ultimo == &fila.primeiro)
        printf("Erro remover\n");
    
    struct Celula *tmp = fila.primeiro.prox;
    struct Personagem retorno = tmp->registro;

    fila.primeiro.prox = tmp->prox;  
    fila.quant--;

    return retorno;
}

void printElements(){
    struct Celula *cell = &fila.primeiro;
    while(cell != fila.ultimo){
        cell = cell->prox;
        printf("%d\n", cell->registro.height);
    }
}

void printMedia(){
    struct Celula *tmp = fila.primeiro.prox;
    double m = 0.0;
    int soma = 0;
    for(int i = 0; i < fila.quant; i++){
        soma+=tmp->registro.height;
        tmp = tmp->prox;
    }

    m = (double)soma/(double)fila.quant;
    if( (int)(m*10) % 10 >= 5){
        printf("%d\n", soma/fila.quant+1);
    }else{
        printf("%d\n", soma/fila.quant);
    }
    
}

char *corta(char a[]){
    int count = 0;
    char *retorno = malloc(sizeof(char)*strlen(a));
    for(int i = 0; i < strlen(a);i++){
        if(i >= 2)
            retorno[count++] = a[i];
    }
    retorno[count] = '\0';
    return retorno;
}

int main(){
    FILE *arq; 
    char line[1000], *tmp;
    char auxLine[1000];

    strcpy(auxLine, "");
    scanf(" %s", line);
    strcat(auxLine,line);

    fila.ultimo = &fila.primeiro;
    fila.quant = 0;

    while(!isFIM(line)){
        arq = fopen(auxLine, "r");
        fscanf(arq, " %[^\n]s", line);  

        inserir(line);


        scanf(" %s", line);
        strcpy(auxLine, "");
        strcat(auxLine,line);
    }   
    
    int quant;
    
    scanf("%d", &quant);

    for(int i = 0; i < quant; i++){

        scanf(" %[^\n]s", line);

        if(line[0] == 'I'){

            tmp = corta(line);
            arq = fopen(tmp, "r");
            fscanf(arq," %[^\n]s", line);
            inserir(line);
            
            strcpy(line,"");
            tmp = NULL;

        }else{
            printf("(R) %s\n", remover().name);
        }
    }
    fclose(arq);
}   

