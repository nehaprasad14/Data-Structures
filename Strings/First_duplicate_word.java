static void printFirstRepeating(String arr[])
	{
		// Initialize index of first repeating element
		int min = -1;

		// Creates an empty hashset
		HashSet<String> set = new HashSet<>();

		// Traverse the input array from right to left
		for (int i=arr.length-1; i>=0; i--)
		{
			// If element is already in hash set, update min
		//	System.out.println("in loop : "+arr[i]);
			
			if (set.contains(arr[i]))
				min = i;

			else // Else add element to hash set
				set.add(arr[i]);
		}

		// Print the result
		if (min != -1)
		System.out.println("The first repeating element is " + arr[min]);
		else
		System.out.println("There are no repeating elements");
	}

	// Driver method to test above method
	public static void main (String[] args) throws java.lang.Exception
	{
		String arr[] = {"aaa","aaa","hjgh","bbbb","bbbb"};
		printFirstRepeating(arr);
	}