package Users;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Login.AdminLoginPanel;
import Login.EventPanel;
import Main.Main;

public class ManagePanel extends JPanel {

	JButton button1;
	JButton button2;
	JLabel label1;
	
	
	public static ManagePanel Managepanel = null;
	public ManagePanel()
	{
		setVisible(true);
		setBounds(10,10,350,200);
		setLayout(null);
		this.label1 = new JLabel();
		this.label1.setText("The Member Manage Panel");
		this.label1.setBounds(200, 10, 300, 30);
		add(this.label1);
		this.button1 = new JButton();
		this.button1.setBounds(190, 110, 130, 30);
		this.button1.setText("View Member");
		add(this.button1);
		this.button1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				Main.MainRef().remove(ManagepanellRef());
				Main.MainRef().add(ViewMember.ViewMemberlRef());
				Main.MainRef().pack();
            	Main.MainRef().setBounds(50,100,500,400);
			}	
			
		});
		
		this.button2 = new JButton();
		this.button2.setBounds(190, 150, 130, 30);
		this.button2.setText("Add Member");
		add(this.button2);
		this.button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Main.MainRef().remove(ManagepanellRef());
				Main.MainRef().add(AddMember.AddMemberlRef());
				Main.MainRef().pack();
				Main.MainRef().setBounds(50,100,550,400);
			}	
			
		});
		
}
			
	
	public static ManagePanel ManagepanellRef(){
		if(Managepanel==null)
		{
			Managepanel = new ManagePanel();
		}
		return Managepanel; 
	}
}
