package HW5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {


        try(PrintWriter writer = new PrintWriter(new File("test.csv"))){
            StringBuffer strDate = new StringBuffer();
            strDate.append("val1;val2;val3");
            strDate.append('\n');
            strDate.append("10;20;30");
            strDate.append('\n');
            strDate.append("40;50;60");
            strDate.append('\n');
            strDate.append("70;80;90");

            writer.write(strDate.toString());
            writer.close();
            System.out.println("done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ReadCVS obj = new ReadCVS();
        obj.run();


    }


}

class ReadCVS{
    public void run(){
        String csvFile = "test.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        try{
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null){
                String[] datas = line.split(cvsSplitBy);
                System.out.println(Arrays.toString(datas));
            }
        }catch (FileNotFoundException exc){
            exc.printStackTrace();
        }catch (IOException exc) {
            exc.printStackTrace();
        }finally {
                if (br !=null){
                    try{
                        br.close();
                    }catch (IOException exc){
                        exc.printStackTrace();
                    }
                }
        }
        System.out.println("Done");
    }
}
