//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.RandomAccessFile;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;

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

}

class Lista {
    static Personagem[] listaPersonagens = new Personagem[100];
    int contadorTamanho = 0;
    int numeroComparacoes = 0, numeroMovimentacoes = 0;

    public void inserir(Personagem personagem) throws Exception {
        if (contadorTamanho >= listaPersonagens.length) {
            throw new Exception("Erro!");
        }
        listaPersonagens[contadorTamanho] = personagem;
        contadorTamanho++; 
    }

    public int getMaiorPeso() {
        double maiorPeso = listaPersonagens[0].getPeso();
        for (int i = 1; i < contadorTamanho; i++) {
            if (listaPersonagens[i].getPeso() > maiorPeso) {
                maiorPeso = listaPersonagens[i].getPeso();
            }
            numeroComparacoes += 2;
        }
        return ((int) maiorPeso);
    }

    public void ordenaCountingSort() {
        int[] count = new int[getMaiorPeso() + 1];
        Personagem[] ordenado = new Personagem[contadorTamanho];

        for (int i = 0; i < count.length; count[i] = 0, i++) {
            numeroComparacoes++;
        }

        for (int i = 0; i < contadorTamanho; count[(int) listaPersonagens[i].getPeso()]++, i++) {
            numeroComparacoes++;
        }

        for (int i = 1; i < count.length; count[i] += count[i - 1], i++) {
            numeroComparacoes++;
        }

        for (int i = contadorTamanho - 1; i >= 0; ordenado[count[(int) listaPersonagens[i].getPeso()] // Ordenar
                - 1] = listaPersonagens[i], count[(int) listaPersonagens[i].getPeso()]--, i--) {
            numeroComparacoes++;
        }

        for (int i = 0; i < contadorTamanho; i++) { // Atribuir ao vetor original o vetor ordenado
            listaPersonagens[i] = ordenado[i];
        }
    }

    public void imprimir() {
        for (int i = 0; i < contadorTamanho; i++) {
            MyIO.print(" ## " + listaPersonagens[i].getNome());
            MyIO.print(" ## " + listaPersonagens[i].getAltura());
            if (listaPersonagens[i].getPeso() % 1 == 0) {
                MyIO.print(" ## " + (int) listaPersonagens[i].getPeso());
            } else {
                MyIO.print(" ## " + listaPersonagens[i].getPeso());
            }
            MyIO.print(" ## " + listaPersonagens[i].getCorDoCabelo());
            MyIO.print(" ## " + listaPersonagens[i].getCorDaPele());
            MyIO.print(" ## " + listaPersonagens[i].getCorDosOlhos());
            MyIO.print(" ## " + listaPersonagens[i].getAnoNascimento());
            MyIO.print(" ## " + listaPersonagens[i].getGenero());
            MyIO.print(" ## " + listaPersonagens[i].getHomeworld());
            MyIO.println(" ## ");
        }
    }
}

public class PersonagemMainQ15 {
    public static void main(String[] args) throws Exception {
        MyIO.setCharset("ISO-8859-1");
        Lista listaPersonagens = new Lista();
        String caminhoArquivo = MyIO.readLine().replaceAll("é", "\u00e9");
        while (testaFim(caminhoArquivo) == false) {
            listaPersonagens.inserir(criaPersonagem(caminhoArquivo));
            caminhoArquivo = MyIO.readLine().replaceAll("é", "\u00e9");
        }

        listaPersonagens.ordenaCountingSort(); 
        listaPersonagens.imprimir(); 
    }

    public static boolean testaFim(String palavra) {
        boolean teste = false;
        if (palavra.equals("FIM")) {
            teste = true;
        }
        return teste;
    }

    public static Personagem criaPersonagem(String caminhoArquivo) throws Exception {
        RandomAccessFile leitura = new RandomAccessFile(caminhoArquivo, "r");

        String descricaoPersonagem = leitura.readLine().replaceAll("é", "\u00e9");

        Personagem personagem = new Personagem();
        int contadorDoisPontos = 0; 

        for (int i = 0; i < descricaoPersonagem.length(); i++) {
            if (descricaoPersonagem.charAt(i) == ':') {
                contadorDoisPontos++;

                switch (contadorDoisPontos) {
                    case 1:
                        personagem.setNome(leitura(descricaoPersonagem, i + 3));
                        break;
                    case 2:
                        String atributoInteiro = leitura(descricaoPersonagem, i + 3);
                        if (atributoInteiro.equals("unknown")) {
                            personagem.setAltura(0);
                        } else {
                            personagem.setAltura(Integer.parseInt(atributoInteiro));
                        }
                        break;
                    case 3:
                        String atributoDouble = leitura(descricaoPersonagem, i + 3).replaceAll(",", ".");
                        if (atributoDouble.equals("unknown")) {
                            personagem.setPeso(0);
                        } else {
                            personagem.setPeso(Double.parseDouble(atributoDouble));
                        }
                        break;
                    case 4:
                        personagem.setCorDoCabelo(leitura(descricaoPersonagem, i + 3));
                        break;
                    case 5:
                        personagem.setCorDaPele(leitura(descricaoPersonagem, i + 3));
                        break;
                    case 6:
                        personagem.setCorDosOlhos(leitura(descricaoPersonagem, i + 3));
                        break;
                    case 7:
                        personagem.setanoNascimento(leitura(descricaoPersonagem, i + 3));
                        break;
                    case 8:
                        personagem.setgenero(leitura(descricaoPersonagem, i + 3));
                        break;
                    case 9:
                        personagem.sethomeworld(leitura(descricaoPersonagem, i + 3));
                        i = descricaoPersonagem.length();
                        break;
                    default:
                        break;
                }
            }
        }

        leitura.close();
        return personagem;
    }
    public static String leitura(String descricaoPersonagem, int index) {
        String atributo = new String();
        while (descricaoPersonagem.charAt(index) != '\'') {
            atributo += descricaoPersonagem.charAt(index);
            index++;
        }
        return atributo;
    }
}