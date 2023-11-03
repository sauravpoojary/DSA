/**
 * 
 * 
 * 151. Reverse Words in a String
 * 
 * Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string
 */

public class ReverseWordsInString {
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println("Remove spaces at end :" +s.trim()+ ":");

        String []words = s. split("\\s+");
        String result = "";
        for(int i=words.length-1; i>=0 ; i--){
            result += words[i] + " ";
        }
        System.out.println("After removal of sapce :" +result.trim()+ ":");

    }
}