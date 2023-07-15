import java.util.Scanner;

/*
Показываем, что получаем
*/

public class sol6 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        while (console.hasNextInt()) {
            int x = console.nextInt();
            if (x<min) {
                min2 = min;
                min = x;
            }else if (x>min && x<min2) {
                min2 = x;
            }
        }
        System.out.println(min2);
    }
}
