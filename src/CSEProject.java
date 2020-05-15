import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;

public class CSEProject extends JFrame implements ActionListener, KeyListener{

	private JPanel contentPane;
	JButton btnSinglePlayer,btnMultiplayer,btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CSEProject frame = new CSEProject();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CSEProject() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		design();
		
	}
	public void design(){
	
	btnSinglePlayer = new JButton("Single Player");
	btnSinglePlayer.setBounds(27, 234, 150, 50);
	btnSinglePlayer.setForeground(Color.BLUE);
	btnSinglePlayer.setFont(new Font("ALGERIAN", Font.BOLD, 15));
	btnSinglePlayer.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			SinglePlayer3 sp = new SinglePlayer3();
			dispose();
		}
		
	});
	contentPane.add(btnSinglePlayer);
	
	btnMultiplayer = new JButton("Multiplayer");
	btnMultiplayer.setBounds(27, 350, 150, 50);
	btnMultiplayer.setFont(new Font("ALGERIAN", Font.BOLD, 15));
	btnMultiplayer.setForeground(Color.BLUE);
	btnMultiplayer.addActionListener(this);
	btnMultiplayer.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Multiplayer mp = new Multiplayer();
			dispose();
		}
		
	});
	contentPane.add(btnMultiplayer);
	
	
	btnExit = new JButton("Exit");
	btnExit.setBounds(300, 234, 150, 50);
	btnExit.setForeground(Color.BLUE);
	btnExit.addActionListener(this);
	btnExit.setFont(new Font("ALGERIAN", Font.BOLD, 15));
	btnExit.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.exit(ABORT);
		}
		
	});
	contentPane.add(btnExit);
	
	JLabel lblNewLabel = new JLabel("New label");
	lblNewLabel.setIcon(new ImageIcon("X:\\Java\\Project\\Game\\final.jpg"));
	lblNewLabel.setBounds(0, 0, 800, 480);
	contentPane.add(lblNewLabel);
}

@Override
public void actionPerformed(ActionEvent e) {
	
	
}


@Override
public void keyPressed(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
	
}
