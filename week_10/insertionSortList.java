/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode pre = h;
        ListNode cur = head;
        ListNode lat;
        
        while (cur != null) {
            lat = cur.next; // 记录下一个要插入排序的值
            
            if (lat != null && lat.val < cur.val) { // 只有 cur.next 比 cur 小才需要向前寻找插入点
                while (pre.next != null && pre.next.val < lat.val) { // 如果当前节点的值小于要插入排序的值
                    pre = pre.next; // 继续向后移动
                }
                ListNode tmp = pre.next;
                pre.next = lat;
                cur.next = lat.next;
                lat.next = tmp;
                pre = h;
            } else {
                cur = lat;
            }
        }
        
       return h.next;
    }
}