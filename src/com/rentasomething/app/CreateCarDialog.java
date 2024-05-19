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
 *         This will handle the JDialog used to create a Car Product
 */

public class CreateCarDialog extends JDialog
{
	public CreateCarDialog()
	{
		JPanel bottomPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(5, 2, 5, 18));

		this.setTitle("Create Car");
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

		JLabel miLabel = new JLabel("   Mileage:");
		JTextField miTextField = new JTextField();
		centerPanel.add(miLabel);
		centerPanel.add(miTextField);

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
				try {
					if (maTextField.getText().isEmpty()
							|| moTextField.getText().isEmpty()
							|| yTextField.getText().isEmpty()
							|| miTextField.getText().isEmpty())
					{
						new ErrorDialog("Fields cannot be empty");
					}
					else
					{
						Hashtable<String, Person> personIdentification = Database
								.getNames();
						Car car = new Car(maTextField.getText(),
								moTextField.getText(),
								Integer.parseInt(yTextField.getText()),
								personIdentification
										.get(rnComboBox.getSelectedItem()),
								Long.parseLong(miTextField.getText()));
						GUI.db.addProduct("vehicle", car);
						dispose();
					}
				} catch (Exception ex) {
					new ErrorDialog("Something went wrong. Try again.");
				}
				
			}
		});

	}

}
