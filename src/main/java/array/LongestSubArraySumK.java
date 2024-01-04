package array;

import java.util.HashMap;

public class LongestSubArraySumK {



    public static int getLongestSubarrayHashing(int []nums, int k) {
        // Write your code here.
        int length = nums.length;

        int sum  = 0;
        int maxLength = 0;

        HashMap<Integer , Integer> partialSumMap = new HashMap<>();

        for(int index = 0 ;index<= length-1 ; index++ ) {
            sum += nums[index];

            if (sum == k) {
                maxLength = Math.max(maxLength, index + 1);
            }

            int remaining = sum - k;

            if (partialSumMap.containsKey(remaining)) {
                int len = index - partialSumMap.get(remaining);
                maxLength = Math.max(maxLength, len);
            }

            if (!partialSumMap.containsKey(sum)) {
                partialSumMap.put(sum, index);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1,0,-1,2,1,1,-1,-1,1};
        int len = getLongestSubarrayHashing(numbers,3);

        int[] numbers1 = new int[]{1,0,0,1,0,1,0,2,1,3};

        System.out.println("Max Length of SubArray with Sum is:" + len);

        int len1 = longestSubArrayOptimal(numbers1,3);

        System.out.println("Max Length of SubArray with Sum is:" + len1);


    }

    public static int longestSubArrayOptimal(int[] numbers , int k){
        int length = numbers.length;
        int maxLength = 0;
        int sum = 0;
        int left ;
        int right;
        int subArrayCount = 0;
        left = right = 0;



        sum = numbers[0];

        while(right < length){

            while( sum > k && left <= right){
                sum -= numbers[left];
                left++;
            }
            if(sum == k){
                maxLength = (right-left+1) > maxLength ? (right-left+1) : maxLength;
                subArrayCount++;
            }
            sum += numbers[right];
            right++;
        }

        System.out.println("Number of SubArrays : " + subArrayCount);
        return maxLength;
    }


    public static int getLongestSubarray(int []nums, int k) {
        // Write your code here.

        int length = nums.length;

        int sum ;
        int maxLength = 0;

        for(int i = 0 ;i<= length-1 ; i++ )
        {
            sum = 0;

            for(int j = i ; j <= length-1 ; j++)
            {
                sum += nums[j];

                if(sum == k){
                    maxLength = (j-i+1) > maxLength ? (j-i+1) : maxLength;
                }
            }
        }
        return maxLength;
    }
}
