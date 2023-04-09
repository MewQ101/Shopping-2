import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class Husband extends Woman {
    private int money = 500;  // Усі гроші
    private int price = 0;  // Загальна ціна
    private int price2;
    ArrayList<String> noVal;  // список усіх продуктів яких нема в наявності
    private void allPrice(){
        System.out.println("У вас на рахунку " + money + "грн");
        System.out.println("Загальна ціна покупки : " + price);
        if(money - price < 0)
            System.out.println("Недостатньо коштів, треба ще : " + (price - money) + "грн");
        else
            System.out.println("У вас залишилось ще : " + (money - price) + "грн");

    }
    private Street OpenMap(){
        Street allShops = new Street();
        return allShops;
    }
    public void GoShopping(){
        System.out.println("* Йдем до магазину *");
        System.out.println("Весь список товарів :");
        for(Shop i : Street.allShops){ // для усіх магазинів. пройтись по магазинам і вивести усі продукти
            for (String productName : i.getAllProducts()) {
                System.out.println(productName + " - " + i.getPrice(productName) + " грн");
            }
        }
        System.out.println();
        int count = 0;
        for (String productName : getAllProducts()) { // додаємо ціну за товар в кошику
            count = 0;
            for( Shop i : Street.allShops) {
                if(i.containsProduct(productName)) {
                    price2 = 0;
                    price2 += i.buyProduct(getCount(productName), i.getPrice(productName));
                    if(price2 > money){
                        price += i.buyProduct(getCount(productName), i.getPrice(productName));
                        System.out.println("Не достатньо грошей для покупки : " + productName);
                        toBuyAgain.put(productName, getCount(productName));
                        break;
                    }
                    money -= price2;
                    canBuy.add(productName);
                }
                else
                    count++;
            }
            if(count == Street.allShops.size()) {
                System.out.println("Товара нема в наявності : " + productName);
                toBuyAgain.put(productName, getCount(productName));
            }
        }
        System.out.println();
        toBuy();
        System.out.println();
        allPrice();
        System.out.println();
    }
}
