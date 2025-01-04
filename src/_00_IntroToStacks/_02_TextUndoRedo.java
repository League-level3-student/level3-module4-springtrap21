package _00_IntroToStacks;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel.
	 * 
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 */

	public static void main(String[] args) {
		JFrame frame = new JFrame("Text Editor");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		Stack<Character> deletedChars = new Stack<>();
		panel.add(label);
		frame.add(panel);

		frame.addKeyListener(new KeyAdapter() {
			StringBuilder text = new StringBuilder();

			@Override
			public void keyPressed(KeyEvent e) {
				char keyChar = e.getKeyChar();

				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && text.length() > 0) {
					char removedChar = text.charAt(text.length() - 1);
					text.deleteCharAt(text.length() - 1);
					deletedChars.push(removedChar);
					label.setText(text.toString());
				}

				else if (e.getKeyCode() == KeyEvent.VK_Z && e.isControlDown() && !deletedChars.isEmpty()) {
					char replacedChar = deletedChars.pop();
					text.append(replacedChar);
					label.setText(text.toString());
				}

				else if (Character.isDefined(keyChar) && !e.isControlDown() && !e.isAltDown() && !e.isMetaDown()) {
					text.append(keyChar);
					label.setText(text.toString());
				}
			}
		});

		frame.setVisible(true);
	}
}
