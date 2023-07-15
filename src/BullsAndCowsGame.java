
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BullsAndCowsGame {
    private static final int CODE_LENGTH = 4; // Длина загадываемой строки
    private static final String FILE_NAME = "game_log.txt"; // Имя файла для записи лога игр

    private String secretCode; // Загаданная строка
    private int attempts; // Количество попыток угадывания
    private List<String> gameLog; // Лог игры

    public BullsAndCowsGame() {
        this.secretCode = generateSecretCode();
        this.attempts = 0;
        this.gameLog = new ArrayList<>();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите строку из четырех цифр: ");
            String guess = scanner.nextLine();

            if (guess.length() != CODE_LENGTH || !guess.matches("\\d+")) {
                System.out.println("Некорректный ввод! Попробуйте еще раз.");
                continue;
            }

            attempts++;
            String result = checkGuess(guess);
            gameLog.add("Запрос: " + guess + " Ответ: " + result);

            System.out.println(result);

            if (result.equals(CODE_LENGTH + " быков" + " 0 коровы")) {
                System.out.println("Поздравляю! Вы угадали число за " + attempts + " попыток.");
                break;
            }
        }

        saveGameLog();
    }

    private String generateSecretCode() {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            digits.add(i);
        }

        Collections.shuffle(digits);

        StringBuilder code = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; i++) {
            code.append(digits.get(i));
        }

        return code.toString();
    }

    private String checkGuess(String guess) {
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < CODE_LENGTH; i++) {
            char digit = guess.charAt(i);

            if (digit == secretCode.charAt(i)) {
                bulls++;
            } else if (secretCode.contains(String.valueOf(digit))) {
                cows++;
            }
        }

        return bulls + " бык" + (bulls != 1 ? "ов" : "") + " " +
                cows + " коров" + (cows != 1 ? "ы" : "");
    }

    private void saveGameLog() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            int gameNumber = getLastGameNumber() + 1;
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy H:mm"));

            writer.write("Game №" + gameNumber + " " + timestamp);
            writer.newLine();
            writer.write("Загаданная строка: " + secretCode);
            writer.newLine();

            for (String logEntry : gameLog) {
                writer.write(logEntry);
                writer.newLine();
            }

            writer.write("Строка была угадана за " + attempts + " попыток.");
            writer.newLine();
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка при записи лога игры: " + e.getMessage());
        }
    }

    private int getLastGameNumber() {
        int lastGameNumber = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Game №")) {
                    lastGameNumber = Integer.parseInt(line.substring(6).split(" ")[0]);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла лога игр: " + e.getMessage());
        }

        return lastGameNumber;
    }

    public static void main(String[] args) {
        BullsAndCowsGame game = new BullsAndCowsGame();
        game.play();
    }
}

