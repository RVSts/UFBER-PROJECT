package sistema;

public class Veiculo {
    private TipoVeiculo tipo;
    private String modelo;
    private String cor;
    private String placa;

    public Veiculo(TipoVeiculo tipo, String modelo,
                   String cor, String placa)
    {
        this.tipo   = tipo;
        this.modelo = modelo;
        this.cor    = cor;
        this.placa  = placa;
    }

    //GETTERS
    public TipoVeiculo getTipo() { return tipo; }
    public String getModelo()    { return modelo; }
    public String getCor()       { return cor; }
    public String getPlaca()     { return placa; }

    //SETTERS
    public void setTipo(TipoVeiculo tipo) { this.tipo = tipo; }
    public void setModelo(String modelo)  { this.modelo = modelo; }
    public void setCor(String cor)        { this.cor = cor; }
    public void setPlaca(String placa)    { this.placa = placa; }
}
