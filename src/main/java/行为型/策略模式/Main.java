package 行为型.策略模式;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-17
 * Time: 下午5:27
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String []args){
        Client client = new Client();
        client.setStarategy(new StarategyA());
        client.execute();
        client.setStarategy(new StarategyB());
        client.execute();
    }
}
abstract class Starategy{
   public abstract void doSomeThing();
}
class Client{
    private Starategy starategy;
    public void setStarategy(Starategy starategy){
        this.starategy = starategy;
    }
    public void execute(){
        starategy.doSomeThing();
    }
}
class StarategyA extends Starategy{

    @Override
    public void doSomeThing() {
        System.out.println("doA");
    }
}
class StarategyB extends Starategy{

    @Override
    public void doSomeThing() {
        System.out.println("doB");
    }
}

