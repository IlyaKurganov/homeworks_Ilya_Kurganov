package homework07;

import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;

public class Buyer {
    private final String name;
    private int cash;
    private final int age;
    private final Map<String, Integer> products = new Hashtable<>();

    public Buyer(String name, int cash, int age) {
        if (name == null || name.trim().isEmpty() || name.length() < 3) {
            throw new IllegalArgumentException("Имя не может быть пустым или короче 3 символов");
        }
        this.name = name;
        if (cash < 0) {
            throw new IllegalArgumentException("Количество денег не может быть меньше нуля");
        }
        this.cash = cash;
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        if (cash < 0) {
            throw new IllegalArgumentException("Количество денег не может быть меньше нуля");
        }
        this.cash = cash;
    }

    public int getAge() {
        return age;
    }

    public Map<String, Integer> getProducts() {
        return products;
    }

    public void buyProduct(Product product) {
        if (product.getPrice() > cash) {
            throw new IllegalArgumentException("Недостаточно средств для покупки товара " + product.getProductName());
        } else if (!products.containsKey(product.getProductName())) {
            products.put(product.getProductName(), 1);
            cash -= product.getPrice();
            System.out.println(name + " купил " + product.getProductName());
        } else {
            Integer quantity = products.get(product.getProductName()) + 1;
            products.put(product.getProductName(), quantity);
            cash -= product.getPrice();
            System.out.println(name + " купил " + product.getProductName());
        }
    }

    public void printListOfProducts() {
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Buyer buyer)) return false;
        return cash == buyer.cash && age == buyer.age && Objects.equals(name, buyer.name) && Objects.equals(products, buyer.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cash, age, products);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "name='" + getName() + '\'' +
                ", cash=" + getCash() +
                ", age=" + getAge() +
                '}';
    }
}




