//ref: https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution_BruteForce {
    private int p1 = 0, p2 = 0;    
    private int getMin(int[] nums1, int[] nums2) {
        if (p1 < nums1.length && p2 < nums2.length) {
            return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        } else if (p1 < nums1.length) {
            return nums1[p1++];
        } else if (p2 < nums2.length) {
            return nums2[p2++];
        }
        return -1;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if ((m + n) % 2 == 0) {
            for (int i = 0; i < (m + n) / 2 - 1; ++i) {
                int tmp = getMin(nums1, nums2);
            }
            return (double) (getMin(nums1, nums2) + getMin(nums1, nums2)) / 2;
        } else {
            for (int i = 0; i < (m + n) / 2; ++i) {
                int tmp = getMin(nums1, nums2);
            }
            return getMin(nums1, nums2);
        }
    }
}
// time: O(n)  space:O(1)




class Solution_BinarySearch {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;

        while (left <= right) {
            int partitionA = (left + right) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA;

            int maxLeftA = (partitionA == 0)
                ? Integer.MIN_VALUE
                : nums1[partitionA - 1];
            int minRightA = (partitionA == m)
                ? Integer.MAX_VALUE
                : nums1[partitionA];
            int maxLeftB = (partitionB == 0)
                ? Integer.MIN_VALUE
                : nums2[partitionB - 1];
            int minRightB = (partitionB == n)
                ? Integer.MAX_VALUE
                : nums2[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    return (
                        (Math.max(maxLeftA, maxLeftB) +
                            Math.min(minRightA, minRightB)) /
                        2.0
                    );
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                right = partitionA - 1;
            } else {
                left = partitionA + 1;
            }
        }
        return 0.0;
    }
}
// time: O(log(n))  space:O(1)


/* note:
 * copied both answer from the Editorial, tried my own approach but it gets messy :(
 */