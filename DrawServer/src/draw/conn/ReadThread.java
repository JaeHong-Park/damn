package draw.conn;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

import draw.dto.drawDTO;

public class ReadThread extends Thread {
	
	private Socket socket;	
	private ArrayList<Socket> socketList;
	
	public ReadThread(Socket socket, ArrayList<Socket> socketList) {
		this.socket = socket;
		this.socketList = socketList;
		
		System.out.println("���� IP : " + socket.getInetAddress());
		System.out.println("Port : " + socket.getPort());		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		// ����
		SingletonClass scls = SingletonClass.getInstance();		
		ObjectInputStream ois = null;		// recv		
		
		
		try {
			// ����
			
			
			
			// loop
			while(true){
				// recv				
				try {
					ois = new ObjectInputStream(socket.getInputStream());
					scls.vc = (Vector<drawDTO>)ois.readObject();					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//send
				new WriterClass(socket, socketList).sendList();
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block			
			
		}
	}
}
