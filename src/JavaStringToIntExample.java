public class JavaStringToIntExample {
    public static void main(String[] args) {
        // String s = "fred";  // используйте это, если вам нужно протестировать //исключение ниже
        String s = "1";

        try {
            // именно здесь String преобразуется в int
            int i = Integer.parseInt(s.trim());

            // выведем на экран значение после конвертации
            System.out.println("int i = " + i);
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
    }
}