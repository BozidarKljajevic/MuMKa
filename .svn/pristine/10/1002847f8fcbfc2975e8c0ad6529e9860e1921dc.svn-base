/***********************************************************************
 * Module:  ExitAction.java
 * Author:  Bole
 * Purpose: Defines the Class ExitAction
 ***********************************************************************/

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import dialogues.ExitDialogue;

/** @pdOid 95d4be7f-4679-4286-9a53-b37bc0ab00fd */
public class ExitAction extends AbstractAction  {
   /** @pdOid 01d2c7ca-a89e-4370-babd-90ec7446ec5a */
	
private JFrame parent=null;
/** @pdOid abfda050-fa0f-49d1-8e57-882177adc7aa */
	public ExitAction() {
		
		putValue(NAME, ("Exit"));
		putValue(ACCELERATOR_KEY, 
				KeyStroke.getKeyStroke(
						KeyEvent.VK_E, 
						KeyEvent.CTRL_MASK));
	}
   public void actionPerformed(ActionEvent arg0) {
      // TODO: implement
	   ExitDialogue exit = new ExitDialogue(parent, "Exit" , true);
		exit.setVisible(true);
   }
   
   
   

}