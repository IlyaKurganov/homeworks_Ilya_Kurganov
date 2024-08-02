package homework07;

public class Product {
    private final String productName;
    private final int price;
    private final boolean isChildFriendly;

    public Product(String productName, int price, boolean isChildFriendly) {
        if (productName == null || productName.trim().length() < 3 || productName.matches("\\d+")) {
            throw new IllegalArgumentException("Неверное имя продукта");
        }
        this.productName = productName;
        if (price <= 0) {
            throw new IllegalArgumentException("Цена продукта не может быть нулем или отрицательной");
        }
        this.price = price;
        this.isChildFriendly = isChildFriendly;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public boolean isChildFriendly() {
        return isChildFriendly;
    }
}
