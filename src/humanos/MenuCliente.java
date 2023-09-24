package humanos;

import java.util.Scanner;

public class MenuCliente {
    static void menuCliente() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("========== Menu de Clientes ==========");
            System.out.println("1. Cadastrar um novo cliente");
            System.out.println("2. Re  mover um cliente existente");
            System.out.println("3. Editar informações de um cliente");
            System.out.println("4. Sair do sistema");
            System.out.print("Escolha uma opção (1/2/3/4): ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Opção 1: Cadastrar um novo cliente");
                    break;
                case 2:
                    System.out.println("Opção 2: Remover um cliente existente");
                    break;
                case 3:
                    System.out.println("Opção 3: Editar informações de um cliente");
                    break;
                case 4:
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 4);
    }
}
