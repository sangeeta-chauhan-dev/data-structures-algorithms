package stack;

import java.util.Stack;

class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')' || c == '}' || c == ']') {
                if (st.isEmpty()) return false;
                char ele = st.pop();
                if (!((c == ')' && ele == '(') || (c == '}' && ele == '{') || (c == ']' && ele == '['))) return false;
            } else {
                st.push(c);
            }
        }
        return st.isEmpty();
    }
}