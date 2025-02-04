//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (long i : array) arr[idx++] = (int)i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.firstRepeated(arr));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to return the position of the first repeating element.
    public static int firstRepeated(int[] arr) {
        int n=arr.length;
        HashMap<Integer,int[]> map = new HashMap<>();
        for(int i=0;i<n;i++){
           if(map.containsKey(arr[i])){
               map.get(arr[i])[1]++;
           }else{
               map.put(arr[i], new int[]{i+1,1});
           }
        }
        for(int i=0;i<n;i++){
            int[] data= map.get(arr[i]);
            if(data[1]>1){
                return data[0];
            }
        }
        return -1;
    }
}
