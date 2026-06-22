public class Teste {
    public static void main(String[] args) throws Exception {
        Data data = new Data(17, 05, 2026);

        Produto prod = new Produto("teste", 1000, new Data(20, 10, 2026));
        // System.out.println(prod.getDataValidade());

        // System.out.println(prod.estaVencido());

        Loja loja1 = new Loja("arrayNormal", 0, 3);
        Loja arrayListLoja = new Loja("arrayListLoja", 0, data, 3);

        Produto tenis = new Produto("tenis", 300);
        Produto meia = new Produto("meia", 15);
        Produto raquete = new Produto("raquete", 2000);
        Produto[] prods = { tenis, meia, raquete };

        arrayListLoja.insereProduto2(meia);

        // loja1.setEstoqueProdutos(prods);
        arrayListLoja.imprimeProdutos2();

    }
}
