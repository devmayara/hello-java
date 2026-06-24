public class Carro {
    private boolean ligado;
    private int velocidade;
    private int marcha;

    public Carro() {
        this.ligado = false;
        this.velocidade = 0;
        this.marcha = 0;
    }

    public boolean ligar() {
        if (ligado) {
            System.out.println("O carro ja esta ligado.");
            return false;
        }
        ligado = true;
        System.out.println("Carro ligado.");
        return true;
    }

    public boolean desligar() {
        if (!ligado) {
            System.out.println("O carro ja esta desligado.");
            return false;
        }
        if (marcha != 0) {
            System.out.println("Coloque o carro em ponto morto (marcha 0) para desligar.");
            return false;
        }
        if (velocidade != 0) {
            System.out.println("O carro precisa estar parado (velocidade 0) para desligar.");
            return false;
        }
        ligado = false;
        System.out.println("Carro desligado.");
        return true;
    }

    public boolean acelerar() {
        if (!ligado) {
            System.out.println("O carro esta desligado. Ligue-o primeiro.");
            return false;
        }
        if (marcha == 0) {
            System.out.println("O carro esta em ponto morto. Nao pode acelerar.");
            return false;
        }
        if (velocidade >= 120) {
            System.out.println("Velocidade maxima atingida (120km).");
            return false;
        }
        velocidade++;
        System.out.printf("Acelerando... Velocidade atual: %dkm\n", velocidade);
        return true;
    }

    public boolean diminuirVelocidade() {
        if (!ligado) {
            System.out.println("O carro esta desligado. Ligue-o primeiro.");
            return false;
        }
        if (velocidade <= 0) {
            System.out.println("O carro ja esta parado.");
            return false;
        }
        velocidade--;
        System.out.printf("Reduzindo velocidade... Velocidade atual: %dkm\n", velocidade);
        return true;
    }

    public boolean virar(String direcao) {
        if (!ligado) {
            System.out.println("O carro esta desligado. Ligue-o primeiro.");
            return false;
        }
        if (velocidade < 1 || velocidade > 40) {
            System.out.println("So pode virar com velocidade entre 1km e 40km.");
            return false;
        }
        System.out.printf("Virando para %s.\n", direcao);
        return true;
    }

    public int verificarVelocidade() {
        return velocidade;
    }

    public boolean trocarMarcha(int novaMarcha) {
        if (!ligado) {
            System.out.println("O carro esta desligado. Ligue-o primeiro.");
            return false;
        }
        if (novaMarcha < 0 || novaMarcha > 6) {
            System.out.println("Marcha invalida. As marchas vao de 0 a 6.");
            return false;
        }
        if (Math.abs(novaMarcha - marcha) > 1) {
            System.out.println("Nao e permitido pular marcha!");
            return false;
        }

        marcha = novaMarcha;
        System.out.printf("Marcha trocada para %d.\n", marcha);

        if (!velocidadeCompativel()) {
            System.out.println("Atencao: a velocidade atual nao e compativel com esta marcha!");
        }
        return true;
    }

    private boolean velocidadeCompativel() {
        return switch (marcha) {
            case 0 -> velocidade == 0;
            case 1 -> velocidade >= 0 && velocidade <= 20;
            case 2 -> velocidade >= 21 && velocidade <= 40;
            case 3 -> velocidade >= 41 && velocidade <= 60;
            case 4 -> velocidade >= 61 && velocidade <= 80;
            case 5 -> velocidade >= 81 && velocidade <= 100;
            case 6 -> velocidade >= 101 && velocidade <= 120;
            default -> false;
        };
    }

    public boolean isLigado() {
        return ligado;
    }

    public int getMarcha() {
        return marcha;
    }
}
