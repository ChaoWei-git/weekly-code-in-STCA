package leetcode_20;

import java.util.List;

public class Solution524 {
	public String findLongestWord(String s, List<String> d) {
        String str="";
        for(String sstr:d){
            for(int i=0,j=0;i<s.length()&&j<sstr.length();i++){
                if(s.charAt(i)==sstr.charAt(j)) j++;
                if(j==sstr.length()){
                    if(sstr.length()>str.length()||(sstr.length()==str.length()&&str.compareTo(sstr)>0))  str=sstr;
                }
            }
        }
        return str;
        
    }
}
