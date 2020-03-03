/***********************************************************************
 * Module:  Collection.java
 * Author:  Bole
 * Purpose: Defines the Class Collection
 ***********************************************************************/

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import observer.Observable;
import observer.Observer;
import view.TreeHandler;

/** @pdOid 9cd96b84-72fb-4a5c-89d8-08fa41011eda */
public class Collection implements Component, Observable,Serializable {

	private String name;
	
	private Workspace workspace;

	private List<Component> components;
	
	private List<Document> documents=new ArrayList<>();
	
	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	private List<Observer> observers = new ArrayList<>(); 
	
	public Collection() {
		this.components = new ArrayList<>();
	}
	
	public Collection(String name) {
		this();
		this.name = name;
		this.components = new ArrayList<>();
	}
	
	public Collection(String name, List<Component> components) {
		this();
		this.name = name;
		this.components = components;
	}
	
	public Workspace getWorkspace() {
		return workspace;
	}

	public void setWorkspace(Workspace workspace) {
		this.workspace = workspace;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Component> getComponents() {
		return components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}
	
	public void addChilds(DefaultMutableTreeNode root) {
		
		for (Component c : this.components) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(c);
			c.addChilds(node);
			root.add(node);
		}
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public void notifyObservers(Object arg) {
		// TODO Auto-generated method stub
		for (Observer observer : observers) {
			observer.update(this, arg);
		}
	}

	@Override
	public void addObserver(Observer observer) {
		// TODO Auto-generated method stub
		this.observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		// TODO Auto-generated method stub
		this.observers.remove(observer);
	}
}