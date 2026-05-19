public class Vestuario extends Loja{
    private boolean produtosImportados;

    public Vestuario(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao, int quantProdutos, boolean produtosImportados){
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, quantProdutos);
        this.produtosImportados = produtosImportados;
    }

    public boolean getProdutosImportados() {
        return produtosImportados;
    }
    public void setProdutosImportados(boolean produtosImportados) {
        this.produtosImportados = produtosImportados;
    }

    @Override
    public String getTipoDeNegocio() {
        return "vestuario";
    }


    @Override
    public String toString() {
        return String.format("Nome da loja: %s, \nN. total de Funcionários: %d, \nSalário Base: %2f, \n%s, \nData de fundação: %s, \nComercializa prod. importados: %b", getNome(), getQuantidadeFuncionarios(), getSalarioBaseFuncionario(), getEndereco(), getDataFundacao(), this.produtosImportados);
    }
}
