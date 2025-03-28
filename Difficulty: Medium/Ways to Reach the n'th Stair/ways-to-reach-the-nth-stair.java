//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        while (t-- > 0) {

            // taking count of stairs
            int m = sc.nextInt();

            // creating an object of class DynamicProgramming
            Solution obj = new Solution();

            // calling method countWays() of class
            // DynamicProgramming
            System.out.println(obj.countWays(m));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countWays(int n) {
        // your code here
        if(n==1)
        {
            return 1;
        }
        if(n==2)
        {
            return 2;
        }
        int a = 1;
        int b = 2;
        int result = 0;
        for(int i=3;i<=n;i++)
        {
            result = a+b;
            a = b;
            b = result;
        }
        return result;
        
    }
}
