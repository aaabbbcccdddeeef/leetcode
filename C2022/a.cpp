#include<cstdio>
#include<iostream>
#define f(a,b,c) for(a=b;a<=c;a++)
using namespace std;
string a[17]={
"#include<cstdio>",
"#include<iostream>",
"#define f(a,b,c) for(a=b;a<=c;a++)",
"using namespace std;",
"string a[17]={",
"};",
"int i;",
"int main()",
"{",
"f(i,0,4)",
"cout<<a[i]<<endl;",
"f(i,0,15)",
"cout<<char(34)<<a[i]<<char(34)<<char(44)<<endl;",
"cout<<char(34)<<a[16]<<char(34)<<endl;",
"f(i,5,16)",
"cout<<a[i]<<endl;",
"}"
};
int i;
int main()
{
f(i,0,4)
cout<<a[i]<<endl;
f(i,0,15)
cout<<char(34)<<a[i]<<char(34)<<char(44)<<endl;
cout<<char(34)<<a[16]<<char(34)<<endl;
f(i,5,16)
cout<<a[i]<<endl;
}
