//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

    int maxIndexDiff(int arr[], int n) {
        // code here
        int Rightmax[] = new int[n];
        int Leftmin[] = new int[n];
        
        Leftmin[0] = arr[0];
        for(int i=1;i<n;i++)
        {
            Leftmin[i] = Math.min(arr[i],Leftmin[i-1]);
        }
        
        Rightmax[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--)
        {
            Rightmax[i] = Math.max(arr[i],Rightmax[i+1]);
        }
        
        int i=0,j=0;
        //i represent traversal in leftmin
        //j represent traversal in rightmax
        int Maxans = 0;
        while(i<n && j<n)
        {
            if(Rightmax[j]>=Leftmin[i])
            {
                Maxans = Math.max(Maxans,j-i);
                j++;
            }
            else
            {
                i++;
            }
        }
        return Maxans;
    }
}