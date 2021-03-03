#include<bits/stdc++.h>
using namespace std;


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    TreeNode* removeLeafNodes(TreeNode* root, int target, TreeNode* dad=nullptr) {
        if(root->right){
            removeLeafNodes(root->right, target, root);
        }
        if(root->left){
            removeLeafNodes(root->left, target, root);
        }
        if(root->left==nullptr && root->right==nullptr && root->val==target){
            if(dad){
                if(dad->left == root){
                    dad->left = nullptr;
                }
                else{
                    dad->right = nullptr;
                }
            }
        }
        if(root->val == target && root->right==nullptr && root->left==nullptr){
            return nullptr;
        }
        return root;
    }
};