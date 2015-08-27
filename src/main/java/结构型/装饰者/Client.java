package 结构型.装饰者;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-12
 * Time: 下午2:30
 * To change this template use File | Settings | File Templates.
 */
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
class AniminPro extends AnimiDecorator {
    public AniminPro(Animi animi) {
        super(animi);
    }
    public void eat() {
        System.out.println("animi eat");
    }
}

