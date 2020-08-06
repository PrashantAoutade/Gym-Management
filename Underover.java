
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.applet.*;
import javax.swing.*;
class Mypanel5 extends JPanel
{
 JButton ok,mn,bk;
 public Mypanel5()
 {
  ok=new JButton("INFORMATION");
  mn=new JButton("MENU");
  bk=new JButton("BACK");
  
  add(ok);
  add(mn);
  add(bk);
  setBackground(Color.orange);
 } 
}
class Underover extends JFrame implements ActionListener
{
 Mypanel5 p5;
 JLabel res,msg,info;
 JTextField tinfo;
 JComboBox jres;
 Connection con1;
 Statement stmt;
 PreparedStatement pstmt;
 ResultSet rs1;
 public Underover()
 {
  super("Diet Information");
  res=new JLabel("RESULT");
  info=new JLabel("Information");
        
  msg=new JLabel();
      
  p5=new Mypanel5();
      
  p5.mn.addActionListener(this);
  p5.ok.addActionListener(this);
  p5.bk.addActionListener(this);
      
  p5.setBounds(20,350,550,40);
       
  jres=new JComboBox();
  tinfo=new JTextField();

  Font f=new Font("Comic Sans MS",4,50);
  msg.setFont(new Font("Comic Sans MS",3,30));
  msg.setForeground(Color.yellow);
  msg.setText("DIET INFORMATION");
   
  res.setBounds(60,100,50,20);         jres.setBounds(130,100,120,20);
  info.setBounds(60,150,80,20);       tinfo.setBounds(60,170,450,120);
        
  msg.setBounds(180,20,400,30);
  Container c1=getContentPane();
  c1.setLayout(null);

  c1.add(res);        c1.add(jres);
  c1.add(info);        c1.add(tinfo);
        
  c1.add(p5,"East");
  c1.add(msg);
  setSize(650,450);
  setVisible(true);
  tinfo.setEditable(false);
  this.setResizable(false);
  this.setLocation(300,100);
  setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
  try
  {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  }
  catch(ClassNotFoundException se)
  {
   System.out.println(se);
  }
  try
  {
   con1=DriverManager.getConnection("Jdbc:Odbc:health");
   System.out.println("Connection Establish Successfully....");
  }
  catch(SQLException se)
  {
   se.printStackTrace();
  }
  try
  {
   Statement stmt=con1.createStatement();
   ResultSet rs=stmt.executeQuery("select result from diet");
   while(rs.next())
   {
    jres.addItem(rs.getString(1));
   }
  }//tryclose
  catch(SQLException se)
  {
   System.out.println(se);
  }
 }
 public static void main(String args[])
 {
  new Underover();
 }
 public void actionPerformed(ActionEvent a1)
 {
  String s1=a1.getActionCommand();
  if(s1.equals("INFORMATION"))
  { 
   try
   {
    //String result;
    String r=jres.getSelectedItem().toString();
    //result=eString(r);
    pstmt=con1.prepareStatement("select * from diet where result=?");
    pstmt.setString(1,r);
    rs1=pstmt.executeQuery();
    while(rs1.next())
    {
     tinfo.setText(rs1.getString("diet"));
    }//while
   }//inner try      
   catch(NumberFormatException e1)
   {
    System.out.println(""+e1);
   }//catch
   catch(Exception e2)
   {
    System.out.println(""+e2);
   }//catch
  }
  else if(s1.equals("MENU"))
  {
   new MyMenu();
   this.setVisible(false);
  }//elseif
  
  else if(s1.equals("BACK"))
  {
    new AddCust();
    this.setVisible(false);
   }

 }


} 


