//ref: https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/

/**
 * [0,1,0,1,1,0,0]
 * [0,0,1,1,1,0,0] using 1 swap.
 * [0,1,1,1,0,0,0] using 1 swap.
 * [1,1,0,0,0,0,1] using 2 swaps (using the circular property of the array).
 * 
 * [0,1,1,1,0,0,1,1,0]
 * [1,1,1,0,0,0,0,1,1] using 2 swaps (using the circular property of the array).
 * [1,1,1,1,1,0,0,0,0] using 2 swaps.
 * 
 * [1,1,0,0,1] All the 1's are already grouped together due to the circular property of the array.
 */

class Solution {
    public int minSwaps(int[] nums) {
        int totalOne = 0;
        for (int i=0; i < nums.length; i++) if (nums[i] == 1) totalOne++;
        
        // the pointer for sliding windows
        int x = 0;
        int y = totalOne-1;
        if (x-y == 0) return 0; // all is one?

        // initialize the max one
        int oneCount = 0;
        for (int i=x; i <= y; i++) if (nums[i] == 1) oneCount++;
        int maxOne = oneCount;
        //System.out.println("x:"+x+" y:"+y+" maxOne:"+maxOne);

        // do the sliding window technique
        for (int i=1; i < nums.length; i++) {
            oneCount -= nums[x];
            x++; 
            y = (y + 1) % nums.length;
            oneCount += nums[y];

            if (maxOne < oneCount) maxOne = oneCount;
            //System.out.println("x:"+x+" y:"+y+" maxOne:"+maxOne);
        }

        // the minimum swap to achieve consecutive one is:
        return totalOne - maxOne;
    }
}