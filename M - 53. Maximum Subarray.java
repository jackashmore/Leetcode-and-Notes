// For Kadane's algorithm, we keep track of two "max" variables: a max ending at the 
// current index and a local maximum thus far. First we initialize the maximum ending
// at the current index to -Infinity (Integer.MIN_VALUE) and the local max to 0. Iterate
// through the array once; Kadane's algorithm updates the local maximum such that:
// localMax = localMax + array[i].

// Now we need to do a check: is the maximum ending at the current index less than the 
// local max? If so, update the maximum ending at the current index to be equal to the 
// local max. We will ultimately return the maximum ending at the current index, since 
// at this point in the problem it will be properly updated. The other check we must do 
// is if the local max at this point in the iteration is less than 0. If so, set the local
// max to be 0. 


// PSEUDOCODE FROM THE GEEKSFORGEEKS PAGE
// Initialize:
//     max_so_far = INT_MIN
//     max_ending_here = 0

// Loop for each element of the array

//   (a) max_ending_here = max_ending_here + a[i]
//   (b) if(max_so_far < max_ending_here)
//             max_so_far = max_ending_here
//   (c) if(max_ending_here < 0)
//             max_ending_here = 0
// return max_so_far

class Solution {
    public int maxSubArray(int[] nums) {
        int maxAtCurrIndex = Integer.MIN_VALUE;
        int localMax = 0;

        for (int i = 0; i < nums.length; i++) {
            localMax = localMax + nums[i];
            if (maxAtCurrIndex < localMax) {
                maxAtCurrIndex = localMax;
            }
            if (localMax < 0) {
                localMax = 0;
            }
        }

        return maxAtCurrIndex;
    }
}

// Opinions on this one were a little mixed. Kadane's algorithm makes sense and is pretty
// intuitive when you go through it line by line, but this is one of the harder LC mediums
// I've done. The brute force way to go about this would have been comparing the sums of 
// every subarray in the provided array, but I think that the solution would be like O(n^3)
// or something ridiculous. Definitely an example of a problem to learn a lot from.
