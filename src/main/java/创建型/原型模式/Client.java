package 创建型.原型模式;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-19
 * Time: 下午2:03
 * 实现一个接口，重写一个方法即完成了原型模式
 */
public class Client {
    public static void main(String[] args){
        ConcretePrototype cp = new ConcretePrototype();
        for(int i=0; i< 10; i++){
            ConcretePrototype clonecp = cp.clone(); //通过拷贝创建新的对象
            clonecp.show();
        }
    }
}
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

