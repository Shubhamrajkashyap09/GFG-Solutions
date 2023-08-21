//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int  Count(int[][] matrix)
    {
         int n=matrix.length;
        int m=matrix[0].length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int sum=0;
                if(matrix[i][j]==0)
                    continue;
                else
                {
                    if(i>0 && matrix[i-1][j]==0)
                        sum++;//top
                    if(j>0 && matrix[i][j-1]==0)
                        sum++;//left
                    if(j<m-1 && matrix[i][j+1]==0)
                        sum++;//right
                    if(i<n-1 && matrix[i+1][j]==0)
                        sum++;//bottom
                    if(i>0 && j>0 && matrix[i-1][j-1]==0)
                        sum++;//top-left
                    if(i>0 && j<m-1 && matrix[i-1][j+1]==0)
                        sum++; //top-right
                    if(i<n-1 && j>0 && matrix[i+1][j-1]==0)
                        sum++;//bottom-left
                    if(i<n-1 && j<m-1 && matrix[i+1][j+1]==0)
                        sum++;//bottom-right
                }
                if(sum!=0 && sum%2==0)
                    count++;
            }
        }
        return count;
    }
}