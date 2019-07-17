package visual;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AlgorithmPanel extends JPanel {
	
	private JLabel msg = null;
	private JButton quick = null;
	private JButton sort2 = null;
	private JButton sort3 = null;
	
	public AlgorithmPanel() {
		// TODO Auto-generated constructor stub
	}

	public AlgorithmPanel(MainFrame mf) {
		super();
		
		msg = new JLabel("Z którego algortytmu chcia³byœ skorzystaæ?", JLabel.CENTER);
		msg.setPreferredSize(new Dimension(100, 100));
		msg.setFont(new Font("Verdana", Font.BOLD, 15));
		msg.setOpaque(true);
		
		quick = new JButton("QuickSort");
		quick.setPreferredSize(new Dimension(40, 40));
		quick.addActionListener(mf);
		
		sort2 = new JButton("MergeSort");
		sort2.setPreferredSize(new Dimension(40, 40));
		sort2.addActionListener(mf);
		
		sort3 = new JButton("CombSort");
		sort3.setPreferredSize(new Dimension(40, 40));
		sort3.addActionListener(mf);
		
		this.setLayout(new GridLayout(4,1));
		this.add(msg);
		this.add(quick);
		this.add(sort2);
		this.add(sort3);
	}
}
