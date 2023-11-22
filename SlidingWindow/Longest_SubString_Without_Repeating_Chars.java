import java.util.HashMap;
import java.util.HashSet;

public class Longest_SubString_Without_Repeating_Chars {

    public static int lengthOfLongestSubstringGoodSolution(String s) {
        int len = s.length();
        HashSet<Character> set = new HashSet<>();
        int max_len = 0;
        int left=0;
        for(int right = 0; right<len; right++){
            if(set.contains(s.charAt(right))){
                while(set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(s.charAt(right));
            max_len = Math.max(max_len,right-left+1);
            
        }

        return max_len;
    }

    public static int lengthOfLongestSubstringOptimalSolution(String s) {
        int len = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int max_len = 0;
        int left=0;
        for(int right = 0; right<len; right++){
            if(map.containsKey(s.charAt(right))){
                //max added for second b case
                //when l will be at index 4
                //but in map we have (b,1)
                //so update left to max of left and map.get(s.charAt(right)
                left= Math.max(map.get(s.charAt(right)) +1,left);
            }
            map.put(s.charAt(right), right);
            max_len = Math.max(max_len,right-left+1);         
        }

        return max_len;
    }
    public static void main(String[] args) {
        String s = "abcaabcdba";
        System.out.println("Good Solution : "+lengthOfLongestSubstringGoodSolution(s));
        System.out.println("Optimal Solution : "+lengthOfLongestSubstringOptimalSolution(s));
    }
}
