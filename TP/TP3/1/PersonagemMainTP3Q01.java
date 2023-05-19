import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Locale;
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

     public String gethomeworld(){ // retorna homeworld
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

    public void ler(String nomeArquivo) throws Exception {
        
        FileReader file = new FileReader(""+nomeArquivo);
        BufferedReader buffer = new BufferedReader(file);
        String json = "";
        String line = buffer.readLine();
        
        while (line != null) {
            json += line;
            line = buffer.readLine();
        }

        buffer.close();
        file.close();

        String temp;
        temp = json.substring(json.indexOf("name") + 8);
        temp = temp.substring(0, temp.indexOf("',"));
        this.nome = temp;

        temp = json.substring(json.indexOf("height") + 10);
        temp = temp.substring(0, temp.indexOf("',"));
        if (temp.equals("unknown"))
            this.altura = 0;
        else
            this.altura = Integer.parseInt(temp);

        temp = json.substring(json.indexOf("mass") + 8);
        temp = temp.substring(0, temp.indexOf("',"));
        if (temp.equals("unknown"))
            this.peso = 0;
        else
            this.peso = Double.parseDouble(temp.replace(",", ""));

        temp = json.substring(json.indexOf("hair_color") + 14);
        temp = temp.substring(0, temp.indexOf("',"));
        this.corDoCabelo = temp;

        temp = json.substring(json.indexOf("skin_color") + 14);
        temp = temp.substring(0, temp.indexOf("',"));
        this.corDaPele = temp;

        temp = json.substring(json.indexOf("eye_color") + 13);
        temp = temp.substring(0, temp.indexOf("',"));
        this.corDosOlhos = temp;

        temp = json.substring(json.indexOf("birth_year") + 14);
        temp = temp.substring(0, temp.indexOf("',"));
        this.anoNascimento = temp;

        temp = json.substring(json.indexOf("gender") + 10);
        temp = temp.substring(0, temp.indexOf("',"));
        this.genero = temp;

        temp = json.substring(json.indexOf("homeworld") + 13);
        temp = temp.substring(0, temp.indexOf("',"));
        this.homeworld = temp;
    }

    public void imprimir() {
        System.out.println(toString());
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("#0.##");
        String resp = " ## " + nome + " ## " + altura + " ## ";
        resp += df.format(peso) + " ## " + corDoCabelo + " ## ";
        resp += corDaPele + " ## " + corDosOlhos + " ## ";
        resp += anoNascimento + " ## " + genero + " ## ";
        resp += homeworld + " ## ";
        return resp;
    }

    public void imprimirNome() {
        System.out.println(nome);
    }

}

class Celula {
    public Personagem elemento; // Elemento inserido na celula.
    public Celula prox; // Aponta a celula prox.

    public Celula() {
        this(new Personagem());
        prox = null;
    }
    
    public Celula(Personagem elemento) {
        this.elemento = elemento.clone();
        this.prox = null;
    }
}


class Lista {
    private Celula primeiro;
    private Celula ultimo;

    public Lista() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public void inserirInicio(Personagem x) {
        Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
        tmp = null;
    }

    public void inserirFim(Personagem x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public Personagem removerInicio() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");
        }

        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        Personagem resp = primeiro.elemento;
        tmp.prox = null;
        tmp = null;
        return resp;
    }

    public Personagem removerFim() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");
        }

        Celula i;
        for (i = primeiro; i.prox != ultimo; i = i.prox)
            ;

        Personagem resp = ultimo.elemento;
        ultimo = i;
        i = ultimo.prox = null;

        return resp;
    }

    public void inserir(Personagem x, int pos) throws Exception {

        int tamanho = tamanho();

        if (pos < 0 || pos > tamanho) {
            throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
        } else if (pos == 0) {
            inserirInicio(x);
        } else if (pos == tamanho) {
            inserirFim(x);
        } else {

            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;

            Celula tmp = new Celula(x);
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = i = null;
        }
    }

    public Personagem remover(int pos) throws Exception {
        Personagem resp;
        int tamanho = tamanho();

        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");

        } else if (pos < 0 || pos >= tamanho) {
            throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
        } else if (pos == 0) {
            resp = removerInicio();
        } else if (pos == tamanho - 1) {
            resp = removerFim();
        } else {
            // Caminhar ate a posicao anterior a insercao
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;

            Celula tmp = i.prox;
            resp = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox = null;
            i = tmp = null;
        }

        return resp;
    }

    public void mostrar() {
        int contador = 0;

        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.print("[" + contador + "]");
            i.elemento.imprimir();
            contador++;

        }

    }

    public boolean pesquisar(Personagem x) {
        boolean resp = false;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            if (i.elemento.getNome() == x.getNome()) { // !alterar para o campo desejado
                resp = true;
                i = ultimo;
            }
        }
        return resp;
    }

    public int tamanho() {
        int tamanho = 0;
        for (Celula i = primeiro; i != ultimo; i = i.prox, tamanho++);
        return tamanho;
    }
}



class PersonagemMainTP3Q01 {
    public static boolean ehFim(String s) {
        if (s.equals("FIM"))
            return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner (System.in);
        Lista personagens = new Lista();
        String linha = "";

        while (ehFim(linha = sc.nextLine()) == false) {
            Personagem personagem = new Personagem();
            personagem.ler(linha);
            personagens.inserirFim(personagem);

        }

        int numCasos = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numCasos; i++) {
            String linhaCaso = sc.nextLine();
            String[] infos = linhaCaso.split(" ");
            String caso = infos[0];

            if (caso.equals("II")) {
                Personagem personagem = new Personagem();
                personagem.ler(infos[1]);
                personagens.inserirInicio(personagem);
            }

            if (caso.equals("IF")) {
                Personagem personagem = new Personagem();
                personagem.ler(infos[1]);
                personagens.inserirFim(personagem);
            }

            if (caso.equals("I*")) {
                int pos = Integer.parseInt(infos[1]);
                Personagem personagem = new Personagem();
                personagem.ler(infos[2]);
                personagens.inserir(personagem, pos);
            }

            if (caso.equals("RI")) {
                Personagem personagem = personagens.removerInicio();
                System.out.println("(R) " + personagem.getNome());
            }

            if (caso.equals("RF")) {
                Personagem personagem = personagens.removerFim();
                System.out.println("(R) " + personagem.getNome());
            }

            if (caso.equals("R*")) {
                int pos = Integer.parseInt(infos[1]);
                Personagem personagem = personagens.remover(pos);
                System.out.println("(R) " + personagem.getNome());

            }
        }
        personagens.mostrar();
        sc.close();
    }
}

