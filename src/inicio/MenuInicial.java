package inicio;

import alimentos.cardapios.Cardapio;
import alimentos.carrinho.FuncoesCarrinho;
import humanos.Cliente;
import humanos.IsCliente;

import java.util.Optional;
import java.util.Scanner;


public class MenuInicial {
    public static double saldo;
    public static boolean isCliente = false;

    static Cliente cliente = null;
    static Scanner scanner = new Scanner(System.in);
    static FuncoesCarrinho funcoesCarrinho = new FuncoesCarrinho();

    public void boasVindas() {
        System.out.println("*****************************************************************");
        System.out.println("                 Bem vindo à padaria Pão Açucarado!             ");
        System.out.println("****************************************************************");
        System.out.println("                                   ___");
        System.out.println("                              ___  //\\");
        System.out.println("                        ___   //\\///\\\\\\        ___");
        System.out.println("                       //\\ ///\\ ////\\\\\\   ___ //\\\\");
        System.out.println("         ___          /  ^ \\/^ ^/^  ^  ^ \\/^ \\/ ^ \\");
        System.out.println("        / ^\\    __  / ^   /  ^/ ^ ^ ^   ^\\ ^/  ^^  \\");
        System.out.println("       /^   \\  / ^\\/ ^ ^   ^ / ^  ^    ^  \\/ ^   ^  \\       *");
        System.out.println("      /  ^ ^ \\/^  ^\\ ^ ^ ^   ^  ^   ^   ____  ^   ^  \\     /|\\");
        System.out.println("     / ^ ^  ^ \\ ^  _\\___________________|  |_____^ ^  \\   /||o\\");
        System.out.println("    / ^^  ^ ^ ^\\  /______________________________\\ ^ ^ \\ /|o|||\\");
        System.out.println("   /  ^  ^^ ^ ^  /________________________________\\  ^  /|||||o|\\");
        System.out.println("  /^ ^  ^ ^^  ^    ||___|___||||||||||||___|__|||      /||o||||||");
        System.out.println(" / ^   ^   ^    ^  ||___|___||||||||||||___|__|||          | |");
        System.out.println("/ ^ ^ ^  ^  ^  ^   ||||||||||||||||||||||||||||||oooooooooo| |ooooooo");
        System.out.println("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");


    }

    public static void menuDeOpcoes() {
        System.out.println("│===================================================================│");
        System.out.println("│                        Menu de Ações                              │");
        System.out.println("│===================================================================│");
        System.out.println("│  1. Menu do cliente          │ 5. Ver o carrinho de compras       │");
        System.out.println("│  2. Enviar feedback          │ 6. Adicionar produto no carrinho   │");
        System.out.println("│  3. Opções de contato        │ 7. Remover produto do carrinho     │");
        System.out.println("│  4. Visualizar cardápio      │ 8. Comprar Produtos do carrinho    │");
        System.out.println("│===================================================================│");
        System.out.println("│                          0. Sair                                  │");
        System.out.println("│===================================================================│");

        boolean loop = true;
        while (loop) {
            System.out.println("\nDigite uma opção do Menu de ações:");
            int num = -1;
            while (num < 0) {
                if (scanner.hasNextInt()) {
                    num = scanner.nextInt();
                    if (num < 0 || num > 8) {
                        System.out.println("Opção inválida. Escolha um número entre 0 e 8.");
                    }
                } else {
                    System.err.println("⚠ Entrada inválida. Digite um número inteiro.");
                    scanner.next();
                }
            }
            switch (num) {
                case 0:
                    if (cliente != null) {
                        System.err.println("Fechando o sistema!");
                        System.err.println("Até mais, " + cliente.getNome() + "!");
                    } else {
                        System.err.println("⚠ Fechando o sistema! Até mais!");
                    }
                    loop = false;
                    break;


                case 1:
                    if (cliente == null) {
                        cliente = IsCliente.verificarSeCliente(isCliente);
                        if (cliente != null) {
                            isCliente = true;
                            saldo = cliente.getQuantidadeDinheiro();
                            System.out.println("Obrigado por se tornar cliente, " + cliente.getNome() + "!");
                        }
                    } else {
                        System.out.println("Você já está cadastrado!");
                    }
                    break;
                case 2:
                    System.out.println("Você escolheu avaliar o nosso serviço!");
                    System.out.println("Ficamos honrados em receber seu feedback!");
                    System.out.println("Diga mais sobre sua experiência conosco:");
                    scanner.next();
                    System.out.println("Feedback recebido com sucesso, muito obrigado!");
                    break;

                case 3:
                    System.out.println("Instagram : @matheuxsx3\nWhatsapp : 4002-8922");
                    break;
                case 4:
                    Cardapio.mostrarCardapio(Cardapio.getCardapio());
                    break;
                case 5:
                    funcoesCarrinho.exibirCarrinho();
                    break;
                case 6:
                    System.out.println("Você escolheu adicionar um item ao carrinho!");
                    while (true) {
                        try {
                            System.out.println("Qual é o código do item que você deseja adicionar?:");
                            int codigoSelecionado = scanner.nextInt();
                            System.out.println("Qual é a quantidade que você deseja?:");
                            int quantidadeSelecionada = scanner.nextInt();
                            funcoesCarrinho.encontrarProdutoAdicionado(codigoSelecionado, quantidadeSelecionada);
                            break;
                        } catch (Exception e) {
                            System.err.println("⚠ Entrada inválida. Certifique-se de que você digitou números inteiros.");
                            scanner.nextLine();
                        }
                    }
                    break;

                case 7:
                    System.out.println("Você escolheu remover um produto do carrinho.");
                    System.out.println("Digite o código do produto que deseja remover:");

                    while (true) {
                        if (scanner.hasNextInt()) {
                            int remover = scanner.nextInt();
                            Optional<Integer> remover1 = Optional.of(remover);
                            funcoesCarrinho.removerProduto(remover1.get());
                            break;
                        } else {
                            System.err.println("⚠ Entrada inválida. Digite um número inteiro.");
                            scanner.next();
                        }
                    }
                    break;


                case 8:
                    System.out.println("Você escolheu comprar itens do carrinho");
                    funcoesCarrinho.comprarItens();
                    break;
                default:
                    System.err.println("⚠ O numero escolhido não esta disponivel.");
                    break;
            }
        }
    }
}

