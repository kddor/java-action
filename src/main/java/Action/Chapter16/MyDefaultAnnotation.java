package Action.Chapter16;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by apple on 2019/7/28.
 */
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyDefaultAnnotation{
    public String key() default "ly";
    public String value() default "hello world";
}

