import java.util.HashMap;
import java.util.Map;

// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         int[] result = new int[nums1.length];
//         Map<Integer,Integer> map = new HashMap<>();
//         for(int index=0;index<nums2.length;index++){
//             map.put(nums2[index], index);
//         }
//         for(int index=0;index<nums1.length;index++){
//             int nums2_index = map.get(nums1[index]);
//             while(nums2[nums2_index]<nums1[index]) nums2_index++;
//             if(nums2_index>=nums2.length) result[index] = -1;
//             else result[index] = nums2[nums2_index];
//         }
//         return result;
//     }
// }

//单调栈
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int index=0;index<nums2.length;index++){
            while(!stack.isEmpty()&&stack.peek()<nums2[index]){
                map.put(stack.pop(), nums2[index]);
            }
            stack.push(nums2[index]);
        }
        while(!stack.isEmpty())map.put(stack.pop(), -1);
        for(int index=0;index<nums1.length;index++){
            result[index] = map.get(nums1[index]);
        }
        return result;
    }
}

