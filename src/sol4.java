import java.util.Scanner;

public class sol4 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String a = console.nextLine();
        String b = console.nextLine();

        if (a.equals(b))
            System.out.println("строки одинаковые");
        else
            System.out.println("строки разные");
    }
}