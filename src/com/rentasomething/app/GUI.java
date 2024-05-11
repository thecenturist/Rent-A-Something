package com.rentasomething.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private static ArrayList<Person> allPersons = new ArrayList<>();
	private static ArrayList<Product> allProducts = new ArrayList<>();
	
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
		JMenuItem viewProductItem = new JMenuItem("Product");
		JMenuItem createProductItem = new JMenuItem("Product");
		JMenuItem aboutItem = new JMenuItem("About");
		createMenu.add(createPersonItem);
		createMenu.add(createProductItem);
		viewMenu.add(viewPeopleItem);
		viewMenu.add(viewProductItem);
		helpMenu.add(aboutItem);
		menuBar.add(createMenu);
		menuBar.add(viewMenu);
		menuBar.add(helpMenu);
		this.setJMenuBar(menuBar);
		
		// ACTION LISTENERS FOR MENU
		createPersonItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				getContentPane().removeAll();
				getContentPane().invalidate();
				getContentPane().add(new CreatePersonPanel(allPersons));
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
				getContentPane().add(new CreateProductPanel(allProducts));
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
				getContentPane().add(new ViewPeoplePanel(allPersons));
				getContentPane().revalidate();
				getContentPane().repaint();
			}
			
		});
		
		viewProductItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().invalidate();
				getContentPane().add(new ViewProductPanel(allProducts));
				getContentPane().revalidate();
				getContentPane().repaint();
			}
		});
		
		aboutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().invalidate();
				getContentPane().add(new AboutPanel());
				getContentPane().revalidate();
				getContentPane().repaint();
			}
		});
		
		this.add(new HomepagePanel());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GUI();
	}
}
