import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PartA  extends JFrame{
	
	static int WIDTH=480; 
	static int HIGHT=680;
	
	public void init(){
		JTextField textbox= new JTextField();
		textbox.setPreferredSize(new Dimension(40, 15));
		JButton button= new JButton("Enter");
		JPanel panel= new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		
		panel.add(textbox);
		panel.add(button);
		
		this.add(panel);
		
		
	}

	PartA(){
		super("New Project");
		setSize(WIDTH, HIGHT);
		init();
		setVisible(true);
		
		
	}
	

}
