//{ Driver Code Starts
import java.util.*;
class GenIP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution sln = new Solution();
            ArrayList<String> str = sln.genIp(s);
            Collections.sort(str);
            if(str.size() == 0)
                System.out.println(-1);
            else{
                for (String u : str) {
                    System.out.println(u);
                }
            }
        }
    }
}
// } Driver Code Ends


/*complete the Function*/

class Solution {
    static boolean check(String s){
        int n=s.length();
        if(n<=0 || n>3){
            return false;
        }
        if(s.charAt(0)=='0' && n>1){
            return false;
        }
        int p=Integer.parseInt(s);
        if(p<0 || p>255){
            return false;
        }
        else 
            return true;
    }
    static String Genrate(String s,int n,int i,int j,int k){
        String s1=s.substring(0,i+1);
        String s2=s.substring(i+1,j+1);
        String s3=s.substring(j+1,k+1);
        String s4=s.substring(k+1,n);
        if(check(s1) && check(s2) && check(s3) && check(s4)){
            return s1+"."+s2+"."+s3+"."+s4;
        }
        return "";
    }
    public ArrayList<String> genIp(String s) {
        ArrayList<String> ans=new ArrayList<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    String st=Genrate(s,n,i,j,k);
                    if(st.length()>0){
                        ans.add(st);
                    }
                }
            }
        }
        if(ans.isEmpty()){
            ans.add("-1");
            return ans;
        }
        return ans;
    }
}