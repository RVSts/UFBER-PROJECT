package sistema;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private String status;
    private TipoEndereco enderecoCasa;
    private List<Servico> historicoServicos = new ArrayList<>();

    public Cliente(String nomeCompleto, String telefone,
                   String cpf,
                   TipoEndereco enderecoCasa)
    {
        super(nomeCompleto, telefone, cpf);
        this.enderecoCasa = enderecoCasa;
        this.status = "ativo";
    }

    public void adicionarServico(Servico servico) {
        historicoServicos.add(servico);
    }

    public void visualizarHistorico() {
        System.out.println("\nHistórico de Serviços do Cliente: " + getNomeCompleto());
        System.out.println("Status: " + status);
        for (Servico servico : historicoServicos) {
            servico.exibirDetalhes();
        }
    }

    // GETTERS
    public String getStatus()             { return status; }
    public TipoEndereco getEnderecoCasa() { return enderecoCasa; }

    // SETTERS
    public void setStatus(String status)                   { this.status = status; }
    public void setEnderecoCasa(TipoEndereco enderecoCasa) { this.enderecoCasa = enderecoCasa; }
}
