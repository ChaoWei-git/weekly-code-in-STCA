class Solution {
    public int minPathSum(int[][] grid) {
        int arrLen = grid.length;
        if(arrLen==0){
            return 0;
        }
        int numLen = grid[0].length;
        /*int [][] minpathsum=new int[arrLen+1][numLen+1];
        for(int i=0;i<=arrLen;i++){
            minpathsum[i][0]=Integer.MAX_VALUE;
        }
        for(int j =0;j<=numLen;j++){
            minpathsum[0][j] = Integer.MAX_VALUE;
        }
        minpathsum[0][1] = 0;
        for(int i=1;i<=arrLen;i++){
            for(int j=1;j<=numLen;j++){
                minpathsum[i][j]=Math.min(minpathsum[i-1][j],minpathsum[i][j-1]) + grid[i-1][j-1];
            }
        }
        return minpathsum[arrLen][numLen];*/
        int [] minpath = new int[numLen+1];
        for(int i=0;i<=numLen;i++){
            minpath[i]=Integer.MAX_VALUE;
        }
        minpath[1]=0;
        for(int i =0;i<arrLen;i++){
            for(int j =1;j<=numLen;j++){
                minpath[j]=Math.min(minpath[j],minpath[j-1])+grid[i][j-1];
            }
        }
        return minpath[numLen];
    }
}