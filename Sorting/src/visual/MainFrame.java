package visual;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sorting.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements ActionListener {

	private int[] test = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10, 0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
	private JButton see = null;
	
	public MainFrame() throws HeadlessException {
		super("Sort-Station");
		// TODO Auto-generated constructor stub
		
		see = new JButton("Podejrzyj ci¹g");
		see.addActionListener(this);
		
		this.getContentPane().add(new AlgorithmPanel(this));
		this.getContentPane().add(new CustomArrayPanel(this), BorderLayout.PAGE_START);
		this.getContentPane().add(see, BorderLayout.PAGE_END);
		
		this.setVisible(true);
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	
	public int[] getTest() {
		return test;
	}
	
	public void setTest(int[] A) {
		test = A;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		long start = 0;
		long end = 0;
		
		if(e.getActionCommand().equals("QuickSort")) {
			System.out.println("Started: "+java.time.LocalTime.now());
			//start = System.currentTimeMillis();
			Sorting.QuickSort2(test);
			//end = System.currentTimeMillis();
			//System.out.println(end - start);
			//DisplayDialog dd = new DisplayDialog(test);
			System.out.println("Finished: "+java.time.LocalTime.now());
		}
		else if(e.getActionCommand().equals("MergeSort")) {
			System.out.println("Started: "+java.time.LocalTime.now());
			//start = System.currentTimeMillis();
			Sorting.MergeSort(test);
			//end = System.currentTimeMillis();
			//System.out.println(end - start);
			System.out.println("Finished: "+java.time.LocalTime.now());
		}
		else if(e.getActionCommand().equals("CombSort")) {
			System.out.println("Started: "+java.time.LocalTime.now());
			//start = System.currentTimeMillis();
			Sorting.CombSort(test);
			//end = System.currentTimeMillis();
			//System.out.println(end - start);
			System.out.println("Finished: "+java.time.LocalTime.now());
		}
		else if(e.getActionCommand().equals("Tak!")) {
			ModifyFrame mf = new ModifyFrame(this);
		}
		else {
			//DisplayDialog dd = new DisplayDialog(test);
			for(int a: test) {
				System.out.println(a);
			}
		}
	}
	
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
	}

}
