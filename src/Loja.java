import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Loja {
    private String nome;
    private int quantidadeFuncionarios;
    private double salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;
    private Produto[] estoqueProdutos;

    private List<Produto> estoqueProdutos1; 
    // Lista com interface <Produto> tipo ArrayList == lista dinâmica
    private int limiteMaximo;
    // variavel auxiliar(como um cont) do tam da lista

    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data datadataFundacao,
            int quantProdutos) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = datadataFundacao;
        this.estoqueProdutos = new Produto[quantProdutos];
    }

    public Loja(String nome, int quantidadeFuncionarios, Endereco endereco, Data dataFundacao, int quantProdutos) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos = new Produto[quantProdutos];
    }

    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, int quantProdutos) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.estoqueProdutos = new Produto[quantProdutos];
    }

    public Loja(String nome, int quantidadeFuncionarios, int quantProdutos) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1;
        this.estoqueProdutos = new Produto[quantProdutos];
    }

    public Loja(String nome, int quantidadeFuncionarios, Data dataFundacao, int limiteMaximo) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos1 = new ArrayList<>();
        this.limiteMaximo = limiteMaximo;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }

    public double getSalarioBaseFuncionario() {
        return salarioBaseFuncionario;
    }

    public void setSalarioBaseFuncionario(double salarioBaseFuncionario) {
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Data getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Data data) {
        this.dataFundacao = data;
    }

    public Produto[] getEstoqueProdutos() {
        return estoqueProdutos;
    }

    public void setEstoqueProdutos(Produto[] estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
    }

    public double gastosComSalario() {
        if (salarioBaseFuncionario != -1) return quantidadeFuncionarios * salarioBaseFuncionario;
        else return -1.0;
    }

    public char tamanhoDaLoja() {
        int func = this.quantidadeFuncionarios;
        if (func < 10) {
            return 'P';
        } else if (func >= 10 && func <= 30) {
            return 'M';
        } else if (func >= 31) {
            return 'G';
        }
        return 'e';
    }

    public void imprimeProdutos() {
        for (Produto prod : estoqueProdutos)
            System.out.println(prod);
    }

    public boolean insereProduto(Produto produto) {
        if (produto != null) {
            for (int i = 0; i < estoqueProdutos.length; i++) {
                if (estoqueProdutos[i] == null) {
                    estoqueProdutos[i] = produto;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean insereProduto2(Produto produto){
        if(produto == null) return false;
        if(estoqueProdutos1.size() < limiteMaximo) return estoqueProdutos1.add(produto);
        
        return false;
    }

    public boolean removeProduto(String produto) {
        if (produto != null) {
            for (int i = 0; i < estoqueProdutos.length; i++) {
                if (estoqueProdutos[i] != null && estoqueProdutos[i].getNome().equals(produto)) {
                    estoqueProdutos[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

        public boolean removeProduto2(String produto) {
        if (produto != null) return false;

        return estoqueProdutos1.removeIf(prod -> prod.getNome().equals(produto));
        // removeIf --> remove um elemento se ele atender a uma condição
    }


    public String getTipoDeNegocio() {
        return "Geral";
    }

    @Override
    public String toString() {
        String estoqueFormatado = Arrays.stream(getEstoqueProdutos()).map(prod -> prod == null ? "" : prod.toString())
                .collect(Collectors.joining(" | ", "[", "]"));

        return String.format(
                "Nome da loja: %s, \nN. total de Funcionários: %d, \nSalário Base: %.2f, \nEndereço: %s,\nData de fundação: %s, \nEstoque de Produtos: %s",
                nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, estoqueFormatado);
    }
}
