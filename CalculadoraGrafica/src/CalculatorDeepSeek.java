import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorDeepSeek extends JFrame {
    private JTextField textField;                                                            // O(1)

    public CalculatorDeepSeek() {
        // Creación de la ventana principal
        setLayout(new BorderLayout());                                                       // O(1)
        setTitle("Calculadora");                                                             // O(1)

        // Campo de texto para mostrar resultados
        textField = new JTextField();                                                        // O(1)
        add(textField, BorderLayout.NORTH);                                                  // O(1)

        // Panel con los botones de las operaciones aritméticas
        JPanel panel = new JPanel();                                                         // O(1)
        panel.setLayout(new GridLayout(4, 4));                                    // O(1)

        String[] operations = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};  //O(1)
        for (String op : operations) {                                                       // O(n)
            JButton button = new JButton(op);                                                // O(1)
            // Evento para el botón de igual
            if ("=".equals(op)) {                                                            // O(1)
                button.addActionListener(new ActionListener() {                              // O(1)
                    public void actionPerformed(ActionEvent e) {                             // O(1)
                        String text = textField.getText();                                   // O(1)
                        try {
                            int result = calculateResult(text);                              // O(n)
                            textField.setText("" + result);                                  // O(1)
                        } catch (Exception ex) {
                            textField.setText("Error");                                      // O(1)
                        }
                    }
                });
                // Cualquier otro botón
            } else {                                                                         // O(1)
                button.addActionListener(new ActionListener() {                              // O(1)
                    public void actionPerformed(ActionEvent e) {                             // O(1)
                        String currentText = textField.getText();                            // O(1)
                        textField.setText(currentText + op);                                 // O(1)
                    }
                });
            }
            panel.add(button);                                                               // O(1)
        }

        add(panel, BorderLayout.CENTER);                                                     //O(1)

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                      //O(1)
        pack();                                                                              //O(1)
    }

    private int calculateResult(String text) throws Exception {
        //Dividir la expresión en operandos y operadores utilizando expresiones regulares
        String[] parts = text.split("(?<=[-+*/])|(?=[-+*/])");                         // O(1) LINEA DE CODIGO CAMBIADA
        String aStr = parts[0].trim();                                                       // O(1) LINEA DE CODIGO CAMBIADA
        String operator = parts[1].trim();                                                   // O(1) LINEA DE CODIGO CAMBIADA
        String bStr = parts[2].trim();                                                       // O(1) LINEA DE CODIGO CAMBIADA

        //Convertir los operandos a enteros
        int a = Integer.parseInt(aStr);                                                      // O(1)
        int b = Integer.parseInt(bStr);                                                      // O(1)

        //Realizar la operación adecuada según el operador
        switch (operator) {
            case "+":                                                                        // O(1)
                return a + b;                                                                // O(1)
            case "-":                                                                        // O(1)
                return a - b;                                                                // O(1)
            case "*":                                                                        // O(1)
                return a * b;                                                                // O(1)
            case "/":                                                                        // O(1)
                if (b == 0) {                                                                // O(1)
                    throw new ArithmeticException("No se puede dividir por cero.");          // O(1)
                }
                return a / b;                                                                // O(1)
            default:                                                                         // O(1)
                throw new IllegalArgumentException("Operador inválido: " + operator);        // O(1)
        }
    }

    public static void main(String[] args) {
        new CalculatorDeepSeek().setVisible(true);                                                   // O(n)
    }
}

// O(n)² = 0n² + 3n + 42