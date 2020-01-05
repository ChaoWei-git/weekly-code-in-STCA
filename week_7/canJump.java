class Solution {
    public boolean canJump(int[] nums) {
        int lastJumpPos = nums.length - 1;
        for(int i = nums.length-1;i>=0;i--){
            if(nums[i] + i >= lastJumpPos){
                lastJumpPos = i;
            }
        }
        return lastJumpPos==0;
    }
}