
public class Palindromo{
    public static void main(String[] args){

        String entrada = MyIO.readLine();
        int tamanho = entrada.length();
        boolean simPalindromo;
        

        while(!strComp(entrada)){  //Repetir execucao do programa enquanto nao for escrito "FIM"

            simPalindromo = simPalindromo(entrada, tamanho);

            escrever(simPalindromo);

            entrada = MyIO.readLine();
            tamanho = entrada.length();
            
        }

    }


    public static boolean simPalindromo(String frase, int tamanho){  //Funcao para testar se uma palavra eh palindromo
        boolean simPalindromo = true;
        int iaux = --tamanho;  //Se a palavra tem 3 letras significa que ela vai de 0 ate 2


        for(int i = 0; i < tamanho; i++){
            if(frase.charAt(i) != frase.charAt(iaux)){
                simPalindromo = false;
                i = tamanho;
            }
            iaux--;
        }

        return simPalindromo;
    }


    public static void escrever(boolean simPalindromo){  //Funcao para escrever na tela se eh palindromo
        if(simPalindromo){
            MyIO.println("SIM");
        }
        else{
            MyIO.println("NAO");
        }
    }


    public static boolean strComp(String teste){  //Funcao para terminar a execucao do programa ao ser lido "FIM"
        boolean naoPalindromo = true;
        String FIM = "FIM";

        for(int i = 0; i < 3; i++){
            if(FIM.charAt(i) != teste.charAt(i)){
                naoPalindromo = false;
                i = 3;
            }
        }

        return naoPalindromo;
    }
}