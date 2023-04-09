import java.util.*;

public class Woman {
    private Map<String, Integer> products; // список продуктів
    protected LinkedList<String> canBuy = new LinkedList<>();
    protected Map<String, Integer> toBuyAgain = new HashMap<>();
    public Woman() {
        products = new HashMap<>(); // список товарів для покупки
        addProduct("Bread", 3);
        addProduct("Milk", 2);
        addProduct("Apple", 6);
        addProduct("Banana", 2);
    }

    protected Map GetCart() {
        return products;
    }

    protected int getCount(String productName) {
        return products.get(productName);
    }
    private void addProduct(String productName, Integer count) {
        products.put(productName, count); // додати продукт
    }

    protected Set<String> getAllProducts() { // отримати усі продукти
        return products.keySet();
    }

    protected void toBuy(){
        System.out.println("Треба купити :"); // Вивід списку для купівлі
        for (String productName : getAllProducts()) {
            System.out.println(productName + " - " + products.get(productName) + " шт");
        }
    }

    protected void GoToFriend() {
        System.out.println("* Йдем хвастатись подрузі *");
        if(canBuy.size() > 3) {
            System.out.println("Вау, а ти знаєш що мій чоловік сьогодні накупив? Ні? Ну тоді дивись :");
        } else {
            System.out.println("Та мій чоловік лох, диви як мало продуктів купив :");
        }
        for(String i : canBuy) {
            System.out.println(i + " - " + getCount(i) + " шт");
        }
        System.out.println();
    }

    protected void GoShopAgain(){
        System.out.println("* Йдем знову до магазину *");
        System.out.println("Йди купи усі інші продукти, ось список :");
        for(String i : toBuyAgain.keySet()){
            System.out.println(i + " - " + toBuyAgain.get(i) + " шт");
        }
    }
}
