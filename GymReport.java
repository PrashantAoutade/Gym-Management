
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;

	class GymReport extends JFrame implements ActionListener
	{
	 JButton b1,b2,b3,b4,b5;
	 JLabel l1,lbl,l2;
	 public GymReport()
	 {
	  super("Gymm Mgnt.System");
	  b1=new JButton("TRAINER DETAIL");
	  b2=new JButton(" CUSTOMER DETAIL");
	  b3=new JButton(" TOOL DETAIL");
	  b4=new JButton(" BACK");
	  l1=new JLabel();
	  lbl=new JLabel();

	  Font f=new Font("Times new Roman",Font.BOLD,40);
	  l1.setFont(new Font("Times new Roman",Font.BOLD,50));
	  l1.setForeground(Color.red);
	  l1.setText("  Fitness  Point");

	  b1.setBounds(30,100,250,30);             b1.setForeground(new Color(175,50,175));  
	  b2.setBounds(70,145,250,30);             b2.setForeground(new Color(175,50,175));
	  b3.setBounds(100,195,250,30);             b3.setForeground(new Color(175,50,175));
	  b4.setBounds(130,235,250,30);             b3.setForeground(new Color(175,50,175));  
	 // b3.setBounds(170,275,250,30);             b3.setForeground(new Color(175,50,175));  
	  l1.setBounds(200,20,450,50);
	  lbl.setBounds(150,200,50,50);


	   l2 = new JLabel("", new ImageIcon("C:/sunil/Gymm Management/Image/happy1.png"), JLabel.CENTER);
	   l2.setBounds(435,120,400,300);
	   add(l2);





	   
	  b1.addActionListener(this);
	  b2.addActionListener(this);
	  b3.addActionListener(this);
	  b4.addActionListener(this);
	  	  Container c1=getContentPane();
	  c1.setLayout(null);

	  c1.add(b1);
	  c1.add(b2);
	
	   c1.add(b3);
	   c1.add(b4);
	 
	 
	  setSize(800,600);
	  setVisible(true);
	  this.setResizable(false);
	  this.setLocation(300,50);

	  getContentPane().setBackground(Color.white);

	  setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	 }
	 public static void main(String args[])
	 {
	  new GymReport();
	 }
	 public void actionPerformed(ActionEvent a1)
	 {
		 
	try
	{
	    if(a1.getSource()==b1)
	  {
	   new GymRecordCoach();
	  
	  }


	  if(a1.getSource()==b2)
	  {
	   new GymRecordCust();

	  }
	  
	  if(a1.getSource()==b3)
	  {
	   new GymRecordTool();

	  }
	  if(a1.getSource()==b4)
	  {
	   new MyMenu();
	   this.setVisible(false);
	   dispose();
	  }
	   
	}
	   catch(Exception e) 
	   {
	    System.out.println("ERROR:"+e);
	   }
	  
	 }
	}



