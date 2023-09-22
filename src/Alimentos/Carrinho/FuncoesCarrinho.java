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
    int quantidadeCarrinho;
    double valorTotalPagar;

    @Override
    public void encontrarProdutoAdicionado(int id, int quantidade) {
        Produto produtoSelecionado = null;
        for (
                Produto produto : cardapio) {
            if (produto.getCodigo() == id) {
                produtoSelecionado = produto;
            }
        }
        if (produtoSelecionado != null) {
            if ((produtoSelecionado.getQuantidade() - quantidade) < 0) {
                System.err.println("A quantidade informada não está disponivel!");
                System.err.println("O produto não foi adicionado ao carrinho.");

            } else if (itensNoCarrinho.contains(produtoSelecionado)) {
                System.err.println("O produto ja existe no carrinho.\n remova-o e adicione novamente!");
            } else {
                carrinho.itens.add(produtoSelecionado);
                System.out.println("Produto adicionado ao carrinho: " + produtoSelecionado.getNome());
                int subtrairQuantidade = produtoSelecionado.getQuantidade() - quantidade;
                produtoSelecionado.setQuantidade(subtrairQuantidade);
                quantidadeCarrinho = quantidade;
                System.out.println("A quantidade de " + produtoSelecionado.getNome().strip() + " agora é: " + produtoSelecionado.getQuantidade());

            }
        } else {
            System.err.println("O código informado não corresponde a nenhum produto!");
        }

    }

    @Override
    public void removerProduto(int id) {
        List<Produto> itensNoCarrinho = carrinho.getItens();
        Produto variavel = null;
        for (
                Produto produto : itensNoCarrinho) {
            if (produto.getCodigo() == id) {
                variavel = produto;
            }
        }
        if (variavel != null) {
            itensNoCarrinho.remove(variavel);
            System.out.println(variavel.getNome().strip() + " foi REMOVIDO do carrinho.");
            int adicionarQuantidade = variavel.getQuantidade() + quantidadeCarrinho;
            variavel.setQuantidade(adicionarQuantidade);
        } else {
            System.out.println("Não foi possível encontrar o produto no carrinho");
        }
    }

    @Override
    public void exibirCarrinho() {

        if (itensNoCarrinho.isEmpty()) {
            System.out.println("O carrinho está vazio.");
        } else {
            System.out.println("Itens no carrinho:");
            for (Produto item : itensNoCarrinho) {
                double valorTotal = item.getPreco() * quantidadeCarrinho;
                System.out.println("Nome: " + item.getNome().strip() + " │ Preço Unitário: " + item.getPreco() + " reais " + " │ Quantidade: " + quantidadeCarrinho + " │ Valor Total: " + valorTotal + " reais");
            }
        }
    }

    @Override
    public void comprarItens() {
        if (!MenuInicial.variavelVerificadora) {
            System.err.println("Não foi possivel realizar a compra, usuario ainda não cadastrado.\n Faça o cadastro e tente novamente!");
        } else {
            if (itensNoCarrinho.isEmpty()) {
                System.out.println("O carrinho está vazio.");
            } else {
                for (Produto item : itensNoCarrinho) {
                    double valorTotalUnitario = item.getPreco() * quantidadeCarrinho;
                    valorTotalPagar += valorTotalUnitario;
                }
                System.out.println("Valor total a pagar:" + valorTotalPagar + " reais");
                System.out.println("Seu saldo atual é: " + MenuInicial.saldo + " reais");
                System.out.println("Deseja realmente comprar?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                int num = scanner.nextInt();
                boolean loop = true;
                while (loop) {
                    switch (num) {
                        case 1:
                            if (MenuInicial.saldo >= valorTotalPagar) {
                                double transacao = MenuInicial.saldo - valorTotalPagar;
                                System.out.println("Compra efetuada com sucesso!\nSeu saldo agora é de: " + transacao + " reais");
                                loop = false;
                                break;
                            } else {
                                System.out.println("Desculpe, você não tem saldo suficiente.");
                                loop = false;
                                break;
                            }
                        case 2:
                            System.out.println("Compra cancelada! \nSeus itens permanecem no carrinho.");
                            loop = false;
                            break;

                        default:
                            System.err.println("Numero invalido!");
                            break;
                    }
                    break;
                }
            }
        }
    }
}
