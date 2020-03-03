/***********************************************************************
 * Module:  Workspace.java
 * Author:  Bole
 * Purpose: Defines the Class Workspace
 ***********************************************************************/

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

/** @pdOid 9ccc3e43-b293-4cc0-9b77-3d2a88514b28 */
public class Workspace implements Serializable {
	private String name;
	private List<Collection> collections;
	
	public Workspace() {
		this.collections = new ArrayList<Collection>();
	}

	public Workspace(String name) {
		this();
		this.name = name;
	}
	
	public Workspace(String name, List<Collection> collections) {
		this();
		this.name = name;
		this.collections = collections;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Collection> getCollections() {
		return collections;
	}

	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}
	
	
	public void addChilds(DefaultMutableTreeNode root) {
		
		for (Collection c : this.collections) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(c);
			c.addChilds(node);
			root.add(node);
		}
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
