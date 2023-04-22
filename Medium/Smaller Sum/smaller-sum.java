//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine());
            String s[]=in.readLine().trim().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            long ans[]=ob.smallerSum(n,a);
            for(long i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends

//User function Template for Java
class Solution
{
    public long[] smallerSum(int n,int arr[])
    {
        long sum=0;
        int[] temp=arr.clone();
         Arrays.sort(arr);
        long[] b=new long[n];
        Map<Integer,Long> map=new HashMap<Integer,Long>(); 
        for(int i=0;i<n;i++)
        {
         
          if(!map.containsKey(arr[i]))
          {
              map.put(arr[i],sum);
          }
          sum+=arr[i];
        }
        for(int i=0;i<n;i++)
        {
            b[i]=map.get(temp[i]);
        }
            
        return b;
    }
}