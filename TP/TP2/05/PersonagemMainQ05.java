//import java.io.BufferedReader;
import java.awt.List;
import java.io.File;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.RandomAccessFile;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

class Personagem{

    //Atributos privados da classe Personagem
    private String nome;
    private int altura;
    private double peso;
    private String corDoCabelo;
    private String corDaPele;
    private String corDosOlhos;
    private String anoNascimento;
    private String genero;
    private String homeworld;

    Personagem() { // Construtor do personagem
         this.nome = "";
        this.altura = 0;
        this.peso = 0;
        this.corDoCabelo = "";
        this.corDaPele = "";
        this.corDosOlhos = "";
        this.anoNascimento = "";
        this.genero = "";
        this.homeworld = ""; 
    } 

    // construtor da classe Personagem
    public Personagem(String nome,String corDoCabelo, String corDaPele, String corDosOlhos, String anoNascimento, String genero, String homeworld, int altura, double peso){
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.corDoCabelo = corDoCabelo;
        this.corDaPele = corDaPele;
        this.corDosOlhos = corDosOlhos;
        this.anoNascimento = anoNascimento;
        this.genero = genero;
        this.homeworld = homeworld;
    }

    // métodos que retornam o atributo

    public String getNome(){ //método que retorna o valor do atributo nome
        return nome;
     }
  
     public int getAltura() { // método que retorna altura
        return altura;
     }

     public double getPeso(){ // méotod que retorna peso
        return peso;
     }

     public String getCorDoCabelo(){ // metodo que retorna cor do cabelo
        return corDoCabelo;
     }

     public String getCorDaPele(){ // retorna cor da pele
        return corDaPele;
     }

     public String getCorDosOlhos(){ //retorna cor dos olhos
        return corDosOlhos;
     }

     public String getAnoNascimento(){ //retorna ano nascimento
        return anoNascimento;
     }

     public String getGenero(){ // retorna genero
        return genero;
     }

     public String getHomeworld(){ // retorna homeworld
        return homeworld;
     }

      // métodos que alteram o atributo

     public void setNome(String nome){ //método que altera o valor do atributo nome
        this.nome = nome;
    }

    public void setAltura(int altura){ //  método que altera altura
        this.altura = altura;
     }
   
    public void setPeso(double peso){ // método que altera peso
        this.peso = peso;
    }

    public void setCorDoCabelo(String corDoCabelo){ // altera cor do cabelo
        this.corDoCabelo = corDoCabelo;
    }

    public void setCorDaPele(String corDaPele){ // altera cor da pele
        this.corDaPele = corDaPele;
    }

    public void setCorDosOlhos(String corDosOlhos){ // altera cor dos olhos
        this.corDosOlhos = corDosOlhos;
    }
 
    public void setanoNascimento(String anoNascimento){ // altera ano nascimento
        this.anoNascimento = anoNascimento;
    }

    public void setgenero(String genero){ // altera genero
        this.genero = genero;
    }

    public void sethomeworld(String homeworld){ // altera homeworld
        this.homeworld = homeworld;
    }

public String tem(String l){
        String nova = "";
        for(int i = 0; i<l.length()-1;i++){
        if(l.charAt(i)!=','){
        nova+=l.charAt(i);
        }
    }
 return nova;
}
    
    public Personagem clone(){

        Personagem clonea = new Personagem();

        clonea.nome = this.nome;
        clonea.altura = this.altura;
        clonea.peso = this.peso;
        clonea.corDoCabelo = this.corDoCabelo;
        clonea.corDaPele = this.corDaPele;
        clonea.corDosOlhos = this.corDosOlhos;
        clonea.anoNascimento = this.anoNascimento;
        clonea.genero = this.genero;
        clonea.homeworld = this.homeworld;

        return clonea;
    }


 public void Imprimir(){
    if((this.peso*10)%10==0){
         System.out.print((int)this.peso);
    }else{
        System.out.print(this.peso); 
    }
} 


 public void caminho(String l){

  //nome
for(int i = 0; i < l.length()-1;i++){
    if(l.charAt(i) == 'n' && l.charAt(i+1) == 'a' && l.charAt(i+2) == 'm' && l.charAt(i+3) == 'e'){
        i+=8;
        for(int j = i; j<l.length()-1;j++){
            if(l.charAt(j) == (char)39){
            String a = "";
            a = l.substring(i, j);
            j = l.length()+1;
            i = l.length()+1;
            setNome(a);
        }
    }
}
}

// altura

for(int i = 0; i < l.length();i++){
    if(l.charAt(i) == 'h' && l.charAt(i+1) == 'e' && l.charAt(i+2) == 'i' && l.charAt(i+3) == 'g' && l.charAt(i+4) == 'h' && l.charAt(i+5) == 't'){
        i+=10;
        for(int j=i;j<l.length();j++){
            if(l.charAt(j)==(char)39){
                String a = l.substring(i, j);
                j = l.length()+1;
                i = l.length()+1;
                if(a.equals("unknow")){
                    int b = 0;
                    setAltura(b);
        } else if(a.equals("unknown")){
        int b = 0;
        setAltura(b);
        }else {
        int b = Integer.parseInt(a);
        setAltura(b);
        }
     }
    }
  }
}

// peso

for(int i = 0; i <l.length();i++){
    if(l.charAt(i) == 'm' && l.charAt(i+1) == 'a' && l.charAt(i+2) == 's' && l.charAt(i+3) == 's'){
    i+=8;
    for(int j=i;j<l.length();j++){
        if(l.charAt(j) == (char)39){
        String a = l.substring(i, j);

        a = tem(a);

        if(a.equals("unknow")){
        setPeso(0);
    }else if(a.equals("unknown")){

    int b = 0;
    setAltura(b);
    }else{
        setPeso(Double.parseDouble(a));
    }
    i= l.length()+1;
    j = l.length()+1;
}
   }
  }
}

// cabelo

for(int i = 0; i <l.length();i++){
if(l.charAt(i) == 'h' && l.charAt(i+1) == 'a' && l.charAt(i+2) == 'i' && l.charAt(i+3) == 'r'){
    i+=14;
    for(int j = i;j<l.length();j++){
        if(l.charAt(j) == (char)39){
        String a = l.substring(i, j);
        setCorDoCabelo(a);
        j = l.length()+1;
        i = l.length()+1;
}
  }
 }
}

// cor de pele

for(int i = 0; i <l.length();i++){
    if(l.charAt(i) == 's' && l.charAt(i+1) == 'k' && l.charAt(i+2) == 'i' && 
        l.charAt(i+3) == 'n'){
        i+=14;

        for(int j = i; j < l.length();j++){
        if(l.charAt(j)==(char)39){
            String a = l.substring(i, j);
            setCorDaPele(a);
            j = l.length()+1;
            i = l.length()+1;
}

   }
  }
}

// olhos

for(int i = 0; i <l.length();i++){
    if(l.charAt(i) == 'e' && l.charAt(i+1) == 'y' && l.charAt(i+2) == 'e'){
        i+=13;

        for(int j = i; j < l.length();j++){
            if(l.charAt(j)==(char)39){
            String a = l.substring(i, j);
            setCorDosOlhos(a);
            j = l.length()+1;
            i = l.length()+1;
}

    }
  }
}


// anoNascimento

for(int i = 0; i <l.length();i++){
    if(l.charAt(i) == 'b' && l.charAt(i+1) == 'i' && l.charAt(i+2) == 'r' && l.charAt(i+3) == 't' && l.charAt(i+4) == 'h'){
        i+=14;

        for(int j = i; j < l.length();j++){
            if(l.charAt(j)==(char)39){
            String a = l.substring(i, j);
            setanoNascimento(a);;
            j = l.length()+1;
            i = l.length()+1;
}

   }
  }
}

// genero

for(int i = 0; i <l.length();i++){
    if(l.charAt(i) == 'g' && l.charAt(i+1) == 'e' && l.charAt(i+2) == 'n' && l.charAt(i+3) == 'd' && l.charAt(i+4) == 'e' && l.charAt(i+5) == 'r'){
        i+=10;
        for(int j = i; j < l.length();j++){
            if(l.charAt(j)==(char)39){
            String a = l.substring(i, j);
            setgenero(a);
            getGenero();
            j = l.length()+1;
            i = l.length()+1;
}


}
}
}

// homeworld

for(int i = 0; i <l.length();i++){
    if(l.charAt(i) == 'h' && l.charAt(i+1) == 'o' && l.charAt(i+2) == 'm' && 
        l.charAt(i+3) == 'e' && l.charAt(i+4) == 'w' && l.charAt(i+5) == 'o' && l.charAt(i+6) == 'r' && l.charAt(i+7) == 'l' && l.charAt(i+8) == 'd'){
        i+=13;

    for(int j = i; j < l.length();j++){
        if(l.charAt(j)==(char)39){
        String a = l.substring(i, j);
        sethomeworld(a);
        j = l.length()+1;
        i = l.length()+1;
    }


  }
 }
}

}
}

class PersonagemMainQ05 extends Personagem{  

    
    /*
    public ListaPersonagens() {
        lista = new ArrayList<Personagem>();
    }
    
    public void inserirInicio(Personagem personagem) {
        lista.add(0, personagem);
    }
    
    public void inserir(Personagem personagem, int posicao) {
        lista.add(posicao, personagem);
    }
    
    public void inserirFim(Personagem personagem) {
        lista.add(personagem);
    }

    public Personagem removerInicio() {
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.remove(0);
        }
    }
    
    public Personagem remover(int posicao) {
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.remove(posicao);
        }
    }
    
    public Personagem removerFim() {
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.remove(lista.size()-1);
        }
    } */
    
    public static boolean ehFim(String l){ //FIM
        if(l.length() == 3 && l.charAt(0) == 'F' && l.charAt(1) == 'I' && l.charAt(2) == 'M'){
            return false;
        }
        return true;
    }

    public static void printList(ArrayList a){
        try{

            Personagem fabio = new Personagem();
            
            for(int i = 0; i < a.size();i++){
                fabio = (Personagem) a.get(i);
                System.out.print("["+ i +"]  ");
                System.out.print("## "+fabio.getNome()+" ## "+fabio.getAltura()+ " ## ");
            fabio.Imprimir();
            System.out.print(" ## "+ fabio.getCorDoCabelo()+" ## "+fabio.getCorDaPele()+" ## "+fabio.getCorDosOlhos()+" ## "+fabio.getAnoNascimento()+" ## ");
            System.out.println(fabio.getGenero()+ " ## "+fabio.getHomeworld()+" ## ");
            }
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

public static void main(String[] args) throws Exception{
    ArrayList<Personagem> lista = new ArrayList<Personagem>(1000);

    Personagem fabio = new Personagem();

    int tst = 0;

    try{
        Personagem a = new Personagem();
        Scanner sc = new Scanner(System.in);  
        String str = new String();
        str = sc.nextLine();


        do{
            File arq = new File(str);
            Scanner sc2 = new Scanner(arq);
            String b = sc2.nextLine();
            a.caminho(b);
            
            lista.add(a.clone());
            
            str = sc.nextLine();
            sc2.close();

            }while(ehFim(str));

            
            int input;
            input = Integer.parseInt(sc.nextLine());
            
            
            for(int i = 0; i <input;i++){
                str = sc.nextLine();

                if(str.charAt(0) == 'I'){
                        str = str.substring(2);
                        File archive = new File(str);
                        Scanner sc3 = new Scanner(archive);
                        str = sc3.nextLine();
                        
                        a.caminho(str);
                        lista.add(lista.size()-2,a.clone());
                    }
                    else{ //remove fim
                        fabio = lista.remove(lista.size()-1);
                        System.out.println("(R) " + fabio.getNome());
                }
                
            }
            sc.close();
        }
        catch(FileNotFoundException e){
                e.printStackTrace();
        }
        printList(lista);
    }
}
