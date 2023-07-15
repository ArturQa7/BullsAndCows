import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int a = console.nextInt();
        int b = console.nextInt();
        int c = console.nextInt();

        if (a==b)
            if (a==c)
                System.out.println(a + " " + b + " " + c);
            else
                System.out.println(a + " " + b);
        else if (a==c)
            System.out.println(a + " " + c);
        else if (b==c)
            System.out.println(b + " " + c);

    }
}