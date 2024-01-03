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

        // Определяем окончание для рублей
        String rublesEnding;
        if (rubles % 10 == 1 && rubles % 100 != 11) {
            rublesEnding = "рубль";
        } else if (rubles % 10 >= 2 && rubles % 10 <= 4 && (rubles % 100 < 10 || rubles % 100 >= 20)) {
            rublesEnding = "рубля";
        } else {
            rublesEnding = "рублей";
        }

        // Форматируем и возвращаем строку с суммой и окончанием
        return String.format("%.2f %s", price, rublesEnding).replace(".", ",");
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

            boolean validPrice = false;
            double price = 0.0;
            while (!validPrice) {
                System.out.println("Введите стоимость товара в формате рубли.копейки:");
                String priceInput = scanner.nextLine();
                try {
                    price = Double.parseDouble(priceInput);
                    if (price <= 0) {
                        System.out.println("Ошибка: стоимость товара должна быть положительной.");
                    } else {
                        validPrice = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: некорректный формат цены.");
                }
            }

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
