package homework07;

import java.time.LocalDate;

public class DiscountProduct extends Product {
    private int discount;
    private LocalDate discountExpiry;

    public DiscountProduct(String productName, int price, boolean isChildFriendly, int discount, LocalDate discountExpiry) {
        super(productName, price, isChildFriendly);
        if (discount <= 0) {
            throw new IllegalArgumentException("Скидка должна быть положительным числом");
        }
        this.discount = discount;
        this.discountExpiry = discountExpiry;
    }

    @Override
    public int getPrice() {
        if (LocalDate.now().isBefore(discountExpiry)) {
            return super.getPrice() - discount;
        }
        return super.getPrice();
    }
}
