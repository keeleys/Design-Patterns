package 行为型.责任链;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-17
 * Time: 下午4:30
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String []args){
        Handler handlerA = new HandlerA();
        Handler handlerB = new HandlerB();
        handlerA.setNextHandler(handlerB);
        handlerA.process(2);
    }

}

abstract class Handler{
    private Handler nextHandler;
    public void setNextHandler(Handler nextHandler){
        this.nextHandler=nextHandler;
    }
    public void process(int value){
         if(getLevel()>value){
              this.doSomeThing();
         }
         if(nextHandler!=null)
            nextHandler.process(value);

    }
    public abstract int getLevel();
    public abstract void doSomeThing();
}
class HandlerA extends Handler{
    @Override
    public int getLevel() {
        return 1;
    }

    @Override
    public void doSomeThing() {
        System.out.println("handleA");
    }
}
class HandlerB extends Handler{
    @Override
    public int getLevel() {
        return 3;
    }

    @Override
    public void doSomeThing() {
        System.out.println("handleB");
    }
}
