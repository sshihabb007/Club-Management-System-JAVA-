package Login;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Main.Main;
import Users.CerateClub;
import Users.ManagePanel;
import Users.ProfilePanel;

public class AdminLoginPanel extends JPanel {
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JLabel label1;
	public static AdminLoginPanel adminloginpanel = null;
	public AdminLoginPanel()
	{
		setVisible(true);
		setBounds(0,0,500,400);
		setLayout(null);
		this.label1 = new JLabel();
		this.label1.setText("The Admin Panel");
		this.label1.setBounds(200, 10, 300, 20);
		add(this.label1);
		this.button1 = new JButton();
		this.button1.setBounds(190, 110, 130, 20);
		this.button1.setText("Create Club");
		add(this.button1);
		this.button1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				Main.MainRef().remove(adminloginlRef());
				Main.MainRef().add(CerateClub.cerateclubRef());
				Main.MainRef().pack();
            	Main.MainRef().setBounds(50,100,500,400);
			}	
			
		});
		
		this.button2 = new JButton();
		this.button2.setBounds(190, 150, 130, 20);
		this.button2.setText("Manage Club");
		add(this.button2);
		this.button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Main.MainRef().remove(adminloginlRef());
				Main.MainRef().add(ManagePanel.ManagepanellRef());
				Main.MainRef().pack();
				Main.MainRef().setBounds(50,100,500,400);
			}	
			
		});
		
		this.button3 = new JButton();
		this.button3.setBounds(190, 190, 130, 20);
		this.button3.setText("event History");
		add(this.button3);
		this.button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Main.MainRef().remove(adminloginlRef());
				Main.MainRef().add(EventPanel.EventPanellRef(),BorderLayout.CENTER);
				Main.MainRef().pack();
				Main.MainRef().setBounds(50,100,500,400);
			}	
			
		});
		
		this.button4 = new JButton();
		this.button4.setBounds(190, 230, 130, 20);
		this.button4.setText("Logout");
		add(this.button4);
		this.button4.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				Main.MainRef().remove(adminloginlRef());
				Main.MainRef().add(LoginPanel.LogInlRef());
				Main.MainRef().pack();
	        	Main.MainRef().setBounds(50,100,400,350);
	        	
			}	
			
		});
		this.button5 = new JButton();
		this.button5.setBounds(190, 70, 130, 20);
		this.button5.setText("Manage profile");
		add(this.button5);
        this.button5.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				Main.MainRef().remove(adminloginlRef());
				Main.MainRef().add(ProfilePanel.ProfilelRef());
				Main.MainRef().pack();
	        	Main.MainRef().setBounds(50,100,400,350);
	        	
			}	
			
		});
	}
	public static AdminLoginPanel adminloginlRef(){
		if(adminloginpanel==null)
		{
			adminloginpanel = new AdminLoginPanel();
		}
		return adminloginpanel; 
	}

}
