import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SinglePlayer3 extends JPanel implements ActionListener,KeyListener,MouseListener {
	
	public final int WIDTH = 950, HEIGHT = 800;
	public  Rectangle crosshair;
	
	public ArrayList<Rectangle> duck,duck2,bomb;
	public int yMotion, xMotion, score=0;
	public boolean gameOver, started;
	
	public int dx,dy;

	JFrame frame = new JFrame();
	
	public SinglePlayer3()
	{
		
	
		Timer timer = new Timer(50, this);
	
	
		frame.add(this);
		frame.setTitle("SHOOT THE BIRDS");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.addKeyListener(this);
		frame.setResizable(false);
		frame.setVisible(true);
		
		
		
		crosshair = new Rectangle(WIDTH / 2, HEIGHT / 2, 50, 50);
		
		duck = new ArrayList<Rectangle>();
		duck2 = new ArrayList<Rectangle>();
		bomb = new ArrayList<Rectangle>();
		for (int i=0;i<5;i++){
			int y1=0+(int) (Math.random()*(600-0+1));
			int x1=0+(int) (Math.random()*(600-0+1));
			int y2=0+(int) (Math.random()*(600-0+1));
			int x2=0+(int) (Math.random()*(600-0+1));
			int y3=0+(int) (Math.random()*(600-0+1));
			int x3=0+(int) (Math.random()*(600-0+1));
			Rectangle c1=new Rectangle(x1,y1,50,50);
			Rectangle c2=new Rectangle(x2,y2,50,50);
			Rectangle c3=new Rectangle(x3,y3,50,50);
			
			duck.add(c1);
			duck2.add(c2);
			bomb.add(c3);
			
			
		}
		
		
		repaint();

		

		timer.start();
	}
	
	public void move(){
		xMotion+=dx;
		yMotion+=dy;
	}
	
	

	
	public void paint(Graphics g)
	{
		
	
		
		

		ImageIcon icon=new ImageIcon("background.gif");
		Image b=icon.getImage();
		g.drawImage(b, 0, 0, 950, 800, this);
		//bird
		
			ImageIcon img = new ImageIcon("angry.gif");
			Image i = img.getImage();
			for(Rectangle d1: duck){
				g.drawImage(i, d1.x, d1.y, d1.width, d1.height, this);
		
			
			}
		
			ImageIcon img2 = new ImageIcon("yellow.png");
			Image i2 = img2.getImage();
			for(Rectangle d2: duck2){
				g.drawImage(i2, d2.x, d2.y, d2.width, d2.height, this);
			}
			
			ImageIcon img3 = new ImageIcon("bomb.png");
			Image i3 = img3.getImage();
			for(Rectangle d3: bomb){
				g.drawImage(i3, d3.x, d3.y, d3.width, d3.height, this);
		
			
			}
			
			
		
		
	
		ImageIcon img4 = new ImageIcon("new.png");
		Image i4 = img4.getImage();
		g.drawImage(i4, crosshair.x, crosshair.y, crosshair.width, crosshair.height, this);

		
		
	
		
		g.setColor(Color.RED);
		g.setFont(new Font("Impact", 2, 50));
		
		

		
			g.drawString("Score: "+score, 50,  50);
				

		
	}
	
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key= e.getKeyCode();
		
		if(key==KeyEvent.VK_LEFT){
			crosshair.x-=30;
			repaint();
		}
		
		else if(key==KeyEvent.VK_RIGHT){
			crosshair.x+=30;
			repaint();
		}
		
		else if(key==KeyEvent.VK_UP){
			crosshair.y-=30;
			repaint();
		}
		
		else if(key==KeyEvent.VK_DOWN){
			crosshair.y+=30;
			repaint();
		}
		
	
		for(Rectangle d: duck){
			if(collision(crosshair.getBounds(), d.getBounds())){
				d.height = 0;
				d.width = 0;
				score+=5;
				
			}
		}
		for(Rectangle d: duck2){
			if(collision(crosshair.getBounds(), d.getBounds())){
				d.height = 0;
				d.width = 0;
				score++;
				
			}
		}
		
		for(Rectangle b: bomb){
			if(collision(crosshair.getBounds(), b.getBounds())){
				JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
				System.exit(ABORT);
				
				
			}
		}
	}
		
		
		
		


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key= e.getKeyCode();
		

		if(key==KeyEvent.VK_LEFT){
			crosshair.x=0;
			repaint();
		}
		
		if(key==KeyEvent.VK_RIGHT){
			crosshair.x+=0;
			repaint();
		}
		
		if(key==KeyEvent.VK_UP){
			crosshair.y-=0;
			repaint();
		}
		
		if(key==KeyEvent.VK_DOWN){
			crosshair.y+=0;
			repaint();
		}

	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
	
			}
	
	
	public boolean collision(Rectangle r1, Rectangle r2){
		return r1.intersects(r2);
	}
	
		
	


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
