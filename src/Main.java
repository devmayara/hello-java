import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Ingressos");
            System.out.println("2 - Usuarios");
            System.out.println("3 - Relogios");
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
        System.out.print("Digite o valor do ingresso: R$");
        var valor = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Digite o nome do filme: ");
        var filme = scanner.nextLine();
        System.out.print("Dublado? (s/n): ");
        var resp = scanner.nextLine();
        var dublado = resp.equalsIgnoreCase("s");

        var ingresso = new Ingresso(valor, filme, dublado);

        while (true) {
            System.out.println("\n=== INGRESSOS ===");
            System.out.printf("Filme: %s | Valor base: R$%.2f | %s\n",
                ingresso.getNomeFilme(), ingresso.getValor(),
                ingresso.isDublado() ? "Dublado" : "Legendado");
            System.out.println("1 - Ver valor ingresso normal");
            System.out.println("2 - Ver valor meia entrada");
            System.out.println("3 - Ver valor ingresso familia");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            var opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> System.out.printf("Ingresso normal: R$%.2f\n", ingresso.getValorReal());
                case 2 -> {
                    var meia = new MeiaEntrada(valor, filme, dublado);
                    System.out.printf("Meia entrada: R$%.2f\n", meia.getValorReal());
                }
                case 3 -> {
                    System.out.print("Numero de pessoas: ");
                    var pessoas = scanner.nextInt();
                    var familia = new IngressoFamilia(valor, filme, dublado, pessoas);
                    System.out.printf("Ingresso familia (%d pessoas): R$%.2f\n", pessoas, familia.getValorReal());
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opcao invalida!");
            }
        }
    }

    static void exercicio2(Scanner scanner) {
        System.out.println("\n=== USUARIOS ===");
        var gerente = new Gerente("Carlos", "carlos@email.com", "123");
        var vendedor = new Vendedor("Ana", "ana@email.com", "456");
        var atendente = new Atendente("Pedro", "pedro@email.com", "789");

        while (true) {
            System.out.println("\nEscolha o tipo de usuario:");
            System.out.println("1 - Gerente");
            System.out.println("2 - Vendedor");
            System.out.println("3 - Atendente");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            var tipo = scanner.nextInt();

            switch (tipo) {
                case 1 -> menuGerente(scanner, gerente);
                case 2 -> menuVendedor(scanner, vendedor);
                case 3 -> menuAtendente(scanner, atendente);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opcao invalida!");
            }
        }
    }

    static void menuGerente(Scanner scanner, Gerente gerente) {
        while (true) {
            System.out.printf("\n=== GERENTE: %s ===\n", gerente.getNome());
            System.out.println("1 - Realizar login");
            System.out.println("2 - Realizar logoff");
            System.out.println("3 - Gerar relatorio financeiro");
            System.out.println("4 - Consultar vendas");
            System.out.println("5 - Alterar dados");
            System.out.println("6 - Alterar senha");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            var opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> gerente.realizarLogin();
                case 2 -> gerente.realizarLogoff();
                case 3 -> gerente.gerarRelatorioFinanceiro();
                case 4 -> gerente.consultarVendas();
                case 5 -> {
                    System.out.print("Novo nome: ");
                    var nome = scanner.nextLine();
                    System.out.print("Novo email: ");
                    var email = scanner.nextLine();
                    gerente.alterarDados(nome, email);
                }
                case 6 -> {
                    System.out.print("Nova senha: ");
                    var senha = scanner.nextLine();
                    gerente.alterarSenha(senha);
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opcao invalida!");
            }
        }
    }

    static void menuVendedor(Scanner scanner, Vendedor vendedor) {
        while (true) {
            System.out.printf("\n=== VENDEDOR: %s ===\n", vendedor.getNome());
            System.out.println("1 - Realizar login");
            System.out.println("2 - Realizar logoff");
            System.out.println("3 - Realizar venda");
            System.out.println("4 - Consultar vendas");
            System.out.println("5 - Alterar dados");
            System.out.println("6 - Alterar senha");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            var opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> vendedor.realizarLogin();
                case 2 -> vendedor.realizarLogoff();
                case 3 -> vendedor.realizarVenda();
                case 4 -> vendedor.consultarVendas();
                case 5 -> {
                    System.out.print("Novo nome: ");
                    var nome = scanner.nextLine();
                    System.out.print("Novo email: ");
                    var email = scanner.nextLine();
                    vendedor.alterarDados(nome, email);
                }
                case 6 -> {
                    System.out.print("Nova senha: ");
                    var senha = scanner.nextLine();
                    vendedor.alterarSenha(senha);
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opcao invalida!");
            }
        }
    }

    static void menuAtendente(Scanner scanner, Atendente atendente) {
        while (true) {
            System.out.printf("\n=== ATENDENTE: %s ===\n", atendente.getNome());
            System.out.println("1 - Realizar login");
            System.out.println("2 - Realizar logoff");
            System.out.println("3 - Receber pagamento");
            System.out.println("4 - Fechar caixa");
            System.out.println("5 - Alterar dados");
            System.out.println("6 - Alterar senha");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            var opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> atendente.realizarLogin();
                case 2 -> atendente.realizarLogoff();
                case 3 -> {
                    System.out.print("Valor do pagamento: R$");
                    var valor = scanner.nextDouble();
                    atendente.receberPagamentos(valor);
                }
                case 4 -> atendente.fecharCaixa();
                case 5 -> {
                    System.out.print("Novo nome: ");
                    var nome = scanner.nextLine();
                    System.out.print("Novo email: ");
                    var email = scanner.nextLine();
                    atendente.alterarDados(nome, email);
                }
                case 6 -> {
                    System.out.print("Nova senha: ");
                    var senha = scanner.nextLine();
                    atendente.alterarSenha(senha);
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opcao invalida!");
            }
        }
    }

    static void exercicio3(Scanner scanner) {
        var brasileiro = new RelogioBrasileiro();
        var americano = new RelogioAmericano();

        while (true) {
            System.out.println("\n=== RELOGIOS ===");
            System.out.printf("Brasileiro: %s\n", brasileiro.getHorario());
            System.out.printf("Americano: %s\n", americano.getHorario());
            System.out.println("1 - Ajustar relogio brasileiro");
            System.out.println("2 - Ajustar relogio americano");
            System.out.println("3 - Sincronizar americano pelo brasileiro");
            System.out.println("4 - Sincronizar brasileiro pelo americano");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            var opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Hora (0-23): ");
                    var h = scanner.nextInt();
                    System.out.print("Minuto (0-59): ");
                    var m = scanner.nextInt();
                    System.out.print("Segundo (0-59): ");
                    var s = scanner.nextInt();
                    brasileiro.setHora(h);
                    brasileiro.setMinuto(m);
                    brasileiro.setSegundo(s);
                    System.out.println("Relogio brasileiro ajustado!");
                }
                case 2 -> {
                    System.out.print("Hora (1-12): ");
                    var h = scanner.nextInt();
                    System.out.print("Minuto (0-59): ");
                    var m = scanner.nextInt();
                    System.out.print("Segundo (0-59): ");
                    var s = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Periodo (AM/PM): ");
                    var p = scanner.nextLine();
                    americano.setHora(h);
                    americano.setMinuto(m);
                    americano.setSegundo(s);
                    americano.setPeriodo(p);
                    System.out.println("Relogio americano ajustado!");
                }
                case 3 -> {
                    americano.sincronizar(brasileiro);
                    System.out.println("Americano sincronizado com o brasileiro!");
                }
                case 4 -> {
                    brasileiro.sincronizar(americano);
                    System.out.println("Brasileiro sincronizado com o americano!");
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opcao invalida!");
            }
        }
    }
}
