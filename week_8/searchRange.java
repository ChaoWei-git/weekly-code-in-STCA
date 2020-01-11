
/*
闭区间模式，此时只需要返回left和right边界，此时就是边界。
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] result = new int[2]; 
        int left=0,right=nums.length-1,mid;
        while(left<=right){
            mid = left + (right-left)/2;
            if(nums[mid]>target){
                right = mid - 1;
            }else if(nums[mid]<target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        result[0] = left <= nums.length-1 &&nums[left]==target ? left:-1;
        left=0;
        right=nums.length-1;
        while(left<=right){
            mid = left + (right-left)/2;
            if(nums[mid]>target){
                right = mid -1;
            }else if(nums[mid]<target){
                left = mid + 1;
            }else{
                left = mid + 1;
            }
        }
        result[1] = right >= 0 && nums[right]==target? right:-1;
        return result;
    }
}

/*
左闭右开区间模式，此时闭区间边界直接返回left，而开区间边界则该返回right-1
*/

class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int [] result = new int[2]; 
        int left=0,right=nums.length,mid;
        while(left<right){
            mid = left + (right-left)/2;
            if(nums[mid]>target){
                right = mid;
            }else if(nums[mid]<target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        result[0] = left <= nums.length-1 && nums[left]==target ? left:-1;

        left=0;
        right=nums.length;
        while(left<right){
            mid = left + (right-left)/2;
            if(nums[mid]>target){
                right = mid;
            }else if(nums[mid]<target){
                left = mid + 1;
            }else{
                left = mid + 1;
            }
        }
        result[1] = right > 0 && nums[right-1]==target? right-1:-1;
        return result;
    }
}