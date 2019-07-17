package visual;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import sorting.Sorting;

public class ModifyFrame extends JFrame implements ActionListener {

	private JLabel msg = null;
	private JTextArea ta = null;
	private JButton random, halfsort, sort, reversed;
	
	private int mode = 0;
	
	private MainFrame container = null;
	
	public ModifyFrame(MainFrame mf) {
		super("Customize");
		
		container = mf;
		
		msg = new JLabel("Jak d³ugi ma byæ ci¹g?", JLabel.LEFT);
		msg.setFont(new Font("Verdana", Font.BOLD, 15));
		msg.setOpaque(true);
		
		ta = new JTextArea();
		
		random = new JButton("Przypadkowy");
		random.addActionListener(this);
		
		halfsort = new JButton("50% posortowany");
		halfsort.addActionListener(this);
		
		sort = new JButton("Posortowany");
		sort.addActionListener(this);
		
		reversed = new JButton("Odwrotnie posortowany");
		reversed.addActionListener(this);
		
		JPanel help = new JPanel();
		help.setLayout(new GridLayout(3,2));
		help.add(msg);
		help.add(ta);
		help.add(random);
		help.add(sort);
		help.add(halfsort);
		help.add(reversed);
		
		this.add(help);
		
		this.setVisible(true);
		this.setSize(500, 300);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int[] newtest;
		
		try {
			newtest = new int[Integer.parseInt(ta.getText())];
			//ta.setText("");
			if(e.getActionCommand().equals("Przypadkowy")) {
				newtest = randomHelp(newtest.length);
			}
			else if(e.getActionCommand().equals("50% posortowany")) {
				newtest = halfsortHelp(newtest.length);
			}
			else if(e.getActionCommand().equals("Posortowany")) {
				newtest = sortHelp(newtest.length);
			}
			else if(e.getActionCommand().equals("Odwrotnie posortowany")) {
				newtest = reversedHelp(newtest.length);
			}
			container.setTest(newtest);
			System.out.println("Ready");
		}
		catch(IllegalArgumentException ex) {
			ta.setText("Podaj liczbê naturaln¹!");
		}
		
	}
	
	private int[] randomHelp(int a) {
		int[] returned = new int[a];
		Random r = new Random();
		
		for(int i = 0; i<a; i++) {
			returned[i] = r.nextInt(Integer.MAX_VALUE);
		}
		
		return returned;
	}
	
	private int[] sortHelp(int a) {
		/*
		int[] returned = new int[a];
		Random r = new Random();
		
		int add = r.nextInt(10);
		
		do
			returned[0] = r.nextInt(Integer.MAX_VALUE-a*9);
		while(returned[0]<0);
		
		for(int i = 1; i<a; i++) {
			returned[i] = returned[i-1]+add;
		}
		
		return returned;
		*/
		int[] returned = randomHelp(a);
		Sorting.CombSort(returned);
		return returned;
	}
	
	private int[] reversedHelp(int a) {
		int[] returned = new int[a];
		Random r = new Random();
		
		int add = r.nextInt(10);
		
		do
			returned[0] = r.nextInt(Integer.MAX_VALUE);
		while(returned[0]<a*9);
		
		for(int i = 1; i<a; i++) {
			returned[i] = returned[i-1]-add;
		}
		
		return returned;
	}
	
	private int[] halfsortHelp(int a) {
		/*
		int[] returned = new int[a];
		Random r = new Random();
		
		int add = r.nextInt(10);
		
		returned[a-1] = r.nextInt(Integer.MAX_VALUE/3);
		
		for(int i = 1; i<a; i++) {
			if(i<a/2) {
				returned[i] = returned[i-1]+add;
			}
			else {
				returned[i] = r.nextInt(Integer.MAX_VALUE/3)+returned[a/2 - 1];
			}
		}
		*/
		int[] returned = randomHelp(a);
		Random r = new Random();
		
		Sorting.CombSort(returned);
		
		for(int i = a/2;i<a;i++) {
			returned[i] = r.nextInt(Integer.MAX_VALUE);
			if(returned[i]<Integer.MAX_VALUE-returned[a/2-1]) {
				returned[i]+=returned[a/2-1];
			}
		}
		
		return returned;
	}
	
}
