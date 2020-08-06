
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.applet.*;
class FeesDetail extends JFrame implements ActionListener
{
 JButton b0,b1,b2,b3,b4;
 JLabel l1,l2,l3,l4,l5,l6,l7,l8;
 JTextField t2,t3,t4,t5,t6,t7,t8;
 JComboBox j2;
 Connection con1;
 Statement stmt; 
 ResultSet rs,rs1,rs2; 
 PreparedStatement pstat1,pstat2;
 public FeesDetail()
 {
  super("Details of Customer");
  b0=new JButton("OK");
  b1=new JButton("UPDATE");
  b2=new JButton("CLEAR");
  b3=new JButton("MENU");
  b4=new JButton("BACK");
   
  l1=new JLabel();
  l2=new JLabel("CNO:");
  l3=new JLabel("COURSE NAME");
  l4=new JLabel("ADMISSION DATE");
  l5=new JLabel("END OF COURSE DATE");
  l6=new JLabel("TOTAL FEE");
  l7=new JLabel("FEE PAID");
  l8=new JLabel("FEE REMAINING");
   
  t2=new JTextField();
  t3=new JTextField();
  t4=new JTextField();
  t5=new JTextField();
  t6=new JTextField();
  t7=new JTextField();
  t8=new JTextField();

  Font f=new Font("Comic Sans MS",Font.PLAIN,50);
  l1.setFont(new Font("Comic Sans MS",Font.PLAIN,25));
  l1.setForeground(Color.blue);
  l1.setText("UPDATE FEES DETAILS");

  b0.setBounds(330,95,70,30);
  b1.setBounds(100,400,80,30);
  b2.setBounds(200,400,80,30);
  b3.setBounds(300,400,80,30);
  b4.setBounds(400,400,80,30);
  
  l1.setBounds(200,40,500,30);
  l2.setBounds(100,100,70,20);        t2.setBounds(200,100,100,20); 
  l3.setBounds(100,150,170,20);       t3.setBounds(200,150,200,20); 
  l4.setBounds(100,200,170,20);       t4.setBounds(200,200,100,20);
  l5.setBounds(400,200,170,20);       t5.setBounds(550,200,100,20); 
  l6.setBounds(100,250,70,20);        t6.setBounds(200,250,100,20); 
  l7.setBounds(100,300,70,20);        t7.setBounds(200,300,100,20);
  l8.setBounds(400,300,170,20);       t8.setBounds(550,300,100,20); 
   
  t3.setEditable(false);
  t4.setEditable(false);
  t5.setEditable(false);
  t6.setEditable(false);
  t8.setEditable(false);
   
  b0.addActionListener(this);
  b1.addActionListener(this);
  b2.addActionListener(this);
  b3.addActionListener(this);
  b4.addActionListener(this);
  
     
  Container c1=getContentPane();
  c1.setLayout(null);
  c1.add(b0);
  c1.add(b1);
  c1.add(b2);
  c1.add(b3);
  c1.add(b4);
  
  c1.add(l1);
  c1.add(l2);c1.add(t2);
  c1.add(l3);c1.add(t3); 
  c1.add(l4);c1.add(t4);
  c1.add(l5);c1.add(t5);
  c1.add(l6);c1.add(t6);
  c1.add(l7);c1.add(t7);
  c1.add(l8);c1.add(t8);

  setLocation(300,100);
  setSize(1500,700);
  setVisible(true);
   
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
 }
 public static void main(String args[])
 {
  new FeesDetail();
 }
 public void actionPerformed(ActionEvent a1)
 {
  //String tc,ta,te,tf;
  if(a1.getSource()==b0)
  {
   if(t2.getText().length()==0)
   JOptionPane.showMessageDialog(null,"Please enter customer number."); 
   try
   {
    int custno;
    String custom=t2.getText();
    custno=Integer.parseInt(custom);
    String coname;
    //coname=t3.getText();
    //System.out.println(""+coname);
    pstat1=con1.prepareStatement("select * from addcust where cno=?");
    //pstat2=con1.prepareStatement("select * from course ");
   
    pstat1.setInt(1,custno);
    rs1=pstat1.executeQuery();
    //rs2=pstat2.executeQuery();
     
    while(rs1.next())
    {
     t3.setText(rs1.getString("course"));
     t4.setText(rs1.getString("adate"));
     t5.setText(rs1.getString("ecodate"));
     //t6.setText(rs1.getString("totfee"));
     t7.setText(rs1.getString("feepaid"));
    }//while
    pstat2=con1.prepareStatement("select * from course");
    rs2=pstat2.executeQuery();
      
    while(rs2.next())
    { 
     String cname=rs2.getString("coname");
     if(cname.equals(t3.getText()))
     {
      //System.out.println(""+cname);
      t6.setText(rs2.getString("fees"));
     }
    }
    int tot=Integer.parseInt(t6.getText());
    int fpaid=Integer.parseInt(t7.getText());
    int frem=(tot-fpaid);
    String fremen=Integer.toString(frem);
    t8.setText(fremen);
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
  else
  if(a1.getSource()==b1)
  {
   try
   {                        
    String sql;
    sql="update addcust set feepaid='"+t7.getText()+"' where cno='"+t2.getText()+"'";
	stmt=con1.createStatement();
    try
    {
     stmt.executeUpdate(sql);
     JOptionPane.showMessageDialog(null,"Record updated Successfully");
    }
    catch(Exception e)
    {
     System.out.println("Connection Error"+e);
     System.exit(0);
    }
    
   }
   catch(Exception e)
   {
    System.out.printf("ERROR:"+e);
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
   t8.setText(null);
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
