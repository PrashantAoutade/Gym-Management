import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class ToolInfo extends JFrame implements ActionListener
{
 JButton b1,b2,b3,b4,b5;
 JLabel l1,l2,l3,l4,l5,l6;
 JTextField t2,t3,t4,t5;
 Connection conn;
 Statement stmt;
 ResultSet rs2;
 PreparedStatement pstat1,ps1;
 public ToolInfo()
 {
  super("Tool Deatils");
  b1=new JButton("ADD");
  b2=new JButton("CLEAR");
  b3=new JButton("MENU");
  b4=new JButton("REPORT");
  b5=new JButton("UPDATE");
   
  l1=new JLabel();
  l2=new JLabel("TOOL ID:");
  l3=new JLabel("TOOL NAME");
  l5=new JLabel("QUANTITY");
  
  t2=new JTextField();
  t3=new JTextField();
  t5=new JTextField();
  
  Font f=new Font("Comic Sans MS",4,50);
  l1.setFont(new Font("Comic Sans MS",3,20));
  l1.setForeground(Color.blue);
  l1.setText("TOOLS INFORMATION");

  b1.setBounds(70,300,80,30);
  b2.setBounds(170,300,80,30);
  b3.setBounds(270,300,80,30);
  b4.setBounds(370,300,100,30);
  b5.setBounds(490,300,80,30);
  
  l1.setBounds(120,50,650,20);
  l2.setBounds(100,100,70,20);    t2.setBounds(200,100,70,20); 
  l3.setBounds(100,150,70,20);    t3.setBounds(200,150,150,20); 
  l5.setBounds(100,200,70,20);    t5.setBounds(200,200,70,20); 
  
  b1.addActionListener(this);
  b2.addActionListener(this);
  b3.addActionListener(this);
  b4.addActionListener(this);
  b5.addActionListener(this);
    
  Container c1=getContentPane();
  c1.setLayout(null);

  c1.add(b1);
  c1.add(b2);
  c1.add(b3);
  c1.add(b4);
  c1.add(b5);
  
  c1.add(l1);
  c1.add(l2);  c1.add(t2);
  c1.add(l3);  c1.add(t3);
  c1.add(l5);  c1.add(t5);


   l6 = new JLabel("", new ImageIcon("C:/sunil/Gymm Management/Image/Dumbels.jpg"), JLabel.CENTER);
   l6.setBounds(425,60,225,200);
   c1.add(l6);


  
  setSize(700,500);
  setVisible(true);
  setLocation(200,100);
  try
  {          
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   conn=DriverManager.getConnection("jdbc:odbc:health");
   System.out.println("Connection Successfully establish");
  }
  catch(Exception e1)
  {
   System.out.println(""+e1);
  }
 }
 public static void main(String args[])
 {
  new ToolInfo();
 }
 public void actionPerformed(ActionEvent a1)
 {
  String tname,tdate;
  int tid,tqty;
  if(a1.getSource()==b1)
  {
   if(t2.getText().length()==0)
   JOptionPane.showMessageDialog(null,"Please Enter Information."); 
   try
    { 
     stmt=conn.createStatement();
     ps1=conn.prepareStatement("insert into tool values(?,?,?)");
     tid=Integer.parseInt(t2.getText());
     tname=t3.getText();
     tqty=Integer.parseInt(t5.getText());
     ps1.setInt(1,tid);
     ps1.setString(2,tname);
     ps1.setInt(3,tqty);
     ps1.executeUpdate();
     JOptionPane.showMessageDialog(null,"Record Inserted Successfully...");
    }//outer try
    catch(Exception e)
    {
     System.out.printf("ERROR:"+e);
    }//catch
   }//if
   else
   if(a1.getSource()==b2)
   {
    t2.setText(null);
    t3.setText(null);
    t5.setText(null);
    t2.requestFocus();
   }
   else
   if(a1.getSource()==b3)
   {
    new MyMenu();
    this.setVisible(false);               
   }
   else
   if(a1.getSource()==b5)
   {
    if(t2.getText().length()==0)
    JOptionPane.showMessageDialog(null,"Please enter correct tool id."); 
    else
    {
     try
     { 
      String sql;
      sql="update tool set tid='"+(String)t2.getText()+
                                "',tname='"+(String)t3.getText()+
                                "',tqty='"+(String)t5.getText()+
                                "'where tid='"+(String)t2.getText()+"'";
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
      JOptionPane.showMessageDialog(null,"Record Updated Successfully");
     }
     catch(Exception e)
     {
      System.out.printf("ERROR:"+e);
     }  
    }
   }
   else if(a1.getSource()==b4)
   {
    try 
    {
     if(t2.getText().length()==0)
     JOptionPane.showMessageDialog(null,"Please Enter Correct tool id.");
     int tid1;
     tid1=Integer.parseInt(t2.getText());
     Statement stat1=conn.createStatement();
     rs2=stat1.executeQuery("select * from tool");
     System.out.println(rs2.next());
     int t=rs2.getInt("tid");
     if(rs2!=null)
     {
      while(rs2.next())
      { 
       //System.out.println(t+" "+tid1);
       if(tid1==rs2.getInt("tid"))
       {
        //System.out.println("I Am Here");
        //flag=true;
        t3.setText(rs2.getString(2));
        t5.setText(String.valueOf(rs2.getInt(3)));
       }
       //t=rs2.getInt("tid");
      }
     }
    }
    catch(SQLException e3)
    {
     System.out.println("   "+e3);
    }
    catch(Exception e3)
    {
     System.out.println("   "+e3);
    }
   }  
 } 
}
 

