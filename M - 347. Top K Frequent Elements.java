// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

// Example 1:

// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]
 

// Constraints:

// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// k is in the range [1, the number of unique elements in the array].
// It is guaranteed that the answer is unique.
 

// Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

// I think I'm starting to get a better understanding of when to use HashMaps. With this problem, I started out with the idea
// of using a HashMap to track the values in nums so that key = the number and value = # of occurrences. My first thought was
// to use this approach, then somehow go and check through the values of the HashMap and obtain the largest k values from this
// set of values. This didn't really work and was more complicated than I needed to make it.

// Caved and went to the Neetcode solution. Here, we use the same approach that I discussed above and map each number to its
// frequency. Once this is done, we can create a priority queue sorted in ascending order. With this, we can add each entry in
// the hash map to the queue. With each pass on every entry, we can check if the queue size exceeds k. If it does, call poll()
// to remove the element with the lowest frequency. Finally, we can keep track of an index i equal to k and go through the queue.
// Here, since we were purging all of the elements with the lowest frequency as we went, the only remaining elements will be the
// top k frequent elements. We can add these to the array by using poll() and getKey. I added in-line comments to explain some
// stuff, especially for cases with things getOrDefault; hadn't ever used that method prior to this problem, but it was very helpful:

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // array to store most frequent k entries
        int[] arr = new int[k];
        // HashMap to track occurrences of numbers with key = number,
        // value = # of occurrences
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            // increment the frequency of the number using getOrDefault
            // This basically grabs the provided key's value and adds 1
            // to it if it already exists. If the key isn't in the map,
            // it defaults to 0 and adds 1 to start the freq. count at 1
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // make a priority queue; this will order entries in ascending order
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> 
            a.getValue() - b.getValue());

        // now, go through the map entries
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // add each entry to the priority queue
            queue.add(entry);
            if (queue.size() > k) {
                // if the size of the queue gets to be bigger than k,
                // remove the entry with the smallest frequency
                queue.poll();
            }
        }

        // create our index for arr
        int i = k;
        // go through the queue and extract the remaining elements. Since
        // we already went through and extracted the entries w/ the smallest
        // frequencies (provided the queue size exceeded k at some point), the
        // only remaining entries will be the most commonly occurring 
        while (!queue.isEmpty()) {
            // NOTE: we use --i here instead of i--; --i subtracts 1 from the
            // value of i before using it. This lets us fill our array in reverse
            // order. If we used i--, we would get out of bounds indexing errors
            arr[--i] = queue.poll().getKey();
        }

        return arr;

    }
}

// Here, the time complexity is O(nlog(k)), where n is the size of the nums array and k is the provided k. Insertion and removal
// operations in a priority queue are O(log(n)). Since we have a for loop where we add and remove from the queue, we have O(nlog(k))
// time complexity. For space complexity, we have just O(n) however. Our arrays and queue are all O(n).
