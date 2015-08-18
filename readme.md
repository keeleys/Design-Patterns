## 创建型

### 单例
有几种单例，不过大体上都是构造方法私有，然后内部生成唯一的实例。
```java
public class Singleton {
    private static Singleton singleton = new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return singleton;
    }
}
```

### 工厂模式

其实用的地方呢 就是有一组对象都提供了我需要的方法，我不用记住那么多对象实现，我只需要选择创建哪种就好了。
```

//一个产品接口
interface IProduct {
    public void productMethod();
}

//产品实现A
class ProductA implements IProduct {
    @Override
    public void productMethod() {
        System.out.println("ProductA");
    }
}
//产品实现B
class ProductB implements IProduct {
    @Override
    public void productMethod() {
        System.out.println("ProductB");
    }
}

//工厂接口，有一个生产产品的方法。
interface IFactory {
    public IProduct createProduct(String type);
}
//一个工厂实现
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

//测试
public class Client {

    public static void main(String []args){
        IFactory fac = new Factory();
        IProduct pro = fac.createProduct("B");
        pro.productMethod();
    }
}
```

### 抽象工厂
就是比如你创建实现类A1的时候 创建B类的实现的时候必须创建的是B1类，创建A2类的时候 必须也一起创建B2类，A,B类是一个相关联的族群，就需要抽象工厂了，因为单个的工厂创建的产品没有A,B的关联关系了。
比如我吃面包必须配牛奶，油条必须配豆浆

```
//吃的
interface Food{
    public void eat();
}
//喝的
interface Drink{
    public void drink();
}

//一个吃的实现例子，
class BreadA implements Food{
    public void eat(){
        System.out.println("吃面包");
    }
}
//一个喝的实现例子，
class JuiceA implements Drink{
    @Override
    public void drink() {
        System.out.println("喝牛奶");
    }
}

//一个吃的实现例子，
class BreadB implements Food{
    public void eat(){
        System.out.println("吃油条");
    }
}
//一个喝的实现例子，
class JuiceB implements Drink{
    @Override
    public void drink() {
        System.out.println("喝豆浆");
    }
}

//抽象工厂接口
interface Factory{
    // 2个产品族
    Food createFood();
    Drink createDrink();
}
//早餐工厂A
class FactoryA implements Factory{

    @Override
    public Food createFood() {
        return new BreadA();
    }

    @Override
    public Drink createDrink() {
        return new JuiceA();
    }
}

//早餐工厂B
class FactoryB implements Factory{

    @Override
    public Food createFood() {
        return new BreadB();
    }

    @Override
    public Drink createDrink() {
        return new JuiceB();
    }
}

public class Client {
    public static void main(String []args){
        Factory factory = new FactoryA();
        factory.createDrink().drink();
        factory.createFood().eat();

        factory =  new FactoryB();
        factory.createDrink().drink();
        factory.createFood().eat();
    }
}
```

### 建造者模式
假如要创建一个复杂对象，对象的创建需要设置很多属性，甚至属性的设置还有前后依赖，这时候用创建者给直接组装好。
比如你点一个肯德基套餐S1 我会自动创建薯条，汉堡等，然后返回给你一个套餐。

建造者模式包含如下角色：

* Builder：抽象建造者
* ConcreteBuilder：具体建造者
* Director：指挥者
* Product：产品角色

![Builder.jpg](https://dn-tianjun.qbox.me/ttianjunBuilder.jpg)

```java

//抽象创造者对象 有一个创建对象方法
abstract class Build {
    /**
    创建一组固定参数的 复杂的对象，这时候可以系统内部自己创建了，不用用户自己一个个赋值。
     */
    public abstract Product build();
}

//具体建造者
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

    //省略getter setter
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
//测试
public class Client {
    public static void main(String []args){
        Director dir = new Director();
        dir.setBuilder(new BuildBaidu());
        dir.build().showProduct();
    }
}


```
