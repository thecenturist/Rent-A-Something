package src.com.rentasomething.app;

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
 * @author Kaitlyn Nguy
 * @author Anjolaoluwa Akinremi
 * 
 *         References:
 *         Version/date: May-15-2024
 * 
 *         Responsibilities of class:
 *         This will handle the Dialog that creates a new Apartment
 */

public class CreateApartmentDialog extends JDialog
{
	public CreateApartmentDialog()
	{
		JPanel bottomPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(6, 2, 5, 18));

		this.setTitle("Create Apartment");
		this.setSize(400, 300);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2,
				dim.height / 2 - this.getSize().height / 2);
		this.setLayout(new BorderLayout());

		JLabel rnLabel = new JLabel("   Renter Name:");
		JComboBox rnComboBox = new JComboBox(Database.namesArray());
		centerPanel.add(rnLabel);
		centerPanel.add(rnComboBox);

		JLabel mcLabel = new JLabel("   Max Capacity:");
		JTextField mcTextField = new JTextField();
		centerPanel.add(mcLabel);
		centerPanel.add(mcTextField);

		JLabel anLabel = new JLabel("   Apartment Number:");
		JTextField anTextField = new JTextField();
		centerPanel.add(anLabel);
		centerPanel.add(anTextField);

		JLabel apLabel = new JLabel("   Apartment Price:");
		JTextField apTextField = new JTextField();
		centerPanel.add(apLabel);
		centerPanel.add(apTextField);

		JLabel nBeLabel = new JLabel("   Number of Bedrooms:");
		JTextField nBeTextField = new JTextField();
		centerPanel.add(nBeLabel);
		centerPanel.add(nBeTextField);

		JLabel nBaLabel = new JLabel("   Number of Bathrooms:");
		JTextField nBaTextField = new JTextField();
		centerPanel.add(nBaLabel);
		centerPanel.add(nBaTextField);

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
				if (mcTextField.getText().isEmpty()
						|| anTextField.getText().isEmpty()
						|| apTextField.getText().isEmpty()
						|| nBeTextField.getText().isEmpty()
						|| nBaTextField.getText().isEmpty())
				{
					new ErrorDialog("Fields cannot be empty");
				}
				else if (ErrorDialog
						.containsLetters(mcTextField.getText()) == true
						|| ErrorDialog
								.containsLetters(anTextField.getText()) == true
						|| ErrorDialog
								.containsLetters(apTextField.getText()) == true
						|| ErrorDialog
								.isDecimal(nBeTextField.getText()) == false
						|| ErrorDialog
								.isDecimal(nBaTextField.getText()) == false)
				{
					new ErrorDialog(
							"Field 1, 2, 3 must be integers. Fields 4, 5 must be numbers.");
				}
				else
				{
					// TODO: Properly validate that SSN is only numbers, and if
					// not, throw error pop up
					Hashtable<String, Person> personIdentification = Database
							.getNames();
					Apartment apartment = new Apartment(
							personIdentification
									.get(rnComboBox.getSelectedItem()),
							Integer.parseInt(mcTextField.getText()),
							Integer.parseInt(anTextField.getText()),
							Integer.parseInt(apTextField.getText()),
							Long.parseLong(nBeTextField.getText()),
							Long.parseLong(nBaTextField.getText()));
				}
			}
		});

	}
}
