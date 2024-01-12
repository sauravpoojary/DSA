package HashMap;

import java.util.HashMap;

public class Isomorphic {
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();

        int s_len = s.length();
        for(int i=0; i<s_len; i++){
            char s_char = s.charAt(i);
            char t_char = t.charAt(i);

            if(map.containsKey(s_char)){
                if(map.get(s_char)!=t_char){
                    return false;
                }
                
            }else{
                if(!map.containsValue(t_char)){
                    map.put(s_char,t_char);
                }else{
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";

        System.out.println(isIsomorphic(s, t));
    }
}