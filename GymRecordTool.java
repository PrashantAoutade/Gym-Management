import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.*;
class GymRecordTool extends JFrame 
{
JScrollPane jsp;
Connection con;
Statement st;
ResultSet rs;
ResultSetMetaData rsm;

GymRecordTool()
{
setVisible(true);
setSize(1365,733);
setTitle("Tool Record");
setLayout(new BorderLayout());

try
{

con=DriverManager.getConnection("jdbc:odbc:health");
st=con.createStatement();
rs=st.executeQuery("select * from tool");

 rsm=rs.getMetaData();
int cols=rsm.getColumnCount();

Vector data=new Vector();
Vector heads=new Vector();


for(int i=1;i<=cols;i++)
{
heads.add(rsm.getColumnLabel(i));
}
while(rs.next())
{
Vector row=new Vector();
for(int i=1;i<=cols;i++)
{

row.add(rs.getString(i));
}
data.add(row);

JTable tb=new JTable(data,heads);

if(jsp!=null)
remove(jsp);

jsp=new JScrollPane(tb,20,30);
add(jsp);
invalidate();
}
}

catch(SQLException ex)
{
JOptionPane.showMessageDialog(this,"ERROR IS:"+ex);
}
}
public static void main(String args[])
{
new GymRecordTool();
}
}
