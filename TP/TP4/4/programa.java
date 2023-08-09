import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;


public class programa{
    public static void main(String[] args) throws Exception {
        long inicio = System.currentTimeMillis();
        Locale.setDefault(Locale.US);
        //MyIO.setCharset("UTF-8");
        String word = MyIO.readLine();
        Arvore personagens = new Arvore();
        do {
            personagens.inserir(new Personagem(getFileData(word)));
            word = MyIO.readLine();
        } while (!isFim(word));

        word = MyIO.readLine();
        do {
            MyIO.println(personagens.pesquisar(word) ? " SIM" : " NÃO" );
            word = MyIO.readLine();
        } while (!isFim(word));
        long fim = System.currentTimeMillis();
        long tempo = fim - inicio;
        String dados = "matricula 762148 \t nÃºmero de comparaÃ§Ãµes " + "\t Tempo de execuÃ§Ã£o " + tempo + " milisegundos";
        Arq.abrirArquivo("matricula_arvore.txt", "UTF-8", dados);

        MyIO.setCharset("UTF-8");
    }
    
    public static String getFileData(String word) {
        BufferedReader br = null;
        FileReader fr = null;
        String fileData = "";
        try {
            fr = new FileReader(word.substring(0));
            br = new BufferedReader(fr);

            // Ler cada linha do arquivo
            fileData = br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Fechar o BufferedReader e FileReader
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

    public static boolean isFim(String word) {
        return word.length() == 3 && word.charAt(0) == 'F' && word.charAt(1) == 'I' && word.charAt(2) == 'M';
    }
}

/* 
class ArvoreBinaria {
    private No raiz; 
    public int comp = 0;

    public ArvoreBinaria() {
        raiz = null;
    }

    public boolean pesquisar(String x) {
        System.out.print(x + " raiz");
        return pesquisar(x, raiz);
    }

    private boolean pesquisar(String x, No i) {
        boolean resp;
        if (i == null) {
            resp = false;
            comp++;
        } else if (x.equals(i.elemento.getNome())) {
            resp = true;
            comp++;
        } else if (x.compareTo(i.elemento.getNome()) < 0) {
            System.out.print(" esq");
            resp = pesquisar(x, i.esq);
            comp++;
        } else {
            System.out.print(" dir");
            resp = pesquisar(x, i.dir);
            comp++;
        }
        return resp;
    }

    public void caminharCentral() {
        System.out.print("[ ");
        caminharCentral(raiz);
        System.out.println("]");
    }

 
    private void caminharCentral(No i) {
        if (i != null) {
            comp++;
            caminharCentral(i.esq); 
            System.out.print(i.elemento + " "); 
            caminharCentral(i.dir); 
        }
    }

    public void caminharPre() {
        System.out.print("[ ");
        caminharPre(raiz);
        System.out.println("]");
    }

    private void caminharPre(No i) {
        if (i != null) {
            comp++;
            System.out.print(i.elemento + " "); 
            caminharPre(i.esq); 
            caminharPre(i.dir); 
        }
    }

    public void caminharPos() {
        System.out.print("[ ");
        caminharPos(raiz);
        System.out.println("]");
    }

    private void caminharPos(No i) {
        if (i != null) {
            comp++;
            caminharPos(i.esq); 
            caminharPos(i.dir); 
            System.out.print(i.elemento + " "); 
        }
    }

    public void inserir(Personagem x) throws Exception {
        raiz = inserir(x, raiz);
    }

    private No inserir(Personagem x, No i) throws Exception {
        if (i == null) {
            i = new No(x);
            comp++;
        } else if (x.getNome().compareTo(i.elemento.getNome()) < 0) {
            i.esq = inserir(x, i.esq);
            comp++;
        } else if (x.getNome().compareTo(i.elemento.getNome()) > 0) {
            i.dir = inserir(x, i.dir);
            comp++;
        } else {
            throw new Exception("Erro ao inserir!");
        }

        return i;
    }

    public void inserirPai(Personagem x) throws Exception {
        if (raiz == null) {
            raiz = new No(x);
            comp++;
        } else if (x.getNome().compareTo(raiz.elemento.getNome()) < 0) {
            inserirPai(x, raiz.esq, raiz);
            comp++;
        } else if (x.getNome().compareTo(raiz.elemento.getNome()) > 0) {
            inserirPai(x, raiz.dir, raiz);
            comp++;
        } else {
            throw new Exception("Erro ao inserirPai!");
        }
    }

    private void inserirPai(Personagem x, No i, No pai) throws Exception {
        if (i == null) {
            comp++;
            if (x.getNome().compareTo(pai.elemento.getNome()) < 0) {
                pai.esq = new No(x);
                comp++;
            } else {
                pai.dir = new No(x);
                comp++;
            }
        } else if (x.getNome().compareTo(pai.elemento.getNome()) < 0) {
            inserirPai(x, i.esq, i);
            comp++;
        } else if (x.getNome().compareTo(pai.elemento.getNome()) > 0) {
            inserirPai(x, i.dir, i);
            comp++;
        } else {
            throw new Exception("Erro ao inserirPai!");
        }
    }

    public int getAltura() {
        return getAltura(raiz, 0);
    }

    public int getAltura(No i, int altura) {
        if (i == null) {
            altura--;
            comp++;
        } else {
            int alturaEsq = getAltura(i.esq, altura + 1);
            int alturaDir = getAltura(i.dir, altura + 1);
            altura = (alturaEsq > alturaDir) ? alturaEsq : alturaDir;
            comp++;
        }
        return altura;
    }
}
*/
/* 
class No {
    public Personagem elemento; 
    public No esq, dir; 

    public No(Personagem elemento) {
        this(elemento, null, null);
    }

    public No(Personagem elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}*/

class Arvore {
    private No raiz; // Raiz da arvore.
    public int comp = 0;

    public Arvore() {
        raiz = null;
    }

    public boolean pesquisar(String x) {
        System.out.print(x + " raiz");
        return pesquisar(x, raiz);
    }

    private boolean pesquisar(String x, No i) {
        boolean resp;
        if (i == null) {
            resp = false;
            comp++;
        } else if (x.equals(i.elemento.getNome())) {
            resp = true;
            comp++;
        } else if (x.compareTo(i.elemento.getNome()) < 0) {
            System.out.print(" esq");
            resp = pesquisar(x, i.esq);
            comp++;
        } else {
            System.out.print(" dir");
            resp = pesquisar(x, i.dir);
            comp++;
        }
        return resp;
    }

    public void caminharCentral() {
        System.out.print("[ ");
        caminharCentral(raiz);
        System.out.println("]");
    }

    private void caminharCentral(No i) {
        if (i != null) {
            comp++;
            caminharCentral(i.esq); // Elementos da esquerda.
            System.out.print(i.elemento + " "); // Conteudo do no.
            caminharCentral(i.dir); // Elementos da direita.
        }
    }

    public void caminharPre() {
        System.out.print("[ ");
        caminharPre(raiz);
        System.out.println("]");
    }

    private void caminharPre(No i) {
        if (i != null) {
            comp++;
            System.out.print(i.elemento + " "); // Conteudo do no.
            caminharPre(i.esq); // Elementos da esquerda.
            caminharPre(i.dir); // Elementos da direita.
        }
    }

    public void caminharPos() {
        System.out.print("[ ");
        caminharPos(raiz);
        System.out.println("]");
    }

    private void caminharPos(No i) {
        if (i != null) {
            comp++;
            caminharPos(i.esq); // Elementos da esquerda.
            caminharPos(i.dir); // Elementos da direita.
            System.out.print(i.elemento + " "); // Conteudo do no.
        }
    }

    public void inserir(Personagem elemento) throws Exception {
        // Se a arvore estiver vazia
        if (raiz == null) {
            comp++;
            raiz = new No(elemento);

        } else if (raiz.esq == null && raiz.dir == null) {
            comp++;
            if (elemento.getNome().compareTo(raiz.elemento.getNome()) < 0) {
                comp++;
                raiz.esq = new No(elemento);
            } else {
                comp++;
                raiz.dir = new No(elemento);
            }

        } else if (raiz.esq == null) {
            comp++;
            if (elemento.getNome().compareTo(raiz.elemento.getNome()) < 0) {
                raiz.esq = new No(elemento);
                comp++;
            } else if (elemento.getNome().compareTo(raiz.dir.elemento.getNome()) < 0) {
                raiz.esq = new No(raiz.elemento);
                raiz.elemento = elemento;
                comp++;
            } else {
                raiz.esq = new No(raiz.elemento);
                raiz.elemento = raiz.dir.elemento;
                raiz.dir.elemento = elemento;
                comp++;
            }
            raiz.esq.cor = raiz.dir.cor = false;

        } else if (raiz.dir == null) {
            comp++;
            if (elemento.getNome().compareTo(raiz.elemento.getNome()) > 0) {
                raiz.dir = new No(elemento);
                comp++;
            } else if (elemento.getNome().compareTo(raiz.esq.elemento.getNome()) < 0) {
                raiz.dir = new No(raiz.elemento);
                raiz.elemento = elemento;
                comp++;
            } else {
                raiz.dir = new No(raiz.elemento);
                raiz.elemento = raiz.esq.elemento;
                raiz.esq.elemento = elemento;
                comp++;
            }
            raiz.esq.cor = raiz.dir.cor = false;

        } else {
            inserir(elemento, null, null, null, raiz);
        }
        raiz.cor = false;
    }

    private void balancear(No bisavo, No avo, No pai, No i) {
        if (pai.cor == true) {
            comp++;
            if (pai.elemento.getNome().compareTo(avo.elemento.getNome()) > 0) { 
                comp++;
                if (i.elemento.getNome().compareTo(pai.elemento.getNome()) > 0) {
                    avo = rotacaoEsq(avo);
                    comp++;
                } else {
                    avo = rotacaoDirEsq(avo);
                    comp++;
                }
            } else {
                comp++;
                if (i.elemento.getNome().compareTo(pai.elemento.getNome()) < 0) {
                    avo = rotacaoDir(avo);
                    comp++;
                } else {
                    avo = rotacaoEsqDir(avo);
                    comp++;
                }
            }
            if (bisavo == null) {
                comp++;
                raiz = avo;
            } else if (avo.elemento.getNome().compareTo(bisavo.elemento.getNome()) < 0) {
                comp++;
                bisavo.esq = avo;
            } else {
                comp++;
                bisavo.dir = avo;
            }
            avo.cor = false;
            avo.esq.cor = avo.dir.cor = true;
        }
    }

    private void inserir(Personagem elemento, No bisavo, No avo, No pai, No i) throws Exception {
        if (i == null) {
            comp++;
            if (elemento.getNome().compareTo(pai.elemento.getNome()) < 0) {
                i = pai.esq = new No(elemento, true);
                comp++;
            } else {
                i = pai.dir = new No(elemento, true);
                comp++;
            }
            if (pai.cor == true) {
                balancear(bisavo, avo, pai, i);
                comp++;
            }
        } else {
            comp++;
            if (i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true) {
                i.cor = true;
                i.esq.cor = i.dir.cor = false;
                comp++;
                if (i == raiz) {
                    i.cor = false;
                    comp++;
                } else if (pai.cor == true) {
                    balancear(bisavo, avo, pai, i);
                    comp++;
                }
            }
            if (elemento.getNome().compareTo(i.elemento.getNome()) < 0) {
                inserir(elemento, avo, pai, i, i.esq);
                comp++;
            } else if (elemento.getNome().compareTo(i.elemento.getNome()) > 0) {
                inserir(elemento, avo, pai, i, i.dir);
                comp++;
            } else {
                throw new Exception("Erro inserir (elemento repetido)!");
            }
        }
    }

    private No rotacaoDir(No no) {
        No noEsq = no.esq;
        No noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;

        return noEsq;
    }

    private No rotacaoEsq(No no) {
        No noDir = no.dir;
        No noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;
        return noDir;
    }

    private No rotacaoDirEsq(No no) {
        no.dir = rotacaoDir(no.dir);
        return rotacaoEsq(no);
    }

    private No rotacaoEsqDir(No no) {
        no.esq = rotacaoEsq(no.esq);
        return rotacaoDir(no);
    }
}

class No {
    public Personagem elemento; // Conteudo do no.
    public No esq, dir; // Filhos da esq e dir.
    public boolean cor;

    public No() {
        this(null);
    }

    public No(Personagem elemento) {
        this(elemento, false, null, null);
    }

    public No(Personagem elemento, boolean cor) {
        this(elemento, cor, null, null);
    }

    public No(Personagem elemento, boolean cor, No esq, No dir) {
        this.cor = cor;
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}


class Personagem {
    private String nome;
    private int altura;
    private Double peso;
    private String corDoCabelo;
    private String codDaPele;
    private String corDosOlhos;
    private String anoNascimento;
    private String genero;
    private String homeWorld;

    public Personagem() {
        this.nome = "";
        this.altura = 0;
        this.peso = 0.0;
        this.corDoCabelo = "";
        this.codDaPele = "";
        this.corDosOlhos = "";
        this.anoNascimento = "";
        this.genero = "";
        this.homeWorld = "";
    }

    public Personagem(String fileData) {
        ler(fileData);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getAltura() {
        return altura;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getPeso() {
        return peso;
    }

    public void setCorDoCabelo(String corDoCabelo) {
        this.corDoCabelo = corDoCabelo;
    }

    public String getCorDoCabelo() {
        return corDoCabelo;
    }

    public void setCodDaPele(String codDaPele) {
        this.codDaPele = codDaPele;
    }

    public String getCodDaPele() {
        return codDaPele;
    }

    public void setCorDosOlhos(String corDosOlhos) {
        this.corDosOlhos = corDosOlhos;
    }

    public String getCorDosOlhos() {
        return corDosOlhos;
    }

    public void setAnoNascimento(String anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getAnoNascimento() {
        return anoNascimento;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setHomeWorld(String homeWorld) {
        this.homeWorld = homeWorld;
    }

    public String getHomeWorld() {
        return homeWorld;
    }

    public Personagem clone() {
        Personagem temp = new Personagem();
        temp.nome = this.nome;
        temp.altura = this.altura;
        temp.peso = this.peso;
        temp.corDoCabelo = this.corDoCabelo;
        temp.codDaPele = this.codDaPele;
        temp.corDosOlhos = this.corDosOlhos;
        temp.anoNascimento = this.anoNascimento;
        temp.genero = this.genero;
        temp.homeWorld = this.homeWorld;
        return temp;
    }

    public void imprimir() {
        DecimalFormat decimalFormat = new DecimalFormat("#.################");
        System.out.println("## " + this.nome + " ## " + this.altura + " ## " + decimalFormat.format(this.peso) + " ## "
                + this.corDoCabelo + " ## "
                + this.codDaPele + " ## " + this.corDosOlhos + " ## " + this.anoNascimento + " ## " + this.genero
                + " ## " + this.homeWorld + " ## ");
    }

    public void ler(String fileData) {
        String temp, value;
        fileData = fileData.replace("{", "");
        temp = fileData.replaceFirst("'name': '", "");
        value = temp.substring(0, temp.indexOf("'"));
        temp = temp.replaceFirst(value + "', '", "");
        temp = temp.replaceFirst("height': '", "");
        setNome(value);
        
        value = temp.substring(0, temp.indexOf("'"));
        temp = temp.replaceFirst(value + "', '", "");
        temp = temp.replaceFirst("mass': '", "");
        if (value.equals("unknown"))
            setAltura(0);
        else
            setAltura(Integer.parseInt(value));
        
        value = temp.substring(0, temp.indexOf("'"));
        temp = temp.replaceFirst(value + "', '", "");
        temp = temp.replaceFirst("hair_color': '", "");
        if (value.equals("unknown"))
            setPeso(0.0);
        else
            setPeso(Double.parseDouble(value.replaceAll(",", ".")));
        
        value = temp.substring(0, temp.indexOf("'"));
        temp = temp.replaceFirst(value + "', '", "");
        temp = temp.replaceFirst("skin_color': '", "");
        setCorDoCabelo(value);
        
        value = temp.substring(0, temp.indexOf("'"));
        temp = temp.replaceFirst(value + "', '", "");
        temp = temp.replaceFirst("eye_color': '", "");
        setCodDaPele(value);
        
        value = temp.substring(0, temp.indexOf("'"));
        temp = temp.replaceFirst(value + "', '", "");
        temp = temp.replaceFirst("birth_year': '", "");
        setCorDosOlhos(value);
        
        value = temp.substring(0, temp.indexOf("'"));
        temp = temp.replaceFirst(value + "', '", "");
        temp = temp.replaceFirst("gender': '", "");
        setAnoNascimento(value);
        
        value = temp.substring(0, temp.indexOf("'"));
        temp = temp.replaceFirst(value + "', '", "");
        temp = temp.replaceFirst("homeworld': '", "");
        setGenero(value);
        
        value = temp.substring(0, temp.indexOf("'"));
        temp = temp.replaceFirst(value + "', '", "");
        setHomeWorld(value);
    }
}


     class Arq{
   private static String nomeArquivo = "";
   private static String charsetArquivo = "ISO-8859-1";
   private static boolean write = false, read = false;
   private static Formatter saida = null;
   private static Scanner entrada = null;

	public static boolean openWrite(String nomeArq, String charset) {
      boolean resp = false;
      close();
		try{
		   saida = new Formatter(nomeArq, charset);
         nomeArquivo = nomeArq;
         resp = write = true;
		}  catch (Exception e) {}
      return resp;
   }

	public static boolean openWrite(String nomeArq) {
      return openWrite(nomeArq, charsetArquivo);
   }

	public static boolean abrirArquivo(String nomeArq, String charset, String conteudo) {
      boolean resp = openWrite(nomeArq, charset);
      if(resp == true){
         println(conteudo);
         close();
      }
      return resp;
   }

	public static boolean abrirArquivo(String nomeArq, String conteudo) {
      return abrirArquivo(nomeArq, charsetArquivo, conteudo);
   }

	public static boolean openRead(String nomeArq) {
      return openRead(nomeArq, charsetArquivo);
   }

	public static boolean openRead(String nomeArq, String charset) {
      boolean resp = false;
      close();
		try{
         entrada = new Scanner(new File(nomeArq), charset);
         nomeArquivo = nomeArq;
         resp = read = true;
		}  catch (Exception e) {}
      return resp;
   }

   public static String openReadClose(String nomeArq){
      openRead(nomeArq);
      String resp = readAll();
      close();
      return resp;
   }

	public static void close() {
      if(write == true){
         saida.close();
      }
      if(read == true){
         entrada.close();
      }
      write = read = false;
      nomeArquivo = "";
      charsetArquivo = "ISO-8859-1";
	}

   public static long length(){
      long resp = -1;
      if(read != write){
         File file = new File(nomeArquivo);
         resp = file.length();
      }
      return resp;
   }

   public static void print(int x){
      if(write == true){
		   saida.format( "%d", x);
      }
   }

   public static void print(double x){
      if(write == true){
	   	saida.format( "%f", x);
      }
   }

   public static void print(String x){
      if(write == true){
   		saida.format( "%s", x);
      }
   }

   public static void print(boolean x){
      if(write == true){
		   saida.format( "%s", ((x) ? "true" : "false"));
      }
   }

   public static void print(char x){
      if(write == true){
	   	saida.format( "%c", x);
      }
   }

   public static void println(int x){
      if(write == true){
   		saida.format( "%d\n", x);
      }
   }

   public static void println(double x){
      if(write == true){
		   saida.format( "%f\n", x);
      }
   } 

   public static void println(String x){
      if(write == true){
	   	saida.format( "%s\n", x);
      }
   }

   public static void println(boolean x){
      if(write == true){
   		saida.format( "%s\n", ((x) ? "true" : "false"));
      }
   }

   public static void println(char x){
      if(write == true){
		   saida.format( "%c\n", x);
      }
   } 

   public static int readInt(){
      int resp = -1;
		try{
         resp = entrada.nextInt();
		}  catch (Exception e) {}
      return resp;
   }

   public static char readChar(){
      char resp = ' ';
		try{
         resp = (char)entrada.nextByte();
		}  catch (Exception e) {}
      return resp;
   }

   public static double readDouble(){
      double resp = -1;
		try{
         resp = Double.parseDouble(readString().replace(",","."));
		}  catch (Exception e) {}
      return resp;
   }

   public static String readString(){
      String resp = "";
		try{
         resp = entrada.next();
		}  catch (Exception e) { System.out.println(e.getMessage()); }
      return resp;
	}

   public static boolean readBoolean(){
      boolean resp = false;
		try{
         resp = (entrada.next().equals("true")) ? true : false;
		}  catch (Exception e) {}
      return resp;
	}

   public static String readLine(){
      String resp = "";
		try{
         resp = entrada.nextLine();
		}  catch (Exception e) { System.out.println(e.getMessage()); }
      return resp;
	}


   public static boolean hasNext(){
      return entrada.hasNext();
   }

   public static String readAll(){
      String resp = "";
      while(hasNext()){
         resp += (readLine() + "\n");
      }
      return resp;
   }
}