package Alimentos.Carrinho;

import Alimentos.Cardapios.Cardapio;
import Alimentos.Produto;
import Inicio.MenuInicial;

import java.util.List;
import java.util.Scanner;

public class FuncoesCarrinho implements OrganizarCarrinho {

    Carrinho carrinho = new Carrinho();
    Scanner scanner = new Scanner(System.in);
    List<Produto> itensNoCarrinho = carrinho.getItens();
    Produto[] cardapio = Cardapio.getCardapio();

    @Override
    public void encontrarProdutoAdicionado(int id, int quantidade) {
        Produto produtoSelecionado = null;
        for (Produto produto : cardapio) {
            if (produto.getCodigo() == id) {
                produtoSelecionado = new Produto(produto); // Crie uma cópia do produto
                break;
            }
        }

        if (produtoSelecionado != null) {
            // Verifique se o produto já existe no carrinho
            boolean produtoJaNoCarrinho = itensNoCarrinho.stream().anyMatch(p -> p.getCodigo() == id);

            if (produtoJaNoCarrinho) {
                System.err.println("⚠ O produto já existe no carrinho. Remova-o e adicione novamente se necessário.");
            } else {
                if ((produtoSelecionado.getQuantidade() - quantidade) < 0) {
                    System.err.println("⚠ A quantidade informada não está disponível!");
                    System.err.println("⚠ O produto não foi adicionado ao carrinho.");
                } else {
                    produtoSelecionado.setQuantidade(quantidade);
                    carrinho.itens.add(produtoSelecionado);

                    for (Produto produto : cardapio) {
                        if (produto.getCodigo() == id) {
                            produto.setQuantidade(produto.getQuantidade() - quantidade);
                            System.out.println("A quantidade de " + produtoSelecionado.getNome() + " agora é: " + produto.getQuantidade());
                        }
                    }

                    System.out.println("Produto adicionado ao carrinho: " + produtoSelecionado.getNome());
                }
            }
        } else {
            System.err.println("⚠ O número digitado não corresponde a nenhum produto!");
        }
    }

    @Override
    public void removerProduto(int id) {
        Produto produtoEscolhido = null;
        for (Produto produto : itensNoCarrinho) {
            if (produto.getCodigo() == id) {
                produtoEscolhido = produto;
                break;
            }
        }

        if (produtoEscolhido != null) {
            // Resto do seu código para remover o produto do carrinho

            // Atualize a quantidade no cardápio
            for (Produto produto : cardapio) {
                if (produto.getCodigo() == id) {
                    produto.setQuantidade(produto.getQuantidade() + produtoEscolhido.getQuantidade());
                    break;
                }
            }
        } else {
            System.err.println("⚠ Não foi possível encontrar o produto no carrinho");
        }
    }

    @Override
    public void exibirCarrinho() {
        if (itensNoCarrinho.isEmpty()) {
            System.err.println("⚠ O carrinho está vazio.");
        } else {
            System.out.println("Itens no carrinho:");
            for (Produto item : itensNoCarrinho) {
                double valorTotal = item.getPreco() * item.getQuantidade();
                System.out.println("Nome: " + item.getNome().strip() + " │ Preço Unitário: " + item.getPreco() + " reais " + " │ Quantidade: " + item.getQuantidade() + " │ Valor Total: " + valorTotal + " reais");
            }
        }
    }

    @Override
    public void comprarItens() {
        double valorTotalPagar = 0;
        if (!MenuInicial.isCliente) {
            System.err.println("⚠ Não foi possível realizar a compra, usuário ainda não cadastrado.\nFaça o cadastro e tente novamente!");
        } else {
            if (itensNoCarrinho.isEmpty()) {
                System.err.println("⚠ O carrinho está vazio.");
            } else {
                for (Produto item : itensNoCarrinho) {
                    double valorTotalUnitario = item.getPreco() * item.getQuantidade();
                    valorTotalPagar += valorTotalUnitario;
                }
                System.out.println("Valor total a pagar:" + valorTotalPagar + " reais");
                System.out.println("Seu saldo atual é: " + MenuInicial.saldo + " reais");
                System.out.println("Deseja realmente comprar?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                int num = scanner.nextInt();
                while (true) {
                    switch (num) {
                        case 1:
                            if (MenuInicial.saldo >= valorTotalPagar) {
                                MenuInicial.saldo -= valorTotalPagar;
                                itensNoCarrinho.clear();
                                System.out.println("Compra efetuada com sucesso!\nSeu novo saldo é de: " + MenuInicial.saldo + " reais");
                            } else {
                                System.err.println("⚠ Desculpe, você não tem saldo suficiente.");
                            }
                            break;
                        case 2:
                            System.err.println("⚠ Compra cancelada! \nSeus itens permanecem no carrinho.");
                            break;
                        default:
                            System.err.println("⚠ Número inválido!");
                            break;
                    }
                    break;
                }
            }
        }
    }
}
