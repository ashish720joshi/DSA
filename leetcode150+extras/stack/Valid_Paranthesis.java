class Solution {
    public boolean isValid(String s) {
        int i=0;
        char []charArray=s.toCharArray();
        Stack<Character>stack=new Stack<>();
        if(s.length()%2==0){
            while(i!=s.length()){
                if(charArray[i]=='(' || charArray[i]=='{' || charArray[i]=='['){
                    stack.push(charArray[i]);
                }else{
                    if((!stack.isEmpty()) && ((charArray[i]==')' && stack.peek()=='(') ||
                    (charArray[i]=='}' && stack.peek()=='{') ||
                    (charArray[i]==']' && stack.peek()=='['))){
                        stack.pop();
                    }else return false;
                }
                i++;
            }
            if(stack.isEmpty()) return true;
            else return false;
        }
        return false;
    }
}

// better code written

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c); // Push opening brackets
            } else {
                // Check if the stack is empty or if the brackets don't match
                if (stack.isEmpty() || 
                   (c == ')' && stack.pop() != '(') || 
                   (c == '}' && stack.pop() != '{') || 
                   (c == ']' && stack.pop() != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty(); // Ensure no unmatched opening brackets remain
    }
}