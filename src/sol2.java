import java.util.Scanner;

public class sol2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        if (Math.abs(b-a) < 0.000001)
            System.out.println("числа равны");
        else
            System.out.println("числа не равны");
    }
}