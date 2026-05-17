public class Alimentacao extends Loja{
    private Data dataAlvara;

    public Alimentacao(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco,
            Data dataFundacao, int quantProdutos, Data dataAlvara) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, quantProdutos);
        this.dataAlvara = dataAlvara;
    }

    public Data getDataAlvara() {
        return dataAlvara;
    }
    public void setDataAlvara(Data dataAlvara) {
        this.dataAlvara = dataAlvara;
    }
    
    @Override
    public String toString() {
        return String.format("Nome da loja: %s, \nN. total de Funcionários: %d, \nSalário Base: %2f, \n%s, \nData de fundação: %s, \nData do Alvará de Funcionamento: %s", getNome(), getQuantidadeFuncionarios(), getSalarioBaseFuncionario(), getEndereco(), getDataFundacao(), this.dataAlvara);
    }
}
