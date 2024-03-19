package com.rentasomething.app;

/**
 * Lead Author(s):
 * @author Anjolaoluwa Akinremi
 * 
 * References:
 * Version/date: March-17-2024
 * 
 * Responsibilities of class:
 * Model an ActionListener that makes a JDialog visible
 */

import javax.swing.JDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// A DialogListener is-a ActionListener
public class DialogListener implements ActionListener{
    private JDialog dialog; // A DialogListener has-a dialog

    DialogListener(JDialog dialog){
        this.dialog = dialog;
    }

    /**
     * Set the visibility of dialog to true
     * @param event
     */
    @Override
    public void actionPerformed(ActionEvent event){
        this.dialog.setVisible(true);
    }
}
