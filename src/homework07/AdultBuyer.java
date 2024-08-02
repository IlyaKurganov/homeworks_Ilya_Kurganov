package homework07;

public class AdultBuyer extends Buyer {
    private boolean creditAvailable;

    public AdultBuyer(String name, int cash, int age, boolean creditAvailable) {
        super(name, cash, age);
        this.creditAvailable = creditAvailable;
        if (age < 18 || age > 65) {
            throw new IllegalArgumentException("Покупатель-взрослый должен быть в возрасте от 18 до 65 лет");
        }
    }

    @Override
    public void buyProduct(Product product) {
        int price = product.getPrice();
        if (getCash() >= price || (creditAvailable && getCash() + 5000 >= price)) {
            super.buyProduct(product);
        } else {
            System.out.println(getName() + " не может купить " + product.getProductName() + ", недостаточно средств даже с кредитом.");
        }
    }
}