//
// Created by 刘志成 on 2022/2/8.
//
#include <bits/stdc++.h>
class Solution {
public:
    bool isMatch(string s, string p) {
        int str=0,mtc=0;
        int sLen=(int)s.length(), pLen=(int)p.length();
        while (str<sLen && mtc<pLen){
            if(pLen-mtc==1){
                if(p[mtc]!='.' && s[str]!=p[mtc]){
                    return false;
                }
                mtc++;str++;
            }else{
                if(p[mtc+1]=='*'){
                    if(p[mtc]=='.'){
                        if(mtc+1==pLen-1){
                            return true;
                        }
                        for(int i=0;i<=sLen-str;i++){
                            if(isMatch(s.substr(i+str), p.substr(mtc+2))){
                                return true;
                            }
                        }
                    }else{
                        int num=0;
                        while(s[str+num]==p[mtc]){
                            num++;
                        }
                        for(int i=0;i<=num;i++){
                            if(isMatch(s.substr(i+str),p.substr(mtc+2))){
                                return true;
                            }
                        }
                    }
                    return false;
                }else{
                    if(p[mtc]!='.' && s[str]!=p[mtc]){
                        return false;
                    }
                    mtc++;str++;
                }
            }
        }
        for(int i=1;i<pLen-mtc;){
            if(p[i+mtc]=='*'){
                mtc+=2;
            }else{
                break;
            }
        }
        if(str!=sLen || mtc!=pLen){
            return false;
        } else{
            return true;
        }
    }
};
class Solution_ {
public:
    bool isMatch(string s, string p) {
        return isMatch(s.c_str(), p.c_str());
    }

    bool isMatch(const char* s, const char* p) {
        if(*p == 0) return *s == 0;

        auto first_match = *s && (*s == *p || *p == '.');

        if(*(p+1) == '*'){
            return isMatch(s, p+2) || (first_match && isMatch(++s, p));
        }
        else{
            return first_match && isMatch(++s, ++p);
        }
    }
};
int main(){
    cout<<Solution_().isMatch("c",".*b*b*")<<endl;
    return 0;
}