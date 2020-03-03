package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import dialogues.SaveDialogue;

public class SaveAction  extends AbstractAction{


		public  SaveAction() {
				
				
				putValue(NAME, ("Save"));
				putValue(SHORT_DESCRIPTION, ("Save"));
				//putValue(SMALL_ICON, new ImageIcon("images/save22x22.png"));
				putValue(ACCELERATOR_KEY, 
						KeyStroke.getKeyStroke(
								KeyEvent.VK_S, 
								KeyEvent.CTRL_MASK));
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				
				SaveDialogue dialog = new SaveDialogue(MainFrame.getInstance(), "Save", true);
			
				dialog.setVisible(true);
			
		}

	
}
