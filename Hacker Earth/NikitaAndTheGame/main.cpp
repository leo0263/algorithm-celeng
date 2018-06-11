// NikitaAndTheGame.cpp : Defines the entry point for the console application.
// https://www.hackerrank.com/challenges/array-splitting

#include <iostream>
using namespace std;

int T, N;
int inputan[32768];
long long int answers[20];

long long int doSplit(int start, int stop);
long long int max(long long int a, long long int b);

int main()
{
	cin >> T; 
	for (int t = 0; t < T; t++) {
		cin >> N;
		for (int i = 0; i < N; i++) {
			cin >> inputan[i];
			inputan[i]++;
		}

		// delete lead/trail zeroes
		int start = 0;
		int stop = N-1;
		while (inputan[start] == 0) start++;
		while (inputan[stop] == 0) stop--;

		// do split recursively
		long long int maxSplit = doSplit(start, stop);

		answers[t] = maxSplit;
	}

	for (int t = 0; t < T; t++) {
		cout << answers[t] << endl;
	}

    return 0;
}

long long int doSplit(int start, int stop)
{
	if (start >= stop) return 0;

	long long int sum = 0;
	for (int i = start; i <= stop; i++) sum += inputan[i];
	
	long long int average = sum / 2;
	long long int leftSum = 0;
	long long int rightSum = 0;
	int middle = -1;

	int pointer = start;
	do {
		leftSum += inputan[pointer];
		pointer++;
	} while (leftSum < average);

	middle = pointer-1;
	do {
		rightSum += inputan[pointer];
		pointer++;
	} while ((rightSum < average) && (pointer <= stop));

	//// debug
	//cout << "leftSum:" << leftSum << " rightSum:" << rightSum;
	//cout << " Start/Middle/Stop: " << start << "/" << middle << "/" << stop << endl;

	if (leftSum != rightSum) return 0;
	else {
		return 1 + max(doSplit(start, middle), doSplit(middle + 1, stop));
	}

}

long long int max(long long int a, long long int b)
{
	if (a > b) return a;
	else return b;
}
