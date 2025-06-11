package sistema;

public class Usuario {
    protected String nomeCompleto;
    protected String telefone;
    protected String cpf;

    public Usuario(String nomeCompleto, String telefone,
                   String cpf) {
        this.nomeCompleto = nomeCompleto;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    // GETTERS
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public String getTelefone()     { return telefone; }
    public String getCpf()          { return cpf; }

    // SETTERS
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    public void setTelefone(String telefone)         { this.telefone = telefone; }
    public void setCpf(String cpf)                   { this.cpf = cpf; }
}
