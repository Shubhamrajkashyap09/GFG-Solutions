//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        //code here
        int n= S.length();
        StringBuilder s2 = new StringBuilder(S);
        String Snew= (s2.reverse()).toString();
        
        int[][] dp= new int[n+1][n+1];
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                
                if(S.charAt(i-1)==Snew.charAt(j-1))  dp[i][j]= 1+dp[i-1][j-1];
                else dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                
            }
        }
        
        return dp[n][n];
    }
}