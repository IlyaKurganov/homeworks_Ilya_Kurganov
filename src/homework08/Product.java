package homework08;

import java.util.Objects;

public class Product {
    private String title;
    private int cost;

    public Product(String title, int cost) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Название пустое");
        } else {
            this.title = title;
        }

        if (cost < 1) {
            throw new IllegalArgumentException("Цена не может быть 0 или меньше");
        } else {
            this.cost = cost;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Название пустое");
        } else {
            this.title = title;
        }
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        if (cost < 1) {
            throw new IllegalArgumentException("Цена не может быть 0 или меньше");
        } else {
            this.cost = cost;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return cost == product.cost && Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, cost);
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", cost=" + cost +
                '}';
    }
}
