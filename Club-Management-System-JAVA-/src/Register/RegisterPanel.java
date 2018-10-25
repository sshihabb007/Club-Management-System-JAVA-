package Register;

import javax.swing.*;

import DB.DBConnectionProvider;
import Login.LoginPanel;
import Main.Main;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegisterPanel extends JPanel
{
	
	JButton button;
	JButton button1;
	JButton button2;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label5;
	JLabel label6;
	JLabel label7;
	JLabel label8;
	JTextField textfield1;
	JTextField textfield2;
	JTextField textfield3;
	JPasswordField passwordfield1;
	JPasswordField passwordfield2;
	JTextField textfield5;
	JTextField textfield6;
	JTextField textfield7;
	JTextField textfield8;
	JComboBox combobox;
	Connection conn = null;
	JLabel label9;
    JLabel label10;
	private static RegisterPanel RegisterPanelRef = null;
	public RegisterPanel()
	{
		
		setVisible(true);
		setBounds(5,5,400,450);
		setLayout(null);
		
		this.label1 = new JLabel();
		this.label1.setBounds(10,10,100,20);
		this.label1.setText("Frist Name");
		add(this.label1);
		
		this.textfield1 = new JTextField();
		this.textfield1.setBounds(150,10,200,20);
		this.textfield1.setText(null);
		add(this.textfield1);
		
		this.label2 = new JLabel();
		this.label2.setBounds(10,50,100,20);
		this.label2.setText("Last Name");
		add(this.label2);
		
		this.textfield2 = new JTextField();
		this.textfield2.setBounds(150,50,200,20);
		this.textfield2.setText(null);
		add(this.textfield2);
		
		this.label3 = new JLabel();
		this.label3.setBounds(10,90,100,20);
		this.label3.setText("User Name");
		add(this.label3);
		
		this.textfield3 = new JTextField();
		this.textfield3.setBounds(150,90,200,20);
		this.textfield3.setText(null);
		add(this.textfield3);
		
		this.label4 = new JLabel();
		this.label4.setBounds(10,130,100,20);
		this.label4.setText("Password");
		add(this.label4);
		
		this.passwordfield1 = new JPasswordField();
		this.passwordfield1.setBounds(150,130,200,20);
		this.passwordfield1.setText(null);
		add(this.passwordfield1);
		
		this.label8 = new JLabel();
		this.label8.setBounds(10,170,150,20);
		this.label8.setText("Confirm Password");
		add(this.label8);
		
		this.passwordfield2 = new JPasswordField();
		this.passwordfield2.setBounds(150,170,200,20);
		this.passwordfield2.setText(null);
		add(this.passwordfield2);
		
		this.label5 = new JLabel();
		this.label5.setBounds(10,210,100,20);
		this.label5.setText("Depertment");
		add(this.label5);
		
		this.textfield5 = new JTextField();
		this.textfield5.setBounds(150,210,200,20);
		this.textfield5.setText(null);
		add(this.textfield5);
		
		this.label6 = new JLabel();
		this.label6.setBounds(10,250,100,20);
		this.label6.setText("CGPA");
		add(this.label6);
		
		this.textfield6 = new JTextField();
		this.textfield6.setBounds(150,250,200,20);
		this.textfield6.setText(null);
		add(this.textfield6);
		
		this.label7 = new JLabel();
		this.label7.setBounds(10,290,100,20);
		this.label7.setText("Club Name");
		add(this.label7);
		
		this.combobox = new JComboBox();
		this.combobox.setBounds(150,290,200,20);
		add(this.combobox);
		this.combobox.removeAllItems();
		 try {
				            
				conn = DBConnectionProvider.getDBConnection();       
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
							 combobox.getSelectedItem().toString();
					        } catch (Exception ex) {
								System.out.println(ex.getMessage());
					        		 
				}
				
				}
		 });
		 
		  this.label9 = new JLabel();
			this.label9.setBounds(10,330,100,20);
			this.label9.setText("Email");
			add(this.label9);
			
			this.textfield7 = new JTextField();
			this.textfield7.setBounds(150,330,200,20);
			this.textfield7.setText(null);
			add(this.textfield7);
			this.label10 = new JLabel();
			this.label10.setBounds(10,370,100,20);
			this.label10.setText("Phone Number");
			add(this.label10);
			
			this.textfield8 = new JTextField();
			this.textfield8.setBounds(150,370,200,20);
			this.textfield8.setText(null);
			add(this.textfield8);
			
		this.button = new JButton();
		this.button.setText("Confirm");
		this.button.setBounds(240,400,100,20);
		add(this.button);
		this.button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(passwordfield1.getText().equals(passwordfield2.getText()))
						{
					 try {
				            
				            Connection conn = DBConnectionProvider.getDBConnection();
				          
				            if(combobox.getSelectedItem().equals("---")||combobox.getSelectedItem().equals(null))
				            {
				            	JOptionPane.showMessageDialog(null,"Club name must be select");
				            }
				            else
				            {
				            	Statement stmt = conn.createStatement();
						           String query = "INSERT INTO registration (`FRIST_NAME`, `LAST_NAME`, `USER_NAME`, `PASSWORD`,`DEPARTMENT`,`CGPA`,`Club_Name`) VALUES ('" +textfield1.getText()+"', '"+textfield2.getText()+"', '"+textfield3.getText()+"', '"+passwordfield1.getText()+ "', '"+textfield5.getText()+"','"+Float.valueOf(textfield6.getText())+"','"+combobox.getSelectedItem()+"')";
						          stmt.executeUpdate(query);
						            JOptionPane.showMessageDialog(null,"Registration successfull");
				            }
				            
				        } catch (Exception ex) {
							System.out.println(ex.getMessage());
							JOptionPane.showMessageDialog(null,"fil all the information");
				        }					
						}
				else 
					JOptionPane.showMessageDialog(null,"Password and Confermrd password dose not match");
			}
		});
		
		this.button1 = new JButton();
		this.button1.setText("Clean");
		this.button1.setBounds(155,400,70,20);
		add(this.button1);
		this.button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				textfield1.setText(null);
				textfield2.setText(null);
				textfield3.setText(null);
				textfield5.setText(null);
				textfield6.setText(null);
				passwordfield1.setText(null);
				passwordfield2.setText(null);
				combobox.removeAllItems();
				 try {
						            
						Connection conn = DBConnectionProvider.getDBConnection();
						combobox.addItem("---");        
						Statement stmt = conn.createStatement();
						String query = "SELECT Club_Name  FROM clubs";
						ResultSet rs = stmt.executeQuery(query);
						while(rs.next())
						{
						    combobox.addItem(""+rs.getString("Club_Name"));
					    }
						            
						} catch (Exception ex) {
						}
			}	
		});
		
		this.button2 = new JButton();
		this.button2.setText("< Back");
		this.button2.setBounds(30,400,100,20);
		add(this.button2);
		this.button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Main.MainRef().remove(RegisterPanel.RegisterRef());
				Main.MainRef().add(LoginPanel.LogInlRef());
				Main.MainRef().pack();
				Main.MainRef().setBounds(50,100,400,450);
			}	
			
		});
	}
		public static RegisterPanel RegisterRef(){
			if(RegisterPanelRef==null)
			{
				RegisterPanelRef = new RegisterPanel();
			}
			return RegisterPanelRef; 
		}
	}

			