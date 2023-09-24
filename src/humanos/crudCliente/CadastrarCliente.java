package humanos.crudCliente;

import humanos.Cliente;

import java.util.Scanner;

public class CadastrarCliente {
    static boolean condicao = true;
    public static Cliente cliente = null;
    static Scanner scanner = new Scanner(System.in);

    public static void verificarSeCliente() {
        if (cliente == null) {
            cadastrarCliente();
        } else {
            System.err.println("⚠ Você já está cadastrado!");
        }
    }

    public static void cadastrarCliente() {
        System.out.println("======================================");
        System.out.println("     Questionário para cadastro!");
        System.out.println("======================================\n");

        System.out.print("Por favor, responda as seguintes perguntas:\n");

        System.out.print("Qual é o seu nome?");
        String nome = scanner.nextLine();

        System.out.print("Qual é o seu número de telefone?");
        String numeroTelefone = scanner.nextLine();

        System.out.print("Qual é o seu endereço?");
        String endereco = scanner.nextLine();

        System.out.println("Você acaba de receber um cartão de crédito para usar em nossa padaria!");


        double saldo = 0;
        do {
            try {
                System.out.println("Quanto de crédito você gostaria de ter?");
                saldo = scanner.nextDouble();
                if (saldo <= 0) {
                    System.err.println("⚠ Insira um crédito positivo");
                } else if (saldo > 1000) {
                    System.err.println("⚠ Seu crédito não pode exceder 1000 reais");
                } else {
                    condicao = false;
                }
            } catch (Exception p) {
                System.err.println("⚠ Digite um número não nulo");
            }

        } while (condicao);
        cliente = new Cliente(nome, numeroTelefone, endereco, saldo);
    }
}
