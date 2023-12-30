package org.example;

public class MaxSumSubArray {

    public static void main(String[] args) {
        int numbers[];

        numbers = new int[]{1, 4, -5, -2, 3, 5, -6, 2, 6, -9};

        int numbers1[] = new int[]{8,-5,-6,1,7,-2};


        int subArraySum = kadanesAlgo(numbers);

        System.out.println("Max SubArray Sum " + subArraySum);

        subArraySum = kadanesAlgo(numbers1);

        System.out.println("Max SubArray Sum " + subArraySum);



    }

    private static int kadanesAlgo(int[] numbers) {

        int maxSubArraySum = Integer.MIN_VALUE;
        int sum = 0;
        for(int index = 0 ; index < numbers.length ; index++){
            sum += numbers[index];
            if(sum > maxSubArraySum){
                maxSubArraySum = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return maxSubArraySum;
    }

    private static int buySellStock(int[] numbers) {

        int buy = 0;

        int profit = 0;

        for(int sell = 1 ; sell < numbers.length ;sell++){

            if(numbers[sell] < numbers[buy]){
                buy = sell;
            }
            if(profit < (numbers[sell] - numbers[buy])){
                profit = numbers[sell] - numbers[buy];
            }


        }
        return profit;
    }

    private static int secondLargestElement(int[] numbers) {

        int largest = numbers[0];
        int sLargest = Integer.MIN_VALUE;

        for(int index = 1 ; index < numbers.length ; index++){
            if(numbers[index] > largest){
                sLargest = largest;
                largest = numbers[index];
            } else if (numbers[index] < largest && numbers[index] >=sLargest) {
                sLargest = numbers[index];

            }

        }
        return sLargest;
    }


    private static int maxArray(int[] numbers) {
        int max= Integer.MIN_VALUE;

        for (int number:numbers) {

            if(number >= max){
                max = number;
            }

        }
        return max;
    }
}
