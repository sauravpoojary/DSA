import java.util.ArrayList;


/*
 * 
 * 
 * 
 * 6. Zigzag Conversion
 * 
 * link : https://leetcode.com/problems/zigzag-conversion/description/?envType=study-plan-v2&envId=top-interview-150
 * 
 * 
 * Approach
 * 
 * Take a arraylist of size numRows
 * 
 * Traverse through each character in string
 * Add to list for specific indx
 * 
 * 
 * indx will be incremented when flag true ()
 * flag :true
 * eg : PAYPALISHIRING
 * ArrayList
 * 0 P
 * 1 A
 * 2 Y
 * 
 * when numRoes -1 reached say 2 here then switch the flag to false
 * 
 *so next time it will go from 2 -> 1 -> 0
 *
 * toggle again
 * when again 0 reached 0 -> 1 -> 2
 */
public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        

        if(numRows == 1){
            return s;
        }

        boolean flag = false;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add("");
        }
        int indx = 0;

        for(char ch : s.toCharArray()){
            String curString = list.get(indx);
            curString += ch;
            list.set(indx, curString);

            if( indx == 0 || indx == numRows-1){
                flag = !flag;
            }

            if(flag){
                indx++;
            }else{
                indx--;
            }

        }
        String result = "";
        for(String str : list){
            result += str;
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
