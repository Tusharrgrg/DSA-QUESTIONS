// Given a linked list and a number k. 
//You have to reverse first part of linked list with k nodes and the second part with n-k nodes.

class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

public class reverseBothParts{
    public static Node reverse(Node head, int k) {
        // code here
        Node prev = null;
        Node curr = head;
        while(k > 0){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        Node nhead = prev;
        prev = null;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = prev;
        return nhead;
    }
}