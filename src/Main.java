import sistema.*;
import gerenciamento.Administrador;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Criar instância do sistema Ufber
        Ufber ufber = new Ufber();

        // Criar administrador
        Administrador admin = new Administrador("Carlos Silva", "ADM001", "12345678901");

        // Criar clientes
        Cliente cliente1 = new Cliente("João Silva", "71999998888", "11122233344", TipoEndereco.CASA);
        Cliente cliente2 = new Cliente("Maria Souza", "71999997777", "55566677788", TipoEndereco.CAMPUS_FEDERACAO);
        ufber.cadastrarCliente(cliente1);
        ufber.cadastrarCliente(cliente2);

        // Criar motoristas
        Motorista motorista1 = new Motorista("Carlos Oliveira", "71999996666", "99988877766",
                TipoContrato.PRO_LABORE);
        Motorista motorista2 = new Motorista("Ana Pereira", "71999995555", "44433322211",
                TipoContrato.CARONA);
        ufber.cadastrarMotorista(motorista1);
        ufber.cadastrarMotorista(motorista2);

        // Adicionar veículos
        Veiculo veiculo1 = new Veiculo(TipoVeiculo.CARRO, "Fiat Uno", "Vermelho", "ABC1D23");
        Veiculo veiculo2 = new Veiculo(TipoVeiculo.MOTO, "Honda CG", "Preto", "MOT0R123");
        motorista1.adicionarVeiculo(veiculo1);
        motorista2.adicionarVeiculo(veiculo2);

        // Criar trajetos
        Trajeto trajeto1 = new Trajeto(TipoEndereco.CAMPUS_ONDINA, TipoEndereco.CASA, 15.5f);
        Trajeto trajeto2 = new Trajeto(TipoEndereco.CAMPUS_FEDERACAO, TipoEndereco.CAMPUS_CANELA, 8.2f);
        ufber.cadastrarTrajeto(trajeto1);
        ufber.cadastrarTrajeto(trajeto2);

        // Criar itens para entrega
        Item item1 = new Item("Documentos importantes", true);

        // Criar serviços (com horários específicos)
        LocalDateTime dataHora1 = LocalDateTime.of(2025, 5, 31, 14, 30);
        LocalDateTime dataHora2 = LocalDateTime.of(2025, 5, 31, 18, 15);

        Corrida corrida1 = new Corrida(dataHora1, trajeto1, motorista1, cliente1, 1, false);
        Entrega entrega1 = new Entrega(dataHora2, trajeto2, motorista2, cliente2, item1);

        // Calcular valores
        corrida1.calcularCorrida();
        entrega1.calcularCorrida();

        // Finalizar serviços
        corrida1.finalizarServico("Cartão de crédito");
        entrega1.finalizarServico("PIX");

        // Visualizar históricos
        cliente1.visualizarHistorico();
        cliente2.visualizarHistorico();

        // Testar operações sobre usuários
        System.out.println("\n=== OPERAÇÕES ===");

        // Editar cliente
        admin.editarCliente(cliente1, "71999990000", TipoEndereco.CAMPUS_ONDINA);
        System.out.println("Cliente editado: Novo telefone - " + cliente1.getTelefone() +
                ", Novo endereço - " + cliente1.getEnderecoCasa());

        // Bloquear motorista
        admin.bloquearMotorista(motorista1);
        System.out.println("Motorista bloqueado: " + motorista1.getNomeCompleto() +
                " | Status: " + motorista1.getStatus());

        // Criar novo trajeto
        admin.criarTrajeto(ufber, TipoEndereco.CAMPUS_CANELA, TipoEndereco.CASA, 12.3f);
        System.out.println("Novo trajeto criado: " +
                ufber.getTrajetos().get(ufber.getTrajetos().size()-1).getOrigem() + " -> " +
                ufber.getTrajetos().get(ufber.getTrajetos().size()-1).getDestino());

        // Exibir histórico geral
        ufber.exibirHistorico();
    }
}