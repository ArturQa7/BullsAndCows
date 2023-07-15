

public class sol3 {
    public static void main(String[] args) {
        String text = "Привет";
        String text2 = "Привет";
        String s1 = text.toUpperCase();
        String s2 = text.toUpperCase();

        System.out.println(text == text2); // Ссылаются на одну и ту же ссылку, адреса равны
        System.out.println(text == s1); //адреса разные
        System.out.println(s1 == s2); //s1 и s2 хранят ссылки на очень похожие объекты, но все-таки не на один и тот же объект
        System.out.println(s1.equals(s2));  // одинаковые, хотя адреса разные
    }
}
// Ссылаются на одну и ту же ссылку