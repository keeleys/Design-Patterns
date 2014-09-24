package 行为型.备忘录;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-18
 * Time: 上午10:52
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[]args){
        Caretaker c = new Caretaker();

        Originator o =new Originator();
        o.setState("好的");  //设置状态
        c.addMemento(o.saveMemento());//保存状态

        o.setState("坏的");
        c.addMemento(o.saveMemento());

        o.setState("你的");
        c.addMemento(o.saveMemento());

        o.setState("我的");

        o.restoreMemento(c.getMemento(0));//恢复到0
        System.out.println(o.getState());
        o.restoreMemento(c.getMemento(1));//恢复到1
        System.out.println(o.getState());
        o.restoreMemento(c.getMemento(2));//恢复到2
        System.out.println(o.getState());
        o.restoreMemento(c.getMemento(0));//恢复到0
        System.out.println(o.getState());
    }

}
class Originator {
   private String state;

    String getState() {
        return state;
    }
    void setState(String state) {
        this.state = state;
    }
    //保存状态
    public Memento saveMemento(){
        return new Memento(this.state);
    }
    public void restoreMemento(Memento m){
        state= m.getState();
    }
    class Memento {
        private String state;
        public Memento(String state){
            this.state=state;
        }
        String getState() {
            return state;
        }
        void setState(String state) {
            this.state = state;
        }
    }
}

class Caretaker {
    //定义一个集合来存储多个备忘录
    private List<Originator.Memento> mementoList = new ArrayList();

    List<Originator.Memento> getMementoList() {
        return mementoList;
    }

    void setMementoList(List<Originator.Memento> mementoList) {
        this.mementoList = mementoList;
    }
    void addMemento(Originator.Memento m){
        mementoList.add(0,m);
    }
    Originator.Memento getMemento(int index){
        if(index<mementoList.size())
            return mementoList.get(index);
        return null;
    }

}
