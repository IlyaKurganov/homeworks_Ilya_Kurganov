package homework06;

import java.util.ArrayList;
import java.util.Objects;

public class Person {
    private String name;
    private int cash;
    private ArrayList<Product> bagWithProducts = new ArrayList<>();


    public Person(String name, int cash) throws IllegalArgumentException {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        } else {
            this.name = name;
        }
        if (cash >= 0) {
            this.cash = cash;
        } else {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
    }

    public Person(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        } else {
            this.name = name;
        }
    }

    public void buyProduct(Product product) {
        if (this.getCash() - product.getCost() >= 0) {
            this.cash -= product.getCost();
            bagWithProducts.add(product);
            System.out.println(this.name + " купил(-а) " + product.getTitle());
        } else {
            System.out.println(this.name + " не может позволить себе этот продукт");
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        } else {
            this.name = name;
        }
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        if (cash >= 0) {
            this.cash = cash;
        } else {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return cash == person.cash && Objects.equals(name, person.name) && Objects.equals(bagWithProducts, person.bagWithProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cash, bagWithProducts);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", cash=" + cash +
                ", bagWithProducts=" + bagWithProducts +
                '}';
    }

    public void showBagWithProducts() {
        if (bagWithProducts.isEmpty()) {
            System.out.println("Ничего не куплено");
        } else {
            System.out.print(this.name + " купил(-а): ");
            for (Product bagWithProduct : bagWithProducts) {
                System.out.print(bagWithProduct.getTitle() + " ");
            }
        }
    }
}
