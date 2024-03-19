package com.rentasomething.app;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// A CreatePersonDialog is-a JDialog
public class CreatePersonDialog extends JDialog
{
	CreatePersonDialog(){
		GridLayout ex = new GridLayout(5,1);
    	this.setLayout(ex);
    	this.setSize(new Dimension(500, 700));
    	this.setResizable(false);
    	
		// First Name Input Panel
    	JPanel firstNamePanel = new JPanel();
    	JLabel firstNameLabel = new JLabel("First Name: ");
    	JTextField firstNameTextField = new JTextField("");
    	firstNameTextField.setPreferredSize(new Dimension(200,25));
    	firstNamePanel.add(firstNameLabel);
    	firstNamePanel.add(firstNameTextField);
    	
		// Last Name Input Panel
    	JPanel lastNamePanel = new JPanel();
    	JLabel lastNameLabel = new JLabel("Last Name: ");
    	JTextField lastNameTextField = new JTextField("");
    	lastNameTextField.setPreferredSize(new Dimension(200,25));
    	lastNamePanel.add(lastNameLabel);
    	lastNamePanel.add(lastNameTextField);
    	
		// Social Security Number Input Panel
    	JPanel ssnPanel = new JPanel();
    	JLabel ssnLabel = new JLabel("SSN: ");
    	JTextField ssnTextField = new JTextField("");
    	ssnTextField.setPreferredSize(new Dimension(200,25));
    	ssnPanel.add(ssnLabel);
    	ssnPanel.add(ssnTextField);

		// Submit Button Panel
        JPanel submitPanel = new JPanel();
        JButton submitButton = new JButton("Create");
        submitPanel.add(submitButton);
    	
    	// Add ActionListener to components
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
				try {
					Integer.parseInt(ssnTextField.getText());
					System.out.println("HERE");
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Enter only numbers", "Problem", JOptionPane.ERROR_MESSAGE);
				}

				if (inputValidation(firstNameTextField.getText(), lastNameTextField.getText(), ssnTextField.getText())){
					Person newPerson = new Person(firstNameTextField.getText(), lastNameTextField.getText(), Integer.parseInt(ssnTextField.getText()));
                	System.out.println(newPerson.toString());
				}
            }
        });
    	
    	// Add components to JDialog
    	this.add(firstNamePanel);
    	this.add(lastNamePanel);
    	this.add(ssnPanel);
        this.add(submitPanel);
    	
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

    boolean inputValidation(String first, String last, String ssn){
		// Ensure no field is empty
		if ((first == "") || (last == "") || (ssn == "")){
			JOptionPane.showMessageDialog(null, "Fields cannot be empty", "Problem", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		// A Social Security Number must be 10 digits
		if (ssn.length() != 10){
			return false;
		}

        return true;
    }
	
}
