package homework07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuyersCreator {
    private final List<Buyer> buyers = new ArrayList<>();

    public void createBaseBuyers() {
        buyers.add(new AdultBuyer("Павел Андреевич", 10000, 34, true));
        buyers.add(new ChildBuyer("Игорь", 500, 15));
        buyers.add(new PensionerBuyer("Анна Петровна", 3000, 70));
        System.out.println("Создан базовый список покупателей.");
        System.out.println();
    }

    public void createCustomBuyers() {
        Scanner sc = new Scanner(System.in);
        boolean continueAdding = true;
        while (continueAdding) {
            System.out.println("Выберите тип покупателя: 1 - Ребенок, 2 - Взрослый, 3 - Пенсионер");
            int type = sc.nextInt();
            sc.nextLine();
            System.out.println("Введите имя:");
            String name = sc.nextLine();
            System.out.println("Введите количество денег:");
            int cash = Integer.parseInt(sc.nextLine());
            System.out.println("Введите возраст:");
            int age = Integer.parseInt(sc.nextLine());

            try {
                switch (type) {
                    case 1:
                        buyers.add(new ChildBuyer(name, cash, age));
                        break;
                    case 2:
                        System.out.println("Может ли покупать в кредит? 1 - Да, 2 - Нет");
                        boolean credit = sc.nextInt() == 1;
                        sc.nextLine();
                        buyers.add(new AdultBuyer(name, cash, age, credit));
                        break;
                    case 3:
                        buyers.add(new PensionerBuyer(name, cash, age));
                        break;
                    default:
                        System.out.println("Неверный тип покупателя. Попробуйте еще раз.");
                        continue;
                }
                System.out.println("Покупатель добавлен.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Добавить еще покупателя? 1 - Да, 2 - Нет");
            continueAdding = sc.nextInt() == 1;
            sc.nextLine();
        }
    }

    public void printListOfBuyers() {
        if (buyers.isEmpty()) {
            System.out.println("Список покупателей пуст.");
        } else {
            System.out.println("Базовый список покупателей:");
            for (Buyer buyer : buyers) {
                System.out.println(buyer.toString());
            }
        }
    }

    public List<Buyer> getListOfBuyers() {
        return buyers;
    }
}


