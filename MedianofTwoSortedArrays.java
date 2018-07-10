class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        int l1 = nums1.length;
        int l2 = nums2.length;

        int i = 0, j = 0;
        while (i < l1 && j < l2) {
            if (nums1[i] <= nums2[j]) {
                array.add(nums1[i]);
                i++;
            } else {
                array.add(nums2[j]);
                j++;
            }
        }

        while (i < l1) {
            array.add(nums1[i]);
            i++;
        }

        while (j < l2) {
            array.add(nums2[j]);
            j++;
        }

        /*
         * for(int a : array){ System.out.println(a+"\n"); }
         */

        int s = array.size() / 2;

        if (array.size() % 2 == 0) {
            return ((double) (array.get(s - 1) + array.get(s)) / 2);
        } else {
            return ((double) array.get(s));
        }
    }
}

public class MedianofTwoSortedArrays {

    public static void main(String[] args) throws IOException {

        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };

        double ret = new Solution().findMedianSortedArrays(nums1, nums2);

        System.out.print(ret);
    }
}