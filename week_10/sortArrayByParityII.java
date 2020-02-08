class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int odd=1;
        for(int even=0;even<A.length;even+=2){
            if(A[even]%2==1){
                while(A[odd]%2==1) odd +=2;
                int temp = A[odd];
                A[odd] = A[even];
                A[even] = temp;
            }
        }
        return A; 
    }
}