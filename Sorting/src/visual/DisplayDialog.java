package visual;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class DisplayDialog extends JFrame {

	//Niewykorzystane z powodu powolnej pracy
	
	private JTextPane tp = null;
	
	public DisplayDialog(int[] A) {
		super("Sorted Array");
		
		tp = new JTextPane();
		tp.setEditable(false);
		tp.setText(help(A));
		this.add(tp);
		this.add(new JScrollPane(tp));
		
		this.setVisible(true);
		this.setSize(1000, 1000);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	private String help(int[] A) {
		String s = "";
		
		for(int a: A) {
			s+=a+" ";
		}
		
		return s;
	}
}
