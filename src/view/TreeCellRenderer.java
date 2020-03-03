package view;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.Collection;
import model.Document;
import model.Workspace;



public class TreeCellRenderer extends DefaultTreeCellRenderer{

	private static final long serialVersionUID = 8652394700428406234L;

	public TreeCellRenderer() {
		
	}
	
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

		if (value instanceof DefaultMutableTreeNode) {

			Object node = ((DefaultMutableTreeNode)value).getUserObject();
			
			if (node == null) {
				return this;
			}
			
			String iconPath = null, text = "";
			
			if (node instanceof Workspace) {
				iconPath = "images/workwork.png";
				text = ((Workspace)node).getName();
			} else if (node instanceof Collection) {
				iconPath = "images/coll.png";
				text = ((Collection)node).getName();
			} else if (node instanceof Document) {
				iconPath = "images/doc.jpg";
				text = ((Document)node).getName();
			} 
			
			setIcon(new ImageIcon(iconPath));
			setText(text);
		}

		return this;
	}
}
