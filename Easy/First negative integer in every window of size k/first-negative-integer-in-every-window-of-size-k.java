//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        Queue<Integer> q = new LinkedList<>();
        long[] ans = new long[N-K+1];
        for(int i=0;i<N;i++){
            if(A[i]<0) q.add(i);
        }
        int z=0;
        for(int i=0;i<N-K+1;i++){
            // if(q.size()==0) ans[i]=0;
            // else if(i<q.peek() && i+K-1<q.peek()) ans[i]=0;
            // else if(q.size()>0 && i==q.peek()){
            //     ans[z++]=A[q.peek()];
            //     q.remove();
            // }
            // else if(q.size()>0 && i<q.peek()){
            //     ans[z++]=A[q.peek()];
            // }
            while(q.size()>0 && q.peek()<i) q.remove();
            if(q.size()>0 && q.peek()<=i+K-1) ans[i]=A[q.peek()];
            else{
                ans[i]=0;
            }
        }
        return ans;
    }
}