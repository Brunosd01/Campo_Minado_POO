public class Campo {
    AreaSegura areaSegura;
    Bomba bomba;
    Numeracao numeracao;
    int[][] campo = new int[8][8];

    public Campo(int linhaDigitada, int colunaDigitada){
        int linhaReal = linhaDigitada - 1;
        int colunaReal = colunaDigitada - 1;

        // 1. Instancia e manda a AreaSegura desenhar os "1"s na matriz
        this.areaSegura = new AreaSegura();
        this.areaSegura.gerarArea(this.campo, linhaReal, colunaReal);

        // 2. Instancia e manda a Bomba colocar os "2"s nos espaços que sobraram como "0"
        this.bomba = new Bomba();
        this.bomba.espalharBombas(this.campo);

        this.numeracao = new Numeracao();
    }

    public int cordenadasBandeira (int linhaDigitada, int colunaDigitada){
        int linhaReal = linhaDigitada - 1;
        int colunaReal = colunaDigitada - 1;
        if (campo[linhaReal][colunaReal] == 0){
            campo[linhaReal][colunaReal] = 3;
            return 1;
        } else if (campo[linhaReal][colunaReal] == 1 || campo[linhaReal][colunaReal] == 3 || campo[linhaReal][colunaReal] == 4) {
            if (campo[linhaReal][colunaReal] == 3 || campo[linhaReal][colunaReal] == 4){
                System.out.println("Selecione um quadrado que ainda não tenha uma bandeira.");
            }else {
                System.out.println("Selecione um quadrado que não esteja liberado.");
            }
            return 2;
        } else if (campo[linhaReal][colunaReal] == 2){
            campo[linhaReal][colunaReal] = 4;
            return 1;
        }
        return 2;
    }

    public boolean bombasMarcadas(){
        int contadorDeBombasMarcadas = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // No seu código, a bomba (2) com bandeira vira 4
                if(campo[i][j] == 4){
                    contadorDeBombasMarcadas++;
                }
            }
        }
        return contadorDeBombasMarcadas == 5;
    }

    public int cordenadasQuadrado(int linhaDigitada, int colunaDigitada){
        int linhaReal = linhaDigitada - 1;
        int colunaReal = colunaDigitada - 1;

        if(campo[linhaReal][colunaReal] == 1){
            System.out.println("Esse quadrado já está liberado, digite uma cordenada valida.");
            return 1;
        }
        else if (campo[linhaReal][colunaReal] == 0){
            campo[linhaReal][colunaReal] = 1;
            return 2;
        }
        else {
            // Retorna 0 quando acertar uma bomba
            return 0;
        }
    }


    public void matriz() {
        System.out.println();
        System.out.println("                    CAMPO MINADO");
        System.out.println();
        System.out.println("           1      2      3      4      5      6      7      8");
        System.out.println("       ┌──────┬──────┬──────┬──────┬──────┬──────┬──────┬──────┐");

        for (int i = 0; i < 8; i++) {
            System.out.print("   " + (i + 1) + "   │");

            for (int j = 0; j < 8; j++) {

                // Lógica de visualização do mapa
                if (campo[i][j] == 0 || campo[i][j] == 2) {
                    // 0 = Vazio, 2 = Bomba (Fica escondida como vazio)
                    System.out.print("  □   │");
                }
                else if (campo[i][j] == 1) {
                    // 1 = Liberado / Seguro
                    int quantidadeBombas = numeracao.contarBombas(campo, i, j);

                    if (quantidadeBombas == 0) {
                        // Se não tem bombas perto, deixa um espaço vazio
                        // (visual clássico do Campo Minado)
                        System.out.print("      │");
                    } else {
                        // Imprime a numeração calculada pela POO
                        System.out.print("  " + quantidadeBombas + "   │");
                    }
                }
                else if (campo[i][j] == 3 || campo[i][j] == 4) {
                    // 3 e 4 = Bandeiras
                    System.out.print("  ⚑   │");
                }
            }

            System.out.println();

            if (i < 7) {
                System.out.println("       ├──────┼──────┼──────┼──────┼──────┼──────┼──────┼──────┤");
            }
        }

        System.out.println("       └──────┴──────┴──────┴──────┴──────┴──────┴──────┴──────┘");
        System.out.println();
    }

    public void mostrarBombas() {
        this.bomba.bombasNoCampo(this.campo);
    }

}

