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
		JButton deleteButton = new JButton("DELETE");
		northPanel.add(deleteButton);
		this.add(northPanel, BorderLayout.NORTH);
		
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{
//				new DeletePersonDialog(displayPersons);
				JDialog deletePersonDialog = new JDialog();
				deletePersonDialog.setTitle("Delete Person by SSN");
				deletePersonDialog.setSize(400, 100);
				deletePersonDialog.setLayout(new BoxLayout(deletePersonDialog.getContentPane(), BoxLayout.Y_AXIS));
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				deletePersonDialog.setLocation(dim.width / 2 - deletePersonDialog.getSize().width / 2,
						dim.height / 2 - deletePersonDialog.getSize().height / 2);
				
				JPanel subPanel = new JPanel();
				subPanel.setSize(new Dimension(300, 100));
				JLabel jl = new JLabel("Enter SSN:");
				jl.setHorizontalAlignment(SwingConstants.CENTER);
				JTextField ssnField = new JTextField();
				subPanel.add(jl);
				subPanel.add(ssnField);
				JButton deleteSubmitButton = new JButton("Delete");
				ssnField.setSize(new Dimension(100, 50));
				
				deletePersonDialog.add(jl);
				deletePersonDialog.add(ssnField);
//				deletePersonDialog.add(subPanel);
				deletePersonDialog.add(deleteSubmitButton);
				deletePersonDialog.setVisible(true);
				deletePersonDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				
				deleteSubmitButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e)
					{
						Long ssn;
						try {
							if (!displayPersons.isEmpty()) {
								ssn = Long.parseLong(ssnField.getText());
								for (Person p : displayPersons) {
									if (p.getSSN() == ssn) {
										System.out.println("Deleting: " + ssn);
										displayPersons.remove(p);
										deletePersonDialog.dispose();
										revalidate();
										repaint();
									} else {
										new ErrorDialog("There is no person matching that SSN");
									}
									
								}
							} else {
								new ErrorDialog("There are no persons at this time");
							}
							
							
						} catch (NumberFormatException ex) {
							new ErrorDialog("Unable to format SSN");
						}
						
						
						
					}
					
				});
			}
			
		});

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
