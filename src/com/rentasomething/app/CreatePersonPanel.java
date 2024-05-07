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

public class CreatePersonPanel extends JPanel
{
	public CreatePersonPanel()
	{
		this.setLayout(new BorderLayout());

		// TODO: Make visual components closer together, and text fields smaller
		// to fit only a name.

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

		createButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (firstNameField.getText().isEmpty()
						|| lastNameField.getText().isEmpty()
						|| ssnField.getText().isEmpty())
				{
					new ErrorDialog("Fields cannot be empty");
				}
				else if (containsLetters(ssnField.getText()) == true)
				{
					new ErrorDialog("SSN must contain numbers");
				}
				else if (containsNumbers(firstNameField.getText()) == true
						|| containsNumbers(lastNameField.getText()) == true)
				{
					new ErrorDialog("Name must contain letters");
				}
				else
				{
					// TODO: Properly validate that SSN is only numbers, and if
					// not, throw error pop up
					Person person = new Person(firstNameField.getText(),
							lastNameField.getText(),
							Long.parseLong(ssnField.getText()));
					// TODO: Save person to database (csv file)
					System.out.println(person.toString());
				}
			}
		});

	}

	private boolean containsNumbers(String str)
	{
		for (int checkChar = 0; checkChar < str.length(); checkChar++)
		{
			for (int number = 0; number < 10; number++)
			{
				if (str.charAt(checkChar) == (char) number)
				{
					return true;
				}
			}
		}
		return false;
	}

	private boolean containsLetters(String str)
	{
		for (int checkChar = 0; checkChar < str.length(); checkChar++)
		{
			// 57 is ASCII value for 9 
			// 48 is ASCII value for 0
			if (str.charAt(checkChar) > 57 || str.charAt(checkChar) < 48)
			{
				return true;
			}
		}
		return false;
	}

}
