// ref: https://www.hackerrank.com/challenges/birthday-cake-candles/problem?isFullScreen=true
// i wonder why this code doesnt pass several testcase :(
    static Integer tallest = 0;
    static Integer tallestCount = 0;
    public static int birthdayCakeCandles(List<Integer> candles) {
        candles.forEach((candle) -> {
            if (candle > tallest) {
                tallest = candle;
                tallestCount = 1;
            } else if (candle == tallest) {
                tallestCount++;
            }
        });
        return tallestCount;
    }


// this code is passing all testcases, eventhough it's logic is the same as above code
// what's different is i'm not using foreach
   public static int birthdayCakeCandles(List<Integer> candles) {
        int tallest = 0;
        int tallestCount = 0;
        int count = candles.size();
        for (int i = 0; i < count; i++) {
            if (candles.get(i) > tallest) {
                tallest = candles.get(i);
                tallestCount = 1;
            } else if (candles.get(i) == tallest) {
                tallestCount++;
            }          
        }
        return tallestCount;
    }