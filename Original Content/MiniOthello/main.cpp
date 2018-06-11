#include <iostream>
using namespace std;

struct t_board {
    int pos[30];
};

t_board initialBoard;
int T, N, globalScore;



t_board playOthello(t_board currentBoard, int cellPos, int pieceColor) {
    t_board resultBoard = currentBoard;
    
    // color the target (empty) cell position with new color 
    resultBoard.pos[cellPos] = pieceColor;
    
    // scan to the left until we found same color cell
    int sameColorOnLeftPos = cellPos-1;
    while ((sameColorOnLeftPos >= 0) && (resultBoard.pos[sameColorOnLeftPos] != pieceColor)) sameColorOnLeftPos--;
    
    // then check from current to left position : can we convert all cell betweens to current color?
    // this means all pieces from current cell pos-1 to the first same color cell pos+1 must not be empty
    bool canConvertToLeft = true;
    for (int i = cellPos-1; i >= sameColorOnLeftPos+1; i--) 
        if (resultBoard.pos[i] == 0) canConvertToLeft = false;
        
    // if we can convert to left, do it on the result board;
    if (canConvertToLeft)
        for (int i = cellPos-1; i >= sameColorOnLeftPos+1; i--) 
            resultBoard.pos[i] = pieceColor;
            
    // now do the same thing to the opposite side (right)
    int sameColorOnRightPos = cellPos+1;
    while ((sameColorOnRightPos < N) && (resultBoard.pos[sameColorOnRightPos] != pieceColor)) sameColorOnRightPos++;
    
    bool canConvertToRight = true;
    for (int i = cellPos+1; i <= sameColorOnRightPos-1; i++) 
        if (resultBoard.pos[i] == 0) canConvertToRight = false;
        
    if (canConvertToRight)
        for (int i = cellPos+1; i <= sameColorOnRightPos-1; i++) 
            resultBoard.pos[i] = pieceColor;
    
    // return the resultBoard as the next recursive input (currentBoard)
    return resultBoard;
}



void doOthello(int steps, t_board currentBoard) {
    // exit condition, if we have play for 6 steps, check the score (count the black pieces)
    if (steps == 6) {
        int currentScore = 0;
        for (int i = 0; i < N; i++) if (currentBoard.pos[i] == 1) currentScore++;
        
        if (currentScore > globalScore) { // update global score when new score is higher
            globalScore = currentScore;
            
            // debug
            // for (int i = 0; i < N; i++) cout << currentBoard.pos[i] << " "; cout << "score = " << currentScore << endl;        
        }

        return;
    }
    
    
    // else do the recursion based on the current steps : 
    // steps 0 = black move 1st, 1 = white turn, 2 = black turns again, etc
    if (steps % 2 == 0) { // black moves
        for (int i = 0; i < N; i++) { // for every position in the board try to :
            if (currentBoard.pos[i] == 0) { // find an empty cell to put black pieces (as next recursion steps)
                doOthello(steps + 1, playOthello(currentBoard, i, 1));
            }
        }
    } else { // white moves, note that white AI always choose the leftmost blank cell
        int leftMostPosition = 0;
        for (int i = N-1; i >= 0; i--) if (currentBoard.pos[i] == 0) leftMostPosition = i;
        doOthello(steps + 1, playOthello(currentBoard, leftMostPosition, 2));
    }
    
}




int main() {
    cin >> T;
    for (int t = 1; t <= T; t++) {
        // read input
        cin >> N;
        for (int i = 0; i < N; i++) cin >> initialBoard.pos[i];
        
        // recursively play the game
        globalScore = 0;
        doOthello(0, initialBoard);
        
        // print the output
        cout << "#" << t << " " << globalScore << endl;
    }
    
}