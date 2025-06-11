package sistema;

public class Motor {
    private int potencia;
    private String tipo;

    public Motor(int potencia, String tipo) {
        this.potencia = potencia;
        this.tipo = tipo;
    }

    public String getInfo() {
        return tipo + " de " + potencia + "cv";
    }
}
