package gerenciamento;

// O pacote de gerenciamento deverá possuir uma classe do tipo interface: IAdministrador, e a assinatura de dois métodos,
// cadastrarMotorista e cadastrarCliente. A classe Administrador do exercício incremental 3.1 permanece com as mesmas
// funcionalidades, e passa a poder também realizar o cadastro de Clientes e Motoristas, implementando a interface IAdministrador.
// Uma nova classe CadastroCliente também deve implementar a interface IAdministrador, mas essa deverá apenas poder cadastrar Clientes
// e Motoristas (essa classe CadastroCliente  poderá ser utilizada por clientes ou motoristas que optem por realizar seu próprio cadastro no sistema,
// ou um administrador do sistema poderá realizar essa tarefa). Ao cadastrar um motorista, o sistema deve também cadastrar um veículo e vincular ao
// novo motorista cadastrado.

import sistema.*;

public interface IAdministrador {
    Motorista cadastrarMotorista(Ufber sistema, String nome, String telefone,
                                 String cpf, TipoContrato contrato);
    Cliente cadastrarCliente(Ufber sistema, String nomeCompleto, String telefone,
                             String cpf, TipoEndereco enderecoCasa);
}
