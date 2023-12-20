//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution{
    public:
    int findWinner(int n, int A[]){
        
        int xx=0;
        unordered_map<int,int> mp;
        for(int i=0;i<n;i++)
        {
            mp[A[i]]++;
            xx^=A[i];
        }
        
        if(!xx)
        return 1;
        
        bool flag=0;
        int even=0;
        for(auto it:mp)
        {
            if(it.second%2==0)
            even++;
        }
        
        if(even&1)
        flag=(!flag);
        
        if(flag)
        {
            if(mp.size()&1)
            return 1;
            else
            return 2;
        }
        else
        {
            if(mp.size()&1)
            return 2;
            else
            return 1;
        }
        
        return 0;
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        int A[n];
        for(int i = 0;i < n;i++)
            cin>>A[i];
        
        Solution ob;
        cout<<ob.findWinner(n, A)<<"\n";
    }
    return 0;
}
// } Driver Code Ends