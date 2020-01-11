class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int m = matrix.length;
      if (m == 0) return false;
      int n = matrix[0].length;
  
      // 二分查找
      int left = 0, right = m * n - 1;
      int pivotIdx, pivotElement;
      while (left <= right) {
        pivotIdx = (left + right) / 2;
        pivotElement = matrix[pivotIdx / n][pivotIdx % n];
        if (target == pivotElement) return true;
        else {
          if (target < pivotElement) right = pivotIdx - 1;
          else left = pivotIdx + 1;
        }
      }
      return false;
    }
  }

class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
      int m = matrix.length-1;
      if (m == 0) return false;
      int n = 0;
  
      while(m>=0&&n<matrix[0].length){
        if(matrix[m][n]>target) m--;//[x,y]的值比目标值大，上移
        else if(matrix[m][n]<target)n++;//[x,y]的值比目标值小，右移
        else return true;
      }
      return false;
    }
  }
