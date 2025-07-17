package gerenciamento;

import sistema.*;
import java.util.Scanner;

public class Administrador extends Usuario implements IAdministrador {
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

    //CRIAÇÃO DE CADASTRO

    @Override
    public Motorista cadastrarMotorista(Ufber sistema, String nome, String telefone,
                                   String cpf, TipoContrato contrato)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe os dados do veículo\n");

        System.out.println("Informe o tipo do veículo: ");
        String tipo = scanner.nextLine();

        System.out.println("Informe o modelo do veículo: ");
        String modelo = scanner.nextLine();

        System.out.println("Informe a placa do veículo: ");
        String cor = scanner.nextLine();

        System.out.println("Informe a cor do veículo: ");
        String placa = scanner.nextLine();

        TipoVeiculo tipoVeiculo = converterVeiculo(tipo);
        Veiculo veiculo = new Veiculo(tipoVeiculo, modelo, cor, placa);

        Motorista motorista = new Motorista(nome, telefone, cpf, contrato);
        motorista.adicionarVeiculo(veiculo);

        sistema.cadastrarMotorista(motorista);
        return motorista;
    }

    @Override
    public Cliente cadastrarCliente(Ufber sistema, String nomeCompleto, String telefone,
                                 String cpf, TipoEndereco enderecoCasa)
    {
        Cliente cliente = new Cliente(nomeCompleto, telefone, cpf, enderecoCasa);
        sistema.cadastrarCliente(cliente);
        return cliente;
    }

    //CONVERTER STRING TO VEICULO
    public TipoVeiculo converterVeiculo(String tipoVeiculo) {
        TipoVeiculo tipoVeiculo1 = null;
        try {
            tipoVeiculo1 = TipoVeiculo.valueOf(tipoVeiculo.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de veiculo invalido");
        }
        return tipoVeiculo1;
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
