//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class GfG { 
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    int[] arr = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++)arr[i] = Integer.parseInt(inputLine[i]);
		    
		    Solution obj = new Solution();
		    System.out.println(obj.firstElementKTime(n, k, arr));
		}
	}
}

// } Driver Code Ends


class Solution
{
    public int firstElementKTime(int n, int k, int[] a) { 
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i=0;i<n;i++){
            if(hs.containsKey(a[i])){
                hs.put(a[i],hs.get(a[i])+1);
                if(hs.get(a[i])==k){
                    return a[i];
                }
            }
            else{
                hs.put(a[i],1);
            }
        }
        return -1;
    } 
}