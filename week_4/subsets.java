import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums == null || nums.length ==0){
            return result;
        }

        List<Integer> curlist = new ArrayList<>();
        backtrack(result,curlist, nums, 0);
        return result;
    }
    private void backtrack(List<List<Integer>> result,List<Integer> curlist,int[] nums,int index){
        result.add(new ArrayList<>(curlist));
        for(int i=index;i<nums.length;i++){
            curlist.add(nums[i]);
            backtrack(result,curlist,nums,i+1);
            curlist.remove(curlist.size()-1);
        }
    }
}