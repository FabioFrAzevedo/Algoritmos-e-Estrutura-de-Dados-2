public class CifraDeCesar{
    public static void main(String[] args){
        String entrada;
        short cifra = 3; //chave de ciframento 3
        entrada = MyIO.readLine();

        while(!strComp(entrada)){  // scanner

            cifrar(entrada, cifra);
            entrada = MyIO.readLine();
        }
    }

    public static void cifrar(String texto, short cifra){  // 
        int tam = texto.length();
        char cifrac; // cifrado

        for(short i = 0; i < tam; i++){ //descriptografia
            cifrac = (char)(texto.charAt(i) + cifra);  
            MyIO.print(cifrac);
        }

        MyIO.println(""); //saida descriptografada
    }

    public static boolean strComp(String teste){  // FIM
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
    

