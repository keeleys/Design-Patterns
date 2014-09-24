package 创建型.工厂模式;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-13
 * Time: 上午10:59
 * To change this template use File | Settings | File Templates.
 */
public class Client {

    public static void main(String []args){
        IFactory fac = new Factory();
        IProduct pro = fac.createProduct("B");
        pro.productMethod();
    }
}

interface IFactory {
    public IProduct createProduct(String type);
}

class Factory implements IFactory{

    @Override
    public IProduct createProduct(String type) {
        if(type.equals("A"))
            return new ProductA();
        if(type.equals("B"))
            return new ProductB();
        return null;
    }
}

interface IProduct {
    public void productMethod();
}

class ProductA implements IProduct {
    @Override
    public void productMethod() {
        System.out.println("ProductA");
    }
}
class ProductB implements IProduct {
    @Override
    public void productMethod() {
        System.out.println("ProductB");
    }
}


