package com.rentasomething.app;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

/**
 * Lead Author(s):
 * 
 * @author Anjolaoluwa Akinremi
 * 
 *         References:
 *         Version/date: May-18-2024
 * 
 *         Responsibilities of class:
 *         This will manage the JPanel that will display all products that exist in the program.
 */
public class ViewProductPanel extends JPanel
{
	private int cap;
	private String[][] data;
	private JPanel products, centerPanel;

	public ViewProductPanel(){
		this.setLayout(new BorderLayout());
		JPanel northPanel = new JPanel();
		JLabel createTitle = new JLabel("VIEW PRODUCTS");
		northPanel.add(createTitle);
		this.add(northPanel, BorderLayout.NORTH);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		if(GUI.db.getInventoryCount() > 0) {
			createVehicleTables("boat");
			centerPanel.add(new JLabel("BOATS", SwingConstants.CENTER));
			centerPanel.add(products);
			centerPanel.add(new JLabel(" "));

			createVehicleTables("car");
			centerPanel.add(new JLabel("CARS", SwingConstants.CENTER));
			centerPanel.add(products);
			centerPanel.add(new JLabel(" "));

			createElectronicTables("camera");
			centerPanel.add(new JLabel("CAMERAS", SwingConstants.CENTER));
			centerPanel.add(products);
			centerPanel.add(new JLabel(" "));

			createElectronicTables("phone");
			centerPanel.add(new JLabel("PHONES", SwingConstants.CENTER));
			centerPanel.add(products);
			centerPanel.add(new JLabel(" "));
		}
		else {
			centerPanel.add(new JLabel("NO ITEMS YET"));
		}

        
		this.add(centerPanel, BorderLayout.CENTER);
	}
	private void createVehicleTables(String str) {
		products = new JPanel();
		products.setLayout(new BorderLayout());
		if(GUI.db.getProductForType(str).isEmpty() != true) {
			cap = GUI.db.getProductForType(str).size();
			data = new String[cap][5];
			for (int i = 0; i < cap; i++) {
				Vehicle temp = (Vehicle) GUI.db.getProductForType(str).get(i);
				data[i][0] = temp.getManufacturer();
				data[i][1] = temp.getModel();
				data[i][2] = String.valueOf(temp.getYear());
				data[i][3] = String.valueOf(temp.getRentAmount());
				data[i][4] = String.valueOf(temp.getDiscountPercentage());
			}
			
			String[] columnNames = { "Manufacturer", "Model", "Year", "Rent", "Discount %"};
			products.add(new JScrollPane(new JTable(data, columnNames)));
		}
		else {
			String productType = str.toUpperCase();
			products.add(new JLabel("NO " + productType + " YET", SwingConstants.CENTER));
		}
	}
	private void createElectronicTables(String str) {
		products = new JPanel();
		products.setLayout(new BorderLayout());
		if(GUI.db.getProductForType(str).isEmpty() != true) {
			for (int i = 0; i < cap; i++) {
				Electronic temp = (Electronic) GUI.db.getProductForType(str).get(i);
				data[i][0] = temp.getManufacturer();
				data[i][1] = temp.getBrand();
				data[i][2] = temp.getModel();
				data[i][3] = String.valueOf(temp.getRentAmount());
				data[i][4] = String.valueOf(temp.getDiscountPercentage());
			}
			
			String[] columnNames = { "Manufacturer", "Brand", "Model", "Rent", "Discount %"};
			// JTable j = new JTable(data, columnNames);
			// j.setBounds(30, 40, 200, 300);
			// products.add(new JScrollPane(j));
			products.add(new JScrollPane(new JTable(data, columnNames)));
		}
		else {
			String productType = str.toUpperCase();
			products.add(new JLabel("NO " + productType + " YET", SwingConstants.CENTER));
		}
	}
}
	
