public class PalindromoRecursivo{
    public static void main(String[] args){

        String entrada = MyIO.readLine();  //entrada
        int tamanho = entrada.length(); 
        boolean aPalindromo;
        

        while(!strComp(entrada)){  //comparação

            aPalindromo = aPalindromo(entrada, tamanho-1, 0);  

            escrever(aPalindromo);

            entrada = MyIO.readLine(); // leitura
            tamanho = entrada.length(); 
            
        }

    }

    public static boolean aPalindromo(String frase, int tamanho, int pos){  
        boolean aPalindromo = true; 
        char letra1;
        char letra2;
        
        if(tamanho > pos){ 
            letra1 = frase.charAt(tamanho);
            letra2 = frase.charAt(pos);
            if(letra1 != letra2){
                aPalindromo = false;
                tamanho = pos;
            }else{
                aPalindromo = aPalindromo(frase, tamanho-1, pos+1);
            }
        }
        return aPalindromo;
    }

    public static void escrever(boolean aPalindromo){  
        if(aPalindromo){
            MyIO.println("SIM");  // se for = saida na tela "sim"
        }else{
            MyIO.println("NAO"); // se não for = saida na tela "nao"
        }
    }


    public static boolean strComp(String teste){  // FIM
        boolean aFim = true;
        String FINAL = "FIM";

        for(int i = 0; i < 3; i++){ // fim
            if(FINAL.charAt(i) != teste.charAt(i)){
                aFim = false;
                i = 3;
            }
        }
        return aFim;
    }
}