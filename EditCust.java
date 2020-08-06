

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class EditCust extends JFrame implements ActionListener
{
 JButton b1,b2,b3;
 JLabel l1,l2;
 public EditCust()
 {
  super("Details of Cutomer");
  b1=new JButton("CUSTOMER'S PHY. DETAILS");
  b2=new JButton("FEES DETAILS");
  b3=new JButton("MENU");
     
  l1=new JLabel();

  Font f=new Font("Comic Sans MS",Font.PLAIN,30);
  l1.setFont(new Font("Comic Sans MS",Font.PLAIN,30));
  l1.setForeground(Color.green);
  l1.setText("UPDATE CUSTOMER");


   l2 = new JLabel("", new ImageIcon("C:/sunil/Gymm Management/Image/Man.jpg"), JLabel.CENTER);
   l2.setBounds(200,220,400,400);
   add(l2);



  b1.setBounds(50,130,200,40);  
  b2.setBounds(100,180,200,40); 
  b3.setBounds(80,300,100,30);  
  
  l1.setBounds(120,20,350,30);
  
  b1.addActionListener(this);
  b2.addActionListener(this);
  b3.addActionListener(this);
  
  Container c1=getContentPane();
  c1.setLayout(null);

  c1.add(b1);
  c1.add(b2);
  c1.add(b3);
  c1.add(l1);

  getContentPane().setBackground(Color.white);
  setSize(1500,700);
  setResizable(false);
  setLocation(300,80);
  setVisible(true);
 }
 public static void main(String args[])
 {
  new EditCust();
 }
 public void actionPerformed(ActionEvent a1)
 {
  if(a1.getSource()==b1)
  {
   new CustDetail();
   this.setVisible(false);
  }
  else
  if(a1.getSource()==b2)
  {
   new FeesDetail();
   this.setVisible(false);
  }
  else
  if(a1.getSource()==b3)
  {
   new MyMenu();
   this.setVisible(false);                 
  }
 }
}
