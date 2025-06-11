package sistema;

import java.time.LocalDateTime;

public class Corrida extends Servico {
    private int numeroPassageiros;
    private boolean compartilhada;

    public Corrida(LocalDateTime dataHora, Trajeto trajeto, Motorista motorista,
                   Cliente cliente, int numeroPassageiros, boolean compartilhada) {
        super(dataHora, trajeto, motorista, cliente);
        this.numeroPassageiros = numeroPassageiros;
        this.compartilhada = compartilhada;
    }

    @Override
    public void calcularCorrida() {
        if (motorista.getContrato() == TipoContrato.CARONA) {
            valorEstimado = 0;
        } else {
            Veiculo veiculo = motorista.getVeiculos().get(0);
            double fator = (veiculo.getTipo() == TipoVeiculo.MOTO) ? 1.0 : 1.3;
            valorEstimado = trajeto.getDistanciaKm() * fator;
        }
    }

    public void verificarTrajeto() { return; }

    public void selecionarTrajeto() { return; }

    public void verificarMotorista() { return; }

    //GETTERS
    public int getNumeroPassageiros() { return numeroPassageiros; }
    public boolean isCompartilhada()  { return compartilhada; }

    //SETTERS
    public void setNumeroPassageiros(int numeroPassageiros) { this.numeroPassageiros = numeroPassageiros; }
    public void setIsCompartilhada(boolean compartilhada)   { this.compartilhada = compartilhada; }
}