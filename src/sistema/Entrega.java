package sistema;

import java.time.LocalDateTime;

public class Entrega extends Servico {
    private Item item;
    private boolean pego;

    public Entrega(LocalDateTime dataHora,
                   Trajeto trajeto,
                   Motorista motorista,
                   Cliente cliente,
                   Item item)
    {
        super(dataHora, trajeto, motorista, cliente);
        this.item = item;
        this.pego = false;
    }

    @Override
    public void calcularCorrida() {
        Veiculo veiculo = motorista.getVeiculos().get(0);
        double fator = (veiculo.getTipo() == TipoVeiculo.MOTO) ? 0.5 : 0.8;
        valorEstimado = trajeto.getDistanciaKm() * fator;
    }

    //GETTERS
    public Item getItem()   { return item; }
    public boolean isPego() { return pego; }

    //SETTERS
    public void setItem(Item item)      { this.item = item; }
    public void setIsPego(boolean pego) { this.pego = pego; }
}