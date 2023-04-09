import java.util.LinkedList;

public class Street {
    static LinkedList<Shop> allShops = new LinkedList<>(){{
        add(new TechShop());
        add(new ProductShop());
    }};
}
