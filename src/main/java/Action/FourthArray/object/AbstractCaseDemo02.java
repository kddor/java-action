package Action.FourthArray.object;

/**
 * Created by apple on 2019/5/24.
 */

abstract class Person{
    private String name;
    private int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void say(){
        System.out.println(this.getContent());
    }
    public abstract String getContent();
}

class Student extends Person{
    private float score;
    public Student(String name,int age,float score){
        super(name,age);
        this.score = score;
    }
    public String getContent() {
        return  "学生姓名："+ super.getName() +"年龄："+super.getAge() + "成绩："+ this.score;
    }
}

class Worker extends Person{
    private float salary;
    public Worker(String name,int age,float salary){
        super(name,age);
        this.salary = salary;
    }

    public String getContent() {
        return  "学生姓名："+ super.getName() +"年龄："+super.getAge() + "薪水："+ this.salary;
    }
}

public class AbstractCaseDemo02 {
    public static void main(String args[]){
        Person p1 = null;
        Person p2 = null;
        p1 = new Student("张三",20,99.0f);
        p2 = new Worker("李四",30,33.0f);
        p1.say();
        p2.say();
    }
}
