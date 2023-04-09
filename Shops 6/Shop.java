import java.util.*;
public abstract class Shop {
    private Map<String, Integer> products; // словарь продуктів ( Назва - ціна )
    protected int price = 0;
    protected Shop() {
        products = new HashMap<>();
    }
    protected static int minimumQuantity;
    protected static double discountPercentage;
    protected void Discount(int minimumQuantity, double discountPercentage) {
        this.minimumQuantity = minimumQuantity;
        this.discountPercentage = discountPercentage;
    }
    protected double buyProduct(int quantity, double originalPrice) {
        if (quantity > minimumQuantity) {
            int quantity2 = quantity - minimumQuantity;
            double priceMon = originalPrice/100*discountPercentage;
            double discountAmount = ((quantity - quantity2) * originalPrice) + (quantity2 * (originalPrice - priceMon));
            return discountAmount;
        } else {
            return originalPrice * quantity;
        }
    }

    protected double buyProduct2(int quantity, double originalPrice) {
        if (quantity > minimumQuantity) {
            int quantity2 = quantity - minimumQuantity;
            double priceMon = originalPrice/100*discountPercentage;
            double discountAmount = ((quantity - quantity2) * originalPrice) + (quantity2 * (originalPrice - priceMon));
            return discountAmount;
        } else {
            return originalPrice * quantity;
        }
    }
    protected void addProduct(String productName, int price) { // додати продукт в наявність магазину
        products.put(productName, price);
    }

    protected int getPrice(String productName) { // отримати ціну продукта
        if (products.containsKey(productName)) {
            return products.get(productName);
        }
        return 0;
    }
    protected boolean containsProduct(String productName) { // отримати назву продукта
        return products.containsKey(productName);
    }

    protected Set<String> getAllProducts() { // отримати всі назві продуктів
        return products.keySet();
    }
}
