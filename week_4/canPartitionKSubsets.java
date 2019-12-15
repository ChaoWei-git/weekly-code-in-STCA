import java.util.Arrays;

/*
给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。

示例 1：
输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
输出： True
说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和
*/

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if(sum%k!=0) return false;
        int target = sum/k;
        Arrays.sort(nums);
        int end = nums.length -1;
        if(nums[end]>target) return false;
        while(end>=0&&nums[end]==target){
            end--;
            k--;
        }
        return this.search(new int[k], nums, target, end);


    }
    private boolean search(int[] group,int[] nums,int target,int end){
        if(end<0) return true;
        int group_num = group.length;
        int temp = nums[end--];
        for(int i=0;i<group_num;i++){
            if(group[i]+temp<=target){
                group[i]+=temp;
                if(search(group,nums,target,end)) return true;
                group[i]-=temp;
            }
            if (group[i] == 0) break;
        }
        return false;
    }
}