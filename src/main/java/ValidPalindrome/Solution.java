package ValidPalindrome;

// https://neetcode.io/problems/is-palindrome

//avccva

public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]+", "");
        System.out.println(s);
        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }
}
