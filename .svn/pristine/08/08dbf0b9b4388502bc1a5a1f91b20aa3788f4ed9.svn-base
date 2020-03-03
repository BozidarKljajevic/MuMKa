/***********************************************************************
 * Module:  CloseAction.java
 * Author:  Bole
 * Purpose: Defines the Class CloseAction
 ***********************************************************************/

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import dialogues.SaveDialogue;

/** @pdOid 0c16cf4e-defd-48dd-ba57-c0f0f18a74b9 */
public class CloseAction extends AbstractAction {
   /** @pdOid 046e27b1-9af2-4ad0-aea8-0396f7956cc6 */
   public CloseAction() {
      // TODO: implement
	   putValue(NAME, ("Close"));
		putValue(ACCELERATOR_KEY, 
				KeyStroke.getKeyStroke(
						KeyEvent.VK_L, 
						KeyEvent.CTRL_MASK));
   }
   
   /** @pdOid 44a1d862-41b2-4eb5-88f8-bd6af830f675 */
   public void actionPerformed(ActionEvent arg0) {
	
      MainFrame.getPanLeft().removeAll();
      MainFrame.getRightPanel().removeAll();
		SwingUtilities.updateComponentTreeUI(MainFrame.getRightPanel());
      SwingUtilities.updateComponentTreeUI(MainFrame.getPanLeft());
   }

}