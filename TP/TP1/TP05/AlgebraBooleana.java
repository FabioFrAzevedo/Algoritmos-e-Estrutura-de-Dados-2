
public class AlgebraBooleana{
		public static void main(String[] args){
      		String entrada;

		boolean resultado, pararLeitura = false;
		do {			
			entrada = MyIO.readLine("");
			if (entrada.length() == 1 && entrada.charAt(0) == '0') {
				pararLeitura = true;
			}else{
				resultado = verificarExpressao(entrada);
				lehResultado(resultado);
			}
		} while ( pararLeitura == false );
	}

	public static boolean verificarExpressao(String entrada) {
		boolean resp = true;
		int numExpr = entrada.charAt(0) - 48;
		int expr[] = new int[numExpr];
	
		expr = recuperarValores(entrada,numExpr);
		entrada = ajustarExpressaoEsubstituirValores(entrada,expr);
		entrada = substituirNandsEnors(entrada);
		do { 
			entrada = substituirAndsEors(entrada);				
		} while(entrada.length() != 1);
		if (entrada.charAt(0) == '0') 
			resp = false;
		return resp;
	}
	
	public static int[] recuperarValores(String entrada, int numExpr){	
		int expr[] = new int[numExpr];

		for ( int i = 2, j = 0; i < (numExpr * 2) + 1 ; i += 2 , j++) {
			expr[j] = (int)entrada.charAt(i) - 48;
		}
		return expr;
	}

	public static String ajustarExpressaoEsubstituirValores(String entrada, int[] expr){
		String novaExpressao = "";
		
		for (int i = posInicioExpressao(entrada,expr.length); i < entrada.length(); i++){
			if (ehVariavel(entrada,i) == true){
				novaExpressao += expr[(int)entrada.charAt(i) - 65];
			}else if(  not(entrada,i) == true && ehVariavel(entrada,i + 4) == true ){
				i += 4;
				novaExpressao += operacaoNot(expr[(int)entrada.charAt(i) - 65]); 
				i += 1;
			}else if (entrada.charAt(i) != ' '){
				novaExpressao += entrada.charAt(i);
			}
		}
		return novaExpressao;
	}

	public static String substituirNandsEnors(String entrada) {
		String novaExpressao = "";
		int expr[];
		
		for ( int i = 0; i < entrada.length() ; i++ ){
			if ( not(entrada,i) == true ){
				i += 4;
				if ( and(entrada,i) == true ){
					i += 4;
					novaExpressao += operacaoNot(operacaoAnd(organizarValores(entrada,i)));
					i += posFimExpressao(entrada,i) + 2 ;
				}else if ( or(entrada,i) == true ){
					i += 3;
					novaExpressao += operacaoNot(operacaoOr(organizarValores(entrada,i)));
					i += posFimExpressao(entrada,i) + 2 ;
				}	
			}else{
				novaExpressao += entrada.charAt(i);
			}
		}
		return novaExpressao;
	}

	public static String substituirAndsEors(String entrada){ 
		String novaExpressao = "";
		for ( int i = 0 ; i < entrada.length(); i++){
			if ( and(entrada,i) == true && temExpressao(entrada,i + 4) == false ){
				i += 4;
				novaExpressao += operacaoAnd(organizarValores(entrada,i));
				i += posFimExpressao(entrada,i) + 1 ;
			}else if ( or(entrada,i) == true && temExpressao(entrada,i + 3) == false ){
				i += 3;
				novaExpressao += operacaoOr(organizarValores(entrada,i));
				i += posFimExpressao(entrada,i) + 1 ;
			}else {
				novaExpressao += entrada.charAt(i);
			}
		}
		return novaExpressao;
	}

	public static boolean not(String entrada,int pos){
		return (entrada.charAt(pos) == 'n' && entrada.charAt(pos + 1) == 'o' && entrada.charAt(pos + 2) == 't');	
	}

	public static boolean and(String entrada,int pos){
		return (entrada.charAt(pos) == 'a' && entrada.charAt(pos + 1) == 'n' && entrada.charAt(pos + 2) == 'd');	
	}

	public static boolean or(String entrada,int pos){
		return (entrada.charAt(pos) == 'o' && entrada.charAt(pos + 1) == 'r');	
	}

	public static int operacaoNot(int entrada){
		int saida;
		if( entrada == 0){
			saida = 1;
		}else{
			saida = 0;
		}
		return saida;			
	}

	public static int[] organizarValores(String entrada, int pos){
		int[] vet;
		int fim = posFimExpressao(entrada,pos)+pos + 1,tamVetor = 0;

		for (int i = pos ; i < fim; i++){ 
			if (ehVariavel(entrada,i) == true)
				tamVetor++; 		
		} 

		vet = new int[tamVetor];
		for (int i = 0 ; pos < fim; pos++){
			if ( ehVariavel(entrada,pos) == true ){
				vet[i] = (int)entrada.charAt(pos) - 48;
				i++;			
			}						
		} 	
		return vet;
	}

	public static int operacaoAnd(int[] valores){
		int saida = 1;
		for (int i = 0; i < valores.length ; i++){
			if (valores[i] == 0){
				saida = 0;
				i = valores.length;	
			}
		}
		return saida;	
	}

	public static int operacaoOr(int[] valores){
		int saida = 1, contadorDe0 = 0;
		for (int i = 0; i < valores.length ; i++){
			if (valores[i] == 0){
				contadorDe0++;
			}
		}
			if (contadorDe0 == valores.length) {
			saida = 0;
		}
		return saida;	
	}

	public static boolean ehVariavel(String entrada,int pos){
		return ((entrada.charAt(pos) >= 'A' && entrada.charAt(pos) <= 'Z') || 
			entrada.charAt(pos) == '0' || entrada.charAt(pos) == '1' );	
	}

	public static int posInicioExpressao(String entrada, int numExpr){
		int pos = 0,whitespaces = 0;
		while( whitespaces != (numExpr + 1) ){
			if ( entrada.charAt(pos) == ' ' ) 
				whitespaces++;
	
			pos++;				
		}
		return pos;
	}

	public static boolean temExpressao(String entrada, int pos){
		boolean resultado = false;
		for ( /**/; pos < entrada.length() ; pos++){			
			if ( entrada.charAt(pos) == '(' ) {
				resultado = true;
				pos = entrada.length();
			}			
		}
		return resultado;
	}

	public static int posFimExpressao(String entrada, int pos){
		int saida;		
		for ( saida = 0 ; entrada.charAt(pos+1) != ')' ; saida++,pos++);
		return saida;
	}

	public static void lehResultado(boolean saida) {
		if (saida == true) {
			MyIO.println("1");
		}else {
			MyIO.println("0");
		}
	}	
}				