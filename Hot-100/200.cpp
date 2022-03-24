//
// Created by 刘志成 on 2022/2/2.
//
// finally, it doesn't AC, failed at last testcase.
// I don't know why. And I'm not going to figure it out.
#include<bits/stdc++.h>

#define LAND '1'

class Solution {
public:
    int numIslands(vector <vector<char>> &grid) {
        int m = (int) grid.size(), n = (int) grid[0].size();
        vector <vector<int>> island(m, vector<int>(n, 0));
        vector<int> type{0};
        unordered_set<int> set;
        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == LAND) {
                    if (!j && !i) {
                        //0,0 is island
                        island[i][j] = ++num;
                        type.push_back(num);
                        set.insert(num);
                    } else {
                        int t = mn;
                        if (j > 0 && grid[i][j - 1] == LAND) {
                            t = min(t, type[island[i][j - 1]]);
                        }
                        if (i > 0 && grid[i - 1][j] == LAND) {
                            t = min(t, type[island[i - 1][j]]);
                        }
                        if (t != mn) {
                            island[i][j] = t;
                        } else {
                            island[i][j] = ++num;
                            type.push_back(num);
                            set.insert(num);
                        }
                        int tp = type[island[i][j]];
                        if (i > 0 && island[i - 1][j]) {
                            if (type[island[i - 1][j]] != tp && set.count(type[island[i - 1][j]])) {
                                set.erase(type[island[i - 1][j]]);
                            }
                            type[island[i - 1][j]] = type[island[i][j]];
                        }
                        if (i < m - 1 && island[i + 1][j]) {
                            if (type[island[i + 1][j]] != tp && set.count(type[island[i + 1][j]])) {
                                set.erase(type[island[i + 1][j]]);
                            }
                            type[island[i + 1][j]] = type[island[i][j]];
                        }
                        if (j > 0 && island[i][j - 1]) {
                            if (type[island[i][j - 1]] != tp && set.count(type[island[i][j - 1]])) {
                                set.erase(type[island[i][j - 1]]);
                            }
                            type[island[i][j - 1]] = type[island[i][j]];
                        }
                        if (j < n - 1 && island[i][j + 1]) {
                            if (type[island[i][j + 1]] != tp && set.count(type[island[i][j + 1]])) {
                                set.erase(type[island[i][j + 1]]);
                            }
                            type[island[i][j + 1]] = type[island[i][j]];
                        }
                    }
                }
            }
        }
        return (int) set.size();
    }
};

int main() {
    vector <vector<char>> grid = {{'1', '1', '0', '0', '0'},
                                  {'1', '1', '0', '0', '0'},
                                  {'0', '0', '1', '0', '0'},
                                  {'0', '0', '0', '1', '1'}};
    cout << Solution().numIslands(grid) << endl;
}
