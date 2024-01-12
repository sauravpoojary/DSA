package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> res = new ArrayList<>();

        for(int []interval : intervals){
            
            if(interval[0] <= end){
                end = Math.max(end,interval[1]);
            }else{
                res.add(new int[]{start,end});
                start = interval[0];
                end = interval[1];
            }
        }

        res.add(new int[]{start,end});

        return res.toArray(new int[0][]);
    }
    
    public static void main(String[] args) {
        int [][]intervals = {{1,3},{2,6},{8,10},{15,18}};
        int [][]result = merge(intervals);
        for(int []interval : result){
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}
