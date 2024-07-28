// ref: https://www.hackerrank.com/challenges/mini-max-sum/problem?isFullScreen=true
   public static void miniMaxSum(List<Integer> arr) {
        // sort the 5 item
        for (int i = 0; i < 4; i++) {
            for (int j = i+1; j < 5; j++) {
                if (arr.get(i) > arr.get(j)) {
                    Integer temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
        
        long mini = 0;
        for (int i = 0; i < 4; i++) mini += arr.get(i);
        
        long maxi = 0;
        for (int i = 1; i < 5; i++) maxi += arr.get(i);
        
        System.out.println(mini + " " + maxi);
    }
}