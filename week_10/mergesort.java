import java.util.Arrays;

class MergeSort{
    public static void mergerSort(int[] nums){
        for(int section_length=1;section_length<nums.length;section_length*=2){
            for(int merger_start = 0;merger_start<nums.length;merger_start+=2*section_length){
                merge_section_arr(nums,merger_start,section_length);
            }
        }
    }
    public static void merge_section_arr(int[] nums,int merger_start,int section_length){
        int mid = merger_start + section_length, end = merger_start+2*section_length>nums.length?nums.length:merger_start + 2 * section_length;
        int i=merger_start,j = mid,k = 0;
        int[] temp = new int[end-merger_start];
        while(k<temp.length){
            int n1 = i<mid?nums[i]:Integer.MAX_VALUE;
            int n2 = j<end?nums[j]:Integer.MAX_VALUE;
            temp[k++] = n1<=n2?nums[i++]:nums[j++];  
        }
        System.out.println(Arrays.toString(temp));
        for(int p=0;p<temp.length;p++) nums[merger_start+p] = temp[p];
    }
    public static void main(String[] args) {
        int[] test = new int[]{2,3,1,5,7};
        mergerSort(test);
        System.out.println("Final array:");
        System.out.println(Arrays.toString(test));
    }
}