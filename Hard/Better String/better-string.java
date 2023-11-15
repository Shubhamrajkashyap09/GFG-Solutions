//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();

            Solution obj = new Solution();
            String ans = obj.betterString(str1, str2);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static String betterString(String str1, String str2) {
        int first = countDistrinctSubsequence(str1);
        int second = countDistrinctSubsequence(str2);
        if(first>=second){
            return str1;
        }else{
            return str2;
        }
    }
    public static int countDistrinctSubsequence(String s){
        
        int dp[] = new int[s.length()+1];
        dp[0] = 1;
        
        int ch[] = new int[26];
        
        for(int i=1;i<dp.length;i++){
            int val = ch[s.charAt(i-1)-'a'];
            dp[i] = ((2 * dp[i-1])) - val;
            ch[s.charAt(i-1) - 'a'] = dp[i-1];
        }
        int ans = dp[s.length()];
        return ans;
    }
}