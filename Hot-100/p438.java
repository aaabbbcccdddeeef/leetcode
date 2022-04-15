import java.util.*;

public class p438 {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen=s.length(),pLen=p.length();
        if(sLen<pLen){
            return new ArrayList<Integer>();
        }
        int[] count=new int[26];
        for(int i=0;i<pLen;i++){
            ++count[s.charAt(i)-'a'];
            --count[p.charAt(i)-'a'];
        }
        int need=0;
        for(int i=0;i<26;i++){
            need+=count[i]==0?0:1;
        }
        List<Integer> ans=new ArrayList<Integer>();
        if(need==0){
            ans.add(0);
        }
        for(int i=1;i+pLen<=sLen;i++){
            count[s.charAt(i-1)-'a']--;
            if(count[s.charAt(i-1)-'a']==0){
                need--;
            }else if(count[s.charAt(i-1)-'a']==-1){
                need++;
            }
            count[s.charAt(i+pLen-1)-'a']++;
            if(count[s.charAt(i+pLen-1)-'a']==0){
                need--;
            }else if(count[s.charAt(i+pLen-1)-'a']==1){
                need++;
            }
            if(need==0){
                ans.add(i);
            }
        }
        return ans;
    }
}
