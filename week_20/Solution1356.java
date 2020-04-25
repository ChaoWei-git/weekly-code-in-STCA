package leetcode_20;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1356 {
	public int[] sortByBits(int[] arr) {
        Integer[] sortArr = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++) {
            sortArr[i] = arr[i];
        }
        Arrays.sort(sortArr, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int binaryCountA = 0, binaryCountB = 0;
                int originA = a, originB = b;
                while(a != 0) {
                    a &= (a-1);
                    binaryCountA++;
                }
                while(b != 0) {
                    b &= (b-1);
                    binaryCountB++;
                }
                
                return (binaryCountA == binaryCountB) ? originA - originB :  binaryCountA - binaryCountB;
            }
        });
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sortArr[i];
        }
        return arr;
    }
}
