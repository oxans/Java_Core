package HW3;

import java.sql.Array;

/*
    Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
 */
class TempNum<T>{
    private T temp;

    public TempNum(T temp){
        this.temp = temp;
    }
    public T getTemp(){
        return temp;
    }
    public T setTemp(){
        T temp = this.temp;
        return temp;
    }

}
public class Task01 {

    public static void main(String[] args){
        int[] Myarray = new int[]{1, 5, 7, 8, 25};

        int i = Myarray[2];
        int j = Myarray[4];
        System.out.println("Array:" + Myarray);

         switchArray(Myarray[], i, j);


    }

    private static void switchArray(Integer[] array, int i, int j) {
        TempNum<Integer> temp = new TempNum<>(array[i]);
        array[i] = array[j];
        array[j] = temp.getTemp();
    }


}
