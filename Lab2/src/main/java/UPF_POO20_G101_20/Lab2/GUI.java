package UPF_POO20_G101_20.Lab2;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
		initialize();
		frmLogowindow.setBackground(Color.BLACK);
		frmLogowindow.setBounds(100, 100, logo.getWidth(), logo.getHeight());
		frmLogowindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint ( Graphics g ){
			super.paint( g ) ;
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
		
		JButton btnNewButton = new JButton("Button 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] options = {"Yes", "Fuck"};
				JOptionPane.showOptionDialog(null, "Fuck", "A11", 2, 1, null, options, options);
			}
		});
		btnNewButton.setBounds(10, 527, 89, 23);
		frmLogowindow.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Button 2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] options = {"Yes", "Stonks"};
				JOptionPane.showOptionDialog(null, "Invest", "Nemo", 0, 1, null, options, options);
			}
		});
		btnNewButton_1.setBounds(134, 527, 89, 23);
		frmLogowindow.getContentPane().add(btnNewButton_1);
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
