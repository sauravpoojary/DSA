/**
 * 
 * 
 * 
 * 
 * 
 * 14. Longest Common Prefix
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 */

public class LongestCommonPrefixInArrayOfString {
    
    public  static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        //take prefix has first element
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            //check if full prefix exist in rest of elements
            while (strs[i].indexOf(prefix) != 0) {
                //if full prefix not existing in other element than reduce substring by 1
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }        
        return prefix;
    }
    public static void main(String[] args) {
        

        String []str = {"flower","flow","flight"};

        System.out.println("The logestcommon Prefix is : "+longestCommonPrefix(str));
    }
}
