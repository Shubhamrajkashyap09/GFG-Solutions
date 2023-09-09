//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer,Integer> mp = new HashMap<>();
        int[] pre=new int[n];
        int max=0;
        pre[0]=arr[0];
        mp.put(0,-1);
        for(int i=1;i<n;i++){
            pre[i]=arr[i]+pre[i-1];
        }
        for(int i=0;i<n;i++){
            if(!mp.containsKey(pre[i])){
                mp.put(pre[i],i);
            }
            else{
                if(max<i-(mp.get(pre[i]))){
                    max=i-(mp.get(pre[i]));
                }
            }
        }
        return max;
    }
}