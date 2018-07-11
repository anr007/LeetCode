/* Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321. */

class Solution {
    public int[] plusOne(int[] digits) {
        
        int s = digits.length;
        
        int i = s-1;
        int carry = 1;
        while(carry != 0 && i>=0){
         if(digits[i] < 9){
            digits[i] = digits[i] + carry;
             carry = 0;
         }else {
              digits[i] = 0;
              carry = 1;
         }
         i--;
        }
        
        if(carry == 1 && s>0){
            int ans[] = new int[s+1];
            ans[0]= 1;
            System.arraycopy(digits,0,ans,1,s);
            return ans;
        }
        
        return digits;
        
    }
}