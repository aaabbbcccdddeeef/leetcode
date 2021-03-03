#include<bits/stdc++.h>
using namespace std;

int main(){
    set<pair<int,int>> my_set;
    my_set.insert(make_pair(4,5));
    my_set.insert(make_pair(4,6));
    my_set.insert(make_pair(5,7));
    my_set.insert(make_pair(1,4));
    auto t = my_set.lower_bound(make_pair(4,-1));
    cout<<(*t).first<<endl;
    cout<<(*t).second<<endl;
    cout<<(t == my_set.end())<<endl;
}