// https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/number-of-rs-1/description/
// by : leo.0263@gmail.com

#include <iostream>
#include <string>
using namespace std;

int T, N;
string inputan;

int main()
{
    cin >> T;
    for (int t = 0; t < T; t++) {
        // read the input
        cin >> inputan;
        N = inputan.length();
        
        // do the kadane's alogrithm (largest sum contiguous subarray)
        long maxHere = 0;
        long maxGlobal = 0;
        long initialR = 0;
        for (int i = 0; i < N; i++) {
            if (inputan[i] == 'K') {
                maxHere++;
            } else {
                maxHere--;
                initialR++;
            }
            
            if (maxHere < 0) maxHere = 0;
            
            if (maxGlobal < maxHere) maxGlobal = maxHere; 
        }
        
        // due to the nature of the problem, even if all input is like 'RRRRR' we still have to flip 1 time
        if (initialR == N) initialR--;
        
        // print the answer
        cout << initialR + maxGlobal << endl;
    }
    
    return 0;
}
