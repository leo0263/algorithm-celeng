//ref: https://leetcode.com/problems/filling-bookcase-shelves

class Solution {

    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[][] dpTable = new int[books.length][shelfWidth+1];
        return findMin(books, shelfWidth, dpTable, 0, shelfWidth, 0);
    }

    private int findMin(
        int[][] books, int shelfWidth, 
        int[][] dpTable, 
        int index,
        int remainingWidth,
        int totalHeight
    ) {
        int currentBookWidth = books[index][0];
        int currentBookHeight = books[index][1];
        int normalizedTotalHeight = Math.max(totalHeight, currentBookHeight);

        // if last book, either use current shelf, or put in new shelf
        if (index == books.length-1) {
            if (remainingWidth >= currentBookWidth) return normalizedTotalHeight;
            else return totalHeight + currentBookHeight;
        }

        // check dpTable for memoization
        int memoization = dpTable[index][remainingWidth];
        if (memoization != 0) return memoization;

        // else, branch into either use current shelf
        int useCurrentShelf = -1;
        if (remainingWidth >= currentBookWidth) {
            useCurrentShelf = findMin(books, shelfWidth, dpTable,
                index + 1,
                remainingWidth - currentBookWidth,
                normalizedTotalHeight
            );
        }

        //  or create new shelf
        int createNewShelf = totalHeight + findMin(books, shelfWidth, dpTable,
                index + 1,
                shelfWidth - currentBookWidth,
                currentBookHeight
            );
        
        if (useCurrentShelf != -1) {
            dpTable[index][remainingWidth] = Math.min(
                useCurrentShelf,
                createNewShelf
            );
        } else {
            dpTable[index][remainingWidth] = createNewShelf;
        }

        return dpTable[index][remainingWidth];
    }
}