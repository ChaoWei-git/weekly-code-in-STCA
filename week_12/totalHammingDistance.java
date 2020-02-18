class Solution {
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max) max = nums[i];
        }
        while(max!=0){
            int total = 0;
            for(int i=0;i<nums.length;i++){
                total +=(nums[i] & 1) ;
                nums[i] >>=1;
            }
            max>>=1;
            result += (total==0||total==nums.length)? 0:total * (nums.length - total);  
        }
        return result;
    }
}