/***********************************************************************
 * Module:  OpenWorkspace.java
 * Author:  Damjan
 * Purpose: Defines the Class OpenWorkspace
 ***********************************************************************/

package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

import com.thoughtworks.xstream.XStream;



import model.Document;

import model.Page;
import model.Workspace;
import view.TreeHandler;

/** @pdOid 8d7e7e3d-5d9f-4a59-85cc-2ebf21db0efe */

public class MainFrame extends JFrame {

private static MainFrame instance = new MainFrame();

    private static JButton delete;
    private static JButton prev;
    private static JButton next;
	private static JTextField numPage;
	private static JPanel panLeft;
	
	


	public static JPanel getPanLeft() {
		return panLeft;
	}

	public static void setPanLeft(JPanel panLeft) {
		MainFrame.panLeft = panLeft;
	}

	public static JTextField getNumPage() {
		return numPage;
	}

	public static void setNumPage(JTextField numPage) {
		MainFrame.numPage = numPage;
	}

	private static JPanel rightPanel;

	private Workspace workspace; 
	
	private TreeHandler treeHandler;

	public static MainFrame getInstance() {
		
		return instance;
	}
	
	private MainFrame() {
		
		
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		
		setTitle("MuMKa");
		setSize((int)(screenSize.getWidth()*0.5), (int)(screenSize.getHeight()*0.5));
		setLocationRelativeTo(null);
		
		Image icon = toolkit.getImage("images/mumkanarandzasta.png");
		setIconImage(icon);
		MenuBar menuBar=new MenuBar();
		this.setJMenuBar(menuBar);
		
		setPlugins();
		addWindowListener( new MainFrameListener());
		// tree
		this.treeHandler = new TreeHandler();
		this.workspace = new Workspace("Workspace");
		this.treeHandler.setWorkspace(this.workspace);
		
		this.treeHandler.initTree();
		
		rightPanel = new JPanel();
		//rightPanel.setBackground(Color.black);
		
		numPage = new JTextField("0");
		numPage.setPreferredSize(new Dimension(50, 50));
		numPage.setEnabled(false);
		
		JPanel PanBottom = new  JPanel();
		PanBottom.setPreferredSize(new Dimension(100,100));
		
		this.add(PanBottom,BorderLayout.SOUTH);
		
		PanBottom.setBorder(BorderFactory.createMatteBorder(3, 1, 2, 0, Color.LIGHT_GRAY));
		
		PanBottom.setLayout(new BorderLayout());
		
		JPanel pnlForButton = new JPanel();
        pnlForButton.setBackground(new Color (255,254,182));
        PanBottom.add(pnlForButton,BorderLayout.CENTER);
		
        RemovePageAction removePage = new RemovePageAction();
        
        
         prev = new JButton("Previous");
         next = new JButton("Next");
		
        prev.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int numProvera = Integer.parseInt(MainFrame.getNumPage().getText());
				if( numProvera <= 1) {
					prev.setEnabled(false);
				} else {
					DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
					Object nodeInfo = childNodeView.getUserObject();
					if(nodeInfo instanceof Document) {
					next.setEnabled(true);
					
				// TODO Auto-generated method stub
				
				
				Document c = (Document)childNodeView.getUserObject();
			    int num = Integer.parseInt(MainFrame.getNumPage().getText());
				MainFrame.InsertInRightPanel(c.getPages().get(num-2).getPanPage());
				SwingUtilities.updateComponentTreeUI(MainFrame.getRightPanel());
		    	MainFrame.getNumPage().setText(num-1 + "");
					} else {
						Window parent = SwingUtilities.getWindowAncestor(MainFrame.getInstance());
						JOptionPane.showMessageDialog(parent, "please select the document");
				}
				}
				
			}
		});
        
		
		next.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int numProvera = Integer.parseInt(MainFrame.getNumPage().getText());
				DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
				
				if (childNodeView == null) {
					return;
				} else {
					Object nodeInfo = childNodeView.getUserObject();
					if(nodeInfo instanceof Document) {
				Document c = (Document)childNodeView.getUserObject();
				if( c.getPages().size() == numProvera )
				{
					next.setEnabled(false);
				} else {
					prev.setEnabled(true);
				MainFrame.InsertInRightPanel(c.getPages().get(numProvera).getPanPage());
				SwingUtilities.updateComponentTreeUI(MainFrame.getRightPanel());
		    	MainFrame.getNumPage().setText(numProvera+1 + "");
						}
					}  else {
						Window parent = SwingUtilities.getWindowAncestor(MainFrame.getInstance());
						JOptionPane.showMessageDialog(parent, "please select the document");
				}
				}
				
			}
		});
		//int numProvera = Integer.parseInt(MainFrame.getNumPage().getText());
		 delete = new JButton(removePage);
		delete.setText("Delete");
		if(numPage.getText().equals("0")) {
			delete.setEnabled(false);
		}
		    pnlForButton.add(numPage);
			pnlForButton.add(prev);
			pnlForButton.add(next);
			pnlForButton.add(delete);
		
		
		prev.setPreferredSize(new Dimension(150, 40));
		prev.setFont(new Font("TAHOMA",Font.BOLD,18));
		
		next.setPreferredSize(new Dimension(150, 40));
		next.setFont(new Font("TAHOMA",Font.BOLD,18));
		
		
		delete.setPreferredSize(new Dimension(150, 40));
		delete.setFont(new Font("TAHOMA",Font.BOLD,18));
		panLeft = new JPanel();
		panLeft.add(this.treeHandler.getTree(), BorderLayout.WEST);
			
		JScrollPane scrollPaneLeft = new JScrollPane(panLeft, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JScrollPane scrollPaneRight = new JScrollPane(rightPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		scrollPaneLeft.setMinimumSize(new Dimension(getWidth()/6, getHeight()));
		scrollPaneRight.setMinimumSize(new Dimension(getWidth()/6, getHeight()));
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPaneLeft,scrollPaneRight);
		splitPane.setDividerLocation(getWidth()/3);
		splitPane.setOneTouchExpandable(false);
		
		add(splitPane, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static JButton getPrev() {
		return prev;
	}

	public static void setPrev(JButton prev) {
		MainFrame.prev = prev;
	}

	public static JButton getDelete() {
		return delete;
	}

	public static void setDelete(JButton delete) {
		MainFrame.delete = delete;
	}

	public Workspace getWorkspace() {
		return workspace;
	}

	public void setWorkspace(Workspace workspace) {
		this.workspace = workspace;
	}

	public TreeHandler getTreeHandler() {
		return treeHandler;
	}

	public void setTreeHandler(TreeHandler treeHandler) {
		this.treeHandler = treeHandler;
	}
	public static void InsertInRightPanel(JPanel newPage) {
		rightPanel.removeAll();
		rightPanel.add(newPage,BorderLayout.CENTER);
	}

	public static JPanel getRightPanel() {
		return rightPanel;
	}

	public static void setRightPanel(JPanel rightPanel) {
		MainFrame.rightPanel = rightPanel;
	}
	
	private void setPlugins() {
		File file = new File("./plugins.xml");
		if(file.exists()) {
			InputStream is=null;
			try {
				is=new BufferedInputStream(new FileInputStream(file));
				XStream plugOpen= new XStream();
				List<Boolean> plugins= (List<Boolean>)plugOpen.fromXML(is);
				
				
				MenuBar.getCb1().setSelected(plugins.get(0));
				MenuBar.getCb2().setSelected(plugins.get(1));
				MenuBar.getCb3().setSelected(plugins.get(2));
				MenuBar.getCb4().setSelected(plugins.get(3));
				MenuBar.getCb5().setSelected(plugins.get(4));
			}catch(FileNotFoundException e1){
				e1.printStackTrace();
			}finally {
				try {
					is.close();
				}catch (IOException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			}
		}
	}

}