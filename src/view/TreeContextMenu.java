package view;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTree;

import controller.AddCollectionAction;
import controller.AddDocumentAction;
import controller.AddPageAction;
import controller.ChangeCollectionName;
import controller.ChangeDocumentName;
import controller.RemoveCollectionAction;
import controller.RemoveDocumentAction;
import controller.RenameWorkspaceAction;
import model.Collection;
import model.Document;
import model.Workspace;

public class TreeContextMenu extends JPopupMenu {

	public TreeContextMenu(JTree tree, Object item) {
		if (item instanceof Workspace) {
			JMenuItem addCollection = new JMenuItem("Add collection");
			JMenuItem renameWorkspace = new JMenuItem("Rename workspace");
			
			//lisener treba za ovo
			renameWorkspace.addActionListener(new RenameWorkspaceAction());
			addCollection.addActionListener(new AddCollectionAction());
			
			
			add(addCollection);
			add(renameWorkspace);
		}else if (item instanceof Collection) {
			
			JMenuItem addCollection = new JMenuItem("Add collection");
			JMenuItem changeCollection = new JMenuItem("Change collection");
			JMenuItem removeCollection = new JMenuItem("Remove collection");
			JMenuItem addDocument = new JMenuItem("Add document");
			
			
		
			//lisener treba za ovo
			
			changeCollection.addActionListener(new ChangeCollectionName());
			addCollection.addActionListener(new AddCollectionAction());
			removeCollection.addActionListener(new RemoveCollectionAction());
			addDocument.addActionListener(new AddDocumentAction());
			//changeCollection.addActionListener(new ChangeCollectionListener());
			
			add(addCollection);
			add(changeCollection);
			add(removeCollection);
			add(new JSeparator());
			add(addDocument);
		}else if (item instanceof Document) {
			
			
			JMenuItem changeCollection = new JMenuItem("Change document");
			JMenuItem removeCollection = new JMenuItem("Remove document");
			JMenuItem addPage = new JMenuItem("Add page");
			
			
		
			//lisener treba za ovo
			addPage.addActionListener(new AddPageAction());
			changeCollection.addActionListener(new ChangeDocumentName());
			removeCollection.addActionListener(new RemoveDocumentAction());
			//changeCollection.addActionListener(new ChangeCollectionListener());
			
	
			add(changeCollection);
			add(removeCollection);
			add(addPage);
			add(new JSeparator());

		}
	}
}
