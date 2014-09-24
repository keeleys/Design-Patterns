package 行为型.命令模式;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-17
 * Time: 下午4:03
 * To change this template use File | Settings | File Templates.
 */

class Invoker{
    private Command command;
    public void setCommand(Command command){
        this.command = command;
    }
    public void action()
    {
        command.execute();
    }
};
abstract  class Command{
    public abstract void execute();
};
class Command1 extends  Command{
    public Receiver receiver;
    public Command1(Receiver receiver){
        this.receiver =receiver;
    }
    @Override
    public void execute() {
        receiver.do1();
    }
}
class Command2 extends  Command{
    public Receiver receiver;
    public Command2(Receiver receiver){
        this.receiver =receiver;
    }
    @Override
    public void execute() {
        receiver.do2();
    }
}
class Receiver{
    public void do1(){
        System.out.println("do1");
    }
    public void do2(){
        System.out.println("do2");
    }
};
/*
调用者选择不同的命令
得到不同的执行结果
 */

public class Main {
    public static  void main(String[]args){
        Receiver r = new Receiver();
        Invoker invoker = new Invoker();
        invoker.setCommand(new Command1(r));
        invoker.action();
        invoker.setCommand(new Command2(r));
        invoker.action();

    }
}



