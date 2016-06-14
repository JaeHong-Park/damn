package Awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class idsearchAwt extends Frame implements ActionListener, WindowListener {
	GridBagConstraints c ;
	//기본 판넬
	Panel pan = new Panel();
	//라벨
	Label lbname;
	Label lbquestion[] = new Label[2];
	Label lbanswer;
	//텍스트필트
	TextField tfname;
	TextField tfanswer = new TextField();
	//버튼
	Button b_search;
	Button b_confirm = new Button("확인");
	
	public idsearchAwt() {
		super("아이디/비밀번호 찾기");
		
		pan.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		for(int i = 0;i < 5; i++){
			Panel p1 = new Panel();
			c.weightx = 1.0;	
			c.gridx = i;
			c.gridy = 0;
			c.gridwidth = 1;
			pan.add(p1, c);
		}
		
		lbname = new Label("이름 :", Label.CENTER);
		c.insets = new Insets(10, 10, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		//c.gridwidth = 1;
		pan.add(lbname, c);
			
		tfname = new TextField();
		c.insets = new Insets(10, 0, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		//c.gridwidth = 3;
		pan.add(tfname, c);
		
		b_search = new Button("찾기");
		c.insets = new Insets(10, 10, 0, 10);
		c.gridx = 4;
		c.gridy = 1;
		c.gridwidth = 2;
		pan.add(b_search, c);
		
		//찾기 누르면 질문이 나타나게 하기위한 준비
		lbquestion[0] = new Label();
		lbquestion[0].setAlignment(Label.CENTER);
		c.insets = new Insets(10, 10, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		pan.add(lbquestion[0], c);
		
		lbquestion[1] = new Label();
		c.insets = new Insets(10, 0, 0, 0);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 3;
		pan.add(lbquestion[1], c);
		
		lbanswer = new Label();
		lbanswer.setAlignment(Label.CENTER);
		c.insets = new Insets(10, 10, 0, 0);
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		pan.add(lbanswer, c);

		b_confirm.addActionListener(this);
		b_search.addActionListener(this);
		
		setBounds(10, 10, 300, 400);
		setVisible(true);
		//setResizable(false);
		
		add(pan);
		addWindowListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Button btn = (Button)e.getSource();
		String str = btn.getLabel();
		
		if(str.equals("찾기")){
			lbquestion[0].setText("질문 :");
			lbquestion[1].setText("데이터베이스에서 가져 와야 함");
			lbanswer.setText("답변 :");
			//Textfeild
			c.insets = new Insets(10, 0, 0, 0);
			c.gridx = 1;
			c.gridy = 3;
			c.gridwidth = 3;
			pan.add(tfanswer, c);
			//button
			c.gridx = 1;
			c.gridy = 5;
			c.gridwidth = 2;
			pan.add(b_confirm, c);
			
		}else if(str.equals("확인")){
			mainClass.disMessage("입력하신 이메일로 전송되었습니다.");
			dispose();
			new LoginAwt();
		}
	}
	
	@Override
	public void windowActivated(WindowEvent e){
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
