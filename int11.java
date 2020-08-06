
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class int11 extends JFrame 
{
	

	JPanel p;
	JTextField t1,t2;
	JButton b1;
	JLabel jb1,jb2,l1,l2;
	JLabel j1,j2,j3,j4,j5,j6,j7,j8,j9; 
	public int11()
	{
                 super("Instructions");	
	    p=new JPanel();
	    p.setLayout(null);
	    getContentPane().add(p);
	    setSize(750,650);
                  setLocation(300,30);
		setVisible(true);
		p.setBackground(Color.white);
				
		jb1=new JLabel("Rules and Regulations!!");
		jb1.setFont(new Font("Bradley Hand ITC",Font.BOLD,40));
		jb1.setForeground(Color.red);
		jb1.setBounds(150,40,700,80);
		p.add(jb1);


             




		
	  j1=new JLabel("1: Every member has to submit their medical certificate.");
                j1.setFont(new Font("Times new Roman",Font.BOLD,16));
	  j1.setBounds(60,100,950,180);
	  j1.setForeground(Color.black);
	  p.add(j1);
		
	  j2=new JLabel("2: Every member must have to submit Birth-certificate.");
                j2.setFont(new Font("Times new Roman",Font.BOLD,16));
	  j2.setBounds(60,150,800,160);
	  j2.setForeground(Color.black);
	  p.add(j2);
		
      	
	  j3=new JLabel("3: The Age of the children must be 16-years completed.");
                j3.setFont(new Font("Times new Roman",Font.BOLD,16));
	  j3.setBounds(60,200,700,140);
	  j3.setForeground(Color.black);
	  p.add(j3);
		
		
                j4=new JLabel("4: Customers should allowed only within there Batch Timming.");
                j4.setFont(new Font("Times new Roman",Font.BOLD,16));
	  j4.setBounds(60,250,900,120);
	  j4.setForeground(Color.black);
	  p.add(j4);
	  
	  
	  	   	
	  j5=new JLabel("5: Members must have their I_card with them.");
                j5.setFont(new Font("Times new Roman",Font.BOLD,16));
	  j5.setBounds(60,300,700,100);
	  j5.setForeground(Color.black);
	  p.add(j5);
	  
	  
	  
	  j6=new JLabel("6: Every customer must take advice of Coach in gym.");
                j6.setFont(new Font("Times new Roman",Font.BOLD,16));
	  j6.setBounds(60,350,700,80);
	  j6.setForeground(Color.black);
	  p.add(j6);
	
	
	  j7=new JLabel("7: Smoking is prohibited in gym. ");
                j7.setFont(new Font("Times new Roman",Font.BOLD,16));
	  j7.setBounds(60,400,700,60);
	  j7.setForeground(Color.black);
	  p.add(j7);
	  
	  
	  j8=new JLabel("8:Every member keep silence in gym area.");
                j8.setFont(new Font("Times new Roman",Font.BOLD,16));
	  j8.setBounds(60,435,900,60);
	  j8.setForeground(Color.black);
	  p.add(j8);
	


               l1 = new JLabel("", new ImageIcon("C:/sunil/Gymm Management/Image/yog.gif"), JLabel.CENTER);
               l1.setBounds(0,50,450,500);
               p.add(l1);

 

               l2 = new JLabel("", new ImageIcon("C:/sunil/Gymm Management/Image/Flower.jpg"), JLabel.CENTER);
               l2.setBounds(300,100,450,450);
               p.add(l2);

  
 



		
	  b1=new JButton("OK");
	  b1.setBounds(280,560,100,40);
	  b1.setFont(new Font("Times new Roman",Font.BOLD,35));
	  b1.setBackground(Color.white);
	  p.add(b1);
                show();
	
	  b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
                                           
			  setVisible(false);
                                           new MyMenu();
			}
		});
	}
	/*public static void main(String args[])
	{
		//new Instruction();
	}*/
}				