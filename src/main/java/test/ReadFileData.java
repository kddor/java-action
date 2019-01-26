package test;

import java.io.*;
import java.util.*;


/**
 * description:
 *
 * @outhor wq
 * @create 2018-06-02 13:29
 */
public class ReadFileData {
    private static final String FILE_PATH="/Users/apple/Desktop/dataNode.txt";
    public static void main(String[] args) {


        List<DataNode> list=queryById("101");


        StringBuilder sb = new StringBuilder();
        sb.append("{\"101\":");
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(list.get(i).toString());
        }
        sb.append("]}");
        System.out.println(sb.toString());
    }

    public static List<DataNode> queryById(String queryId){
        if(queryId==null || queryId.isEmpty()){
            return null;
        }

        List<String> list = readFile();

        List<DataNode> dataNodes=new ArrayList<>();

        String temp, id, date;
        String[] ary, values;
        DataNode dataNode;
        int startDate, endDate;
        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i);
            values = new String[4];

            ary = temp.split(":");
            if (ary.length < 6) {
                continue;
            }
            id = ary[0];
            if(!id.equals(queryId)){
                continue;
            }


            date = ary[1].replaceAll("\\[|\\]","");
            values[0] = ary[2];
            values[1] = ary[3];
            values[2] = ary[4];
            values[3] = ary[5];

            //判断是不是时间段
            ary = date.split(",");
            if (ary.length > 1) {
                startDate = Integer.parseInt(ary[0]);
                endDate = Integer.parseInt(ary[1]);
                for (int j = startDate; j < endDate; j++) {
                    //System.out.println(id + " " + j + " " + Arrays.toString(values));
                    dataNode = new DataNode();
                    dataNode.setId(id);
                    dataNode.setDate(j);
                    dataNode.setValues(values);
                    dataNodes.add(dataNode);
                }
            } else {
                //System.out.println(id + " " + date + " " + Arrays.toString(values));

                dataNode = new DataNode();
                dataNode.setId(id);
                dataNode.setDate(Integer.parseInt( date));
                dataNode.setValues(values);
                dataNodes.add(dataNode);
            }
        }


        Collections.sort(dataNodes);

        return dataNodes;
    }

    //读取指定id数据
    public static List<String> readFile(){

        File file =new File(FILE_PATH);
        if(!file.exists()){
            return null;
        }
        List<String> list=new ArrayList<String>();
        InputStreamReader inputStreamReader;

        try {
            inputStreamReader=new InputStreamReader(new FileInputStream(file));
            BufferedReader br=new BufferedReader(inputStreamReader);
            String line="";
            int i=0;
            while ((line=br.readLine())!=null){
                list.add(line);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<String> getData() {
        List<String> list = new ArrayList<>();
        list.add("101:10:0:0:0:0");
        list.add("101:11:0:0:0:1");
        list.add("101:12:0:0:0:0");
        list.add("101:13:1:1:1:1");
        list.add("101:14:0:0:0:0");
        list.add("101:15:0:0:0:0");
        list.add("101:[0,5]:0:0:0:0");
        list.add("101:[21,23]:0:0:0:0");
        list.add("102:10:0:0:0:0");
        list.add("102:11:0:0:0:1");
        list.add("102:12:0:0:0:0");
        list.add("102:13:1:1:1:1");
        list.add("102:14:0:0:0:0");
        list.add("102:15:0:0:0:0");
        list.add("102:[0,5]:0:0:0:0");
        list.add("102:[21,23]:0:0:0:0");
        list.add("103:10:0:0:0:0");
        list.add("103:11:0:0:0:1");
        list.add("103:12:0:0:0:0");
        list.add("103:13:1:1:1:1");
        list.add("103:14:0:0:0:0");
        list.add("103:15:0:0:0:0");
        list.add("103:[0,5]:0:0:0:0");
        list.add("103:[21,23]:0:0:0:0");
        return list;

    }
}
