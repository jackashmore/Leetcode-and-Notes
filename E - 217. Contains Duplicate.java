// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

// Example 1:

// Input: nums = [1,2,3,1]
// Output: true
// Example 2:

// Input: nums = [1,2,3,4]
// Output: false
// Example 3:

// Input: nums = [1,1,1,3,3,4,3,2,4,2]
// Output: true
 

// Constraints:

// 1 <= nums.length <= 105
// -109 <= nums[i] <= 109


class Solution {
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}

// This was my original solution. Obviously inefficient, running in O(n^2) time
// for nested for loops. TLE when submitted.

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}

// Much faster solution than the above linear search I originally tried. Easy 
// thing to make the search faster is sorting the nums before searching through.
// Got to make sure I'm paying attention to array bounds. Calling Arrays.sort()
// makes this O(nlogn), so we can make it faster.

// Quicker approach involves using a HashSet. A HashSet is a set backed by an
// underlying hash map and has add() operations instead of put(). The add()
// method only adds a value to a HashSet if it is a distinct value, so an easy
// way to approach this would be to put all values from the nums array into the
// HashSet and compare the array length to the size of the set. Something like this:

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
        	hSet.add(nums[i]); // won't add if it's a duplicate
        }
        // If the size of the set is the same as the array length,
        // we know they were all distinct elements
        return !(hSet.size() == nums.length);
    }
}

// Update: A pretty easy way to make the above code even faster is to add a check
// in to see if nums[i] is contained in the HashSet already when adding it from the
// array. If this is the case, return true. This would stop it early and prevent the
// need of adding all the elements to the set first.
