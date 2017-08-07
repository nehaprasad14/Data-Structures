Java Solution 3 - Heap

We can use a min heap to solve this problem. The heap stores the top k elements. Whenever the size is greater than k, delete the min. 
Time complexity is O(nlog(k)). Space complexity is O(k) for storing the top k numbers.

public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
    for(int i: nums){
        q.offer(i);
 
        if(q.size()>k){
            q.poll();
        }
    }
 
    return q.peek();
}

**************************************************************************************************************************************************************
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example, given [3,2,1,5,6,4] and k = 2, return 5.

Note: You may assume k is always valid, 1 ≤ k ≤ array's length.

Java Solution 1 - Sorting

public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length-k];
}
Time is O(nlog(n)).



kth_largest_element_in_an_unsorted_array