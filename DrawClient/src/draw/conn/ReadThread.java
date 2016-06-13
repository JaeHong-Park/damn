package draw.conn;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

import draw.dto.drawDTO;
import draw.window.DrawWindow;

public class ReadThread extends Thread {
	
	private Socket socket;
	private DrawWindow dw;

	public ReadThread(Socket socket, DrawWindow dw) {
		this.socket = socket;
		this.dw = dw;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		// 識情
		ObjectInputStream ois = null;		// recv
		
		try {
			// 持失
			SingletonClass scls = SingletonClass.getInstance();
			
			
			// loop
			while(true){
				// recv				
				try {
					ois = new ObjectInputStream(socket.getInputStream());
					scls.vc = (Vector<drawDTO>)ois.readObject();
					dw.repaint();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
