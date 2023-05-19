#include <stdio.h>

//definições
#define bool short
#define true 1
#define false 0

//variaveis
int length(char frase[]);
bool aPalindromo(char frase[]);
bool strComp(char frase[]);

int main(){
    const int TAM = 1000;
    char entrada[TAM];

    fgets(entrada, TAM ,stdin);  //passagem de paramêtro // entrada do teclado
    int tam = length(entrada);   
    
    while(!strComp(entrada)){   // palindromo = sim 
        if(aPalindromo(entrada)){   // não palindromo = não
            printf("SIM\n");
        }
        else{
            printf("NAO\n");
        }

        fgets(entrada, TAM ,stdin);
        tam = length(entrada);
    }

}

bool aPalindromo(char frase[]){  //palindromo
    bool aPalindromo = true;
    int tamAux = length(frase)-1; 
    int tam =  length(frase);

    for (int i = 0; i < tam/2; i++){  
        if(frase[i] != frase[tamAux]){ // leitura diferente ao contrário = falso
            aPalindromo = false;
            i = tam;
        }
        tamAux--;
    }
     return aPalindromo;
}

int length(char frase[]){  //ler frase
    int tam = 0;

    while(frase[tam] != '\0'){
        tam++;
    }

    tam--; 
    return tam;
}

bool strComp(char frase[]){  // FIM
    bool ehFim = true;
    char FIM[] = "FIM";

    for(int i = 0; i < 3; i++){
        if(frase[i] != FIM[i]){
            ehFim = false;
            i = 3;
        }
    }
    return ehFim;
}