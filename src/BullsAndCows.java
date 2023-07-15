import java.io.*;
import java.util.*;

public class BullsAndCows {
    private static final int NUMBER_LENGTH = 4; // длина загадываемого числа
    private static int gameNumber = 1; // номер текущей игры

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String answer = generateAnswer(random); // генерируем загаданное число
        System.out.println("Игра началась! Угадайте число из " + NUMBER_LENGTH + " разных цифр.");

        while (true) {
            System.out.println("Введите число: ");
            String guess = scanner.nextLine();
            if (guess.equals("выход")) {
                break;
            }
            if (!isValidGuess(guess)) {
                System.out.println("Некорректный ввод. Введите число из " + NUMBER_LENGTH + " разных цифр.");
                continue;
            }
            String result = getResult(answer, guess);
            System.out.println(result);
            if (result.equals(NUMBER_LENGTH + " быка")) {
                System.out.println("Вы выиграли!");
                writeResultToFile(answer, gameNumber); // записываем результат в файл
                gameNumber++; // увеличиваем номер игры
                break;
            }
        }
        scanner.close();
    }

    // генерация загаданного числа
    private static String generateAnswer(Random random) {
        List<Integer> digits = new ArrayList<>();
        while (digits.size() < NUMBER_LENGTH) {
            int digit = random.nextInt(10);
            if (!digits.contains(digit)) {
                digits.add(digit);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            sb.append(digit);
        }
        return sb.toString();
    }

    // проверка корректности введенного числа
    private static boolean isValidGuess(String guess) {
        if (guess.length() != NUMBER_LENGTH) {
            return false;
        }
        Set<Character> digits = new HashSet<>();
        for (char c : guess.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
            digits.add(c);
        }
        return digits.size() == NUMBER_LENGTH;
    }

    // получение результата угадывания
    private static String getResult(String answer, String guess) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (guess.charAt(i) == answer.charAt(i)) {
                bulls++;
            } else if (answer.indexOf(guess.charAt(i)) != -1) {
                cows++;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (bulls > 0) {
            sb.append(bulls).append(" бык");
            if (bulls > 1 ) {
                sb.append("а");
            }
        }
        if (cows > 0) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(cows).append(" коров");
            if (cows > 1)
                sb.append("ы");
                else if (cows == 1)
                    sb.append("а");

        }
        if (sb.length() == 0) {
            sb.append("Нет совпадений");
        }
        return sb.toString();
    }

    // запись результата игры в файл
    private static void writeResultToFile(String answer, int gameNumber) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("results.txt", true)))) {
            writer.println("Game №" + gameNumber + " " + new Date());
            writer.println("Загаданная строка: " + answer);
            Scanner scanner = new Scanner(System.in);
            int guessCount = 0;
            while (true) {
                System.out.println("Введите число: ");
                String guess = scanner.nextLine();
                if (!isValidGuess(guess)) {
                    System.out.println("Некорректный ввод. Введите число из " + NUMBER_LENGTH + " разных цифр.");
                    continue;
                }
                String result = getResult(answer, guess);
                writer.println("Запрос: " + guess + " Ответ: " + result);
                guessCount++;
                if (result.equals(NUMBER_LENGTH + " быка")) {
                    break;
                }
            }
            writer.println("Строка была угадана за " + guessCount + " попыток.");
            scanner.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}

