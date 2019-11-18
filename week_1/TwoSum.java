import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{0,0};
        Map<Integer,Integer> map = new HashMap<>();
        for(int index=0;index<nums.length;index++){
            int temp = target-nums[index];
            if(map.containsKey(temp)){
                result[0] = index;
                result[1] = map.get(temp);
            }else{
                map.put(nums[index], index);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] test = new int []{2,7,11,15};
        System.out.println(TwoSum.twoSum(test,9));
    }
}