public class IsSubsequence392 {
    public static void main(String[] args) {
        String s = "";
        String t = "ahbgdc";

        int s_len = s.length();
        int t_len = t.length();

        if(s_len ==0 || t_len == 0){
            System.out.println(false);
        }

        int i = 0;

        for(int j = 0; j<t_len; j++){
            if(i<s_len && j<t_len && s.charAt(i) == t.charAt(j)){
                i++;
            }
        }
        if(i == s_len){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

        


    }
}