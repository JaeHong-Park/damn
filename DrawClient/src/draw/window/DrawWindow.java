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

	// ����� ��ư
	private Button btnClear;
	
	// ��ǥ
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
		super("�׸���");
		this.init();
		this.start();
		this.setSize(500,500);
		this.setVisible(true);
	}

	public void init() throws IOException{
		btnClear = new Button("�����");
		this.setLayout(new BorderLayout());
		this.add(btnClear, "South");
		btnClear.addActionListener(this);
		
		timeout = 10000;		
		sockAddr = new InetSocketAddress("211.238.142.191", 9000);		
		socket = new Socket();		
		socket.connect(sockAddr, timeout);
		
		// droawwindow�� �Ѱ��ָ鼭 readThread ����
		new ReadThread(socket, this).start();
	}

	public void start(){
		this.addMouseListener(this);
		this.addMouseMotionListener(this);	
		
		//â�ݱ�
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});		
	}

	public void paint(Graphics g){	
		//���� ���콺�� �巡�׵� ���������� �׸��� ǥ��
		Color c = new Color(0, 0, 0);
		g.setColor(c);	
		g.drawLine(x, y, x1, y1);
		
		SingletonClass scls = SingletonClass.getInstance();
		// Vector�� ����� ������ ���� ǥ��
		for(int i = 0; i < scls.vc.size(); i++){
			drawDTO ddto = (drawDTO) scls.vc.get(i);
			g.drawLine(ddto.getX(), ddto.getY(), ddto.getX1(), ddto.getY1());
		}
	}
	
	public void mouseClicked(MouseEvent e){
	
	}

	//���콺�� ���� ������ ���������� ���
	public void mousePressed(MouseEvent e){
		x = e.getX();
		y = e.getY();
	}

	//���콺�� �� ������ �������� ����Ѵ�. repaint()�޼��带 ȣ���Ͽ� �ٽ� �׸��� �׸���.
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
	* ���콺�� �巡���� ������ �����̴� ���������� �׸��� �׶� �׶� ǥ���Ǿ�� �ϱ� ������
	* �ش� �׸��� �׷��ش�.
	*/
	public void mouseDragged(MouseEvent e){
		x1 = e.getX();
		y1 = e.getY();
		
		//PEN�� ���� �Ǿ����� ��� �������� ���Ϳ� �����Ѵ�.		
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