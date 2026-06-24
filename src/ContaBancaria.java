public class ContaBancaria {
    private double saldo;
    private final double chequeEspecial;
    private boolean usandoChequeEspecial;

    public ContaBancaria(double depositoInicial) {
        this.saldo = depositoInicial;
        if (depositoInicial <= 500) {
            this.chequeEspecial = 50;
        } else {
            this.chequeEspecial = depositoInicial * 0.5;
        }
        this.usandoChequeEspecial = false;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public double consultarChequeEspecial() {
        return chequeEspecial;
    }

    public boolean verificarUsoChequeEspecial() {
        return usandoChequeEspecial;
    }

    public void depositar(double valor) {
        if (usandoChequeEspecial) {
            var taxa = valor * 0.2;
            saldo += valor - taxa;
            System.out.printf("Taxa de 20%% sobre o valor do cheque especial: R$%.2f\n", taxa);
            if (saldo >= 0) {
                usandoChequeEspecial = false;
                System.out.println("Cheque especial quitado!");
            }
        } else {
            saldo += valor;
        }
        System.out.printf("Deposito realizado. Saldo atual: R$%.2f\n", saldo);
    }

    public boolean sacar(double valor) {
        var saldoDisponivel = saldo + chequeEspecial;
        if (valor > saldoDisponivel) {
            System.out.println("Saldo insuficiente!");
            return false;
        }
        saldo -= valor;
        if (saldo < 0) {
            usandoChequeEspecial = true;
        }
        System.out.printf("Saque realizado. Saldo atual: R$%.2f\n", saldo);
        return true;
    }

    public boolean pagarBoleto(double valor) {
        return sacar(valor);
    }
}
