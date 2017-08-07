// A Java program to reverse 2nd half linked list
// kth node from the end

import java.util.*;
 
class LinkedList1
{
    

    /* Utility function for displaying linked list */
    void printList(LinkedList<Integer> list)
    {
        ListIterator ltr = list.listIterator();
        while (ltr.hasNext())
        {
            //  moving cursor to next element
            int i = (Integer)ltr.next();
 
            // getting even elements one by one
            System.out.print(i + " ");
        }    
        System.out.println("");
    }
    
    
    LinkedList<Integer> reverse(LinkedList<Integer> list){
        
        int size = list.size();
        int count = 0;
        List<Integer> reversed = new LinkedList<Integer>();
        
        ListIterator ltr = list.listIterator();
        
        while (ltr.hasNext()){
  
         int i = (Integer)ltr.next();  

           if(count < size/2){
               count++;
           }  
           else if(count < size ) 
                {
                   reversed.add(i);
                   ltr.remove();
                   count++;
                }           
        }
        
        Collections.reverse(reversed);
        list.addAll(size/2,reversed);
        return list;
    }
    
 
    
    // Driver code to test above
    public static void main(String[] args)
    {
        LinkedList1 ll = new LinkedList1();
        
        LinkedList<Integer> llist = new LinkedList<Integer>();
        for (int i = 1; i <= 9; i++)
            llist.add(i);
         
        ll.printList(llist); 
        llist = ll.reverse(llist);
        ll.printList(llist);
        
    }
}
//Run on IDE


    
    