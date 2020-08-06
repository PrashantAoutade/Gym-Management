
import java.awt.*;
import javax.swing.*;

class MySplash extends JWindow implements Runnable
{
	Thread t;
	Image i;
	ImageIcon ii;
	int x=10;
	int r=225,g=90,b=50;
	Color c,c1;
	Font f1;
	MySplash()
	{
		t=new Thread(this,"MyThread");
		ii=new ImageIcon("C:/sunil/Gymm Management/Image/man.png");
		i=ii.getImage();
		setBounds(400,150,665,519);
		f1=new Font("Tahoma",Font.BOLD,15);	
		setVisible(true);
		t.start();
	}
	public void run()
	{
		try
		
			{
			c=new Color(r%255,g%255,b%255);	
			while(x<565)
			{
				r+=20;g+=15;b+=9;
				x+=15;t.sleep(100);repaint();
			}
		}catch(Exception e){}
		 //LoginForm l1=new ();
		 Login l1=new Login();
		 //p1.setBounds(275,35,850,565);
		this.setVisible(false);
	}
	public void paint(Graphics g)
	{
		g.drawImage(i,0,0,this);
		g.setColor(Color.black);
		g.setFont(f1);
		g.drawString("Plz. Wait until process completes ......",100,405);
		//g.setColor(c);
		g.drawString((x*100/570)+"% completed",100,350);
		//g.setColor(Color.white);
		g.drawRect(25,364,570,14);
		g.fillRect(25,365,x,13);
		
	}
	public static void main(String args[])
	{
		new MySplash();
	}
}		