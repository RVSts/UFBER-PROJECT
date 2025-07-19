package sistema;

import java.time.LocalDateTime;

public class Entrega extends Corrida {
    private Cliente destinatario;
    private Cliente remetente;
    private Item item;
    private boolean pego;

    public Entrega(LocalDateTime horario,
                   Trajeto trajeto,
                   Motorista motorista,
                   Cliente remetente,
                   Cliente destinatario,
                   Item item)
    {
        super(horario, trajeto, motorista, remetente);
        this.destinatario = destinatario;
        this.item = item;
        this.pego = false;

        if (trajeto != null && motorista != null) {
            calcularEAtualizarValor();
        }
    }

    @Override
    public double calcularValorCorrida(Trajeto trajeto, Corrida corrida) {
        if (motorista == null || motorista.getVeiculos().isEmpty()) {
            return 0.0; // Retorna 0 se motorista ou veículo não estiverem disponíveis
        }

        Veiculo veiculo = motorista.getVeiculos().get(0);
        double fator = (veiculo.getTipo() == TipoVeiculo.MOTO) ? 0.5 : 0.8;
        return trajeto.getDistanciaKm() * fator;
    }

    //GETTERS
    public Item getItem()   { return item; }
    public boolean isPego() { return pego; }
    public String getNomeRemetente() { return remetente.getNomeCompleto(); }
    public String getTelefoneRemetente() { return remetente.getTelefone(); }
    public String getNomeDestinatario() { return destinatario.getNomeCompleto(); }
    public String getTelefoneDestinatario() { return destinatario.getTelefone(); }

    //SETTERS
    public void setItem(Item item)      { this.item = item; }
    public void setIsPego(boolean pego) { this.pego = pego; }
}