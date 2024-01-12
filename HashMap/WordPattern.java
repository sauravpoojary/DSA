package HashMap;

import java.util.HashMap;

public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        int wordsLength = words.length;
        int patternLength = pattern.length();
        if(wordsLength != patternLength) return false;
        
        HashMap<Character, String> map = new HashMap<>();

        for(int i = 0; i < wordsLength; i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if(map.containsKey(c)) {
                if(!map.get(c).equals(word)) return false;
            } else {
                if(map.containsValue(word)) return false;
                map.put(c, word);
            }
        }

        return true;
    }
   public static void main(String[] args) {
    
    String pattern = "aaaa";
    String s = "dog cat cat fish";

    System.out.println(wordPattern(pattern, s));
   } 
}
