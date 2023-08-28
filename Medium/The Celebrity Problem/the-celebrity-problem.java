//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack<Integer> st = new Stack<>();
    	for(int i=0;i<n;i++){
    	    st.push(i);
    	}
    	while(st.size()>1){
    	    int v1=st.pop();
    	    int v2=st.pop();
    	    if(M[v1][v2]==0) st.push(v1);
    	    else if(M[v2][v1]==0) st.push(v2);
    	}
    	if(st.size()==0) return -1;
    	int pot=st.pop();
    	for(int j=0;j<n;j++){
    	    if(M[pot][j]==1) return -1;
    	}
    	for(int i=0;i<n;i++){
    	    if(pot==i) continue;
    	    if(M[i][pot]==0) return -1;
    	}
    	return pot;
    }
}