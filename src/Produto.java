import java.time.LocalDate;

public class Produto {
    private String nome;
    private double preco;
    private Data dataValidade;

    public Produto(String nome, double preco, Data dataValidade) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;
    }

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public Data getDataValidade() {
        return dataValidade;
    }
    public void setDataValidade(Data dataValidade) {
        this.dataValidade = dataValidade;
    }

    public boolean estaVencido(Data data) {
        LocalDate validadeProd = LocalDate.of(dataValidade.getAno(), dataValidade.getMes(),
                dataValidade.getDia());
        LocalDate dataAtual = LocalDate.of(data.getAno(), data.getMes(), data.getDia());

        return validadeProd.isBefore(dataAtual);
    }

    @Override
    public String toString() {
        return String.format("Nome produto: %s, preço: %2f, data de validade: %s", nome, preco, dataValidade);
    }
}
