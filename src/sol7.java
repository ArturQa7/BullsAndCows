import java.util.Scanner;

/*
Сумма кратных чисел
*/

public class sol7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int multiple = scanner.nextInt();

        int sum = 0;
        for (int i = start; i < end; i++) {
            if (i % multiple != 0) {        //Внутри оператора if проверяется, является ли текущее число кратным заданному числу multiple.
                                            // Если нет, то происходит переход к следующей ИТЕРАЦИИ цикла с помощью оператора continue.
                                            // Проще говоря работает как фильтр, т. е. дальше проходят значения 3,6,9 и складываются
                System.out.print("Б");
                System.out.println(i);

                continue;
            }
            System.out.println(sum);
            sum = sum + i;

        }
        System.out.println(sum);
    }
}
