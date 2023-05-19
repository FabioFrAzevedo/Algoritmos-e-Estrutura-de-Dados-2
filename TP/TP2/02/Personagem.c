#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Definição da classe Personagem
typedef struct {
    char nome[100];
    int altura;
    double peso;
    char corDoCabelo[100];
    char codDaPele[100];
    char corDosOlhos[100];
    char anoNascimento[100];
    char genero[100];
    char homeworld[100];
} Personagem;

// Protótipos dos métodos da classe Personagem
Personagem* criarPersonagem(char* nome, int altura, double peso, char* corDoCabelo, char* codDaPele, char* corDosOlhos, char* anoNascimento, char* genero, char* homeworld);
Personagem* clonePersonagem(Personagem* p);
void imprimirPersonagem(Personagem* p);
void lerPersonagem(Personagem* p);

// Implementação dos métodos da classe Personagem
Personagem* criarPersonagem(char* nome, int altura, double peso, char* corDoCabelo, char* codDaPele, char* corDosOlhos, char* anoNascimento, char* genero, char* homeworld) {
    Personagem* p = (Personagem*) malloc(sizeof(Personagem));
    strcpy(p->nome, nome);
    p->altura = altura;
    p->peso = peso;
    strcpy(p->corDoCabelo, corDoCabelo);
    strcpy(p->codDaPele, codDaPele);
    strcpy(p->corDosOlhos, corDosOlhos);
    strcpy(p->anoNascimento, anoNascimento);
    strcpy(p->genero, genero);
    strcpy(p->homeworld, homeworld);
    return p;
}

Personagem* clonePersonagem(Personagem* p) {
    return criarPersonagem(p->nome, p->altura, p->peso, p->corDoCabelo, p->codDaPele, p->corDosOlhos, p->anoNascimento, p->genero, p->homeworld);
}

void imprimirPersonagem(Personagem* p) {
    printf("Nome: %s\n", p->nome);
    printf("Altura: %d\n", p->altura);
    printf("Peso: %.2lf\n", p->peso);
    printf("Cor do cabelo: %s\n", p->corDoCabelo);
    printf("Código da pele: %s\n", p->codDaPele);
    printf("Cor dos olhos: %s\n", p->corDosOlhos);
    printf("Ano de nascimento: %s\n", p->anoNascimento);
    printf("Gênero: %s\n", p->genero);
    printf("Planeta natal: %s\n", p->homeworld);
}

void lerPersonagem(Personagem* p) {
    printf("Digite o nome: ");
    scanf("%s", p->nome);
    printf("Digite a altura: ");
    scanf("%d", &p->altura);
    printf("Digite o peso: ");
    scanf("%lf", &p->peso);
    printf("Digite a cor do cabelo: ");
    scanf("%s", p->corDoCabelo);
    printf("Digite o código da pele: ");
    scanf("%s", p->codDaPele);
    printf("Digite a cor dos olhos: ");
    scanf("%s", p->corDosOlhos);
    printf("Digite o ano de nascimento: ");
    scanf("%s" p->anoNascimento);

}
