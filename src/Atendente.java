public class Atendente extends Usuario {
    private double valorEmCaixa;

    public Atendente(String nome, String email, String senha) {
        super(nome, email, senha, false);
        this.valorEmCaixa = 0;
    }

    public double getValorEmCaixa() {
        return valorEmCaixa;
    }

    public void receberPagamentos(double valor) {
        valorEmCaixa += valor;
        System.out.printf("Pagamento de R$%.2f recebido. Saldo em caixa: R$%.2f\n", valor, valorEmCaixa);
    }

    public void fecharCaixa() {
        System.out.printf("Caixa fechado. Valor total: R$%.2f\n", valorEmCaixa);
        valorEmCaixa = 0;
    }
}
