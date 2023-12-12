//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int n, int m, int M[][])
    {
        // code here
        int ans = 0;
        //staring from last second last col
        for(int col=m-2;col>=0;col--){
            for(int row=0;row<n;row++){
                int temp = M[row][col+1];
                if(row-1>=0){
                    temp = Math.max(M[row-1][col+1],temp);
                }
                if(row+1<n){
                 temp = Math.max(M[row+1][col+1],temp);
                }
                M[row][col] = M[row][col] + temp;
                if(col==0){
                    ans = Math.max(M[row][col],ans);
                }
            }
        }
        return ans;
    }
}