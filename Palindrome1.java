public class Palindrome1 {
    public static void main(String[] args) {
        String str = " ";
        str = str.trim();
        if(str.length() == 0) System.out.println(false);
        str = str.toLowerCase();
        str = str.replaceAll("[^a-z]","");
        StringBuilder sb = new StringBuilder(str);
        String reversed_str = sb.reverse().toString();
        System.out.println(reversed_str.equals(str));
    }
}
