package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Collection;
import model.Document;
import observer.EventType;

public class ChangeDocumentName extends AbstractAction{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
		
		
		if (childNodeView == null) {
			return;
		}
		
		String inputName = JOptionPane.showInputDialog("Please enter the new collection name:");
		
		if (inputName == "" || inputName == null) {
			return;
		}
		
		Document c = (Document)childNodeView.getUserObject();
		
		DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) childNodeView.getParent();
		
		if (parentNode.getUserObject() instanceof Collection) {
               			
			c.setName(inputName);
		}
		
		//c.removeObserver(MainFrame.getInstance().getTreeHandler().getTreeModel());
		c.notifyObservers(EventType.CHANGED);
		
	}
	
}
