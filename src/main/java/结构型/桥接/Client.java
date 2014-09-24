package 结构型.桥接;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-19
 * Time: 上午10:39
 *
 *  什么人吃什么食物喝什么饮料
 *
 */
public class Client {
    public static void main(String []args){
        People pa = new PeopleA();
        Drink drink  = new Juice();
        Food food = new Bread();

        pa.setDrink(drink);
        pa.setFood(food);

        pa.process();
    }
}
abstract class People{
    private Drink drink;
    private Food food;
    abstract void say();
    void process(){
        say();
        drink.drink();
        food.eat();
    }
    void setDrink(Drink drink) {
        this.drink = drink;
    }
    void setFood(Food food) {
        this.food = food;
    }
}
interface Drink{
    void drink();
}
interface Food{
     void eat();
}
class Juice implements Drink{
    @Override
    public void drink() {
        System.out.println("喝着橙汁");
    }
}
class Bread implements Food{
    @Override
    public void eat() {
        System.out.println("吃着面包");
    }
}
class PeopleA extends People{
    @Override
    void say() {
        System.out.println("peopleA");
    }
}
