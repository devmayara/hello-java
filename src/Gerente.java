public class Gerente extends Usuario {
    public Gerente(String nome, String email, String senha) {
        super(nome, email, senha, true);
    }

    public void gerarRelatorioFinanceiro() {
        System.out.printf("Relatorio financeiro gerado pelo gerente %s.\n", nome);
    }

    public void consultarVendas() {
        System.out.println("Consultando vendas...");
    }
}
