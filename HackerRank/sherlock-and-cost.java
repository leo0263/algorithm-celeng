// ref: https://www.hackerrank.com/challenges/sherlock-and-cost/problem?isFullScreen=true
// 3rd try, dynamic programming
public static int cost(List<Integer> B) {
    int dataCount = B.size();
    int dpTable[][] = new int[dataCount][2];
    dpTable[0][0] = 0;
    dpTable[0][1] = 0;

    for (int i = 1; i < dataCount; i++) {
        dpTable[i][0] = Math.max(
            dpTable[i-1][0] + Math.abs(B.get(i) - B.get(i-1)), 
            dpTable[i-1][1] + Math.abs(B.get(i) - 1)
        );

        dpTable[i][1] = Math.max(
            dpTable[i-1][0] + Math.abs(1 - B.get(i-1)),
            dpTable[i-1][1]
        )
    }
    
    return Math.max(
        dpTable[dataCount-1][0],
        dpTable[dataCount-1][1]
    );
}





// 2nd try, recursive (timeout)
    public static int findCost(List<Integer> data, int index, boolean useOne) {
        if (index == -1) return 0;

        int a = 0; int b = 0;
        a = findCost(data, index-1, false);
        b = findCost(data, index-1, true);

        int value = (useOne) ? data.get(index+1) : 1;
        a = a + Math.abs(value - 1);
        b = b + Math.abs(value - data.get(index));
        
        return Math.max(a, b);
    }

public static int cost(List<Integer> B) {
    int maxi = Math.max(findCost(B, B.size()-2, false), findCost(B, B.size()-2, true));
    
    return maxi;
}





// 1st try, totally missed the question :(
    public static int cost(List<Integer> B) {
        List<Integer> sorted = new ArrayList<Integer>(B);
        Collections.sort(sorted);
        int itemCount = sorted.size();
        int mid = sorted.size() / 2;
        boolean notEven = (sorted.size() % 2 == 1);
        
        List<Integer> maxi = new ArrayList<Integer>();
        List<Integer> mini = new ArrayList<Integer>();
        
        for(int i = 0; i < mid; i++) {
            maxi.add(sorted.get(itemCount - i - 1));
            mini.add(sorted.get(i));
        }
        if (notEven) {
            maxi.add(sorted.get(mid));
        }
        
        List<Integer> combined = new ArrayList<Integer>();
        int pointerMaxi = 0;
        int pointerMini = 0;
        for(int i = 0; i < itemCount; i++) {
            if (i % 2 == 0) {
                combined.add(maxi.get(pointerMaxi));
                pointerMaxi++;
            } else {
                 combined.add(mini.get(pointerMini));
                pointerMini++;               
            }
        }
    
        //debug
        System.out.println(combined);
        
        int totalSum = 0;
        for (int i = 1; i < itemCount; i++) {
            System.out.println(combined.get(i) + " - " + combined.get(i-1) + " = "+ (combined.get(i) - combined.get(i-1)));
            totalSum += Math.abs(combined.get(i) - combined.get(i-1));
        }
        
        return totalSum;
    }