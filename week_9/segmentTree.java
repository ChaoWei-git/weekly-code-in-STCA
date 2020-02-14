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
            tree[node] = tree[left] + tree[right];
        }
    }

    public static void update(int[] array,int[] tree,int node,int start,int end,int x,int val){
        if(start==end){
            array[x] = val;
            tree[node] = val;
        }else{
            int mid = start + (end - start)/2;
            int left = 2 * node + 1;
            int right = 2 * node + 2;
            if(x>=start && mid>=x){
                update(array, tree, left, start, mid, x, val);
            }else{
                update(array, tree, right, mid + 1,end, x, val);
            }
            tree[node] = tree[left] + tree[right];
        }
    }

    public static int query(int[] array,int[] tree,int node,int start,int end,int l,int r){
        if(l>end || r<start) return 0;
        else if(l<=start&& end <=r) return tree[node];
        else {
            int mid = start + (end - start)/2;
            int left = 2 * node + 1;
            int right = 2 * node + 2;
            int left_sum = query(array, tree, left, start, mid, l, r);
            int right_sum = query(array, tree, right, mid+1, end, l, r);
            return left_sum + right_sum;
        }
    }
    public static void main(String[] args) {
        
        int a[] = {1, 3, 5, 7, 9, 11};
        int[] tree = new int[1000];

        build(a, tree, 0, 0, a.length-1);

        for(int i = 0; i <= 14; i ++)
            System.out.println("tree["+ i + "]=" + tree[i]);

        update(a, tree, 0, 0, a.length-1, 4, 6);

        for(int i = 0; i <= 14; i ++)
            System.out.println("tree["+ i + "]=" + tree[i]);
        
        int ans = query(a, tree, 0, 0, a.length-1, 2, 5);
        System.out.println("ans ="+ans); 
    }
}