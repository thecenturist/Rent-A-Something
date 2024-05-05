package com.rentasomething.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Lead Author(s):
 * 
 * @author Kaitlyn Nguy
 * @author Anjolaoluwa Akinremi
 * 
 *         References:
 *         Version/date: April-28-2024
 * 
 *         Responsibilities of class:
 *         The Graphical User Interface (Main Program)
 */

public class GUI extends JFrame
{
	static JMenuBar menuBar = new JMenuBar();
	
	public GUI() {
		// Set Program Window title and dimension
		this.setTitle("LJC Resort & Housing Rental System");
		this.setSize(1000, 500);
		
		// Center to screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		// MENU
		JMenu createMenu = new JMenu("CREATE");
		JMenu viewMenu = new JMenu("VIEW");
		JMenu helpMenu = new JMenu("HELP");
		JMenuItem createPersonItem = new JMenuItem("Person");
		JMenuItem viewPeopleItem = new JMenuItem("People");
		JMenuItem createProductItem = new JMenuItem("Product");
		JMenuItem aboutItem = new JMenuItem("About");
		createMenu.add(createPersonItem);
		createMenu.add(createProductItem);
		viewMenu.add(viewPeopleItem);
		helpMenu.add(aboutItem);
		menuBar.add(createMenu);
		menuBar.add(viewMenu);
		menuBar.add(helpMenu);
		this.setJMenuBar(menuBar);
		
		
		CreatePersonPanel np = new CreatePersonPanel();
		CreateProductPanel npp = new CreateProductPanel();
		ViewPeoplePanel vpp = new ViewPeoplePanel();
		
		createPersonItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				getContentPane().removeAll();
				getContentPane().invalidate();
				getContentPane().add(np);
				getContentPane().revalidate();
				getContentPane().repaint();
			}
		});
		
		createProductItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				getContentPane().removeAll();
				getContentPane().invalidate();
				getContentPane().add(npp);
				getContentPane().revalidate();
				getContentPane().repaint();
			}
		});
		
		viewPeopleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				getContentPane().removeAll();
				getContentPane().invalidate();
				getContentPane().add(vpp);
				getContentPane().revalidate();
				getContentPane().repaint();
			}
			
		});
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GUI();
	}
}
