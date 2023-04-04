import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGuessingGame extends JFrame implements ActionListener {
    private JTextField textField;
    private JLabel resultLabel;
    private int randomNumber;
    private int guessesLeft;

    public NumberGuessingGame() {
        setTitle("Number Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        randomNumber = (int) (Math.random() * 100) + 1;
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("Guess a number between 1 and 100:"));
        textField = new JTextField(10);
        textField.addActionListener(this);
        inputPanel.add(textField);
        add(inputPanel, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton guessButton = new JButton("Guess");
        guessButton.addActionListener(this);
        buttonPanel.add(guessButton);
        add(buttonPanel, BorderLayout.CENTER);
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout());
        resultLabel = new JLabel("Guesses left: 10");
        resultPanel.add(resultLabel);
        add(resultPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        guessesLeft = 10;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int guess = Integer.parseInt(textField.getText());
            guessesLeft--;

            if (guess == randomNumber) {
                resultLabel.setText("You win!");
                textField.setEditable(false);
            } else if (guessesLeft == 0) {
                resultLabel.setText("You lose! The number was " + randomNumber);
                textField.setEditable(false);
            } else if (guess < randomNumber) {
                resultLabel.setText("Too low! Guesses left: " + guessesLeft);
            } else if (guess > randomNumber) {
                resultLabel.setText("Too high! Guesses left: " + guessesLeft);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        textField.setText("");
        textField.requestFocusInWindow();
    }

    public static void main(String[] args) {
        new NumberGuessingGame();
    }
}
