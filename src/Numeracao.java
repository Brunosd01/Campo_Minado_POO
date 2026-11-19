public class Numeracao {

    // Metodo que recebe a matriz do campo
    public int contarBombas(int[][] matriz, int linha, int coluna) {
        int contador = 0;

        // Percorre as linhas ao redor (em cima, no meio e embaixo)
        for (int i = linha - 1; i <= linha + 1; i++) {

            // Percorre as colunas ao redor (esquerda, meio e direita)
            for (int j = coluna - 1; j <= coluna + 1; j++) {

                // Validação de segurança: Impede que a busca saia dos limites da matriz 8x8
                if (i >= 0 && i < 8 && j >= 0 && j < 8) {

                    // Verifica se a posição ao redor é uma bomba.
                    // 2 = Bomba oculta, 4 = Bomba com bandeira
                    if (matriz[i][j] == 2 || matriz[i][j] == 4) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }
}