package Action.Chapter16;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by apple on 2019/7/28.
 */
public class ReflectDemo02 {
    public static void main(String args[]) throws Exception{
        Class<?> c = null;
        c = Class.forName("Action.Chapter16.SimpleBeanTwo");
        Method toM = c.getMethod("toString");
        if(toM.isAnnotationPresent(MyDefaultAnnotation.class)){
            MyDefaultAnnotation mda = null;
            mda = toM.getAnnotation(MyDefaultAnnotation.class);
            String key = mda.key();
            String value = mda.value();
            System.out.println("key="+ key);
            System.out.println("value="+ value);
        }

    }
}
