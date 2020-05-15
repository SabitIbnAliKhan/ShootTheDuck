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
public class SinglePlayer extends JPanel implements ActionListener,KeyListener,MouseListener {
	//public static SinglePlayer singlePlayer = new SinglePlayer();
	public final int WIDTH = 700, HEIGHT = 750;
	public  Rectangle crosshair;
	
	public ArrayList<Rectangle> duck,duck2;
	public int yMotion, xMotion, score=0;
	public boolean gameOver, started;
	
	public int dx,dy;
	//JLabel scoreLabel;
	//JTextField scoreField;
//	JPanel panel;
	//public Renderer renderer;
	JFrame frame = new JFrame();
	//JPanel panel=new JPanel();
	//Crosshair crosshair;

	public SinglePlayer()
	{
		
		//frame = new JFrame();
		Timer timer = new Timer(50, this);
	//	renderer = new Renderer();
	//	add(renderer);
		//Graphics g;
		
	//	singlePlayer = new SinglePlayer();
	
		frame.add(this);
		frame.setTitle("SHOOT THE DUCK");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.addKeyListener(this);
		frame.setResizable(false);
		frame.setVisible(true);
		//panel.setBackground(Color.BLACK);
		//panel.paintComponents(){
			
		//};
		/*scoreLabel = new JLabel("Score");
		
		GridBagConstraints c = new GridBagConstraints();   

		c.insets = new Insets(10,10,10,10);    //  each component will be surrounded by 10 pixel space (top, left, bottom, right)
		
		c.anchor = GridBagConstraints.EAST;    //  Left-alignment. If you want center-alignment, just comment it out
		
		c.gridx= 0;
		c.gridy = 0;
		panel.add(scoreLabel, c);
		*/   
		
		
		crosshair = new Rectangle(WIDTH / 2, HEIGHT / 2, 50, 50);
		//duck = new Rectangle(WIDTH / 2, HEIGHT / 2, 50, 50);
		//duck2 = new Rectangle(WIDTH / 2, HEIGHT / 2, 50, 50);
		duck = new ArrayList<Rectangle>();
		duck2 = new ArrayList<Rectangle>();
		for (int i=0;i<3;i++){
			int y1=0+(int) (Math.random()*(600-0+1));
			int x1=0+(int) (Math.random()*(600-0+1));
			int y2=0+(int) (Math.random()*(600-0+1));
			int x2=0+(int) (Math.random()*(600-0+1));
			Rectangle c1=new Rectangle(x1,y1,50,50);
			Rectangle c2=new Rectangle(x2,y2,50,50);
			duck.add(c1);
			duck2.add(c2);
		}
		
		//addDuck(true);
		//Ducks d= new Ducks(new SinglePlayer());
		repaint();

		

		timer.start();
	}
	
	public void move(){
		xMotion+=dx;
		yMotion+=dy;
	}
	
	
/*	public void paintComponent(Graphics g){
		super.paintComponent(g);
		repaint();
	}*/
	
	/*public void paintColumn(Graphics g, Rectangle duck)
	{
		g.setColor(Color.green.darker());
		g.fillRect(duck.x, duck.y, duck.width, duck.height);
	}*/
	
//	public void paintDuck(Graphics g){
		
	//}
	
	public void paint(Graphics g)
	{
		
	/*	GridBagConstraints c = new GridBagConstraints();   

		c.insets = new Insets(10,10,10,10);    //  each component will be surrounded by 10 pixel space (top, left, bottom, right)
		
		c.anchor = GridBagConstraints.EAST;    //  Left-alignment. If you want center-alignment, just comment it out
		
		c.gridx= 0;
		c.gridy = 0;
		panel.add(scoreLabel, c);   
		
		c.gridx = 1;
		c.gridy = 0;
		panel.add(scoreField, c);
		
		scoreField.setText(Integer.toString(score));
		
		*/
	//	super.paint(g);
		//Graphics2D g2d=(Graphics2D) g;
		//crosshair.paint(g2d);
		
		//the Jpanel
		g.setColor(Color.cyan);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		//ground
		g.setColor(Color.orange);
		g.fillRect(0, HEIGHT - 120, WIDTH, 120);


		//bird
		
			ImageIcon img = new ImageIcon("cuteduck.jpg");
			Image i = img.getImage();
			for(Rectangle d1: duck){
				g.drawImage(i, d1.x, d1.y, d1.width, d1.height, this);
			//g.drawImage(i, (int) (d1.x-(50+Math.random()*(250-50+1))), (int) (d1.y-(50+Math.random()*(250-50+1))) ,duck.width-150, duck.height-150, this);
			
			}
			g.setColor(Color.white);
			g.setFont(new Font("Arial", 2, 50));
			
			ImageIcon img2 = new ImageIcon("chick.jpeg");
			Image i2 = img2.getImage();
			for(Rectangle d2: duck2){
				g.drawImage(i2, d2.x, d2.y, d2.width, d2.height, this);
			}
			//g.drawImage(i2, (int) (duck.x-(50+Math.random()*(250-50+1))), (int) (duck.y-(50+Math.random()*(250-50+1))) ,duck.width-150, duck.height-150, this);

			g.setColor(Color.white);
			g.setFont(new Font("Arial", 2, 50));
			
		
		
		/*for(Rectangle c: duck){
			ImageIcon img = new ImageIcon("X:\\Java\\Project\\Game\\cuteduck.jpg");
			Image i = img.getImage();
			g.drawImage(i,duck.x,duck.y,duck.width-150, duck.height-150, this)
		}
		*/
		ImageIcon img3 = new ImageIcon("crosshair.png");
		Image i3 = img3.getImage();
		g.drawImage(i3, crosshair.x, crosshair.y, crosshair.width, crosshair.height, this);

		g.setColor(Color.white);
		g.setFont(new Font("Arial", 2, 50));
		
	/*	for (Rectangle item : duck)
		{
			paintColumn(g, item);
		}*/
		
		g.setColor(Color.white);
		g.setFont(new Font("Arial", 2, 50));
		
		if (!started)
		{
			g.drawString("", 75, HEIGHT / 2);
		}

		//if (gameOver)
		//{
			g.drawString("Score: "+score, 50,  50);
		//}		

		
	}
	
	public void play(){
		/*if (gameOver){		
			columns.clear();
			yMotion = 0;
			//addColumn(true);
			//addColumn(true);	
		}
*/
		if (!started){
			started = true;
		}
		else if (!gameOver){
			if (yMotion > 0){
				yMotion = 0;
			}

			yMotion -= 10;
		}
	}
	
	/*public void addDuck(boolean start)
	{
		int space = 300;
		int gap = 100;
		int height = 50 + (int) (Math.random()*(350-50+1));  // height of lower column

		if (start)   //  columns of first screen
		{
			duck.add(new Rectangle(WIDTH + gap + duck.size()*200, HEIGHT - height - 120, gap, height));  //  120 for ground
			duck2.add(new Rectangle(WIDTH + gap + (duck2.size() - 1)*200 , 0, gap, HEIGHT - height - space));    //  upper column
		}
		else    //  columns of other screens
		{
			duck.add(new Rectangle(duck.get(duck.size() - 1).x + 400, HEIGHT - height - 120, gap, height));   //  lower column
			duck2.add(new Rectangle(duck2.get(duck2.size() - 1).x, 0, gap, HEIGHT - height - space));    //  upper column
		}
	}*/
	
	/*private boolean collision() {
		return SinglePlayer.crosshair.getBounds().intersects(getBounds());
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//int speed = 15;
		//if (started)
		//{
			/*for (int i = 0; i < duck.size(); i++)
			{
				Rectangle column = duck.get(i);

				column.x -= speed;
			}

			if (yMotion < speed)
			{
				yMotion+=2;
			}

			for (int i = 0; i < duck.size(); i++)
			{
				Rectangle column = duck.get(i);

				if (column.x + column.width < 0)
				{
					duck.remove(column);

					if (column.y == 0)
					{
						addDuck(false);
					}
				}
			}

			//bird.y += yMotion;
			
			
			/*for (Rectangle column : columns){
				
				if (column.y == 0 && bird.x + bird.width / 2 > column.x + column.width / 2 - 10 && bird.x + bird.width / 2 < column.x + column.width / 2 + 10)
				{
					if(!gameOver){
						score++;
					}
	
				}

				
				if (column.intersects(bird)){
					gameOver = true;

					bird.height=0;    //  to make the bird invisible
					bird.width=0;
				}
			}*/

		//}
	//	renderer.repaint();
		
		
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
			crosshair.x-=20;
			repaint();
		}
		
		else if(key==KeyEvent.VK_RIGHT){
			crosshair.x+=20;
			repaint();
		}
		
		else if(key==KeyEvent.VK_UP){
			crosshair.y-=20;
			repaint();
		}
		
		else if(key==KeyEvent.VK_DOWN){
			crosshair.y+=20;
			repaint();
		}
		
	
		for(Rectangle d: duck){
			if(collision(crosshair.getBounds(), d.getBounds())){
				d.height = 0;
				d.width = 0;
				score++;
				
			}
		}
		for(Rectangle d: duck2){
			if(collision(crosshair.getBounds(), d.getBounds())){
				d.height = 0;
				d.width = 0;
				score++;
				
			}
		}
		
		
		
		
		
if (!gameOver){
			
			if(e.getKeyCode() == KeyEvent.VK_SPACE)
			{
				//jump();
				//play();
				//paint(null);
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
		//if (SwingUtilities.isLeftMouseButton(e)){
			
			/*	for(int i=0; i<duck.size() || i<duck2.size(); i++){
					if(crosshair.getBounds().intersects(duck.get(i).getBounds())){
						score++;
						duck.get(i).width=0;
						duck.get(i).height=0;
						
					}
					else if(crosshair.getBounds().intersects(duck2.get(i).getBounds())){
						score++;
						duck2.get(i).width=0;
						duck2.get(i).height=0;
					}
				}
				*/
		
				
			//	System.out.println(score);
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
