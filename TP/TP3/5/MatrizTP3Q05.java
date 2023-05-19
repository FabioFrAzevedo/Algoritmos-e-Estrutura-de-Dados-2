class MatrizTP3Q05 {
    public static void main(String[] args) {
        Matriz m1, m2, soma, multiplicacao;
        int tests;
        tests = Integer.parseInt(MyIO.readLine());
        for (int i = 0; i < tests; i++) {
            int linha = Integer.parseInt(MyIO.readLine());
            int coluna = Integer.parseInt(MyIO.readLine());
            m1 = new Matriz(linha, coluna);
            m1.read();
            m1.mostrarDiagonalPrincipal();
            m1.mostrarDiagonalSecundaria();
            linha = Integer.parseInt(MyIO.readLine());
            coluna = Integer.parseInt(MyIO.readLine());
            m2 = new Matriz(linha, coluna);
            m2.read();
            soma = m1.soma(m2);
            soma.print();
            multiplicacao = m1.multiplicacao(m2);
            multiplicacao.print();
        }

    }
}

class Celula {
    public int elemento;
    public Celula inf, sup, esq, dir;

    public Celula() {
        this(0);
    }

    public Celula(int elemento) {
        this(elemento, null, null, null, null);
    }

    public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir) {
        this.elemento = elemento;
        this.inf = inf;
        this.sup = sup;
        this.esq = esq;
        this.dir = dir;
    }
}

class Matriz {
    private Celula inicio;
    private int linha, coluna;

    public Matriz() {
        this(3, 3);
    }

    public Matriz(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        this.inicio = new Celula();
        // alocar a matriz com this.linha linhas e this.coluna colunas
        this.iniciarMatriz();
    }

    public void iniciarMatriz() {
        Celula tmp = this.inicio;
        for (int i = 0; i < this.coluna; i++, tmp = tmp.dir) {
            tmp.dir = new Celula(0, null, null, tmp, null);
        }
        tmp = this.inicio;
        for (int i = 0; i < this.linha; i++, tmp = tmp.inf) {
            tmp.inf = new Celula(0, null, tmp, null, null);
        }

        iniciarMatrizMeio();
    }

    private void iniciarMatrizMeio() {
        Celula atual = inicio.inf;
        for (int i = 1; i < linha; i++, atual = atual.inf) {
            Celula temp = atual;
            for (int j = 1; j < coluna; j++, temp = temp.dir) {
                temp.dir = new Celula(0, null, temp.sup.dir, temp, null);
                temp.sup.dir.inf = temp.dir;
            }
        }
    }

    private Celula getPos(int linha, int coluna) {
        Celula atual = inicio;
        for (int i = 0; i < linha; i++) {
            atual = atual.inf;
        }
        for (int j = 0; j < coluna; j++) {
            atual = atual.dir;
        }
        return atual;
    }

    public Matriz soma(Matriz m) {
        Matriz resp = null;

        if (this.linha == m.linha && this.coluna == m.coluna) {
            resp = new Matriz(this.linha, this.coluna);
            for (int i = 0; i < this.linha; i++) {
                for (int j = 0; j < this.coluna; j++) {
                    Celula a = getPos(i, j);
                    Celula b = m.getPos(i, j);
                    Celula c = resp.getPos(i, j);
                    c.elemento = a.elemento + b.elemento;
                }
            }
        }

        return resp;
    }

    public Matriz multiplicacao(Matriz m) {
        Matriz resp = null;

        if (this.coluna == m.linha) {
            resp = new Matriz(this.linha, m.coluna);
            for (int i = 0; i < resp.linha; i++) {
                for (int j = 0; j < resp.coluna; j++) {
                    int total = 0;
                    for (int k = 0; k < this.coluna; k++) {
                        Celula a = this.getPos(i, k);
                        Celula b = m.getPos(k, j);
                        total += a.elemento * b.elemento;
                    }
                    resp.inserir(i, j, total);
                }
            }
        }

        return resp;
    }

    public void inserir(int linha, int coluna, int valor) {
        Celula atual = inicio;
        for (int i = 0; i < linha; i++) {
            atual = atual.inf;
        }
        for (int j = 0; j < coluna; j++) {
            atual = atual.dir;
        }
        atual.elemento = valor;
    }

    public boolean isQuadrada() {
        return (this.linha == this.coluna);
    }

    public void mostrarDiagonalPrincipal() {
        if (isQuadrada() == true) {
            for (int i = 0; i < this.linha; i++) {
                System.out.print(getPos(i, i).elemento + " ");
            }
            System.out.println();
        }
    }

    public void mostrarDiagonalSecundaria() {
        if (isQuadrada() == true) {
            for (int i = 0; i < linha; i++) {
                for (int j = 0; j < coluna; j++) {
                    if (i + j == linha - 1) {
                        System.out.print(getPos(i, j).elemento + " ");
                    }
                }
            }
            System.out.println();
        }
    }

    public void read() {
        for (int i = 0; i < this.linha; i++) {
            for (int j = 0; j < this.coluna; j++) {
                int elemento = MyIO.readInt();
                inserir(i, j, elemento);
            }
        }
    }

    public void print() {
        for (int i = 0; i < this.linha; i++) {
            for (int j = 0; j < this.coluna; j++) {
                System.out.print(getPos(i, j).elemento + " ");
            }
            System.out.println();
        }
    }
}