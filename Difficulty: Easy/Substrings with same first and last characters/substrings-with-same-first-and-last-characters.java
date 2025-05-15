//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();

            Solution ob = new Solution();
            int result = ob.countSubstring(s);

            System.out.println(result);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countSubstring(String s) {
        
        Map<Character,Integer> strings = new HashMap<>();
        int count =0;
        
        for(int i=0; i<s.length() ;i++){
            
            if(!strings.containsKey(s.charAt(i))){
                strings.put(s.charAt(i),1);
            }else{
                strings.put(s.charAt(i), strings.get(s.charAt(i)) + 1);
            }
            
            
        }
        
        for(Map.Entry<Character,Integer> entrySet : strings.entrySet()){
            count = count + ( entrySet.getValue() * (entrySet.getValue() +1))/2;
        }
        return count;
    }
}