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

        factory =  new FactoryB();
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
//一个吃的实现例子，
class BreadA implements Food{
    public void eat(){
        System.out.println("吃面包");
    }
}
//一个喝的实现例子，
class JuiceA implements Drink{
    @Override
    public void drink() {
        System.out.println("喝牛奶");
    }
}

//一个吃的实现例子，
class BreadB implements Food{
    public void eat(){
        System.out.println("吃油条");
    }
}
//一个喝的实现例子，
class JuiceB implements Drink{
    @Override
    public void drink() {
        System.out.println("喝豆浆");
    }
}
interface Factory{
    // 2个产品族
    Food createFood();
    Drink createDrink();
}
//早餐工厂A
class FactoryA implements Factory{

    @Override
    public Food createFood() {
        return new BreadA();
    }

    @Override
    public Drink createDrink() {
        return new JuiceA();
    }
}

//早餐工厂B
class FactoryB implements Factory{

    @Override
    public Food createFood() {
        return new BreadB();
    }

    @Override
    public Drink createDrink() {
        return new JuiceB();
    }
}
