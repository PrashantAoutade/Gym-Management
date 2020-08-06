
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyMenu extends JFrame implements ActionListener
{
 JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
 JLabel l1,lbl,l2,l3;
 public MyMenu()
 {
  super("Gymm Mgnt.System");
  b1=new JButton("NEW CUSTOMER");
  b2=new JButton("DELETE CUSTOMER");
  b3=new JButton("CUSTOMER'S INFORMATION");
  b4=new JButton("UPDATE CUSTOMER");
  b5=new JButton("EXIT");
  b6=new JButton("TOOL INFORMATON");
  b7=new JButton("About");
  b8=new JButton("COACH INFORMATION");
  b9=new JButton("INSTRUCTIONS");
  b10=new JButton("REPORT");
  l1=new JLabel();
  lbl=new JLabel();

  Font f=new Font("Times new Roman",Font.BOLD,40);
  l1.setFont(new Font("Times new Roman",Font.BOLD,50));
  l1.setForeground(Color.red);
  l1.setText("  Fitness  Point");
 add(l1);
  b1.setBounds(30,250,250,60);             b1.setForeground(new Color(175,50,175));  
  b2.setBounds(30,330,250,60);             b2.setForeground(new Color(175,50,175));
  b3.setBounds(30,410,250,60);           b3.setForeground(new Color(175,50,175));
  b4.setBounds(30,490,250,60);           b4.setForeground(new Color(175,50,175));
  b6.setBounds(30,570,250,60);           b6.setForeground(new Color(175,50,175));
  b5.setBounds(1060,250,250,60);           b5.setForeground(new Color(175,50,175));
  b7.setBounds(1060,330,250,60);           b7.setForeground(new Color(175,50,175));
  b8.setBounds(1060,410,250,60);           b8.setForeground(new Color(175,50,175));
  b9.setBounds(1060,490,250,60);           b9.setForeground(new Color(175,50,175));
 b10.setBounds(1060,570,250,60);           b10.setForeground(new Color(175,50,175));
  l1.setBounds(500,140,450,50);
  lbl.setBounds(150,200,50,50);


   l2 = new JLabel("PORT FITNESS CLUB, WEST MAHARASHTRA");
   l2.setBounds(50,0,1400,100);
   l2.setFont(new Font("Stencil",Font.BOLD,58));
   add(l2);


 l3 = new JLabel("", new ImageIcon("fit.jpg"), JLabel.CENTER);
  l3.setBounds(370,200,600,500);
  add(l3);



   
  b1.addActionListener(this);
  b2.addActionListener(this);
  b3.addActionListener(this);
  b4.addActionListener(this);
  b6.addActionListener(this);
  b5.addActionListener(this);
  b7.addActionListener(this);
  b8.addActionListener(this);
  b9.addActionListener(this);
  b10.addActionListener(this); 
  Container c1=getContentPane();
  c1.setLayout(null);

  c1.add(b1);
  c1.add(b2);
  c1.add(b3);
  c1.add(b4);
  c1.add(b6);
  c1.add(b5);
  c1.add(b7);
  c1.add(b8);
  c1.add(b9);
  c1.add(b10);
  c1.add(lbl); 
  c1.add(l1);
  
 
  setSize(1500,750);
  setVisible(true);
  this.setResizable(false);
//  this.setLocation(300,50);

  getContentPane().setBackground(Color.white);

  setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
 }
 public static void main(String args[])
 {
  new MyMenu();
 }
 public void actionPerformed(ActionEvent a1)
 {
    if(a1.getSource()==b9)
  {
  new int11();
   this.setVisible(false);
  }


  if(a1.getSource()==b8)
  {
   new Coach();
   this.setVisible(false);
  }


   if(a1.getSource()==b7)
  {
   new About();
   this.setVisible(false);
  }
 


  if(a1.getSource()==b1)
  {
   new AddCust();
   this.setVisible(false);
  }
  if(a1.getSource()==b2)
  {
   new DeleteCust();
   this.setVisible(false);
  }
  if(a1.getSource()==b3)
  {
   new Report();
   this.setVisible(false);              
  }
  if(a1.getSource()==b4)
  {
   new EditCust();
   this.setVisible(false);
  }
  if(a1.getSource()==b10)
  {
   new GymReport();
   this.setVisible(false);
  }
  
  if(a1.getSource()==b6)
  {
   new ToolInfo();
   this.setVisible(false);
  }
  if(a1.getSource()==b5)
  {
   try
   {
    String s1=a1.getActionCommand();
    if(s1.equals("EXIT"))
    {
     int res=JOptionPane.showConfirmDialog(null,"Do you want to exit?","EXIT",JOptionPane.YES_NO_OPTION);
     if(res==JOptionPane.YES_OPTION)
     {
      System.exit(0);
     }
    }
   }
   catch(Exception e) 
   {
    System.out.println("ERROR:"+e);
   }
  }
 }
}


