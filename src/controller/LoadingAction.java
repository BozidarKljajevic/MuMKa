package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.tree.DefaultTreeModel;

import com.thoughtworks.xstream.XStream;

import model.Collection;
import model.Document;
import model.Page;
import model.Workspace;



public class LoadingAction extends AbstractAction{

	public  LoadingAction() {
		
		
		putValue(NAME, ("open"));
		putValue(SHORT_DESCRIPTION, ("OpenFile"));
		//putValue(SMALL_ICON, new ImageIcon("images/open22x22.png"));
		putValue(ACCELERATOR_KEY, 
				KeyStroke.getKeyStroke(
						KeyEvent.VK_O, 
						KeyEvent.CTRL_MASK));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		JFileChooser jfc = new JFileChooser();
		int returnValue = jfc.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = null;
			String path = jfc.getSelectedFile().getAbsolutePath();
			if (path.length() > 4) {
				if (path.substring(path.length() - 4).equals(".xml")) {
					selectedFile = jfc.getSelectedFile();

				} else {
					return;
				}
			}

			InputStream is = null;

			try {
				is = new BufferedInputStream(new FileInputStream(selectedFile));

				XStream xsOpen = new XStream();
				
				xsOpen.alias("Workspace", Workspace.class);
				xsOpen.alias("Collection", Collection.class);
				xsOpen.alias("Document", Document.class);
				xsOpen.alias("Page", Page.class);

				DefaultTreeModel treeModel = (DefaultTreeModel) xsOpen.fromXML(is);
				JTree tree = MainFrame.getInstance().getTreeHandler().getTree();

				tree.setModel(null);

				MainFrame.getInstance().getTreeHandler().setTreeModel(treeModel);

				tree.setModel(treeModel);

				for (int i = 0; i < tree.getRowCount(); i++) {
					tree.expandRow(i);
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					is.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	
		 }
	}


}
