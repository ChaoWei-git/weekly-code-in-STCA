class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
            if((n&1)==1) count++;
            n = n>>>1;
        }
        return count;
    }
}

//Use while (n != 0) instead of while (n > 0) since n can be a negative number
// Put parentheses around n & 1 as ((n & 1) == 1) so that the n & 1 is evaluated first
// Use an unsigned bit shift as n = n >>> 1 to shift the digits to the right by 1.