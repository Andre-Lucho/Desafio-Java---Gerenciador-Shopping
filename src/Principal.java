import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String opcao;
        do {
            System.out.println("Menu:\n(1)Criar uma loja \n(2)Criar um produto \n(3)Sair");
            opcao = input.next();

            switch (opcao) {
                case "1":
                    Loja loja1 =new Loja(opcao, 0, null, null);
                    break;
                case "2":
                    Produto produto1 = new Produto(opcao, 0, null);
                    break;
                case "3":
                    System.out.println("Saindo do Menu...");
                    break;
            
                default:
                    System.out.println("Opção inválida");
                    break;
            }
            
        } while (opcao != "3");
        input.close();

    }
}
