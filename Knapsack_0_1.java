import java.util.Scanner;

public class Knapsack_0_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] weight = new int[n];
        int[] profit = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight of item " + (i + 1) + ": ");
            weight[i] = sc.nextInt();

            System.out.print("Enter profit of item " + (i + 1) + ": ");
            profit[i] = sc.nextInt();
        }

        System.out.print("Enter knapsack capacity: ");
        int W = sc.nextInt();

        int[][] dp = new int[n + 1][W + 1];

        // Dynamic Programming
        for (int i = 1; i <= n; i++) {

            for (int w = 0; w <= W; w++) {

                if (weight[i - 1] <= w) {

                    dp[i][w] = Math.max(
                        profit[i - 1] + dp[i - 1][w - weight[i - 1]],
                        dp[i - 1][w]
                    );

                } else {

                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("Maximum Profit: " + dp[n][W]);

        // Display selected items
        System.out.println("Selected Items:");

        int w = W;

        for (int i = n; i > 0; i--) {

            if (dp[i][w] != dp[i - 1][w]) {

                System.out.println("Item " + i);
                w = w - weight[i - 1];
            }
        }

        sc.close();
    }
}










//recurive solution with memoization


// import java.util.Scanner;

// public class Knapsack_0_1 {

//     static int[][] dp;

//     // Recursive function with memoization
//     static int knapsack(int[] weight, int[] profit, int W, int n) {

//         // Base condition
//         if (n == 0 || W == 0) {
//             return 0;
//         }

//         // If already calculated
//         if (dp[n][W] != -1) {
//             return dp[n][W];
//         }

//         // Pick and Not Pick
//         if (weight[n - 1] <= W) {

//             int pick = profit[n - 1] +
//                        knapsack(weight, profit,
//                        W - weight[n - 1], n - 1);

//             int notPick = knapsack(weight, profit,
//                                    W, n - 1);

//             dp[n][W] = Math.max(pick, notPick);

//         } else {

//             // Cannot pick the item
//             dp[n][W] = knapsack(weight, profit, W, n - 1);
//         }

//         return dp[n][W];
//     }

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter number of items: ");
//         int n = sc.nextInt();

//         int[] weight = new int[n];
//         int[] profit = new int[n];

//         for (int i = 0; i < n; i++) {

//             System.out.print("Enter weight of item " + (i + 1) + ": ");
//             weight[i] = sc.nextInt();

//             System.out.print("Enter profit of item " + (i + 1) + ": ");
//             profit[i] = sc.nextInt();
//         }

//         System.out.print("Enter knapsack capacity: ");
//         int W = sc.nextInt();

//         // Initialize DP array with -1
//         dp = new int[n + 1][W + 1];

//         for (int i = 0; i <= n; i++) {
//             for (int j = 0; j <= W; j++) {
//                 dp[i][j] = -1;
//             }
//         }

//         int ans = knapsack(weight, profit, W, n);

//         System.out.println("Maximum Profit: " + ans);

//         // Display selected items
//         System.out.println("Selected Items:");

//         int w = W;

//         for (int i = n; i > 0; i--) {

//             if (dp[i][w] != -1 && dp[i][w] != dp[i - 1][w]) {
//                 System.out.println("Item " + i);
//                 w = w - weight[i - 1];
//             }
//         }

//         sc.close();
//     }
// }
