package homework07;

public class ChildBuyer extends Buyer {
    public ChildBuyer(String name, int cash, int age) {
        super(name, cash, age);
        if (age > 17 || age < 6) {
            throw new IllegalArgumentException("Покупатель-ребенок должен быть в возрасте от 6 до 17 лет");
        }
    }

    @Override
    public void buyProduct(Product product) {
        if (!product.isChildFriendly()) {
            System.out.println(getName() + " не может купить этот продукт, так как он не подходит для детей.");
        } else {
            super.buyProduct(product);
        }
    }
}