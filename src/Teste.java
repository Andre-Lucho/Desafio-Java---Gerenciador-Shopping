public class Teste {
        public static void main(String[] args) throws Exception {

            Loja loja = new Loja("Teste", 1, 3);

            Produto prod1 = new Produto("tenis", 1000);
            Produto prod2 = new Produto("raquete", 3000);
            Produto prod3 = new Produto("bola", 200);

            Produto[] lista = new Produto[]{prod1, prod2, prod3};

            loja.setEstoqueProdutos(lista);

            // System.out.println(loja.getEstoqueProdutos());
            
            System.out.println(loja);


        }

}
