public class Bijuteria extends Loja{
    private double metaVendas;

    public Bijuteria(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao, double metaVendas, int quantProdutos){
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, quantProdutos);
        this.metaVendas = metaVendas;
    }

    public double getMetaVendas() {
        return metaVendas;
    }
    public void setMetaVendas(double metaVendas) {
        this.metaVendas = metaVendas;
    }

    @Override
    public String getTipoDeNegocio() {
        return "bijuteria";
    }

    @Override
    public String toString() {
        return String.format("Nome da loja: %s, \nN. total de Funcionários: %d, \nSalário Base: %2f, \n%s, \nData de fundação: %s, \nMeta de vendas mensais: %2f",  super.getNome(),  super.getQuantidadeFuncionarios(),  super.getSalarioBaseFuncionario(),  super.getEndereco(),  super.getDataFundacao(), this.metaVendas);
    }
}
