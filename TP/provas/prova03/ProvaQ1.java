
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Candidato {
    String nome;
    String escolha;
}

public class ProvaQ1 {
    public static void main(String[] args) {
        Candidato[] candidato = new Candidato[10000];
        String esc = "";
        int i, j, escolhido;

        Scanner scanner = new Scanner(System.in);

        for (i = 0; true; i++) {
            candidato[i] = new Candidato();
            candidato[i].nome = scanner.next();
            candidato[i].escolha = scanner.nextLine();


            if (candidato[i].nome.equals("FIM"))
                break;
        }

        for (j = escolhido = 0; j < i; j++) {
            if (candidato[escolhido].escolha.equals("YES")) {
                if (j + 1 < i && candidato[j + 1].escolha.equals("YES") && candidato[escolhido].nome.length() < candidato[j + 1].nome.length())
                    escolhido = j + 1;
            } else {
                escolhido++;
                j++;
            }
        }

        esc = candidato[escolhido].nome;

        Arrays.sort(candidato, 0, i, new Comparator<Candidato>() {
            @Override
            public int compare(Candidato o1, Candidato o2) {
                if (o1.escolha.equals(o2.escolha))
                    return o1.nome.compareTo(o2.nome);
                else
                    return o2.escolha.compareTo(o1.escolha);
            }
        });

        System.out.println(candidato[0].nome);

        for (j = 1; j < i; j++) {
            if (!candidato[j].nome.equals(candidato[j - 1].nome))
                System.out.println(candidato[j].nome);
        }

        System.out.println("\nAmigo do Habay:\n" + esc);
    }
}
