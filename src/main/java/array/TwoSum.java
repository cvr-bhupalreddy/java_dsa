package array;

import java.util.HashMap;

public class TwoSum {

    public static String twoSumOptimal(int n, int []book, int target){

        int length = book.length;
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int index = 0; index < length ; index++){

            int remaining = target - book[index];

            if(map.containsKey(remaining)){
                return "YES";
            }
            map.put(book[index], index);

        }
        return "NO";

        // Write your code here.
    }


}
