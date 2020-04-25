package leetcode_20;

import java.util.ArrayList;
import java.util.List;

public class Solution969 {
	public List<Integer> pancakeSort(int[] A) {
		List<Integer> resultIntegers = new ArrayList<Integer>();
		int length = A.length;
		while(length>=1) {
			int max = this.getMaxIndex(A, length-1);
			resultIntegers.add(max+1);
			reverse(A, 0, max);
			resultIntegers.add(length);
			reverse(A, 0, length-1);
			length--;
			
		}
		return resultIntegers;
    }
	private void reverse(int[] array,int i,int j) {
		while(i<j) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;
		}
	}
	private int getMaxIndex(int[] array,int length) {
		int maxValue = array[0];
		int maxIndex = 0;
		for(int i=1;i<=length;i++) {
			if(maxValue<array[i]) {
				maxIndex = i;
				maxValue = array[i];
			}
		}
		return maxIndex;
	}
}
