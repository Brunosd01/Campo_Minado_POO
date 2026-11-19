import java.util.Random;

public class Bomba {

    // Recebe a matriz já modificada pela AreaSegura
    public void espalharBombas(int[][] matriz) {
        Random rand = new Random();
        int bombasColocadas = 0;
        int totalBombas = 5; // Quantidade de minas no tabuleiro

        while (bombasColocadas < totalBombas) {
            int l = rand.nextInt(8);
            int c = rand.nextInt(8);

            // Verifica se o espaço está vazio (0 significa que não é área segura e não tem bomba)
            if (matriz[l][c] == 0) {
                matriz[l][c] = 2; // Coloca a bomba (representada pelo número 2)
                bombasColocadas++;
            }
        }
    }

    public void bombasNoCampo (int[][] matriz){
        System.out.println();
        System.out.println("                    CAMPO MINADO");
        System.out.println();
        System.out.println("           1      2      3      4      5      6      7      8");
        System.out.println("       ┌──────┬──────┬──────┬──────┬──────┬──────┬──────┬──────┐");

        for (int i = 0; i < 8; i++) {
            System.out.print("   " + (i + 1) + "   │");

            for (int j = 0; j < 8; j++) {

                if (matriz[i][j] == 0) {
                    System.out.print("  □   │");
                } else if (matriz[i][j] == 2) {
                    System.out.print("  ⊗   │");
                } else if (matriz[i][j] == 1) {
                    System.out.print("      │");
                }
                else if (matriz[i][j] == 3) {
                    System.out.print("  ⚑   │");
                } else if (matriz[i][j] == 4) {
                    System.out.print("  ⊗   │");
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
}