package visual;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomArrayPanel extends JPanel {

	private JLabel msg = null;
	private JButton yes = null;
	
	public CustomArrayPanel(MainFrame mf) {
		super();
		
		msg = new JLabel("Czy chcia³byœ zmieniæ ci¹g?", JLabel.LEFT);
		msg.setFont(new Font("Verdana", Font.BOLD, 15));
		msg.setOpaque(true);
		
		yes = new JButton("Tak!");
		yes.addActionListener(mf);
		
		this.setLayout(new GridLayout(1,2));
		this.add(msg);
		this.add(yes);
	}
}
