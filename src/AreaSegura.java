import java.util.Random;

public class AreaSegura {


    public void gerarArea(int[][] matriz, int linha, int coluna) {

        // Comprimento aleatório da área
        Random rand = new Random();
        //int xAlea = rand.nextInt(5) + 4;// 4 até 8
        int xAlea = rand.nextInt(3) + 6;
        int inicio;
        int fim;

        // Tenta colocar a bandeira no meio da área
        if (coluna - (xAlea / 2) >= 0 && coluna + (xAlea / 2) < 8) {

            inicio = coluna - (xAlea / 2);
            fim = inicio + xAlea - 1;
        }
        // Se não couber para os dois lados,
        // tenta colocar a área para a esquerda
        else if (coluna - (xAlea - 1) >= 0) {
            fim = coluna;
            inicio = fim - xAlea + 1;
        }
        // Se não couber para a esquerda,
        // coloca a área para a direita
        else {
            System.out.println();
            inicio = coluna;
            fim = inicio + xAlea - 1;
            // Segurança contra ultrapassar a matriz
            if (fim >= 8) {
                fim = 7;
                inicio = fim - xAlea + 1;
            }
        }

        for (int colunaAtual = inicio; colunaAtual <= fim; colunaAtual++) {
            matriz[linha][colunaAtual] = 1;

            //int yAlea = rand.nextInt(3) + 1;
            int yAlea = rand.nextInt(3) + 3;

            // Divide aleatoriamente entre cima e baixo
            int cima = rand.nextInt(yAlea + 1);
            int baixo = yAlea - cima;
            // Casas acima

            for (int j = 1; j <= cima; j++) {

                if (linha - j >= 0) {
                    matriz[linha - j][colunaAtual] = 1;
                }
            }
            // Casas abaixo
            for (int j = 1; j <= baixo; j++) {

                if (linha + j < 8) {
                    matriz[linha + j][colunaAtual] = 1;
                }
            }
        }
    }



}