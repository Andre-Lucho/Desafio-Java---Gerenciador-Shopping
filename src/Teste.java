public class Teste {
    public static void main(String[] args) throws Exception {
        Data data = new Data(17, 05, 2026);

        Produto prod = new Produto("teste", 1000, new Data(20, 10, 2026));
        System.out.println(prod.getDataValidade());

        System.out.println(prod.estaVencido());

    }
}
