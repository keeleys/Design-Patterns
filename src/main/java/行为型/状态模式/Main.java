package 行为型.状态模式;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-18
 * Time: 下午3:25
 * To change this template use File | Settings | File Templates.
 * 解决的问题  类似开关一样的状态切换
 　　主要解决的是当控制一个对象状态转换的条件表达式过于复杂时的情况。把状态的判断逻辑转移到表示不同的一系列类当中，可以把复杂的逻辑判断简单化。

 */
public class Main {
    public static void main(String[]args){
        Light light = new Light();
        light.content(new Off());

        light.response();
        light.response();
        light.response();
    }
}

class Light{
    private LightState status;

   public void content(LightState lightState){
       this.status=lightState;
   }
    void response(){
        this.status.handler(this);
    }
}
abstract class LightState{
    abstract void handler(Light l);
}
class Off extends LightState{

    @Override
    void handler(Light l) {
        System.out.println("开灯");
        l.content(new On());
    }
}
class On extends LightState{

    @Override
    void handler(Light l) {
        System.out.println("关灯");
        l.content(new Off());
    }
}
