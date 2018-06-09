// https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/choosing-the-judges-7/
// by : leo.0263@gmail.com

#include <iostream>
using namespace std;

int T, N;
long data[10001], dpTable[10001];

long maximum(long a, long b) {
    if (a > b) return a;
    else return b;
}

long doDP(int index) {
    // if index out of data count, exit
    if (index >= N) return 0;
    
    // if we have visited this node, use the answer
    if (dpTable[index] != -1) return dpTable[index];
    
    // else, recursively find the best choices to make
    long localMax = maximum(doDP(index + 1), data[index] + doDP(index + 2));
    dpTable[index] = localMax;
    return localMax;
}

int main()
{
    cin >> T;
    for (int t = 0; t < T; t++) {
        // read input
        cin >> N;
        for (int i = 0; i < N; i++) {
            cin >> data[i];
            dpTable[i] = -1;
        }
        
        // process the DP
        cout << "Case " << t+1 << ": " << doDP(0) << endl;        
    }
    return 0;
}









