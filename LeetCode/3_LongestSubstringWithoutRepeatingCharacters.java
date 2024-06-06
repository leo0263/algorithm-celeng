// ref: https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.BitSet;

class Solution_BruteForce {
    public int lengthOfLongestSubstring(String s) {
        BitSet charSet = new BitSet();
        int strLength = s.length();
        int longest = 0;

        if (strLength == 1) longest = 1;
        for (int i = 0; i < strLength-1; i++) {
            charSet.clear();
            charSet.set(s.charAt(i));
            int subLength = 1;

            for (int j=i+1; j<strLength; j++) {
                if (charSet.get(s.charAt(j))) break;
                else {
                    charSet.set(s.charAt(j));
                    subLength++;
                }
            }

            if (subLength > longest) longest = subLength;
        }

        return longest;
    }
}
// time: O(n^2)  space:O(n)
// Runtime 36ms Beats 15.46% of users with Java
// Memory 42.66MB Beats 98.05% of users with Java

/* note: 
 * learn about BitSet class --> to map used char
 *   bitSet.clear() --> mark all map as false
 *   bitSet.set(char) --> mark that char as "used" (true)
 *   bitSet.get(char) --> check if that char is ever "used"
 */