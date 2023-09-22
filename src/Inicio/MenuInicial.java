package Inicio;

import Alimentos.Cardapios.Cardapio;
import Alimentos.Carrinho.FuncoesCarrinho;
import Humanos.Cliente;
import Humanos.IsCliente;

import java.util.Scanner;


public class MenuInicial {
    public static double saldo;
    static FuncoesCarrinho funcoesCarrinho = new FuncoesCarrinho();
    public static boolean variavelVerificadora = false;
    static Cliente cliente = null;

    public void boasVindas() {
        System.out.println("*****************************************************************");
        System.out.println("                 Bem vindo à padaria Pão Açucarado!             ");
        System.out.println("****************************************************************");
        System.out.println("                             ______    ");
        System.out.println("                            /      \\   ");
        System.out.println("                           /        \\  ");
        System.out.println("                          /          \\ ");
        System.out.println("                         /            \\ ");
        System.out.println("                        │    __  __    │");
        System.out.println("                        │   │  │|  │   │");
        System.out.println("                        │___│__││__│___│\n");

    }

    public static void menuDeOpcoes() {
        System.out.println("│===================================================================│");
        System.out.println("│                        Menu de Ações                              │");
        System.out.println("│===================================================================│");
        System.out.println("│  1. Cadastrar cliente        │ 5. Ver o carrinho de compras       │");
        System.out.println("│  2. Ver o cardápio           │ 6. Adicionar produto no carrinho   │");
        System.out.println("│  3. Opções de contato        │ 7. Remover produto do carrinho     │");
        System.out.println("│  4. Avaliar o nosso serviço  │ 8. Comprar Produtos do carrinho    │");
        System.out.println("│===================================================================│");
        System.out.println("│                          0. Sair                                  │");
        System.out.println("│===================================================================│");


        Scanner scanner = new Scanner(System.in);

        boolean loop = true;
        while (loop) {
            System.out.println("\nDigite uma opção do MENU:");

            int num = scanner.nextInt();
            switch (num) {
                case 0:
                    if (cliente != null) {
                        System.out.println("Tchau, " + cliente.getNome() + "!");
                    } else {
                        System.out.println("Até mais!");
                    }
                    loop = false;
                    break;


                case 1:
                    if (cliente == null) {
                        cliente = IsCliente.verificarSeCliente(variavelVerificadora);
                        if (cliente != null) {
                            variavelVerificadora = true;
                            saldo = cliente.getQuantidadeDinheiro();
                            System.out.println("Agradecemos por virar cliente, muito obrigado " + cliente.getNome() + "!");
                        }
                    } else {
                        System.out.println("Você já está cadastrado!");
                    }
                    break;
                case 2:
                    Cardapio.mostrarCardapio(Cardapio.getCardapio());
                    break;
                case 3:
                    System.out.println("Instagram : @matheuxsx3\nWhatsapp : 4002-8922");
                    break;
                case 4:
                    System.out.println("Você escolheu avaliar o nosso serviço!");
                    System.out.println("Ficamos honrados em receber seu feedback!");
                    System.out.println("Diga mais sobre sua experiência conosco:");
                    scanner.next();
                    System.out.println("Feedback recebido com sucesso, muito obrigado!");
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
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case 7:
                    System.out.println("Você escolheu remover um produto do carrinho.");
                    System.out.println("Digite o código do produto que deseja remover:");
                    while (true) {
                        try {
                            int teste = scanner.nextInt();
                            funcoesCarrinho.removerProduto(teste);
                            break;
                        } catch (Exception e) {
                            System.err.println("Número invalido.\n tente novamente");
                        }
                    }
                    break;
                case 8:
                    System.out.println("Você escolheu comprar itens do carrinho");
                    funcoesCarrinho.comprarItens();
                    break;
                default:
                    System.out.println("O numero escolhido não esta disponivel.");
                    break;
            }
        }
    }
}
