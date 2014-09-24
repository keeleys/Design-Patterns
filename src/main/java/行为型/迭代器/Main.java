package 行为型.迭代器;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-17
 * Time: 下午5:44
 *  迭代器模式
 */
public class Main {
    public static void main(String []args){
        MyList<String> my = new MyListA<String>();
        my.add("123");
        my.add("321");
        my.add("1111");
        Iterator<String> it = my.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
interface Iterator<T>{
    boolean hasNext();
    T next();
}
class MyIterator<T> implements Iterator<T>{
    private List<T> list;
    private int currentIndex=0;
    public MyIterator(List<T> list){
        this.list=list;
    }
    @Override
    public boolean hasNext() {
        return currentIndex!=list.size();
    }

    @Override
    public T next() {
        return list.get(currentIndex++);
    }
}
interface MyList<T>{
    public Iterator<T> iterator();
    public void add(T t);
}
class MyListA<T> implements  MyList<T>{
    private List<T> list = new ArrayList<T>();
    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>(list);
    }

    @Override
    public void add(T t) {
        list.add(t);
    }
}
