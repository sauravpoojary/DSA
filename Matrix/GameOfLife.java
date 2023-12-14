package Matrix;
public class GameOfLife {
    public static int findNoOfOnes(int i, int j, int[][] board) {
        int count = 0;
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
                count += board[newRow][newCol];
            }
        }

        return count;
    }

    public static int[][] gameOfLife(int[][] board) {
        int r = board.length;
        int c = board[0].length;

        int[][] res = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int cur = board[i][j];
                int noOfOnes = findNoOfOnes(i, j, board);

                if (cur == 1) {
                    if (noOfOnes < 2 || noOfOnes > 3) {
                        res[i][j] = 0;
                    } else {
                        res[i][j] = 1;
                    }
                } else {
                    if (noOfOnes == 3) {
                        res[i][j] = 1;
                    }
                }
            }
        }

        return res;
    }

    public static int findNoOfOnesOpt(int i, int j, int[][] board) {
        int count = 0;
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
                if(Math.abs(board[newRow][newCol]) == 2){
                    continue;
                }else{
                    count += Math.abs(board[newRow][newCol]);
                }
                
            }
        }

        return count;
    }


    public static int[][] gameOfLifeOptimal(int[][] board) {
        int r = board.length;
        int c = board[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int cur = board[i][j];
                int noOfOnes = findNoOfOnesOpt(i, j, board);
                System.out.println("No of Ones :: " + noOfOnes);

                if (cur == 1) {
                    if (noOfOnes < 2 || noOfOnes > 3) {
                        board[i][j] = -1;
                    } else {
                        board[i][j] = 1;
                    }
                } else {
                    if (noOfOnes == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        for(int i =0; i<r; i++){
            for(int j=0;j<c;j++){

                if(board[i][j]==2){
                    board[i][j]=1;
                }else if(board[i][j]==-1) {
                    board[i][j]=0;
                }
            }
        }

        return board;
    }
    public static void print(int [][]res){
        for(int i=0;i<res.length; i++){
            for(int j=0; j<res[0].length; j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int [][]board = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        int res[][] = gameOfLifeOptimal(board);

        print(res);
    }
}
