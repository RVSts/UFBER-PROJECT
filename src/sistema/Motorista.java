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
    private ArrayList<Veiculo> veiculos;

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


    // GETTERS
    public double getAvaliacaoMedia()       { return avaliacaoMedia; }
    public String getStatus()              { return status;}
    public ArrayList<Veiculo> getVeiculos() { return veiculos; }
    public TipoContrato getContrato()       { return contrato; }

    // SETTERS
    public void setAvaliacaoMedia(double avaliacaoMedia) { this.avaliacaoMedia = avaliacaoMedia; }
    public void setStatus(String status)                 { this.status = status;}
    public void setContrato(TipoContrato contrato)       { this.contrato = contrato; }
    public void setVeiculos(ArrayList<Veiculo> veiculos) { this.veiculos = veiculos; }
}
