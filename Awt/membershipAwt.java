package Awt;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class membershipAwt extends JFrame implements ActionListener, WindowListener {
	//�⺻�ǳ�
	JPanel pan = new JPanel();
	//���̺�
	Label lbtitle;
	Label lbnickname[]= new Label[2];
	Label lbhitrate[] = new Label[2];
	Label lbpoint[] = new Label[2];
	//�̹��� ���̺�
	JLabel image;
	BufferedImage inputimage;
	
	public membershipAwt() throws IOException{
		super("ȸ������");
	
		pan.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		lbtitle = new Label("ȸ������", Label.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		pan.add(lbtitle, c);
		
		inputimage = ImageIO.read(new File("C:\\Users\\User\\Desktop\\image\\man.jpg"));
		image = new JLabel(new ImageIcon(inputimage), JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 4;
		c.gridwidth = 2;
		pan.add(image, c);
				
		lbnickname[0] = new Label("���� :", Label.CENTER);
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		pan.add(lbnickname[0], c);
		
		//������ ���̽����� ������ ������ �;� �Ѵ�.
		lbnickname[1] = new Label("�г���", Label.CENTER);
		c.insets = new Insets(0, 0, 0, 10);
		c.gridx = 3; 
		c.gridy = 2;
		pan.add(lbnickname[1], c);
		
		lbhitrate[0] = new Label("���߷� :", Label.CENTER);
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 1;
		pan.add(lbhitrate[0], c);
		
		//������ ���̽����� ���߷��� ������ �;� �Ѵ�.
		lbhitrate[1] = new Label("���߷�", Label.CENTER);
		c.insets = new Insets(0, 0, 10, 0);
		c.gridx = 3; 
		c.gridy = 3;
		pan.add(lbhitrate[1], c);
		
		lbpoint[0] = new Label("����Ʈ :", Label.CENTER);
		c.gridx = 2;
		c.gridy = 4;
		c.gridwidth = 1;
		pan.add(lbpoint[0], c);
		
		//������ ���̽����� ����Ʈ�� ������ �;� �Ѵ�.
		lbpoint[1] = new Label("����Ʈ", Label.CENTER);
		c.insets = new Insets(0, 0, 10, 0);
		c.gridx = 3; 
		c.gridy = 4;
		pan.add(lbpoint[1], c);
		
		for(int i = 0;i < 5; i++){
			JPanel p1 = new JPanel();
			c.insets = new Insets(10, 0, 0, 0);
			c.weightx = 1.0;	
			c.gridx = i;
			c.gridy = 5;
			c.gridwidth = 1;			
			pan.add(p1, c);
		}
		
		setBounds(150, 150, 300, 200);
		setVisible(true);

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
