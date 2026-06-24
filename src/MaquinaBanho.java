public class MaquinaBanho {
    private static final int MAX_AGUA = 30;
    private static final int MAX_SHAMPOO = 10;
    private static final int CUSTO_AGUA_BANHO = 10;
    private static final int CUSTO_SHAMPOO_BANHO = 2;
    private static final int CUSTO_AGUA_LIMPEZA = 3;
    private static final int CUSTO_SHAMPOO_LIMPEZA = 1;
    private static final int ABASTECIMENTO_POR_VEZ = 2;

    private int agua;
    private int shampoo;
    private boolean temPet;
    private boolean petLimpo;
    private boolean maquinaSuja;

    public MaquinaBanho() {
        this.agua = 0;
        this.shampoo = 0;
        this.temPet = false;
        this.petLimpo = false;
        this.maquinaSuja = false;
    }

    public void darBanho() {
        if (!temPet) {
            System.out.println("Nao ha pet na maquina.");
            return;
        }
        if (petLimpo) {
            System.out.println("O pet ja esta limpo.");
            return;
        }
        if (agua < CUSTO_AGUA_BANHO) {
            System.out.printf("Agua insuficiente. Necessario %dL, disponivel %dL.\n", CUSTO_AGUA_BANHO, agua);
            return;
        }
        if (shampoo < CUSTO_SHAMPOO_BANHO) {
            System.out.printf("Shampoo insuficiente. Necessario %dL, disponivel %dL.\n", CUSTO_SHAMPOO_BANHO, shampoo);
            return;
        }
        agua -= CUSTO_AGUA_BANHO;
        shampoo -= CUSTO_SHAMPOO_BANHO;
        petLimpo = true;
        System.out.println("Banho realizado com sucesso! Pet esta limpo.");
    }

    public void abastecerAgua() {
        if (agua >= MAX_AGUA) {
            System.out.printf("Agua ja esta no maximo (%dL).\n", MAX_AGUA);
            return;
        }
        var abastecer = Math.min(ABASTECIMENTO_POR_VEZ, MAX_AGUA - agua);
        agua += abastecer;
        System.out.printf("Agua abastecida com %dL. Nivel atual: %dL/%dL\n", abastecer, agua, MAX_AGUA);
    }

    public void abastecerShampoo() {
        if (shampoo >= MAX_SHAMPOO) {
            System.out.printf("Shampoo ja esta no maximo (%dL).\n", MAX_SHAMPOO);
            return;
        }
        var abastecer = Math.min(ABASTECIMENTO_POR_VEZ, MAX_SHAMPOO - shampoo);
        shampoo += abastecer;
        System.out.printf("Shampoo abastecido com %dL. Nivel atual: %dL/%dL\n", abastecer, shampoo, MAX_SHAMPOO);
    }

    public int verificarNivelAgua() {
        return agua;
    }

    public int verificarNivelShampoo() {
        return shampoo;
    }

    public boolean verificarPet() {
        return temPet;
    }

    public boolean isMaquinaSuja() {
        return maquinaSuja;
    }

    public void colocarPet() {
        if (temPet) {
            System.out.println("Ja tem um pet na maquina.");
            return;
        }
        if (maquinaSuja) {
            System.out.println("A maquina esta suja. Limpe-a antes de colocar outro pet.");
            return;
        }
        temPet = true;
        petLimpo = false;
        System.out.println("Pet colocado na maquina.");
    }

    public void retirarPet() {
        if (!temPet) {
            System.out.println("Nao tem pet na maquina.");
            return;
        }
        if (!petLimpo) {
            maquinaSuja = true;
            System.out.println("Pet retirado sem estar limpo. A maquina precisa ser limpa.");
        } else {
            System.out.println("Pet limpo retirado da maquina.");
        }
        temPet = false;
        petLimpo = false;
    }

    public void limparMaquina() {
        if (temPet) {
            System.out.println("Retire o pet da maquina primeiro.");
            return;
        }
        if (!maquinaSuja) {
            System.out.println("A maquina ja esta limpa.");
            return;
        }
        if (agua < CUSTO_AGUA_LIMPEZA) {
            System.out.printf("Agua insuficiente para limpeza. Necessario %dL, disponivel %dL.\n", CUSTO_AGUA_LIMPEZA, agua);
            return;
        }
        if (shampoo < CUSTO_SHAMPOO_LIMPEZA) {
            System.out.printf("Shampoo insuficiente para limpeza. Necessario %dL, disponivel %dL.\n", CUSTO_SHAMPOO_LIMPEZA, shampoo);
            return;
        }
        agua -= CUSTO_AGUA_LIMPEZA;
        shampoo -= CUSTO_SHAMPOO_LIMPEZA;
        maquinaSuja = false;
        System.out.println("Maquina limpa com sucesso!");
    }
}
