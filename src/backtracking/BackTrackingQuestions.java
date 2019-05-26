package backtracking;


public class BackTrackingQuestions {



    //----------------------1.  N Queen Solve -----------------------------------

    /* Since we are processing from left to right
        We need to chec for:
            - Presence of another queen in the same row on left side
            - Presence of queen on upper diagonol on left side
            - Presence of queen on lower diagnol on left side
     */
    public boolean isSafe(int[][] b, int row, int col) {

        // check for another queen in same row
        for(int i=0; i<col; i++) {
            if(b[row][i] == 1) {
                return false;
            }
        }

        // check for another queen in upper diagonol on left
        for(int i=row, j=col; i>=0 && j>=0; i--, j--) {
            if(b[i][j] ==1) {
                return false;
            }
        }

        // check for another queen in lower left diagnol
        for(int i=row, j=col; i<b.length && j>=0; i++, j--) {
            if(b[i][j] == 1) {
                return false;
            }
        }

        return true;
    }


    // Returns true if N queens can be placed from col = col to col = N
    public boolean solveNQUtil(int[][] b, int col) {

        // Base condition: if recursive call reaches to N+1 col, return true
        if(col==b.length) {
            return true;
        }

        /* iterate over each row for the given col and check if queen can be placed safely.
         If Yes, mark the placement=1 and try placing queen for next column recursively
         If recursive call returns false, then check for the other rows in the given col and again call recursively for next col
         If all rows exhaust for safe placement of queen in the given col, then return false
          */

        for(int row=0; row<b.length; row++) {
            if(isSafe(b, row, col)) {
                b[row][col] = 1;
                if(solveNQUtil(b, col+1)) {
                    return true;
                }else {
                    b[row][col] = 0;
                }
            }
        }
        return false;
    }

    public void printBoard(int[][] b) {
        for(int i=0; i<b.length; i++)  {
            for(int j=0; j<b[0].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void solveNQ() {
        int[][]  b = {  {0,0,0,0},
                        {0,0,0,0},
                        {0,0,0,0},
                        {0,0,0,0}
                        };
        if(solveNQUtil(b, 0)) {
            printBoard(b);
        }else {
            System.out.println("Not possible to place queens");
        }
    }

    // ---------------2.  Sudoku solve ------------------------------

    public boolean isSafeSudoku(int[][] b, int row, int col, int num) {

        // check horizontally
        for(int i=0; i<b[0].length; i++) {
            if(i!=col && b[row][i]==num) {
                return false;
            }
        }

        // check vertically
        for(int i=0; i<b.length; i++) {
            if(i!=row && b[i][col]==num) {
                return false;
            }
        }

        // check within same box
        int sqrt = (int) Math.sqrt(b.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for(int i=boxRowStart; i<boxRowStart+sqrt;  i++) {
            for(int j=boxColStart; j<boxColStart+sqrt; j++) {
                if(b[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solveSudokuUtil(int[][] b) {

        // isEmpty variable tracks if there are any missing slot in sudoku to be filled
        boolean isEmpty = true;
        int row = -1;
        int col = -1;

        // traverse each position and check if its non zero or not
        for(int i=0; i<b.length; i++) {
            for(int j=0; j<b[0].length; j++) {
                if(b[i][j]==0)  {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if(!isEmpty) {
                break;
            }
        }

        if(isEmpty) {
            return true;
        }

        for(int i=1; i<=b.length; i++) {
            if(isSafeSudoku(b, row, col, i)) {
                b[row][col] = i;
                if(solveSudokuUtil(b)) {
                    return true;
                }else {
                    b[row][col] = 0;
                }
            }
        }


        return false;
    }

    public void printSudoku(int[][] b) {
        for(int i=0; i<b.length; i++) {
            for(int j=0; j<b[0].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void solveSudoku() {
        int[][] board = new int[][]
                {
                        {3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}

                        /*{1, 0, 3, 0},
                        {0,0,2,1},
                        {0,1,0,2},
                        {2, 4, 0, 0}*/
                };
        int N = board.length;

        if (solveSudokuUtil(board))
        {
            printSudoku(board); // print solution
        }
        else
        {
            System.out.println("No solution");
        }
    }

    public static void main(String[] args) {
        BackTrackingQuestions obj = new BackTrackingQuestions();

        // 1.https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/
        obj.solveNQ();
        System.out.println(" ---------------sudoku ----------");
        obj.solveSudoku();
    }
}
