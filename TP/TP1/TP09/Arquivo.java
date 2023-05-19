import java.io.RandomAccessFile;
import java.util.*;

class Arquivo{
    
    public static void main(String[] args) throws Exception{ //exceção 

        int n = MyIO.readInt(); 
        double r;

        RandomAccessFile raf = new RandomAccessFile("arq.txt", "rw"); // criando arquivo 

        for(int i = 0; i < n; i++){
            r = MyIO.readDouble();
            raf.writeDouble(r);
        }

        raf.close(); // fechando
        raf = new RandomAccessFile("arq.txt", "r"); //criando arquivo

        for(int i = n -1; i >=0; i--){

            raf.seek(i * 8);
            double num = raf.readDouble();

            if(num == (int)num){

                MyIO.println((int)num);
            }else{

                MyIO.println(num);
            }
        }
        raf.close(); //fechando
    }
}