class Solution {
    public String largestNumber(int[] nums) {
        if(nums.length==0|| nums==null) return "0";
        String[] str = new String[nums.length];
        for(int index=0;index<nums.length;index++){
            str[index] = nums[index] + "";
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String i, String j) {
                String s1 = i+j;
                String s2 = j+i;
                return s1.compareTo(s2);
            }
        });
        if(str[str.length-1].equals("0")) return "0";
        String res = new String();
        for (int i = 0; i < str.length; i++) {
            res = str[i]+res;
        }
        return res;
    }
}