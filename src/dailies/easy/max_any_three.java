package dailies.easy;

import java.util.Arrays;

public class max_any_three {
    /**
     * Given a list of integers, return the largest product that can be made by multiplying any three integers.
     * For example, if the list is [-10, -10, 5, 2], we should return 500, since that's -10 * -10 * 5.
     * You can assume the list has at least three integers.
     */
    public static void main(String[] args) {

        int[] arr = new int[] {-10, -10, 5, 2};

        int count = 3;
        int a = findHighest(arr, count);
        System.out.println(a);
    }

    private static int findHighest(int[] arr, int count) {
        if (count < 3) {
            return -1;
        }

        int maxA = Integer.MIN_VALUE,
            maxB = Integer.MIN_VALUE,
            maxC = Integer.MIN_VALUE;

        int minA = Integer.MAX_VALUE,
            minB = Integer.MAX_VALUE;

        for(int i = 0; i < count; i++)
        {
            if (arr[i] > maxA) {
                maxC = maxB;
                maxB = maxA;
                maxA = arr[i];
            }

            else if (arr[i] > maxB) {
                maxC = maxB;
                maxB = arr[i];
            }

            else if (arr[i] > maxC)
                maxC = arr[i];

            if (arr[i] < minA){
                minB = minA;
                minA = arr[i];
            } else if(arr[i] < minB)
                minB = arr[i];
        }

        return Math.max(minA * minB * maxA, maxA * maxB * maxC);
    }
}
