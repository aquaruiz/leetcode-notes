package dailies.easy;

import java.util.stream.IntStream;

public class Rand7 {

    /**
     * Using a function rand7() that returns an integer from 1 to 7 (inclusive) with uniform probability,
     * implement a function rand5() that returns an integer from 1 to 5 (inclusive).
     *
     */
    public static void main(String[] args) {
        for (int i : IntStream.range(0,10).toArray())
        {
            System.out.print(rand7() + " ");
        }
    }

    public static int rand5()
    {
        return (int) (5.0 * Math.random()) + 1;
    }

    // avg - O(1) | worst - O(n)
    public static int rand7()
    {
        int i;
        i = 5*rand5() + rand5() - 5; // 1 to 25
        if (i < 22)
            return i%7 + 1;
        return rand7();
    }
}
