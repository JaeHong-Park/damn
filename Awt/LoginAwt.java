package Awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class LoginAwt extends Frame implements WindowListener, ActionListener {
	//기본 바탕 판넬
	Panel pan = new Panel();
	// ID/PW 입력 
	TextField tfid = new TextField("아이디");
	TextField tfpw = new TextField("비밀번호");
	//버튼
	Button b_login = new Button("Login") ;
	Button b_join = new Button("회원 가입");
	Button b_search = new Button("아이디 / 비밀번호 찾기");
	
	public LoginAwt() {
		super("로그인");
			
		pan.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		for(int i = 0;i < 5; i++){
			Panel p1 = new Panel();
			c.weightx = 1.0;	
			c.gridx = i;
			c.gridy = 0;
			c.gridwidth = 1;
			pan.add(p1, c);
		}
		
		//TextField("아이디");
		c.insets = new Insets(10, 10, 0, 10);
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 3;
		pan.add(tfid, c);
		
		//TextField("비밀번호");
		c.insets = new Insets(10, 10, 0, 10);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 3;
		pan.add(tfpw, c);
		
		//Button("Login");
		c.gridx = 3;
		c.gridy = 1;
		c.gridwidth = 2;
		c.gridheight = 2;
		pan.add(b_login, c);
		
		//Button("회원가입");
		c.insets = new Insets(10, 10, 0, 0);
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 2;
		c.gridheight = 1;
		pan.add(b_join, c);
		
		//Button("아이디/비밀번호 찾기");
		c.insets = new Insets(10, 10, 0, 10);
		c.gridx = 2;
		c.gridy = 4;
		c.gridwidth = 3;
		c.gridheight = 1;
		pan.add(b_search, c);
		
		b_join.addActionListener(this);
		b_login.addActionListener(this);
		b_search.addActionListener(this);
		
		setBounds(150, 150, 300, 200);
		setVisible(true);
		setResizable(false);
	
		add(pan);
		addWindowListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Button btn = (Button) e.getSource();
		String str = btn.getLabel();
		
		if(str.equals("Login")){
			dispose();
			//게임 화면 등록해야뎀
		}else if(str.equals("회원 가입")){
			dispose();
			new joinAwt();
		}else if(str.equals("아이디 / 비밀번호 찾기")){
			dispose();
			new idsearchAwt();
		}
		

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
