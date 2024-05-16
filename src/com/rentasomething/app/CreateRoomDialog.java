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
 *         This will handle the Dialog used to create a new Room Product
 */

public class CreateRoomDialog extends JDialog
{
	public CreateRoomDialog()
	{
		JPanel bottomPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(5, 2, 5, 18));

		this.setTitle("Create Room");
		this.setSize(400, 300);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2,
				dim.height / 2 - this.getSize().height / 2);
		this.setLayout(new BorderLayout());

		JLabel rNaLabel = new JLabel("   Renter Name:");
		JComboBox rNaComboBox = new JComboBox(Database.namesArray());
		centerPanel.add(rNaLabel);
		centerPanel.add(rNaComboBox);

		JLabel mcLabel = new JLabel("   Max Capacity:");
		JTextField mcTextField = new JTextField();
		centerPanel.add(mcLabel);
		centerPanel.add(mcTextField);

		JLabel rNuLabel = new JLabel("   Room Number:");
		JTextField rNuTextField = new JTextField();
		centerPanel.add(rNuLabel);
		centerPanel.add(rNuTextField);

		JLabel rpLabel = new JLabel("   Room Price:");
		JTextField rpTextField = new JTextField();
		centerPanel.add(rpLabel);
		centerPanel.add(rpTextField);

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
						|| rNuTextField.getText().isEmpty()
						|| rpTextField.getText().isEmpty())
				{
					new ErrorDialog("Fields cannot be empty");
				}
				else if (ErrorDialog
						.containsLetters(mcTextField.getText()) == true
						|| ErrorDialog
								.containsLetters(rNuTextField.getText()) == true
						|| ErrorDialog
								.containsLetters(rpTextField.getText()) == true)
				{
					new ErrorDialog(
							"Max capacity, apartment number, and apartment price must be integers");
				}
				else
				{
					// TODO: Properly validate that SSN is only numbers, and if
					// not, throw error pop up
					Hashtable<String, Person> personIdentification = Database
							.getNames();
					Room room = new Room(
							personIdentification
									.get(rNaComboBox.getSelectedItem()),
							Integer.parseInt(mcTextField.getText()),
							Integer.parseInt(rNuTextField.getText()),
							Integer.parseInt(rpTextField.getText()));
				}
			}
		});
	}

}
