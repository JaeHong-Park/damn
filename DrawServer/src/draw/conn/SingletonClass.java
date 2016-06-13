package draw.conn;

import java.util.Vector;

import draw.dto.drawDTO;

/*
 * singleton
 */

public class SingletonClass {
private static SingletonClass single = null;
	
	public Vector<drawDTO> vc;
	
	private SingletonClass() {
		vc = new Vector<drawDTO>();
	}
	
	public static SingletonClass getInstance(){
		if(single == null){
			single = new SingletonClass();
		}
		return single;
	}
	
	public void displayMessage(String nameSupplied){
		javax.swing.JOptionPane.showMessageDialog(null, nameSupplied);
	}

}
