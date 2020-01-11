class Solution {
    public int search(int[] nums, int target) {
        int start=0,end = nums.length-1;
        int mid = start + (end-start)/2;
        while(start<=end){
            if(target==nums[mid]){
                return mid;
            }else if(target>nums[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}