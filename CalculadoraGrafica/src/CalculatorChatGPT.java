import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorChatGPT extends JFrame implements ActionListener {
    private JTextField textField; // O(1)
    private JButton[] numberButtons = new JButton[10]; // O(1)
    private JButton[] functionButtons = new JButton[4]; // O(1)
    private JButton addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton; // O(1)
    private JPanel panel; // O(1)

    private double num1 = 0, num2 = 0, result = 0; // O(1)
    private char operator; // O(1)

    public CalculatorChatGPT() {
        setTitle("Calculadora"); // O(1)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // O(1)
        setSize(300, 400); // O(1)
        setLocationRelativeTo(null); // O(1)

        panel = new JPanel(); // O(1)
        panel.setLayout(new GridLayout(5, 4, 5, 5)); // O(1)

        textField = new JTextField(); // O(1)
        textField.setHorizontalAlignment(JTextField.RIGHT); // O(1)
        textField.setEditable(false); // O(1)

        addButton = new JButton("+"); // O(1)
        subButton = new JButton("-"); // O(1)
        mulButton = new JButton("*"); // O(1)
        divButton = new JButton("/"); // O(1)
        decButton = new JButton("."); // O(1)
        equButton = new JButton("="); // O(1)
        delButton = new JButton("Delete"); // O(1)
        clrButton = new JButton("Clear"); // O(1)

        functionButtons[0] = addButton; // O(1)
        functionButtons[1] = subButton; // O(1)
        functionButtons[2] = mulButton; // O(1)
        functionButtons[3] = divButton; // O(1)

        for (int i = 0; i < 4; i++) { // O(n)
            functionButtons[i].addActionListener(this); // O(1)
            functionButtons[i].setFont(new Font("Arial", Font.PLAIN, 18)); // O(1)
            functionButtons[i].setBackground(Color.GRAY); // O(1)
            functionButtons[i].setForeground(Color.WHITE); // O(1)
        }

        for (int i = 0; i < 10; i++) { // O(n)
            numberButtons[i] = new JButton(String.valueOf(i)); // O(1)
            numberButtons[i].addActionListener(this); // O(1)
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 18)); // O(1)
        }

        decButton.addActionListener(this); // O(1)
        equButton.addActionListener(this); // O(1)
        delButton.addActionListener(this); // O(1)
        clrButton.addActionListener(this); // O(1)

        panel.add(delButton); // O(1)
        panel.add(clrButton); // O(1)
        panel.add(numberButtons[7]); //LINEA DE CODIGO CAMBIADA O(1)
        panel.add(divButton); //LINEA DE CODIGO CAMBIADA O(1)
        panel.add(numberButtons[8]); // O(1)
        panel.add(numberButtons[9]); // O(1)
        panel.add(numberButtons[4]); //LINEA DE CODIGO CAMBIADA O(1)
        panel.add(mulButton); //LINEA DE CODIGO CAMBIADA O(1)
        panel.add(numberButtons[5]); // O(1)
        panel.add(numberButtons[6]); // O(1)
        panel.add(numberButtons[1]); //LINEA DE CODIGO CAMBIADA O(1)
        panel.add(subButton); //LINEA DE CODIGO CAMBIADA O(1)
        panel.add(numberButtons[2]); // O(1)
        panel.add(numberButtons[3]); // O(1)
        panel.add(decButton); //LINEA DE CODIGO CAMBIADA O(1)
        panel.add(addButton); //LINEA DE CODIGO CAMBIADA O(1)
        panel.add(numberButtons[0]); // O(1)
        panel.add(equButton); // O(1)

        add(textField, BorderLayout.NORTH); // O(1)
        add(panel); // O(1)

        setVisible(true); // O(n)
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) { // O(n)
            if (e.getSource() == numberButtons[i]) { // O(1)
                textField.setText(textField.getText().concat(String.valueOf(i))); // O(1)
            }
        }
        if (e.getSource() == decButton) { // O(1)
            textField.setText(textField.getText().concat(".")); // O(1)
        }
        if (e.getSource() == addButton) { // O(1)
            num1 = Double.parseDouble(textField.getText()); // O(1)
            operator = '+'; // O(1)
            textField.setText(""); // O(1)
        }
        if (e.getSource() == subButton) { // O(1)
            num1 = Double.parseDouble(textField.getText()); // O(1)
            operator = '-'; // O(1)
            textField.setText(""); // O(1)
        }
        if (e.getSource() == mulButton) { // O(1)
            num1 = Double.parseDouble(textField.getText()); // O(1)
            operator = '*'; // O(1)
            textField.setText(""); // O(1)
        }
        if (e.getSource() == divButton) { // O(1)
            num1 = Double.parseDouble(textField.getText()); // O(1)
            operator = '/'; // O(1)
            textField.setText(""); // O(1)
        }
        if (e.getSource() == equButton) { // O(1)
            num2 = Double.parseDouble(textField.getText()); // O(1)

            switch (operator) {
                case '+': // O(1)
                    result = num1 + num2; // O(1)
                    break; // O(1)
                case '-': // O(1)
                    result = num1 - num2; // O(1)
                    break; // O(1)
                case '*': // O(1)
                    result = num1 * num2; // O(1)
                    break; // O(1)
                case '/': // O(1)
                    result = num1 / num2; // O(1)
                    break; // O(1)
            }

            textField.setText(String.valueOf(result)); // O(1)
            num1 = result; // O(1)
        }
        if (e.getSource() == clrButton) { // O(1)
            textField.setText(""); // O(1)
        }
        if (e.getSource() == delButton) { // O(1)
            String string = textField.getText(); // O(1)
            textField.setText(""); // O(1)
            for (int i = 0; i < string.length() - 1; i++) {  // O(n)
                textField.setText(textField.getText() + string.charAt(i)); // O(1)
            }
        }
    }

    public static void main(String[] args) {
        new CalculatorChatGPT();  // O(n)
    }
}

// O(n)² = 0n² + 6n + 101