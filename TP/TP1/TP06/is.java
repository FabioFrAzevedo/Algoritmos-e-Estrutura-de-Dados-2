public class is{
    public static void main(String[] args){
        String entrada = MyIO.readLine(); // entrada

        while(!strComp(entrada)){ // comparação 
            isOrquestra(entrada);
            entrada = MyIO.readLine(); // leitura 
        }
    }

    public static void isOrquestra(String entrada){  
        
        boolean sVogais = sVogais(entrada); // somente vogais
        boolean sConsoantes = sConsoantes(entrada); // somente consoantes
        boolean inteiros = inteiros(entrada);
        boolean real = real(entrada);

        if(sVogais) {
            MyIO.print("SIM ");
       } else {
            MyIO.print("NAO ");
       } if(sConsoantes) {
            MyIO.print("SIM ");
       } else {
            MyIO.print("NAO ");
       } if(inteiros) {
            MyIO.print("SIM ");
       } else {
            MyIO.print("NAO ");
       } if(real){
            MyIO.print("SIM");
       } else {
            MyIO.print("NAO");
       }
        MyIO.println("");
    }

    public static boolean sVogais(String frase){  
        boolean sVogais = true;
        char letra;

        for(int i = 0; i < frase.length(); i++){
            letra = frase.charAt(i);
            if(letra != 'A' && letra != 'a' && letra != 'E' && letra != 'e' && letra != 'I' && letra != 'i' && letra != 'O' && letra != 'o' && letra != 'U' && letra != 'u'){
                sVogais = false;
                i = frase.length();
            }
        }
        return sVogais;
    }

    public static boolean sConsoantes(String frase){  
        boolean sConsoantes = true;
        char letra;

        for(int i = 0; i < frase.length(); i++){
            letra = frase.charAt(i);
            if(letra == 'A' || letra == 'a' || letra == 'E' || letra == 'e' || letra == 'I' || letra == 'i' || letra == 'O' || letra == 'o' || letra == 'U' || letra == 'u' || letra >= '0' && letra <= '9'){
                sConsoantes = false;
                i = frase.length();
            }
        }  
        return sConsoantes;
    }

    public static boolean inteiros(String frase){  
        boolean inteiros = true;
        char letra;

        for(int i = 0; i < frase.length(); i++){
            letra = frase.charAt(i);
            if(letra >= 'a' && letra <= 'z' || letra >= 'A' && letra <= 'Z' || letra == '.' || letra == ','){
                inteiros = false;
                i = frase.length();
            }
        }
        return inteiros;
    }

    public static boolean real(String frase){  
        boolean real = true;
        char letra;
        int numVirgulas = 0;

        for(int i = 0; i < frase.length(); i++){
            letra = frase.charAt(i);
            if(letra >= 'a' && letra <= 'z' || letra >= 'A' && letra <= 'Z'){
                real = false;
                i = frase.length();
            }
            if(letra == '.' || letra == ','){
                numVirgulas++;
            }
        }
        if(numVirgulas > 1){
            real = false;
        }
        return real;
    }

    public static boolean strComp(String entrada){  // FIM
        boolean ehFim = true; 
        if(entrada.charAt(0) != 'F' || entrada.charAt(1) != 'I' || entrada.charAt(2) != 'M'){
            ehFim = false;
        }
        return ehFim;
    }
}