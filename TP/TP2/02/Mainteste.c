#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>
#include "Personagem.h"

typedef struct Personagem {
char nome[100];
int altura;
double peso;
char corDoCabelo[50];
char corDaPele[50];
char corDosOlhos[50];
char anoNascimento[10];
char genero[20];
char homeworld[100];
} Personagem;

Personagem* Personagem_novo(){
Personagem* personagem = (Personagem*) malloc(sizeof(Personagem));
if(personagem != NULL){
    strcpy(personagem->nome, "");
    personagem->altura = 0;
    personagem->peso = 0;
    strcpy(personagem->corDoCabelo, "");
    strcpy(personagem->corDaPele, "");
    strcpy(personagem->corDosOlhos, "");
    strcpy(personagem->anoNascimento, "");
    strcpy(personagem->genero, "");
    strcpy(personagem->homeworld, "");
}

return personagem;
}

Personagem* Personagem_novo_param(char* nome, char* corDoCabelo, char* corDaPele, char* corDosOlhos, char* anoNascimento, char* genero, char* homeworld, int altura, double peso){
Personagem* personagem = (Personagem*) malloc(sizeof(Personagem));
if(personagem != NULL){
    strcpy(personagem->nome, nome);
    personagem->altura = altura;
    personagem->peso = peso;
    strcpy(personagem->corDoCabelo, corDoCabelo);
    strcpy(personagem->corDaPele, corDaPele);
    strcpy(personagem->corDosOlhos, corDosOlhos);
    strcpy(personagem->anoNascimento, anoNascimento);
    strcpy(personagem->genero, genero);
    strcpy(personagem->homeworld, homeworld);
}

return personagem;

}

char* getNome(Personagem* personagem){
return personagem->nome;
}

int getAltura(Personagem* personagem){
return personagem->altura;
}

double getPeso(Personagem* personagem){
return personagem->peso;
}

char* getCorDoCabelo(Personagem* personagem){
return personagem->corDoCabelo;
}

char* getCorDaPele(Personagem* personagem){
return personagem->corDaPele;
}

char* getCorDosOlhos(Personagem* personagem){
return personagem->corDosOlhos;
}

char* getAnoNascimento(Personagem* personagem){
return personagem->anoNascimento;
}

char* getGenero(Personagem* personagem){
return personagem->genero;
}

char* getHomeworld(Personagem* personagem){
return personagem->homeworld;
}

void setNome(Personagem* personagem, char* nome){
strcpy(personagem->nome, nome);
}

void setAltura(Personagem* personagem, int altura){
personagem->altura = altura;
}

void setPeso(Personagem* personagem, double peso){
personagem->peso = peso;
}

void setCorDoCabelo(Personagem* personagem, char* corDoCabelo){
strcpy(personagem->corDoCabelo, corDoCabelo);
}

void setCorDaPele(Personagem* personagem, char* corDaPele){
strcpy(personagem->corDaPele, corDaPele);
}

void setCorDosOlhos(Personagem *personagem, char *corDosOlhos){
strcpy(personagem->corDosOlhos, corDosOlhos);
}

void setAnoNascimento(Personagem *personagem, char *anoNascimento){
strcpy(personagem->anoNascimento, anoNascimento);
}

void setGenero(Personagem *personagem, char *genero){
strcpy(personagem->genero, genero);
}

void setHomeworld(Personagem *personagem, char *homeworld){
strcpy(personagem->homeworld, homeworld);
}

char* tem(char *l){
char nova = (char)malloc(strlen(l)*sizeof(char));
int j = 0;
for(int i = 0; i < strlen(l)-1; i++){
if(l[i] != ','){
nova[j++] = l[i];
}
}
nova[j] = '\0';
return nova;
}

void imprimirPeso(Personagem personagem){
if((personagem->peso10)%10==0){
printf("%d",(int)personagem->peso);
}else{
printf("%.1f",personagem->peso);
}
}

void caminho(Personagem *personagem, char *l){
    //nome
for(int i = 0; i < strlen(l)-1;i++){
    if(l[i] == 'n' && l[i+1] == 'a' && l[i+2] == 'm' && l[i+3] == 'e'){
        i+=8;
        for(int j = i; j<strlen(l)-1;j++){
            if(l[j] != ','){
                personagem->nome[strlen(personagem->nome)] = l[j];
            }else{
                break;
            }
        }
    }

    //altura
    if(l[i] == 'h' && l[i+1] == 'e' && l[i+2] == 'i' && l[i+3] == 'g' && l[i+4] == 'h' && l[i+5] == 't'){
        i+=9;
        char altura[10];
        int j = 0;
        while(l[i] != ','){
            altura[j++] = l[i++];
        }
        altura[j] = '\0';
        personagem->altura = atoi(altura);
    }

    //peso
    if(l[i] == 'm' && l[i+1] == 'a' && l[i+2] == 's' && l[i+3] == 's'){
        i+=7;
        char peso[10];
        int j = 0;
        while(l[i] != ','){
            peso[j++] = l[i++];
        }
        peso[j] = '\0';
        personagem->peso = atof(peso);
    }

    //corDoCabelo
    if(l[i] == 'h' && l[i+1] == 'a' && l[i+2] == 'i' && l[i+3] == 'r' && l[i+4] == '_'){
        i+=13;
        for(int j = i; j<strlen(l)-1;j++){
            if(l[j] != ','){
                personagem->corDoCabelo[strlen(personagem->corDoCabelo)] = l[j];
            }else{
                break;
            }
        }
    }

    //corDaPele
    if(l[i] == 's' && l[i+1] == 'k' && l[i+2] == 'i' && l[i+3] == 'n'){
        p->setCorDaPele(SkinColor::SKIN);
i += 3;
} else if(l[i] == 'p' && l[i+1] == 'r' && l[i+2] == 'e' && l[i+3] == 't' && l[i+4] == 'a'){
p->setCorDaPele(SkinColor::PRETA);
i += 4;
} else if(l[i] == 'b' && l[i+1] == 'r' && l[i+2] == 'a' && l[i+3] == 'n' && l[i+4] == 'c' && l[i+5] == 'a'){
p->setCorDaPele(SkinColor::BRANCA);
i += 5;
} else if(l[i] == 'a' && l[i+1] == 'm' && l[i+2] == 'a' && l[i+3] == 'r' && l[i+4] == 'e' && l[i+5] == 'l' && l[i+6] == 'a'){
p->setCorDaPele(SkinColor::AMARELA);
i += 6;
} else if(l[i] == 'v' && l[i+1] == 'e' && l[i+2] == 'r' && l[i+3] == 'm' && l[i+4] == 'e' && l[i+5] == 'l' && l[i+6] == 'h' && l[i+7] == 'a'){
p->setCorDaPele(SkinColor::VERMELHA);
i += 7;
}
}
}

// Implementação da função setCorDosOlhos
void setCorDosOlhos(Personagem* p, std::string l){
for(int i = 0; i < l.size(); i++){
if(l[i] == 'a' && l[i+1] == 'z' && l[i+2] == 'u' && l[i+3] == 'l'){
p->setCorDosOlhos(EyeColor::AZUL);
i += 3;
} else if(l[i] == 'v' && l[i+1] == 'e' && l[i+2] == 'r' && l[i+3] == 'd' && l[i+4] == 'e'){
p->setCorDosOlhos(EyeColor::VERDE);
i += 4;
} else if(l[i] == 'c' && l[i+1] == 'a' && l[i+2] == 's' && l[i+3] == 't' && l[i+4] == 'a' && l[i+5] == 'n' && l[i+6] == 'h' && l[i+7] == 'o'){
p->setCorDosOlhos(EyeColor::CASTANHO);
i += 7;
}
}
}

// Implementação da função setTipoSanguineo
void setTipoSanguineo(Personagem* p, std::string l){
if(l == "A+"){
p->setTipoSanguineo(BloodType::A_POSITIVO);
} else if(l == "A-"){
p->setTipoSanguineo(BloodType::A_NEGATIVO);
} else if(l == "B+"){ loodType::B_POSITIVO); 
} else if(l == "B-"){
p->setTipoSanguineo(BloodType::B_NEGATIVO);
} else if(l == "AB+"){
p->setTipoSanguineo(BloodType::AB_POSITIVO);
} else if(l == "AB-"){
p->setTipoSanguineo(BloodType::AB_NEGATIVO);
} else if(l == "O+"){
p->setTipoSanguineo(BloodType::O_POSITIVO);
} else if(l == "O-"){
p->setTipoSanguineo(BloodType::O_NEGATIVO);
} else {
// se não for um tipo de sangue válido, lançar uma exceção
throw std::invalid_argument("Tipo sanguíneo inválido.");
}
} else {
// se não for um número inteiro válido, lançar uma exceção
throw std::invalid_argument("Idade inválida.");
} else {
// se não for um nome válido, lançar uma exceção
throw std::invalid_argument("Nome inválido.");
}else {
// se não for um gênero válido, lançar uma exceção
throw std::invalid_argument("Gênero inválido.");
} else {
// se não for uma cor de cabelo válida, lançar uma exceção
throw std::invalid_argument("Cor de cabelo inválida.");
} else {
// se não for uma cor de olhos válida, lançar uma exceção
throw std::invalid_argument("Cor dos olhos inválida.");
}
// se não houve exceções, retornar o ponteiro para o personagem criado
return p;



using namespace std;

int main() {
    Personagem *p1 = new Personagem();
    p1->setNome("Gandalf");
    p1->setIdade(2019);
    p1->setAltura(1.80);
    p1->setPeso(85.0);
    p1->setCorDoCabelo("Cinza");
    p1->setCorDosOlhos("Azul");
    p1->setCorDaPele("Branco");
    p1->setTipoSanguineo(BloodType::AB_POSITIVO);

    Personagem *p2 = new Personagem();
    p2->setNome("Legolas");
    p2->setIdade(2931);
    p2->setAltura(1.87);
    p2->setPeso(70.5);
    p2->setCorDoCabelo("Loiro");
    p2->setCorDosOlhos("Azul");
    p2->setCorDaPele("Branco");
    p2->setTipoSanguineo(BloodType::O_NEGATIVO);

    cout << "Nome: " << p1->getNome() << endl;
    cout << "Idade: " << p1->getIdade() << endl;
    cout << "Altura: " << p1->getAltura() << endl;
    cout << "Peso: " << p1->getPeso() << endl;
    cout << "Cor do cabelo: " << p1->getCorDoCabelo() << endl;
    cout << "Cor dos olhos: " << p1->getCorDosOlhos() << endl;
    cout << "Cor da pele: " << p1->getCorDaPele() << endl;
    cout << "Tipo sanguíneo: " << static_cast<int>(p1->getTipoSanguineo()) << endl;

    cout << endl;

    cout << "Nome: " << p2->getNome() << endl;
    cout << "Idade: " << p2->getIdade() << endl;
    cout << "Altura: " << p2->getAltura() << endl;
    cout << "Peso: " << p2->getPeso() << endl;
    cout << "Cor do cabelo: " << p2->getCorDoCabelo() << endl;
    cout << "Cor dos olhos: " << p2->getCorDosOlhos() << endl;
    cout << "Cor da pele: " << p2->getCorDaPele() << endl;
    cout << "Tipo sanguíneo: " << static_cast<int>(p2->getTipoSanguineo()) << endl;

    delete p1;
    delete p2;

    return 0;
}


