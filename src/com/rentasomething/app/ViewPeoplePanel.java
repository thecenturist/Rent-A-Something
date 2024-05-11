package com.rentasomething.app;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewPeoplePanel extends JPanel
{

	public ViewPeoplePanel(ArrayList displayPersons)
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
		this.add(northPanel, BorderLayout.NORTH);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		if (displayPersons.isEmpty() == false)
		{
			for (int person = 0; person < displayPersons.size(); person++)
			{
				JLabel personLabel = new JLabel(
						displayPersons.get(person).toString());
				personLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
				centerPanel.add(personLabel);
			}
		}
		else
		{
			JLabel noPersons = new JLabel("No persons at the time");
			centerPanel.add(noPersons);
		}

		this.add(centerPanel, BorderLayout.CENTER);
	}
}
