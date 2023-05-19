#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

typedef struct Personagem{
    char nome[40];
    int altura;
    double peso;
    char corDoCabelo[40];
    char corDaPele[40];
    char corDosOlhos[40];
    char anoNascimento[40];
    char genero[40];
    char homeworld[40];
} Personagem;

double fmod(double x, double y){
    return x - (int)(x / y) * y;
}


void leituraAtributo(char atributo[], char descricaoPersonagem[], int index){
    int i = 0;
    while (descricaoPersonagem[index] != '\''){
        atributo[i] = descricaoPersonagem[index];

        i++;
        index++;
    }

    atributo[i] = '\0';
}

bool ehFim(char palavra[]){
    bool teste = false;
    if (palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M'){
        teste = true;
    }

    return teste;
}

Personagem montaPersonagem(char caminhoArquivo[]){
    FILE *leitura = fopen(caminhoArquivo, "r");
    char descricaoPersonagem[1000];
    fscanf(leitura, " %[^\n]s", descricaoPersonagem);
    Personagem personagem; 
    int contador = 0;
    for (int i = 0; i < strlen(descricaoPersonagem); i++){
        if (descricaoPersonagem[i] == ':'){
            char atributo[50];
            contador++;

            switch (contador){
            case 1:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.nome, atributo);
                break;
            case 2:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                personagem.altura = atoi(atributo);
                break;
            case 3:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                for (int i = 0; i < strlen(atributo); i++){
                    if (atributo[i] == ',')
                    {
                        atributo[i] = atributo[i - 1];
                        atributo[i - 1] = '0';
                    }
                }
                personagem.peso = atof(atributo);
                break;
            case 4:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.corDoCabelo, atributo);
                break;
            case 5:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.corDaPele, atributo);
                break;
            case 6:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.corDosOlhos, atributo);
                break;
            case 7:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.anoNascimento, atributo);
                break;
            case 8:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.genero, atributo);
                break;
            case 9:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.homeworld, atributo);

                i = strlen(descricaoPersonagem); 
                break;
            default:
                break;
            }
        }
    }

    fclose(leitura);

    return personagem;
}

void trocaPersonagem(Personagem listaPersonagens[], int i, int j, int *ptrMov){
    Personagem personagemTemporario = listaPersonagens[i];
    listaPersonagens[i] = listaPersonagens[j];
    listaPersonagens[j] = personagemTemporario;

    *ptrMov += 3;
}


void construirHeap(Personagem listaPersonagens[], int tam, int *ptrComp, int *ptrMov){
    for (int i = tam; i > 1 && (listaPersonagens[i].altura > listaPersonagens[i / 2].altura); i /= 2){
        trocaPersonagem(listaPersonagens, i, i / 2, ptrMov);
        *ptrComp += 2;
    }
}

int getMaiorFilho(Personagem listaPersonagens[], int i, int tam, int *ptrComp){
    int filho;
    if (2 * i == tam || listaPersonagens[2 * i].altura > listaPersonagens[2 * i + 1].altura) {
        filho = 2 * i;
    }
    else{
        filho = 2 * i + 1;
    }
    *ptrComp += 2;

    return filho;
}

bool hasFilho(int i, int tam, int *ptrComp){
    *ptrComp += 1;

    return (i <= (tam / 2));
}

void reconstruirHeap(Personagem listaPersonagens[], int tam, int *ptrComp, int *ptrMov){
    int i = 1;
    while (hasFilho(i, tam, ptrComp) == true){
        int filho = getMaiorFilho(listaPersonagens, i, tam, ptrComp);
        if (listaPersonagens[i].altura < listaPersonagens[filho].altura){
            trocaPersonagem(listaPersonagens, i, filho, ptrMov);
            i = filho;
        }
        else {
            i = tam;
        }
        *ptrComp += 2;
    }
    *ptrComp += 1; 
}

void ordenaHeapsort(Personagem listaPersonagens[], int tamanhoVetor, int k, int *ptrComp, int *ptrMov){
    for (int tam = 2; tam <= k; tam++){
        construirHeap(listaPersonagens, tam, ptrComp, ptrMov);
        *ptrComp += 1;
    }

    for (int i = k + 1; i <= tamanhoVetor - 1; i++){
        if (listaPersonagens[i].altura < listaPersonagens[1].altura)
        {
            trocaPersonagem(listaPersonagens, i, 1, ptrMov);
            reconstruirHeap(listaPersonagens, k, ptrComp, ptrMov);
        }

        *ptrComp += 2;
    }


    int tam = k;
    while (tam > 1){
        *ptrComp += 1;

        trocaPersonagem(listaPersonagens, 1, tam--, ptrMov);
        reconstruirHeap(listaPersonagens, tam, ptrComp, ptrMov);
    }
}

void ordenaInsercao(Personagem listaPersonagens[], int tamanhoVetor, int *ptrComp, int *ptrMov){
    for (int i = 1; i < tamanhoVetor; i += 1)
    {
        Personagem personagemTemporario = listaPersonagens[i];
        int j = i - 1;
        while ((j >= 0) && ((listaPersonagens[j].altura == personagemTemporario.altura) && (strcmp(listaPersonagens[j].nome, personagemTemporario.nome) > 0)))
        {
            *ptrComp += 3;
            *ptrMov += 1;
            listaPersonagens[j + 1] = listaPersonagens[j];
            j -= 1;
        }

        *ptrComp += 1; 
        *ptrMov += 1;

        listaPersonagens[j + 1] = personagemTemporario;
    }

    *ptrComp += 1; 
}


void imprimir(Personagem listaPersonagens[], int k){
    for (int i = 1; i <= k; i++){
        printf(" ## %s", listaPersonagens[i].nome);
        printf(" ## %d", listaPersonagens[i].altura);
        if (fmod(listaPersonagens[i].peso, 1) == 0)
            printf(" ## %.0lf", listaPersonagens[i].peso);
        else
            printf(" ## %.1lf", listaPersonagens[i].peso);
        printf(" ## %s", listaPersonagens[i].corDoCabelo);
        printf(" ## %s", listaPersonagens[i].corDaPele);
        printf(" ## %s", listaPersonagens[i].corDosOlhos);
        printf(" ## %s", listaPersonagens[i].anoNascimento);
        printf(" ## %s", listaPersonagens[i].genero);
        printf(" ## %s", listaPersonagens[i].homeworld);
        printf(" ## \n");
    }
}

void criarLog(time_t inicio, int numeroComparacoes, int numeroMovimentacoes){
    float tempo;
    time_t final = time(NULL); // Marcar o final da execução

    tempo = difftime(final, inicio);
}

int main(void){
    char caminhoArquivo[200];
    int contadorTamanho = 1, numeroComparacoes = 0, numeroMovimentacoes = 0;
    int *ptrComp = &numeroComparacoes, *ptrMov = &numeroMovimentacoes;
    int k = 10;                 
    time_t inicio = time(NULL); 
    Personagem listaPersonagem[100];

    scanf(" %[^\n]s", caminhoArquivo);
    getchar();

    while (ehFim(caminhoArquivo) == false)
    {
        listaPersonagem[contadorTamanho] = montaPersonagem(caminhoArquivo);
        contadorTamanho += 1;

        scanf(" %[^\n]s", caminhoArquivo);
        getchar();
    }

    ordenaHeapsort(listaPersonagem, contadorTamanho, k, ptrComp, ptrMov);
    ordenaInsercao(listaPersonagem, contadorTamanho, ptrComp, ptrMov);
    imprimir(listaPersonagem, k); 
    criarLog(inicio, numeroComparacoes, numeroMovimentacoes);

    return 0;
}