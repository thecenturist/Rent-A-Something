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
 *         This class will handle the Dialog used to create a Camera Product
 */

public class CreateCameraDialog extends JDialog
{
	public CreateCameraDialog()
	{
		JPanel bottomPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(8, 2, 5, 18));

		this.setTitle("Create Camera");
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

		JLabel mpLabel = new JLabel("   Megapixels:");
		JTextField mpTextField = new JTextField();
		centerPanel.add(mpLabel);
		centerPanel.add(mpTextField);

		JLabel sWidthLabel = new JLabel("   Sensor Width:");
		JTextField sWidthTextField = new JTextField();
		centerPanel.add(sWidthLabel);
		centerPanel.add(sWidthTextField);

		JLabel sLengthLabel = new JLabel("   Sensor Length:");
		JTextField sLengthTextField = new JTextField();
		centerPanel.add(sLengthLabel);
		centerPanel.add(sLengthTextField);

		JLabel sAreaLabel = new JLabel("   Sensor Area:");
		JTextField sAreaTextField = new JTextField();
		centerPanel.add(sAreaLabel);
		centerPanel.add(sAreaTextField);

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
						|| mpTextField.getText().isEmpty()
						|| sWidthTextField.getText().isEmpty()
						|| sLengthTextField.getText().isEmpty()
						|| sAreaTextField.getText().isEmpty())
				{
					new ErrorDialog("Fields cannot be empty");
				}
				else if (ErrorDialog
						.containsNumbers(manTextField.getText()) == true
						|| ErrorDialog
								.containsNumbers(bTextField.getText()) == true
						|| ErrorDialog
								.containsNumbers(moTextField.getText()) == true
						|| ErrorDialog
								.containsLetters(mpTextField.getText()) == true
						|| ErrorDialog.containsLetters(
								sWidthTextField.getText()) == true
						|| ErrorDialog.containsLetters(
								sLengthTextField.getText()) == true
						|| ErrorDialog.containsLetters(
								sAreaTextField.getText()) == true)
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
					Camera camera = new Camera(
							personIdentification
									.get(rnComboBox.getSelectedItem()),
							manTextField.getText(), bTextField.getText(),
							moTextField.getText(),
							Integer.parseInt(mpTextField.getText()),
							Integer.parseInt(sWidthTextField.getText()),
							Integer.parseInt(sLengthTextField.getText()),
							Integer.parseInt(sAreaTextField.getText()));
				}
			}
		});
	}

}
