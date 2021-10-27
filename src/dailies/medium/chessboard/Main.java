package dailies.medium.chessboard;

public class Main {
    /**
     * On our special chessboard, two bishops attack each other if they share the same diagonal.
     * This includes bishops that have another bishop located between them, i.e. bishops can attack through pieces.
     *
     * You are given N bishops, represented as (row, column) tuples on a M by M chessboard. Write a function to count
     * the number of pairs of bishops that attack each other. The ordering of the pair doesn't matter:
     * (1, 2) is considered the same as (2, 1).
     *
     * For example, given M = 5 and the list of bishops:
     *
     * (0, 0)
     * (1, 2)
     * (2, 2)
     * (4, 0)
     * The board would look like this:
     *
     * [b 0 0 0 0]
     * [0 0 b 0 0]
     * [0 0 b 0 0]
     * [0 0 0 0 0]
     * [b 0 0 0 0]
     * You should return 2, since bishops 1 and 3 attack each other, as well as bishops 3 and 4.
     *
     * Upgrade to premium and get in-depth solutions to every problem, including this one. Since you were referred
     * by one of our affiliates, you'll get a 10% discount on checkout!
     *
     * If you liked this problem, feel free to forward it along so they can subscribe here! As always, shoot us an
     * email if there's anything we can help with!
     */
    public static void main(String[] args) {
        int n = 2;
        int k = 2;
        long ans = bishop_placements(n, k);
        System.out.println(ans);
    }

    // returns the number of ways to fill a
    // n * n chessboard with k bishops so
    // that no two bishops attack each other.
    private static long bishop_placements(int n, int k) {
        // return 0 if the number of valid places to be
        // filled is less than the number of bishops
        if (k > 2 * n - 1)
            return 0;

        // dp table to store the values
        long[][] dp = new long[n * 2][k + 1];

        // Setting the base conditions
        for (int i = 0; i < n * 2; i++)
            dp[i][0] = 1;
        dp[1][1] = 1;

        // calculate the required number of ways
        for (int i = 2; i < n * 2; i++) {
            for (int j = 1; j <= k; j++)
                dp[i][j]
                        = dp[i - 2][j]
                        + dp[i - 2][j - 1] * (squares(i) - j + 1);
        }

        // stores the answer
        long ans = 0;
        for (int i = 0; i <= k; i++) {
            ans += dp[n * 2 - 1][i] * dp[n * 2 - 2][k - i];
        }

        return ans;
    }

    private static int squares(int i) {
        if ((i & 1) == 1)
            return i / 4 * 2 + 1;
        else
            return (i - 1) / 4 * 2 + 2;
    }
}
