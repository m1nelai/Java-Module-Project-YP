import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int guests;
        while (true) {
            System.out.println("Введите количество людей для разделения счета (больше 1):");
            String input = scanner.nextLine();
            try {
                guests = Integer.parseInt(input);  // Пытаемся преобразовать строку в целое число
                if (guests <= 1) {
                    System.out.println("Ошибка: количество гостей должно быть больше 1");
                    continue;  // Продолжаем цикл, если введено некорректное значение
                } else {
                    break;  // Выходим из цикла, если введено корректное значение
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: некорректное значение для подсчета.");
            }
        }

        Calculator shoppingCalculator = new Calculator();
        shoppingCalculator.addProducts(scanner);  // Вызываем метод класса Calculator для добавления товаров

        shoppingCalculator.showAllAddedProducts();  // Показываем список добавленных товаров

        double amountPerGuest = shoppingCalculator.getTotalSum() / guests;  // Вычисляем сумму на каждого гостя
        System.out.println("Каждый гость должен заплатить: " + shoppingCalculator.formatPrice(amountPerGuest));

        scanner.close();
    }
}

