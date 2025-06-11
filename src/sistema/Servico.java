package sistema;// --- Servico.java ---

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Servico {
    protected Cliente cliente;
    protected Motorista motorista;
    protected Trajeto trajeto;
    protected LocalDateTime  dataHora;
    protected StatusServico status;
    protected double valorEstimado;
    protected Pagamento pagamento;

    public Servico(LocalDateTime dataHora, Trajeto trajeto, Motorista motorista, Cliente cliente) {
        this.dataHora = dataHora;
        this.trajeto = trajeto;
        this.motorista = motorista;
        this.cliente = cliente;
        this.status = StatusServico.PENDENTE;
    }

    //MÉTODOS

    public abstract void calcularCorrida();

    public void finalizarServico(String metodoPagAMENTO) {
        this.status = StatusServico.CONCLUIDO;
        this.pagamento = new Pagamento(valorEstimado, metodoPagAMENTO, "Pago");
    }

    public void exibirDetalhes() {
        System.out.println("\nDetalhes do Serviço:");
        System.out.println("Cliente: " + cliente.getNomeCompleto());
        System.out.println("Tipo: " + this.getClass().getSimpleName());
        System.out.println("Trajeto: " + trajeto.getOrigem() + " -> " + trajeto.getDestino());
        System.out.println("Motorista: " + motorista.getNomeCompleto());
        Veiculo v = motorista.getVeiculos().get(0);
        System.out.println("Veículo: " + v.getTipo() + "; Placa: " + v.getPlaca() + "; Cor: " + v.getCor());
        System.out.println("Horário: " + dataHora.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm")));
        System.out.println("Valor pago: R$ " + String.format("%.2f", pagamento.getValorFinal()));
    }


    //GETTERS
    public Cliente getCliente()           { return cliente;          }
    public Motorista getMotorista()       { return motorista;        }
    public Trajeto getTrajeto()           { return trajeto;          }
    public LocalDateTime getDataHora()    { return dataHora;         }
    public StatusServico getStatus()      { return status;           }
    public double getValorEstimado()      { return valorEstimado;    }
    public Pagamento getPagamento() { return pagamento; }

    //SETTERS
    public void setCliente(Cliente cliente)               { this.cliente = cliente;               }
    public void setMotorista(Motorista motorista)         { this.motorista = motorista;           }
    public void setTrajeto(Trajeto trajeto)               { this.trajeto = trajeto;               }
    public void setDataHora(LocalDateTime dataHora)       { this.dataHora = dataHora;             }
    public void setStatus(StatusServico status)           { this.status = status;                 }
    public void setValorEstimado(double valorEstimado)    { this.valorEstimado = valorEstimado;   }
}
