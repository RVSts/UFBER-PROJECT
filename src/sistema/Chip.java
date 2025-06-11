package sistema;

public class Chip {
    private Usuario usuario;
    private String numero;
    private double saldo;
    private String protocolo;
    private boolean ativo;
    private String plano;

    public Chip(Usuario usuario, String numero, double saldo, String protocolo, boolean ativo, String plano) {
        this.usuario = usuario;
        this.numero = numero;
        this.saldo = saldo;
        this.protocolo = protocolo;
        this.ativo = ativo;
        this.plano = plano;
    }

    public void imprimirDados() {
        System.out.println("Usuário: " + usuario.getNomeCompleto());
        System.out.println("CPF: " + usuario.getCpf());
        System.out.println("Número: " + numero);
        System.out.println("Saldo: " + saldo);
        System.out.println("Protocolo: " + protocolo);
        System.out.println("Status: " + (ativo ? "Ativo" : "Inativo"));
        System.out.println("Plano: " + plano);
    }
}
