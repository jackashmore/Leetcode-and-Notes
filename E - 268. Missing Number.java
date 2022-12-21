// Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

 

// Example 1:

// Input: nums = [3,0,1]
// Output: 2
// Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
// Example 2:

// Input: nums = [0,1]
// Output: 2
// Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
// Example 3:

// Input: nums = [9,6,4,2,3,5,7,0,1]
// Output: 8
// Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 

// Constraints:

// n == nums.length
// 1 <= n <= 104
// 0 <= nums[i] <= n
// All the numbers of nums are unique.
 

// Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?



// Initial solution I think of when seeing this is to call Arrays.sort() on nums.
// Once we do this and the numbers are sorted, iterate through the array and check if
// nums[i + 1] != (nums[i] + 1). In other words, we are checking if the element after the one 
// at the current index is equal to the currently indexed element summed with 1. Since the
// numbers are sorted, the value after the current number should always be the current
// number plus 1.

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
        	if ((nums[i] + 1) != nums[i + 1]) {
        		return (nums[i] + 1);
        	} 
        }
        return (nums[nums.length - 1] + 1);
    }
}

// Keeping this here to see my mistakes ^

// This ultimately didn't work for a few different reasons. A working solution involving a HashSet 
// could be like this:

class Solution {
    public int missingNumber(int[] nums) {
        HashSet<Integer> hSet = new HashSet<Integer>();
        for (val : nums) {
        	hSet.add(val); // add all of the values to the set
        }

        for (int i = 0; i <= nums.length; i++) { // our bounds are inclusive at nums.length
        	// because the array goes from 0 to n
        	if (!hSet.contains(i)) {
        		return i;
        	} 
        }

        return -1;
    }
}

// This simply adds all the values to the HashSet and then checks to see if all the numbers from
// 0 to n are contained in the set. Whatever isn't found is returned. This runs in O(n) with an
// O(n) space complexity because of the HashSet instantiation. Note the follow up:

// Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

// We could go one of two routes here: the sum route or the bit manipulation route. The sum route involves using
// Gauss's formula. This states that the total sum of the values from 1 to n is equal to (n * (n + 1)) / 2. We can 
// subtract the sum of all of the elements in the provided array from this to get our missing number.

class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
		for (int val : nums) {
        	sum += val; // the sum of the vals in the given array
        }

        int arrayTotal = nums.length; // our 'n' for our formula

        return ((arrayTotal * (arrayTotal + 1) / 2) - sum); // (n * (n + 1) / 2) - the actual sum
    }
}

// This runs in O(n) and only requires O(1) space complexity. We compare the expected sum with the actual sum and
// the result from subtracting is our missing number. The sum approach is WAY more easier to understand than the bit 
// manipulation stuff right now but I'm sure it'll get better with time.
