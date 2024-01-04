package array;

import java.util.Arrays;

public class MoveZerosEnd {

    public static int[] moveZeros(int n , int[] a){

        int left = 0;
        int right = 1;

        while(right < n){
            if(a[left] == 0){
                while(right < n && a[right]== 0){
                    right++;
                }
                if(right < n) {
                    a[left] = a[right];
                    a[right] = 0;
                    right++;
                    left++;
                }
            }
            else
            {
                left++;
                right++;

            }

        }
        return a;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{7,93,0,8 ,15, 0 ,0 ,0 ,0 ,0 ,26 ,0 ,0 ,0 ,43 ,90 ,2 ,0 ,0 ,0 ,58 ,94 ,77 ,45 ,59 ,19 ,0 ,0 ,98 ,0 ,0 ,0 ,0 ,0 ,88 ,0 ,0 ,0 };

        int[] result = moveZeros(numbers.length , numbers);

        printArray(result);
    }

    private static void printArray(int[] numbers) {
        Arrays.stream(numbers).forEach(System.out::print);
    }
}
