import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.applet.*;
import javax.swing.*;
class Mypanel1 extends JPanel
{
 JButton ad,ext,cl,mn,cal;
 public Mypanel1()
 {
  ad=new JButton("ADD");
  ad.setToolTipText("Add New Customer Record");
  cl=new JButton("CLEAR");
  cl.setToolTipText("Clear Records");
  mn=new JButton("MENU");
  mn.setToolTipText("Menu Frame");
  cal=new JButton("RESULT");
  cal.setToolTipText("Calculate Result");  



     
  add(ad);
  add(cl);
  add(mn);
  add(cal);
  setBackground(Color.orange);
 }
}
class AddCust extends JFrame implements ActionListener
{
 Mypanel1 p1;
 JLabel cno,cname,adate,ecodate,addr,phno,ht,age,wt,msg,thigh,chest,shoulder,r,coursename,feepaid,gen,l3;
 JTextField tcno,tcname,tadate,tecodate,taddr,tphno,tht,twt,tage,tthigh,tchest,tshoulder,tr,tcoursename,tfeepaid;
 JComboBox dd1,mm1,yyyy1,jgen,dd2,mm2,yyyy2;
 JButton ok;
 Connection conn;
 Statement stmt;
 PreparedStatement ps1,ps2;
 ResultSet rs;
 public AddCust()
 {
  super("Customer Details");
  cno=new JLabel("Customer No");
  cname=new JLabel("Customer Name");
  adate=new JLabel("Admission Date");
  ecodate=new JLabel("End of Course Date");
  addr=new JLabel("Address");
  phno=new JLabel("Tele No");
  ht=new JLabel("Height");
  age=new JLabel("Age");
  gen=new JLabel("Gender");
  wt=new JLabel("Weight");
  thigh=new JLabel("Thigh");
  chest=new JLabel("Chest");
  shoulder=new JLabel("Shoulder");
  r=new JLabel("Result");
  coursename=new JLabel("Course Name");
  feepaid=new JLabel("Fee Paid");
  msg=new JLabel();

  ok=new JButton("OK");
 l3 = new JLabel("PORT FITNESS CLUB, WEST MAHARASHTRA");
   l3.setBounds(50,0,1400,100);
   l3.setFont(new Font("Stencil",Font.BOLD,58));
   add(l3);
 





        
  p1=new Mypanel1();
  p1.ad.addActionListener(this);
  p1.cl.addActionListener(this);
  p1.mn.addActionListener(this);
  p1.cal.addActionListener(this);
  ok.addActionListener(this);
        
  p1.setBounds(0,600,600,40);


  
       
  tcno=new JTextField();
  tcname=new JTextField();
  tadate=new JTextField();
  tecodate=new JTextField();
  taddr=new JTextField();
  tphno=new JTextField();
  tht=new JTextField();
  tage=new JTextField();
  twt=new JTextField();
  tthigh=new JTextField();
  tchest=new JTextField();
  tshoulder=new JTextField();
  tr=new JTextField();
  tcoursename=new JTextField();
  tfeepaid=new JTextField();
  tr.setEditable(false);
      
  Font f=new Font("Comic Sans MS",4,50);
  msg.setFont(new Font("System",3,40));
  msg.setForeground(Color.red);
  msg.setText("CUSTOMER DETAILS");

  dd1=new JComboBox();
  dd1.addItem("Day");
  for(int i=1;i<32;i++)
  dd1.addItem(""+i);

  mm1=new JComboBox();
  mm1.addItem("Month");
  for(int i=1;i<13;i++)
  mm1.addItem(""+i);

  yyyy1=new JComboBox();
  yyyy1.addItem("Year");
  for(int i=2010;i<2018;i++)
  yyyy1.addItem(""+i);

  dd2=new JComboBox();
  dd2.addItem("Day");
  for(int i=1;i<32;i++)
  dd2.addItem(""+i);

  mm2=new JComboBox();
  mm2.addItem("Month");
  for(int i=1;i<13;i++)
  mm2.addItem(""+i);

  yyyy2=new JComboBox();
  yyyy2.addItem("Year");
  for(int i=2010;i<2018;i++)
  yyyy2.addItem(""+i);

  jgen=new JComboBox();
  jgen.addItem("MALE");
  jgen.addItem("FEMALE");

  cno.setBounds(30,140,100,20);                 tcno.setBounds(180,140,50,20);
  cname.setBounds(30,170,100,20);             tcname.setBounds(180,170,300,20);
  addr.setBounds(30,200,100,20);              taddr.setBounds(180,200,300,20);
  adate.setBounds(30,230,100,20);             //tadate.setBounds(180,320,200,20);
  ecodate.setBounds(400,400,150,20);        //tecodate.setBounds(180,320,200,20);
  phno.setBounds(30,260,100,20);             tphno.setBounds(180,260,150,20);
  age.setBounds(30,290,100,20);               tage.setBounds(180,290,50,20);
  gen.setBounds(30,320,100,20);               jgen.setBounds(180,320,100,20);
  ht.setBounds(30,350,100,20);                 tht.setBounds(180,350,50,20);
  wt.setBounds(30,380,100,20);                twt.setBounds(180,380,50,20);
  thigh.setBounds(30,410,100,20);            tthigh.setBounds(180,410,50,20);
  chest.setBounds(30,440,100,20);            tchest.setBounds(180,440,50,20);
  shoulder.setBounds(30,470,100,20);        tshoulder.setBounds(180,470,50,20);
  coursename.setBounds(30,500,100,20);   tcoursename.setBounds(180,500,150,20);
  feepaid.setBounds(30,530,100,20);         tfeepaid.setBounds(180,530,100,20);
  r.setBounds(30,560,100,20);                  tr.setBounds(180,560,150,20);

  ok.setBounds(350,560,60,20);
  msg.setBounds(480,90,550,30);

  dd1.setBounds(180,230,50,20);
  mm1.setBounds(230,230,60,20);
  yyyy1.setBounds(290,230,80,20);
      
  dd2.setBounds(350,430,50,20);
  mm2.setBounds(400,430,60,20);
  yyyy2.setBounds(460,430,80,20);

  Container c1=getContentPane();
  c1.setLayout(null);

  c1.add(cno);        c1.add(tcno);
  c1.add(cname);      c1.add(tcname);
  c1.add(adate);
  c1.add(ecodate);
  c1.add(addr);       c1.add(taddr);
  c1.add(phno);       c1.add(tphno);
  c1.add(ht);         c1.add(tht);
  c1.add(age);        c1.add(tage);
  c1.add(gen);        c1.add(jgen);
  c1.add(wt);         c1.add(twt);
  c1.add(thigh);      c1.add(tthigh);
  c1.add(chest);      c1.add(tchest);
  c1.add(shoulder);   c1.add(tshoulder);
  c1.add(r);          c1.add(tr);
  c1.add(coursename); c1.add(tcoursename);
  c1.add(feepaid);    c1.add(tfeepaid);
      
  c1.add(ok);
                
  c1.add(dd1);c1.add(mm1);c1.add(yyyy1);
  c1.add(dd2);c1.add(mm2);c1.add(yyyy2);
       
  c1.add(p1,"East");
  c1.add(msg);
  setSize(1500,7500);
  setVisible(true);
  this.setResizable(false);
 // setLocation(150,50);
  setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
 
 }
 public static void main(String args[])
 {
  new AddCust();
 }
	 public void actionPerformed(ActionEvent a1)
 {
  String dd3,mm3,yyyy3,dd4,mm4,yyyy4,gender,adate,ecodate,cname;
  int cpno,cage,feepaid;
  String ht,wt,thigh,chest,shoulder,addr,course,tel,cno ;
  String s1=a1.getActionCommand();
         
  if(s1.equals("ADD"))
  {
   try
   { 
    try
    {          
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     conn=DriverManager.getConnection("jdbc:odbc:health");
     System.out.println("Connection Successfully establish");
     stmt=conn.createStatement();
     ps1=conn.prepareStatement("insert into addcust values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
     ps2=conn.prepareStatement("insert into updatecust values(?,?,?,?,?,?)");
    }
    catch(Exception e)
    {
     System.out.println("Connection Error"+e);
     System.exit(0);
    }
    cno=tcno.getText();
    cname=tcname.getText();
    addr=taddr.getText();
    dd3=(String)dd1.getSelectedItem();
    mm3=(String)mm1.getSelectedItem();
    yyyy3=(String)yyyy1.getSelectedItem();
    dd4=(String)dd2.getSelectedItem();
    mm4=(String)mm2.getSelectedItem();
    yyyy4=(String)yyyy2.getSelectedItem();
    gender=(String)jgen.getSelectedItem();
    adate=(String)dd3+"/"+mm3+"/"+yyyy3;
    ecodate=(String)dd4+"/"+mm4+"/"+yyyy4;
    tel=tphno.getText();
    cage=Integer.parseInt(tage.getText());
    ht=tht.getText();
    wt=twt.getText();
    thigh=tthigh.getText();
    chest=tchest.getText();
    shoulder=tshoulder.getText();
    course=tcoursename.getText();
    feepaid=Integer.parseInt(tfeepaid.getText());
              
    ps1.setString(1,cno);
    ps2.setString(1,cno);
    ps1.setString(2,cname);
    ps1.setString(3,addr);
    ps1.setString(4,adate);
    ps1.setString(5,ecodate);
    ps1.setString(6,tel);
    ps1.setInt(7,cage);
    ps1.setString(8,gender);
    ps1.setString(9,ht);
    ps2.setString(2,ht);
    ps1.setString(10,wt);
    ps2.setString(3,wt);
    ps1.setString(11,thigh);
    ps2.setString(5,thigh);
    ps1.setString(12,chest);
    ps2.setString(4,chest);
    ps1.setString(13,shoulder);
    ps2.setString(6,shoulder);
    ps1.setString(14,course);
    ps1.setInt(15,feepaid);
             
    ps1.executeUpdate();
    ps2.executeUpdate();
    JOptionPane.showMessageDialog(null,"Record Inserted Successfully...");
   }
   catch(ArrayIndexOutOfBoundsException e1)
   {
    System.out.println(""+e1);
   }
   catch(Exception e)
   {
    System.out.printf("ERROR:"+e);
   }
  }
  else  
  if(s1.equals("CLEAR"))
  {
   tcno.setText(null);
   tcname.setText(null);
   //dd1.setText(null);
   //mm1.setText(null);
   //yyyy1.setText(null);
   //dd2.setText(null);
   //mm2.setText(null);
   //yyyy2.setText(null);
   taddr.setText(null);
   tphno.setText(null);
   tht.setText(null);
   tage.setText(null);
   twt.setText(null);
   tthigh.setText(null);
   tchest.setText(null);
   tshoulder.setText(null);
   tcoursename.setText(null);
   tfeepaid.setText(null);
   tr.setText(null);
   tcno.requestFocus();
  }//if
  else if(s1.equals("MENU"))
  {
   new MyMenu();
   this.setVisible(false);
  }//elseif
  else if(s1.equals("OK"))
  {
   new Underover();
   this.setVisible(false);
  }//elseif
  else if(s1.equals("RESULT"))
  {
   double het=Double.parseDouble(tht.getText());
   double wgt=Double.parseDouble(twt.getText());
   String msg="Fine";
      
       if(het==6.3)
       {
       	 if(wgt<81)
       	  msg="Underweight";
       	 else
       	  if(wgt>88)
       	   msg="Overweight";
       	  else
       	   msg="Fine";
       	     
       }
       tr.setText(msg);   
       
       if(het==6.2)
       {
       	 if(wgt<78)
       	  msg="Underweight";
       	 else
       	  if(wgt>84)
       	   msg="Overweight";
       	  else
       	   msg="Fine";
       	     
       }
       tr.setText(msg);     
       if(het==6.1)
       {
       	 if(wgt<75)
       	  msg="Underweight";
       	 else
       	  if(wgt>80)
       	   msg="Overweight";
       	  else
       	   msg="Fine";
       	     
       }
       tr.setText(msg);     
       
       if(het==6.0)
       {
       	 if(wgt<72)
       	  msg="Underweight";
       	 else
       	  if(wgt>76)
       	   msg="Overweight";
       	  else
       	   msg="Fine";
       	     
       }
       tr.setText(msg);     
       
       if(het==5.11)
       {
       	 if(wgt<70)
       	  msg="Underweight";
       	 else
       	  if(wgt>76)
       	   msg="Overweight";
       	  else
       	   msg="Fine";
       	     
       }
       tr.setText(msg);     
       if(het==5.10)
       {
       	 if(wgt<69)
       	  msg="Underweight";
       	 else
       	  if(wgt>75)
       	   msg="Overweight";
       	  else
       	   msg="Fine";
       	     
       }
       tr.setText(msg);     
       
       if(het==5.9)
       {
       	 if(wgt<68)
       	  msg="Underweight";
       	 else
       	  if(wgt>74)
       	   msg="Overweight";
       	  else
       	   msg="Fine";
       	     
       }
       tr.setText(msg);     
       
       if(het==5.8)
       {
       	 if(wgt<67)
       	  msg="Underweight";
       	 else
       	  if(wgt>73)
       	   msg="Overweight";
       	  else
       	   msg="Fine";
       	     
       }
       tr.setText(msg);     
       
       if(het==5.7)
       {
       	 if(wgt<66)
       	  msg="Underweight";
       	 else
       	  if(wgt>72)
       	   msg="Overweight";
       	  else
       	   msg="Fine";
       	     
       }
       tr.setText(msg);     
       
       if(het==5.6)
       {
       	 if(wgt<65)
       	  msg="Underweight";
       	 else
       	  if(wgt>70)
       	   msg="Overweight";
       	  else
       	   msg="Fine";
       	     
       }
       tr.setText(msg);     
       
       if(het==5.5)
       {
       	 if(wgt<64)
       	  msg="Underweight";
       	 else
       	  if(wgt>69)
       	   msg="Overweight";
       	  else
       	   msg="Fine";
       	     
       }
       tr.setText(msg);     
       
       if(het==5.4)
       {
       	 if(wgt<63)
       	  msg="Underweight";
       	 else
       	  if(wgt>68)
       	   msg="Overweight";
       	  else
       	   msg="Fine";
       	     
       }
       tr.setText(msg);     
       
       if(het==5.3)
       {
       	 if(wgt<62)
       	  msg="Underweight";
       	 else
       	  if(wgt>67)
       	   msg="Overweight";
       	  else
       	   msg="Fine";
       	     
       }
       tr.setText(msg);     
       
       if(het==5.2)
       {
       	 if(wgt<55)
       	  msg="Underweight";
       	 else
       	  if(wgt>60)
       	   msg="Overweight";
       	  else
       	   msg="Fine";
       	     
       }
       tr.setText(msg);     
 	    
 	    if(het==5.1)
       {
       	 if(wgt<50)
       	  msg="Underweight";
       	 else
       	  if(wgt>54)
       	   msg="Overweight";
       	  else
       	   msg="Fine";
       	     
       }
       tr.setText(msg); 
       
       if(het==5.0)
       {
       	 if(wgt<47)
       	  msg="Underweight";
       	 else
       	  if(wgt>52)
       	   msg="Overweight";
       	  else
       	   msg="Fine";
       	     
       }
       tr.setText(msg); 	     
     }
     
 }
}
