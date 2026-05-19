import java.util.Arrays;
import java.util.List;
import java.text.Normalizer;

public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    public Shopping(String nome, Endereco endereco, int quantLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[quantLojas];
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public Loja[] getLojas() {
        return lojas;
    }
    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }

    public boolean insereLoja(Loja loja) {
        if (loja != null) {
            for (int i = 0; i < lojas.length; i++) {
                if (lojas[i] == null) {
                    lojas[i] = loja;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeLoja(String loja) {
        if (loja != null) {
            for (int i = 0; i < lojas.length; i++) {
                if (loja == lojas[i].getNome()) {
                    lojas[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    private String normalizarString(String texto) {
        if (texto == null)
            return "";

        String stringNormalizada = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase()
                .trim();
        return stringNormalizada;
    }
    public int quantidadeLojasPorTipo(String tipo) {
        String tipoBusca = normalizarString(tipo);

        List<String> validos = Arrays.asList(
                "cosmetico", "vestuario", "bijuteria", "alimentacao", "informatica");

        if (!validos.contains(tipoBusca))
            return -1;

        int cont = 0;
        for (Loja loja : lojas) {
            if (loja != null && loja.getTipoDeNegocio().equals(tipoBusca))
                cont++;
        }
        return cont;
    }

    public Informatica lojaSeguroMaisCaro() {
        List<Informatica> lojasInfo = {};
        List<double> valoresSeguro = {};
        
        for(Loja loja : lojas){
            if((loja.getTipoDeNegocio()).equals("informatica")){
                // alimentar a lista 'lojasInfo'
            }

        }

        for(List lojas : lojasInfo){
            if(lojasInfo != null){
                    loja.getSeguroEletronicos();
                }
        }

        // metodo para comparar e retornar o valor mais alto
                
        return null;
    }

    @Override
    public String toString() {
        return String.format("Nome Shopping: %s, Endereço: %s, Lojas: %s", nome, endereco, Arrays.toString(lojas));
    }
}
