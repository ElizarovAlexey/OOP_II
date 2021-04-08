package individual_work;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartEndString extends JFrame implements ActionListener {
	JLabel labelText;
	JTextField firstString;
	public StartEndString(String title){
		super(title);
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		labelText = new JLabel("Introduceti sir de caractere");
		container.add(labelText);
		firstString = new JTextField(25);
		container.add(firstString);
		
		JButton resultBtn = new JButton("Rezultat");
		container.add(resultBtn);
		resultBtn.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String mainString = firstString.getText();
		int mainStringLength = mainString.length();
		String startOfString = "He";
		String endOfString = "lo";
		
		if (mainString.substring(0, 2).equals(startOfString) && mainString.substring(mainStringLength - 2, mainStringLength).equals(endOfString)) {
			JOptionPane.showMessageDialog(this,"Inceputul si sfarsitul randului sunt egale cu valorile specificate");
		}
		
		if (mainString.substring(0, 2).equals(startOfString) && mainString.substring(mainStringLength - 2, mainStringLength).equals(endOfString) == false) {
			JOptionPane.showMessageDialog(this,"Numai inceputul este egal cu valoarea specificata");
		}
		
		if (mainString.substring(0, 2).equals(startOfString) == false && mainString.substring(mainStringLength - 2, mainStringLength).equals(endOfString)) {
			JOptionPane.showMessageDialog(this,"Numai sfarsitul este egal cu valoarea specificata");
		}
	}
}