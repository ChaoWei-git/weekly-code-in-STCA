import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

示例:
输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]
*/

class Solution {
    LinkedList<String> segments = new LinkedList<>();
    List<String> result = new ArrayList<>();
    String s;
    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        backtrack(-1, 3);
        return result;
    }

    private void updateOutput(int index){
        String segment = this.s.substring(index+1, s.length());
        if(this.isValid(segment)){
            this.segments.add(segment);
            result.add(String.join(".", segments));
            this.segments.removeLast();
        }

    }

    private void backtrack(int previous_pos,int dot_num){
        int max_pos = Math.min(s.length()-1, previous_pos + 4);
        for(int i=previous_pos+1;i<max_pos;i++){
            String segment = s.substring(previous_pos+1, i+1);
            if(this.isValid(segment)){
                segments.add(segment);
                if(dot_num>1){
                    backtrack(i, dot_num-1);
                }else{
                    this.updateOutput(i);
                }
                segments.removeLast();
            }
        }
    }
    private boolean isValid(String segment){
        if(segment.length()>3) return false;
        return segment.charAt(0)!='0'? Integer.valueOf(segment)<=255:segment.length()==1;
    }
}