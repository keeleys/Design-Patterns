package 行为型.访问者;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-17
 * Time: 下午3:09
 * To change this template use File | Settings | File Templates.
 */
public class Visitor implements IVisitor {
    @Override
    public void visit(Element1 e) {
        e.doWork();
    }

    @Override
    public void visit(Element2 e) {
        e.doWork();
    }
}
