// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

// Merge nums1 and nums2 into a single array sorted in non-decreasing order.

// The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

// Example 1:

// Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
// Output: [1,2,2,3,5,6]
// Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
// The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
// Example 2:

// Input: nums1 = [1], m = 1, nums2 = [], n = 0
// Output: [1]
// Explanation: The arrays we are merging are [1] and [].
// The result of the merge is [1].
// Example 3:

// Input: nums1 = [0], m = 0, nums2 = [1], n = 1
// Output: [1]
// Explanation: The arrays we are merging are [] and [1].
// The result of the merge is [1].
// Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 

// Constraints:

// nums1.length == m + n
// nums2.length == n
// 0 <= m, n <= 200
// 1 <= m + n <= 200
// -109 <= nums1[i], nums2[j] <= 109
 

// Follow up: Can you come up with an algorithm that runs in O(m + n) time?



// Some key takeaways from this problem that I learned upon starting it: ALWAYS READ THE PROBLEM FULLY AND CAREFULLY. Even
// if it seems trivial upon first glance, you could totally mess up the expected implementation by adding a return when there
// is none expected. That's what I did for this problem. I read that everything was going to be stored in nums1 and immediately
// assumed that we returned nums1, disregarding the fact that it's a void method and explicitly says to not return anything. 

// That being said, my first idea with this problem was to append all of the elements of nums2 to nums1 and then calling Arrays.sort.
// This seemed like the most straightforward approach because Arrays.sort sorts the elements in non-decreasing order, which works fine.
// But, I learned that Arrays.sort has a time complexity of O(nlog(n)). I originally thought this solution was an O(n) solution without 
// realizing this, but good to know for future problems. 

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Arrays.sort will help a lot here since it already sorts
        // in non-decreasing order. All we have to do is start at
        // the end of nums1
        
        // start at the end of the array, run while it's less than the
        // combined length, basically just appending all of the elems to nums1
        int nums2Index = 0;
        for (int i = m; i < m + n; i++, nums2Index++) {
            nums1[i] = nums2[nums2Index];
        }
        // sort to non-decreasing order
        Arrays.sort(nums1);
        
    }
}


// A new solution idea I found to this problem is to adopt a two pointer approach. Here, we can use m and n to act as our two pointers.
// We start at the end of each array and use an index variable to go through the nums1 array. First, we decrement our m and n to account
// for bounds, and we set our index equal to nums1.length - 1. Since we know exactly how many times we're running this, we can use a while
// loop. Our while loop will run while our index is greater than or equal to 0.

// Now we have a few checks to account for. First, if m is less than 0, we know we've reached the end of the nums1 array, so we need to set
// the value at i (our index) in nums1 equal to the value at n in nums2. Similarly, our next check looks at n. If n is less than 0, we know
// we've reached the end of the nums2 array, so we need to set the value at nums1[i] to be nums1[m]. Don't forget to decrement the pointers!

// Our final condition is responsible for comparing the values of each array. First we can check if the value at nums1[m] > nums2[n]. If it is,
// update our current index at nums1 to be nums1[m]. Otherwise, set nums1[i] to be nums2[n]. Again, don't forget to decrement the pointers! 
// We decrement our index with every iteration of the while loop, also.

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Two pointer approach. We'll use m and n here, so we
        // have to decrement them to start
        m--;
        n--;
        int i = nums1.length - 1; // will serve as our index

        while (i >= 0) {
            if (m < 0) {
                nums1[i] = nums2[n];
                n--;
            }
            else if (n < 0) {
                nums1[i] = nums1[m];
                m--;
            }
            else {
                if (nums1[m] > nums2[n]) {
                    nums1[i] = nums1[m];
                    m--;
                }
                else {
                    nums1[i] = nums2[n];
                    n--;
                }
            }
            i--;
        }
    }
}

// This is a much faster solution and runs in O(m + n), with O(1) space complexity.
