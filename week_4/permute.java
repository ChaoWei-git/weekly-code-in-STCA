import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);
        backtrack(result,nums_lst, 0, nums.length);
        return result;
    }

    private void backtrack(List<List<Integer>> result,List<Integer> current,int index,int max){
        if (index==max){
            result.add(new ArrayList<Integer>(current));
        }
        for (int num_index=index;num_index<current.size();num_index++){
            Collections.swap(current,num_index,index);
            backtrack(result,current,index+1,max);
            Collections.swap(current,num_index,index);
        }
    }
}