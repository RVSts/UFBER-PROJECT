package gerenciamento;

import sistema.*;

public class Administrador extends Usuario {
    private String nome;
    private String matricula;
    private String cpf;

    public Administrador(String nome, String matricula, String cpf)
    {
        super(nome, null, cpf);
        this.matricula = matricula;
    }


    // MODIFICAÇÕES SOBRE TRAJETO

    public void editarTrajeto(Trajeto trajeto, TipoEndereco novaOrigem,
                              TipoEndereco novoDestino, double novaDistancia)
    {
        trajeto.setOrigem(novaOrigem);
        trajeto.setDestino(novoDestino);
        trajeto.setDistanciaKm(novaDistancia);
    }


    public void criarTrajeto(Ufber sistema, TipoEndereco origem,
                             TipoEndereco destino, double distancia)
    {
        Trajeto novoTrajeto = new Trajeto(origem, destino, distancia);
        sistema.cadastrarTrajeto(novoTrajeto);
    }

    public void removerTrajeto(Ufber sistema, Trajeto trajeto)
    {
        sistema.removerTrajeto(trajeto);
    }

    //MODIFICAÇÕES SOBRE CLIENTE

    public void editarCliente(Cliente cliente, String novoTelefone, TipoEndereco novoEndereco)
    {
        cliente.setTelefone(novoTelefone);
        cliente.setEnderecoCasa(novoEndereco);
    }

    public void bloquearCliente(Cliente cliente)
    {
        cliente.setStatus("bloqueado");
    }

    public void removerCliente(Ufber sistema, Cliente cliente)
    {
        sistema.removerCliente(cliente);
    }

    //MODIFICAÇÕES SOBRE MOTORISTA
    public void editarMotorista(Motorista motorista, String novoTelefone, TipoContrato novoContrato) {
        motorista.setTelefone(novoTelefone);
        motorista.setContrato(novoContrato);
    }

    public void bloquearMotorista(Motorista motorista) {
        motorista.setStatus("Bloqueado");
    }

    public void excluirMotorista(Ufber sistema, Motorista motorista) {
        sistema.removerMotorista(motorista);
    }

    // GETTERS & SETTERS

    public String getMatricula() { return matricula; }

    public void setMatricula(String matricula) { this.matricula = matricula; }

}
