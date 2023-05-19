public class CifraDeCesarRecursiva{
    public static void main(String[] args){
        String entrada;
        short cifra = 3;//chave de ciframento 3
        entrada = MyIO.readLine();

        while(!strComp(entrada)){  

            cifrar(entrada, cifra, entrada.length()-1);
            MyIO.println("");
            entrada = MyIO.readLine();
        }
    }

    public static void cifrar(String texto, short cifra, int pos){  
        char cifrac = (char)(texto.charAt(pos) + cifra);  //cifrado

        if(pos > 0){
            cifrar(texto, cifra, pos-1);
        }
        MyIO.print(cifrac);
    }

    public static boolean strComp(String teste){   //FIM
        boolean ehFim = true;
        String FIM = "FIM";

        for(int i = 0; i < 3; i++){
            if(FIM.charAt(i) != teste.charAt(i)){
                ehFim = false;
                i = 3;
            }
        }
        return ehFim;
    }
}