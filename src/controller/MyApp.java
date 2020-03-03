/***********************************************************************
 * Module:  MyApp.java
 * Author:  Bole
 * Purpose: Defines the Class MyApp
 ***********************************************************************/

package controller;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.Workspace;

/** Aktiviranje prethodno instalirane izvrÅ¡ne verzije radnog okvira na naÄ�in koji je definisan prilikom njegove instalacije.
 * 
 * @pdOid 9e2f5889-909a-4962-b4e8-4bd6a41b825b */
public class MyApp {
   /** @pdOid 258ebb29-bb5e-4987-8836-a8a2fe9b41ee */
   public static void main(String[] args) {
      
	   String Look = "de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel";
		try {
			UIManager.setLookAndFeel(Look);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MainFrame mFrame = MainFrame.getInstance();
		mFrame.setVisible(true);
	   
   }

}