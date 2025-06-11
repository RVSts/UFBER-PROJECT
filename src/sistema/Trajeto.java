package sistema;

public class Trajeto {
    private TipoEndereco origem;
    private TipoEndereco destino;
    private double distanciaKm;

    public Trajeto(TipoEndereco origem,
                   TipoEndereco destino,
                   double distanciaKm)
    {
        this.origem      = origem;
        this.destino     = destino;
        this.distanciaKm = distanciaKm;
    }

    //GETTERS
    public TipoEndereco getOrigem()  { return this.origem; }
    public TipoEndereco getDestino() { return this.destino; }
    public double getDistanciaKm()   { return this.distanciaKm; }

    //SETTERS
    public void setOrigem(TipoEndereco origem)     { this.origem = origem; }
    public void setDestino(TipoEndereco destino)   { this.destino = destino; }
    public void setDistanciaKm(double distanciaKm) { this.distanciaKm = distanciaKm; }
}
