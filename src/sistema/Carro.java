package sistema;

public class Carro {
    private String modelo;
    private int ano;
    private Motor motor;

    public Carro(String modelo, int ano, int potencia, String tipoMotor) {
        this.modelo = modelo;
        this.ano = ano;
        this.motor = new Motor(potencia, tipoMotor);  // composição forte
    }

    public void exibirInfo() {
        System.out.println(modelo + " - " + ano);
        System.out.println("Motor: " + motor.getInfo());
    }
}
