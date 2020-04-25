package leetcode_20;

public class Solution327 {
	//实际上通过依次求和的问题化简为Here, after we did the preprocess, we need to solve the problem
	//count[i] = count of a <= S[j] - S[i] <= b with j > i
	//ans = sum(count[:])
	
	public int countRangeSum(int[] nums, int lower, int upper) {
    	long[] ans = new long[nums.length+1];
    	int count = 0;
    	for(int i=0;i<nums.length;i++) {
    		ans[i+1] = ans[i] + nums[i];
    	}
//    	for(int i=0;i<nums.length;i++) {
//    		for(int j=i+1;j<=nums.length;j++) {
//    			int temp = ans[j] - ans[i];
//    			if(temp>=lower&&temp<=upper) count++;
//    		}
//    	}
//    	return count;
    	return merge(ans,0,nums.length+1,lower,upper);
    }
    private int merge(long[] sums,int start,int end,int lower,int upper) {
    	if(end-start<=1) return 0;
    	int mid = start + (end-start)/2;
    	int count = merge(sums, start, mid, lower, upper) + merge(sums, mid, end, lower, upper);
    	//merge
    	int k=mid,m = mid,t=mid;
    	long[] cache = new long[end - start];
    	for(int i=start,r = 0;i<mid;i++,r++) {
    		while(k<end&&sums[k] - sums[i]<lower) k++;
    		while(m<end&&sums[m] - sums[i]<=upper) m++;
    		while(t<end&&sums[t]<=sums[i]) cache[r++] = sums[t++];
    		cache[r] = sums[i];
    		count += m-k;
    	}
    	System.arraycopy(cache, 0, sums, start, t - start);
    	return count;
    	
    }
}
