package homework07;

public class PensionerBuyer extends Buyer {
    public PensionerBuyer(String name, int cash, int age) {
        super(name, cash, age);
        if (age < 65) {
            throw new IllegalArgumentException("Покупатель-пенсионер должен быть старше 65 лет");
        }
    }

    @Override
    public void buyProduct(Product product) {
        int priceWithDiscount = (int) (product.getPrice() * 0.95);
        if (getCash() >= priceWithDiscount) {
            setCash(getCash() - priceWithDiscount);
            System.out.println(getName() + " купил " + product.getProductName() + " со скидкой.");
            if (!getProducts().containsKey(product.getProductName())) {
                getProducts().put(product.getProductName(), 1);
            } else {
                getProducts().put(product.getProductName(), getProducts().get(product.getProductName()) + 1);
            }
        } else {
            System.out.println(getName() + " не может купить " + product.getProductName() + ", недостаточно средств даже со скидкой.");
        }
    }
}