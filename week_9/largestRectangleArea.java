class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int area = 0;
        for(int i=0;i<heights.length;i++){
            while(stack.peek()!=-1 && heights[stack.peek()]>=heights[i]) 
                area = Math.max(area,heights[stack.pop()] * (i-stack.peek()-1));
            stack.push(i);
        }
        while(stack.peek()!=-1){
            area = Math.max(area,heights[stack.pop()] * (heights.length-stack.peek()-1));
        }
        return area;
    }
}