package 行为型.模板方法;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-24
 * Time: 上午10:44
 * 基于继承的代码复用
 */
public class Client {
    public static void main(String []args){
        AbsTemp temp = new Temp("test1");
        temp.say();
    }
}
abstract class AbsTemp{
    public void say(){
        System.out.println(getName()+"在说话");
    }
    abstract protected String getName();
}
class Temp extends AbsTemp{
    private String name;
    public Temp(String name){
        this.name=name;
    }
    @Override
    protected String getName() {
        return name;
    }
}
