package controller;

import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Collection;
import model.Document;
import model.Page;
import model.Workspace;
import observer.EventType;

public class RemovePageAction extends AbstractAction {
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
		
		
		if (childNodeView == null) {
			return;
		}
		
		Object nodeInfo = childNodeView.getUserObject();
		
		if(nodeInfo instanceof Document) {
		
		Document c = (Document)childNodeView.getUserObject();
	    int num = Integer.parseInt(MainFrame.getNumPage().getText());
	    c.getPages().remove(num-1);
	    if(c.getPages().size() == 0) {
	    	MainFrame.getDelete().setEnabled(false);
	    	MainFrame.getRightPanel().removeAll();
	    	SwingUtilities.updateComponentTreeUI(MainFrame.getRightPanel());
	    	MainFrame.getNumPage().setText(c.getPages().size() + "");
	    }
	    	else if(c.getPages().size() == num-1) {
		    	MainFrame.InsertInRightPanel(c.getPages().get(num-2).getPanPage());
		    	SwingUtilities.updateComponentTreeUI(MainFrame.getRightPanel());
		    	MainFrame.getNumPage().setText(c.getPages().size() + "");
		    	
		    } 
	     else if(c.getPages().size() != 0) {
	    	MainFrame.InsertInRightPanel(c.getPages().get(num-1).getPanPage());
	    	SwingUtilities.updateComponentTreeUI(MainFrame.getRightPanel());
	    	MainFrame.getNumPage().setText(c.getPages().size() + "");
	    	
	     }
		} else {
			Window parent = SwingUtilities.getWindowAncestor(MainFrame.getInstance());
			JOptionPane.showMessageDialog(parent, "please select the document");
	}
		
		
	}

}
