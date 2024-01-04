package array;

import java.util.Arrays;



public class Sort012 {

    public static  void sort012(int[] arr){

        int low ,mid,high;

        low = mid = 0;
        high = arr.length-1;
        int temp;

        while(mid <=high){

            if(arr[mid] == 0){
                temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            }
            else if (arr[mid] == 1){
                mid++;
            }
            else  {
                temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {

        int[] numbers = new int[]{1,2,0,2,1,2,0,0,1,1,2,0,1,0};

        System.out.println("Array Length = "+ numbers.length);

        System.out.println("Numbers Before Sorting");

        printArray(numbers);


        sort012(numbers);

        System.out.println("");
        System.out.println("Numbers After Sorting");

        printArray(numbers);

    }

    private static void printArray(int[] numbers) {
        Arrays.stream(numbers).forEach(System.out::print);
    }
}
