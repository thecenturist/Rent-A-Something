package com.rentasomething.app;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.*;

public class TestView
{
	
	static JMenuBar menuBar = new JMenuBar();
	
	public static void main(String[] args) {
		JFrame mainFrame = new JFrame("The Renters Might");
		mainFrame.setLayout(new FlowLayout());
		mainFrame.setSize(1000, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation(dim.width/2-mainFrame.getSize().width/2, dim.height/2-mainFrame.getSize().height/2);
		
		
		
		// MENU
		JMenu createMenu = new JMenu("Create");
		JMenu helpMenu = new JMenu("Help");
		JMenuItem createPersonItem = new JMenuItem("Person");
		JMenuItem createProductItem = new JMenuItem("Product");
		JMenuItem aboutItem = new JMenuItem("About");
		createMenu.add(createPersonItem);
		createMenu.add(createProductItem);
		helpMenu.add(aboutItem);
		menuBar.add(createMenu);
		menuBar.add(helpMenu);
		mainFrame.setJMenuBar(menuBar);
		
		mainFrame.setVisible(true);
		
	}

}
