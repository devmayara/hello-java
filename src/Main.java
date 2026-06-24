import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Conta Bancaria");
            System.out.println("2 - Carro");
            System.out.println("3 - Maquina de Banho");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            var opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> exercicio1(scanner);
                case 2 -> exercicio2(scanner);
                case 3 -> exercicio3(scanner);
                case 0 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opcao invalida!");
            }
        }
    }

    static void exercicio1(Scanner scanner) {
        System.out.print("Digite o valor do deposito inicial: R$");
        var deposito = scanner.nextDouble();
        var conta = new ContaBancaria(deposito);

        while (true) {
            System.out.println("\n=== CONTA BANCARIA ===");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Consultar cheque especial");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - Sacar dinheiro");
            System.out.println("5 - Pagar boleto");
            System.out.println("6 - Verificar uso do cheque especial");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            var opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> System.out.printf("Saldo atual: R$%.2f\n", conta.consultarSaldo());
                case 2 -> System.out.printf("Cheque especial disponivel: R$%.2f\n", conta.consultarChequeEspecial());
                case 3 -> {
                    System.out.print("Valor para depositar: R$");
                    conta.depositar(scanner.nextDouble());
                }
                case 4 -> {
                    System.out.print("Valor para sacar: R$");
                    conta.sacar(scanner.nextDouble());
                }
                case 5 -> {
                    System.out.print("Valor do boleto: R$");
                    conta.pagarBoleto(scanner.nextDouble());
                }
                case 6 -> {
                    if (conta.verificarUsoChequeEspecial()) {
                        System.out.println("A conta esta usando cheque especial.");
                    } else {
                        System.out.println("A conta nao esta usando cheque especial.");
                    }
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opcao invalida!");
            }
        }
    }

    static void exercicio2(Scanner scanner) {
        System.out.println("Em construcao...");
    }

    static void exercicio3(Scanner scanner) {
        System.out.println("Em construcao...");
    }
}
