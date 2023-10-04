//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        // code here
         int ans=0;
        HashMap<Character,Integer>map=new HashMap<>();
        map.put('I',1);
         map.put('V',5);
          map.put('X',10);
           map.put('L',50);
            map.put('C',100);
             map.put('D',500);
              map.put('M',1000);
               int n=str.length();
                    int prev=0;
               for(int i=n-1;i>=0;i--)
               {
                  int temp= map.get(str.charAt(i));
                  if(prev>temp)
                  {
                      ans=ans-temp; 
                  }
                  else{
                  ans+=temp;
                  }
                  prev=temp;
               }
               return ans;
    }
}