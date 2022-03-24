//
// Created by 刘志成 on 2022/2/16.
//
#include <bits/stdc++.h>
struct TrieNode{
    TrieNode* children[26];
    bool isWord;
    TrieNode():isWord(false){
        memset(children,0,sizeof(children));
    }
};
class Trie{
    TrieNode *root;
public:
    Trie(){
        root=new TrieNode;
    }
    ~Trie(){
        delete(root);
    }
    void insert(string word){
        TrieNode *node=root;
        for(char ch:word){
            if(node->children[ch-'a']== nullptr){
                node->children[ch-'a']=new TrieNode();
            }
            node=node->children[ch-'a'];
        }
        node->isWord=true;
    }
    bool search(string word){
        TrieNode *node=root;
        for(char ch:word){
            if(node->children[ch-'a']== nullptr){
                return false;
            }
            node=node->children[ch-'a'];
        }
        return node->isWord;
    }
    bool startsWith(string prefix){
        TrieNode *node=root;
        for(char ch:prefix){
            if(node->children[ch-'a']== nullptr){
                return false;
            }
            node=node->children[ch-'a'];
        }
        return true;
    }
};
int main(){
    Trie t;
    t.insert("apple");
    t.search("apple");
    t.insert("app");
    cout<<t.search("app")<<endl;
    return 0;
}

