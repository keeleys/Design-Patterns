package 结构型.组合模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-19
 * Time: 上午11:06
 *    比如一个商店调整了价格 让所有分店价格都改变
 */
public class Client {
    public static void main(String []args){
        Shop s1 = new CompositeShop("广东店");
        Shop s2 = new CompositeShop("深圳分店");
        Shop s3 = new LeafShop("深圳南山分店");
        Shop s4 = new LeafShop("深圳福田分店");

        s1.addShop(s2);
        s2.addShop(s3);
        s2.addShop(s4);

        s1.changePrice(45.5);

    }
}

interface Shop{
    void addShop(Shop s);
    void removeShop(Shop s);
    void changePrice(Double price);
    String getName();
}

/**
 * 最终节点店
 */
class LeafShop implements Shop{
    private String name;
    @Override
    public void addShop(Shop s) {
        System.out.println("不提供");
    }

    @Override
    public void removeShop(Shop s) {
        System.out.println("不提供");
    }

    @Override
    public void changePrice(Double price) {
        System.out.println(getName()+":改变价格为"+price);
    }
    public LeafShop(String name){
       this.name=name;
    }
    @Override
    public String getName() {
        return this.name;
    }
}

/**
 * 组合店
 */
class CompositeShop implements Shop{
   List<Shop> shopList = new ArrayList();
    private String name;

    CompositeShop(String name) {
        this.name = name;
    }

    @Override
    public void addShop(Shop s) {
        //To change body of implemented methods use File | Settings | File Templates.
        shopList.add(s);
    }

    @Override
    public void removeShop(Shop s) {
        //To change body of implemented methods use File | Settings | File Templates.
        shopList.remove(s);
    }

    @Override
    public void changePrice(Double price) {
        System.out.println(getName()+":改变价格为"+price);
        for(Shop s : shopList){
            s.changePrice(price);
        }
    }

    @Override
    public String getName() {
        return this.name;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
