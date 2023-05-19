#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

typedef struct Personagem{ //atributos do personagem
	char nome[100];
	int altura;
	double peso;
	char corDoCabelo[100];
	char corDaPele[100];
	char corDosOlhos[100];
	char anoNascimento[100];
	char genero[10];
	char homeworld[100];

} Personagem;

void setNome(Personagem *p, char *nome){ // set nome
	strcpy(p->nome, nome);
}
void setAltura(Personagem *p, char *altura){ // set altura
	if (strstr(altura, "unknown")){
		p->altura = 0;
	}else{
		p->altura = atoi(altura);
	}
}
void setPeso(Personagem *p, char *peso){ //set Peso
	if (strstr(peso, "unknown")){
		p->peso = 0;
	}else{
		p->peso = atof(peso);
	}
}
void setCorDoCabelo(Personagem *p, char *corDoCabelo){ // set cor do cabelo
	strcpy(p->corDoCabelo, corDoCabelo);
}
void setCorDaPele(Personagem *p, char *corDaPele){ //set cor da pele
	strcpy(p->corDaPele, corDaPele);
}
void setCorDosOlhos(Personagem *p, char *corDosOlhos){ //set cor dos olhos
	strcpy(p->corDosOlhos, corDosOlhos);
}
void setAnoNascimento(Personagem *p, char *anoNascimento){ //set ano nascimento
	strcpy(p->anoNascimento, anoNascimento);
}
void setGenero(Personagem *p, char *genero){ //set genero
	strcpy(p->genero, genero);
}
void setHomeworld(Personagem *p, char *homeworld){ //set homeworld
	strcpy(p->homeworld, homeworld);
}

void str_replace(char *str, const char *from, const char *to){ 
	int len_from = strlen(from);
	char *p;
	while ((p = strstr(str, from)) != NULL){
		char buf[1024];
		strcpy(buf, p + len_from);

		*p = '\0';
		strcat(str, to);
		strcat(str, buf);
	}
}

void leitura(Personagem *p, char *line){ //leitura
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

	setNome(p, attribute[1]);
	setAltura(p, attribute[4]);
	setPeso(p, attribute[7]);
	setCorDoCabelo(p, attribute[10]);
	setCorDaPele(p, attribute[13]);
	setCorDosOlhos(p, attribute[16]);
	setAnoNascimento(p, attribute[19]);
	setGenero(p, attribute[22]);
	setHomeworld(p, attribute[25]);
}

void print_character(Personagem *p){
	printf(" ## %s ## ", p->nome);
	printf("%d ## ", p->altura);
	printf("%g ## ", p->peso);
	printf("%s ## ", p->corDoCabelo);
	printf("%s ## ", p->corDaPele);
	printf("%s ## ", p->corDosOlhos);
	printf("%s ## ", p->anoNascimento);
	printf("%s ## ", p->genero);
	printf("%s ## ", p->homeworld);
	printf("\n");
}

bool isFim(char *s){ //fim
	if (strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M'){
		return true;
	}else{
		return false;
	}
}

int main(void){
	FILE *file;
	char json_txt[100][100];
	int count = 0;
	do{
		fgets(json_txt[count], 100, stdin);
		json_txt[count][strcspn(json_txt[count], "\n")] = '\0';
	} while (isFim(json_txt[count++]) == false);
	count--;

	char line[100][1000];
	Personagem p[100];

	for (int i = 0; i < count; i++){
		file = fopen(json_txt[i], "r");
		if (file != NULL){
			fgets(line[i], 1000, file);
			leitura(&p[i], line[i]);
			print_character(&p[i]);

			fclose(file);
		}else{
			printf("Falha ao abrir o arquivo: %s\n", json_txt[i]);
		}
	}
	return 0;
}
