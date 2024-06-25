package homework06;

public record ListOfProducts() {
    static Product milk = new Product("Молоко", 60);
    static Product bread = new Product("Хлеб", 40);
    static Product cake = new Product("Торт", 1000);
    static Product coffee = new Product("Кофе", 879);
    static Product butter = new Product("Масло", 150);
}
