package Alimentos.Cardapios;

import Alimentos.Produto;
import Inicio.MenuInicial;

import java.util.Random;

public class Cardapio {
    static int quantidadeA = getRandomQuantidade();
    static int quantidadeB = getRandomQuantidade();
    static int quantidadeC = getRandomQuantidade();
    static int quantidadeD = getRandomQuantidade();
    static int quantidadeE = getRandomQuantidade();
    static int quantidadeF = getRandomQuantidade();
    static int quantidadeG = getRandomQuantidade();
    static int quantidadeH = getRandomQuantidade();
    static int quantidadeI = getRandomQuantidade();
    static int quantidadeJ = getRandomQuantidade();
    static int quantidadeK = getRandomQuantidade();
    static int quantidadeL = getRandomQuantidade();
    static int quantidadeM = getRandomQuantidade();
    static int quantidadeN = getRandomQuantidade();
    static int quantidadeO = getRandomQuantidade();
    static int quantidadeP = getRandomQuantidade();
    static int quantidadeQ = getRandomQuantidade();
    static int quantidadeR = getRandomQuantidade();
    static int quantidadeS = getRandomQuantidade();
    static int quantidadeT = getRandomQuantidade();
    static int quantidadeU = getRandomQuantidade();
    private static Produto[] cardapio = {
            new Produto(1, " Pão Francês        ", 1.00, quantidadeA),
            new Produto(2, "Croissant          ", 1.50, quantidadeB),
            new Produto(3, "Bolo de Chocolate  ", 3.75, quantidadeC),
            new Produto(4, "Sanduíche de Frango", 5.25, quantidadeD),
            new Produto(5, "Café Expresso      ", 2.00, quantidadeE),
            new Produto(6, "Muffin de Blueberry", 2.25, quantidadeF),
            new Produto(7, "Baguete            ", 2.50, quantidadeG),
            new Produto(8, "Biscoito de Nutella", 5.00, quantidadeH),
            new Produto(9, "Torta de Maçã      ", 4.00, quantidadeI),
            new Produto(10, "Chocolat Chaud     ", 3.50, quantidadeJ),
            new Produto(11, "Pão Integral       ", 1.25, quantidadeK),
            new Produto(12, "Pão de Centeio     ", 1.50, quantidadeL),
            new Produto(13, "Queijo Gouda       ", 2.75, quantidadeM),
            new Produto(14, "Queijo Brie        ", 3.25, quantidadeN),
            new Produto(15, "Queijo Cheddar     ", 2.50, quantidadeO),
            new Produto(16, "Croissant recheado ", 1.75, quantidadeP),
            new Produto(17, "Donut de Morango   ", 1.95, quantidadeQ),
            new Produto(18, "Bolo de Cenoura    ", 3.50, quantidadeR),
            new Produto(19, "Cappuccino         ", 3.00, quantidadeS),
            new Produto(20, "Suco de Laranja    ", 2.50, quantidadeT),
            new Produto(21, "Água Mineral       ", 1.00, quantidadeU)
    };

    public static Produto[] getCardapio() {
        return cardapio;
    }

    public static void mostrarCardapio(Produto[] produtos) {
        System.out.println("│---------------------------------------------------------│");
        System.out.println("│                       Cardápio                          │");
        System.out.println("│-------------------------------------------------------  │");
        System.out.println("│  Código │       Item          │ Preço (R$) │ Quantidade │");
        System.out.println("│-------------------------------------------------------- │");

        for (Produto produto : produtos) {
            System.out.printf("    %2d  │  %-18s │ %9.2f  │ %d%n ",
                    produto.getCodigo(), produto.getNome(), produto.getPreco(), produto.getQuantidade());
        }

        System.out.println("│---------------------------------------------------------│");

        MenuInicial.menuDeOpcoes();
    }

    static int getRandomQuantidade() {
        Random random = new Random();
        return random.nextInt(100);
    }
}

