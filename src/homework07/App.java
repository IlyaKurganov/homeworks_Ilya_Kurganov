package homework07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final Scanner sc = new Scanner(System.in);
    private static final BuyersCreator bc = new BuyersCreator();
    private static final ProductsCreator pc = new ProductsCreator();

    public static void main(String[] args) {
        initBuyersAndProducts();
        mainMenu();
    }

    private static void initBuyersAndProducts() {
        System.out.println("Cоздаем базовые списки");
        System.out.println();
        bc.createBaseBuyers();
        pc.createBaseListOfProducts();

        bc.printListOfBuyers();
        System.out.println();

        pc.printListOfProducts();
        System.out.println();

        System.out.println("Создать еще покупателя? 1 - Да, 2 - Нет");
        int addMoreBuyers = sc.nextInt();
        sc.nextLine();
        if (addMoreBuyers == 1) {
            bc.createCustomBuyers();
        }

        System.out.println("Создать еще продукт? 1 - Да, 2 - Нет");
        int addMoreProducts = sc.nextInt();
        sc.nextLine();
        if (addMoreProducts == 1) {
            pc.createCustomListOfProducts();
        }
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("\nВыберите действие: \n1 - Выбрать покупателя \n2 - Показать всех покупателей \n3 - Выйти");
            int action = sc.nextInt();
            sc.nextLine();
            if (action == 1) {
                selectBuyer();
            } else if (action == 2) {
                printAllBuyers();
            } else if (action == 3) {
                System.out.println("Программа завершена.");
                break;
            } else {
                System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

    private static void selectBuyer() {
        List<Buyer> buyers = new ArrayList<>(bc.getListOfBuyers());
        if (buyers.isEmpty()) {
            System.out.println("Список покупателей пуст. Добавьте покупателей перед выбором.");
            return;
        }
        System.out.println("Выберите покупателя для покупок:");
        for (int i = 0; i < buyers.size(); i++) {
            Buyer buyer = buyers.get(i);
            System.out.println((i + 1) + ". " + buyer.getName() + " - " + buyer.getClass().getSimpleName());
        }
        System.out.print("Введите номер покупателя: ");
        int buyerIndex = sc.nextInt() - 1;
        sc.nextLine();
        if (buyerIndex >= 0 && buyerIndex < buyers.size()) {
            shoppingSession(buyers.get(buyerIndex));
        } else {
            System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
        }
    }

    private static void shoppingSession(Buyer buyer) {
        System.out.println("Покупки для " + buyer.getName() + ". Введите 'end' для завершения:");
        while (true) {
            System.out.println("Доступные продукты:");
            int count = 1;
            for (Product product : pc.getListOfProducts()) {
                System.out.println(count++ + ". " + product.getProductName() + " - Цена: " + product.getPrice());
            }
            System.out.print("Выберите номер продукта для покупки или введите 'end': ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("end")) {
                break;
            }
            try {
                int productIndex = Integer.parseInt(input) - 1;
                if (productIndex >= 0 && productIndex < pc.getListOfProducts().size()) {
                    buyer.buyProduct(new ArrayList<>(pc.getListOfProducts()).get(productIndex));
                } else {
                    System.out.println("Неверный ввод, попробуйте снова.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод, попробуйте снова.");
            }
        }
    }


    private static void printAllBuyers() {
        List<Buyer> buyers = bc.getListOfBuyers();
        if (buyers.isEmpty()) {
            System.out.println("Список покупателей пуст.");
            return;
        }

        System.out.println("Все покупатели:");
        for (Buyer buyer : buyers) {
            System.out.println(buyer.toString());

            if (!buyer.getProducts().isEmpty()) {
                System.out.println("Купленные продукты:");
                buyer.printListOfProducts();

            }else {
                System.out.println("Нет купленных продуктов.");
            }
            System.out.println();
        }
    }
}





