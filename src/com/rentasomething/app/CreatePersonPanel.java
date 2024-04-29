package com.rentasomething.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreatePersonPanel extends JPanel
{
	public CreatePersonPanel() {
		this.setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel();
		JLabel createTitle = new JLabel("CREATE NEW PERSON");
		northPanel.add(createTitle);
		this.add(northPanel, BorderLayout.NORTH);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 2, 5, 18));

		JLabel firstName = new JLabel("     First Name: ");
		centerPanel.add(firstName);
		centerPanel.add(new JTextField());

		JLabel lastName = new JLabel("     Last Name: ");
		centerPanel.add(lastName);
		centerPanel.add(new JTextField());

		JLabel ssn = new JLabel("     SSN: ");
		centerPanel.add(ssn);
		centerPanel.add(new JTextField());
		
		this.add(centerPanel, BorderLayout.CENTER);
		
		JPanel southPanel = new JPanel();
		JButton createButton = new JButton("Create");
		createButton.setPreferredSize(new Dimension(100, 50));
		southPanel.add(createButton);
		this.add(southPanel, BorderLayout.SOUTH);
		
	}
}
