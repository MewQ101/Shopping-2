class ProductShop extends Shop {
    @Override
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
    public ProductShop() { // магазин продуктів
        addProduct("Apple", 300); // добавляємо продукти
        addProduct("Bread", 110);
        addProduct("Sausage", 80);
        addProduct("Butter", 70);
        addProduct("Milk", 300);
        addProduct("Potato", 40);

        Discount(5, 20.0);
    }
}
