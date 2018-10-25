package Users;

import javax.swing.*;
import javax.swing.table.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

import DB.DBConnectionProvider;
import Main.Main;

public class ViewMember extends JPanel{
	JComboBox combobox;
	JLabel label1;
	JTable table;
	Connection conn =null;
	Vector<Vector<String>> vectorRow=new Vector<Vector<String>>();
	Vector<String> columnNames = new Vector<String>();
	public static ViewMember ViewMember = null;
	public ViewMember()
	{
		setVisible(true);
		setBounds(10,10,350,200);
		setLayout(null);
		
		this.label1 = new JLabel();
		this.label1.setText("Club Name");
		this.label1.setBounds(10, 10, 100, 20);
		add(this.label1);
		this.combobox = new JComboBox();
		this.combobox.setBounds(130,10,100,20);
		add(this.combobox);
		this.combobox.removeAllItems();
		 try {
				            
				conn = DBConnectionProvider.getDBConnection();
				combobox.addItem("---");        
				Statement stmt = conn.createStatement();
				String query = "SELECT Club_Name  FROM clubs";
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next())
				{
				    combobox.addItem(""+rs.getString("Club_Name"));
			    }
				            
				} catch (Exception ex) {
					 System.out.println(ex.getMessage());
				}
		 combobox.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
						 try {
							
								combobox.getSelectedItem();
								Statement st;
								st=conn.createStatement();
								String sql="SELECT * FROM user Where CLUB_NAME ='"+combobox.getSelectedItem()+"'";
								ResultSet rs = st.executeQuery(sql);
								
								while(rs.next()){
								Vector row = new Vector();
								row.add(rs.getString("USER_NAME"));
								row.add(rs.getString("TYPE"));
								row.add(rs.getString("CLUB_NAME"));
								row.add(rs.getString("Depertment"));
								row.add(rs.getString("EMAIL"));
								row.add(rs.getString("PHONE"));
								vectorRow.add(row);
								}
								
								columnNames.add("USER_NAME");
								columnNames.add("TYPE");
								columnNames.add("CLUB_NAME");
								columnNames.add("Depertment");
								columnNames.add("EMAIL");
								columnNames.add("PHONE");
								table=new JTable(vectorRow,columnNames);
								
								JScrollPane sp = new JScrollPane(table);
								sp.setBounds(30,70,240,250);
								add(sp);
								Main.MainRef().pack();
								Main.MainRef().setBounds(50,100,500,400);
					        } catch (Exception ex) {
								System.out.println(ex.getMessage());
					        }
				

				}
		 });	
		
}
			
	
	public static ViewMember ViewMemberlRef(){
		if(ViewMember==null)
		{
			ViewMember = new ViewMember();
		}
		return ViewMember; 
	}
}
