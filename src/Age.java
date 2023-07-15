import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        System.out.println("Введите свой возраст");
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        if (age < 12) {
            System.out.println("Вы ребенок");
        } else if (age > 12 && age <= 18) {
            System.out.println("Вы подросток");
        } else {
            System.out.println("Вы дед");
        }
    }
}

