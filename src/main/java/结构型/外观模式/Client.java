package 结构型.外观模式;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-18
 * Time: 下午2:51
 * To change this template use File | Settings | File Templates.
 */
public class Client {
    public static void main(String []args){
        new PeopleFacade( new People()).sleep();
    }
}

class People{
    public void methodA(){
        System.out.println("关门");
    }
    public void methodB(){
        System.out.println("关灯");
    }
    public void methodC(){
        System.out.println("上床");
    }
}
class PeopleFacade{
    public People people;  //聚合关系
    public  PeopleFacade(People p){
        this.people = p;
    }
    public void sleep(){
        people.methodA();
        people.methodB();
        people.methodC();
    }
}
