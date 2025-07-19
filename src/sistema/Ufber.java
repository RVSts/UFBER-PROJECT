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
        if (indiceTrajeto >= 0 && indiceTrajeto < trajetos.size()) {
            Trajeto trajetoSelecionado = trajetos.get(indiceTrajeto);
            corrida.setTrajeto(trajetoSelecionado);

            // Atualiza o valor da corrida se possível
            if (corrida instanceof Carona || corrida.getMotorista() != null) {
                try {
                    corrida.calcularEAtualizarValor();
                    System.out.println("Valor da corrida atualizado: R$" + corrida.getValorFinalCorrida());
                } catch (IllegalStateException e) {
                    System.out.println("Não foi possível calcular o valor: " + e.getMessage());
                }
            }
        }
    }

    // Metodo para listar motoristas compatíveis
    public List<Motorista> listarMotoristasCompativeis(Corrida corrida) {
        return corrida.verificarMotoristas(motoristas);
    }

    // Metodo para atribuir motorista a corrida
    public void atribuirMotorista(Corrida corrida, Motorista motorista) {
        corrida.setMotorista(motorista);
        if (corrida.getTrajeto() != null) {
            try {
                corrida.calcularEAtualizarValor();
                System.out.println("Valor da corrida atualizado: R$" + corrida.getValorFinalCorrida());
            } catch (IllegalStateException e) {
                System.out.println("Não foi possível calcular o valor: " + e.getMessage());
            }
        }
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

    // --------- SOLICITAR Corrida ---------
    // --------- SOLICITAR CORRIDA PROLABORE ---------
    public Prolabore solicitarProlabore(Cliente cliente,
                                        Motorista motorista,
                                        Trajeto trajeto,
                                        LocalDateTime horario,
                                        int numeroPassageiros,
                                        boolean compartilhada) {
        if (motorista.getContrato() == TipoContrato.PRO_LABORE) {
            Prolabore prolabore = new Prolabore(
                    horario,
                    trajeto,
                    motorista,
                    cliente,
                    numeroPassageiros,
                    compartilhada
            );
            corridas.add(prolabore);
            return prolabore;
        }
        System.out.println("Motorista não habilitado para corridas pró-labore.");
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
            corridas.add(entrega);
            return entrega;
        }
        System.out.println("Motorista não habilitado para entregas.");
        return null;
    }

    // --------- SOLICITAR CARONA ---------
    public Carona solicitarCarona(Cliente cliente,
                                  Motorista motorista,
                                  Trajeto trajeto,
                                  LocalDateTime horario,
                                  int numeroPassageiros,
                                  boolean compartilhada,
                                  double valorOferecidoPorKm) {
        if (motorista.getContrato() == TipoContrato.CARONA) {
            Carona carona = new Carona(
                    horario,
                    trajeto,
                    motorista,
                    cliente,
                    numeroPassageiros,
                    compartilhada,
                    valorOferecidoPorKm
            );
            corridas.add(carona);
            return carona;
        }
        System.out.println("Motorista não habilitado para caronas.");
        return null;
    }

    // --------- ATUALIZAR CONTRIBUIÇÃO DA CARONA ---------
    public void atualizarContribuicaoCarona(Carona carona, double novoValorPorKm) {
        carona.atualizarContribuicao(novoValorPorKm);
        System.out.println("Valor atualizado: R$" + carona.getValorFinalCorrida());
    }

    //Metodo para exibiri o historico das corridas
    public void exibirHistorico() {
        System.out.println("\nHISTÓRICO DE CORRIDAS");
        for (Corrida corrida : corridas) {
            corrida.exibirDetalhes();
        }
    }
}
