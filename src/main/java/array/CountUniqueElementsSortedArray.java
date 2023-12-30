package array;

public class CountUniqueElementsSortedArray {

    public static void main(String[] args) {
        int numbers[] = new int[]{1, 2, 2, 3, 3, 3, 4, 4, 8, 9, 9, 9};

        int uniqueCount = countUnique(numbers);
        System.out.println("Unique Elements in Array : " + uniqueCount);

    }

    private static int countUnique(int[] numbers) {

        int count = 1;
        int left = 0;
        int right = 1;

        if(numbers.length <1 )
            return 0;
        else if (numbers.length ==1) {
            return 1;

        }


        for (int index = 1; index < numbers.length; index++) {

            if (numbers[left] != numbers[right]) {
                count++;

            }
            left++;
            right++;

        }
        return count;

    }
}