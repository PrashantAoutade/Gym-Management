import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.applet.*;
import javax.swing.*;
class Mypanel4 extends JPanel
{
 JButton ok,cl,mn;
 public Mypanel4()
 {
  ok=new JButton("REPORT");
  cl=new JButton("CLEAR");
  mn=new JButton("MENU");
     
  add(cl);
  add(ok);
  add(mn);
  setBackground(Color.cyan);
 }
}
class Report extends JFrame implements ActionListener
{
 Mypanel4 p4;
 JLabel cno,cname,adate,addr,oht,age,owt,msg,othigh,ochest,oshoulder;
 JLabel coursename,feepaid,nht,nwt,nthigh,nchest,nshoulder;
 JTextField tcno,tcname,tadate,taddr,toht,towt,tage,tothigh,tochest;
 JTextField toshoulder,tcoursename,tfeepaid,tnht,tnwt,tnthigh,tnchest,tnshoulder;
 JComboBox jcno;
 JButton ok1;
 Connection conn,con1;
 Statement stmt,stmt1;
 PreparedStatement pstat1,pstat2;
 ResultSet rs1,rs2;
 public Report()
 {
  super("Customer Details");
  cno=new JLabel("Custmer No");
  cname=new JLabel("Customer Name");
  adate=new JLabel("Admission Date");
  addr=new JLabel("Address");
  age=new JLabel("Age");
  oht=new JLabel("Old Height");
  owt=new JLabel("Old Weight");
  othigh=new JLabel("Old Thigh");
  ochest=new JLabel("Old Chest");
  oshoulder=new JLabel("Old Shoulder");
  nht=new JLabel("Updated Height");
  nwt=new JLabel("Updated Weight");
  nthigh=new JLabel("Updated Thigh");
  nchest=new JLabel("Updated Chest");
  nshoulder=new JLabel("Updated Shoulder");
  coursename=new JLabel("Course Name");
  feepaid=new JLabel("Fee Paid");
      
  msg=new JLabel();
  ok1=new JButton("OK");
       
  p4=new Mypanel4();
  p4.cl.addActionListener(this);
  p4.mn.addActionListener(this);
  p4.ok.addActionListener(this);
  ok1.addActionListener(this);
      
  p4.setBounds(0,550,550,40);
       
  tcno=new JTextField();
  tcname=new JTextField();
  tadate=new JTextField();
  taddr=new JTextField();
  tage=new JTextField();
  toht=new JTextField();
  towt=new JTextField();
  tothigh=new JTextField();
  tochest=new JTextField();
  toshoulder=new JTextField();
  tnht=new JTextField();
  tnwt=new JTextField();
  tnthigh=new JTextField();
  tnchest=new JTextField();
  tnshoulder=new JTextField();
  tcoursename=new JTextField();
  tfeepaid=new JTextField();
  jcno=new JComboBox();

  Font f=new Font("Comic Sans MS",Font.PLAIN,25);
  msg.setFont(new Font("Comic Sans MS",Font.PLAIN,25));
  msg.setForeground(Color.red);
  msg.setText("CUSTOMER REPORT");

  cno.setBounds(30,70,100,20);         jcno.setBounds(180,70,70,20);
  cname.setBounds(30,110,100,20);       tcname.setBounds(180,110,300,20);
  addr.setBounds(30,150,100,20);        taddr.setBounds(180,150,300,20);
  adate.setBounds(30,190,100,20);       tadate.setBounds(180,190,100,20);
  age.setBounds(30,230,100,20);         tage.setBounds(180,230,50,20);
  oht.setBounds(30,270,100,20);          toht.setBounds(180,270,50,20);
  owt.setBounds(30,310,100,20);          towt.setBounds(180,310,50,20);
  othigh.setBounds(30,350,100,20);       tothigh.setBounds(180,350,50,20);
  ochest.setBounds(30,390,100,20);       tochest.setBounds(180,390,50,20);
  oshoulder.setBounds(30,430,100,20);    toshoulder.setBounds(180,430,50,20);
  nht.setBounds(310,270,100,20);          tnht.setBounds(430,270,50,20);
  nwt.setBounds(310,310,100,20);          tnwt.setBounds(430,310,50,20);
  nthigh.setBounds(310,350,100,20);       tnthigh.setBounds(430,350,50,20);
  nchest.setBounds(310,390,100,20);       tnchest.setBounds(430,390,50,20);
  nshoulder.setBounds(310,430,120,20);    tnshoulder.setBounds(430,430,50,20);
  coursename.setBounds(30,470,100,20);  tcoursename.setBounds(180,470,150,20);
  feepaid.setBounds(30,510,100,20);     tfeepaid.setBounds(180,510,100,20);
  msg.setBounds(180,20,400,30);
  ok1.setBounds(520,350,60,20);

  Container c1=getContentPane();
  c1.setLayout(null);
  c1.add(cno);         c1.add(jcno);
  c1.add(cname);       c1.add(tcname);
  c1.add(adate);       c1.add(tadate);
  c1.add(addr);        c1.add(taddr);
  c1.add(age);         c1.add(tage);
  c1.add(oht);         c1.add(toht);
  c1.add(owt);         c1.add(towt);
  c1.add(othigh);      c1.add(tothigh);
  c1.add(ochest);      c1.add(tochest);
  c1.add(oshoulder);   c1.add(toshoulder);
  c1.add(nht);         c1.add(tnht);
  c1.add(nwt);         c1.add(tnwt);
  c1.add(nthigh);      c1.add(tnthigh);
  c1.add(nchest);      c1.add(tnchest);
  c1.add(nshoulder);   c1.add(tnshoulder);
  c1.add(coursename);  c1.add(tcoursename);
  c1.add(feepaid);     c1.add(tfeepaid);
  c1.add(ok1);
        
  c1.add(p4,"East");
  c1.add(msg);
  setSize(650,650);
  setLocation(300,40);
  setVisible(true);
  tcname.setEditable(false);
  tcname.setEditable(false);tadate.setEditable(false);taddr.setEditable(false);
  tage.setEditable(false);toht.setEditable(false);towt.setEditable(false);
  tothigh.setEditable(false);tochest.setEditable(false);toshoulder.setEditable(false);
  tnht.setEditable(false);tnwt.setEditable(false);tnthigh.setEditable(false);
  tnchest.setEditable(false);tnshoulder.setEditable(false);tcoursename.setEditable(false);
  tfeepaid.setEditable(false);
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
   con1=DriverManager.getConnection("Jdbc:Odbc:mydsn");
   System.out.println("Connection Establish Successfully....");
  }
  catch(SQLException se)
  {
   se.printStackTrace();
  }
  try
  {
   Statement stmt=con1.createStatement();
   ResultSet rs=stmt.executeQuery("select cno from addcust");
   //ResultSet rs1=stmt.executeQuery("select cno from updatecust");
   while(rs.next())
   {
    jcno.addItem(rs.getInt(1));
   }
  }//tryclose
  catch(SQLException se)
  {
   System.out.println(se);
  }
 }
 public static void main(String args[])
 {
  new Report();
 }
 public void actionPerformed(ActionEvent a1)
 {
  String s1=a1.getActionCommand();
  if(s1.equals("REPORT"))
  { 
   try
   {
    int custno;
    String c=jcno.getSelectedItem().toString();
    custno=Integer.parseInt(c);
    pstat1=con1.prepareStatement("select * from addcust where cno=?");
    //pstat2=con1.prepareStatement("select * from updatecust where cno=?");
    pstat1.setInt(1,custno);
    // pstat2.setInt(1,custno);
    rs1=pstat1.executeQuery();
    // rs2=pstat2.executeQuery();
    while(rs1.next())
    {
     tcname.setText(rs1.getString("cname"));
     tadate.setText(rs1.getString("adate"));
     taddr.setText(rs1.getString("addr"));
     tage.setText(rs1.getString("cage"));
     toht.setText(rs1.getString("ht"));
     towt.setText(rs1.getString("wt"));
     tothigh.setText(rs1.getString("thigh"));
     tochest.setText(rs1.getString("chest"));
     toshoulder.setText(rs1.getString("shoulder"));
     tcoursename.setText(rs1.getString("course"));
     tfeepaid.setText(rs1.getString("feepaid"));
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
  else  if(s1.equals("CLEAR"))
  {
   tcno.setText(null);
   tcname.setText(null);
   tadate.setText(null);
   taddr.setText(null);
   tage.setText(null);
   toht.setText(null);
   towt.setText(null);
   tothigh.setText(null);
   tochest.setText(null);
   toshoulder.setText(null);
   tnht.setText(null);
   tnwt.setText(null);
   tnthigh.setText(null);
   tnchest.setText(null);
   tnshoulder.setText(null);
   tcoursename.setText(null);
   tfeepaid.setText(null);
   tcno.requestFocus();
  }//if
  else  if(s1.equals("OK"))
  {  
   try
   {
    int custno;
    String c=jcno.getSelectedItem().toString();
    custno=Integer.parseInt(c);
    //pstat1=con1.prepareStatement("select * from addcust where cno=?");
    pstat2=con1.prepareStatement("select * from updatecust where cno=?");
    //pstat1.setInt(1,custno);
    pstat2.setInt(1,custno);
    // rs1=pstat1.executeQuery();
    rs2=pstat2.executeQuery();
    while(rs2.next())
    {
     tnht.setText(rs2.getString("ht"));
     tnwt.setText(rs2.getString("wt"));
     tnthigh.setText(rs2.getString("thigh"));
     tnchest.setText(rs2.getString("chest"));
     tnshoulder.setText(rs2.getString("shoulder"));
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
 }
}

