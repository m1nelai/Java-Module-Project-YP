import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    private ArrayList<String> products = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();
    private double totalSum = 0.0;

    public void addProductToCalculator(String productName, double price) {
        products.add(productName);
        prices.add(price);
        totalSum += price;
    }

    public String formatPrice(double price) {
        long rubles = (long) Math.floor(price);
        int kopecks = (int) Math.round((price - rubles) * 100);

        //окончание
        if (rubles == 1 && (kopecks == 0 || kopecks > 20)) {
            return String.format("%.2f рубль", price).replace(",", ".");
        } else {
            return String.format("%.2f рубля", price).replace(",", ".");
        }
    }

    public void showAllAddedProducts() {
        System.out.println("Список добавленных товаров:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i) + " - " + prices.get(i));
        }
        System.out.println("Общая сумма: " + formatPrice(totalSum));
    }

    public void addProducts(Scanner scanner) {
        while (true) {
            System.out.println("Добавленные товары:");
            String productName = scanner.nextLine();

            if (productName.equalsIgnoreCase("завершить")) {
                break;
            }

            System.out.println("Введите стоимость товара в формате рубли.копейки:");
            String priceInput = scanner.nextLine();
            double price = Double.parseDouble(priceInput);

            addProductToCalculator(productName, price);
            System.out.println("Товар успешно добавлен в калькулятор.");

            System.out.println("Хотите добавить ещё один товар? Введите 'завершить' чтобы закончить");
            String decision = scanner.nextLine();
            if (decision.equalsIgnoreCase("завершить")) {
                break;
            }
        }
    }

    public double getTotalSum() {
        return totalSum;
    }
}
