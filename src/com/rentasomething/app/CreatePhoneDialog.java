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
import javax.swing.SwingConstants;

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
				try {
					if (manTextField.getText().isEmpty()
					|| bTextField.getText().isEmpty()
					|| moTextField.getText().isEmpty()
					|| massTextField.getText().isEmpty()
					|| cpuTextField.getText().isEmpty()
					|| caTextField.getText().isEmpty())
					{
						new ErrorDialog("Fields cannot be empty");
					}
					else if(ErrorDialog.containsLetters(
						massTextField.getText()) == true
					|| ErrorDialog
							.containsLetters(caTextField.getText()) == true) {
						new ErrorDialog("Fields 4,6 must be an integer");
					}
					else
					{
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
						JDialog jd = new JDialog();
						jd.setTitle("SUCCESS");
						jd.setSize(400, 100);
						Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
						jd.setLocation(dim.width / 2 - jd.getSize().width / 2,
								dim.height / 2 - jd.getSize().height / 2);
						JLabel jl = new JLabel("Phone created successfully");
						jl.setHorizontalAlignment(SwingConstants.CENTER);
						jd.add(jl);
						jd.setVisible(true);
						jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						GUI.db.addProduct("phone", phone);
						dispose();
					}
				} catch (Exception ex) {
					new ErrorDialog("Something went wrong. Try again.");
					ex.printStackTrace();
				}
			}
		});
	}

}
