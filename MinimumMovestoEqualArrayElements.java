/* Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4] */


/* let's define 'sum' as the sum of all the numbers, before any moves; 
minNum as the min number int the list;
n is the length of the list;

After, say m moves, we get all the numbers as x , and we will get the following equation

 sum + m * (n - 1) = x * n

and actually,

  x = minNum + m

This part may be a little confusing, but let me explain a little. it comes from two observations:

the minNum number will always be minimum until it reachs the final number, because every move, other numbers (besides the max) will be increamented too;
from above, we can get, the minimum number will be incremented in every move. So, if the final number is x, it would be minNum + moves;
and finally, we will get

  sum - minNum * n = m

This is just a math calculation. */

// My Approach - TLE ;(
class Solution {
    public int minMoves(int[] nums) {
        
        if(nums.length < 1)
            return 0;
        
        Arrays.sort(nums);
        
        int s = nums.length;
        int m = 0;
        
        while(nums[0]!=nums[s-1]){
            for(int i=0;i<s-1;i++){
                nums[i]++;
            }
            Arrays.sort(nums);
            m++;
        }
        
        return m;
        
    }
}


// Formula
class Solution {
    public int minMoves(int[] nums) {
        
        int s = nums.length;
        int sum = 0;
        int min = nums[0];
                
        for(int i=0;i<s;i++){
          sum += nums[i];
          if(nums[i] < min){
              min = nums[i];
          }
        }

        return sum - min*s;        
    }
}