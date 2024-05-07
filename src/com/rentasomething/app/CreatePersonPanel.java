package com.rentasomething.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Lead Author(s):
 * 
 * @author Kaitlyn Nguy
 * @author Anjolaoluwa Akinremi
 * 
 *         References:
 *         Version/date: April-28-2024
 * 
 *         Responsibilities of class:
 *         This will be a JPanel that deals with the creation of a new Person in the application, including saving the details of the Person created to a database.
 */

public class CreatePersonPanel extends JPanel
{
	public CreatePersonPanel() {
		this.setLayout(new BorderLayout());
		
		// TODO: Make visual components closer together, and text fields smaller to fit only a name.
		
		JPanel northPanel = new JPanel();
		JLabel createTitle = new JLabel("CREATE NEW PERSON");
		northPanel.add(createTitle);
		this.add(northPanel, BorderLayout.NORTH);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 2, 5, 18));

		JLabel firstName = new JLabel("     First Name: ");
		centerPanel.add(firstName);
		JTextField firstNameField = new JTextField();
		centerPanel.add(firstNameField);

		JLabel lastName = new JLabel("     Last Name: ");
		centerPanel.add(lastName);
		JTextField lastNameField = new JTextField();
		centerPanel.add(lastNameField);

		JLabel ssn = new JLabel("     SSN: ");
		centerPanel.add(ssn);
		JTextField ssnField = new JTextField();
		centerPanel.add(ssnField);
		
		this.add(centerPanel, BorderLayout.CENTER);
		
		JPanel southPanel = new JPanel();
		JButton createButton = new JButton("Create");
		createButton.setPreferredSize(new Dimension(100, 50));
		southPanel.add(createButton);
		this.add(southPanel, BorderLayout.SOUTH);
		
		createButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (firstNameField.getText().isEmpty() ||lastNameField.getText().isEmpty() || ssnField.getText().isEmpty()) {
					new ErrorDialog("Fields cannot be empty");
				} else {
					// TODO: Properly validate that SSN is only numbers, and if not, throw error pop up
					Person person = new Person(firstNameField.getText(), lastNameField.getText(), Long.parseLong(ssnField.getText()));
					// TODO: Save person to database (csv file)
					System.out.println(person.toString());	
				}	
			}
		});
		
	}
}
