import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

class About extends JFrame
{  
   
    Font f1 = new Font("Verdana",Font.BOLD,15);   
    public static final int	HAND_CURSOR	= 12;
   About()
   {
   	 super("About Us");
   	 setVisible(true);
   	 setSize(3003,3003);
   	 setLocation(300,80);
   	 JPanel pan = new JPanel();
   	 getContentPane().add(pan);
   	 pan.setLayout(null);
   	
   	 
   	 // image apperance
   	 
   	 ImageIcon i = new ImageIcon("C:/sunil/Gymm Management/Image/a.gif");
	 JLabel Logo = new JLabel("",i,JLabel.RIGHT);
	 Logo.setBounds(120,10,150,100);
	 pan.add(Logo);   	 
   	 
   	   	 
   	 JLabel lbl = new JLabel("PROJECT NAME:");
   	 lbl.setBounds(20,80,200,50);
   	 pan.add(lbl);
   	 lbl.setForeground(Color.blue);
   	 lbl.setFont(f1);
   	 
   	 JLabel l1 = new JLabel("  PORT HEALTH CLUB,WEST MAHARASHTRA");
   	 l1.setBounds(1,110,550,60);
   	 pan.add(l1);
   	 l1.setForeground(Color.red);
   	 l1.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
   	 
   	
   	 
   	 JLabel l2 = new JLabel("DEVELOPED BY:");
   	 l2.setBounds(20,180,200,50);
   	 pan.add(l2);
   	 l2.setForeground(Color.blue);
   	 l2.setFont(f1);
   	 
   	 //trying Image1
   	 ImageIcon s1 = new ImageIcon("C:/sunil/Gymm Management/Image/c.gif");
	 JLabel Logo1 = new JLabel("",s1, JLabel.CENTER);
	 Logo1.setBounds(125,230,20,10);
	 pan.add(Logo1);
   	 //end image
   	 
   	    	   	     	 
   	 JLabel l3 = new JLabel("   Aoutade Prashant");
   	 l3.setBounds(150,208,300,50);
   	 pan.add(l3);
   	 l3.setForeground(Color.magenta);
   	 l3.setFont(f1);
   	 
   	  //trying Image2
   	 ImageIcon s2 = new ImageIcon("C:/sunil/Gymm Management/Image/c.gif");
	 JLabel Logo2 = new JLabel("", s2, JLabel.CENTER);
	 Logo2.setBounds(125,263,20,10);
	 pan.add(Logo2);
   	 //end image
   	 
   	
   	 
   	 JLabel l4 = new JLabel("    Kirane Omkar");
   	 l4.setBounds(150,243,300,50);
   	 pan.add(l4);
   	 l4.setForeground(Color.magenta);
   	 l4.setFont(f1);
		
	JLabel l5 = new JLabel("    Gulig Tushar");
   	 l5.setBounds(150,280,300,50);
   	 pan.add(l5);
   	 l5.setForeground(Color.magenta);
   	 l5.setFont(f1);


       
   	 //JButton	 
   	 JButton b1 = new JButton("OK");
   	 b1.setBounds(190,460,80,30);
   	 pan.add(b1);
   	 b1.setForeground(Color.red);
   	 b1.setFont(f1);
   	 Cursor hand = new Cursor(HAND_CURSOR);
   	 b1.setCursor(hand);



              JLabel l6 = new JLabel("GUIDED BY:");
   	 l6.setBounds(20,320,200,50);
   	 pan.add(l6);
   	 l6.setForeground(Color.blue);
   	 l6.setFont(f1);


              JLabel l7 = new JLabel("1)   Prof.Ms. Patil madom");
   	 l7.setBounds(150,340,300,50);
   	 pan.add(l7);
   	 l7.setForeground(Color.black);
   	 l7.setFont(f1);
  

     /*         JLabel l8 = new JLabel("2)   .");
   	 l8.setBounds(150,370,300,50);
   	 pan.add(l8);
   	 l8.setForeground(Color.black);
   	 l8.setFont(f1);*/
            

   	
   	 
   	b1.addActionListener(new ActionListener()
   	{
   		public void actionPerformed(ActionEvent e)
   		{
   		 	new MyMenu();
			setVisible(false);
   			}
   		});    	    	 
    }
   public static void main(String[] args)
   {
   	 new About();
  }
}