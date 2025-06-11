package sistema;

public class Pagamento {
    private double valorFinal;
    private String metodo;
    private String status;

    public Pagamento(double valorFinal,
                     String metodo,
                     String status)
    {
        this.valorFinal = valorFinal;
        this.metodo = metodo;
        this.status = status;
    }

    //GETTERS
    public double getValorFinal() { return valorFinal; }
    public String getMetodo()     { return metodo; }
    public String getStatus()     { return status; }

    //SETTERS
    public void setValorFinal(double valorFinal) { this.valorFinal = valorFinal; }
    public void setMetodo(String metodo)         { this.metodo = metodo; }
    public void setStatus(String status)         { this.status = status; }
}
