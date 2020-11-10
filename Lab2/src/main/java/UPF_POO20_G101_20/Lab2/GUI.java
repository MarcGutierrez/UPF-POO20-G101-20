package UPF_POO20_G101_20.Lab2;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JFrame frmLogowindow;
	private Logo logo;
	private Program prog;

	/**
	 * Create the application.
	 */
	public GUI() {
		logo = new Logo(800, 600);
		List<Instruction> Instructions = new ArrayList<Instruction>();
		Instruction in1 = new Instruction("FWD", 100.0);
		Instruction in2 = new Instruction("ROT", 90.0);
		Instructions.add(in1); Instructions.add(in2);Instructions.add(in1); Instructions.add(in2);Instructions.add(in1); Instructions.add(in2);Instructions.add(in1); Instructions.add(in2);
		prog = new Program(Instructions, "Square App");

		prog.printErrors();
	
		initialize();
		frmLogowindow.setBackground(Color.WHITE);
		frmLogowindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint ( Graphics g ){
			super.paint( g ) ;
			g.setColor(Color.BLACK);
			logo.execute( prog, g );
		}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogowindow = new JFrame();
		
		frmLogowindow.setTitle("LogoWindow");
		frmLogowindow.setName("LogoWindow");
		frmLogowindow.getContentPane().setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
		frmLogowindow.getContentPane().setBackground(Color.WHITE);
		frmLogowindow.getContentPane().setLayout(null);
		frmLogowindow.setBounds(100, 100, logo.getWidth(), logo.getHeight());
		
		
		JButton btnNewButton = new JButton("Execute");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paint(frmLogowindow.getGraphics());
			}
		});
		btnNewButton.setBounds(10, 527, 112, 23);
		frmLogowindow.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Toggle Pen");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logo.togglePen();
			}
		});
		btnNewButton_1.setBounds( 132, 527, 112, 23);
		frmLogowindow.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogowindow.getGraphics().clearRect(0, 0, 800, 600);
				logo.resetTurtle();
			}
		});
		btnNewButton_2.setBounds( 254, 527, 112, 23);
		frmLogowindow.getContentPane().add(btnNewButton_2);
	}

	public Logo getLogo() {
		return logo;
	}

	public void setLogo(Logo logo) {
		this.logo = logo;
	}

	public Program getProgram() {
		return prog;
	}

	public void setProgram(Program program) {
		this.prog = program;
	}
}
