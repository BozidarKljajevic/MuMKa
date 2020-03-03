package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Collection;
import model.Document;
import model.Page;
import model.Workspace;
import observer.EventType;

public class AddPageAction extends AbstractAction{

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
		
		if (childNodeView == null) {
			return;
		}
		
	
		
		
		if (childNodeView.getUserObject() instanceof Document) {
			Document d = (Document)childNodeView.getUserObject();
			MainFrame.getNumPage().setText(d.getPages().size()+1 + "");
			MainFrame.getDelete().setEnabled(true);
			MainFrame.getPrev().setEnabled(true);
			
			Page newPage = new Page();
			d.getPages().add(newPage);
			MainFrame.InsertInRightPanel(newPage.getPanPage());
			 SwingUtilities.updateComponentTreeUI(MainFrame.getRightPanel());
		}
		
		
	}
}
