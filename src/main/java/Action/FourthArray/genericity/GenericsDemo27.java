package Action.FourthArray.genericity;

/**
 * Created by apple on 2019/6/29.
 */

class Info<T extends Number>{
    private T var;
    public T getVar(){
        return var;
    }
    public void setVar(T var){
        this.var = var;
    }
    public String toString(){
        return this.var.toString();
    }
}
public class GenericsDemo27 {
    public static void main(String args[]){
        Info<Integer>  i = fun(30);
        System.out.println(i.getVar());
    }

    public static <T extends Number> Info<T> fun(T param){
        Info<T> temp = new Info<T>();
        temp.setVar(param);
        return temp;
    }

}
