//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int sum = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(arr, sum));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int count(int coins[], int sum) {
        // Create a DP array to store the number of ways to make each sum
        int[] dp = new int[sum + 1];

        // Base case: There's 1 way to make sum 0 (use no coins)
        dp[0] = 1;

        // Iterate through each coin
        for (int coin : coins) {
            // Update the dp array for sums >= coin
            for (int j = coin; j <= sum; j++) {
                dp[j] += dp[j - coin];
            }
        }

        // The answer is the number of ways to make the target sum
        return dp[sum];
    }
}

