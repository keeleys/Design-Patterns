package 行为型.访问者;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-17
 * Time: 下午3:07
 * To change this template use File | Settings | File Templates.
 */
public class Element1 implements Element {
    @Override
    public void accept(IVisitor v) {
        v.visit(this);
    }

    @Override
    public void doWork() {
        System.out.println("我是访问者1");
    }
}
