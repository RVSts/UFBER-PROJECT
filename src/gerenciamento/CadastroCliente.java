package gerenciamento;

import sistema.*;

import java.util.Scanner;

public class CadastroCliente implements IAdministrador{
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

}
