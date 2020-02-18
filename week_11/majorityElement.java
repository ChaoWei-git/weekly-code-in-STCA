class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for(int item:nums){
            if(count==0) candidate = item;
            if(candidate==item) count++;
            else count--; 
        }
        return candidate;
    }
}