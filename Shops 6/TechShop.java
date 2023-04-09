class TechShop extends Shop {
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
    public TechShop() {  // магазин техніки
        addProduct("Sony", 100); // добавляємо продукт
        addProduct("Samsung", 80);
        addProduct("Sharp", 70);
        addProduct("Aser", 40);

        Discount(5, 20.0);
    }
}

