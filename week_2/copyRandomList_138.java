import java.util.HashMap;
import java.util.Map;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    /*//backtracing
    //save old nodes as key and new copied node as value , 
    private Map<Node,Node> visitedHashMap = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        // If we have already create new node, then we simply return the cloned version of it
        if(this.visitedHashMap.containsKey(head)) return visitedHashMap.get(head);
        Node node = new Node(head.val,null,null);
        this.visitedHashMap.put(head,node);
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);
        return node;
    }*/
    /*//iterate
    //save old nodes as key and new copied node as value , 
    private Map<Node,Node> visitedHashMap = new HashMap<>();
    private Node getCloneNode(Node node){
        if(node==null) return null;
        if(this.visitedHashMap.containsKey(node)) return this.visitedHashMap.get(node);
        else{
            Node temp = new Node(node.val,null,null);
            this.visitedHashMap.put(node,temp);
            return temp;
        }
    }
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node newNode = new Node(head.val,null,null);
        Node oldNode = head;
        this.visitedHashMap.put(oldNode,newNode);
        while(oldNode != null){
            newNode.random = this.getCloneNode(oldNode.random);
            newNode.next = this.getCloneNode(oldNode.next);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return this.visitedHashMap.get(head);
    }*/
    public Node copyRandomList(Node head) {
  
        if (head == null) {
          return null;
        }
    
        // Creating a new weaved list of original and copied nodes.
        Node ptr = head;
        while (ptr != null) {
    
          // Cloned node
          Node newNode = new Node(ptr.val);
    
          // Inserting the cloned node just next to the original node.
          // If A->B->C is the original linked list,
          // Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
          newNode.next = ptr.next;
          ptr.next = newNode;
          ptr = newNode.next;
        }
    
        ptr = head;
    
        // Now link the random pointers of the new nodes created.
        // Iterate the newly created list and use the original nodes' random pointers,
        // to assign references to random pointers for cloned nodes.
        while (ptr != null) {
          ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
          ptr = ptr.next.next;
        }
    
        // Unweave the linked list to get back the original linked list and the cloned list.
        // i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
        Node ptr_old_list = head; // A->B->C
        Node ptr_new_list = head.next; // A'->B'->C'
        Node head_old = head.next;
        while (ptr_old_list != null) {
          ptr_old_list.next = ptr_old_list.next.next;
          ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
          ptr_old_list = ptr_old_list.next;
          ptr_new_list = ptr_new_list.next;
        }
        return head_old;
      }
}
