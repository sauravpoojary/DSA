/*
 * 
 * 
 * 58. Length of Last Word
 * 
 * 
 * Given a string s consisting of words and spaces, return the length of the last word in the string.A word is a maximal 
 * substring
 * consisting of non-space characters only.
 * link : https://leetcode.com/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150
 */

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "luffy is still joyboy";

        s = s.trim();

        String []words = s.split("\\s+");

        System.out.println(":"+words[words.length-1].length()+":");
    }
}
