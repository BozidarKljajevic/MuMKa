package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Enumeration;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class SearchDocumentAction extends AbstractAction{
	
	/**
	 * @param name
	 */
	public SearchDocumentAction(String name) {
		super(name);
		
		putValue(NAME, ("Search"));
		putValue(ACCELERATOR_KEY, 
				KeyStroke.getKeyStroke(
						KeyEvent.VK_F, 
						KeyEvent.CTRL_MASK));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String se = JOptionPane.showInputDialog(MainFrame.getInstance(), "");
		if (se == null) {
			return;
		}

		DefaultTreeModel model = MainFrame.getInstance().getTreeHandler().getTreeModel();

		@SuppressWarnings("unchecked")
		Enumeration<DefaultMutableTreeNode> en = ((DefaultMutableTreeNode) model
				.getRoot()).breadthFirstEnumeration();

		boolean found = false;
		while (en.hasMoreElements()) {
			DefaultMutableTreeNode curr = en.nextElement();
			if (curr.getUserObject().toString().equalsIgnoreCase(se)) {
				MainFrame.getInstance().getTreeHandler().getTree()
						.setSelectionPath(new TreePath(curr.getPath()));
				MainFrame.getInstance().getTreeHandler().getTree()
						.scrollPathToVisible(new TreePath(curr.getPath()));
				found = true;
				break;
			}
		}

		if (!found) {
			JOptionPane.showMessageDialog(MainFrame.getInstance(),("NotFound"), "", JOptionPane.WARNING_MESSAGE);

		}

	}

}
