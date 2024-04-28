package com.rentasomething.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Lead Author(s):
 * 
 * @author Kaitlyn Nguy
 * 
 *         References:
 *         Version/date: April-27-2024
 * 
 *         Responsibilities of class:
 *         Catalog GUI (main screen)
 */

public class Catalog extends JFrame
{
	public Catalog()
	{
		this.setPreferredSize(new Dimension(400, 250));
		this.setLayout(new BorderLayout());
		this.setTitle("LJC Resort and Housing Rental System");

		JPanel northPanel = new JPanel();
		JLabel createTitle = new JLabel("Create New Person");
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

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new Catalog();
	}
}
