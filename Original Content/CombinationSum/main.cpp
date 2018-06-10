// Subset sum -> Given a positive integer as input, find all sets of natural number that sums to that input.
// example if n = 4 : 
// 4
// 3 1
// 2 2
// 2 1 1
// 1 1 1 1
// brute-recursive solution by leo.0263@gmail.com

#include <iostream>
using namespace std;

const int maxGoal = 100;

int goal;
int digits[maxGoal];

void combinationSum(int currentDigit, int sum, int digitIndex) {
    // recursion exit condition
    if (currentDigit <= 0) return;
    if (sum > goal) return;
    
    if (sum == goal) {
        // print the solution
        for (int i = 0; i < digitIndex; i++) { cout << digits[i] << " "; };
        cout << endl;        
    } else {
        digits[digitIndex] = currentDigit;
        
        // try to use current digit on next recursion
        combinationSum(currentDigit, sum + currentDigit, digitIndex + 1);
        
        // try to skip current digit on next recursion
        combinationSum(currentDigit-1, sum, digitIndex);
    }
}

int main()
{
    cin >> goal;
    combinationSum(goal, 0, 0);
}
