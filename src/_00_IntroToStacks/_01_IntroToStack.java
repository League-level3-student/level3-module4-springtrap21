package _00_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
    public static void main(String[] args) {
        // 1. Create a Stack of Doubles
        //    Don't forget to import the Stack class
    	Stack<Double> dubs = new Stack<Double>();
        // 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
    	Random rnd = new Random();
    	for (int i = 0; i < 100; i++) {
			double rndDub = rnd.nextDouble(100);
			dubs.push(rndDub);
		}
        // 3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
    	String one = JOptionPane.showInputDialog("Enter a number between 0 and 100");
    	String two = JOptionPane.showInputDialog("Enter another bigger number between 0 and 100");
        // 4. Pop all the elements off of the Stack. Every time a double is popped that is
        //    between the two numbers entered by the user, print it to the screen.
    	double inputOne = Double.parseDouble(one);
    	double inputTwo = Double.parseDouble(two);
    	for (int i = 0; i < dubs.size()-1; i++) {
			double popped = dubs.pop();
			if (popped >= inputOne && popped <= inputTwo) {
				System.out.println(popped);
			}
		}
    	
        // EXAMPLE:
        // NUM 1: 65
        // NUM 2: 75

        // Popping elements off stack...
        // Elements between 65 and 75:
        // 66.66876846
        // 74.51651681
        // 70.05110654
        // 69.21350456
        // 71.54506465
        // 66.47984807
        // 74.12121224
    }
}
