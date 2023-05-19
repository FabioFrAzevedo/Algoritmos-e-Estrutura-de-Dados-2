#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

typedef struct Personagem{
	char name[100];
	int height;
	double weight;
	char colorHair[100];
	char skinColor[100];
	char eyeColor[100];
	char yearOfBirth[100];
	char gender[10];
	char homeworld[100];

} Personagem;

Personagem *clonePersonagem(Personagem *original){
	Personagem *clone = (Personagem *)malloc(sizeof(Personagem));
	if (clone == NULL)
	{
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

void setName(Personagem *p, char *name){
	strcpy(p->name, name);
}

char *getName(Personagem *p){
	return p->name;
}

void setHeight(Personagem *p, char *height){
	if (strstr(height, "unknown"))
	{
		p->height = 0;
	}
	else
	{
		p->height = atoi(height);
	}
}
int getHeight(Personagem *p){
	return p->height;
}

void setWeight(Personagem *p, char *weight){
	if (strstr(weight, "unknown"))
	{
		p->weight = 0;
	}
	else
	{
		p->weight = atof(weight);
	}
}

int getWeight(Personagem *p){
	return (int)p->weight;
}

void setColorHair(Personagem *p, char *colorHair){
	strcpy(p->colorHair, colorHair);
}

char *getColorHair(Personagem *p){
	return p->colorHair;
}

void setSkinColor(Personagem *p, char *skinColor){
	strcpy(p->skinColor, skinColor);
}

char *getSkinColor(Personagem *p){
	return p->skinColor;
}

void setEyeColor(Personagem *p, char *eyeColor){
	strcpy(p->eyeColor, eyeColor);
}

char *getEyeColor(Personagem *p){
	return p->eyeColor;
}

void setYearOfBirth(Personagem *p, char *yearOfBirth){
	strcpy(p->yearOfBirth, yearOfBirth);
}

char *getYearOfBirth(Personagem *p){
	return p->yearOfBirth;
}

void setGender(Personagem *p, char *gender){
	strcpy(p->gender, gender);
}

char *getGender(Personagem *p){
	return p->gender;
}

void setHomeworld(Personagem *p, char *homeworld){
	strcpy(p->homeworld, homeworld);
}

char *getHomeworld(Personagem *p){
	return p->homeworld;
}

void str_replace(char *str, const char *from, const char *to){
	int len_from = strlen(from);

	char *p;
	while ((p = strstr(str, from)) != NULL)
	{
		char buf[1024];
		strcpy(buf, p + len_from);

		*p = '\0';
		strcat(str, to);
		strcat(str, buf);
	}
}

void read_line(Personagem *p, char *line){
	str_replace(line, "{", "");
	str_replace(line, "}", "");
	str_replace(line, "': ", "");

	char *token;
	token = strtok(line, "[");

	char *token2;
	char attribute[100][100];
	int indexCount = 0;
	token2 = strtok(line, "'");
	while (token2 != NULL)
	{
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


void print_character(Personagem p){
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
	if (strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M')
	{
		return true;
	}
	else
	{
		return false;
	}
}

typedef struct List{
	Personagem array[100];
	int n;
} List;

void start(List *list){
	list->n = 0;
}

void insert_start(Personagem *p, List *list){
	if (list->n >= sizeof(list->array))
	{
		printf("Erro!");
		exit(1);
	}

	for (int i = list->n; i > 0; i--)
	{
		list->array[i] = list->array[i - 1];
	}
	list->array[0] = *p;
	list->n++;
}

void insert_end(Personagem *p, List *list){
	if (list->n >= sizeof(list->array))
	{
		printf("Erro!");
		exit(1);
	}

	list->array[list->n] = *p;
	list->n++;
}

void insert(Personagem *p, List *list, int pos){
	if (list->n >= sizeof(list->array) || pos < 0 || pos > list->n)
	{
		printf("Erro!");
		exit(1);
	}

	for (int i = list->n; i > pos; i--)
	{
		list->array[i] = list->array[i - 1];
	}
	list->array[pos] = *p;
	list->n++;
}

Personagem remove_start(List *list){
	if (list->n == 0)
	{
		printf("Erro!");
		exit(1);
	}

	Personagem resp = list->array[0];

	for (int i = 0; i < list->n; i++)
	{
		list->array[i] = list->array[i + 1];
	}
	list->n--;
	return resp;
}


Personagem remove_end(List *list){
	if (list->n == 0)
	{
		printf("Erro!");
		exit(1);
	}

	return list->array[--list->n];
}

Personagem remove_list(int pos, List *list){
	if (list->n == 0 || pos < 0 || pos >= list->n)
	{
		printf("Erro!");
		exit(1);
	}
	Personagem resp = list->array[pos];
	list->n--;
	for (int i = pos; i < list->n; i++)
	{
		list->array[i] = list->array[i + 1];
	}
	return resp;
}

void print_list(List *list){
	for (int i = 0; i < list->n; i++)
	{
		printf("[%d", i);
		printf("] ");
		print_character(list->array[i]);
	}
}

int main(void){
	FILE *file;
	List list;
	start(&list);
	char json_txt[100][100];
	int cont = 0;
	do{
		Personagem p;
		fgets(json_txt[cont], 100, stdin);
		json_txt[cont][strcspn(json_txt[cont], "\n")] = '\0';
		if (isFim(json_txt[cont]) == true){
			break;
		}
		file = fopen(json_txt[cont], "r");
		if (file != NULL){
			char line[1000];
			fgets(line, 1000, file);
			read_line(&p, line);
			insert_end(&p, &list);
			fclose(file);
		}else{
			printf("Failed to open file: %s\n", json_txt[cont]);
		}
	} while (isFim(json_txt[cont++]) == false);

	int n = 0;
	scanf("%d", &n);
	char json_address[100][100];
	for (int i = 0; i <= n; i++){
		Personagem p1;
		fgets(json_address[i], 100, stdin);
		json_address[i][strcspn(json_address[i], "\n")] = '\0';

		char *token = strtok(json_address[i], " ");
		if (strcmp(json_address[i], "II") == 0){
			token = strtok(NULL, " ");
			char line[1000];
			file = fopen(token, "r");
			fgets(line, 1000, file);
			read_line(&p1, line);
			insert_start(&p1, &list);
		}
		else if (strcmp(json_address[i], "IF") == 0){
			token = strtok(NULL, " ");
			char line[1000];
			file = fopen(token, "r");
			fgets(line, 1000, file);
			read_line(&p1, line);
			insert_end(&p1, &list);
		}
		else if (strcmp(json_address[i], "I*") == 0){
			token = strtok(NULL, " ");
			int pos = atoi(token);
			token = strtok(NULL, " ");
			char line[1000];
			file = fopen(token, "r");
			fgets(line, 1000, file);
			read_line(&p1, line);
			insert(&p1, &list, pos);
		}
		else if (strcmp(json_address[i], "RI") == 0){
			printf("(R) %s\n", remove_start(&list).name);
		}
		else if (strcmp(json_address[i], "RF") == 0){
			printf("(R) %s\n", remove_end(&list).name);
		}
		else if (strcmp(json_address[i], "R*") == 0){
			token = strtok(NULL, " ");
			int pos = atoi(token);
			printf("(R) %s\n", remove_list(pos, &list).name);
		}
	}
	print_list(&list);
	return 0;
}