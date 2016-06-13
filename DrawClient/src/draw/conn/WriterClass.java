package draw.conn;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class WriterClass extends Thread {
	private Socket socket;
	
	public WriterClass(Socket socket) {
		this.socket = socket;
	}
	
	public void sendList(){
		SingletonClass scls = SingletonClass.getInstance();
		ObjectOutputStream oos = null;
		
		try{			
			oos = new ObjectOutputStream(socket.getOutputStream());			
			System.out.println("º¸³¿");
			// °´Ã¼ Àü¼Û		send
			oos.writeObject(scls.vc);
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
