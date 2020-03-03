/***********************************************************************
W * Module:  TreeHandler.java
 * Author:  Bole
 * Purpose: Defines the Class TreeHandler
 ***********************************************************************/

package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import controller.MainFrame;
import model.Collection;
import model.Document;
import model.Workspace;
import observer.EventType;
import observer.Observable;
import observer.Observer;
import view.TreeContextMenu;

public class TreeHandler implements Observer {

	private JTree tree;
	
	private DefaultTreeModel treeModel;
	
	private DefaultMutableTreeNode root;
	
	private Workspace workspace;
	
	public TreeHandler() {}
	
	public TreeHandler(Workspace workspace) {
		this.workspace = workspace;
	}
	
	public TreeHandler(JTree tree, DefaultTreeModel treeModel, 
			DefaultMutableTreeNode root) {
		super();
		this.tree = tree;
		this.treeModel = treeModel;
		this.root = root;
	}

	public void initTree() {	
		
		initData();
		
		this.treeModel = new DefaultTreeModel(this.root);
		this.treeModel.setAsksAllowsChildren(true);
		this.tree = new JTree(treeModel) {

			private static final long serialVersionUID = 2789999619139248302L;

			@Override
			public boolean isPathEditable(TreePath path) {
				return false;
			}
		};
		this.tree.setEditable(true);
		this.tree.setCellRenderer(new TreeCellRenderer());
		expandAllNodes(this.tree, 0, tree.getRowCount());
		this.tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);	
		
		this.tree.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

			    if (SwingUtilities.isRightMouseButton(e)) {

			        int row = tree.getClosestRowForLocation(e.getX(), e.getY());
			        tree.setSelectionRow(row);
			        Object node = ((DefaultMutableTreeNode)tree.getLastSelectedPathComponent()).getUserObject();
			        new TreeContextMenu(tree, node).show(e.getComponent(), e.getX(), e.getY());
			    }
			}
		});
	}
	
	private void initData() {
		this.root = new DefaultMutableTreeNode(this.workspace);
		this.workspace.addChilds(root);
	}
	
	private void expandAllNodes(JTree tree, int startingIndex, int rowCount){
	    for(int i=startingIndex;i<rowCount;++i){
	        tree.expandRow(i);
	    }

	    if(tree.getRowCount()!=rowCount){
	        expandAllNodes(tree, rowCount, tree.getRowCount());
	    }
	}

	public JTree getTree() {
		return tree;
	}

	public void setTree(JTree tree) {
		this.tree = tree;
	}

	public DefaultTreeModel getTreeModel() {
		return treeModel;
	}

	public void setTreeModel(DefaultTreeModel treeModel) {
		this.treeModel = treeModel;
	}

	public Workspace getWorkspace() {
		return workspace;
	}

	public void setWorkspace(Workspace workspace) {
		this.workspace = workspace;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		@SuppressWarnings("unchecked")
		Enumeration<DefaultMutableTreeNode> en = ((DefaultMutableTreeNode) treeModel
				.getRoot()).breadthFirstEnumeration();
		
		if (arg1 == EventType.REMOVED) {
			if (arg0 instanceof Collection) {
				Collection collection = (Collection)arg0;
				
				while (en.hasMoreElements()) {
					DefaultMutableTreeNode curr = en.nextElement();
					if (curr.getUserObject() instanceof Collection && 
							((Collection)curr.getUserObject()).getName().equals(collection.getName())) {
						
						this.treeModel.removeNodeFromParent(curr);
					}
				}
			} else if (arg0 instanceof Document) { 
				Document collection = (Document)arg0;
				
				while (en.hasMoreElements()) {
					DefaultMutableTreeNode curr = en.nextElement();
					if (curr.getUserObject() instanceof Document && 
							((Document)curr.getUserObject()).getName().equals(collection.getName())) {
						
						this.treeModel.removeNodeFromParent(curr);
					}
				}
			}
		} else if (arg1 == EventType.ADDED) {
			if (arg0 instanceof Collection) {
				Collection collection = (Collection)arg0;
				
				DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame
						.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
				
				this.treeModel.insertNodeInto(new DefaultMutableTreeNode(collection), childNodeView, childNodeView.getChildCount());
			}else if(arg0 instanceof Document) {
				Document collection = (Document)arg0;
				
				DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame
						.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
				
				this.treeModel.insertNodeInto(new DefaultMutableTreeNode(collection), childNodeView, childNodeView.getChildCount());
			}
			
		} else if (arg1 == EventType.CHANGED) {
			if (arg0 instanceof Collection) {
				
				DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame
						.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
				
				this.treeModel.nodeChanged(childNodeView);
				//this.treeModel.insertNodeInto(new DefaultMutableTreeNode(collection), childNodeView, childNodeView.getChildCount());
			} else if(arg0 instanceof Document) {
				
				DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame
						.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
				this.treeModel.nodeChanged(childNodeView);
				//this.treeModel.insertNodeInto(new DefaultMutableTreeNode(collection), childNodeView, childNodeView.getChildCount());
			}
		}
	}
}
