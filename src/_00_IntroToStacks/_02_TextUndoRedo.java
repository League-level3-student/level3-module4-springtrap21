package _00_IntroToStacks;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo {
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * 
     * Every time a key is pressed, add that character to the JLabel. It should
     * looks like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Text Editor");
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		Stack<Character> deletedChars = new Stack<>();
		frame.setSize(400,400);
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(null);
		
	}
}
