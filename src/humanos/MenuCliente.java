package humanos;

import humanos.crudCliente.CadastrarCliente;
import humanos.crudCliente.DeletaCliente;
import humanos.crudCliente.EditarCLiente;
import humanos.crudCliente.VisualizarCliente;
import inicio.MenuInicial;

import java.util.Scanner;

public class MenuCliente {
    public static void menuCliente() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        boolean sair = true;
        System.out.println("========== Menu de Clientes ==========");
        System.out.println("0. Voltar para o menu principal");
        System.out.println("1. Visualizar informações da conta");
        System.out.println("2. Cadastrar uma nova conta");
        System.out.println("3. Editar informações da conta");
        System.out.println("4. Deletar conta");
        System.out.println("=======================================");

        try {
            do {
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                switch (opcao) {

                    case 0:
                        MenuInicial.menuDeOpcoes();
                        sair = false;
                    case 1:
                        VisualizarCliente.visualizarCliente();
                        break;
                    case 2:
                        CadastrarCliente.verificarSeCliente();
                        break;
                    case 3:
                        EditarCLiente.editarCliente();
                        break;
                    case 4:
                        DeletaCliente.deletaCliente();
                        break;
                    default:
                        System.err.println("⚠ Opção inválida. Por favor, escolha uma opção válida.");
                        break;
                }
            } while (sair);
        } catch (Exception exception){
            System.err.println("Opção inválida");
        }
    }
}
