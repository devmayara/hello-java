public class Vendedor extends Usuario {
    private int quantidadeVendas;

    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha, false);
        this.quantidadeVendas = 0;
    }

    public int getQuantidadeVendas() {
        return quantidadeVendas;
    }

    public void realizarVenda() {
        quantidadeVendas++;
        System.out.printf("Venda realizada com sucesso. Total de vendas: %d\n", quantidadeVendas);
    }

    public void consultarVendas() {
        System.out.printf("Total de vendas: %d\n", quantidadeVendas);
    }
}
