//同步
// class MinStack {

//     private Stack<Integer> stack;
//     private Stack<Integer> helper;
//     /** initialize your data structure here. */
//     public MinStack() {
//         stack = new Stack<>();
//         helper = new Stack<>();
//     }
    
//     public void push(int x) {
//         stack.push(x);
//         if(helper.isEmpty()) helper.push(x);
//         else{
//             if(helper.peek()>=x) helper.push(x);
//             else helper.push(helper.peek());
//         }
//     }
    
//     public void pop() {
//         if(stack.isEmpty()) return;
//         stack.pop();
//         helper.pop();
//     }
    
//     public int top() {
//         if(stack.isEmpty()) return Integer.MIN_VALUE;;
//         return stack.peek();
//     }
    
//     public int getMin() {
//         if(stack.isEmpty()) return Integer.MIN_VALUE;
//         return helper.peek();
//     }
// }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//异步
class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> helper;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        helper = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(helper.isEmpty()) helper.push(x);
        else{
            int min_number = helper.peek();
            if(x<=min_number){
                helper.push(x);
            }
        }
        
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        int temp = stack.pop();
        if(helper.peek()==temp) helper.pop();
    }
    
    public int top() {
        if(stack.isEmpty()) return -1;
        return stack.peek();
    }
    
    public int getMin() {
        if(stack.isEmpty()) return -1;
        return helper.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class MinStack {

    private Stack<Integer> stack;
    private int min_number = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if(x<=min_number) {
            stack.push(min_number);
            min_number = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if(stack.pop()==min_number) min_number = stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_number;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


class MinStack {

    private Stack<Long> stack;
    private long min_number;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
       if(stack.isEmpty()){
           stack.push(0L);
           min_number = x;
       }else{
           long delta = x - min_number;
           stack.push(delta);
           if(delta<0) min_number = x;
       }
    }
    
    public void pop() {
        long delta = stack.pop();
        if(delta<0) min_number = min_number - delta;
    }
    
    public int top() {
        long delta = stack.peek();
        if(delta<0) return (int)min_number;
        else return (int) (min_number + delta) ;
    }
    
    public int getMin() {
        return (int)min_number;
    }
}