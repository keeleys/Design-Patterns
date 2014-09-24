package 结构型.代理模式;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-19
 * Time: 下午2:14
 *  为其他对象提供一种代理，并以控制对这个对象的访问。（
 *
 */
public class Client {
    public static void main(String []args){

        IGamePlayer player = new PlayerProxy("zhangsan");
        player.login("keeley","123456");
        player.killBoss();
        player.killBoss();
        player.upgrade();
    }

}
interface IGamePlayer{
    public void killBoss() ;
    public void login(String user, String password);
    public void upgrade();
}
class Player implements IGamePlayer{
    private String name;
    public Player(IGamePlayer player,String name){
        if(player==null) throw new RuntimeException("不能创建真实角色");
        this.name = name;
    }
    @Override
    public void killBoss() {
        System.out.println(name+",在打怪");
    }

    @Override
    public void login(String user, String password) {
        System.out.println(name+",正在用账户"+user+",登录中");
    }

    @Override
    public void upgrade() {
        System.out.println(name+",升级了");
    }
}
class PlayerProxy implements IGamePlayer{
    private Player player;
    public PlayerProxy(String name){
         this.player = new Player(this,name);
    }
    @Override
    public void killBoss() {
        player.killBoss();
    }

    @Override
    public void login(String user, String password) {
        player.login(user,password);
    }

    @Override
    public void upgrade() {
        player.upgrade();
    }

}
