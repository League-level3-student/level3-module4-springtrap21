package _03_Hangman;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
/*Step 1: When the program starts, it will ask the user for a number (up to the total words in the file). Then the 
program will read that many words from the "dictionary.txt" file and push them to a Stack. 
Use the readRandomLineFromFile method in the Utilities class. The words should be selected randomly so 
not every game is played with the same set of words. You can use the Stack's contains() method to make sure
there are no duplicate words.

Step 2: Pop the word off the top of the stack and use a JLabel to display a blank line for all the characters in the word. 
Collect key inputs from the user. If the user guesses a letter, fill in the blank space. Otherwise, take off a life.

Step 3: When a word has been solved, pop the next one off the stack and start a new round. It is up to you if you want to 
reset the lives.

Step 4: If they run out of lives, give them a game over message.

Step 5: Don't end the program on game over. Ask the user if they would like to play again and run the game again with new 
words if they choose yes*/
public class Hangman {
	
	    private Stack<String> wordStack;
	    private String currentWord;
	    private char[] displayedWord;
	    private int lives = 6;
	    private JLabel wordLabel, livesLabel;
	    private JFrame frame;

	    public Hangman() {
	        setupGame();
	    }

	    private void setupGame() {
	        wordStack = new Stack<>();
	        HashSet<String> usedWords = new HashSet<>();
	        int numWords = Integer.parseInt(JOptionPane.showInputDialog("Enter number of words to play with:"));

	        while (wordStack.size() < numWords) {
	            String word = Utilities.readRandomLineFromFile("dictionary.txt");
	            if (!usedWords.contains(word)) {
	                wordStack.push(word);
	                usedWords.add(word); 
	            }
	        }
	        
	        createGUI();
	        startNewRound();
	    }

	    private void createGUI() {
	        frame = new JFrame("Hangman Game");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(400, 200);
	        frame.setLayout(new GridLayout(2, 1));

	        wordLabel = new JLabel("", SwingConstants.CENTER);
	        wordLabel.setFont(new Font("Arial", Font.BOLD, 24));
	        frame.add(wordLabel);

	        livesLabel = new JLabel("Lives: " + lives, SwingConstants.CENTER);
	        frame.add(livesLabel);

	        frame.addKeyListener(new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	                processGuess(e.getKeyChar());
	            }
	        });
	        
	        frame.setVisible(true);
	        frame.requestFocus();
	    }

	    private void startNewRound() {
	        if (wordStack.isEmpty()) {
	            JOptionPane.showMessageDialog(frame, "You won! All words solved.");
	            askReplay();
	            return;
	        }
	        
	        currentWord = wordStack.pop();
	        displayedWord = new char[currentWord.length()];
	        for (int i = 0; i < displayedWord.length; i++) {
	            displayedWord[i] = '_';
	        }
	        
	        updateDisplay();
	    }

	    private void processGuess(char guess) {
	        boolean correct = false;
	        for (int i = 0; i < currentWord.length(); i++) {
	            if (currentWord.charAt(i) == guess) {
	                displayedWord[i] = guess;
	                correct = true;
	            }
	        }
	        
	        if (!correct) {
	            lives--;
	            livesLabel.setText("Lives: " + lives);
	        }
	        
	        updateDisplay();
	        checkGameState();
	    }

	    private void updateDisplay() {
	        wordLabel.setText(new String(displayedWord));
	    }

	    private void checkGameState() {
	        if (new String(displayedWord).equals(currentWord)) {
	            JOptionPane.showMessageDialog(frame, "You guessed the word! Moving to the next one.");
	            startNewRound();
	        } else if (lives == 0) {
	            JOptionPane.showMessageDialog(frame, "Game Over! The word was: " + currentWord);
	            askReplay();
	        }
	    }

	    private void askReplay() {
	        int choice = JOptionPane.showConfirmDialog(frame, "Play again?", "Game Over", JOptionPane.YES_NO_OPTION);
	        if (choice == JOptionPane.YES_OPTION) {
	            lives = 6;
	            setupGame();
	        } else {
	            System.exit(0);
	        }
	    }

	    public static void main(String[] args) {
	        new Hangman();
	    }
	} 


