//{ Driver Code Starts
import java.util.*;

class Sorted_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            GfG obj = new GfG();
            System.out.println(obj.transitionPoint(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG {
    int transitionPoint(int arr[], int n) {
        // code here
        if(n>1 && arr[n-2]==0 && arr[n-1]==1){
           return n-1;
       }
       if(arr[0]==1){
           return 0;
       }
        for(int i=0;i<n-1;i++){
            if(arr[i]==0 && arr[i+1]==1){
                return i+1;
            }
        }
        return -1;
    }
}