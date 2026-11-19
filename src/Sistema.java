import java.util.Scanner;

public class Sistema {

    Scanner entrada = new Scanner(System.in);
    Campo campo;
    boolean jogoAtivo = true;
    public void executar() {
        // Gera uma matriz ilustrativa
        System.out.println();
        System.out.println("                           CAMPO MINADO");
        System.out.println("           1      2      3      4      5      6      7      8");

        System.out.println("       ┌──────┬──────┬──────┬──────┬──────┬──────┬──────┬──────┐");

        for (int i = 0; i < 8; i++) {
            System.out.print("   " + (i + 1) + "   │");
            for (int j = 0; j < 8; j++) {
                System.out.print("  □   │");
            }
            System.out.println();
            if (i < 7) {
                System.out.println("       ├──────┼──────┼──────┼──────┼──────┼──────┼──────┼──────┤");
            }
        }
        System.out.println("       └──────┴──────┴──────┴──────┴──────┴──────┴──────┴──────┘");

        System.out.println("\n");

        // Criacao da area segura
        System.out.println("Para começar, informe um ponto para a criação da área!");

        // Linha
        System.out.print("Linha: ");
        int linha = entrada.nextInt();
        // Tratamento de erros
        while (linha < 1 || linha > 8) {
            System.out.println("A linha " + linha + " não faz parte do campo. Digite um valor valido.");
            System.out.print("Linha: ");
            linha = entrada.nextInt();
        }

        // Coluna
        System.out.print("Coluna: ");
        int coluna = entrada.nextInt();
        // Tratamento de erros
        while (coluna < 1 || coluna > 8) {
            System.out.println("A coluna " + coluna + " não faz parte do campo. Digite um valor valido.");
            System.out.print("Coluna: ");
            coluna = entrada.nextInt();
        }
        System.out.println("\n\n\n\n\n");

        // Criando o objeto Campo e enviando os dados digitados
        campo = new Campo(linha, coluna);

        // loop do jogo
        while (jogoAtivo) {
            // Chama a metodo matriz da classe campo
            campo.matriz();

            // Comandos de acoes no jogo
            System.out.println("Digite 1 para adicionar uma bandeira, 2 para liberar um quadrado ou 0 para sair do jogo.");

            // Acao
            System.out.print("Ação: ");
            int acaoDoJogo = entrada.nextInt();

            // Tratamento de erros
            while (acaoDoJogo < 0 || acaoDoJogo > 2) {
                System.out.println("Digite um número valido.");
                System.out.print("Ação: ");
                acaoDoJogo = entrada.nextInt();
            }

            // Acao 0 no jogo (finalizar)
            if (acaoDoJogo == 0) {
                System.out.println("Jogo Encerrado.");
                jogoAtivo = false; // finaliza o loop
            }
            // Acao 1 no jogo (Colocar uma bandeira)
            else if (acaoDoJogo == 1) {
                do {
                    System.out.println();
                    System.out.println("Digite as coordenadas da bandeira:");

                    System.out.print("Linha: ");
                    linha = entrada.nextInt();

                    // Tratamento de erros
                    while (linha < 1 || linha > 8) {
                        System.out.println("A linha " + linha + " não faz parte do campo. Digite um valor valido.");
                        System.out.print("Linha: ");
                        linha = entrada.nextInt();
                    }

                    System.out.print("Coluna: ");
                    coluna = entrada.nextInt();
                    // Tratamento de erros
                    while (coluna < 1 || coluna > 8) {
                        System.out.println("A coluna " + coluna + " não faz parte do campo. Digite um valor valido.");
                        System.out.print("Coluna: ");
                        coluna = entrada.nextInt();
                    }
                } while (campo.cordenadasBandeira(linha, coluna) == 2);
                System.out.println("\n\n\n\n\n");


                // Condição de Vitória: Verifica se marcou todas as bombas
                if (campo.bombasMarcadas()) {
                    campo.matriz();
                    System.out.println("🏆 PARABÉNS! Você marcou todas as bombas e venceu o jogo!");
                    jogoAtivo = false;
                }

                // Acao 2 no jogo (Colocar um quadrado)
            } else {
                int resultadoQuadrado;
                do {
                    System.out.println("Digite as cordenadas do quadrado: ");
                    System.out.print("Linha: ");
                    linha = entrada.nextInt();
                    // Tratamento de erros
                    while (linha < 1 || linha > 8) {
                        System.out.println("A linha " + linha + " não faz parte do campo. Digite um valor valido.");
                        System.out.print("Linha: ");
                        linha = entrada.nextInt();
                    }

                    System.out.print("Coluna: ");
                    coluna = entrada.nextInt();
                    // Tratamento de erros
                    while (coluna < 1 || coluna > 8) {
                        System.out.println("A coluna " + coluna + " não faz parte do campo. Digite um valor valido.");
                        System.out.print("Coluna: ");
                        coluna = entrada.nextInt();
                    }

                    resultadoQuadrado = campo.cordenadasQuadrado(linha, coluna);

                } while (resultadoQuadrado == 1);
                System.out.println("\n\n\n\n\n");

                // Condição de Derrota
                if (resultadoQuadrado == 0) {
                    System.out.println("\n💥 BOOOM! Você clicou em uma bomba. Fim de jogo!");
                    campo.mostrarBombas();

                    jogoAtivo = false; // finaliza o loop
                }
            }
        }
    }
}
