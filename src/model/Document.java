/***********************************************************************
 * Module:  Document.java
 * Author:  Bole
 * Purpose: Defines the Class Document
 ***********************************************************************/

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import observer.Observable;
import observer.Observer;

/** @pdOid 44dc3574-5019-4cef-acd3-e803d6226f07 */
public class Document implements Observable,Component, Serializable {
   /** @pdOid e58c88a9-8681-4b5c-9475-1308d7e2320f */
   private String name;
   /** @pdOid 93524939-c0ae-4cd5-9951-66cee2a87a85 */
   private List<Observer> observers = new ArrayList<>();
   /** @pdOid b2275ace-0337-4cff-8a62-2a8a01bf9132 */
   private Collection collection;
 

private List<Page> pages = new ArrayList<>();
   
   public List<Page> getPages() {
	return pages;
}

public void setPages(List<Page> pages) {
	this.pages = pages;
}

/** @pdOid 77c1b23a-6dd0-43ba-849f-11662fa15e35 */
   public Document() {
      // TODO: implement
   }
   
   public Document(String name) {
	   this.name = name;
	   
   }
   
   /** @pdOid dd00e41d-7709-4e0e-a7ff-83a399c778f2 */
   public String getName() {
      return name;
   }
   
   /** @param newName
    * @pdOid 2c3d6642-bda5-4a07-ae33-e159f7a326f3 */
   public void setName(String newName) {
      name = newName;
   }
   
   /** @pdOid f227d378-e0c5-4fbc-a8b3-aba63318ab37 */
   public List<Observer> getObservers() {
      return observers;
   }
   
   /** @param newObservers
    * @pdOid 07d39cc5-8037-445f-9917-c458f860227b */
   public void setObservers(List<Observer> newObservers) {
      observers = newObservers;
   }
   
   /** @pdOid 8095c99d-a336-4153-bcbe-2df53d6642c1 */
   public Collection getCollection() {
      return collection;
   }
   
   /** @param newCollection
    * @pdOid ccee4900-7376-4d7e-8569-fb66ff956bd8 */
   public void setCollection(Collection newCollection) {
      collection = newCollection;
   }
   
   /** @param arg
    * @pdOid 0114db14-670c-4de6-b8fc-bb24a19f34f5 */
   @Override
	public void notifyObservers(Object arg) {
		// TODO Auto-generated method stub
		for (Observer observer : observers) {
			observer.update(this, arg);
		}
	}
   
   @Override
	public String toString() {
		return this.name;
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

	@Override
	public void addChilds(DefaultMutableTreeNode node) {
		// TODO Auto-generated method stub
		
	}
}