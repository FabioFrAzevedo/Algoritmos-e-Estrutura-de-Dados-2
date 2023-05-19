import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Locale;

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

    public void imprimir() {
        DecimalFormat decimalFormat = new DecimalFormat("#.################");
        MyIO.println("## " + this.nome + " ## " + this.altura + " ## " + decimalFormat.format(this.peso) + " ## "
                + this.corDoCabelo + " ## "
                + this.corDaPele + " ## " + this.corDosOlhos + " ## " + this.anoNascimento + " ## " + this.genero
                + " ## " + this.homeworld + " ## ");
    }

    public void leitura(String fileData) {
        String temp, value;
        // readNome
        fileData = fileData.replace("{", "");
        temp = fileData.replaceFirst("'name': '", "");
        value = temp.substring(0, temp.indexOf("'"));
        temp = temp.replaceFirst(value + "', '", "");
        temp = temp.replaceFirst("height': '", "");
        setNome(value);
        // readAltura
        value = temp.substring(0, temp.indexOf("'"));
        temp = temp.replaceFirst(value + "', '", "");
        temp = temp.replaceFirst("mass': '", "");
        if (value.equals("unknown"))
            setAltura(0);
        else
            setAltura(Integer.parseInt(value));
        // readPeso
        value = temp.substring(0, temp.indexOf("'"));
        temp = temp.replaceFirst(value + "', '", "");
        temp = temp.replaceFirst("hair_color': '", "");
        if (value.equals("unknown"))
        setPeso(0.0);
        else
            setPeso(Double.parseDouble(value.replaceAll(",", ".")));
        // readCorDoCabelo
        value = temp.substring(0, temp.indexOf("'"));
        temp = temp.replaceFirst(value + "', '", "");
        temp = temp.replaceFirst("skin_color': '", "");
        setCorDoCabelo(value);
        // readCorDaPele
        value = temp.substring(0, temp.indexOf("'"));
        temp = temp.replaceFirst(value + "', '", "");
        temp = temp.replaceFirst("eye_color': '", "");
        setCorDaPele(value);
        // readCorDosOlhos
        value = temp.substring(0, temp.indexOf("'"));
        temp = temp.replaceFirst(value + "', '", "");
        temp = temp.replaceFirst("birth_year': '", "");
        setCorDosOlhos(value);
        // readAnoNascimento
        value = temp.substring(0, temp.indexOf("'"));
        temp = temp.replaceFirst(value + "', '", "");
        temp = temp.replaceFirst("gender': '", "");
        setanoNascimento(value);
        // readGender
        value = temp.substring(0, temp.indexOf("'"));
        temp = temp.replaceFirst(value + "', '", "");
        temp = temp.replaceFirst("homeworld': '", "");
        setgenero(value);
        // readhomeworld
        value = temp.substring(0, temp.indexOf("'"));
        temp = temp.replaceFirst(value + "', '", "");
        sethomeworld(value);
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

class Pilha {
    public Celula topo;
    public int auxprint;

    public Pilha() {
        topo = new Celula();
        auxprint = 0;
    }
    
    public void inserir(Personagem x) {
        Celula tmp = new Celula(x);
        tmp.prox = topo.prox;
        topo.prox = tmp;
        tmp = null;
    }
    
    public String remover() throws Exception {
        if (topo.prox == null) 
            throw new Exception("Erro ao remover (vazia)!");
        
        Celula tmp = topo.prox;
        topo.prox = tmp.prox;

        String retorno = tmp.elemento.getNome();

        tmp.prox =null;
        tmp = null;
        return retorno;
        
    }
    
    public void mostrar() {
        int n = 0;
        for (Celula i = topo.prox; i != null; i = i.prox, n++) {
            System.out.print("[" + n + "]  ");
            i.elemento.imprimir();
        }
    }

    public void mostrarR(Celula a){
        if(a.prox == null){
            System.out.print("[" + auxprint++ + "]  ");
            a.elemento.imprimir();
        }else{

            mostrarR(a.prox);
            System.out.print("[" + auxprint++ + "]  ");
            a.elemento.imprimir();
        }

    }

}
        public class PersonagemMainTP3Q02 {
            public static void main(String[] args) throws Exception {
        
                Locale.setDefault(Locale.US);
                MyIO.setCharset("UTF-8");
                String word = MyIO.readLine();
                Pilha personagens = new Pilha();
                do {
                    Personagem tmp = new Personagem();
                    tmp.leitura(getFileData(word));
                    personagens.inserir(tmp);
                    word = MyIO.readLine();
                } while (!word.equals("FIM"));

                word = MyIO.readLine();

                int mov = Integer.parseInt(word);

                for (int i = 0; i < mov; i++) {
                    String expression = MyIO.readLine();
                    switch (expression.charAt(0)) {
                        case 'I':
                            Personagem tmp = new Personagem();
                            tmp.leitura(getFileData(expression.substring(2)));
                            personagens.inserir(tmp);
                            break;
                        case 'R':
                            System.out.println("(R) " + personagens.remover());
                            break;
                    }
                }
                personagens.mostrarR(personagens.topo.prox);
            }
        
            public static String getFileData(String word) {
                BufferedReader br = null;
                FileReader fr = null;
                String fileData = "";
                try {
                    fr = new FileReader(word);
                    br = new BufferedReader(fr);
                    fileData = br.readLine();
        
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (br != null) {
                            br.close();
                        }
                        if (fr != null) {
                            fr.close();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                return fileData;
            }
        
        }