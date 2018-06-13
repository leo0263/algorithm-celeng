// https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/once-upon-a-time-in-time-land/
// by : leo.0263@gmail.com

#include <iostream>
using namespace std;

long int T, N, K;
long int data[100001];
long int dp[100001];

long int findMax(long int a, long int b) {
    if (a > b) return a;
    else return b;
}

long int doDP(long int index) {
    // if index is out of data bound, return 0
    if (index >= N) return 0;
    
    // if we've found the max value for this step before, use it
    if (dp[index] != -1) return dp[index];

    // else, recursively find wheter it is better to skip this data, or use it (by it's index) 
    long int maxLocal = findMax(doDP(index + 1), data[index] + doDP(index + K + 1));
    if (dp[index] < maxLocal) dp[index] = maxLocal;
    return maxLocal;
}

int main()
{
    cin >> T;
    for (long int t = 0; t < T; t++) {
        // read input parameters
        cin >> N >> K;
        
        // read data & prepare dp table
        for (long int i = 0; i < N; i++) {
            cin >> data[i];
            dp[i] = -1;
        }
        
        // process the data using dp table
        long int maxGlobal = doDP(0);
    
        // prlong int the output
        cout << maxGlobal << endl;
    }
    
    return 0;
}
