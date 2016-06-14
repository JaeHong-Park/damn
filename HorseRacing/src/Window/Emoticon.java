package Window;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Emoticon extends JFrame {
	
	JButton btnEmo;
	
	JPanel pnEmoList;
	JScrollPane pnScroll;
	
	Container ct;
	
	public Emoticon() {
		pnEmoList = new JPanel();
		pnEmoList.setLayout(new GridBagLayout());
//		pnEmoList.setPreferredSize(new Dimension(300, 300));
		pnScroll = new JScrollPane(pnEmoList);
		pnScroll.getVerticalScrollBar().setUnitIncrement(10);;	// 스크롤바 속도
		
		ct = getContentPane();
		ct.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		///// 버튼 생성
		c.weightx = 1.0;	// 버튼 가로 크기  ※ 화면 가로 영역 비율에 맞춤
//		c.ipadx = 50;
		c.ipady = 50;		// 버튼 세로 크기
		
		int x = 0, y = 0;
		for (int i = 0; i < 21; i++) {
			btnEmo = new JButton(String.valueOf(i));
			btnEmo.setBorderPainted(false);			// 테두리 숨김
			btnEmo.setContentAreaFilled(false);		// 투명 하이라이트 숨김
			
			if (x <= 2) {
				c.gridx = x;
				c.gridy = y;
				pnEmoList.add(btnEmo, c);
				x++;
			}

			if (x > 2) {
				x = 0;
				y++;
			}
		}
		
		// 버튼 영역
		c.weightx = 1.0;
		c.weighty = 1.0;
		ct.add(pnScroll, c);
		
		// 이모티콘 창 셋팅
		setTitle("이모티콘 선택");
		setBounds(1400, 300, 300, 400);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		// 창 오른쪽 위 'X'버튼 클릭 시 창 닫기
	}
}