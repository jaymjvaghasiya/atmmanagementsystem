package atmmanagement;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener
{
	String pin;
	JButton b2;
	
	public BalanceEnquiry(String pin)
	{
		this.pin = pin;
		

		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/screen.jpg"));
		Image screen = i.getImage().getScaledInstance(380, 308, Image.SCALE_DEFAULT);
		ImageIcon img = new ImageIcon(screen);
		JLabel screenimg = new JLabel(img);
		screenimg.setBounds(0, 0, 380, 308);
		add(screenimg);
		
		JLabel balance = new JLabel("Current Balance in your account: ");
		balance.setFont(new Font("Raleway", Font.BOLD, 17));
		balance.setForeground(Color.WHITE);
		balance.setBounds(20, 20, 300, 25);
		screenimg.add(balance);
		
		try
		{
			Conn c = new Conn();
			String query = "select * from user_balance where pin_number = '"+pin+"'";
			ResultSet rs = c.s.executeQuery(query);
			rs.next();
			
			String bal_amount = "Rs." + rs.getString("balance");
			JLabel bal = new JLabel();
			bal.setText(bal_amount);
			bal.setFont(new Font("Raleway", Font.BOLD, 17));
			bal.setForeground(Color.WHITE);
			bal.setBounds(20, 50, 200, 25);
			screenimg.add(bal);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		b2 = new JButton("Back");
		b2.setFont(new Font("Arial", Font.BOLD, 14));
		b2.addActionListener(this);
		b2.setBounds(198, 240, 160, 25);
		screenimg.add(b2);
		
		setLocation(455, 267);
		setSize(363, 270);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b2)
		{
			setVisible(false);
			new Screen(pin);
		}
	}

	public static void main(String[] args) 
	{
		new BalanceEnquiry("");
	}

}
