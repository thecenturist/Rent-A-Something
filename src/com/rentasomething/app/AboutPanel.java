package com.rentasomething.app;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
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
 *         This class will manage the JPanel that gives information about the program
 */

public class AboutPanel extends JPanel
{
	public AboutPanel() {
		this.setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel();
		JLabel createTitle = new JLabel("About This Application");
		northPanel.add(createTitle);
		this.add(northPanel, BorderLayout.NORTH);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 2, 5, 18));
		JLabel aboutText = new JLabel("Created by Anjolaoluwa Akinremi and Kaitlyn for the CISC191 Project.");
		aboutText.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(aboutText);
		
		
		this.add(centerPanel, BorderLayout.CENTER);
	}

}
