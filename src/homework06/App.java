package homework06;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        Person person = new Person("Иван Васильевич", 10000);
        Product[] products = {ListOfProducts.milk, ListOfProducts.bread, ListOfProducts.cake, ListOfProducts.butter, ListOfProducts.coffee};

        boolean ended = false;

        System.out.println("Купить еще продукт? (рандом/молоко/хлеб/торт/масло/кофе/END)");

        while (!ended) {
            String input = sc.nextLine().toLowerCase();

            switch (input) {
                case "рандом":
                    int randomProduct = random.nextInt(products.length);
                    person.buyProduct(products[randomProduct]);
                    System.out.println("Купить еще продукт? (рандом/молоко/хлеб/торт/масло/кофе/END)");
                    break;
                case "молоко":
                    person.buyProduct(ListOfProducts.milk);
                    System.out.println("Купить еще продукт? (рандом/молоко/хлеб/торт/масло/кофе/END)");
                    break;
                case "хлеб":
                    person.buyProduct(ListOfProducts.bread);
                    System.out.println("Купить еще продукт? (рандом/молоко/хлеб/торт/масло/кофе/END)");
                    break;
                case "торт":
                    person.buyProduct(ListOfProducts.cake);
                    System.out.println("Купить еще продукт? (рандом/молоко/хлеб/торт/масло/кофе/END)");
                    break;
                case "масло":
                    person.buyProduct(ListOfProducts.butter);
                    System.out.println("Купить еще продукт? (рандом/молоко/хлеб/торт/масло/кофе/END)");
                    break;
                case "кофе":
                    person.buyProduct(ListOfProducts.coffee);
                    System.out.println("Купить еще продукт? (рандом/молоко/хлеб/торт/масло/кофе/END)");
                    break;
                case "end":
                    ended = true;
                    break;
                default:
                    System.out.println("Неправильный ввод. Пожалуйста, введите 'рандом', название продукта или 'END'.");
                    break;
            }
        }

        person.showBagWithProducts();
    }
}
