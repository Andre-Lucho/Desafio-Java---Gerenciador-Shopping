public class Loja {
    private String nome;
    private int quantidadeFuncionarios;
    private double salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;
    private Produto[] estoqueProdutos;

    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data data, int quantProdutos) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = data;
        this.estoqueProdutos = new Produto[quantProdutos];
    }
    public Loja(String nome, int quantidadeFuncionarios, Endereco endereco, Data data, int quantProdutos) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1;
        this.endereco = endereco;
        this.dataFundacao = data;
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
        for(Produto prod : estoqueProdutos) System.out.println(prod);
        
        return estoqueProdutos;
    }
    public void setEstoqueProdutos(Produto[] estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
    }

    public double gastosComSalario() {
        if (salarioBaseFuncionario != -1) {
            return quantidadeFuncionarios * salarioBaseFuncionario;
        } else {
            return -1.0;
        }
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

    @Override
    public String toString() {
        return String.format("Nome da loja: %s, \nN. total de Funcionários: %d, \nSalário Base: %2f, %s, Data de fundação: %s, \nEstoque de Produtos: %s", nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, this.getEstoqueProdutos());
    }

}
