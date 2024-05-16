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
 *         This class will handle the Dialog used to create a Boat product
 */

public class CreateBoatDialog extends JDialog
{
	public CreateBoatDialog()
	{
		JPanel bottomPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(6, 2, 5, 18));

		this.setTitle("Create Boat");
		this.setSize(400, 300);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2,
				dim.height / 2 - this.getSize().height / 2);
		this.setLayout(new BorderLayout());

		JLabel rnLabel = new JLabel("   Renter Name:");
		JComboBox rnComboBox = new JComboBox(Database.namesArray());
		centerPanel.add(rnLabel);
		centerPanel.add(rnComboBox);

		JLabel maLabel = new JLabel("   Manufacturer:");
		JTextField maTextField = new JTextField();
		centerPanel.add(maLabel);
		centerPanel.add(maTextField);

		JLabel moLabel = new JLabel("   Model:");
		JTextField moTextField = new JTextField();
		centerPanel.add(moLabel);
		centerPanel.add(moTextField);

		JLabel yLabel = new JLabel("   Year:");
		JTextField yTextField = new JTextField();
		centerPanel.add(yLabel);
		centerPanel.add(yTextField);

		JLabel lLabel = new JLabel("   Length of Boat:");
		JTextField lTextField = new JTextField();
		centerPanel.add(lLabel);
		centerPanel.add(lTextField);

		JLabel tsLabel = new JLabel("   Top Speed of Boat:");
		JTextField tsTextField = new JTextField();
		centerPanel.add(tsLabel);
		centerPanel.add(tsTextField);

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
				if (maTextField.getText().isEmpty()
						|| moTextField.getText().isEmpty()
						|| yTextField.getText().isEmpty()
						|| lTextField.getText().isEmpty()
						|| tsTextField.getText().isEmpty())
				{
					new ErrorDialog("Fields cannot be empty");
				}
				else if (ErrorDialog
						.containsNumbers(maTextField.getText()) == true
						|| ErrorDialog
								.containsNumbers(moTextField.getText()) == true
						|| ErrorDialog
								.containsLetters(yTextField.getText()) == true
						|| ErrorDialog.isDecimal(lTextField.getText()) == false
						|| ErrorDialog
								.isDecimal(tsTextField.getText()) == false)
				{
					new ErrorDialog(
							"Field 1, 2, must be Strings. Fields 3 must be an Integer. Fields 4, 5 must be numbers.");
				}
				else
				{
					// TODO: Properly validate that SSN is only numbers, and if
					// not, throw error pop up
					Hashtable<String, Person> personIdentification = Database
							.getNames();
					Boat boat = new Boat(maTextField.getText(),
							moTextField.getText(),
							Integer.parseInt(yTextField.getText()),
							personIdentification
									.get(rnComboBox.getSelectedItem()),
							Long.parseLong(lTextField.getText()),
							Long.parseLong(tsTextField.getText()));
				}
			}
		});

	}

}
