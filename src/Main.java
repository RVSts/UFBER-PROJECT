import gerenciamento.Administrador;
import gerenciamento.CadastroCliente;
import gerenciamento.IAdministrador;
import sistema.*;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Ufber sistema = new Ufber();

        Cliente cliente = new Cliente("João Silva", "71999998888", "11122233344", TipoEndereco.CASA);
        sistema.cadastrarCliente(cliente);

        Corrida corrida = new Prolabore(
                LocalDateTime.now(),
                null, // trajeto não definido
                null,
                cliente,
                2,
                false
        );
        sistema.cadastrarCorrida(corrida);

        Trajeto trajeto = new Trajeto(TipoEndereco.CAMPUS_ONDINA, TipoEndereco.CASA, 15.5f);
        sistema.cadastrarTrajeto(trajeto);

        Motorista motorista = new Motorista("Carlos Motorista", "71999996666", "99988877766", TipoContrato.PRO_LABORE);
        Veiculo veiculo = new Veiculo(TipoVeiculo.CARRO, "Fiat Uno", "Vermelho", "ABC1D23");
        motorista.adicionarVeiculo(veiculo);
        sistema.cadastrarMotorista(motorista);

        corrida.setTrajeto(trajeto);
        sistema.atribuirMotorista(corrida, motorista);

        corrida.finalizarCorrida("Cartão de crédito");

        corrida.exibirDetalhes();
    }
}