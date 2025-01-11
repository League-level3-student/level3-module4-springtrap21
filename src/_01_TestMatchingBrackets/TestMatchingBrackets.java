package _01_TestMatchingBrackets;

import java.util.Stack;

import javax.xml.stream.events.Characters;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
    	Stack <Character> brackets = new Stack<>();
    	int openBrackets = 0;
    	int closeBrackets = 0;
    	for (char character : b.toCharArray()) {
    		if (character == '[') {
				openBrackets++;
			}
    		else if (openBrackets == 0 && character == ']') {
				closeBrackets++;
			}
			brackets.push(character);			   	
		}
    	if (openBrackets == closeBrackets) {
			return true;
		}
		return false; 
    }
}