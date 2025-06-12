package sistema;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private String status;
    private TipoEndereco enderecoCasa;
    private List<Corrida> historicoCorridas = new ArrayList<>();

    public Cliente(String nomeCompleto, String telefone,
                   String cpf,
                   TipoEndereco enderecoCasa)
    {
        super(nomeCompleto, telefone, cpf);
        this.enderecoCasa = enderecoCasa;
        this.status = "ativo";
    }

    public void adicionarServico(Corrida corrida) {
        historicoCorridas.add(corrida);
    }

    public void visualizarHistorico() {
        System.out.println("\nHistórico de Serviços do Cliente: " + getNomeCompleto());
        System.out.println("Status: " + status);
        for (Corrida corrida : historicoCorridas) {
            corrida.exibirDetalhes();
        }
    }

    // GETTERS
    public String getStatus()             { return status; }
    public TipoEndereco getEnderecoCasa() { return enderecoCasa; }

    // SETTERS
    public void setStatus(String status)                   { this.status = status; }
    public void setEnderecoCasa(TipoEndereco enderecoCasa) { this.enderecoCasa = enderecoCasa; }
}
