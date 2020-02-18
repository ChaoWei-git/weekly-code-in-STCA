//log n
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left=0,right = nums.length-1;
        while(left<right){
            int mid = left + (right-left)/2;
            boolean is_Even = (right-mid)%2==0;
            if(nums[mid]==nums[mid+1]){
                if(is_Even){
                    left = mid +2;
                }else{
                    right = mid -1;
                }
            }else if(nums[mid]==nums[mid-1]){
                if(is_Even){
                    right = mid -2;
                }else{
                    left = mid +1;
                }
            }else{
                return nums[mid];
            }
        }
        return nums[left];
    }
}

//n
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int sum = nums[0];
        for(int i=1;i<nums.length; i++){
            sum = sum^nums[i];
        }
        return sum;
    }
}