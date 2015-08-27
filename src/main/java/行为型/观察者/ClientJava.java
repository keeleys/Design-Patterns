package 行为型.观察者;

import java.util.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by TianJun on 2015-08-27.
 * java提供的观察者类的实现
 */
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
