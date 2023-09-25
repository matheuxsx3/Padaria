package humanos.crudCliente;

import java.util.Scanner;

public class EditarCLiente {
    public static void editarCliente() {
        Scanner scanner = new Scanner(System.in);
        boolean condicao = true;
        int opcao;
        if (CadastrarCliente.cliente == null) {
            System.err.println("⚠ Nenhuma conta cadastrada encontrada");
        } else {
            do {
                try {
                    System.out.println("Qual informação você deseja editar? : ");
                    System.out.println("1. Nome");
                    System.out.println("2. Número de telefone");
                    System.out.println("3. Endereço");
                    System.out.println("4. Saldo");
                    opcao = scanner.nextInt();
                    switch (opcao) {
                        case 1:
                            System.out.println("Digite seu novo nome:");
                            String novoNome = scanner.next();
                            CadastrarCliente.cliente.setNome(novoNome);
                            condicao = false;
                            break;
                        case 2:
                            System.out.println("Digite seu novo número de telefone:");
                            String novoNumero = scanner.next();
                            CadastrarCliente.cliente.setNumeroContato(novoNumero);
                            condicao = false;
                            break;
                        case 3:
                            System.out.println("Digite seu novo endereço");
                            String novoEndereco = scanner.next();
                            CadastrarCliente.cliente.setEndereco(novoEndereco);
                            condicao = false;
                            break;
                        case 4:
                            System.out.println("Digite seu novo saldo:");
                            double novoSaldo = scanner.nextDouble();
                            CadastrarCliente.cliente.setQuantidadeDinheiro(novoSaldo);
                            condicao = false;
                            break;
                    }
                } catch (Exception exception) {
                    System.err.println("teste");
                    break;
                }
            } while (condicao);
        }
    }
}
