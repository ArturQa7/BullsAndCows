public class ApartmentSale {
    public static int calculateRevenue(int N, int M, int X) {
        int totalRevenue = 0;
        int currentPrice = X;
        for (int i = 1; i <= N; i++) {
            totalRevenue += currentPrice;
            if (i % M == 0) {
                currentPrice += 1000;
            }
        }
        return totalRevenue;
    }

    public static void main(String[] args) {
        int N = 30; // количество этажей
        int M = 10; // через сколько этажей цена увеличивается
        int X = 10000; // цена квартиры на первом этаже

        int revenue = calculateRevenue(N, M, X);
        System.out.println("Выручка от продажи всех квартир: $" + revenue);
    }
}
