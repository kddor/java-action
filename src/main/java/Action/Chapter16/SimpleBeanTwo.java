package Action.Chapter16;

/**
 * Created by apple on 2019/7/28.
 */
public class SimpleBeanTwo {
    @SuppressWarnings("unchecked")
    @Deprecated
    @Override
    @MyDefaultAnnotation(key="ly",value = "hello world")
    public String toString(){
        return "Hello World";
    }
}
