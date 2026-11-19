import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("========================================" +
                "1" +
                "0" +
                " ====================================================");
        System.out.println("                                     ,--.!,");
        System.out.println("                                  __/   -*-");
        System.out.println("                                ,d08b.  '|`");
        System.out.println("                                0088MM");
        System.out.println("                                `9MMP'");
        System.out.println();
        System.out.println("                   💥 BEM-VINDO AO JOGO DO CAMPO MINADO! 💥");
        System.out.println("============================================================================================");
        System.out.println();
        System.out.print("Digite 1 para começar ou 0 para sair: ");
        int digitando = entrada.nextInt();
        System.out.println("\n\n\n\n\n");

        // Tratamento de erros
        while (digitando != 1 && digitando != 0) {
            System.out.println("Digite um número valido.");
            digitando = entrada.nextInt();
        }
        if(digitando == 1){
            Sistema sistema = new Sistema();
            sistema.executar();
        }
    }
}