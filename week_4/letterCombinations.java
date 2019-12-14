import java.util.ArrayList;
import java.util.List;

class letterCombinations {
    private	char [][] dict = {{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{ 'j', 'k', 'l' }, { 'm', 'n', 'o' },{ 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' }};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length()<=0) return result;
        iterDigits(result,0,digits,"");
        return result;
        
    }
    private void iterDigits(List<String> result,int digits_index,String digits,String curstr){
        if(digits_index == digits.length()){
            result.add(curstr);
            return;
        }
        for (char temp:dict[digits.charAt(digits_index)-'1']){
            iterDigits(result,digits_index+1,digits,curstr+temp)
        }
    }
}