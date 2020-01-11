/*
这实际是一个边界问题，考虑使用区间的思想，在初始化left，right时候使用左闭右开或者左闭右闭，迭代过程中也应该使用左闭右开或者左闭右闭，注意，使用开区间时候应该使用<
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0, right=nums.length;
        int mid;
        while(left<right){
            mid = left + (right-left)/2;
            if(nums[mid]>=target){
                right = mid;
            }else if(nums[mid]<target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return right;
    }
}