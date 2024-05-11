package com.rentasomething.app;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewPeoplePanel extends JPanel
{

	public ViewPeoplePanel(ArrayList<Person> displayPersons)
	{
		this.setLayout(new BorderLayout());

		// TODO: Write GUI code to display all Persons in the database, the rows
		// should include buttons to edit and delete the person. Preferably,
		// when the edit button is pressed, the firstname, lastname, and ssn
		// labels should turn into textfields with the content present for
		// editing.
		JPanel northPanel = new JPanel();
		JLabel createTitle = new JLabel("VIEW PEOPLE");
		northPanel.add(createTitle);
		northPanel.add(new JButton("DELETE"));
		this.add(northPanel, BorderLayout.NORTH);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		int cap = displayPersons.size();
		String[][] data = new String[cap][3];
		
		for (int i = 0; i < displayPersons.size(); i++) {
			Person temp = displayPersons.get(i);
			data[i][0] = temp.getFirstName();
			data[i][1] = temp.getLastName();
			data[i][2] = String.valueOf(temp.getSSN());
		}
		
		String[] columnNames = { "Firstname", "Lastname", "SSN" };
        JTable j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(j);
        centerPanel.add(sp);
        
		this.add(centerPanel, BorderLayout.CENTER);
	}
}
