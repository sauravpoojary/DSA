package Stacks;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValid(String s) {
        int len = s.length();

        if(len%2 != 0) return false;

        Stack<Character> st = new Stack<>();

        for(char c: s.toCharArray()){
            if(c == ')'){
                if(st.isEmpty() || st.peek() != '('){
                    return false;
                }else{
                    st.pop();
                }
            }else if(c == '}'){
                if(st.isEmpty() || st.peek() != '{'){
                    return false;
                }else{
                    st.pop();
                }
            }else if(c == ']'){
                if(st.isEmpty() || st.peek() != '['){
                    return false;
                }else{
                    st.pop();
                }
            }else{
                st.push(c);
            }
        }

        return st.size()==0 ? true : false;
    }

    public static void main(String[] args) {
        
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}
