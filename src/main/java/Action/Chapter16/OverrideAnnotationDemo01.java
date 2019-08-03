package Action.Chapter16;

/**
 * Created by apple on 2019/7/28.
 */





class Person{
    public String getInfo(){
        return "这是一个Person类";
    }
}

@Deprecated
class Student extends Person{
    @Override //防止用户在覆写方法的时候将方法定义出错
    public String getInfo(){
        return "这是一个Student类";
    }

    @Deprecated //不建议使用该方法
    public String getOther(){
        return "这是一个Student:Deprecated注释";
    }
}
@MyDefaultAnnotation(value="hahahha")
class DemoFX<T>{
    private T var;
    public T getVar(){
        return var;
    }
    public void setVar(T var){
        this.var = var;
    }
}



public class OverrideAnnotationDemo01 {
    public static void main(String args[]){
        Student stu = new Student();
        System.out.println(stu.getInfo());
        System.out.println(stu.getOther());

        //SuppressWarnings
        //@SuppressWarnings("unchecked")
        DemoFX demoFx = new DemoFX();
        demoFx.setVar("哈哈哈哈");
        System.out.println("内容:"+demoFx.getVar());

    }
}
