import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class CustDetail extends JFrame implements ActionListener
{
 JButton b1,b2,b3,b4;
 JLabel l1,l2,l3,l4,l5,l6,l7,l8;
 JTextField t2,t3,t4,t5,t6,t7;
 Connection conn;
 Statement stmt; 
 public CustDetail()
 {
  super("Details of Cutomer");
  b1=new JButton("UPDATE");
  b2=new JButton("CLEAR");
  b3=new JButton("MENU");
  b4=new JButton("BACK");
   
  l1=new JLabel();
  l2=new JLabel("CNO:");
  l3=new JLabel("HEIGHT");
  l4=new JLabel("WEIGHT");
  l5=new JLabel("CHEST");
  l6=new JLabel("THIGH");
  l7=new JLabel("SHOULDER");
  t2=new JTextField();
  t3=new JTextField();
  t4=new JTextField();
  t5=new JTextField();
  t6=new JTextField();
  t7=new JTextField();

  Font f=new Font("Comic Sans MS",Font.PLAIN,50);
  l1.setFont(new Font("Comic Sans MS",Font.PLAIN,30));
  l1.setForeground(Color.orange);
  l1.setText("UPDATE CUSTOMERS PHYSICAL DETAILS");

  b1.setBounds(150,400,80,30);
  b2.setBounds(250,400,80,30);
  b3.setBounds(350,400,80,30);
  b4.setBounds(450,400,80,30);
  
  l1.setBounds(20,40,650,40);
  l2.setBounds(100,100,70,20);    t2.setBounds(200,100,70,20); 
  l3.setBounds(100,150,70,20);    t3.setBounds(200,150,70,20); 
  l4.setBounds(100,200,70,20);    t4.setBounds(200,200,70,20);
  l5.setBounds(100,250,70,20);    t5.setBounds(200,250,70,20); 
  l6.setBounds(100,300,70,20);    t6.setBounds(200,300,70,20);
  l7.setBounds(100,350,70,20);    t7.setBounds(200,350,70,20);


   l8 = new JLabel("", new ImageIcon("C:/sunil/Gymm Management/Image/gym d1.jpg"), JLabel.CENTER);
   l8.setBounds(300,100,400,250);
   add(l8);


   
    getContentPane().setBackground(Color.white);

   
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
   
  c1.add(l1);
  c1.add(l2);     c1.add(t2);
  c1.add(l3);     c1.add(t3); 
  c1.add(l4);     c1.add(t4);
  c1.add(l5);     c1.add(t5);
  c1.add(l6);     c1.add(t6);
  c1.add(l7);     c1.add(t7);
   
  setSize(1500,750);
  this.setResizable(false);
  //setLocation(300,100);
  setVisible(true);
  setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
 }
 public static void main(String args[])
 {
  new CustDetail();
 }
 public void actionPerformed(ActionEvent a1)
 {
  if(a1.getSource()==b1)
  {
   if(t2.getText().length()==0)
   JOptionPane.showMessageDialog(null,"Please enter correct customer number."); 
   else
   {
    try
    { 
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     conn=DriverManager.getConnection("jdbc:odbc:health");
     System.out.println("Connection Successfully establish...");
                          
     String sql;
     sql="update updatecust set cno='"+(String)t2.getText()+
                                     "',ht='"+(String)t3.getText()+
                                     "',wt='"+(String)t4.getText()+
                                     "',chest='"+(String)t5.getText()+
                                     "',thigh='"+(String)t6.getText()+
                                     "',shoulder='"+(String)t7.getText()+
                                     "'where cno='"+(String)t2.getText()+"'";
     stmt=conn.createStatement();
     try
     {
      stmt.executeUpdate(sql);
     }
     catch(Exception e)
     {
      System.out.println("Connection Error"+e);
      System.exit(0);
     }
     JOptionPane.showMessageDialog(null,"Record updated Successfully");
    } 
    catch(Exception e)
    {
     System.out.printf("ERROR:"+e);
    }  
   }
  }
  else
  if(a1.getSource()==b2)
  {
   t2.setText(null);
   t3.setText(null);
   t4.setText(null);
   t5.setText(null);
   t6.setText(null);
   t7.setText(null);
   t2.requestFocus();
  }
  else
  if(a1.getSource()==b3)
  {
   new MyMenu();
   this.setVisible(false);               
  }
  else
  if(a1.getSource()==b4)
  {
   new EditCust();
   this.setVisible(false);               
  }
 }
}
 
