// Given an array of positive integers nums and a positive integer target, return the minimal length of a 
// subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

public class Minimum_Size_Subarray_Sum {
    public static int minSubArrayLen(int target, int[] nums) {
        return 0;
    }
    public static void main(String[] args) {
      int target = 7;
      int []nums = new int[] {2,3,1,2,4,3};
      System.out.println(minSubArrayLen(target, nums));
    }
}
