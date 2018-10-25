package Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.ResultSet;
import java.util.Vector;

class AddMember extends JPanel{
	
	JTable table;
	Connection conn =null;
	public static AddMember AddMember = null;
	AddMember(){
			
			setVisible(true);
			setBounds(0,0,1000,400);
			setLayout(null);
			
			Vector<Vector<String>> vectorRow=new Vector<Vector<String>>();
			try{
				Statement st;
				st=conn.createStatement();
				
				String sql="SELECT * FROM registration GROUP by Club_Name";
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()){
				Vector row = new Vector();
				row.add(rs.getString("FRIST_NAME"));
				row.add(rs.getString("LAST_NAME"));
				row.add(rs.getString("DEPARTMENT"));
				row.add(rs.getFloat("CGPA"));
				row.add(rs.getString("Club_Name"));
				row.add(rs.getString("email"));
				row.add(rs.getString("phone"));
				
				vectorRow.add(row);
				}
			}catch(Exception ex){
			                JOptionPane.showMessageDialog(this, ex);
	    }
			
			
			Vector<String> columnNames = new Vector<String>();
			columnNames.add("FRIST_NAME");
			columnNames.add("LAST_NAME");
			columnNames.add("DEPARTMENT");
			columnNames.add("CGPA");
			columnNames.add("Club_Name");
			columnNames.add("Email");
			columnNames.add("Phone No.");
			
			
			this.table=new JTable(vectorRow,columnNames);
			
			JScrollPane sp = new JScrollPane(table);
			sp.setBounds(0,0,550,250);
		  add(sp);
	}
	public static AddMember AddMemberlRef(){
		if(AddMember==null)
		{
			AddMember = new AddMember();
		}
		return AddMember; 
	}
}
