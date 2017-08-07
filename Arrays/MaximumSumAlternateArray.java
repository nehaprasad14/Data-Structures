Algorithm:
Loop for all elements in arr[] and maintain two sums incl and excl where 
	incl = Max sum including the previous element and 
	excl = Max sum excluding the previous element.

Max sum excluding the current element will be max(incl, excl) and max sum including the current element will be excl + current element (Note that only excl is considered because elements cannot be adjacent).

At the end of the loop return max of incl and excl.

*****************************************************************************************************
// {5, 3, 10, 100}
// incl:5     excl:0   excl_new:
// incl:3     excl:5   excl_new:5
// incl:15    excl:5   excl_new:5
// incl:105   excl:15   excl_new:15

	
class MaximumSum
{
    /*Function to return max sum such that no two elements
      are adjacent */
    int FindMaxSum(int arr[], int n)
    {
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;
 
        for (i = 1; i < n; i++)
        {
            /* current max excluding i */
            excl_new = (incl > excl) ? incl : excl;
 
            /* current max including i */
            incl = excl + arr[i];
            excl = excl_new;
        }
 
        /* return max of incl and excl */
        return ((incl > excl) ? incl : excl);
    }
 
    // Driver program to test above functions
    public static void main(String[] args)
    {
        MaximumSum sum = new MaximumSum();
        int arr[] = new int[]{5, 5, 10, 100, 10, 5};   //output : 110
        System.out.println(sum.FindMaxSum(arr, arr.length));
    }
}
 