package HashMap;

import java.util.*;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {

        int freq[]= new int[26];

        for(char c : magazine.toCharArray()){
            freq[c-'a']++;
        }

        for(char c : ransomNote.toCharArray()){

            if(freq[c - 'a'] > 0){
                freq[c - 'a']--;
            }else{
                return false;
            }
        }


        return true;

    }

    public static void main(String[] args) {
        
        String ransomNote = "aaa";
        String magazine = "aaaab";
        System.out.println(canConstruct(ransomNote, magazine));
    }
}
