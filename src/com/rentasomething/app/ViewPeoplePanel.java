package com.rentasomething.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewPeoplePanel extends JPanel
{
	public ViewPeoplePanel() {
		this.setLayout(new BorderLayout());
		
		// TODO: Write GUI code to display all Persons in the database, the rows should include buttons to edit and delete the person. Preferably, when the edit button is pressed, the firstname, lastname, and ssn labels should turn into textfields with the content present for editing.
		JPanel northPanel = new JPanel();
		JLabel createTitle = new JLabel("VIEW PEOPLE");
		northPanel.add(createTitle);
		this.add(northPanel, BorderLayout.NORTH);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 2, 5, 18));

		
		
		this.add(centerPanel, BorderLayout.CENTER);
	}
}
