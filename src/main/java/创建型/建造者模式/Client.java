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
        dir.setBuilder(new BuildBaidu());
        dir.build().showProduct();
    }
}
//一个指挥官 选择用什么人当创建者
class Director {
    private Build build;
    //这里跟建造者是一样的方法，但是假如要返回一组对象 这里就有用了。
    public Product build(){
        return build.build();
    }
    public void setBuilder(Build build){
        this.build = build;
    }
}

//抽象创造者对象 有一个创建对象方法
abstract class Build {
    /**
    创建一组固定参数的 复杂的对象，这时候可以系统内部自己创建了，不用用户自己一个个赋值。
     */
    public abstract Product build();
}

class BuildBaidu extends Build {
    @Override
    public Product build() {
        Product product = new Product();
        product.setName("Baidu");
        product.setNum(10);
        return product;
    }
}
class BuildGoogle extends Build {
    @Override
    public Product build() {
        Product product = new Product();
        product.setName("google");
        product.setNum(8);
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
