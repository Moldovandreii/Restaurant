package presentationLayer;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ChefGUI extends Observer{
	private JFrame frame = new JFrame();
	private JLabel info = new JLabel("Info: ");
	private JTextArea textArea = new JTextArea();
	private JScrollPane textScroll;
	private Subject s;
	private String text = new String();
	//private JButton load = new JButton("LOAD");
	
	public ChefGUI(Subject s) {
		this.s = s;
		frame.setSize(1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel defaultPanel = new JPanel();
		defaultPanel.setLayout(new FlowLayout());
		info.setFont(new Font("Serif", Font.PLAIN, 20));
		textScroll = new JScrollPane(textArea);
		textScroll.setPreferredSize(new Dimension(400,500));
		//load.setPreferredSize(new Dimension(80,30));
		defaultPanel.add(info);
		defaultPanel.add(textScroll);
		//defaultPanel.add(load);
		
		frame.setContentPane(defaultPanel);
		frame.setVisible(true);
	}
	
	/*public void addActionListener(ActionListener load) {
		this.load.addActionListener(load);
	}*/
	
	public void setInfo(String toAdd) {
		this.textArea.setText(toAdd);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		text = text.concat(s.getState() + '\n');
		this.textArea.setText(text);
	}
}
