package dialogues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.tree.DefaultTreeModel;

import com.thoughtworks.xstream.XStream;

import controller.MainFrame;
import model.Collection;
import model.Document;
import model.Page;
import model.Workspace;

public class SaveDialogue extends JDialog{


		JTextField  tf;
		String icon;
		
		public SaveDialogue(Frame parent, String title, boolean modal){
			super(parent, title, modal);
				
				setSize(400,200);
				setLocationRelativeTo(parent);
				setResizable(false);
				
				
				JPanel pan = new JPanel();
				JLabel lbl = new JLabel(("SaveName"));
				JLabel lbl1 = new JLabel(("Choose"));
				 tf = new JTextField();
				 JTextField  tfFile = new JTextField();
				tf.setPreferredSize(new Dimension(200,20));
				tfFile.setPreferredSize(new Dimension(200,20));
				JButton btnIzvor = new JButton("---");
				pan.add(lbl1);
				pan.add(tf);
				pan.add(btnIzvor);
				JPanel panName = new JPanel();
				
				panName.add(lbl, BorderLayout.SOUTH);
				panName.add(tfFile, BorderLayout.SOUTH);
				
				JPanel panBtn = new JPanel();
				JButton btnCancel = new JButton(("cancel"));
				btnCancel.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						setVisible(false);
						
					}
				});
				btnIzvor.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						uploadPath();
						
					}
				});
				
				JButton btnOk = new JButton(("ok"));
				btnOk.addActionListener(new ActionListener() { 

					@Override
					public void actionPerformed(ActionEvent e) {
						if(!tfFile.getText().isEmpty()) {
							String fileName = tfFile.getText();
							setVisible(false);
							File f = new File(icon+ "\\" + fileName+".xml");

							DefaultTreeModel treeModel = MainFrame.getInstance().getTreeHandler().getTreeModel();

							OutputStream os = null;
							try {
								os = new BufferedOutputStream(new FileOutputStream(f));

								XStream xsSave = new XStream();

								xsSave.alias("Workspace", Workspace.class);
								xsSave.alias("Collection", Collection.class);
								xsSave.alias("Document", Document.class);
								xsSave.alias("Page", Page.class);
								

								xsSave.toXML(treeModel, os);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} finally {
								try {
									os.close();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
					}
				});
				panBtn.add(btnOk);
				panBtn.add(btnCancel);
				add(pan,BorderLayout.NORTH);
				add(panName,BorderLayout.CENTER);
				add(panBtn,BorderLayout.SOUTH);
			}

			 private void uploadPath() {
					JFileChooser fc = new JFileChooser();
					
					fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
						 icon = new String(fc.getSelectedFile().getAbsolutePath());
						tf.setText(icon);
					}
				}

	
}
