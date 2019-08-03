package Action.Chapter16;

/**
 * Created by apple on 2019/7/29.
 */

interface IMessage{
    public void print();
}
public class TestLamdaDemo {
    public static void main(String[] args){
        fun(()->System.out.println("更多课程请访问:"));

    }
    public static void fun(IMessage msg){
        msg.print();
    }

}
