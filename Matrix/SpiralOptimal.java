package Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOptimal {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = col-1;
        int top = 0;
        int bottom = row-1;
        List<Integer> res = new ArrayList<>();

        while(left<=right && top<=bottom){

            for(int i = left; i<=right; i++){
                res.add(matrix[top][i]);
            }
            top++;
            for(int i=top; i<=bottom; i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){//if there is only one row
                for(int i=right; i>=left; i--){
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){//only one col
                for(int i=bottom; i>=top; i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int [][]matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
}