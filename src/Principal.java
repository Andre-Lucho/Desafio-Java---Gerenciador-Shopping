import java.util.Scanner;

public class Principal {
    static Scanner input = new Scanner(System.in);

    static Loja loja;
    static Produto produto;

    public static Loja criarLoja() {
        System.out.println("Digite um nome para a nova loja: ");
        String nomeLoja = input.next();

        System.out.println("Digite quantos funcionários essa loja possui: ");
        int quantFuncionarios = input.nextInt();

        System.out.println("Digite um salário-base para os funcionários, caso necessário: (formato = 1000,00)");
        double salarioBase = input.nextDouble();

        System.out.println(
                "Digite a data de fundação da loja, caso necessário: (utilizar apenas números - formato: 01 05 2026)");
        System.out.println("Digite o dia: ");
        int dia = input.nextInt();
        System.out.println("Digite o mês: ");
        int mes = input.nextInt();
        System.out.println("Digite o ano: ");
        int ano = input.nextInt();

        Endereco endereco = new Endereco("Av. Carlos Gomes", "2004", "01", "Porto Alegre", "RS", "90900-900", "Brasil");
        Data dataFundacao = new Data(dia, mes, ano);

        Loja loja = new Loja(nomeLoja, quantFuncionarios, salarioBase, endereco, dataFundacao);
        System.out.println("Loja Criada com sucesso!");
        System.out.println(loja);

        return loja;
    };

    public static Produto criarProduto() {
        System.out.println("Digite um nome para o novo produto: ");
        String nomeProduto = input.next();

        System.out.println("Digite um preço para o produto: (formato = 100,00)");
        double precoProduto = input.nextDouble();

        System.out.println("Digite a data de validade do produto: (utilizar apenas números - formato: 01 05 2026)");
        System.out.println("Digite o dia: ");
        int validadeDia = input.nextInt();
        System.out.println("Digite o mês: ");
        int validadeMes = input.nextInt();
        System.out.println("Digite o ano: ");
        int validadeAno = input.nextInt();
        Data validade = new Data(validadeDia, validadeMes, validadeAno);

        Produto produto = new Produto(nomeProduto, precoProduto, validade);
        System.out.println("Produto criado com sucesso!");

        return produto;
    };

    public static void main(String[] args) throws Exception {
        int opcao;

        do {
            System.out.println("Menu:\n(1)Criar uma loja \n(2)Criar um produto \n(3)Sair");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    loja = criarLoja();
                    break;
                case 2:
                    if(loja == null){
                        System.out.println("Primeiramente, vamos criar uma nova Loja: ");
                        loja = criarLoja();
                        System.out.println("Agora, vamos a criação do novo produto:");
                    }
                
                    produto = criarProduto();
                    Boolean novoProduto = produto.estaVencido(new Data(20, 10, 2023));

                    if(novoProduto) System.out.println("PRODUTO VENCIDO");
                    else System.out.println("PRODUTO NÃO VENCIDO");
                    break;
                case 3:
                    System.out.println("Saindo do Menu...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

        } while (opcao != 3);
        input.close();

    }
}
