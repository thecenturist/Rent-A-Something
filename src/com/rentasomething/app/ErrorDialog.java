package com.rentasomething.app;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ErrorDialog extends JDialog
{
	public ErrorDialog(String message) {
		this.setTitle("ERROR");
		this.setSize(400,100);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		JLabel jl = new JLabel(message);
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(jl);
		this.setVisible(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

}
