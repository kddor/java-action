package Action.Chapter16;

/**
 * Created by apple on 2019/7/28.
 */
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
public class ReflectDemo01 {
    public static void main(String args[]) throws Exception{
        Class<?> c = null;
        c = Class.forName("Action.Chapter16.SimpleBeanOne");
        Method toM = c.getMethod("toString");
        Annotation an[] = toM.getAnnotations();
        for(Annotation a:an){
            System.out.println(a);
        }

    }
}
