package 创建型.抽象工厂;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-19
 * Time: 上午10:09
 * 创建一组相关联的族群 就需要抽象工厂.
 */
public class Client {
    public static void main(String []args){
        Factory factory = new FactoryA();
        factory.createDrink().drink();
        factory.createFood().eat();
    }
}

interface Food{
    public void eat();
}
interface Drink{
    public void drink();
}
class Bread implements Food{
    public void eat(){
        System.out.println("吃面包");
    }
}
class Juice implements Drink{
    @Override
    public void drink() {
        System.out.println("喝果汁");
    }
}
interface Factory{
    // 2个产品族
    Food createFood();
    Drink createDrink();
}
class FactoryA implements Factory{

    @Override
    public Food createFood() {
        return new Bread();
    }

    @Override
    public Drink createDrink() {
        return new Juice();
    }
}

