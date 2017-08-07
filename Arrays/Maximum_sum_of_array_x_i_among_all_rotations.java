/*The idea is to compute value of a rotation using value of previous rotation.
	When we rotate an array by one, following changes happen in sum of i*arr[i].
1) Multiplier of arr[i-1] changes from 0 to n-1, i.e., arr[i-1] * (n-1) is added to current value.
2) Multipliers of other terms is decremented by 1. i.e., (cum_sum – arr[i-1]) is subtracted from current value where cum_sum is sum of all numbers.
next_val = curr_val - (cum_sum - arr[i-1]) + arr[i-1] * (n-1);

next_val = Value of ∑i*arr[i] after one rotation.
curr_val = Current value of ∑i*arr[i] 
cum_sum = Sum of all array elements, i.e., ∑arr[i].

Lets take example {1, 2, 3}. Current value is 1*0+2*1+3*2
= 8. Shifting it by one will make it {2, 3, 1} and next value
will be 8 - (6 - 1) + 1*2 = 5 which is same as 2*0 + 3*1 + 1*2
*/

int maxSum(int arr[], int n)
{
    // Compute sum of all array elements
    int cum_sum = 0;
    for (int i=0; i<n; i++)
        cum_sum += arr[i];
 
    // Compute sum of i*arr[i] for initial
    // configuration.
    int curr_val = 0;
    for (int i=0; i<n; i++)
        curr_val += i*arr[i];
 
    // Initialize result
    int res = curr_val;
 
    // Compute values for other iterations
    for (int i=1; i<n; i++)
    {
        // Compute next value using previous value in
        // O(1) time
        int next_val = curr_val - (cum_sum - arr[i-1])
                       + arr[i-1] * (n-1);
 
        // Update current value
        curr_val = next_val;
 
        // Update result if required
        res = Math.max(res, next_val); //Maximum of both
    }
 
    return res;
}