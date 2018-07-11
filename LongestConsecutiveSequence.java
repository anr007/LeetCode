/* Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length < 1)
            return 0;
        
        Arrays.sort(nums);
        
        int max_len=1;
        int cur_len=1;
        
        for(int i =1;i<nums.length;i++){
            if(nums[i-1]+1==nums[i]){
                cur_len++;
                if(cur_len > max_len){
                    max_len = cur_len;
                }
            } else if(nums[i-1]==nums[i]){
                
            } else {
                cur_len = 1;
            }
        }
        
        return max_len;
    }
}