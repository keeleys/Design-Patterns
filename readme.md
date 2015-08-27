## 创建型

### 单例

>有几种单例，不过大体上都是构造方法私有，然后内部生成唯一的实例。

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

>其实用的地方呢 就是有一组对象都提供了我需要的方法，我不用记住那么多对象实现，我只需要选择创建哪种就好了。

```java

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
>就是比如你创建实现类A1的时候 创建B类的实现的时候必须创建的是B1类，创建A2类的时候 必须也一起创建B2类，A,B类是一个相关联的族群，就需要抽象工厂了，因为单个的工厂创建的产品没有A,B的关联关系了。
>比如我吃面包必须配牛奶，油条必须配豆浆

```java
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
>假如要创建一个复杂对象，对象的创建需要设置很多属性，甚至属性的设置还有前后依赖，这时候用创建者给直接组装好。
>比如你点一个肯德基套餐S1 我会自动创建薯条，汉堡等，然后返回给你一个套餐。

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

### 原型模式
![原型模式](https://dn-tianjun.qbox.me/ttianjun1332722887_7899.jpg)

* 在java语言有一个Cloneable接口，它的作用只有一个，就是在运行时通知虚拟机可以安全地在实现了此接口的类上使用clone方法。在java虚拟机中，只有实现了这个接口的类才可以被拷贝，否则在运行时会抛出CloneNotSupportedException异常。
* 重写Object类中的clone方法。Java中，所有类的父类都是Object类，Object类中有一个clone方法，作用是返回对象的一个拷贝，但是其作用域protected类型的，一般的类无法调用，因此，Prototype类需要将clone方法的作用域修改为public类型。

>使用原型模式创建对象比直接new一个对象在性能上要好的多，因为Object类的clone方法是一个本地方法，它直接操作内存中的二进制流，特别是复制大对象时，性能的差别非常明显。
>使用原型模式的另一个好处是简化对象的创建，使得创建对象就像我们在编辑文档时的复制粘贴一样简单。
>因为以上优点，所以在需要重复地创建相似对象时可以考虑使用原型模式。比如需要在一个循环体内创建对象，假如对象创建过程比较复杂或者循环次数很多的话，使用原型模式不但可以简化创建过程，而且可以使系统的整体性能提高很多。

```java
class Prototype<T extends Prototype> implements Cloneable{
    public T clone(){
        T prototype = null;
        try{
            prototype = (T)super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return prototype;
    }

}
class ConcretePrototype extends Prototype<ConcretePrototype>{
    public ConcretePrototype(){
        System.out.println("==构造方法");
    }
    public void show(){
        System.out.println("原型模式实现类"+this.hashCode());
    }
}

public class Client {
    public static void main(String[] args){
        ConcretePrototype cp = new ConcretePrototype();
        for(int i=0; i< 10; i++){
            ConcretePrototype clonecp = cp.clone(); //通过拷贝创建新的对象
            clonecp.show();
        }
    }
}
```

## 结构型

### 代理模式

![Proxy](https://dn-tianjun.qbox.me/ttianjunProxy.jpg)

* 抽象角色：声明真实对象和代理对象的共同接口。
* 代理角色：代理对象角色内部含有对真实对象的引用，从而可以操作真实对象，同时代理对象提供与真实对象相同的接口以便在任何时刻都能代替真实对象。同时，代理对象可以在执行真实对象操作时，附加其他的操作，相当于对真实对象进行封装。
* 真实角色：代理角色所代表的真实对象，是我们最终要引用的对象。

> 下面的例子，一个游戏玩家，一个游戏代练者给一个玩家做代练。

```java
public class Client {
    public static void main(String []args){

        IGamePlayer player = new PlayerProxy("zhangsan");
        player.login("keeley","123456");
        player.killBoss();
        player.killBoss();
        player.upgrade();
    }

}
interface IGamePlayer{
    public void killBoss() ;
    public void login(String user, String password);
    public void upgrade();
}
class Player implements IGamePlayer{
    private String name;
    public Player(IGamePlayer player,String name){
        if(player==null) throw new RuntimeException("不能创建真实角色");
        this.name = name;
    }
    @Override
    public void killBoss() {
        System.out.println(name+",在打怪");
    }

    @Override
    public void login(String user, String password) {
        System.out.println(name+",正在用账户"+user+",登录中");
    }

    @Override
    public void upgrade() {
        System.out.println(name+",升级了");
    }
}
class PlayerProxy implements IGamePlayer{
    private Player player;
    public PlayerProxy(String name){
         this.player = new Player(this,name);
    }
    @Override
    public void killBoss() {
        player.killBoss();
    }

    @Override
    public void login(String user, String password) {
        player.login(user,password);
    }

    @Override
    public void upgrade() {
        player.upgrade();
    }

}
```

### 装饰模式

![decorator](https://dn-tianjun.qbox.me/ttianjunDecorator.jpg)

* Component: 抽象构件
* ConcreteComponent: 具体构件
* Decorator: 抽象装饰类
* ConcreteDecorator: 具体装饰类

一般有两种方式可以实现给一个类或对象增加行为：

* 继承机制，使用继承机制是给现有类添加功能的一种有效途径，通过继承一个现有类可以使得子类在拥有自身方法的同时还拥有父类的方法。但是这种方法是静态的，用户不能控制增加行为的方式和时机。
* 关联机制，即将一个类的对象嵌入另一个对象中，由另一个对象来决定是否调用嵌入对象的行为以便扩展自己的行为，我们称这个嵌入的对象为装饰器(Decorator)

装饰模式以对客户透明的方式动态地给一个对象附加上更多的责任，换言之，客户端并不会觉得对象在装饰前和装饰后有什么不同。装饰模式可以在不需要创造更多子类的情况下，将对象的功能加以扩展。

> animi有一个说话的方法，装饰者AnimiDecorator装饰animi，AnimiDecorator的实现可以增加方法从而到达扩展animi的目的。
```java
public class Client {
    public static void main(String[]args){
        AniminPro animi = new AniminPro(new AnimiImpl());
        animi.say();
        animi.eat();
    }
}

interface Animi {
    public void say();
}

class AnimiImpl implements Animi {
    @Override
    public void say() {
        System.out.println("animi say");
    }
}
//抽象装饰类 实现了Animi接口 并且关联了Animi对象的默认say方法的实现。
class AnimiDecorator implements Animi {
    @Override
    public void say() {
        animi.say();
    }
    private Animi animi;

    public AnimiDecorator(Animi animi) {
        this.animi = animi;
    }
}
//继承抽象装饰者 在此基础上做横向扩展
class AniminPro extends AnimiDecorator {
    public AniminPro(Animi animi) {
        super(animi);
    }
    public void eat() {
        System.out.println("animi eat");
    }
}

```

## 行为模式

### 策略模式

> 比如计算折扣，积分，根据不同的条件调用不同的计算方法的时候，就可以用策略模式来调用。
> 策略算法是相同行为的不同实现。
> 策略模式的重心不是如何实现算法，而是如何组织、调用这些算法，从而让程序结构更灵活，具有更好的维护性和扩展性。
>客户端必须知道所有的策略类，并自行决定使用哪一个策略类

![123](https://dn-tianjun.qbox.me/ttianjun%E4%B8%8B%E8%BD%BD.png)

```java
//抽象折扣类
interface MemberStrategy {
    /**
     * 计算图书的价格
     * @param booksPrice    图书的原价
     * @return    计算出打折后的价格
     */
    public double calcPrice(double booksPrice);
}

//初级会员折扣类
class PrimaryMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double booksPrice) {
        
        System.out.println("对于初级会员的没有折扣");
        return booksPrice;
    }

}
//中级会员折扣类
class IntermediateMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double booksPrice) {

        System.out.println("对于中级会员的折扣为10%");
        return booksPrice * 0.9;
    }

}
//高级会员折扣类
class AdvancedMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double booksPrice) {
        
        System.out.println("对于高级会员的折扣为20%");
        return booksPrice * 0.8;
    }
}

//价格类
class Price {
    //持有一个具体的策略对象
    private MemberStrategy strategy;
    /**
     * 构造函数，传入一个具体的策略对象
     * @param strategy    具体的策略对象
     */
    public Price(MemberStrategy strategy){
        this.strategy = strategy;
    }
    
    /**
     * 计算图书的价格
     * @param booksPrice    图书的原价
     * @return    计算出打折后的价格
     */
    public double quote(double booksPrice){
        return this.strategy.calcPrice(booksPrice);
    }
}

//客户端
public class Client {

    public static void main(String[] args) {
        //选择并创建需要使用的策略对象
        MemberStrategy strategy = new AdvancedMemberStrategy();
        //创建环境
        Price price = new Price(strategy);
        //计算价格
        double quote = price.quote(300);
        System.out.println("图书的最终价格为：" + quote);
    }

}

```


### 观察者模式

>当被观察者发生状态改变时，通知所有观察者执行代码

>两种实现 一种自己写的，一种jdk自带的

```java

/**
 * 观察者接口
   有一个update方法，执行检查到被观察者改变之后的动作。
 */
interface Observer<T extends Observable> {
    public void update(T a);
}

/**
特定的观察者的实现类。
*/

class ObserverImpl implements Observer<User> {
    @Override
    public void update(User a) {
        System.out.println("检测到name:"+a.getName());
    }
}

/**
 * 抽象的被观察者类
 */
abstract class Observable{
    private List<Observer> observerList = new ArrayList<Observer>();
    public Observable addListen(Observer observer){
        observerList.add(observer);
        return this;
    }
    public Observable deleteListen(Observer observer){
        observerList.remove(observer);
        return this;
    }
    protected void notifyObserver(){
        for(Observer o: observerList){
            o.update(this);
        }
    }
}

//实际的被观察者 需要手动通知观察者自己的改变

class User extends Observable {
    private String name;
    public void setName(String name) {
        this.name=name;
        this.notifyObserver();
    }
    public String getName(){
        return name;
    }
}
```

jdk的自带实现
```
public class ClientJava {

    public static void main(String[]args){
        Product product = new Product();
        product.addObserver(new Listener());
        product.setName("TianJun");
    }
}

class Product extends java.util.Observable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.setChanged();

        //这里有一个带参数的重载，带参数会通知给观察者 update(Observable o, Object arg) 的第二个参数,第一个参数是被观察者本身。

        this.notifyObservers();
    }
}
class Listener implements Observer{

    @Override
    public void update(Observable o, Object arg) {
        Product p = (Product) o;
        System.out.println("改变了name:"+p.getName());
    }
}
```

Observable`的源代码片段
```java
  public void notifyObservers(Object arg) {
        /*
         * a temporary array buffer, used as a snapshot of the state of
         * current Observers.
         */
        Object[] arrLocal;

        synchronized (this) {
            /* We don't want the Observer doing callbacks into
             * arbitrary code while holding its own Monitor.
             * The code where we extract each Observable from
             * the Vector and store the state of the Observer
             * needs synchronization, but notifying observers
             * does not (should not).  The worst result of any
             * potential race-condition here is that:
             * 1) a newly-added Observer will miss a
             *   notification in progress
             * 2) a recently unregistered Observer will be
             *   wrongly notified when it doesn't care
             */
            if (!changed)
                return;
            arrLocal = obs.toArray();
            clearChanged();
        }

        for (int i = arrLocal.length-1; i>=0; i--)
            ((Observer)arrLocal[i]).update(this, arg);
    }
```


