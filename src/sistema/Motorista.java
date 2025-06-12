package sistema;

import java.util.ArrayList;
import java.util.List;

public class Motorista extends Usuario {
    private String nome;
    private String telefone;
    private String cpf;
    private double avaliacaoMedia;
    private String status;

    private TipoContrato contrato;
    private List<Veiculo> veiculos;
    private List<Trajeto> historicoTrajetos = new ArrayList<>();

    public Motorista(String nome, String telefone,
                     String cpf, TipoContrato contrato)
    {
        super(nome, telefone, cpf);
        this.contrato       = contrato;
        this.veiculos       = new ArrayList<>();
        this.avaliacaoMedia = 5.0;
        this.status         = "ativo";
    }

    public void adicionarVeiculo(Veiculo veiculo) { veiculos.add(veiculo); }

    public void adicionarCorrida(Trajeto trajeto) { historicoTrajetos.add(trajeto); }

    public ArrayList<Trajeto> visualizarHistoricoTrajetos() {
        System.out.println("\nHistorico de trajetos de: " + getNomeCompleto());
        System.out.println("Status: " + getStatus());
        for (Trajeto t : historicoTrajetos) {
            t.exibirDetalhes();
        }
        return null;
    }


    // GETTERS
    public double getAvaliacaoMedia()       { return avaliacaoMedia; }
    public String getStatus()              { return status;}
    public List<Veiculo> getVeiculos() { return veiculos; }
    public TipoContrato getContrato()       { return contrato; }

    // SETTERS
    public void setAvaliacaoMedia(double avaliacaoMedia) { this.avaliacaoMedia = avaliacaoMedia; }
    public void setStatus(String status)                 { this.status = status;}
    public void setContrato(TipoContrato contrato)       { this.contrato = contrato; }
    public void setVeiculos(ArrayList<Veiculo> veiculos) { this.veiculos = veiculos; }
}
