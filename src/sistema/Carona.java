package sistema;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Carona extends Corrida {
    private int numeroPassageiros;
    private boolean compartilhada;
    private double valorOferecidoPorKm;

    public Carona(LocalDateTime horario, Trajeto trajeto,
                  Motorista motorista, Cliente cliente,
                  int numeroPassageiros, boolean compartilhada, double valorOferecidoPorKm) {
        super(horario, trajeto, motorista, cliente);
        this.numeroPassageiros = numeroPassageiros;
        this.compartilhada = compartilhada;
        this.valorOferecidoPorKm = valorOferecidoPorKm;

        if (trajeto != null) {
            calcularEAtualizarValor();
        }
    }

    @Override
    public List<Motorista> verificarMotoristas(List<Motorista> motoristasCadastrados) {
        return motoristasCadastrados.stream()
                .filter(m -> m.getContrato() == TipoContrato.CARONA)
                .collect(Collectors.toList());
    }

    @Override
    public double calcularValorCorrida(Trajeto trajeto, Corrida corrida) {
        return trajeto.getDistanciaKm() * valorOferecidoPorKm;
    }

    public void atualizarContribuicao(double novoValorPorKm) {
        this.valorOferecidoPorKm = novoValorPorKm;
        if (trajeto != null) {
            this.valorFinalCorrida = calcularValorCorrida(this.trajeto, this);
        }
    }

    //GETTERS
    public int getNumeroPassageiros()      { return numeroPassageiros; }
    public boolean isCompartilhada()       { return compartilhada; }
    public double getValorOferecidoPorKm() { return valorOferecidoPorKm; }

    //SETTERS
    public void setNumeroPassageiros(int numeroPassageiros)        { this.numeroPassageiros = numeroPassageiros; }
    public void setIsCompartilhada(boolean compartilhada)          { this.compartilhada = compartilhada; }
    public void setValorOferecidoPorKm(double valorOferecidoPorKm) { this.valorOferecidoPorKm = valorOferecidoPorKm; }
}