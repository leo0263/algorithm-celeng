// ref: https://leetcode.com/problems/two-sum/

import java.util.HashMap;
import java.util.Map;

class Solution_BruteForce {
    public int[] twoSum(int[] nums, int target) {
        int count = nums.length;
        for (int i=0; i<count-1; i++) {
            for (int j=i+1; j<count; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
} // time: O(n^2)  space:O(1)







class Solution_HashTable {
    public int[] twoSum(int[] nums, int target) {
        int count = nums.length;
        Map <Integer, Integer> hashMap = new HashMap<>();

        for (int i=0; i<count; i++) {
            int targetPair = target - nums[i];
            if (hashMap.containsKey(targetPair)) {
                return new int[]{i, hashMap.get(targetPair)};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }
} // time: O(n)  space:O(n)