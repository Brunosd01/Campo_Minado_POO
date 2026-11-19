#  Campo Minado em Java
 
Jogo de **Campo Minado** para terminal, desenvolvido em **Java** com foco em **Programação Orientada a Objetos (POO)**. O tabuleiro tem tamanho 8x8, possui 5 bombas escondidas e uma **área segura inicial** gerada ao redor da primeira coordenada escolhida pelo jogador.
 
---
 
##  Índice
 
- [Sobre o projeto](#-sobre-o-projeto)
- [Funcionalidades](#-funcionalidades)
- [Como executar](#-como-executar)
- [Como jogar](#-como-jogar)
- [Símbolos do tabuleiro](#-símbolos-do-tabuleiro)
- [Regras de vitória e derrota](#-regras-de-vitória-e-derrota)
- [Estrutura do projeto](#-estrutura-do-projeto)
- [Como o jogo funciona por dentro](#-como-o-jogo-funciona-por-dentro)
- [Melhorias futuras](#-melhorias-futuras)
- [Autor](#-autor)
---
 
##  Sobre o projeto
 
Este projeto recria o clássico Campo Minado em modo texto. Diferente da versão tradicional, aqui o jogador começa informando **um ponto de partida**, e o jogo gera automaticamente uma região segura (sem bombas) em volta dele. Só depois disso as bombas são espalhadas pelas casas restantes, o que garante que a primeira jogada nunca seja perdida.
 
O código foi dividido em classes com responsabilidades bem definidas, aplicando conceitos de encapsulamento, separação de responsabilidades e composição de objetos.
 
---
 
##  Funcionalidades
 
- Tabuleiro **8x8** desenhado no terminal com caracteres Unicode
- **Área segura inicial** com tamanho e formato aleatórios
- **5 bombas** posicionadas aleatoriamente fora da área segura
- **Numeração automática** das casas liberadas (quantidade de bombas vizinhas)
- Sistema de **bandeiras** para marcar suspeitas de bombas
- Validação das coordenadas digitadas (linha e coluna de 1 a 8)
- Mensagens de erro para jogadas inválidas (casa já liberada, casa já com bandeira)
- Revelação de todas as bombas ao perder o jogo
---
 
##  Como executar
 
### Pré-requisitos
 
- [JDK (Java Development Kit)](https://www.oracle.com/java/technologies/downloads/) instalado
- Um terminal com suporte a **UTF-8** (necessário para exibir corretamente os símbolos `□`, `⚑`, `⊗` e as bordas do tabuleiro)
Para conferir se o Java está instalado:
 
```bash
java -version
javac -version
```
 
### Passo a passo
 
1. Clone o repositório:
```bash
git clone https://github.com/SEU-USUARIO/NOME-DO-REPOSITORIO.git
cd NOME-DO-REPOSITORIO
```
 
2. Compile todos os arquivos:
```bash
javac *.java
```
 
3. Execute o jogo:
```bash
java Main
```
 
> 💡 **Dica (Windows):** se os símbolos aparecerem quebrados no CMD ou PowerShell, execute `chcp 65001` antes de iniciar o jogo, ou rode pelo terminal da sua IDE (IntelliJ, VS Code, Eclipse).
 
---
 
##  Como jogar
 
1. Na tela inicial, digite **1** para começar ou **0** para sair.
2. Informe a **linha** e a **coluna** (de 1 a 8) onde a área segura será criada.
3. A cada rodada, escolha uma ação:
| Ação | Comando | Descrição |
|:----:|:-------:|-----------|
| 🚩 Bandeira | `1` | Marca uma casa que você acredita ter uma bomba |
| ✅ Liberar | `2` | Libera uma casa para ver quantas bombas existem ao redor |
| 🚪 Sair | `0` | Encerra o jogo |
 
4. Depois de escolher a ação, digite a **linha** e a **coluna** da casa desejada.
5. Use os números das casas liberadas para deduzir onde estão as bombas.
### Exemplo de tabuleiro
 
```
                    CAMPO MINADO
 
           1      2      3      4      5      6      7      8
       ┌──────┬──────┬──────┬──────┬──────┬──────┬──────┬──────┐
   1   │  □   │      │      │  1   │  □   │  □   │  □   │  □   │
       ├──────┼──────┼──────┼──────┼──────┼──────┼──────┼──────┤
   2   │  □   │      │  1   │  □   │  □   │  ⚑   │  □   │  □   │
       ├──────┼──────┼──────┼──────┼──────┼──────┼──────┼──────┤
   ...
```
 
---
 
##  Símbolos do tabuleiro
 
| Símbolo | Significado |
|:-------:|-------------|
| `□` | Casa ainda não liberada (pode ou não ter bomba) |
| *(vazio)* | Casa liberada sem nenhuma bomba por perto |
| `1` a `8` | Casa liberada com essa quantidade de bombas ao redor |
| `⚑` | Bandeira colocada pelo jogador |
| `⊗` | Bomba (aparece somente ao fim da partida) |
 
---
 
##  Regras de vitória e derrota
 
-  **Vitória:** marcar com bandeira **todas as 5 bombas** do tabuleiro.
-  **Derrota:** liberar uma casa que contenha uma bomba. Ao perder, o tabuleiro é exibido com todas as bombas reveladas.
---
 
## 🗂️ Estrutura do projeto
 
```
📦 campo-minado
 ┣ 📜 Main.java        → Ponto de entrada: tela de boas-vindas e menu inicial
 ┣ 📜 Sistema.java     → Controla o fluxo do jogo, entradas do usuário e validações
 ┣ 📜 Campo.java       → Representa o tabuleiro e as regras (bandeiras, liberar casas, desenho do mapa)
 ┣ 📜 AreaSegura.java  → Gera a região segura inicial ao redor da primeira coordenada
 ┣ 📜 Bomba.java       → Espalha as bombas e exibe o tabuleiro com as bombas reveladas
 ┗ 📜 Numeracao.java   → Calcula quantas bombas existem ao redor de cada casa
```
 
### Responsabilidade de cada classe
 
| Classe | Responsabilidade |
|--------|------------------|
| `Main` | Exibe a tela de boas-vindas e inicia o `Sistema` |
| `Sistema` | Gerencia o loop principal do jogo, lê as entradas e decide vitória/derrota |
| `Campo` | Guarda a matriz do jogo e coordena `AreaSegura`, `Bomba` e `Numeracao` |
| `AreaSegura` | Marca na matriz as casas seguras iniciais |
| `Bomba` | Sorteia as posições das bombas nas casas que sobraram |
| `Numeracao` | Conta as bombas vizinhas (8 direções) de uma casa |
 
---
 
## ⚙️ Como o jogo funciona por dentro
 
O tabuleiro é representado por uma matriz de inteiros `int[8][8]`, em que cada valor indica o estado da casa:
 
| Valor | Estado |
|:-----:|--------|
| `0` | Casa vazia, ainda escondida |
| `1` | Casa segura / já liberada |
| `2` | Bomba escondida |
| `3` | Bandeira sobre uma casa vazia |
| `4` | Bandeira sobre uma bomba |
 
### Geração do tabuleiro
 
1. **Área segura** (`AreaSegura`): a partir do ponto escolhido, sorteia uma largura de **6 a 8 colunas** na linha escolhida. Em cada coluna, a área se expande de **3 a 5 casas** na vertical, dividindo aleatoriamente entre cima e baixo. Se a área não couber centralizada, ela é deslocada para a esquerda ou para a direita, sem ultrapassar os limites da matriz.
2. **Bombas** (`Bomba`): sorteia posições aleatórias e coloca uma bomba (`2`) somente em casas com valor `0`, repetindo até completar 5 bombas.
3. **Numeração** (`Numeracao`): ao desenhar uma casa liberada, percorre as 8 casas vizinhas contando quantas são bombas (valores `2` ou `4`).
---
 
##  Melhorias futuras
 
Ideias para evoluir o projeto:
 
- [ ] Tratar entradas inválidas (letras ou símbolos) com `try/catch` para evitar `InputMismatchException`
- [ ] Limitar a quantidade de bandeiras ao número de bombas, evitando vitória por marcar casas em excesso
- [ ] Permitir remover uma bandeira já colocada
- [ ] Impedir que liberar uma casa com bandeira conte como acerto de bomba
- [ ] Liberação em cascata das casas vazias vizinhas (como no jogo original)
- [ ] Níveis de dificuldade (tamanho do tabuleiro e número de bombas)
- [ ] Contador de tempo e de jogadas
- [ ] Interface gráfica (Swing ou JavaFX)
---
 
##  Autor
 
Desenvolvido por **Bruno Silva Defelicibus**.
 

- LinkedIn: https://www.linkedin.com/in/bruno-silva-64a3162a5/
---

 
