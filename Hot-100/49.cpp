//
// Created by liu on 2022/3/14.
//
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<int> prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        const int mod=INT_MAX;
        map<int,vector<string>> group_map;
        for(const auto& str:strs){
            int tmp=1;
            for(auto i:str){
                tmp*=prime[i-'a'];
                tmp%=mod;
            }
            if(group_map.count(tmp)){
                group_map[tmp].push_back(str);
            }else{
                group_map.insert(make_pair(tmp,vector<string>{str}));
            }
        }
        vector<vector<string>> ans;
        for(const auto& i:group_map){
            ans.emplace_back(i.second);
        }
        return ans;
    }
};
class Solution1 {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        // 自定义对 array<int, 26> 类型的哈希函数
        auto arrayHash = [fn = hash<int>{}] (const array<int, 26>& arr) -> size_t {
            return accumulate(arr.begin(), arr.end(), 0u, [&](size_t acc, int num) {
                return (acc << 1) ^ fn(num);
            });
        };

        unordered_map<array<int, 26>, vector<string>, decltype(arrayHash)> mp(0, arrayHash);
        for (string& str: strs) {
            array<int, 26> counts{};
            int length = str.length();
            for (int i = 0; i < length; ++i) {
                counts[str[i] - 'a'] ++;
            }
            mp[counts].emplace_back(str);
        }
        vector<vector<string>> ans;
        for (auto it = mp.begin(); it != mp.end(); ++it) {
            ans.emplace_back(it->second);
        }
        return ans;
    }
};