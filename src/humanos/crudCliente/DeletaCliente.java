package humanos.crudCliente;

public class DeletaCliente {
    public static void deletaCliente() {
        if (CadastrarCliente.cliente == null) {
            System.out.println("Conta ainda não cadastrada.");
        } else {
            System.out.println("Cliente deletado com sucesso.");
            CadastrarCliente.cliente = null;
        }
    }
}
