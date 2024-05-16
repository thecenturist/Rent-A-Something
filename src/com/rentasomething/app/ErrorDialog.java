package com.rentasomething.app;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Lead Author(s):
 * 
 * @author Kaitlyn Nguy
 * @author Anjolaoluwa Akinremi
 * 
 *         References:
 *         Version/date: May-15-2024
 * 
 *         Responsibilities of class:
 *         Generates error message when something is wrong
 */

public class ErrorDialog extends JDialog
{
	// TODO: Make it so the main window cannot be returned to unless the dialog
	// is closed
	public ErrorDialog(String message)
	{
		this.setTitle("ERROR");
		this.setSize(400, 100);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2,
				dim.height / 2 - this.getSize().height / 2);
		JLabel jl = new JLabel(message);
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(jl);
		this.setVisible(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	public static boolean containsNumbers(String str)
	{
		for (int checkChar = 0; checkChar < str.length(); checkChar++)
		{
			// 57 is ASCII value for 9
			// 48 is ASCII value for 0
			if (str.charAt(checkChar) <= 57 && str.charAt(checkChar) >= 48)
			{
				return true;
			}
		}
		return false;
	}

	public static boolean containsLetters(String str)
	{
		for (int checkChar = 0; checkChar < str.length(); checkChar++)
		{
			// 57 is ASCII value for 9
			// 48 is ASCII value for 0
			if (str.charAt(checkChar) > 57 || str.charAt(checkChar) < 48)
			{
				return true;
			}
		}
		return false;
	}

	public static boolean isDecimal(String str)
	{
		for (int checkChar = 0; checkChar < str.length(); checkChar++)
		{
			// 57 is ASCII value for 9
			// 48 is ASCII value for 0
			// 46 is ASCII value for .
			if (str.charAt(checkChar) > 57 || str.charAt(checkChar) < 48)
			{
				if (str.charAt(checkChar) != 46)
				{
					return false;
				}
			}
		}
		return true;
	}

}
