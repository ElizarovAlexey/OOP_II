package individual_work;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;


public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Calculate sum");
        JTextField firstNumber =  new JTextField(16);
        JTextField secondNumber = new JTextField(16);
        JTextField result = new JTextField(16);
        JButton calculateButton = new JButton("Calculate");

        firstNumber.setBounds(25, 20, 250, 30);
        secondNumber.setBounds(25, 70, 250, 30);
        result.setBounds(25, 120, 250, 30);
        calculateButton.setBounds(25, 170, 250, 40);
                
        Border border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray);
        firstNumber.setBorder(border);
        secondNumber.setBorder(border);
        result.setBorder(border);
        calculateButton.setBorder(border);
        calculateButton.setBackground(Color.white);
        
        Font font = new Font("Serif", Font.BOLD, 18);
        firstNumber.setFont(font);
        secondNumber.setFont(font);
        result.setFont(font);
        calculateButton.setFont(font);
        
        result.disable();
        result.setDisabledTextColor(Color.black);

        frame.add(firstNumber);
        frame.add(secondNumber);
        frame.add(result);
        frame.add(calculateButton);

        calculateButton.addActionListener(ae -> {
        	if (firstNumber.getText() != "" && secondNumber.getText() != "") {
      		  int first = Integer.parseInt(firstNumber.getText());
              int second = Integer.parseInt(secondNumber.getText());
              result.setText(first + second + "");
      	  	} else {
      		  result.setText("Input two values in text fields");
      	  	}
        });

        frame.setSize(320, 270);
        frame.setLayout(null);
        frame.setVisible(true);
	}

}