package com.rentasomething.app;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DeletePersonDialog extends JDialog
{
	public DeletePersonDialog() {
		this.setTitle("Delete Person by SSN");
		this.setSize(400, 100);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2,
				dim.height / 2 - this.getSize().height / 2);
		JLabel jl = new JLabel("Delete a person by SSN");
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextField ssnField = new JTextField();
		JButton deleteSubmitButton = new JButton("Delete");
		ssnField.setSize(new Dimension(100, 50));
		
		
		this.add(jl);
		this.add(ssnField);
		this.add(deleteSubmitButton);
		this.setVisible(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		deleteSubmitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Long ssn;
				try {
					if (!GUI.db.getAllPersons().isEmpty()) {
						ssn = Long.parseLong(ssnField.getText());
						for (Person p : GUI.db.getAllPersons()) {
							if (p.getSSN() == ssn) {
								System.out.println("Deleting: " + ssn);
								GUI.db.removePerson(p);
								dispose();
								revalidate();
								repaint();
							} else {
								new ErrorDialog("There is no person matching that SSN");
							}
							
						}
					} else {
						new ErrorDialog("There are no persons at this time");
					}
					
					
				} catch (NumberFormatException ex) {
					new ErrorDialog("Unable to format SSN");
				}
				
				
				
			}
			
		});
	}
}
