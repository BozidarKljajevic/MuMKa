/***********************************************************************
 * Module:  Page.java
 * Author:  Bole
 * Purpose: Defines the Class Page
 ***********************************************************************/

package model;

import java.awt.Color;
import java.awt.Dimension;
import java.io.Serializable;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import controller.MainFrame;

/** @pdOid 1d70d282-c05c-4899-a65e-1bb90ea79ac4 */
public class Page implements Serializable {
	private JPanel panPage = new JPanel();
	

	public Page() {
		panPage.setPreferredSize(new Dimension(600, 1000));
		panPage.setMaximumSize(new Dimension(500, 1000));
		panPage.setBackground(Color.WHITE);
		panPage.setBorder(BorderFactory.createRaisedBevelBorder());
	}
	
	

	public Page(JPanel panPage, int numPage) {
		super();
		this.panPage = panPage;
		
		
	}

	public JPanel getPanPage() {
		return panPage;
	}

	public void setPanPage(JPanel panPage) {
		this.panPage = panPage;
	}
	
}