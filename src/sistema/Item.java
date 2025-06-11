package sistema;

public class Item {
    private String descricao;
    private boolean urgente;

    public Item(String descricao, boolean urgente)
    {
        this.descricao = descricao;
        this.urgente = urgente;
    }

    //GETTERS
    public String getDescricao() { return descricao; }
    public boolean isUrgente() { return urgente; }
}
