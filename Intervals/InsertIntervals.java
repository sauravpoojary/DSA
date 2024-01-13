package Intervals;
import java.util.*;

public class InsertIntervals {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
       
        List<int[]> res= new ArrayList<>();

        //check how many intervals before new intervals arenot overlapping can be inserted to res
        int i = 0;
        //add all non-overlapping intervals to res
        while(i<intervals.length && intervals[i][1]<newInterval[0]){
            res.add(intervals[i]);
            i++;
        }

        //add overlapping intervals
        while(i<intervals.length &&  intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        res.add(newInterval);

        //add the last one
        while(i<intervals.length){
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[0][]);
    }
    public static void main(String[] args) {
        int [][]intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int []newInterval = {4,8};
        int [][]result = insert(intervals,newInterval);
        for(int []interval : result){
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}
