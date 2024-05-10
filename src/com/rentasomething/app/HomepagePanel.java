package com.rentasomething.app;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomepagePanel extends JPanel
{
	public HomepagePanel() {
		// TODO: Design JPanel to be the homepage of the application, it will be shown by default when the program is launched
		
		this.setBackground(new Color(78, 89, 194));
		JLabel label = new JLabel("Welcome to LJC Application");
		
		label.setFont(new Font("Calibri", Font.BOLD, 80));
		label.setForeground(Color.WHITE);
		
		JLabel createdByLabel = new JLabel("Created by:");
		createdByLabel.setForeground(Color.WHITE);
		JLabel kaitlynLabel = new JLabel("Kaitlyn Nguy");
		kaitlynLabel.setForeground(Color.WHITE);
		JLabel ajLabel = new JLabel("Anjolaoluwa 'AJ' Akinremi");
		ajLabel.setForeground(Color.WHITE);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		this.add(label, gbc); //adds in all the labels to panels
		this.add(createdByLabel, gbc);
		this.add(kaitlynLabel, gbc);
		this.add(ajLabel, gbc);
		gbc.insets = new Insets(30, 0, 0, 0);
		
	}

}
