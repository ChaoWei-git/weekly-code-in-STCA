//使用左右两侧对二分查找进行约束，其余则保持原样

class Solution {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1,mid;
        while(left<=right){
            mid = left + (right-left)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>nums[left]){
                //左侧有序
                if(nums[mid]>target && nums[left]<=target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                //右侧有序
                if(nums[mid]<target && nums[right]>=target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}