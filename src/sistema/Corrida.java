package sistema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Corrida {
    private static int proximoId = 1;

    protected Cliente cliente;
    protected Motorista motorista;
    protected Trajeto trajeto;
    protected LocalDateTime horario;
    protected StatusServico status;
    protected double valorFinalCorrida;
    protected Pagamento pagamento;
    protected int id;

    public Corrida(LocalDateTime horario, Trajeto trajeto,
                   Motorista motorista, Cliente cliente)
    {
        this.horario = horario;
        this.trajeto = trajeto;
        this.motorista = motorista;
        this.cliente = cliente;
        this.status = StatusServico.PENDENTE;
        this.id = proximoId++;
        this.valorFinalCorrida = 0.0;
    }

    //MÉTODOS

    public void verificarTrajetos(List<Trajeto> trajetosDisponiveis, int indiceSelecionado) {
        if (indiceSelecionado >= 0 && indiceSelecionado < trajetosDisponiveis.size()) {
            this.trajeto = trajetosDisponiveis.get(indiceSelecionado);
        }
    }

    public List<Motorista> verificarMotoristas(List<Motorista> motoristasCadastrados) {
        return new ArrayList<>(motoristasCadastrados);
    }

    public abstract double calcularValorCorrida(Trajeto trajeto, Corrida corrida);

    public void finalizarCorrida(String metodoPagAMENTO) {
        this.status = StatusServico.CONCLUIDO;
        this.pagamento = new Pagamento(valorFinalCorrida, metodoPagAMENTO, "Pago");
    }

    public void calcularEAtualizarValor() {
        if (trajeto == null) {
            throw new IllegalStateException("Trajeto não definido para a corrida");
        }
        this.valorFinalCorrida = calcularValorCorrida(trajeto, this);
    }

    public ArrayList<Trajeto> veririfcarHistoricoTrajetosMotorista(Motorista motorista) {
        return motorista.visualizarHistoricoTrajetos();
    }
    public void exibirDetalhes() {
        System.out.println("\nDetalhes do Serviço:");
        System.out.println("Cliente: " + cliente.getNomeCompleto());
        System.out.println("Tipo: " + this.getClass().getSimpleName());
        System.out.println("Trajeto: " + trajeto.getOrigem() + " -> " + trajeto.getDestino());
        System.out.println("Motorista: " + motorista.getNomeCompleto());
        Veiculo v = motorista.getVeiculos().get(0);
        System.out.println("Veículo: " + v.getTipo() + "; Placa: " + v.getPlaca() + "; Cor: " + v.getCor());
        System.out.println("Horário: " + horario.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm")));
        System.out.println("Valor pago: R$ " + String.format("%.2f", pagamento.getValorFinal()));
    }


    //GETTERS
    public Cliente getCliente()           { return cliente;          }
    public Motorista getMotorista()       { return motorista;        }
    public Trajeto getTrajeto()           { return trajeto;          }
    public LocalDateTime getHorario()     { return horario;         }
    public StatusServico getStatus()      { return status;           }
    public double getValorFinalCorrida()      { return valorFinalCorrida;    }
    public Pagamento getPagamento()       { return pagamento; }
    public int getId()                    { return id; }

    //SETTERS
    public void setCliente(Cliente cliente)               { this.cliente = cliente;               }
    public void setMotorista(Motorista motorista)         { this.motorista = motorista;           }
    public void setTrajeto(Trajeto trajeto)               { this.trajeto = trajeto;               }
    public void setHorario(LocalDateTime horario)         { this.horario = horario;             }
    public void setStatus(StatusServico status)           { this.status = status;                 }
    public void setValorFinalCorrida(double valorEstimado)    { this.valorFinalCorrida = valorEstimado;   }
    public void setId(int id)                             { this.id = id; }
}
