import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Quantos anos você tem?");

        var age = scanner.nextInt();
        var isEmancipated = false; // valor padrão

        // Só pergunta sobre emancipação se a idade for entre 16 e 18
        if (age <= 18 && age >= 16) {
            System.out.println("Você é emancipado? (true/false)");
            isEmancipated = scanner.nextBoolean();
        }

        var canDiver = age >= 18 || (isEmancipated && age >= 16);

        System.out.printf("Você %s!", canDiver ? "pode dirigir" : "não pode dirigir");
    }
}
