package Sorting;

import java.util.*;

public class ArithmeticSequence {

    public static boolean checkArrayWithoutSorting(int []a){
        //Optimal Approach
        int len = a.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Set<Integer> hash = new HashSet<>();

        for(int num : a){
            min = Math.min(min,num);
            max = Math.max(max,num);
            hash.add(num);
        }

        if((max-min)%(len-1) != 0){
            return false;
        }

        int diff = (max-min)/(len-1);

        int cur = min + diff;

        while(cur<max){
            if(!hash.contains(cur)){
                return false;
            }

            cur +=diff;
        }
        

        return true;
        
    }

    public static boolean checkArrayWithSorting(int []a){
        //Good Approach
        int len = a.length;
        if(len == 1)return true;
        Arrays.sort(a);
        int diff = a[len-1] - a[len-2];
        for(int i = len-2; i>0 ; i--){
            if(diff != a[i] - a[i-1]){
                return false;
            }
        }

        return true;
        
    }

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        int n = l.length;

        for (int j = 0; j < n; j++) {
            int left_index = l[j];
            int right_index = r[j];
            int[] new_ar = Arrays.copyOfRange(nums, left_index, right_index + 1);
            res.add(checkArrayWithoutSorting(new_ar));
        }

        return res;
    }
    
    public static void main(String[] args) {
        
        int []nums = {4,6,5,9,3,7};
        int []l = {0,0,2};
        int []r = {2,3,5};
        List<Boolean> res = new ArrayList<>();
        res = checkArithmeticSubarrays(nums,l,r);

        for(Boolean re:res){
            System.out.println(re+" ");
        }
    }
}
