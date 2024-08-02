package homework07;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;

public class ProductsCreator {
    private final HashSet<Product> products = new HashSet<>();

    public void createBaseListOfProducts() {
        products.add(new Product("Молоко", 60, true));
        products.add(new DiscountProduct("Хлеб со скидкой", 40, true, 5, LocalDate.now().plusDays(10)));
        products.add(new Product("Торт", 300, false));
        products.add(new DiscountProduct("Кофе со скидкой", 250, false, 50, LocalDate.now().plusDays(5)));
        System.out.println("Создан базовый список продуктов.");
        System.out.println();
    }

    public void createCustomListOfProducts() {
        Scanner sc = new Scanner(System.in);
        boolean continueAdding = true;
        while (continueAdding) {
            System.out.println("Введите название продукта:");
            String productName = sc.nextLine();
            System.out.println("Введите стоимость продукта:");
            int price = Integer.parseInt(sc.nextLine());
            System.out.println("Продукт подходит для детей? 1 - Да, 2 - Нет");
            boolean isChildFriendly = sc.nextInt() == 1;
            sc.nextLine();

            System.out.println("Это скидочный продукт? 1 - Да, 2 - Нет");
            boolean isDiscountProduct = sc.nextInt() == 1;
            sc.nextLine();

            if (isDiscountProduct) {
                System.out.println("Введите размер скидки:");
                int discount = Integer.parseInt(sc.nextLine());
                System.out.println("Введите срок действия скидки (дней):");
                int days = Integer.parseInt(sc.nextLine());
                products.add(new DiscountProduct(productName, price, isChildFriendly, discount, LocalDate.now().plusDays(days)));
            } else {
                products.add(new Product(productName, price, isChildFriendly));
            }
            System.out.println("Продукт добавлен.");
            System.out.println("Добавить еще продукт? 1 - Да, 2 - Нет");
            continueAdding = sc.nextInt() == 1;
            sc.nextLine();
        }
    }

    public void printListOfProducts() {
        if (products.isEmpty()) {
            System.out.println("Список продуктов пуст.");
        } else {
            System.out.println("Базовый список продуктов:");
            for (Product product : products) {
                System.out.println(product.getProductName() + " - Цена: " + product.getPrice() +
                        (product.isChildFriendly() ? " (Подходит для детей)" : " (Не для детей)"));
            }
        }
    }

    public HashSet<Product> getListOfProducts() {
        return products;
    }
}

