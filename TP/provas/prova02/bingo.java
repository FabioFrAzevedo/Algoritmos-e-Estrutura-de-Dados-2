import java.util.Scanner;

 public class bingo {
    
    public static String vencedores(int m[][], int[] a){
        int l = m.length;
        int c = m[0].length;
        String retorno = "";
        boolean TorF = false;
        int k =0;
        for(int i = 0; i<l;i++){
            for(int j = 0; j<c;j++){
                if(m[i][j] == a[k]){
                    k = 1;
                    j = 0;
                    }
                    if(k == c-1){
                        retorno+=i+1;
                        retorno+=" ";
                        k = 0;
                        j = 10000;
                    }
                    
                }
            }
            return retorno;
        }
    /*
    * N = quant de cartelas
    * K = tamanho do vetor
    * U = <= a esse numero sera sorteado
    */
    public static void main(String args[]){
        Scanner leitura = new Scanner(System.in);
       
         int N = leitura.nextInt();
         int K = leitura.nextInt();
         int U = leitura.nextInt();
         int m[][] = new int[N][K];

        for(int i = 0; i < N;i++){
            for(int j = 0; j<K;j++){
                m[i][j] = leitura.nextInt();
            }
        }

        int vet[] = new int[10];
        for(int i = 0; i<10;i++){
            vet[i] = 0;
        }
        String resp = "";
        while(resp.length() > 0){
            for(int i = 0; i < U;i++){
                vet[i] = leitura.nextInt();
                if(i >=4){
                    resp = vencedores(m,vet);
                }
            }             
        }

        System.out.println(resp);   
    }
}
