import java.util.Scanner;

public class Zadanie {
    public static void main(String[] args) {
        int number = (int) (Math.random() * 100) + 1; // загадываем число от 1 до 100
        Scanner scanner = new Scanner(System.in);

        System.out.println("Угадайте число от 1 до 100");

        int guess = 0;
        while (guess != number) {
            System.out.print("Введите ваше предположение: ");
            guess = scanner.nextInt();

            if (guess < number) {
                System.out.println("Загаданное число больше");
            } else if (guess > number) {
                System.out.println("Загаданное число меньше");
            } else {
                System.out.println("Вы угадали!");
            }
        }
    }
}
