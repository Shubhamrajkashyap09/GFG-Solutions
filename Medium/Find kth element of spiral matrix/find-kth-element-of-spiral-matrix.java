//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method*/
    int findK(int A[][], int n, int m, int k)
    {
	// Your code here
	int i=0, j=0;
        while(k > 2*n+2*m-4){
            k -= 2*n+2*m-4;
            n -= 2;
            m -= 2;
            i++;    j++;
        }
        if(k > m){
            k -= m;
            j += m-1;
            if(k > n-1){
                k -= n-1;
                i += n-1;
                if(k > m-1){
                    k -= m-1;
                    j -= m-1;
                    i -= k;
                }else
                    j -= k;
            }else
                i += k;
        }else
            j += k-1;
        return A[i][j];
    }
}