package atmmanagement;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.text.*;

public class FastCash extends JFrame implements ActionListener
{
	String pin;
	JButton b1, b2, b3, b4, b5, b6, b7;
	
	public FastCash(String pin)
	{
		this.pin = pin;
		
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/screen.jpg"));
		Image screen = i.getImage().getScaledInstance(380, 308, Image.SCALE_DEFAULT);
		ImageIcon img = new ImageIcon(screen);
		JLabel screenimg = new JLabel(img);
		screenimg.setBounds(0, 0, 380, 308);
		add(screenimg);
		
		JLabel title = new JLabel("Select Withdrawl Amount");
		title.setFont(new Font("Ralewat", Font.BOLD, 17));
		title.setForeground(Color.WHITE);
		title.setBounds(76, 20, 250, 25);
		screenimg.add(title);
		
		b1 = new JButton("Rs. 100");
		b1.setFont(new Font("Arial", Font.BOLD, 14));
		b1.addActionListener(this);
		b1.setBounds(5, 135, 160, 30);
		screenimg.add(b1);
		
		b2 = new JButton("Rs. 500");
		b2.setFont(new Font("Arial", Font.BOLD, 14));
		b2.addActionListener(this);
		b2.setBounds(198, 135, 160, 30);
		screenimg.add(b2);
		
		b3 = new JButton("Rs. 1000");
		b3.setFont(new Font("Arial", Font.BOLD, 14));
		b3.addActionListener(this);
		b3.setBounds(5, 170, 160, 30);
		screenimg.add(b3);
		
		b4 = new JButton("Rs. 2000");
		b4.setFont(new Font("Arial", Font.BOLD, 14));
		b4.addActionListener(this);
		b4.setBounds(198, 170, 160, 30);
		screenimg.add(b4);
		
		b5 = new JButton("Rs. 5000");
		b5.setFont(new Font("Arial", Font.BOLD, 14));
		b5.addActionListener(this);
		b5.setBounds(5, 205, 160, 30);
		screenimg.add(b5);
		
		b6 = new JButton("Rs. 10000");
		b6.setFont(new Font("Arial", Font.BOLD, 14));
		b6.addActionListener(this);
		b6.setBounds(198, 205, 160, 30);
		screenimg.add(b6);
		
		b7 = new JButton("Back");
		b7.setFont(new Font("Arial", Font.BOLD, 14));
		b7.addActionListener(this);
		b7.setBounds(198, 240, 160, 25);
		screenimg.add(b7);
		
		setLocation(455, 267);
		setSize(363, 270);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b7)
		{
			setVisible(false);
			new Screen(pin);
		}
		else
		{
			String amount = ((JButton)ae.getSource()).getText().substring(4);
			int withdrawalAmount = Integer.parseInt(amount);
			try
			{
				Conn c = new Conn();
				String query1 = "select * from user_balance where pin_number = '"+pin+"'";
				ResultSet r = c.s.executeQuery(query1);
				r.next();
				int oldBalance = Integer.parseInt(r.getString("balance"));
				
				if(oldBalance > withdrawalAmount)
				{
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss aaa");
					String tDate = sdf.format(date);
					
					String query2 = "insert into bank values ('"+pin+"', '"+tDate+"', 'Withdraw', '"+amount+"')";
					String query3 = "update user_balance set balance = balance - '"+withdrawalAmount+"' where pin_number = '"+pin+"'";
					
					c.s.executeUpdate(query2);
					c.s.executeUpdate(query3);
					
					JOptionPane.showMessageDialog(null, "Rs. " +withdrawalAmount+ " Debited successfully.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String args[])
	{
		new FastCash("");
	}
}
