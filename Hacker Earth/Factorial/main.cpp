// https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/tutorial/
// by : leo.0263@gmail.com

#include <iostream>
using namespace std;

long long int factorial[100001];

int main()
{
    // precomputation, fill the factorial table
    factorial[0] = 1;
    factorial[1] = 1;
    for (long int i = 2; i < 100000; i++) {
        factorial[i] = (factorial[i-1] * i % 1000000007);
    }
    
    int T;
    long int N;
    
    cin >> T;
    for (int t = 0; t < T; t++) {
        cin >> N;
        cout << factorial[N] << endl;
    }   
    
    return 0;
}
