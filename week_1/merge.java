
class Solution {
    public int[][] merge(int[][] intervals) {
        int numOfInterval=intervals.length;
        List<int[]> result = new ArrayList<>();
        if(numOfInterval<=1) return intervals;
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for(int[] interval:intervals){
        	if(interval[0]<=newInterval[1]){
        		newInterval[1] = Math.max(interval[1],newInterval[1]);
        	}else{
        		newInterval = interval;
        		result.add(newInterval);
        	}
        }
        return result.toArray(new int[result.size()][]);
    }
}