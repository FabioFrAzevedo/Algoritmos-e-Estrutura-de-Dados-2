import java.util.Random;

class AlteracaoAleatoria {
    public static void main(String[] args){
        String entrada = MyIO.readLine(); // leitura da entrada
        Random gerador = new Random(); // gerar random
        gerador.setSeed (4); 
        char[] escolha = new char[2]; // escolher

        while(!strComp(entrada)){      // comparação
            eLetras(entrada, gerador, escolha); 
            aleatorio(entrada, escolha); //aleatorizar
            entrada = MyIO.readLine();            
        }
    }

    public static void eLetras(String frase, Random gerador, char[] escolha){  // escolher
        escolha[0] = (char)('a' + Math.abs(gerador.nextInt()) % 26);
        escolha[1] = (char)('a' + Math.abs(gerador.nextInt()) % 26);
    }

    public static void aleatorio(String frase, char[] escolha){  
        char[] fAleatorizada = new char[1000]; // frase aleatorizada

        for(int i = 0; i < frase.length(); i++){
            if(frase.charAt(i) == escolha[0]){
                fAleatorizada[i] = escolha[1];
            }
            else{
                fAleatorizada[i] = frase.charAt(i);
            }
        }

        for(int i = 0; i < frase.length(); i++){  
            MyIO.print(fAleatorizada[i]);// saida da frase aleatorizada
        }
        MyIO.println("");
    }
    public static boolean strComp(String teste){  // FIM
        boolean ehFim = true;
        String FIM = "FIM";

        for(int i = 0; i < 3; i++){ // leitura do fim
            if(FIM.charAt(i) != teste.charAt(i)){
                ehFim = false;
                i = 3;
            }
        }
        return ehFim;
    }
}
