package com.rentasomething.app;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
 *         This will manage the JPanel that will display all persons that exist in the program.
 */

public class ViewPeoplePanel extends JPanel
{

	public ViewPeoplePanel()
	{
		this.setLayout(new BorderLayout());
		JPanel northPanel = new JPanel();
		JLabel createTitle = new JLabel("VIEW PEOPLE");
		northPanel.add(createTitle);
		JButton deleteButton = new JButton("DELETE");
		northPanel.add(deleteButton);
		this.add(northPanel, BorderLayout.NORTH);
		
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				new DeletePersonDialog();
			}
			
		});

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		int cap = GUI.db.getAllPersons().size();
		String[][] data = new String[cap][3];
		
		for (int i = 0; i < GUI.db.getAllPersons().size(); i++) {
			Person temp = GUI.db.getAllPersons().get(i);
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
