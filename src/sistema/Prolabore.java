package sistema;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Prolabore extends Corrida {
    private int numeroPassageiros;
    private boolean compartilhada;

    public Prolabore(LocalDateTime horario, Trajeto trajeto,
                     Motorista motorista, Cliente cliente,
                     int numeroPassageiros, boolean compartilhada) {
        super(horario, trajeto, motorista, cliente);
        this.numeroPassageiros = numeroPassageiros;
        this.compartilhada = compartilhada;
        this.valorFinalCorrida = 0.0;

        if (trajeto != null && motorista != null) {
            calcularEAtualizarValor();
        }
    }

    @Override
    public List<Motorista> verificarMotoristas(List<Motorista> motoristasCadastrados) {
        return motoristasCadastrados.stream()
                .filter(m -> m.getContrato() == TipoContrato.PRO_LABORE)
                .collect(Collectors.toList());
    }

    @Override
    public double calcularValorCorrida(Trajeto trajeto, Corrida corrida) {
        if (motorista == null || motorista.getVeiculos().isEmpty()) {
            return 0.0; // Retorna 0 se motorista ou veículo não estiverem disponíveis
        }

        Veiculo veiculo = motorista.getVeiculos().get(0);
        double fator = (veiculo.getTipo() == TipoVeiculo.MOTO) ? 1.0 : 1.3;
        return trajeto.getDistanciaKm() * fator;
    }

    //GETTERS
    public int getNumeroPassageiros() { return numeroPassageiros; }
    public boolean isCompartilhada()  { return compartilhada; }

    //SETTERS
    public void setNumeroPassageiros(int numeroPassageiros) { this.numeroPassageiros = numeroPassageiros; }
    public void setIsCompartilhada(boolean compartilhada)   { this.compartilhada = compartilhada; }
}