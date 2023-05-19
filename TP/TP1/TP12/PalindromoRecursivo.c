#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>

// definicoes
#define nDeStrings 1000
#define tam 350

bool isfim(char *a);
bool ispal(char *a, int i);
void imprimir (char *a);

int main (void) {

char str[nDeStrings][tam + 1];
int y = 0; // tamanho string
char teste[tam + 1];
    // pegar strings
    do {
        fgets(teste, tam, stdin);
        teste[strcspn(teste, "\r\n")] = 0;
        strcpy(str[y], teste);
    } while (isfim(str[y++]));
    y--; //desnconsiderar fim

      for (int i = 0; i < y; i++) {
        imprimir(str[i]);
    } 

}

bool isfim(char *a) {
    if (a[0] == 'F' && a[1] == 'I' && a[2] == 'M'){
    return false;
    }
    return true;
}

void imprimir (char *a) {
    if (ispal(a, 0) == true) {
    printf("SIM\n");
    } else {
    printf("NAO\n");
    }
}

bool ispal(char *a, int i) {
    bool resp;
    if (i == (strlen(a) / 2)) {
        resp = true;
    }
    else if (a[i] != a[strlen(a) - i - 1]) {
        resp = false;
    }
    else {
        resp = ispal(a, i + 1);
    }
    return resp;
}