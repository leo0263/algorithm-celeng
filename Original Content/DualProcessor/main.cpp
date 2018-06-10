#include <iostream>
using namespace std;

struct t_job {
    int start;
    int duration;
    int stop;
};

void bruteForce(int index, int core1stop, int core2stop, int totalDuration);

t_job jobs[100];
int T, N, maxDuration;

int main() {
    
    cin >> T; 
    for (int cases = 1; cases <= T; cases++) {
        // read the input
        cin >> N;
        for (int i = 0; i < N; i++) {
            cin >> jobs[i].start >> jobs[i].duration;
            jobs[i].stop = jobs[i].start + jobs[i].duration;
        }
        
        // do the core operation
        maxDuration = 0;
        bruteForce(0, 0, 0, 0);
        
        // print the answer
        cout << "#" << cases << ": " << maxDuration << endl;
    }
    
    return 0;
}




void bruteForce(int index, int core1stop, int core2stop, int totalDuration) {
    // stop condition, if we have already tried to assign all jobs, check if this path is maxDuration
    if (index >= N) {
        if (maxDuration < totalDuration) maxDuration = totalDuration;
        return;
    }
    
    // else, for each index of job, try to give it to core1 or core2 or to no core at all
    // making this function act as a 3-way recursive branch
    
    if (jobs[index].start >= core1stop) // give current job to core 1
        bruteForce(index+1, jobs[index].stop, core2stop, totalDuration + jobs[index].duration);
        
    if (jobs[index].start >= core2stop) // give current job to core 2
        bruteForce(index+1, core1stop, jobs[index].stop, totalDuration + jobs[index].duration);
        
    // skip current job, dont give it to any cores
    bruteForce(index+1, core1stop, core2stop, totalDuration);
}