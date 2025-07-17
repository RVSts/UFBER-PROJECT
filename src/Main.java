import gerenciamento.Administrador;
import gerenciamento.CadastroCliente;
import gerenciamento.IAdministrador;
import sistema.*;

public class Main {
    public static void main(String[] args) {
        Ufber sistema = new Ufber();
        IAdministrador admin = new Administrador("Admin Chefe", "ADM001", "12345678901");
        IAdministrador autoCadastro = new CadastroCliente();

        // Cadastro pelo administrador
        Motorista motorista = admin.cadastrarMotorista(
                sistema,
                "Carlos Motorista",
                "71999998888",
                "11122233344",
                TipoContrato.PRO_LABORE
        );

        // Auto-cadastro de cliente
        Cliente cliente = autoCadastro.cadastrarCliente(
                sistema,
                "João Cliente",
                "71999997777",
                "55566677788",
                TipoEndereco.CASA
        );

        System.out.println("Motorista cadastrado: " + motorista.getNomeCompleto());
        System.out.println("Cliente cadastrado: " + cliente.getNomeCompleto());

        // Verificando cadastros no sistema
        System.out.println("\nMotoristas no sistema:");
        sistema.getMotoristas().forEach(m -> System.out.println("- " + m.getNomeCompleto()));

        System.out.println("\nClientes no sistema:");
        sistema.getClientes().forEach(c -> System.out.println("- " + c.getNomeCompleto()));
    }
}