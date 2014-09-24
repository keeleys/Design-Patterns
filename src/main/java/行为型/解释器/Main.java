package 行为型.解释器;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-18
 * Time: 上午9:51
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String []args){

        Context c = new Context(10);
        new PushExpression().parse(c);
        new PushExpression().parse(c);
        new PullExpression().parse(c);
        new PullExpression().parse(c);
        new PushExpression().parse(c);
        System.out.println(c.age);
    }

}
class Context{
    public int age;
    public Context(int age){
        this.age=age;
    }
}
abstract class Expression{
    /**
     * 怎么解析 Context
     * @param c
     */
   public abstract void parse(Context c);
}
class PushExpression extends Expression{

    @Override
    public void parse(Context c) {
        System.out.println("c--");
        c.age--;
    }
}
class PullExpression extends Expression{

    @Override
    public void parse(Context c) {
        System.out.println("c++");
        c.age++;
    }
}


