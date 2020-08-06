
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.applet.*;
import javax.swing.*;
class Mypanel3 extends JPanel
{
 JButton del,cl,mn;
 Mypanel3()
 {
  del=new JButton("DELETE");
  cl=new JButton("CLEAR");
  mn=new JButton("MENU");

  add(del);
  add(cl);
  add(mn);
  setBackground(Color.pink);
  setBounds(00,200,350,40);
 }
}
class DeleteCust extends JFrame implements ActionListener
{
 Mypanel3 p3;
 JLabel cno,msg;
 JTextField tcno;
 Connection conn;
 Statement stmt;
 PreparedStatement ps1;
 DeleteCust()
 {
  super("Delete Customer ");
  cno=new JLabel("CUSTOMER  NO");
        
  msg=new JLabel();
  Font f=new Font("TimesNewRoman",4,50);
  msg.setFont(new Font("Comic Sans MS",Font.PLAIN,25));
  msg.setForeground(Color.black);
  msg.setText("DELETE CUSTOMER ");
       
  p3=new Mypanel3();
  p3.del.addActionListener(this);
  p3.cl.addActionListener(this);
  p3.mn.addActionListener(this);
        
  tcno=new JTextField();
        
  cno.setBounds(80,120,100,20);
  tcno.setBounds(200,120,80,20);
  msg.setBounds(50,30,400,30);
        
  Container c1=getContentPane();
  c1.setLayout(null);

  c1.add(cno);
  c1.add(tcno);
  c1.add(msg);
  c1.add(p3,"South");
  setSize(450,350);
  setLocation(300,100);
  setVisible(true);
 }
 public void actionPerformed(ActionEvent a1)
 {  
  String s1=a1.getActionCommand();
  if(s1.equals("CLEAR"))
  {
   tcno.setText(null);
   tcno.requestFocus();
  }
  else if(s1.equals("MENU"))
  {
   new MyMenu();
   this.setVisible(false);
  }
  else if(s1.equals("DELETE"))
  {
   int cno,f=0;
   if(tcno.getText().length()==0)
   JOptionPane.showMessageDialog(null,"Please enter correct customer number."); 
   else
   {
    try
    { 
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     conn=DriverManager.getConnection("jdbc:odbc:health");
     System.out.println("Connection Successfully establish...");
                          
     String sql,sql1,sql0;
     sql0="select cno from addcust";
     Statement st=conn.createStatement();
     ResultSet rs=st.executeQuery(sql0);
     while(rs.next())
     {
      if(tcno.getText().equals(rs.getString("cno")))
      f=1;
     }               
     if(f==1)
     {
      sql="delete from addcust where cno='"+tcno.getText()+"'"; 
      sql1="delete from updatecust where cno='"+tcno.getText()+"'"; 
      stmt=conn.createStatement();
      try
      {
       stmt.executeUpdate(sql);
       stmt.executeUpdate(sql1);
       JOptionPane.showMessageDialog(null,"Record delete Successfully....."); 
      }
      catch(SQLException e)
      {
       System.out.println("Connection Error"+e);
       System.exit(0);
      }
      catch(Exception e)
      {
       System.out.printf("ERROR:"+e);
      }
     }
     else
     JOptionPane.showMessageDialog(null,"Please enter correct customer number."); 
    }
    catch(SQLException e)
    {
     System.out.println("Connection Error"+e);
     System.exit(0);
    }
    catch(Exception e)
    {
     System.out.printf("ERROR:"+e);
    }
   }
  }
 }
 public static void main(String args[])
 {
  new DeleteCust();
 }
}
