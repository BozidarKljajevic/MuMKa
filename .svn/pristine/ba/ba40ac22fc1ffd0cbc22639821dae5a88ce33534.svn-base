/***********************************************************************
 * Module:  ExitDialogue.java
 * Author:  Bole
 * Purpose: Defines the Class ExitDialogue
 ***********************************************************************/

package dialogues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** @pdOid adb17382-70e8-493f-bf07-f3b5e037dd7f */
public class ExitDialogue extends JDialog {
   /** @pdOid 86e73760-42be-4028-a3c0-5bf201190f24 */
   public ExitDialogue(Frame parent, String naziv, boolean modal) {
      
	   JLabel text = new JLabel("Are you sure you want to exit aplication ?");
		text.setFont(new Font("TAHOMA",Font.BOLD,20));
		text.setBackground(new Color(255,254,182));
		
		JButton btnYes = new JButton("Yes");
		btnYes.setPreferredSize(new Dimension(200, 50));
		btnYes.setBackground(Color.RED);
		btnYes.setForeground(Color.BLUE);
       btnYes.setFont(new Font("TAHOMA",Font.BOLD,20));
		btnYes.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e)
		    {
		       System.exit(0);
		    }
		});
		
		JButton btnNo = new JButton("No");
		btnNo.setPreferredSize(new Dimension(200, 50));
		
		btnNo.setForeground(Color.BLUE);
		btnNo.setBackground(Color.RED);
		btnNo.setFont(new Font("TAHOMA",Font.BOLD,20));
		btnNo.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		       setVisible(false);
		    }
		});
		
		JPanel pnlButton  = new JPanel();
		pnlButton.add(btnYes,BorderLayout.EAST);
		pnlButton.add(btnNo,BorderLayout.WEST);
		add(text, BorderLayout.NORTH);
		add(pnlButton,BorderLayout.CENTER);
		
		setSize(500,150);
		setResizable(false);
		setLocationRelativeTo(parent);
   }

}