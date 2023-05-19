#include <stdio.h>
#include <stdbool.h>
#include <string.h>

bool isFim(char *s){ // FIM
    bool resp = false;
    if (strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M'){ // comparação fim
        resp = true;
    }

    return resp;
}

bool isVogal(char *s){ // Vogal
    bool resp = false;

    for (int i = 0; i < strlen(s); i++) { // repetição para conferir vogal

        if (s[i] == 'a' || s[i] == 'A' || s[i] == 'e' || s[i] == 'E' || s[i] == 'i' ||
            s[i] == 'I' || s[i] == 'o' || s[i] == 'O' || s[i] == 'u' || s[i] == 'U') {
            resp = true;
        }
        else{
            return false;
        }
    }
    return resp;
}

bool isConsoante(char *s){ // consoante
    bool resp = false;

    for (int i = 0; i < strlen(s); i++){ // repetição para conferir consoante
        if (s[i] == 'b' || s[i] == 'B' || s[i] == 'c' || s[i] == 'C' ||
            s[i] == 'd' || s[i] == 'D' || s[i] == 'f' || s[i] == 'F' ||
            s[i] == 'g' || s[i] == 'G' || s[i] == 'h' || s[i] == 'H' ||
            s[i] == 'j' || s[i] == 'J' || s[i] == 'k' || s[i] == 'K' ||
            s[i] == 'l' || s[i] == 'L' || s[i] == 'm' || s[i] == 'M' ||
            s[i] == 'n' || s[i] == 'N' || s[i] == 'p' || s[i] == 'P' ||
            s[i] == 'q' || s[i] == 'Q' || s[i] == 'r' || s[i] == 'R' ||
            s[i] == 's' || s[i] == 'S' || s[i] == 't' || s[i] == 'T' ||
            s[i] == 'v' || s[i] == 'V' || s[i] == 'w' || s[i] == 'W' ||
            s[i] == 'x' || s[i] == 'X' || s[i] == 'y' || s[i] == 'Y' ||
            s[i] == 'z' || s[i] == 'Z') {
            resp = true;
        }else{
        return false;
        }
    }
    return resp;
}

bool isInt(char *s){ // Inteiro
    bool resp = false;
    for (int i = 0; i < strlen(s); i++){ // repetição para conferir int
        if (s[i] == '0' || s[i] == '1' || s[i] == '2' || s[i] == '3' || s[i] == '4' ||
            s[i] == '5' || s[i] == '6' || s[i] == '7' || s[i] == '8' || s[i] == '9') {
            resp = true;
        }else{
            return false;
        }
    }
    return resp;
}

bool isReal(char *s){ // Real
    bool resp = false;
    int count = 0;

    for (int i = 0; i < strlen(s); i++){ // conferir nmr real

        if ((s[i] == '0' || s[i] == '1' || s[i] == '2' || s[i] == '3' || s[i] == '4' ||
             s[i] == '5' || s[i] == '6' || s[i] == '7' || s[i] == '8' || s[i] == '9' ||
             s[i] == ',' || s[i] == '.')){
            resp = true;
            if (s[i] == ',' || s[i] == '.'){
                count++;
            }
            if (count > 1){
                return false;
            }
        } else
            return false;
    }
    return resp;
}

int main(){ // main principal
    char entrada[1000];
    while (isFim(entrada) == false){ 
        scanf(" %[^\n]s", entrada);
        if (isVogal(entrada) == true){ // se for vogal = sim
            printf("SIM ");
        }
        else if (isVogal(entrada) == false){ 
            if (isFim(entrada) == true){
                break;
            }
            printf("NAO ");
        }
        if (isConsoante(entrada) == true){
            printf("SIM ");
        }
        else if (isConsoante(entrada) == false){
            if (isFim(entrada) == true){
                break;
            }
            printf("NAO ");
        }
        if (isInt(entrada) == true){
            printf("SIM ");
        }
        else if (isInt(entrada) == false){
             if (isFim(entrada) == true){
                break;
            }
            printf("NAO ");
        }
        if (isReal(entrada) == true) {
            printf("SIM\n");
        }
        else if (isReal(entrada) == false){
            if (isFim(entrada) == true){
                break;
            } printf("NAO\n");
        }
    }
    return 0;
}