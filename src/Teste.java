public class Teste {
    public static void main(String[] args) throws Exception {

        // Loja loja = new Loja("Teste", 1, 3);
        Produto bolo = new Produto("bolo", 1000);
        Produto pizza = new Produto("pizza", 3000);
        Produto cafe = new Produto("café", 200);
        Produto[] lista = new Produto[] { bolo, pizza, cafe };

        Produto batom = new Produto("batom", 30);
        Produto po = new Produto("po", 40);
        Produto[] lista2 = new Produto[]{batom, po};

        Produto monitor = new Produto("monitor", 250);
        Produto gpu = new Produto("gpu", 1500);
        Produto[] lista3 = new Produto[]{monitor, gpu};

        Alimentacao alim1 = new Alimentacao("Loja Alimentacao1", 1, 0, null, null, 3, null);
        Cosmetico cosmet1 = new Cosmetico("Loja Cosmetico1", 1 , 1500, null, null, 2, 1000);
        Informatica info1 = new Informatica("Loja informatica1", 4, 2000, null, null, 2, 0);
        Informatica info2 = new Informatica("Loja informatica2", 2, 1200, null, null, 2, 0);
        Loja[] lojas = new Loja[]{alim1, cosmet1, info1, info2};
        
        Shopping shop1 = new Shopping("novoShopping", null, 3);
        
        alim1.setEstoqueProdutos(lista);
        cosmet1.setEstoqueProdutos(lista2);
        info1.setEstoqueProdutos(lista3);
        info2.setEstoqueProdutos(lista3);
        
        shop1.setLojas(lojas);
        System.out.println(shop1.quantidadeLojasPorTipo("informática"));

    }

}
