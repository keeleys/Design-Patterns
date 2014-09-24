package 创建型.建造者模式;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-13
 * Time: 下午2:17
 * 工厂模式关注的是创建单个产品，而建造者模式则关注创建符合对象
 */
public class Client {
    public static void main(String []args){
        Director dir = new Director();
        dir.getProduct1().showProduct();
        dir.getProduct2().showProduct();
    }
}
class Director {
    private AbsBuild build = new Build();
    public Product getProduct1(){
        build.setProd("tianjun",15);
        return build.getProduct();
    }
    public Product getProduct2(){
        build.setProd("zhangxia",20);
        return build.getProduct();
    }
}


abstract class AbsBuild {
    public abstract void setProd(String name,int num);
    public abstract Product getProduct();
}
class Build extends AbsBuild {
    Product product = new Product();
    @Override
    public void setProd(String name, int num) {
        //To change body of implemented methods use File | Settings | File Templates.
        product.setName(name);
        product.setNum(num);
    }

    @Override
    public Product getProduct() {
        return product;
    }
}

class Product {
    private String name;
    private int num;

    public void showProduct(){
        System.out.println("name :"+name);
        System.out.println("age:"+num);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
