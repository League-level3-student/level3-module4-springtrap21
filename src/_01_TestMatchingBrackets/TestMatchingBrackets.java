package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
	/*
	 * Use a Stack to complete the method for checking if every opening bracket has
	 * a matching closing bracket
	 */
	public static boolean doBracketsMatch(String b) {
		Stack<Character> brackets = new Stack<>();
		if (b.charAt(0) == ']') {
			return false;
		}
		for (char character : b.toCharArray()) {
			brackets.push(character);
		}
		int counter = 0;
		while (!brackets.empty()) {
			char pop = brackets.pop();
			if (pop == '[') {
				counter++;
			} else {
				counter--;
			}
		}
		if (counter == 0) {
			return true;
		}
		return false;

	}
}