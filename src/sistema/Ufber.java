package sistema;// --- Ufber.java ---

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ufber {
    private List<Cliente> clientes   = new ArrayList<>();
    private List<Motorista> motoristas = new ArrayList<>();
    private List<Servico>   servicos   = new ArrayList<>();
    private List<Trajeto> trajetos = new ArrayList<>();

    //MÉTODOS DE GERENCIAMENTO
    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void cadastrarMotorista(Motorista motorista ) {
        motoristas.add(motorista);
    }

    public void cadastrarServico(Servico servico) {
        servicos.add(servico);
    }

    public void cadastrarTrajeto(Trajeto trajeto) {
        trajetos.add(trajeto);
    }

    //MÉTODOS DE ACESSO // esses getters permitem ao Main fazer sys.getClientes() e sys.getMotoristas()
    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }

    public List<Motorista> getMotoristas() {
        return new ArrayList<>(motoristas);
    }

    public List<Servico> getServicos() {
        return new ArrayList<>(servicos);
    }

    public List<Trajeto> getTrajetos() {
        return new ArrayList<>(trajetos);
    }

    //MÉTODOS DE REMOÇÃO
    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public void removerMotorista(Motorista motorista) {
        motoristas.remove(motorista);
    }

    public void removerTrajeto(Trajeto trajeto) {
        trajetos.remove(trajeto);
    }
    // --------- SOLICITAR CORRIDA ---------
    public Servico solicitarServico(Cliente cliente,
                                    Motorista motorista,
                                    Trajeto trajeto,
                                    LocalDateTime dataHora,
                                    double valorEstimado,
                                    int numeroPassageiros,
                                    boolean compartilhada)
    {
        if (motorista.getContrato() == TipoContrato.PRO_LABORE ||
                (motorista.getContrato() == TipoContrato.CARONA && compartilhada))
        {
            Corrida corrida = new Corrida(
                    dataHora,
                    trajeto,
                    motorista,
                    cliente,
                    numeroPassageiros,
                    compartilhada
            );
            corrida.calcularCorrida();
            servicos.add(corrida);
            return corrida;
        }
        System.out.println("Motorista não habilitado para esta corrida.");
        return null;
    }

    // --------- SOLICITAR ENTREGA ---------
    public Servico solicitarServico(Cliente cliente,
                                    Motorista motorista,
                                    Trajeto trajeto,
                                    LocalDateTime dataHora,
                                    Item item)
    {
        if (motorista.getContrato() == TipoContrato.PRO_LABORE) {
            Entrega entrega = new Entrega(
                    dataHora,
                    trajeto,
                    motorista,
                    cliente,
                    item
            );
            entrega.calcularCorrida();
            servicos.add(entrega);
            return entrega;
        }
        System.out.println("Motorista não habilitado para entregas.");
        return null;
    }

    //Metodo para exibiri o historico das corridas
    public void exibirHistorico() {
        System.out.println("\nHISTÓRICO DE CORRIDAS");
        for (Servico servico : servicos) {
            servico.exibirDetalhes();
        }
    }
}
