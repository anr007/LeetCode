/* Given an array of integers nums, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

Example 1:
Input: 
nums = [1, 7, 3, 6, 5, 6]
Output: 3
Explanation: 
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.
Example 2:
Input: 
nums = [1, 2, 3]
Output: -1
Explanation: 
There is no index that satisfies the conditions in the problem statement.
Note:

The length of nums will be in the range [0, 10000].
Each element nums[i] will be an integer in the range [-1000, 1000]. */

class Solution {
    public int pivotIndex(int[] nums) {

        ArrayList<Integer> a = new ArrayList<>();

        int mid = nums.length / 2;
        if (mid == 0)
            return -1;

        int i = mid;
        int l = 0, r = 0;
        for (int j = i - 1; j >= 0; j--) {
            l = l + nums[j];
        }
        for (int k = i + 1; k < nums.length; k++) {
            r = r + nums[k];
        }

        if (l == r) {
            a.add(i);
        }

        int l1 = l, r1 = r;
        for (i = mid - 1; i >= 0; i--) {
            // System.out.println(i+":\n");
            l1 = l1 - nums[i];
            // System.out.println("l1`:"+l1);
            r1 = r1 + nums[i + 1];
            // System.out.println("r1:"+r1);

            if (l1 == r1) {
                a.add(i);
            }
        }

        if (!a.isEmpty()) {
            Collections.sort(a);
            return a.get(0);
        }

        l1 = l;
        r1 = r;
        for (i = mid + 1; i < nums.length; i++) {
            // System.out.println(i+":\n");
            l1 = l1 + nums[i - 1];
            // System.out.println("l1`:"+l1);
            r1 = r1 - nums[i];
            // System.out.println("r1:"+r1);

            if (l1 == r1) {
                a.add(i);
            }
        }

        if (a.isEmpty())
            return -1;
        else {
            Collections.sort(a);
            return a.get(0);
        }
    }
}