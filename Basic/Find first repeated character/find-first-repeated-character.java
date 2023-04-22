//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());
        while(t-- > 0){
            String s = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.firstRepChar(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String firstRepChar(String s) 
    {
        // code here
        String M;
        int[] arr=new int[200];
        int n=s.length();
        for(int i=0;i<n;i++){
            arr[(int)s.charAt(i)]+=1;
            if(arr[(int)s.charAt(i)]==2){
                M=String.valueOf(s.charAt(i));
                return M;
            }
        }
        return "-1";
    }
} 