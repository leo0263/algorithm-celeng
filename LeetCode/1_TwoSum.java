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
} 
// time: O(n^2)  space:O(1)
// Runtime 38ms Beats 45.35% of users with Java
// Memory 44.76MB Beats 52.76% of users with Java






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
} 
// time: O(n)  space:O(n)
// Runtime 2ms Beats 97.71% of users with Java
// Memory 45.05MB Beats 13.62% of users with Java

/* note:
 * relearn about HashMap
 *   Map <Integer, Integer> hashMap = new HashMap<>();
 *   hashMap.put(key, value)
 *   hashMap.get(key) --> return it's value
 *   hashMap.containsKey(key) --> check if there's any value for that key
 */