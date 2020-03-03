package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import model.Workspace;
import view.TreeHandler;

public class AddWorkspaceAction extends AbstractAction {
	
	private Workspace workspace; 
	
	private TreeHandler treeHandler;
	
	 public AddWorkspaceAction() {
	      // TODO: implement
		   putValue(NAME, ("AddWorkspace"));
			putValue(ACCELERATOR_KEY, 
					KeyStroke.getKeyStroke(
							KeyEvent.VK_L, 
							KeyEvent.CTRL_MASK));
	   }
	   
	   /** @pdOid 44a1d862-41b2-4eb5-88f8-bd6af830f675 */
	   public void actionPerformed(ActionEvent arg0) {
		    MainFrame.getPanLeft().removeAll();
			this.treeHandler = new TreeHandler();
			this.workspace = new Workspace("Workspace");
			this.treeHandler.setWorkspace(this.workspace);
			
			this.treeHandler.initTree();
			
			MainFrame.getInstance().setTreeHandler(this.treeHandler);
			MainFrame.getInstance().setWorkspace(this.workspace);
			
			MainFrame.getPanLeft().add(treeHandler.getTree(),BorderLayout.WEST);
			
			SwingUtilities.updateComponentTreeUI(MainFrame.getPanLeft());
	   }
}
