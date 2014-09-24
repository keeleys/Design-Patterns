package 结构型.享元模式;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-19
 * Time: 上午11:41
 *  以共享的方式高效地支持大量的细粒度对象  例如String
 *  享元模式一般是解决系统性能问题的，所以经常用于底层开发，在项目开发中并不常用
 */
public class Main {
    public static void main(String []args){
        // 订单生成工厂
        Client.flavorFactory = FlavorFactory.getInstance();
        Client client = new Client();
        // 增加订单
        Client.takeOrders("摩卡");
        Client.takeOrders("卡布奇诺");
        Client.takeOrders("香草星冰乐");
        Client.takeOrders("香草星冰乐");
        Client.takeOrders("拿铁");
        Client.takeOrders("卡布奇诺");
        Client.takeOrders("拿铁");
        Client.takeOrders("卡布奇诺");
        Client.takeOrders("摩卡");
        Client.takeOrders("香草星冰乐");
        Client.takeOrders("卡布奇诺");
        Client.takeOrders("摩卡");
        Client.takeOrders("香草星冰乐");
        Client.takeOrders("拿铁");
        Client.takeOrders("拿铁");

        // 卖咖啡
        for (Order order : Client.orders) {
            order.sell();
        }

        // 打印生成的订单java对象数量
        System.out.println("\n客户一共买了 " + Client.orders.size() + " 杯咖啡! ");

        // 打印生成的订单java对象数量
        System.out.println("共生成了 " + Client.flavorFactory.getTotalFlavorsMade()
                + " 个 FlavorOrder java对象! ");
    }

}
abstract class Order {
    // 执行卖出动作
    public abstract void sell();
}
class FlavorOrder extends Order {
    public String flavor;
    // 获取咖啡口味
    public FlavorOrder(String flavor) {
        this.flavor = flavor;
    }@Override
     public void sell() {
        System.out.println("卖出一份" + flavor + "的咖啡。");
    }
}
class FlavorFactory {
    private Map<String, Order> flavorPool = new HashMap<String, Order>();

    // 静态工厂,负责生成订单对象
    private static FlavorFactory flavorFactory = new FlavorFactory();

    private FlavorFactory() {
    }

    public static FlavorFactory getInstance() {
        return flavorFactory;
    }

    public Order getOrder(String flavor) {
        Order order = null;

        if (flavorPool.containsKey(flavor)) {// 如果此映射包含指定键的映射关系，则返回 true
            order = flavorPool.get(flavor);

        } else {
            order = new FlavorOrder(flavor);
            flavorPool.put(flavor, order);
        }
        return order;
    }

    public int getTotalFlavorsMade() {
        return flavorPool.size();
    }
}
class Client {
    // 客户下的订单
    public static List<Order> orders = new ArrayList<Order>();

    // 订单对象生成工厂
    public static FlavorFactory flavorFactory;

    // 增加订单
    public static void takeOrders(String flavor) {
        orders.add(flavorFactory.getOrder(flavor));
    }
}
