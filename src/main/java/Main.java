import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int guests;
        while (true) {
            System.out.println("Введите количество людей для разделения счета (больше 1):");
            guests = scanner.nextInt();  // Получаем ввод от пользователя
            scanner.nextLine();
            if (guests == 1) {
                System.out.println("Ошибка: количество гостей должно быть больше 1.");
            } else if (guests < 1) {
                System.out.println("Ошибка: некорректное значение для подсчета.");
            } else {
                break;  // Выходим из цикла, если введено корректное значение
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
