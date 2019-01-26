package test;

import java.util.Arrays;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-06-02 13:33
 */
public class DataNode implements Comparable<DataNode>{
    private String id;
    private int date;
    private String[] values;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "{" +
                //"\"id\":\"" + id + '\"' +
                " \"date\":\"" + date + '\"' +
                ", \"values\":" + Arrays.toString(values) +
                '}';
    }

    @Override
    public int compareTo(DataNode o) {
        int i = this.getDate() - o.getDate();
        return i;
    }
}
