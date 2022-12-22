// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

// Example 1:

// Input: s = "anagram", t = "nagaram"
// Output: true
// Example 2:

// Input: s = "rat", t = "car"
// Output: false
 

// Constraints:

// 1 <= s.length, t.length <= 5 * 104
// s and t consist of lowercase English letters.
 

// Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?


// For this problem, we want to look at the occurrences of each of the letters in both strings.

// Wasn't sure how to approach this one code-wise so I watched a video detailing some solutions. An initial approach we could
// use would be to use two HashMaps. Here, we could use the letters as keys and their occurrences as values and then
// just compare the two HashMaps values. This would require O(s + t) time and space complexity, so something more 
// space efficient could be to just use a character count reference array.

// For this approach, we would create an int array of size 26 (all letters in the alphabet). We would first check if 
// the string lengths are equal. If so, then we can iterate from 0 to either s or t.length() and look at the characters
// at each value of i for s and t. We would subtract 'a' from here to get the respective index for the character in our
// character count reference array, and we would increment using s while decrement using t. If we have equal numbers of 
// occurrences for each letter in both s and t, then the counts should even out to zero. This approach would look like this:

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) { 
        	return false;
        }

        int[] charCounts = new int[26]; // letter counts
        for (int i = 0; i < s.length(); i++) {
        	charCounts[s.charAt(i) - 'a']++; // in other words increment the count for the letter provided by subtracting 'a'
        	charCounts[t.charAt(i) - 'a']--; // decrement to "even out" the counts
        }

        for (int count : charCounts) {
        	if (count != 0) { // is everything evened out?
        		return false; 
        	}
        }
        return true;
    }
}
