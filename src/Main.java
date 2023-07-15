public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Java for Beginners", "John Smith", 2019, 200);
        Book book2 = new Book("The Catcher in the Rye", "J.D. Salinger");

        System.out.println("Book 1: " + book1.getTitle() + " by " + book1.getAuthor() + ", published in " + book1.getYear() + ", " + book1.getPages() + " pages.");
        System.out.println("Book 2: " + book2.getTitle() + " by " + book2.getAuthor() + ", published in " + book2.getYear() + ", " + book2.getPages() + " pages.");
    }
}


