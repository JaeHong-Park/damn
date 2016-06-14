package Awt;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
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

public class joinAwt extends Frame implements ActionListener, WindowListener {
	//�⺻ �ǳ�
	Panel pan = new Panel();
	//��
	Label lbid;
	Label lbidnotice;
	Label lbpw;
	Label lbpwnotice;
	Label lbnickname;
	Label lbemail;
	Label lbsex;
	Label lbrecommend;
	//Text field
	TextField tfid;
	TextField tfpw;
	TextField tfnickname;
	TextField tfemail;
	TextField tfrecommend;
	//checkbox - ���� ���
	CheckboxGroup sex = new CheckboxGroup();
	Checkbox man = new Checkbox("����",sex,true);
	Checkbox woman = new Checkbox("����", sex, false);
	//��ư
	Button b_check1;
	Button b_check2;
	Button b_search;
	Button b_join;
	
	public joinAwt() {
		super("ȸ������");
		setTitle("ȸ������");
		
		pan.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		for(int i = 0;i < 6; i++){
			Panel p1 = new Panel();
			c.insets = new Insets(10, 0, 0, 0);
			c.weightx = 1.0;	
			c.gridx = i;
			c.gridy = 0;
			c.gridwidth = 1;			
			pan.add(p1, c);
		}
		
		lbid = new Label("ID :", Label.CENTER);
		c.insets = new Insets(10, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		pan.add(lbid, c);
			
		tfid = new TextField();
		c.insets = new Insets(10, 10, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 3;
		pan.add(tfid, c);
		
		b_check1 = new Button("ID �ߺ�Ȯ��");
		c.insets = new Insets(10, 10, 0, 10);
		c.gridx = 4;
		c.gridy = 1;
		c.gridwidth = 2;
		pan.add(b_check1, c);
		
		lbidnotice = new Label("�ּ� 4���� �̻� ����");
		c.insets = new Insets(10, 10, 0, 0);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		pan.add(lbidnotice, c);
		
		lbpw = new Label("��й�ȣ :", Label.CENTER);
		c.insets = new Insets(10, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		pan.add(lbpw, c);
		
		tfpw = new TextField();
		c.insets = new Insets(10, 10, 0, 0);
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 3;
		pan.add(tfpw, c);
		
		lbpwnotice = new Label("�ּ� 8~12��, Ư�� ��ȣ(!, @, #, ~, *)����");
		c.insets = new Insets(10, 10, 0, 0);
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		pan.add(lbpwnotice, c);
		
		lbnickname = new Label("���� :", Label.CENTER);
		c.insets = new Insets(10, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		pan.add(lbnickname, c);
		
		tfnickname = new TextField();
		c.insets = new Insets(10, 10, 0, 0);
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 3;
		pan.add(tfnickname, c);
		
		b_check2 = new Button("���� �ߺ�Ȯ��");
		c.insets = new Insets(10, 10, 0, 10);
		c.gridx = 4;
		c.gridy = 5;
		c.gridwidth = 2;
		pan.add(b_check2, c);
		
		lbemail = new Label("e-mail :", Label.CENTER);
		c.insets = new Insets(10, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 1;
		pan.add(lbemail, c);
		
		tfemail = new TextField();
		c.insets = new Insets(10, 10, 0, 0);
		c.gridx = 1;
		c.gridy = 6;
		c.gridwidth = 3;
		pan.add(tfemail, c);
		
		lbsex = new Label("���� :", Label.CENTER);
		c.insets = new Insets(10, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 7;
		c.gridwidth = 1;
		pan.add(lbsex, c);
		
		//���� checkbox
		c.insets = new Insets(10, 10, 0, 0);
		c.gridx = 1;
		c.gridy = 7;
		pan.add(man, c);
		
		c.insets = new Insets(10, 10, 0, 0);
		c.gridx = 2;
		c.gridy = 7;
		pan.add(woman, c);
		
		lbrecommend = new Label("��õ�� :", Label.CENTER);
		c.insets = new Insets(10, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth = 1;
		pan.add(lbrecommend, c);
		
		tfrecommend = new TextField();
		c.insets = new Insets(10, 10, 0, 0);
		c.gridx = 1;
		c.gridy = 8;
		c.gridwidth = 3;
		pan.add(tfrecommend, c);
		
		b_search = new Button("ȸ�� �˻�");
		c.insets = new Insets(10, 10, 0, 10);
		c.gridx = 4;
		c.gridy = 8;
		c.gridwidth = 2;
		pan.add(b_search, c);
		
		b_join = new Button("ȸ������");
		c.insets = new Insets(10, 10, 0, 10);
		c.gridx = 1;
		c.gridy = 10;
		c.gridwidth = 1;
		pan.add(b_join, c);
		
		setBounds(10, 10, 500, 500);
		setVisible(true);
		setResizable(false);
		
		add(pan);
		addWindowListener(this);
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
