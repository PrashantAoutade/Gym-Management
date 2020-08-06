
	import javax.swing.*;
	import java.awt.*;
	import java.lang.*;
	import java.awt.event.*;
	import java.sql.*;
	import java.util.*;
	import java.io. *;
	public class Coach extends JFrame implements ActionListener
	{
		JPanel p;
		JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	              JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
		JComboBox cb1,cb2,cb3;
		String blist1[]={"male","female"};
	       // 	String blist2[]={"Batch1","Batch2","Batch3","Batch4","Batch5","Batch6"};

		JButton next,back,save,b5,b1,b2;
		Connection con;
	          // ResultSet rs,rs1;	
		PreparedStatement ps;	
		
	 public Coach()
	 {
			super("Coach Details");
			p=new JPanel();
			p.setLayout(null);
			getContentPane().add(p);   
			
			setSize(900,700);
			
		//	p.setBackground(Color.white);
			setVisible(true);
			setLocation(250,10);
			Font f=new Font("Times new Roman",Font.BOLD,40);
		              Font f1=new Font("Times new Roman",Font.BOLD,18);	
			Font f2=new Font("Bradley Hand ITC",Font.BOLD,30);	
			
		             l2=new JLabel("Coach Information ");
		             l2.setFont(f2);
		             l2.setForeground(new Color(102,10,102));
		             l2.setBounds(250,10,350,200);
		             p.add(l2);
		    
		            l3=new JLabel("Coach No:");
		            l3.setFont(f1);
		            l3.setBounds(80,160,100,100);
		            p.add(l3);
		            t1=new JTextField(20);
		            t1.setBounds(200,200,140,20);
		            p.add(t1);
		    
		           l4=new JLabel("Cname:");
		           l4.setFont(f1);
		           l4.setBounds(80,220,100,100);
		           p.add(l4);
		           t2=new JTextField(20);
		           t2.setBounds(200,260,140,20);
		           p.add(t2);
		
		           l5=new JLabel("Caddress:");
		           l5.setFont(f1);
		           l5.setBounds(80,280,100,100);
		           p.add(l5);
		           t3=new JTextField(20);
		           t3.setBounds(200,320,140,20);
		           p.add(t3);

	              l6=new JLabel("Birth Date:");
		          l6.setFont(f1);
		          l6.setBounds(80,340,100,100);
		          p.add(l6);
		          t4=new JTextField(20);
		          t4.setBounds(200,380,140,20);
		          p.add(t4);
		    
		          l7=new JLabel("Ph No:");
		          l7.setFont(f1);
		          l7.setBounds(80,400,100,100);
		          p.add(l7);
		          t5=new JTextField(20);
		          t5.setBounds(200,440,140,20);
		          p.add(t5);
		
		          l8=new JLabel("Salary:");
		          l8.setFont(f1);
		          l8.setBounds(80,460,100,100);
		          p.add(l8);
		          t6=new JTextField(20);
		          t6.setBounds(200,500,140,20);
		          p.add(t6);
		    
		          l9=new JLabel("Gender:");
		          l9.setFont(f1);
		          l9.setBounds(400,160,100,100);
		          p.add(l9);
		          t7=new JTextField(20);
		          t7.setBounds(500,200,140,20);
		          p.add(t7);
		          cb1=new JComboBox(blist1);
		          p.add(cb1);
		          cb1.addActionListener(this);
		          cb1.setBounds(650,200,140,20);
		    
		
		          l10=new JLabel("Age:");
		          l10.setFont(f1);
		          l10.setBounds(420,225,100,100);
		          p.add(l10);
		          t8=new JTextField(20);
		          t8.setBounds(500,260,140,20);
		          p.add(t8);
		        

	                        l11 = new JLabel("", new ImageIcon("C:/sunil/Gymm Management/Image/yog.gif"), JLabel.CENTER);
	                        l11.setBounds(0,50,450,500);
	                        p.add(l11);

	            	         l12 = new JLabel("", new ImageIcon("C:/sunil/Gymm Management/Image/ascii.gif"), JLabel.CENTER);
	                       l12.setBounds(375,300,400,250);
	                       p.add(l12);

	                   
	                       p.setBackground(Color.white);
			    
	                       back=new JButton("BACK");
		         p.add(back);
		         back.setBounds(170,580,100,30);
		         back.addActionListener(this);
	       	         back.setForeground(new Color(102,10,102));
	       	 
	 	         save=new JButton("SAVE");
		         p.add(save);
		         save.setBounds(300,580,100,30);
		         save.setForeground(new Color(102,10,102));
		         save.addActionListener(this);
	 	
	 	 
	    	        b5=new JButton("Clear");
		        p.add(b5);
		        b5.setForeground(new Color(102,10,102));
		        b5.setBounds(430,580,100,30);                                  
		        b5.addActionListener(this);
	 	
	   	        b1=new JButton("Search");
		        p.add(b1);
		        b1.setForeground(new Color(102,10,102));
		        b1.setBounds(560,580,100,30);                                  
		        b1.addActionListener(this);

	   	        b2=new JButton("Delete");
		        p.add(b2);
		        b2.setForeground(new Color(102,10,102));
		        b2.setBounds(690,580,100,30);                                  
		        b2.addActionListener(this);
	            }	
	 		
		public void actionPerformed(ActionEvent ae)
		{
		     
				if(ae.getSource()==cb1)
				{
					t7.setText(String.valueOf(cb1.getSelectedItem()));
				}
						
		
		                  if(ae.getSource()==back)
			    {
		    	      MyMenu m=new MyMenu();
	                                 this.setVisible(false);
		    	    }
		  
		  	
		 		 if(ae.getSource()==save)
	                                          {

			   	 try
			               {
	               
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					con=DriverManager.getConnection("jdbc:odbc:health");
					ps=con.prepareStatement("insert into coach values(?,?,?,?,?,?,?,?);");
					ps.setInt(1,Integer.parseInt(t1.getText()));
					ps.setString(2,(String)t2.getText());
					ps.setString(3,(String)t3.getText());
					ps.setString(4,(String)t4.getText());
					ps.setInt(5,Integer.parseInt(t5.getText()));
					ps.setInt(6,Integer.parseInt(t6.getText()));
					ps.setString(7,(String)t7.getText());
	                                                       ps.setString(8,(String)t8.getText());
					
					
					JOptionPane.showMessageDialog(null," Record Entered");  
	    				ps.executeUpdate();
	                                          	  t1.setText("");
			                              t2.setText("");
			                              t3.setText("");
			                              t4.setText("");
			                              t5.setText("");
			                              t6.setText("");
	                          	                              t7.setText("");
	                                                          t8.setText("");    	               

					ps.close();
					con.close();
			}
	        catch(SQLException e){}
	        catch(Exception e){}
	      } 

	      if(ae.getSource()==b5)
	      {
			  t1.setEditable(true);
			  t2.setEditable(true);
			  t3.setEditable(true);
			  t4.setEditable(true);
			  t5.setEditable(true);
			  t6.setEditable(true);
			  t7.setEditable(true);
			  t8.setEditable(true);
			  
			  t1.setText("");
			  t2.setText("");
			  t3.setText("");
			  t4.setText("");
			  t5.setText("");
			  t6.setText("");
	              	  t7.setText("");
	    	                t8.setText("");
	         
	      }



	                        if(ae.getSource()==b1)
	                         {
		
	                                       String cno=t2.getText();
			            //if(cno.equals(""))
			            //JOptionPane.showMessageDialog(null," ENTER THE  COACH NO ");

			               
			           try
			            {

			              Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			              System.out.println("\n Driver loaded");
			              Connection con=DriverManager.getConnection("jdbc:odbc:health");
			              Statement stmt=con.createStatement();
			              System.out.println("statement is created");
	                                         String qry= "select * from coach where cname="+cno;
			              System.out.println("SELECT");
	                                         ResultSet rs =stmt.executeQuery(qry);
			              System.out.println("\n RESULT");
			          rs.next();
	                                         
			              t1.setText(String.valueOf(rs.getInt(1)));
			              t2.setText(rs.getString(2));
			              t3.setText(rs.getString(3));
			              t4.setText(rs.getString(4));
			              t5.setText(String.valueOf(rs.getInt(5)));
			              t6.setText(String.valueOf(rs.getInt(6)));
	                                         t7.setText(rs.getString(7));
	                                         t8.setText(rs.getString(8));
	                                                
	                                          System.out.println("QUERY");
			              
			              con.close();

			            }
			            catch(SQLException ex)
			              {
			                  System.out.println("ERROR:"+ex.getMessage());
			              }
			            catch(Exception et)
			              {
			                  System.out.println("error:"+et.getMessage());
			              }
	         }


		

	 if(ae.getSource()==b2)
	       {
	          String cno= t1.getText();
	          if(cno.equals(""))
	          JOptionPane.showMessageDialog(null," ENTER THE CNO ");
	          try
	          {
	             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	             System.out.println("\n Driver loaded");
	             Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
	             Statement stmt=con.createStatement();
	             System.out.println("statement is created");
	             String qry= "delete * from coach where cno = " +cno;
	             System.out.println("SELECT");
	             stmt.executeUpdate(qry);
	             System.out.println("\n RESULT");
	             JOptionPane.showMessageDialog(null,"RECORD IS DELETED SUCCESSFULLY ");
	             System.out.println("QUERY");
	              t2.setEditable(false);
	              t3.setEditable(false);
	              t4.setEditable(false);
	              t5.setEditable(false);
	              t6.setEditable(false);
	              t7.setEditable(false);
	              t8.setEditable(false);
	              

	           con.close();
	         }
	         catch(SQLException eM)
	            {
	                System.out.println("errorsql:"+eM.getMessage());
	            }
	         catch(Exception et)
	            {
	                System.out.println("error:"+et.getMessage());

	            }


	      }


	}
		public static void main(String args[])
		{
			Coach a=new Coach();
		}
	}

