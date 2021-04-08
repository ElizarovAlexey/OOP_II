package individual_work;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IndexOfChar extends JFrame implements ActionListener {
	JLabel labelText;
	JLabel labelChar;
	JTextField someText;
	JTextField someChar;
	public IndexOfChar(String title){
		super(title);
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		labelText = new JLabel("Introduceti un sir");
		container.add(labelText);
		someText = new JTextField(25);
		container.add(someText);
		
		labelChar = new JLabel("Introduceti o litera");
		container.add(labelChar);
		someChar = new JTextField(25);
		container.add(someChar);
		
		JButton resultBtn = new JButton("Rezultat");
		container.add(resultBtn);
		resultBtn.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = someText.getText();
		JOptionPane.showMessageDialog(this,"Posisia literei indicate: " + text.indexOf(someChar.getText()));
	}
}