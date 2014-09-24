package 行为型.访问者;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-17
 * Time: 下午3:11
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args){
        new Element1().accept(new Visitor());
        new Element1().accept(new Visitor());
        new Element2().accept(new Visitor());
        new Element2().accept(new Visitor());
    }
}
