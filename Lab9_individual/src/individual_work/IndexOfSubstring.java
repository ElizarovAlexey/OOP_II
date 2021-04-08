package individual_work;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IndexOfSubstring extends JFrame implements ActionListener {
	JLabel labelText;
	JTextField firstString;
	public IndexOfSubstring(String title){
		super(title);
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		labelText = new JLabel("Introduceti un sir");
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
		String text = firstString.getText();
		String[] arr = text.split("-|\\,|\\ |\\.|\\!|\\?");
		
		JOptionPane.showMessageDialog(this,"In sirul " + arr.length + " de cuvinte.");
	}
}