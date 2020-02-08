class Solution {
    public void wiggleSort(int[] nums) {
        int median_number = get_median_number(nums, 0, nums.length-1);
        System.out.println(median_number);
        int less=0,current=0;
        int more = nums.length-1;
        while(current<=more){
            int new_less = change_index(less, nums.length);
            int new_curr = change_index(current, nums.length);
            int new_more = change_index(more, nums.length);
            if(nums[new_curr]>median_number){
                swap(nums, new_curr, new_less);
                current ++;
                less ++;
            }else if(nums[new_curr]<median_number){
                swap(nums, new_curr, new_more);
                more--;
            }else{
                current++;
            }
        }
    }
    private int change_index(int i,int length){
        //change index to first visit even and next is odd
        return ( 2*i + 1) %(length | 1);
    }
    private int get_median_number(int[] nums,int left,int end){
        if(left>=end) return nums[nums.length>>1];
        int less_number = partition(nums,left,end);
        if(less_number<(nums.length>>1)){
            get_median_number(nums, less_number+1, end);
        }else{
            get_median_number(nums, left, less_number-1);
        }
        return nums[nums.length>>1];
    }
    private int partition(int[] nums,int left,int right){
        //单向版本---head as pivot
        // int pivot = nums[left];
        // int less = left;
        // for(int index = left+1;index <=right;index++){
        //     if(nums[index]<pivot){
        //         swap(nums,++less,index);
        //     }
        // }
        // swap(nums,less,left);
        // return less;
        //单项版本-- end as pivot 
        int pivot = nums[right];
        int less = left - 1;
        for(int index=left;index<right;index++){
            if(nums[index]<pivot){
                swap(nums, ++less, index);
            }
        }
        swap(nums, less+1, right);
        return less+1;
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
} 