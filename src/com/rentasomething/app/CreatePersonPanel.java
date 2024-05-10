package com.rentasomething.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CreatePersonPanel extends JPanel
{

	private static ArrayList<Person> allPersons = new ArrayList<>();

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
				else if (ErrorDialog
						.containsLetters(ssnField.getText()) == true)
				{
					new ErrorDialog("SSN must contain numbers");
				}
				else if (ErrorDialog
						.containsNumbers(firstNameField.getText()) == true
						|| ErrorDialog.containsNumbers(
								lastNameField.getText()) == true)
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
					JDialog jd = new JDialog();
					jd.setTitle("SUCCESS");
					jd.setSize(400, 100);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					jd.setLocation(dim.width / 2 - jd.getSize().width / 2,
							dim.height / 2 - jd.getSize().height / 2);
					JLabel jl = new JLabel("Person created successfully");
					jl.setHorizontalAlignment(SwingConstants.CENTER);
					jd.add(jl);
					jd.setVisible(true);
					jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					firstNameField.setText("");
					lastNameField.setText("");
					ssnField.setText("");
					// TODO: Save person to database (csv file)
					allPersons.add(person);
				}
			}
		});

	}

	public static ArrayList<Person> getAllPersons()
	{
		try
		{
			return allPersons;
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

}
