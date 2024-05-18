package com.rentasomething.app;

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
	static Database db = new Database(); // A GUI has-a db
	static JMenuBar menuBar = new JMenuBar(); // A GUI has-a menuBar

	public GUI()
	{
		// Set Program Window title and dimension
		this.setTitle("LJC Resort & Housing Rental System");
		this.setSize(1000, 500);

		// Center to screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2,
				dim.height / 2 - this.getSize().height / 2);

		// MENU
		JMenu createMenu = new JMenu("CREATE");
		JMenu viewMenu = new JMenu("VIEW");
		JMenu helpMenu = new JMenu("HELP");
		JMenuItem createPersonItem = new JMenuItem("Person");
		JMenuItem viewPeopleItem = new JMenuItem("People");
		JMenuItem viewProductItem = new JMenuItem("Product");

		JMenu createProductItem = new JMenu("Product");
		JMenu createVehicleProduct = new JMenu("Vehicle");
		JMenu createElectronicProduct = new JMenu("Electronic");

		JMenuItem createCarProduct = new JMenuItem("CAR");
		JMenuItem createBoatProduct = new JMenuItem("BOAT");
		JMenuItem createPhoneProduct = new JMenuItem("PHONE");
		JMenuItem createCameraProduct = new JMenuItem("CAMERA");

		createVehicleProduct.add(createCarProduct);
		createVehicleProduct.add(createBoatProduct);

		createElectronicProduct.add(createPhoneProduct);
		createElectronicProduct.add(createCameraProduct);

		createProductItem.add(createVehicleProduct);
		createProductItem.add(createElectronicProduct);

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
		createPersonItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				getContentPane().removeAll();
				getContentPane().invalidate();
				getContentPane().add(new CreatePersonPanel());
				getContentPane().revalidate();
				getContentPane().repaint();
			}
		});

		createCarProduct.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new CreateCarDialog();
			}
		});

		createBoatProduct.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new CreateBoatDialog();
			}
		});

		createCameraProduct.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new CreateCameraDialog();
			}
		});

		createPhoneProduct.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new CreatePhoneDialog();
			}
		});

		viewPeopleItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				getContentPane().removeAll();
				getContentPane().invalidate();
				getContentPane().add(new ViewPeoplePanel());
				getContentPane().revalidate();
				getContentPane().repaint();
			}

		});

		viewProductItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				getContentPane().removeAll();
				getContentPane().invalidate();
				getContentPane().add(new ViewProductPanel());
				getContentPane().revalidate();
				getContentPane().repaint();
			}
		});

		aboutItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
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

	public static void main(String[] args)
	{
		// Sample People: Do Not Delete
		GUI.db.addPerson(new Person("Anjolaoluwa", "Akinremi", 33L));
		GUI.db.addPerson(new Person("Kendrick", "Rock", 333333L));
		GUI.db.addPerson(new Person("Halleberry", "Hallelujah", 533333L));
		GUI.db.addPerson(new Person("Kaitlyn", "Nguy", 333433L));
		new GUI();
	}
}
