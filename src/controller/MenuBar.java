/***********************************************************************
 * Module:  MenuBar.java
 * Author:  Bole
 * Purpose: Defines the Class MenuBar
 ***********************************************************************/

package controller;

import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/** @pdOid fda807f6-fdc5-47d0-a2d4-5ef0f216599e */
public class MenuBar extends JMenuBar {
   /** @pdOid cc1083fa-9c99-4ea6-b58c-f83e41b053da */
	public static JCheckBox cb1;
	public static JCheckBox cb2;
	public static JCheckBox cb3;
	public static JCheckBox cb4;
	public static JCheckBox cb5;
	
   public MenuBar() {
      
	   ExitAction exitAction = new ExitAction();
	   SaveAction saveAction= new SaveAction();
	   LoadingAction loadAction= new LoadingAction();
	   CloseAction closeAction = new CloseAction();
	   AddWorkspaceAction addWorkspace = new AddWorkspaceAction();
	   SearchDocumentAction searchNode= new SearchDocumentAction("");
	   
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		JMenu view = new JMenu("View");
		JMenu plugins= new JMenu("Plugins");
		JMenu search= new JMenu("Search");
		
		JMenuItem src=new JMenuItem(searchNode);
		
		search.add(src);
		
		cb1= new JCheckBox("Video");
	    cb2= new JCheckBox("Audio");
	    cb3= new JCheckBox("Image");
	    cb4= new JCheckBox("Text");
	    cb5= new JCheckBox("Animation");
	   
	    
	    
	    plugins.add(cb4);
	    plugins.add(cb3);
	    plugins.add(cb2);
	    plugins.add(cb1);
	    plugins.add(cb5);
	    
		JMenuItem close = new JMenuItem(closeAction);
		JMenuItem addWork = new JMenuItem(addWorkspace);
		JMenuItem exit =new JMenuItem(exitAction);
		JMenuItem redo =new JMenuItem("Redo");
		JMenuItem undo = new JMenuItem("Undo");
		JMenuItem open = new JMenuItem(loadAction);
		JMenuItem save = new JMenuItem(saveAction);
		
		//JMenuItem saveColection = new JMenuItem("Save colection");
		//JMenuItem saveDocument = new JMenuItem("Save document");
		
		JMenu insert = new JMenu("Insert");
		JMenuItem insertColection = new JMenuItem("Colection");
		JMenuItem insertDocument = new JMenuItem("Document");
		JMenuItem insertPage = new JMenuItem("Page");
		
		JMenuItem delete = new JMenuItem("Delete");
		JMenuItem update = new JMenuItem("Update");
		JMenuItem changeName = new JMenuItem("Change name");
		
		JMenuItem fullScren = new JMenuItem("Full screan");
		
		insert.add(insertColection);
		insert.addSeparator();
		insert.add(insertDocument);
		insert.addSeparator();
		insert.add(insertPage);
		
		edit.add(insert);
		edit.addSeparator();
		edit.add(delete);
		edit.add(update);
		edit.addSeparator();
		edit.add(changeName);
		
		
		file.add(save);
		file.add(open);
		file.addSeparator();
		file.add(close);
		file.add(addWork);
		file.add(exit);
		file.addSeparator();
		file.add(undo);
		file.add(redo);
		
		view.add(fullScren);
		
		add(file);
		add(edit);
		add(view);
		add(help);
		add(plugins);
		add(search);
   }

public static JCheckBox getCb1() {
	return cb1;
}

public static void setCb1(JCheckBox cb1) {
	MenuBar.cb1 = cb1;
}

public static JCheckBox getCb2() {
	return cb2;
}

public static void setCb2(JCheckBox cb2) {
	MenuBar.cb2 = cb2;
}

public static JCheckBox getCb3() {
	return cb3;
}

public static void setCb3(JCheckBox cb3) {
	MenuBar.cb3 = cb3;
}

public static JCheckBox getCb4() {
	return cb4;
}

public static void setCb4(JCheckBox cb4) {
	MenuBar.cb4 = cb4;
}

public static JCheckBox getCb5() {
	return cb5;
}

public static void setCb5(JCheckBox cb5) {
	MenuBar.cb5 = cb5;
}





}