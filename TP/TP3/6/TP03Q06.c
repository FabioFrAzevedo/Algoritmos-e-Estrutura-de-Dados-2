#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

typedef struct Character{
    char name[100];
    int height;
    double weight;
    char colorHair[100];
    char skinColor[100];
    char eyeColor[100];
    char yearOfBirth[100];
    char gender[10];
    char homeworld[100];

} Character;

Character *cloneCharacter(Character *original){
    Character *clone = (Character *)malloc(sizeof(Character));
    if (clone == NULL){
        printf("Erro: falha ao alocar memória para clone.\n");
        return NULL;
    }

    clone->name, original->name;
    clone->height, original->height;
    clone->weight = original->weight;
    clone->colorHair, original->colorHair;
    clone->skinColor, original->skinColor;
    clone->eyeColor, original->eyeColor;
    clone->yearOfBirth, original->yearOfBirth;
    clone->gender, original->gender;
    clone->homeworld, original->homeworld;

    return clone;
}

void setName(Character *p, char *name){
    strcpy(p->name, name);
    }

char *getName(Character *p){
    return p->name;
}

void setHeight(Character *p, char *height){
    if (strstr(height, "unknown")){
        p->height = 0;
    }
    else{
        p->height = atoi(height);
    }
}
int getHeight(Character *p){
    return p->height;
}

void setWeight(Character *p, char *weight){
    if (strstr(weight, "unknown")){
        p->weight = 0;
    }
    else {
        p->weight = atof(weight);
    }
}

int getWeight(Character *p){
    return (int)p->weight;
}

void setColorHair(Character *p, char *colorHair){
    strcpy(p->colorHair, colorHair);
}

char *getColorHair(Character *p){
    return p->colorHair;
}

void setSkinColor(Character *p, char *skinColor){
    strcpy(p->skinColor, skinColor);
}

char *getSkinColor(Character *p){
    return p->skinColor;
}

void setEyeColor(Character *p, char *eyeColor){
    strcpy(p->eyeColor, eyeColor);
}

char *getEyeColor(Character *p){
    return p->eyeColor;
}

void setYearOfBirth(Character *p, char *yearOfBirth){
    strcpy(p->yearOfBirth, yearOfBirth);
}

char *getYearOfBirth(Character *p){
    return p->yearOfBirth;
}

void setGender(Character *p, char *gender){
    strcpy(p->gender, gender);
}

char *getGender(Character *p){
    return p->gender;
}

void setHomeworld(Character *p, char *homeworld){
    strcpy(p->homeworld, homeworld);
}

char *getHomeworld(Character *p){
    return p->homeworld;
}

void str_replace(char *str, const char *from, const char *to){
    int len_from = strlen(from);

    char *p;
    while ((p = strstr(str, from)) != NULL) {
        char buf[1024];
        strcpy(buf, p + len_from);

        *p = '\0';
        strcat(str, to);
        strcat(str, buf);
    }
}

void read_line(Character *p, char *line){

    str_replace(line, "{", "");
    str_replace(line, "}", "");
    str_replace(line, "': ", "");

    char *token;
    token = strtok(line, "[");

    char *token2;
    char attribute[100][100];
    int indexCount = 0;
    token2 = strtok(line, "'");
    while (token2 != NULL){
        strcpy(attribute[indexCount++], token2);
        token2 = strtok(NULL, "'");
    }


    setName(p, attribute[1]);
    setHeight(p, attribute[4]);
    setWeight(p, attribute[7]);
    setColorHair(p, attribute[10]);
    setSkinColor(p, attribute[13]);
    setEyeColor(p, attribute[16]);
    setYearOfBirth(p, attribute[19]);
    setGender(p, attribute[22]);
    setHomeworld(p, attribute[25]);
}

void print_character(Character p){
    printf(" ## %s ## ", p.name);
    printf("%d ## ", p.height);
    printf("%g ## ", p.weight);
    printf("%s ## ", p.colorHair);
    printf("%s ## ", p.skinColor);
    printf("%s ## ", p.eyeColor);
    printf("%s ## ", p.yearOfBirth);
    printf("%s ## ", p.gender);
    printf("%s ## ", p.homeworld);
    printf("\n");
}

bool isFim(char *s){
    if (strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M'){
        return true;
    }
    else{
        return false;
    }
}

typedef struct Cell{
    Character element;
    struct Cell *next;
} Cell;

int numberOfElements = 0;

Cell *newCell(Character *character){
    Cell *new = (Cell *)malloc(sizeof(Cell));
    new->element = *character;
    new->next = NULL;
    return new;
}

Cell *first, *last;

void start(){
    Character *new = (Character *)malloc(sizeof(Character));
    first = newCell(new);
    last = first;
}

void insert(Character *character){
    last->next = newCell(character);
    last = last->next;
    numberOfElements++;
}

Character removeLast(void)
{
    if (first == last)
    {
        printf("ERRO!");
    }
    Cell *i;
    for (i = first; i->next != last; i = i->next)
        ;
    Character element = last->element;
    last = i;
    free(last->next);
    i = last->next = NULL;
    numberOfElements--;
    return element;
}

void show()
{
    Cell *i;
    int j = 0;
    for (i = first->next; i != NULL; i = i->next)
    {
        printf("[%d] ", j);
        print_character(i->element);
        j++;
    }
}

int main(void)
{
    FILE *file;
    char json_txt[100][100];
    int cont = 0;
    start();
    do
    {
        Character p;
        fgets(json_txt[cont], 100, stdin);
        json_txt[cont][strcspn(json_txt[cont], "\n")] = '\0';
        if (isFim(json_txt[cont]) == true)
        {
            break;
        }
        file = fopen(json_txt[cont], "r");
        if (file != NULL)
        {
            char line[1000];
            fgets(line, 1000, file);
            read_line(&p, line);
            insert(&p);
            fclose(file);
        }
        else
        {
            printf("Failed to open file: %s\n", json_txt[cont]);
        }
    } while (isFim(json_txt[cont++]) == false);

    int n = 0;
    scanf("%d", &n);
    char json_address[100][100];
    for (int i = 0; i <= n; i++)
    {
        Character p1;
        fgets(json_address[i], 100, stdin);
        json_address[i][strcspn(json_address[i], "\n")] = '\0';

        char *token = strtok(json_address[i], " ");

        if (strcmp(json_address[i], "I") == 0)
        {
            token = strtok(NULL, " ");
            char line[1000];
            file = fopen(token, "r");
            fgets(line, 1000, file);
            read_line(&p1, line);
            insert(&p1);
        }
        else if (strcmp(json_address[i], "R") == 0)
        {
            printf("(R) %s\n", removeLast().name);
        }
    }
    show();
    return 0;
}