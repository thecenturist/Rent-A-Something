package com.rentasomething.app;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TestView
{
	static String appName = "LJC Resort & Housing Rental System";
	static JMenuBar menuBar = new JMenuBar();
	
	public static void main(String[] args) {
		JFrame mainFrame = new JFrame(appName);
		mainFrame.setLayout(new FlowLayout());
		mainFrame.setSize(1000, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Center the application in the center of the screen on launch
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation(dim.width/2-mainFrame.getSize().width/2, dim.height/2-mainFrame.getSize().height/2);
		
		
		// MENU
		JMenu createMenu = new JMenu("CREATE");
		JMenu viewMenu = new JMenu("VIEW");
		JMenu helpMenu = new JMenu("HELP");
		JMenuItem createPersonItem = new JMenuItem("Person");
		JMenuItem createProductItem = new JMenuItem("Product");
		JMenuItem aboutItem = new JMenuItem("About");
		createMenu.add(createPersonItem);
		createMenu.add(createProductItem);
		helpMenu.add(aboutItem);
		menuBar.add(createMenu);
		menuBar.add(viewMenu);
		menuBar.add(helpMenu);
		mainFrame.setJMenuBar(menuBar);

		createPersonItem.addActionListener(new DialogListener(new CreatePersonDialog()));
		
		JPanel createPersonPanel = new JPanel();
		createPersonPanel.add(new JLabel("Headerish something here"));
		mainFrame.add(createPersonPanel);
		
		JPanel createProductPanel = new JPanel();
		createProductPanel.add(new JLabel("Productish something here"));
		mainFrame.add(createProductPanel);
		
		JButton changeBtn = new JButton("Click");
		mainFrame.add(changeBtn);
		
		changeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				createPersonPanel.setVisible(!createPersonPanel.isVisible());
				createProductPanel.setVisible(!createProductPanel.isVisible());
			}
			
		});
		
		mainFrame.setVisible(true);
		
	}

}
