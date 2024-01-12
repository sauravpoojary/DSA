package HashMap;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        int len = nums.length;

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int longest = 0;

        //traverse a set
        for(int num:set){

            if(!set.contains(num-1)){
                int cnt = 1;

                while(set.contains(num+1)){
                    num++;
                    cnt++;
                }

                longest = Math.max(longest,cnt);
            }
        }

        return longest ;
    }
    public static void main(String[] args) {
        int []nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
}
