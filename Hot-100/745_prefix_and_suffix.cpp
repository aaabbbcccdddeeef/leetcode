//
// Created by 刘志成 on 2022/2/17.
//
#include <bits/stdc++.h>
class Trie{
private:
    Trie *children[27]{nullptr};
    int val=-1;
public:
    void insert(string &word, int start, int cur_val){
        Trie *p=this;
        for(int i=start,s=(int)word.size(); i<s; i++){
            int cur=word[i]=='#'?26:word[i]-'a';
            if(!p->children[cur]) p->children[cur]=new Trie;
            p=p->children[cur];
            p->val=max(p->val,cur_val);
        }
    }
    int search(string &word){
        Trie *p=this;
        for(char ch : word){
            int cur=ch=='#'?26:ch-'a';
            if(!p->children[cur]) return -1;
            p=p->children[cur];
        }
        return p->val;
    }
};
class WordFilter{
private:
    Trie root;
public:
    explicit WordFilter(vector<string>& words){
        string cur;
        for(int i=0; i<words.size(); ++i){
            cur=words[i]+"#"+words[i];
            for(int j=0;j<=words[i].size(); ++j){
                // i is the index of that word in words[]
                root.insert(cur,j,i);
            }
        }
    }
    int f(const string& prefix, const string& suffix){
        string target=suffix+"#"+prefix;
        return root.search(target);
    }
};