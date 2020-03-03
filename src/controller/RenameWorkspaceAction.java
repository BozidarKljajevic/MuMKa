package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Collection;
import model.Workspace;
import observer.EventType;

public class RenameWorkspaceAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
		
		
		if (childNodeView == null) {
			return;
		}
		
		String inputName = JOptionPane.showInputDialog("Please enter the new Workspace name:");
		
		if (inputName == "" || inputName == null) {
			return;
		}
		
		Workspace w = (Workspace)childNodeView.getUserObject();
		
		w.setName(inputName);
		
		
		//c.removeObserver(MainFrame.getInstance().getTreeHandler().getTreeModel());
		
		
	}
}
