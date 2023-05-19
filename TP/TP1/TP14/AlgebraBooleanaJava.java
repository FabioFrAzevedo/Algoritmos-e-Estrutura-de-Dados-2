public class AlgebraBooleanaJava {
    public static int first(String s) {
        return first(s, 0);
    }
    
    public static int last(String s) {
    
      int not = s.lastIndexOf("not");
      int and = s.lastIndexOf("and");
      int or = s.lastIndexOf("or");
    
      if (not > and && not > or) {
          return not;
      } else if (and > not && and > or) {
    
          return and;
      } else if (or > not && or > and) {
    
          return or;
      }
    
      return 0;
    }
    public static int first(String s, int begin) {
        for (int i = begin; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                return i;
            }
        }
        return 0;
    }
      public static void main(String[] args) {   
        while(true){
          int N = MyIO.readInt();
          if(N==0){
            break;
          }
          int[] array = new int[N];
          for(int i=0;i<N;i++){
            array[i] = MyIO.readInt();
          }
          String expressao=MyIO.readLine();
          if (expressao.charAt(expressao.length() - 1) == ' ') {
            expressao = expressao.substring(0, expressao.length() - 1);
          }
          for(int i=0;i<N;i++){
            if (i == 0) {
    
              expressao = expressao.replace("not(A)", array[0] == 0 ? "1" : "0");
              expressao = expressao.replace("A", array[0] == 0 ? "0" : "1");
          } else if (i == 1) {
    
              expressao = expressao.replace("not(B)", array[1] == 0 ? "1" : "0");
              expressao = expressao.replace("B", array[1] == 0 ? "0" : "1");
          } else if (i == 2) {
    
              expressao = expressao.replace("not(C)", array[2] == 0 ? "1" : "0");
              expressao = expressao.replace("C", array[2] == 0 ? "0" : "1");
          }
          }
            while(expressao.length()>1){
              int last = last(expressao);
              String exp = expressao.substring(last, expressao.indexOf(")", last) + 1);
              if (exp.charAt(0) != 'n') {
                int count = 1;
                      for (int x=0;x<exp.length();x++) {
                        if (exp.charAt(x) == ',') {
                          count++;
                        }
                      }
                      int[] p = new int[count];
                      int pos = 0;
                      for (int x = 0; x < count; x++) {
                        pos = first(exp, pos);
                        String num = exp.substring(pos, ++pos);
                        p[x] = Integer.parseInt(num);
                      }
                      if (exp.charAt(0) == 'a') {
                          String resp = "1";
                            if (count == 1) {
                                resp = String.format("%i", p[0]);
                            } else {
                                for (int i = 0; i < count; i++) {
                                  if (p[i] == 0) {
                                    resp = "0";
                                    break;
                                  }
                                }
                            }
                            expressao = expressao.replace(exp, resp);
                        } else if (exp.charAt(0) == 'o') {
    
                            String resp = "0";
    
                            if (count == 1) {
    
                                resp = String.format("%i", p[0]);
                            } else {
    
                                for (int i = 0; i < count; i++) {
    
                                    if (p[i] == 1) {
    
                                        resp = "1";
                                        break;
                                    }
                                }
                            }
                            expressao = expressao.replace(exp, resp);
                        }
                    } else {
                        if (exp.equals("not(0)")) {
    
                            expressao = expressao.replace("not(0)", "1");
                        } else if (exp.equals("not(1)")) {  
                            expressao = expressao.replace("not(1)", "0");
                        }
                    }     
            }
            MyIO.println(expressao);
        }     
    }
}