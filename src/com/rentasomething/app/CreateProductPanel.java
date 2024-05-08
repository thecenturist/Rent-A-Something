package com.rentasomething.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class CreateProductPanel extends JPanel
{

	private Hashtable<Integer, JLabel> productTypeOptions;
	private Product product;

	public CreateProductPanel()
	{
		this.setLayout(new BorderLayout());

		JPanel northPanel = new JPanel();
		JLabel createTitle = new JLabel("CREATE NEW PRODUCT");
		northPanel.add(createTitle);
		this.add(northPanel, BorderLayout.NORTH);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 2, 5, 18));

		JLabel rentPerHour = new JLabel("     Rent Per Hour: ");
		JTextField rentPerHourText = new JTextField();
		centerPanel.add(rentPerHour);
		centerPanel.add(rentPerHourText);

		JLabel discountPercentage = new JLabel("     Discount Percentage: ");
		JSlider discountPercentageSlider = new JSlider();
		// TODO: Fix JSlider from having crammed labels
		discountPercentageSlider.setMaximum(40);
		discountPercentageSlider.setMajorTickSpacing(1);
		discountPercentageSlider.setPaintLabels(true);
		centerPanel.add(discountPercentage);
		centerPanel.add(discountPercentageSlider);

		JLabel productType = new JLabel("     Product Type:");
		JSlider productSlider = new JSlider();
		productSlider.setMaximum(2);
		productSlider.setMajorTickSpacing(1);
		productSlider.setPaintLabels(true);

		productTypeOptions = new Hashtable<>();
		productTypeOptions.put(0, new JLabel("Vehicle"));
		productTypeOptions.put(1, new JLabel("Electronic"));
		// TODO: Fix "Lodging" from cutting off from JSlider
		productTypeOptions.put(2, new JLabel("Lodging"));

		productSlider.setLabelTable(productTypeOptions);
		centerPanel.add(productType);
		centerPanel.add(productSlider);

		this.add(centerPanel, BorderLayout.CENTER);

		JPanel southPanel = new JPanel();
		JButton createButton = new JButton("Create");
		createButton.setPreferredSize(new Dimension(100, 50));
		southPanel.add(createButton);
		this.add(southPanel, BorderLayout.SOUTH);

		createButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (rentPerHourText.getText().isEmpty())
				{
					new ErrorDialog("Fields cannot be empty");
				}
				else if (ErrorDialog
						.isDecimal(rentPerHourText.getText()) == false)
				{
					new ErrorDialog(
							"Rent per hour and discount percentage must contain numbers");
				}
				else
				{
					// TODO: Properly validate that SSN is only numbers, and if
					// not, throw error pop up
					// TODO: Save person to database (csv file)
					switch (productSlider.getValue())
					{
						case 0:
							break;
						case 1:
							break;
						case 2:
							break;
					}
					System.out.println(product.toString());
				}
			}
		});

	}

}

}
