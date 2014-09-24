package 结构型.适配器;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-12
 * Time: 下午3:32
 * To change this template use File | Settings | File Templates.
 */
public class Client {
    public static void main(String[]args){
        new Adapter(new Adaptee()).request();
    }
}
interface Target {
    void request();
}
class Adaptee {
    public void specificRequest(){
        System.out.println("adaptee request");
    }
}
class Adapter implements  Target {
    @Override
    public void request() {
        adaptee.specificRequest();
    }
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
}
