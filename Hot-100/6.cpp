#include<bits/stdc++.h>
using namespace std;

class Solution{
public:
    string convert(string s,int numRows){
        int n=s.size(), r=numRows;
        if(r==1 || r>=n){
            return s;
        }
        string ans;
        int t=r*2-2;
        for(int i=0;i<r;++i){
            for(int j=0;i+j<n;j+=t){
                ans+=s[i+j];
                if(0<i && i<r-1 && j+t-i<n){
                    ans+=s[j+t-i];
                }
            }
        }
        return ans;
    }
};