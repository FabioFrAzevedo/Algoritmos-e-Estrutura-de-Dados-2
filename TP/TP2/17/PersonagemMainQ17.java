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

    public void ordenaMergesort() {
        ordenaMergesort(0, contadorTamanho - 1);
    }

    public void ordenaMergesort(int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            ordenaMergesort(esq, meio);
            ordenaMergesort(meio + 1, dir);
            intercalarVetores(esq, meio, dir);
        }
    }

    public void intercalarVetores(int esq, int meio, int dir) {
        int nEsq = (meio + 1) - esq;
        int nDir = dir - meio;
        Personagem[] arrayEsq = new Personagem[nEsq + 1];
        Personagem[] arrayDir = new Personagem[nDir + 1];

        arrayEsq[nEsq] = arrayDir[nDir] = new Personagem();
        arrayEsq[nEsq].sethomeworld("zzzzzz"); 
        arrayDir[nDir].sethomeworld("zzzzzz"); 

        numeroMovimentacoes += 2;

        int iEsq, iDir, i;

        for (iEsq = 0; iEsq < nEsq; iEsq++) {
            arrayEsq[iEsq] = listaPersonagens[esq + iEsq];

            numeroComparacoes++;
            numeroMovimentacoes++;
        }
        numeroComparacoes++;

        for (iDir = 0; iDir < nDir; iDir++) {
            arrayDir[iDir] = listaPersonagens[(meio + 1) + iDir];

            numeroComparacoes++;
            numeroMovimentacoes++;
        }
        numeroComparacoes++;

        for (iEsq = iDir = 0, i = esq; i <= dir; i++) {
            listaPersonagens[i] = ((arrayEsq[iEsq].getHomeworld()).compareTo(arrayDir[iDir].getHomeworld()) <= 0)
                    ? arrayEsq[iEsq++]
                    : arrayDir[iDir++];

            numeroComparacoes++;
            numeroMovimentacoes++;
        }
        numeroComparacoes++;
    }

    // Imprimir resultados
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

public class PersonagemMainQ17 {
    public static void main(String[] args) throws Exception {
        MyIO.setCharset("ISO-8859-1");
        long tempoInicial = System.currentTimeMillis(); // Gravar tempo de início de execução
        Lista listaPersonagens = new Lista();
        String caminhoArquivo = MyIO.readLine().replaceAll("é", "\u00e9");

        while (ehFim(caminhoArquivo) == false) {
            listaPersonagens.inserir(criaPersonagem(caminhoArquivo));
            caminhoArquivo = MyIO.readLine().replaceAll("é", "\u00e9");
        }
        listaPersonagens.ordenaMergesort(); 
        listaPersonagens.imprimir(); 
    }

    public static boolean ehFim(String palavra) {//FIM
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
        int contadorDoisPontos = 0; // Contar separadores

        for (int i = 0; i < descricaoPersonagem.length(); i++) {
            if (descricaoPersonagem.charAt(i) == ':') {
                contadorDoisPontos++;

                switch (contadorDoisPontos) {
                    case 1:
                        personagem.setNome(leituraAtributo(descricaoPersonagem, i + 3));
                        break;
                    case 2:
                        String atributoInteiro = leituraAtributo(descricaoPersonagem, i + 3);
                        if (atributoInteiro.equals("unknown")) {
                            personagem.setAltura(0);
                        } else {
                            personagem.setAltura(Integer.parseInt(atributoInteiro));
                        }
                        break;
                    case 3:
                        String atributoDouble = leituraAtributo(descricaoPersonagem, i + 3).replaceAll(",", ".");
                        if (atributoDouble.equals("unknown")) {
                            personagem.setPeso(0);
                        } else {
                            personagem.setPeso(Double.parseDouble(atributoDouble));
                        }
                        break;
                    case 4:
                        personagem.setCorDoCabelo(leituraAtributo(descricaoPersonagem, i + 3));
                        break;
                    case 5:
                        personagem.setCorDaPele(leituraAtributo(descricaoPersonagem, i + 3));
                        break;
                    case 6:
                        personagem.setCorDosOlhos(leituraAtributo(descricaoPersonagem, i + 3));
                        break;
                    case 7:
                        personagem.setanoNascimento(leituraAtributo(descricaoPersonagem, i + 3));
                        break;
                    case 8:
                        personagem.setgenero(leituraAtributo(descricaoPersonagem, i + 3));
                        break;
                    case 9:
                        personagem.sethomeworld(leituraAtributo(descricaoPersonagem, i + 3));
                        i = descricaoPersonagem.length(); // Encerra os ciclos de repetição desnecessários
                        break;
                    default:
                        break;
                }
            }
        }

        leitura.close();

        return personagem;
    }

    // Retornar valor do atributo do personagem
    public static String leituraAtributo(String descricaoPersonagem, int index) {
        String atributo = new String();

        while (descricaoPersonagem.charAt(index) != '\'') {
            atributo += descricaoPersonagem.charAt(index);

            index++;
        }

        return atributo;
    }
}