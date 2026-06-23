import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        var male = new Person();
        male.setName("jhon");
        male.setAge(12);

        var female = new Person();
        female.setName("mary");
        female.setAge(14);

        System.out.println("Male:\n name: " + male.getName() + "; age: " + male.getAge());
        System.out.println("Female:\n name: " + female.getName() + "; age: " + female.getAge());
    }
}
