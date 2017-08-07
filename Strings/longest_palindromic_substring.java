//longest_palindromic_substring

public class Solution {
        int start;
        int end;
    
    public String longestPalindrome(String s) {
        int len = s.length();
        
        if(len < 2)
            return s;
        
        for(int i=0;i<len-1;i++){
            expandPalindrome(s,i,i);   //odd
            expandPalindrome(s,i,i+1);//even
        }    
        
        return s.substring(start,start+end);
    }
    
    public void expandPalindrome(String s,int left,int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        
        if(end < right-left-1){
            end = right-left-1;
            start = left+1;
        }
        
    }
}