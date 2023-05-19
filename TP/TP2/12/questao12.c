#include <stdio.h>  // file, printf, scanf...
#include <string.h> // func string
#include <stdlib.h> // inclui malloc
#include <stdbool.h> // inclui bool
#include <locale.h>


struct Personagem{
    char *name;
    int height; // ponteiro somente para string
    float weigth;
    char *colorHair;
    char *colorSkin;
    char *colorEye;
    char *birthYear;
    char *gender;
    char *homeWorld;
};

struct Personagem person[1000];

int indice = 0;
int indiceLista = 0, mov = 0;


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
bool ehFim(char line[]);
void printPerson(struct Personagem person);
struct Personagem readPerson(char line[]);
void printLista();
void insertStart(char name[]);
void insertPos(char name[], int pos);
void insertEnd(char name[]);
char *removeStart();
char *removePos(int pos);
char *removeEnd();
void swap(int menor, int i);
void shellSort();
void auxInsert(int cor, int h);


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

bool ehFim(char line[]){
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

    tmp = name(line);
    returnPerson.name = malloc(sizeof(char)*strlen(tmp));
    strcpy(returnPerson.name, tmp);

    returnPerson.height = height(line);
    returnPerson.weigth = weight(line);
  
    tmp = colorHair(line);
    returnPerson.colorHair = (char*)malloc(sizeof(char)*strlen(tmp));
    strcpy(returnPerson.colorHair,tmp);
   
    tmp = skinColor(line);
    returnPerson.colorSkin = (char*)malloc(sizeof(char)*strlen(tmp));
    strcpy(returnPerson.colorSkin, tmp);
  
    tmp = eyeColor(line);
    returnPerson.colorEye = malloc(sizeof(char)*(strlen(tmp)));
    strcpy(returnPerson.colorEye,tmp);
  
    tmp = birthYear(line);
    returnPerson.birthYear = malloc(sizeof(char)*strlen(tmp));
    strcpy(returnPerson.birthYear, tmp);
   
    tmp = gender(line);
    returnPerson.gender = malloc(sizeof(char)*strlen(tmp));
    strcpy(returnPerson.gender,tmp);
   
    tmp = homeWorld(line);
    returnPerson.homeWorld = malloc(sizeof(char)*strlen(tmp));
    strcpy(returnPerson.homeWorld,tmp);

    return returnPerson;
}

struct Personagem clone(struct Personagem clonar){
    struct Personagem clonado;
    clonado = clonar;
    return clonado;
}


void printLista(){
    for(int i = 0; i < indiceLista;i++){
        printPerson(person[i]);
    }
}


void insertStart(char name[]){
    for(int i = indiceLista; i > 0; i--){
        person[i] = person[i-1];
    }
    person[0] = readPerson(name);
    indiceLista++;
}

void insertPos(char name[], int pos){
    for(int i = indiceLista; i > pos; i--){
        person[i] = person[i-1];
    }
    person[pos] = readPerson(name);
    indiceLista++;
}

void insertEnd(char name[]){
    person[indiceLista++] = readPerson(name);
}


char *removeStart(){
    struct Personagem tmp = person[0];
    indiceLista--;
    for(int i = 0; i < indiceLista; i++){
        person[i] = person[i+1];
    }
    return tmp.name;
}

char *removePos(int pos){
    struct Personagem tmp = person[pos];
    indiceLista--;
    for(int i = pos; i < indiceLista ; i++){
        person[i] = person[i+1];
    }
    return tmp.name;
}

char *removeEnd(){
    struct Personagem tmp = person[--indiceLista];
    return tmp.name;
}

void swap(int menor, int i){
    struct Personagem tmp = person[menor];
    person[menor] = person[i];
    person[i] = tmp;
    mov+=3;
}

void shellSort(){
    int h = 1;
    do{ h = (h*3)*h; }while(h<(indiceLista-1));
    do{
        h /= 3;
        for(int cor = 0; cor < h; cor++){
            auxInsert(cor,h);
        }
    }while(h!=1);
}

void auxInsert(int cor, int h){
    for(int i = (h+cor); i < indiceLista;i+=h){

        float tmp = person[i].weigth;
        struct Personagem temp = person[i];
        int j = i-h;
        while(j >= 0 && (person[j].weigth >= tmp)){
            person[j+h] = person[j];
            j-=h;
        }
        person[j+h] = temp;
    }
}

void insertionSortName(){
    for(int i = 0; i < indiceLista;i++){
        struct Personagem tmp = person[i];
        int j = i-1;
        while(j>=0 && strcmp(person[j].name,tmp.name) > 0 && person[j].weigth==tmp.weigth){
            person[j+1] = person[j];
            j--;
        }
    person[j+1] = tmp;
    }
}

int main(){
    FILE *arq; 
    char line[1000], *tmp;
    char auxLine[1000];

    strcpy(auxLine, "");
    scanf(" %s", line);
    strcat(auxLine,line);

    while(!ehFim(line)){
        arq = fopen(auxLine, "r");
        fscanf(arq, " %[^\n]s", line);  
        insertEnd(line);
        scanf(" %s", line);
        strcpy(auxLine, "");
        strcat(auxLine,line);
        indice = 0;
    }

    shellSort();
    insertionSortName();
    printLista();
    fclose(arq);
}

