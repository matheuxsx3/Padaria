package humanos;

import humanos.crudCliente.CadastrarCliente;

import java.util.Scanner;

public class IsCliente extends Cliente {

    public IsCliente(String nome, String numeroContato, String endereco, double quantidadeDinheiro) {
        super(nome, numeroContato, endereco, quantidadeDinheiro);
    }

    public IsCliente() {
    }

    public static Cliente verificarSeCliente(boolean parametro) {
        Scanner scanner = new Scanner(System.in);


        Cliente cliente = null;
        if (!parametro) {
            System.out.println("Digite seu nome");
            String nome = scanner.nextLine();
            System.out.println("Digite seu numero de telefone:");
            String numeroTelefone = scanner.nextLine();
            System.out.println("Digite seu endereço:");
            String endereco = scanner.nextLine();
            System.out.println("Digite quanto de dinheiro você possui:");
            double dinherio = scanner.nextDouble();
            cliente = new Cliente(nome, numeroTelefone, endereco, dinherio);
        } else {
            System.out.println("Você já está cadastrado!");
        }
        return cliente;
    }
}

