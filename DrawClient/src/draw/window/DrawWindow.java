package draw.window;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Vector;

import draw.conn.ReadThread;
import draw.conn.SingletonClass;
import draw.conn.WriterClass;
import draw.dto.drawDTO;

public class DrawWindow extends Frame implements MouseListener, MouseMotionListener, ItemListener, ActionListener{

	// 지우기 버튼
	private Button btnClear;
	
	// 좌표
	private int x;
	private int y;
	private int x1;
	private int y1;
	
	// connect
	int timeout;
	InetSocketAddress sockAddr;
	Socket socket;
	InetAddress inetAddr;

	public DrawWindow() throws IOException{
		super("그림판");
		this.init();
		this.start();
		this.setSize(500,500);
		this.setVisible(true);
	}

	public void init() throws IOException{
		btnClear = new Button("지우기");
		this.setLayout(new BorderLayout());
		this.add(btnClear, "South");
		btnClear.addActionListener(this);
		
		timeout = 10000;		
		sockAddr = new InetSocketAddress("211.238.142.191", 9000);		
		socket = new Socket();		
		socket.connect(sockAddr, timeout);
		
		// droawwindow를 넘겨주면서 readThread 실행
		new ReadThread(socket, this).start();
	}

	public void start(){
		this.addMouseListener(this);
		this.addMouseMotionListener(this);	
		
		//창닫기
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});		
	}

	public void paint(Graphics g){	
		//현재 마우스가 드래그된 지점까지의 그림을 표현
		Color c = new Color(0, 0, 0);
		g.setColor(c);	
		g.drawLine(x, y, x1, y1);
		
		SingletonClass scls = SingletonClass.getInstance();
		// Vector에 저장된 내용을 전부 표현
		for(int i = 0; i < scls.vc.size(); i++){
			drawDTO ddto = (drawDTO) scls.vc.get(i);
			g.drawLine(ddto.getX(), ddto.getY(), ddto.getX1(), ddto.getY1());
		}
	}
	
	public void mouseClicked(MouseEvent e){
	
	}

	//마우스를 누른 지점을 시작점으로 등록
	public void mousePressed(MouseEvent e){
		x = e.getX();
		y = e.getY();
	}

	//마우스를 뗀 지점을 끝점으로 등록한다. repaint()메서드를 호출하여 다시 그림을 그린다.
	public void mouseReleased(MouseEvent e){
		x1 = e.getX();
		y1 = e.getY();
		
		SingletonClass scls = SingletonClass.getInstance();
		drawDTO ddto = new drawDTO(x, y, x1, y1);
		scls.vc.add(ddto);
		this.repaint();
		new WriterClass(socket).sendList();
	}

	public void mouseEntered(MouseEvent e){
	
	}

	public void mouseExited(MouseEvent e){
	
	}

	public void mouseMoved(MouseEvent e){
	
	}

	/*
	* 마우스를 드래그할 때에는 움직이는 지점까지의 그림이 그때 그때 표현되어야 하기 때문에
	* 해당 그림을 그려준다.
	*/
	public void mouseDragged(MouseEvent e){
		x1 = e.getX();
		y1 = e.getY();
		
		//PEN이 선택 되었을때 모든 움직임을 벡터에 저장한다.		
		Color c = new Color(0, 0, 0);
		
		SingletonClass scls = SingletonClass.getInstance();
		drawDTO ddto = new drawDTO(x, y, x1, y1);
		scls.vc.add(ddto);
		x = x1;
		y = y1;		
		this.repaint();
		new WriterClass(socket).sendList();
	}

	public void actionPerformed(ActionEvent e){
	
		if (e.getSource() == btnClear){
			
			SingletonClass scls = SingletonClass.getInstance();
			scls.vc.clear();
			x = 0;
			y = 0;
			x1 = 0;
			y1 = 0;
			this.repaint();
			
			new WriterClass(socket).sendList();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}