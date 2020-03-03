package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Collection;
import model.Workspace;
import observer.EventType;

public class AddCollectionAction extends AbstractAction {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
		
		if (childNodeView == null) {
			return;
		}
		
		String inputName = JOptionPane.showInputDialog("Please enter the collection name:");
		
		if (inputName == "" || inputName == null) {
			return;
		}
		
		Collection newCollection = new Collection(inputName);
		
		if (childNodeView.getUserObject() instanceof Workspace) {
			
			Workspace ws = (Workspace)childNodeView.getUserObject();
			ws.getCollections().add(newCollection);
			
		} else if (childNodeView.getUserObject() instanceof Collection) {
			
			Collection c = (Collection)childNodeView.getUserObject();
			c.getComponents().add(newCollection);
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(newCollection);

		}
		
		newCollection.addObserver(MainFrame.getInstance().getTreeHandler());
		newCollection.notifyObservers(EventType.ADDED);
	}

}