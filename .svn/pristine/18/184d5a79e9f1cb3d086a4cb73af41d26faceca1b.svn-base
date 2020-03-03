package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import controller.MainFrame;
import model.Collection;
import model.Workspace;
import observer.EventType;
import view.TreeHandler;

public class RemoveCollectionAction extends AbstractAction{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
		
		
		if (childNodeView == null) {
			return;
		}
		
		Collection c = (Collection)childNodeView.getUserObject();
		
		DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) childNodeView.getParent();
		
		if (parentNode.getUserObject() instanceof Workspace) {
			
			((Workspace)parentNode.getUserObject()).getCollections().remove(c);
		} else if (parentNode.getUserObject() instanceof Collection) {
			
			((Collection)parentNode.getUserObject()).getComponents().remove(c);
		}
		
		//c.removeObserver(MainFrame.getInstance().getTreeHandler().getTreeModel());
		c.notifyObservers(EventType.REMOVED);
		
	}
}
