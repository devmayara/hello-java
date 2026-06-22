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
        System.out.print("Digite sua altura (m): ");
        var altura = scanner.nextDouble();
        System.out.print("Digite seu peso (kg): ");
        var peso = scanner.nextDouble();

        var imc = peso / (altura * altura);
        System.out.printf("Seu IMC: %.2f\n", imc);

        String classificacao;
        if (imc <= 18.5) {
            classificacao = "Abaixo do peso";
        } else if (imc <= 24.9) {
            classificacao = "Peso ideal";
        } else if (imc <= 29.9) {
            classificacao = "Levemente acima do peso";
        } else if (imc <= 34.9) {
            classificacao = "Obesidade Grau I";
        } else if (imc <= 39.9) {
            classificacao = "Obesidade Grau II (Severa)";
        } else {
            classificacao = "Obesidade III (Morbida)";
        }
        System.out.println("Classificacao: " + classificacao);
    }

    static void exercicio3(Scanner scanner) {
        System.out.print("Digite o primeiro numero: ");
        var num1 = scanner.nextInt();
        System.out.print("Digite o segundo numero (maior que o primeiro): ");
        var num2 = scanner.nextInt();

        if (num2 <= num1) {
            System.out.println("O segundo numero deve ser maior que o primeiro!");
            return;
        }

        System.out.print("Par ou impar? ");
        var tipo = scanner.next();

        System.out.println("Numeros " + tipo + "es em ordem decrescente:");
        for (var i = num2; i >= num1; i--) {
            var ehPar = i % 2 == 0;
            if (tipo.equalsIgnoreCase("par") && ehPar) {
                System.out.println(i);
            } else if (tipo.equalsIgnoreCase("impar") && !ehPar) {
                System.out.println(i);
            }
        }
    }

    static void exercicio4(Scanner scanner) {
        // a ser implementado
    }
}
