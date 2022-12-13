// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

 

// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:

// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:

// Input: nums = [3,3], target = 6
// Output: [0,1]
 

// Constraints:

// 2 <= nums.length <= 104
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.
 

// Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

// Brute force approach with bad time complexity (O(n^2)) would be a nested for loop:

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1};
    }
}

// For this approach, we would iterate through the array twice and compare every element's
// sum to the target. This works fine for small data sets but starts to fall behind GREATLY
// when we get into larger ones.

// Better approach involves using a HashMap. What we can do is use a HashMap to store the index
// and the number at that index in the array. We will use this data in the HashMap and compare it
// to our "complement." Our complement is just going to be whatever number we need to add to the
// current element in the iteration to get the target, i.e., complement = nums[i] - target. We can
// go through the array with a for loop and check for two conditions: if the HashMap contains the 
// complement at this point in the loop, and if it doesn't. If it does, we get the complement from
// the HashMap and return it with the current index we are at. If it doesn't we need to put the 
// current number and index into the HashMap as a key-value pair.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int complement;
        
        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1};
    }
}

// Our solution is now much faster (O(n)) at the cost of memory. HashMap is a great solution for
// this because of its constant lookup time. Returns an array holding only -1 if not found, but
// the constraints for this problem state that there is exactly one valid solution.
