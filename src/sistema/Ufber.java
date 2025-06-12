package sistema;// --- Ufber.java ---

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ufber {
    private List<Cliente> clientes   = new ArrayList<>();
    private List<Motorista> motoristas = new ArrayList<>();
    private List<Corrida>   corridas   = new ArrayList<>();
    private List<Trajeto> trajetos = new ArrayList<>();

    //MÉTODOS DE GERENCIAMENTO
    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void cadastrarMotorista(Motorista motorista ) {
        motoristas.add(motorista);
    }

    public void cadastrarCorrida(Corrida corrida) {
        corridas.add(corrida);
    }

    public void cadastrarTrajeto(Trajeto trajeto) {
        trajetos.add(trajeto);
    }

    // Metodo para selecionar trajeto para uma corrida
    public void selecionarTrajeto(Corrida corrida, int indiceTrajeto) {
        corrida.verificarTrajetos(trajetos, indiceTrajeto);
    }

    // Metodo para listar motoristas compatíveis
    public List<Motorista> listarMotoristasCompativeis(Corrida corrida) {
        return corrida.verificarMotoristas(motoristas);
    }

    // Metodo para atribuir motorista a corrida
    public void atribuirMotorista(Corrida corrida, Motorista motorista) {
        corrida.setMotorista(motorista);
        corrida.calcularValorCorrida(); // Calcula o valor após atribuição
    }

    //MÉTODOS DE ACESSO // esses getters permitem ao Main fazer sys.getClientes() e sys.getMotoristas()
    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }

    public List<Motorista> getMotoristas() {
        return new ArrayList<>(motoristas);
    }

    public List<Corrida> getCorridas() {
        return new ArrayList<>(corridas);
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
    public Corrida solicitarCorrida(Cliente cliente,
                                    Motorista motorista,
                                    Trajeto trajeto,
                                    LocalDateTime horario,
                                    double valorEstimado,
                                    int numeroPassageiros,
                                    boolean compartilhada)
    {
        if (motorista.getContrato() == TipoContrato.PRO_LABORE ||
                (motorista.getContrato() == TipoContrato.CARONA && compartilhada))
        {
            Prolabore prolabore = new Prolabore(
                    horario,
                    trajeto,
                    motorista,
                    cliente,
                    numeroPassageiros,
                    compartilhada
            );
            prolabore.calcularValorCorrida();
            corridas.add(prolabore);
            return prolabore;
        }
        System.out.println("Motorista não habilitado para esta corrida.");
        return null;
    }

    // --------- SOLICITAR ENTREGA ---------
    public Corrida solicitarCorrida(Cliente cliente,
                                    Cliente cliente2,
                                    Motorista motorista,
                                    Trajeto trajeto,
                                    LocalDateTime horario,
                                    Item item)
    {
        if (motorista.getContrato() == TipoContrato.PRO_LABORE) {
            Entrega entrega = new Entrega(
                    horario,
                    trajeto,
                    motorista,
                    cliente,
                    cliente2,
                    item
            );
            entrega.calcularValorCorrida();
            corridas.add(entrega);
            return entrega;
        }
        System.out.println("Motorista não habilitado para entregas.");
        return null;
    }

    //Metodo para exibiri o historico das corridas
    public void exibirHistorico() {
        System.out.println("\nHISTÓRICO DE CORRIDAS");
        for (Corrida corrida : corridas) {
            corrida.exibirDetalhes();
        }
    }
}
