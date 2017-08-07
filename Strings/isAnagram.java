I would put an extra conditional statement in the second loop.
Average time will be much better as it does not have to go through the 
3rd loop every time. With this line, as soon as a discrepancy is found, 
it will return false and break out of the loops.

public class Solution {
  public boolean isAnagram(String s, String t) {
      int[] alphabet = new int[26];
      for (int i = 0; i < s.length(); i++)    // store all charaters from source str in alphabet
		  alphabet[s.charAt(i) - 'a']++;
	  
      for (int i = 0; i < t.length(); i++) {   // store all charaters from destination str in alphabet
        alphabet[t.charAt(i) - 'a']--;
        if(alphabet[t.charAt(i) - 'a'] < 0) 
		   return false;
      }
      for (int i : alphabet) 
		  if (i != 0) 
			  return false;
      return true;
  }
}


cat == tac = true