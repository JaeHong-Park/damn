package draw.conn;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class WriterClass extends Thread {
	private Socket socket;
	private ArrayList<Socket> socketList;
	
	public WriterClass(Socket socket, ArrayList<Socket> socketList) {
		this.socket = socket;
		this.socketList = socketList;
	}
	
	public void sendList() throws IOException{
		SingletonClass scls = SingletonClass.getInstance();
		ObjectOutputStream oos = null;
		
		//send
		for(int i = 0; i < socketList.size(); i++){
			Socket sock = socketList.get(i);
			
			if(sock != this.socket){
				oos = new ObjectOutputStream(sock.getOutputStream());
				oos.writeObject(scls.vc);
			}
		}
		
	//	oos.close();
	}

}
