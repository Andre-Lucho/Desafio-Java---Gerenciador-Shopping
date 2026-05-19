import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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
                if (lojas[i] != null && lojas[i].getNome().equals(loja)) {
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
        Informatica lojaMaiorSeguro = null;
        double maiorSeguro = 0;

        for(Loja loja : lojas){
            if(loja instanceof Informatica){ 
                Informatica lojaInfo = (Informatica) loja; // downcasting

                if(lojaInfo.getSeguroEletronicos() > maiorSeguro){
                    maiorSeguro = lojaInfo.getSeguroEletronicos();
                    lojaMaiorSeguro = lojaInfo;
                }
            }
        };

        return lojaMaiorSeguro;
    }

    public Informatica lojaSeguroMaisCaro2() {
        return Arrays.stream(lojas)
            .filter(Objects::nonNull)                 
            .filter(Informatica.class::isInstance)   
            .map(Informatica.class::cast)            
            .max((l1, l2) -> Double.compare(l1.getSeguroEletronicos(), l2.getSeguroEletronicos())) 
            .orElse(null);                          
}

    @Override
    public String toString() {
        return String.format("Nome Shopping: %s, Endereço: %s, Lojas: %s", nome, endereco, Arrays.toString(lojas));
    }
}
