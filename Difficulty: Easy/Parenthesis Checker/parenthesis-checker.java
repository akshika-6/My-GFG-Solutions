class Solution {
    public boolean isBalanced(String s) {
        // code here
        ArrayDeque<Character> stack=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch== '(' || ch== '[' || ch== '{'){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char top=stack.peek();
                if(ch==')' && top=='(' ||
                ch==']' && top=='['||
                ch=='}' && top=='{'){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}