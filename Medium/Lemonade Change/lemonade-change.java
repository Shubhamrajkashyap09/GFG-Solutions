//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.lemonadeChange(n, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean lemonadeChange(int N, int bills[]) {
        // code here
        int sum=0;
        int cn5=0;
        int cn10=0;
        int i=0;
        while(i<N){
            if(bills[i]==5){
                cn5++;
            }
            else if(bills[i]==10){
                if(cn5!=0){
                    cn5--;
                    cn10++;
                }
                else{
                    return false;
                }
            }
            else{
                if(cn5>=1 && cn10>=1){
                    cn5--;
                    cn10--;
                }
                else if(cn5 >=1 && cn10==0){
                    if(cn5>=3){
                        cn5=cn5-3;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            i++;
            
        }
        return true;
    }
}
