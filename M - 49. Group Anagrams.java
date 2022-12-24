// Given an array of strings strs, group the anagrams together. You can return the answer in any order.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

// Example 1:

// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2:

// Input: strs = [""]
// Output: [[""]]
// Example 3:

// Input: strs = ["a"]
// Output: [["a"]]
 

// Constraints:

// 1 <= strs.length <= 104
// 0 <= strs[i].length <= 100
// strs[i] consists of lowercase English letters.


// Breaking into mediums slowly but surely... Honestly I wasn't that sure of how to approach this at the start. I recalled the
// easy way we could check if two strings were anagrams and thought about using that method as a helper function while iterating
// through the strings in the provided String array, but quickly realized that that would be alarmingly ineffiecient, ugh. Tried
// whiteboarding a solution on my tablet for like 15 minutes and was still stumped so I followed an online solution. The method
// I found involved using our friend Arrays.sort on the char arrays of each string and utilizing a HashMap of <String, List<String>>.

// Check through each string in strs; make them character arrays, sort these character arrays, and then construct new strings out of
// the sorted character arrays. Now that we've done this, check if the HashMap already contains the sorted string. If it doesn't, 
// put a new entry in with a new ArrayList, and after that add the current string we're on to the corresponding ArrayList holding
// the other strings that are anagrams. Super intuitive!

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> grouped = new ArrayList<>();
        HashMap<String, List<String>> hMap = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (!hMap.containsKey(sorted)) {
                hMap.put(sorted, new ArrayList<String>());
            }
                hMap.get(sorted).add(str);
        }

        grouped.addAll(hMap.values());
        return grouped;
    }
}

// This runs in O(nmlogm) with n being the number of strings given in strs and m being the length of the strings in strs. Could 
// definitely be made more efficient, but works well enough and is very easy to understand.
