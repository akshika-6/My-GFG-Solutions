class Solution {
    public boolean isBalanced(String s) {
        // code here
        ArrayDeque<Character> st=new ArrayDeque<>();
        for(char ch:s.toCharArray()){
            if(ch == '{' || ch == '(' || ch == '['){
                st.push(ch);
            } else {
                if(st.isEmpty()) return false;
                char top = st.pop();
                if((ch == '}' && top != '{')||
                (ch == ')' && top != '(')||
                (ch == ']' && top != '['))
                return false;
            }
        }
        return st.isEmpty();
    }
}