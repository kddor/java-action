package Action.FourthArray.genericity;

/**
 * Created by apple on 2019/6/29.
 */


class Demo{
    //定义一个泛型方法
    //该方法可以接收任意类型的数据
    public <T> T fun(T t){
        return  t;
    }
}

public class GenericsDemo26 {
    public static void main(String args[]){
        Demo d = new Demo();
        String str = d.fun("hello world");
        int i  = d.fun(30);
        System.out.println(str);
        System.out.println(i);
    }
}
