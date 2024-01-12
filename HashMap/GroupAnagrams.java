package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        

        // STORE map [asc[string], [string]]

        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = String.valueOf(charArray);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }

            map.get(sorted).add(s);
        }

        return new ArrayList<>(map.values());

        
    }
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(groupAnagrams(strs));

    }
}
