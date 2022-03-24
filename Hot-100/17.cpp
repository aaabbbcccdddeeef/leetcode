//
// Created by 刘志成 on 2022/2/24.
//
#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    vector<string> board={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    vector<string> res;
    string tmp;
    vector <string> letterCombinations(string digits) {
        if((int)digits.size()==0) return {};
        DFS(0,digits);
        return res;
    }
    void DFS(int pos, const string &digits){
        if(pos==(int)digits.size()){
            res.emplace_back(tmp);
            return;
        }
        int num=digits[pos]-'0';
        for(char i : board[num]){
            tmp.push_back(i);
            DFS(pos+1,digits);
            tmp.pop_back();
        }
    }
};