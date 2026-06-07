import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Olá, informe o seu nome: ");
        String name = scanner.next();

        System.out.println("Olá, informe a sua idade: ");
        int age = scanner.nextInt();

//        System.out.println("Olá, " + name + "sua idade é " + age);
        System.out.printf("Olá, %s sua idade é %s", name, age);
    }
}
