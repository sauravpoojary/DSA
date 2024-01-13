package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        //[[1,6],[2,8],[7,12],[10,16]]
        int cnt = 1;
        int end = points[0][1];//6

        for (int i = 1; i < points.length; i++) {
            int[] cur = points[i];//[2,8]//[7,12]//[10,16]

            if (cur[0] > end) {
                //no overlap
                cnt++;//2
                end = cur[1];//12
            } else {
                end = Math.min(end, cur[1]);//6//10
            }
        }

        return cnt;
    }

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
        int [][]intervals = {{-2147483646,-2147483645},{2147483646,2147483647}};
        // int [][]result = merge(intervals);
        // for(int []interval : result){
        //     System.out.println(interval[0] + " " + interval[1]);
        // }

        System.out.println(findMinArrowShots(intervals));
    }
}
