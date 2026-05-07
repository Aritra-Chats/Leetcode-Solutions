class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int size = s.length();
        for(int i = 0; i < size; i++) {
            switch(s.charAt(i)) {
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != '(')
                        return false;
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{')
                        return false;
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '[')
                        return false;
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }
}
