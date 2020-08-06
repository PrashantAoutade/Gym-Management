
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener
{
 JLabel msg1,user,pass,lbl,lbl1,l3,l4;
 JTextField u1;
 JPasswordField p1;
 JButton b1,b2,b3;
 public Login()
 {
  super("LOGIN PASSWORD"); 
  msg1=new JLabel();
  Font f=new Font("Comic Sans MS",Font.PLAIN,50);
  msg1.setFont(new Font("Stencil",Font.PLAIN,38));
  msg1.setForeground(Color.blue);
  msg1.setText("LOGIN PORT MEMBER");

  Font f1=new Font("Comic Sans MS",Font.PLAIN,26);

  user=new JLabel("User Name");
  user.setFont(f1);
  user.setForeground(Color.blue);
  pass=new JLabel("Password");
  pass.setFont(f1);
  pass.setForeground(Color.blue);
  u1=new JTextField(30);
  u1.setForeground(Color.magenta);
  u1.setFont(new Font("Papyrus",Font.BOLD,28));

  p1=new JPasswordField(10);
  p1.setForeground(Color.magenta);
  p1.setFont(new Font("Papyrus",Font.BOLD,28));

  b1=new JButton("OK");
  b1.setFont(f1);
  b1.setForeground(Color.blue); 
//  b1.setBackground(Color.orange); 
  b2=new JButton("CLEAR");
  b2.setFont(f1);
  b2.setForeground(Color.blue);
  b3=new JButton("EXIT");
  b3.setFont(f1);
  b3.setForeground(Color.blue);

   l3 = new JLabel("PORT FITNESS CLUB, WEST MAHARASHTRA");
   l3.setBounds(50,0,1400,100);
   l3.setFont(new Font("Stencil",Font.BOLD,58));
   add(l3);

  
  l4 = new JLabel("", new ImageIcon("log1.jpg"), JLabel.CENTER);
  l4.setBounds(700,100,600,500);
  add(l4);




  Container c=getContentPane();
  getContentPane().setBackground(Color.orange);     //khaki
                
  setSize(1500,750);
  setTitle("Login");
  c.setLayout(null);
 
  this.setResizable(false);
  setVisible(true);
  setDefaultCloseOperation(EXIT_ON_CLOSE);
    
  c.add(msg1);
  c.add(user);   c.add(u1);
  c.add(pass);   c.add(p1);
  c.add(b1);
  c.add(b2);
  c.add(b3);

  msg1.setBounds(140,140,500,100);
  user.setBounds(130,280,200,65); u1.setBounds(360,280,170,45);
  pass.setBounds(140,360,200,55);  p1.setBounds(360,360,170,45);
  b1.setBounds(110,483,120,60);
  b2.setBounds(270,483,140,60);
  b3.setBounds(460,483,120,60);

  b1.addActionListener(this);
  b1.setActionCommand("ok");
  b3.addActionListener(this);
  b2.addActionListener(this);
 }
 public static void main(String args[])
 {
  new Login();
 } 
 public void actionPerformed(ActionEvent a1)
 {
  String str=a1.getActionCommand();
  JButton b4=(JButton)a1.getSource();
  if(b4==b3)
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
     u1.requestFocus();
    }
   }
   catch(Exception e)
   {
    System.out.println("ERROR:"+e);
   }
  }
  else
  if(b4==b2)
  {
   u1.setText(null);
   p1.setText(null);
   u1.requestFocus();
  } 
  if(str.equals("ok"))
  {
   Connection con;
   Statement stmt;
   Boolean flag=false;
   try
   {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    con=DriverManager.getConnection("Jdbc:Odbc:health");
	System.out.println("driver regester");
    stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select * from admin");
    while(rs.next())
    {
     if(u1.getText().equals(rs.getString(1)) && p1.getText().equals(rs.getString(2)))
     {
      flag=true;
      JOptionPane.showMessageDialog(null,"Login Successfully");
 new MyMenu();
      this.setVisible(false);
     } 
    } 
   }
   catch(SQLException sql)
   {
    System.out.println("Exception Generated:"+sql);
   }
   catch(Exception e1)
   {
    System.out.println("Exception Generated:"+e1);
   }
   if(flag==false)
   {
    JOptionPane.showMessageDialog(null,"Invalid User","Error",JOptionPane.ERROR_MESSAGE);
    u1.setText(null);
    p1.setText(null);
    u1.requestFocus();
   }
  }
 }
}
