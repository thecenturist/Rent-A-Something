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
 * @author Anjolaoluwa Akinremi
 * @author Kaitlyn Nguy
 * 
 *         References:
 *         Version/date: May-12-2024
 * 
 *         Responsibilities of class:
 *         This will handle the JDialog that is used to create a Motorcycle
 *         Product
 */

public class CreateMotorcycleDialog extends JDialog
{
	public CreateMotorcycleDialog()
	{
		JPanel bottomPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(6, 2, 5, 18));

		this.setTitle("Create Motorcycle");
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

		JLabel wLabel = new JLabel("   Weight:");
		JTextField wTextField = new JTextField();
		centerPanel.add(wLabel);
		centerPanel.add(wTextField);

		JLabel poLabel = new JLabel("   Power Output:");
		JTextField poTextField = new JTextField();
		centerPanel.add(poLabel);
		centerPanel.add(poTextField);

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
						|| wTextField.getText().isEmpty()
						|| poTextField.getText().isEmpty())
				{
					new ErrorDialog("Fields cannot be empty");
				}
				else if (ErrorDialog
						.containsNumbers(maTextField.getText()) == true
						|| ErrorDialog
								.containsNumbers(moTextField.getText()) == true
						|| ErrorDialog
								.containsLetters(yTextField.getText()) == true
						|| ErrorDialog.isDecimal(wTextField.getText()) == false
						|| ErrorDialog
								.isDecimal(poTextField.getText()) == false)
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
					Motorcycle motorcycle = new Motorcycle(
							maTextField.getText(), moTextField.getText(),
							Integer.parseInt(yTextField.getText()),
							personIdentification
									.get(rnComboBox.getSelectedItem()),
							Long.parseLong(wTextField.getText()),
							Long.parseLong(poTextField.getText()));
				}
			}
		});

	}

}
