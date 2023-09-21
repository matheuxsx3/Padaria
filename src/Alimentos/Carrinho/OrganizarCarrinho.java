package Alimentos.Carrinho;

public interface OrganizarCarrinho {

    void encontrarProdutoAdicionado(int id, int quantidade);

    void removerProduto(int id);

    void exibirCarrinho();
    void comprarItens();
}
