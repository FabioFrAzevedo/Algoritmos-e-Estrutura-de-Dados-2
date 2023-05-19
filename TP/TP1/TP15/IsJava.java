public class IsJava {
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');}
    
      public static boolean isVogal (String s, int i) {
        s = s.toUpperCase();
    
        if (s.charAt(i) != 'A' && s.charAt(i) != 'E' && s.charAt(i) != 'I' && s.charAt(i) != 'O' && 
        s.charAt(i) != 'U') {
          return false;
        } else if (i == s.length()-1) { 
          return true;
        } else {
          return isVogal(s, i+1);
        }
      }
    
      public static boolean isConsoante (String s, int i) {
        s = s.toUpperCase();
    
        if ((s.charAt(i) != 'A' && s.charAt(i) != 'E' && s.charAt(i) != 'I' && s.charAt(i) != 'O' && 
        s.charAt(i) != 'U') && (s.charAt(i) >= 65 && s.charAt(i) <= 90)) {
          if (i == s.length()-1) {
            return true;
          } else {
            return isConsoante(s, i+1);
          } 
        } else {
          return false;
        }
      }  
    
      public static boolean isInteiro (String s, int i) {
        if ((s.charAt(i) == '0' || s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3' || 
        s.charAt(i) == '4' || s.charAt(i) == '5' || s.charAt(i) == '6' || s.charAt(i) == '7' || 
        s.charAt(i) == '8' || s.charAt(i) == '9') && (s.charAt(i) != ',' && s.charAt(i) != '.')) {
          if (i == s.length()-1) {
            return true;
          } else  { 
            return isInteiro(s, i+1);
          }
        } else {
          return false;
        }
      }
    
      public static boolean isReal (String s, int i) {
        if ((s.charAt(i) == '0' || s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3' || 
        s.charAt(i) == '4' || s.charAt(i) == '5' || s.charAt(i) == '6' || s.charAt(i) == '7' || 
        s.charAt(i) == '8' || s.charAt(i) == '9') && (s.charAt(i) == ',' || s.charAt(i) == '.')) {
          if (i == s.length()-1) {
            return true;
          } else  { 
            return isReal(s, i+1);
          }
        } else {
          return false;
        }
      }
      
      public static void main (String[] args) {
        int i=0;
        String[] entrada = new String[1000];
    
        do{
          entrada[i] = MyIO.readLine();
            if (isVogal(entrada[i], 0) == true) {
              MyIO.print("SIM ");
            } else {
              MyIO.print("NAO ");
            }
    
            if (isConsoante(entrada[i], 0) == true) {
              MyIO.print("SIM ");
            } else {
              MyIO.print("NAO ");
            }
    
            if (isInteiro(entrada[i], 0) == true) {
              MyIO.print("SIM ");
            } else {
              MyIO.print("NAO ");
            }
    
            if (isReal(entrada[i], 0) == true) {
              MyIO.println("SIM ");
            } else {
              MyIO.println("NAO ");
            }
        } while (!(isFim(entrada[i++])));
        i--;
      }
}
