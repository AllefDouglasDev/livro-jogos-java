package movimento;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class App extends JFrame implements KeyListener {

	private int x = 50, y = 50;

	private int vel = 4;

	private int size = 30;

	public static void main(String[] args) 
	{
		new App();
	}

	public App() 
	{
		addKeyListener(this);
		setLocationRelativeTo(null);
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillOval(x, y, size, size);
	}

	@Override
	public void keyPressed(KeyEvent arg0) { mov(arg0); }

	@Override
	public void keyReleased(KeyEvent arg0) { }

	@Override
	public void keyTyped(KeyEvent arg0) { mov(arg0); }

	void mov(KeyEvent e)
	{
		int auxX = x;
		int auxY = y;
		
		if (e.getKeyCode() == KeyEvent.VK_W) 
		{
			y -= vel;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) 
		{
			y += vel;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) 
		{
			x -= vel;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) 
		{
			x += vel;
		}
		
		if (passouParede(x, y)) 
		{
			x = auxX;
			y = auxY;
		}
		else
		{
			repaint();
		}
	}
	
	boolean passouParede(int x, int y) 
	{
		System.out.println("X = " + x + " getWidth = " + getWidth());
		System.out.println("Y = " + y + " getHeight = " + getHeight());
		return x < 10 || y < 31 || x > getWidth() - 40 || y > getHeight() - 40;
	}
}
