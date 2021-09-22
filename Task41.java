package HW4;

import java.util.*;

public class Task41 {
    public static void main(String[] args) {
        String[] strList = {"milk", "cat", "home", "cat", "cloud",
                            "milk", "hamster", "cat", "sun", "food",
                            "cat", "moon", "wind", "mist", "cat"};
        uniqWorld(strList);
    }
    
    
    public static void uniqWorld(String[] array){

        ArrayList<String> arrL = new ArrayList<>();
        arrL.addAll(Arrays.asList(array));

        for (String r: arrL){
            System.out.println(r + ": "+ Collections.frequency(arrL, r));
        }

        Set<String> set = new HashSet<>(arrL);
        arrL.clear();
        arrL.addAll(set);
        System.out.println(set);
    }
}
