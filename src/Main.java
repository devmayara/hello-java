import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Tabuada");
            System.out.println("2 - Calculo IMC");
            System.out.println("3 - Pares ou Impares");
            System.out.println("4 - Divisivel pelo primeiro");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            var opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> exercicio1(scanner);
                case 2 -> exercicio2(scanner);
                case 3 -> exercicio3(scanner);
                case 4 -> exercicio4(scanner);
                case 0 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opcao invalida!");
            }
        }
    }

    static void exercicio1(Scanner scanner) {
        System.out.print("Digite um numero: ");
        var num = scanner.nextInt();
        for (var i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d\n", num, i, num * i);
        }
    }

    static void exercicio2(Scanner scanner) {
        // a ser implementado
    }

    static void exercicio3(Scanner scanner) {
        // a ser implementado
    }

    static void exercicio4(Scanner scanner) {
        // a ser implementado
    }
}
