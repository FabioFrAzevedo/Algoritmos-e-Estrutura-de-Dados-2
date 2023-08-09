import java.util.Scanner;

class ListaNo {
    int valor;
    ListaNo prox;
}

class ListaEncadeada {
    ListaNo lista;
}

class TabelaHash {
    int n;
    ListaEncadeada[] tabela;
}

public class provaq02 {
    public static void inicializaLista(ListaEncadeada l) {
        l.lista = null;
    }

    public static void destroiNo(ListaNo p) {
        if (p.prox != null) {
            destroiNo(p.prox);
        }

        p = null;
    }

    public static void destroiLista(ListaEncadeada l) {
        if (l.lista != null) {
            destroiNo(l.lista);
        }
    }

    public static ListaNo adicionaNo(ListaNo p, int valor) {
        if (p == null) {
            ListaNo novo = new ListaNo();
            novo.valor = valor;
            novo.prox = null;

            return novo;
        } else {
            p.prox = adicionaNo(p.prox, valor);
            return p;
        }
    }

    public static void adicionaElemento(ListaEncadeada l, int valor) {
        if (l.lista == null) {
            inicializaLista(l);
        }

        l.lista = adicionaNo(l.lista, valor);
    }

    public static void imprimeLista(ListaEncadeada l) {
        ListaNo p = l.lista;

        while (p != null) {
            System.out.print(p.valor + " -> ");
            p = p.prox;
        }

        System.out.println("\\");
    }

    public static void inicializaTabelaHash(TabelaHash tabela, int n) {
        tabela.n = n;
        tabela.tabela = new ListaEncadeada[n];

        for (int i = 0; i < n; ++i) {
            tabela.tabela[i] = new ListaEncadeada();
            inicializaLista(tabela.tabela[i]);
        }
    }

    public static void destroiTabelaHash(TabelaHash tabela) {
        for (int i = 0; i < tabela.n; ++i) {
            destroiLista(tabela.tabela[i]);
        }

        tabela.n = 0;
        tabela.tabela = null;
    }

    public static int funcaoHash(TabelaHash tabela, int valor) {
        return valor % tabela.n;
    }

    public static void adicionaElementoTabela(TabelaHash tabela, int valor) {
        int indice = funcaoHash(tabela, valor);
        adicionaElemento(tabela.tabela[indice], valor);
    }

    public static void imprimeTabelaHash(TabelaHash tabela) {
        for (int i = 0; i < tabela.n; ++i) {
            System.out.print(i + " -> ");
            imprimeLista(tabela.tabela[i]);
        }
    }

    public static void main(String[] args) {
        int N, M, C, numero;
        TabelaHash th = new TabelaHash();

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        for (int k = 0; k < N; ++k) {
            if (k > 0) {
                System.out.println();
            }

            M = scanner.nextInt();
            C = scanner.nextInt();

            inicializaTabelaHash(th, M);

            for (int i = 0; i < C; ++i) {
                numero = scanner.nextInt();
                adicionaElementoTabela(th, numero);
            }

            imprimeTabelaHash(th);
        }
    }
}
