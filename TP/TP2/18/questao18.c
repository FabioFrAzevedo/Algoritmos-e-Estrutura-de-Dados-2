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

    while (descricaoPersonagem[index] != '\'')
    {
        atributo[i] = descricaoPersonagem[index];

        i++;
        index++;
    }

    atributo[i] = '\0';
}

bool ehFim(char palavra[]){
    bool teste = false;

    if (palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M')
    {
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

    for (int i = 0; i < strlen(descricaoPersonagem); i++)
    {
        if (descricaoPersonagem[i] == ':')
        {
            char atributo[50];
            contador++;

            switch (contador)
            {
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
                for (int i = 0; i < strlen(atributo); i++)
                {
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

int getMaximo(Personagem listaPersonagens[], int tamanhoVetor, int *ptrComp){
    int max = listaPersonagens[0].altura;
    for (int i = 1; i < tamanhoVetor; i++)
    {
        if (listaPersonagens[i].altura > max)
        {
            max = listaPersonagens[i].altura;
        }

        *ptrComp += 2;
    }
    *ptrComp += 1; 
    return max;
}

void countingSort(Personagem listaPersonagens[], int tamanhoVetor, int posicao, int *ptrComp, int *ptrMov){
    Personagem listaOrdenada[tamanhoVetor + 1];
    int max = (listaPersonagens[0].altura / posicao) % 10;

    for (int i = 1; i < tamanhoVetor; i++){
        if (((listaPersonagens[i].altura / posicao) % 10) > max)
            max = listaPersonagens[i].altura;

        *ptrComp += 2;
    }
    int count[max + 1];

    for (int i = 0; i < max; ++i){
        *ptrComp += 1;
        *ptrMov += 1;

        count[i] = 0;
    }

    for (int i = 0; i < tamanhoVetor; i++){
        *ptrComp += 1;
        *ptrMov += 1;

        count[(listaPersonagens[i].altura / posicao) % 10]++;
    }

    for (int i = 1; i < 10; i++){
        *ptrComp += 1;
        *ptrMov += 1;

        count[i] += count[i - 1];
    }

    for (int i = tamanhoVetor - 1; i >= 0; i--){
        listaOrdenada[count[(listaPersonagens[i].altura / posicao) % 10] - 1] = listaPersonagens[i];
        count[(listaPersonagens[i].altura / posicao) % 10]--;

        *ptrComp += 1;
        *ptrMov += 1;
    }

    for (int i = 0; i < tamanhoVetor; i++){
        *ptrComp += 1;
        *ptrMov += 1;

        listaPersonagens[i] = listaOrdenada[i];
    }
}

void ordenaPorRadixSort(Personagem listaPersonagens[], int tamanhoVetor, int *ptrComp, int *ptrMov){
    int max = getMaximo(listaPersonagens, tamanhoVetor, ptrComp);
    for (int posicao = 1; max / posicao > 0; posicao *= 10){
        *ptrComp += 1;

        countingSort(listaPersonagens, tamanhoVetor, posicao, ptrComp, ptrMov);
    }
}

void imprimirAtributos(Personagem listaPersonagens[], int tamanhoTotal){
    for (int i = 0; i < tamanhoTotal; i++)
    {
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
    time_t final = time(NULL); 
    tempo = difftime(final, inicio);

}

int main(void){
    char caminhoArquivo[100], nomePersonagem[100];
    int contadorTamanho = 0, numeroComparacoes = 0, numeroMovimentacoes = 0;
    int *ptrComp = &numeroComparacoes, *ptrMov = &numeroMovimentacoes;
    time_t inicio = time(NULL); 
    Personagem listaPersonagem[100];

    scanf(" %[^\n]s", caminhoArquivo);
    getchar();

    while (ehFim(caminhoArquivo) == false){
        listaPersonagem[contadorTamanho] = montaPersonagem(caminhoArquivo);
        contadorTamanho += 1;

        scanf(" %[^\n]s", caminhoArquivo);
        getchar();
    }

    ordenaPorRadixSort(listaPersonagem, contadorTamanho, ptrComp, ptrMov);

    imprimirAtributos(listaPersonagem, contadorTamanho); // Imprimir os resultados

    criarLog(inicio, numeroComparacoes, numeroMovimentacoes);

    return 0;
}