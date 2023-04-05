import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
class OnlineTest extends JFrame implements ActionListener {	
	private static final long serialVersionUID = 1L;
	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];
	OnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		//radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}
		if (e.getActionCommand().equals("Result")) {
			if (check())
				count =+1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1:  WHO IS FIRST PRIME MINISTER OF INDIA?");
			radioButton[0].setText("RAJENDRA PRASAD");
			radioButton[1].setText("PANDIT JAWAHARLAL NEHRU");
			radioButton[2].setText("MAHATMA GANDHI");
			radioButton[3].setText("NONE OF THE ABOVE");
		}
		if (current == 1) {
			label.setText("Que2: WHO IS FIRST PRESIDENT OF INDIA?");
			radioButton[0].setText("RAJENDRA PRASAD");
			radioButton[1].setText("PANDIT JAWAHAR LAL NEHRU");
			radioButton[2].setText("MAHATMA GANDHI");
			radioButton[3].setText("NONE OF THE ABOVE");
		}
		if (current == 2) {
			label.setText("Que3: WHOSE PHOTO IS ON INDIAN CURRENCY?");
			radioButton[0].setText("RAJENDRA PRASAD");
			radioButton[1].setText("PANDIT JAWAHAR LAL NEHRU");
			radioButton[2].setText("MAHATMA GANDHI");
			radioButton[3].setText("NONE OF THE ABOVE");
		}
		if (current == 3) {
			label.setText("Que4: WHERE IS THE HEAD QUARTER OF ISRO LOCATED?");
			radioButton[0].setText("BANGLORE");
			radioButton[1].setText("PATNA");
			radioButton[2].setText("AHMEDABAD");
			radioButton[3].setText("NONE OF THE ABOVE");
		}
		if (current == 4) {
			label.setText("Que5:  WHICH IS INDIA'S SMALLEST STATE?");
			radioButton[0].setText(" BIHAR");
			radioButton[1].setText("GOA");
			radioButton[2].setText("ODISHA");
			radioButton[3].setText("NONE OF THE ABOVE");
		}
		if (current == 5) {
			label.setText("Que6: WHO IS THE AUTHOR OF RAMAYAN?");
			radioButton[0].setText("ABHAY");
			radioButton[1].setText("RAM");
			radioButton[2].setText("VALMIKI");
			radioButton[3].setText("NONE OF THE ABOVE");
		}
		if (current == 6) {
			label.setText("Que7:  WWHIC IS INDIA'S BIGGEST STATE?");
			radioButton[0].setText("BIHAR");
			radioButton[1].setText("MAHARASTRA");
			radioButton[2].setText("RAJASTHAN");
			radioButton[3].setText("NONE OF THE ABOVE");
		}
		if (current == 7) {
			label.setText("Que8:  WHICH IS INDIA'S NATIONAL FLOWER?");
			radioButton[0].setText("AGHSJ");
			radioButton[1].setText("SNSB");
			radioButton[2].setText("ABSAC");
			radioButton[3].setText("NONE OF THE ABOVE");
		}
		if (current == 8) {
			label.setText("Que9: WHO HAS THE HIGHEST AUTHORITY IN INDIA?");
			radioButton[0].setText("PRESIDENT");
			radioButton[1].setText("PRIME MINISTER");
			radioButton[2].setText("DEFENCE MINISTER");
			radioButton[3].setText("NONE OF THE ABOVE");
		}
		if (current == 9) {
			label.setText("Que10: HOW IS ALL THE QUESTIONS?");
			radioButton[0].setText("GOOD");
			radioButton[1].setText("BETTER");
			radioButton[2].setText("BEST");
			radioButton[3].setText("BAD");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	boolean check() {
		if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[0].isSelected());
		if (current == 2)
			return (radioButton[3].isSelected());
		if (current == 3)
			return (radioButton[0].isSelected());
		if (current == 4)
			return (radioButton[1].isSelected());
		if (current == 5)
			return (radioButton[2].isSelected());
		if (current == 6)
			return (radioButton[2].isSelected());
		if (current == 7)
			return (radioButton[3].isSelected());
		if (current == 8)
			return (radioButton[0].isSelected());
		if (current == 9)
			return (radioButton[2].isSelected());
		return false;
	}
	public static void main(String s[]) {
		new OnlineTest("Online Test App");
	}
}