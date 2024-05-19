package com.rentasomething.app;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
	public ViewProductPanel(){
		this.setLayout(new BorderLayout());
		JPanel northPanel = new JPanel();
		JLabel createTitle = new JLabel("VIEW PRODUCTS");
		northPanel.add(createTitle);
		this.add(northPanel, BorderLayout.NORTH);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		int cap = GUI.db.getInventoryCount();
		String[][] data = new String[cap][5];
		
		for (int i = 0; i < cap; i++) {
			Vehicle temp = (Vehicle) GUI.db.getProductForType("vehicle").get(i);
			data[i][0] = temp.getManufacturer();
			data[i][1] = temp.getModel();
			data[i][2] = String.valueOf(temp.getYear());
			data[i][3] = String.valueOf(temp.getRentAmount());
			data[i][4] = String.valueOf(temp.getDiscountPercentage());
		}
		
		String[] columnNames = { "Manufacturer", "Model", "Year", "Rent", "Discount %"};
        JTable j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(j);
        centerPanel.add(sp);
        
		this.add(centerPanel, BorderLayout.CENTER);
	}
}
