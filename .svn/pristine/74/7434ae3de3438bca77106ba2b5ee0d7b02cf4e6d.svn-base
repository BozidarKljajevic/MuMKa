package controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class MainFrameListener implements WindowListener{

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		
		
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		List<Boolean> plugins= new ArrayList<Boolean>();
		plugins.add(MenuBar.getCb1().isSelected());
		plugins.add(MenuBar.getCb2().isSelected());
		plugins.add(MenuBar.getCb3().isSelected());
		plugins.add(MenuBar.getCb4().isSelected());
		plugins.add(MenuBar.getCb5().isSelected());
		
		File file = new File("./plugins.xml");
		
		OutputStream os=null;
		try {
			os=new BufferedOutputStream(new FileOutputStream(file));
			
			XStream plugSave =new XStream();
			
			plugSave.toXML(plugins,os);
		}catch(IOException e1) {
			e1.printStackTrace();
		}finally {
			try {
				os.close();
			}catch(IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
