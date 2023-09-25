package humanos.crudCliente;

public class VisualizarCliente {
    public static void visualizarCliente() {
        if (CadastrarCliente.cliente == null) {
            System.err.println("⚠ Nenhuma conta cadastrada encontrada");
        } else {
            System.out.println("================================");
            System.out.println("         Meu perfil");
            System.out.println("================================");
            System.out.println("Nome: " + CadastrarCliente.cliente.getNome() + "\n Número de telefone: " + CadastrarCliente.cliente.getNumeroContato() + "\n Endereço: " + CadastrarCliente.cliente.getEndereco() + "\n Saldo: " + CadastrarCliente.cliente.getQuantidadeDinheiro());
            System.out.println("================================");

        }

    }
}
