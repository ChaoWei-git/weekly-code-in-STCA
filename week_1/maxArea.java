class Solution {
    public int maxArea(int[] height) {
        int left = 0,right = height.length -1;
        int min_height_indx = height[left]>height[right]? right:left;
        int vol,max_vol = height[min_height_indx] * (right - left);
        while(left < right ){
            if (height[left]< height[right]) 
                left ++;
            else 
                right --;
            vol = Math.min(height[left],height[right]) * (right - left);
            if (vol >max_vol){
                max_vol = vol;
            }
        }
        return max_vol;
    }
}