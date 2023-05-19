public class Palindromo{
    public static void main(String[] args){
        String entrada = MyIO.readLine();
        int tamanho = entrada.length();
        boolean aPalindromo;
        
        while(!strComp(entrada)){  
            aPalindromo = aPalindromo(entrada, tamanho);
            escrever(aPalindromo);
            entrada = MyIO.readLine();
            tamanho = entrada.length();          
        }
    }


    public static boolean aPalindromo(String frase, int tamanho){  // palindromo
        boolean aPalindromo = true;
        int iaux = --tamanho;  
        for(int i = 0; i < tamanho; i++){
            if(frase.charAt(i) != frase.charAt(iaux)){
                aPalindromo = false;
                i = tamanho;
            }
            iaux--;
        }
        return aPalindromo;
    }

    public static void escrever(boolean aPalindromo){  // palindromo = sim 
        if(aPalindromo){                               // não é palindromo = nao
            MyIO.println("SIM");
        }
        else{
            MyIO.println("NAO");
        }
    }

    public static boolean strComp(String teste){  //fim
        boolean ehFim = true;
        String FIM = "FIM";

        for(int i = 0; i < 3; i++){ //leitura do fim
            if(FIM.charAt(i) != teste.charAt(i)){
                ehFim = false;
                i = 3;
            }
        }
        return ehFim;
    }
}