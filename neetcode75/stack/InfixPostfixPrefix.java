package stack;

import java.util.HashMap;
import java.util.Stack;

public class InfixPostfixPrefix {

    /*
    Infix x+y
    Prefix +xy
    Postfix xy+

        Operators | Associativity | Precendence
          ^       | Right To Left | 1
          *,/     | Left to Right | 2
          +-      | Left to Right | 3

        Precedence - 1 being the highest.

        If we wish to change the order of execution for infix we need to use brackets.



    */

    public String infixToPrefix(String str) {
        // almost same difference
        // 1. traverse from right to left. - hence the rules for ( & ) changes.
        // 2. for comparing operators, for equal precedence, we do not pop out equal precedence operators
        //    as those for associativity is left to right, hence we stack it on top of each other.
        // 3. also at last return reverse of result.
        return "";
    }

    public int postfixEvaluation(String str) {
        //is pretty straightforward,
        // when an operator is encountered, take last two operators and calculate and add to result.
        return 0;
    }

    public String infixToPostfix(String str) {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('(', 0);
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put('^', 3);

        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            //operand. (alphanumeric chars)
            if (!map.containsKey(curr) && curr != '(' && curr != ')') {
                result.append(curr);
            }

            //brackets.
            if (curr == '(') {
                stack.push(curr);
            }
            if (curr == ')') {
                while (stack.peek() != '(') {
                    result.append(stack.pop());
                }
                System.out.println("pushing out:" + stack.pop());
            }

            // operators
            // greater operator precendence greater - push.
            //                              less - pop
            //                              equal - follow associativity (for all except ^ pop).
            if (map.containsKey(curr)) {

                if (stack.size() == 0) {
                    stack.push(curr);
                } else {
                    if (map.get(stack.peek()) <= map.get(curr) && curr != '^') {
                        while (map.get(stack.peek()) <= map.get(curr)) {
                            result.append(stack.pop());
                        }
                    } else {
                        stack.push(curr);
                    }

                }

            }

        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }


}
