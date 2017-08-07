// A Java program to swap kth node from the beginning with
// kth node from the end
 
class Node
{
    int data;
    Node next;
    Node(int d) { data = d;  next = null; }
}
 
class LinkedList
{
    Node head;
 
    /* Utility function to insert a node at the beginning */
    void push(int new_data)
    {
        Node new_node = new Node(new_data);
        
        if(head == null){ 
             head = new Node(new_data);
             return;
        }     
        
        Node curr = head;
        while(curr.next!=null){
             curr = curr.next;
        }
          
         curr.next = new_node; 
         return;
    }
 
    /* Utility function for displaying linked list */
    void printList()
    {
        Node node = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }
 
    /* Utility function for calculating length of linked list */
    int countNodes()
    {
        int count = 0;
        Node s = head;
        while (s != null)
        {
            count++;
            s = s.next;
        }
        return count;
    }
 
  
  	Node reverse(Node head, int k)
    {
       Node current = head;
       Node next = null;
       Node prev = null;
        
       int count = 0;
 
       /* Reverse first k nodes of linked list */
       while (count < k && current != null) 
       {
           next = current.next;
           current.next = prev;
           prev = current;
           current = next;
           count++;
       }
 
       /* next is now a pointer to (k+1)th node 
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
       if (next != null) 
          head.next = reverse(next, k);
 
       // prev is now head of input list
       return prev;
    } 
 
    // Driver code to test above
    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();
        for (int i = 1; i <= 8; i++)
            llist.push(i);
 
        System.out.print("Original linked list: ");
        llist.printList();
        System.out.println("");
        llist.head = llist.reverse(llist.head, 3);
        llist.printList();
        
    }
}
//Run on IDE


    
    