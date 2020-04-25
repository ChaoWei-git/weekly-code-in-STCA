package leetcode_20;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution767 {
	public String reorganizeString(String S) {
		int[] char2count = new int[26];
		for(int i=0;i<S.length();i++) char2count[S.charAt(i)-'a']+=1;
		PriorityQueue<int[]> pQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			public int compare(int[] a,int [] b) {
				return b[1]-a[1];
			}
		});
		for(int i=0;i<char2count.length;i++) {
			if(char2count[i]>0) pQueue.add(new int[] {i,char2count[i]});
		}
		char[] result = new char[S.length()];
		int max_value = pQueue.peek()[1];
		if(S.length()%2==0&&max_value>S.length()/2)return "";
		if(S.length()%2!=0&&max_value>S.length()/2+1)return "";
		int index = 0;
		while(!pQueue.isEmpty()) {
			int[] temp = pQueue.poll();
			while(temp[1]>0) {
                index = index>=S.length()? 1:index;
				temp[1]--;
				result[index] = (char)('a' + temp[0]);
				index +=2;
				
			}
			
		}
		return String.valueOf(result);
    }
}
