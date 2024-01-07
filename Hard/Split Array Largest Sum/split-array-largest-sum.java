//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[]arr,int N,int K){
        long low= Arrays.stream(arr).max().getAsInt();
        long high= Arrays.stream(arr).sum();
        while(low<high){
            long mid = low +(high - low) /2;
            int count= getCount(arr, N, mid);
            
            if(count > K){
                low =mid+1;
            }else{
                high=mid;
            }
        }
        return (int)low;
    }
    static int getCount(int arr[], int N, long maxSum){
        int count =1;
         long currentSum = 0;
        
        for (int num : arr) {
            currentSum += num;
            if (currentSum > maxSum) {
                count++;
                currentSum = num;
            }
        }
        
        return count;
    }
};