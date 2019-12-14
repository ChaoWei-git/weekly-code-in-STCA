import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n<=0) return result;
        backtracing(result,0,0,n,"");
        return result;

    }
    private void backtracing(List<String> result,int left,int right,int max,String curstr){
        if(curstr.length()==max*2){
            result.add(curstr);
            return;
        }
        if(left<max) backtracing(result,left+1,right,max,curstr+'(');
        if(right<left) backtracing(result,left,right+1,max,curstr+')');
    }
}