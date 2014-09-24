package 行为型.访问者;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-17
 * Time: 下午3:25
 * 双向动态绑定.
 */
class Father {
    public void accept(Execute exe){
        exe.method(this);
    }
}
class Son1 extends Father{
    public void accept(Execute exe){
        exe.method(this);
    }
}
class Son2 extends Father{
    public void accept(Execute exe){
        exe.method(this);
    }
}

class Execute {
    public void method(Father father){
        System.out.println("This is Father's method");
    }

    public void method(Son1 son){
        System.out.println("This is Son1's method");
    }

    public void method(Son2 son){
        System.out.println("This is Son2's method");
    }
}
public class DoubleMain {
    public static void main(String[] args){
        Father father = new Father();
        Father s1 = new Son1();
        Father s2 = new Son2();

        Execute exe = new Execute();
        father.accept(exe);
        s1.accept(exe);
        s2.accept(exe);
    }
}
