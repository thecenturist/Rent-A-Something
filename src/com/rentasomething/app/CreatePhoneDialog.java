package com.rentasomething.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Lead Author(s):
 * 
 * @author Anjolaoluwa Akinremi
 * @author Kaitlyn Nguy
 * 
 *         References:
 *         Version/date: May-12-2024
 * 
 *         Responsibilities of class:
 *         This will handle the Dialog used to create a Phone Product
 */

public class CreatePhoneDialog extends JDialog
{
	public CreatePhoneDialog()
	{
		JPanel bottomPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(7, 2, 5, 18));

		this.setTitle("Create Phone");
		this.setSize(400, 300);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2,
				dim.height / 2 - this.getSize().height / 2);
		this.setLayout(new BorderLayout());

		JLabel rnLabel = new JLabel("   Renter Name:");
		JComboBox rnComboBox = new JComboBox(Database.namesArray());
		centerPanel.add(rnLabel);
		centerPanel.add(rnComboBox);

		JLabel manLabel = new JLabel("   Manufacturer:");
		JTextField manTextField = new JTextField();
		centerPanel.add(manLabel);
		centerPanel.add(manTextField);

		JLabel bLabel = new JLabel("   Brand:");
		JTextField bTextField = new JTextField();
		centerPanel.add(bLabel);
		centerPanel.add(bTextField);

		JLabel moLabel = new JLabel("   Model:");
		JTextField moTextField = new JTextField();
		centerPanel.add(moLabel);
		centerPanel.add(moTextField);

		JLabel massLabel = new JLabel("   Mass:");
		JTextField massTextField = new JTextField();
		centerPanel.add(massLabel);
		centerPanel.add(massTextField);

		JLabel cpuLabel = new JLabel("   CPU:");
		JTextField cpuTextField = new JTextField();
		centerPanel.add(cpuLabel);
		centerPanel.add(cpuTextField);

		JLabel caLabel = new JLabel("   Number of Cameras:");
		JTextField caTextField = new JTextField();
		centerPanel.add(caLabel);
		centerPanel.add(caTextField);

		JButton createButton = new JButton("Create");
		bottomPanel.add(createButton);

		this.add(bottomPanel, BorderLayout.SOUTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.setVisible(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		createButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (manTextField.getText().isEmpty()
						|| bTextField.getText().isEmpty()
						|| moTextField.getText().isEmpty()
						|| massTextField.getText().isEmpty()
						|| cpuTextField.getText().isEmpty()
						|| caTextField.getText().isEmpty())
				{
					new ErrorDialog("Fields cannot be empty");
				}
				else if (ErrorDialog
						.containsNumbers(manTextField.getText()) == true
						|| ErrorDialog
								.containsNumbers(bTextField.getText()) == true
						|| ErrorDialog
								.containsNumbers(moTextField.getText()) == true
						|| ErrorDialog.containsLetters(
								massTextField.getText()) == true
						|| ErrorDialog
								.containsNumbers(cpuTextField.getText()) == true
						|| ErrorDialog
								.containsLetters(caTextField.getText()) == true)
				{
					new ErrorDialog(
							"Field 1, 2, 3, 5 must be Strings. Fields 4, 6 must be an Integer.");
				}
				else
				{
					// TODO: Properly validate that SSN is only numbers, and if
					// not, throw error pop up
					Hashtable<String, Person> personIdentification = Database
							.getNames();
					Phone phone = new Phone(
							personIdentification
									.get(rnComboBox.getSelectedItem()),
							manTextField.getText(), bTextField.getText(),
							moTextField.getText(),
							Integer.parseInt(massTextField.getText()),
							cpuTextField.getText(),
							Integer.parseInt(caTextField.getText()));
				}
			}
		});
	}

}
