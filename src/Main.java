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
        var carro = new Carro();

        while (true) {
            System.out.println("\n=== CARRO ===");
            System.out.printf("Estado: %s | Velocidade: %dkm | Marcha: %d\n",
                carro.isLigado() ? "Ligado" : "Desligado",
                carro.verificarVelocidade(),
                carro.getMarcha());
            System.out.println("1 - Ligar carro");
            System.out.println("2 - Desligar carro");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Diminuir velocidade");
            System.out.println("5 - Virar para esquerda");
            System.out.println("6 - Virar para direita");
            System.out.println("7 - Verificar velocidade");
            System.out.println("8 - Trocar marcha");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            var opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> carro.ligar();
                case 2 -> carro.desligar();
                case 3 -> carro.acelerar();
                case 4 -> carro.diminuirVelocidade();
                case 5 -> carro.virar("esquerda");
                case 6 -> carro.virar("direita");
                case 7 -> System.out.printf("Velocidade atual: %dkm\n", carro.verificarVelocidade());
                case 8 -> {
                    System.out.print("Digite a marcha desejada (0-6): ");
                    carro.trocarMarcha(scanner.nextInt());
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opcao invalida!");
            }
        }
    }

    static void exercicio3(Scanner scanner) {
        var maquina = new MaquinaBanho();

        while (true) {
            System.out.println("\n=== MAQUINA DE BANHO ===");
            System.out.printf("Agua: %dL/30L | Shampoo: %dL/10L | Pet: %s | Maquina: %s\n",
                maquina.verificarNivelAgua(),
                maquina.verificarNivelShampoo(),
                maquina.verificarPet() ? "Sim" : "Nao",
                maquina.isMaquinaSuja() ? "Suja" : maquina.verificarPet() ? "Ocupada" : "Disponivel");
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 - Abastecer com agua");
            System.out.println("3 - Abastecer com shampoo");
            System.out.println("4 - Verificar nivel de agua");
            System.out.println("5 - Verificar nivel de shampoo");
            System.out.println("6 - Verificar se tem pet no banho");
            System.out.println("7 - Colocar pet na maquina");
            System.out.println("8 - Retirar pet da maquina");
            System.out.println("9 - Limpar maquina");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            var opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> maquina.darBanho();
                case 2 -> maquina.abastecerAgua();
                case 3 -> maquina.abastecerShampoo();
                case 4 -> System.out.printf("Nivel de agua: %dL/30L\n", maquina.verificarNivelAgua());
                case 5 -> System.out.printf("Nivel de shampoo: %dL/10L\n", maquina.verificarNivelShampoo());
                case 6 -> System.out.println(maquina.verificarPet() ? "Tem pet na maquina." : "Nao tem pet na maquina.");
                case 7 -> maquina.colocarPet();
                case 8 -> maquina.retirarPet();
                case 9 -> maquina.limparMaquina();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opcao invalida!");
            }
        }
    }
}
