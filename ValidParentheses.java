/* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true */


// Best Solution

class Solution {
    public boolean isValid(String s) {

        int l = s.length();

        if (l < 1)
            return true;

        char[] stack = new char[l + 1];
        int top = 1;

        for (int i = 0; i < l; i++) {

            char c = s.charAt(i);

            if (c == ')') {
                if (stack[top - 1] == '(') {
                    top--;
                } else {
                    stack[top] = c;
                    top++;
                }
            } else if (c == ']') {
                if (stack[top - 1] == '[') {
                    top--;
                } else {
                    stack[top] = c;
                    top++;
                }
            } else if (c == '}') {
                if (stack[top - 1] == '{') {
                    top--;
                } else {
                    stack[top] = c;
                    top++;
                }
            } else {
                stack[top] = c;
                top++;
            }
        }

        return top == 1;

    }
}

// Good Solution

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push('*');

        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (int i = 0; i < s.length(); i++) {

            Character c = s.charAt(i);
            if (map.getOrDefault(stack.peek(), null) == c)
                stack.pop();
            else
                stack.push(c);
        }

        stack.pop();

        return stack.empty();
    }
}