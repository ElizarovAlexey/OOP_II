package individual_work;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Comparator extends JFrame implements ActionListener {
	JLabel labelText;
	JLabel labelChar;
	JTextField firstString;
	JTextField secondString;
	public Comparator(String title){
		super(title);
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		labelText = new JLabel("Introduceti primul sir");
		container.add(labelText);
		firstString = new JTextField(25);
		container.add(firstString);
		
		labelChar = new JLabel("Introduceti al doilea sir");
		container.add(labelChar);
		secondString = new JTextField(25);
		container.add(secondString);
		
		JButton resultBtn = new JButton("Rezultat");
		container.add(resultBtn);
		resultBtn.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		Учитывая регистр
		
//		if (firstString.getText().equals(secondString.getText())) {
//			JOptionPane.showMessageDialog(this,"Randurile sunt egale");
//		} else {
//			JOptionPane.showMessageDialog(this,"Randurile nu sunt egale");
//		}
		
//		Не учитывая регистр
		if (firstString.getText().equalsIgnoreCase(secondString.getText())) {
			JOptionPane.showMessageDialog(this,"Randurile sunt egale");
		} else {
			JOptionPane.showMessageDialog(this,"Randurile nu sunt egale");
		}
	}
}