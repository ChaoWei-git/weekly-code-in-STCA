package leetcode_20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Solution710 {
	private Map<Integer, Integer> black2White;
	private Random random;
	private int n;
	public Solution710(int N, int[] blacklist) {
        black2White = new HashMap<>();
		random = new Random();
		this.n = N - blacklist.length;
		Set<Integer> white = new HashSet<Integer>();
		for(int i=n;i<N;i++) white.add(i);
		for(int temp:blacklist) white.remove(temp);
        Iterator<Integer> iterator = white.iterator();
		for(int b:blacklist) {
			if(b<n) black2White.put(b,iterator.next());
		}
		
    }
    
    public int pick() {
    	int current = random.nextInt(this.n);
    	return black2White.getOrDefault(current, current);
    }
}
