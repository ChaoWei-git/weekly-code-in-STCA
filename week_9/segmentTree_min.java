class Solution {
    
    public static void build(int[] array,int[] tree,int node,int start,int end){
        if(start==end){
            tree[node] = array[start];
        }else{
            int mid = start + (end - start)/2;
            int left = 2 * node + 1;
            int right = 2 * node + 2;
            build(array, tree, left, start, mid);
            build(array, tree, right, mid + 1, end);
            tree[node] = Math.min(tree[left],tree[right]);
        }
    }


    public static int query(int[] array,int[] tree,int node,int start,int end,int l,int r){
        if(l>end || r<start) return Integer.MAX_VALUE;
        else if(l<=start&& end <=r) return tree[node];
        else {
            int mid = start + (end - start)/2;
            int left = 2 * node + 1;
            int right = 2 * node + 2;
            int left_min = query(array, tree, left, start, mid, l, r);
            int right_min = query(array, tree, right, mid+1, end, l, r);
            return Math.min(left_min,right_min);
        }
    }
    public static void main(String[] args) {
        
        int a[] = {1, 3, 2, 7, 9, 11}; 
        int x  = (int) Math.ceil(Math.log(a.length)/Math.log(2));
        int max_size = 2 * (int)Math.pow(2,x) - 1;
        int[] tree = new int[max_size];

        build(a, tree, 0, 0, a.length-1);

        for(int i = 0; i < tree.length; i ++)
            System.out.println("tree["+ i + "]=" + tree[i]);
        
        int ans = query(a, tree, 0, 0, a.length-1, 2, 5);
        System.out.println("ans ="+ans); 
    }
}