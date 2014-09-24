package 行为型.访问者;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-17
 * Time: 下午3:06
 * To change this template use File | Settings | File Templates.
 */
public interface IVisitor {
    public void visit(Element1 e);
    public void visit(Element2 e);

}
