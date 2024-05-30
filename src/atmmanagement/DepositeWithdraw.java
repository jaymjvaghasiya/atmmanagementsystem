package atmmanagement;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.text.*;

public class DepositeWithdraw extends JFrame implements ActionListener
{
	String pin, type;
	JTextField amount;
	JButton b1, b2;
	
	public DepositeWithdraw(String pin, String type)
	{
		this.pin = pin;
		this.type = type;
		
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/screen.jpg"));
		Image screen = i.getImage().getScaledInstance(380, 308, Image.SCALE_DEFAULT);
		ImageIcon img = new ImageIcon(screen);
		JLabel screenimg = new JLabel(img);
		screenimg.setBounds(0, 0, 380, 308);
		add(screenimg);
		
		JLabel title = new JLabel("Enter amount you want to " + type);
		title.setFont(new Font("Ralewat", Font.BOLD, 17));
		title.setForeground(Color.WHITE);
		title.setBounds(40, 20, 290, 30);
		screenimg.add(title);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 16));
		amount.setBounds(58, 60, 250, 25);
		screenimg.add(amount);
		
		b1 = new JButton(type);
		b1.setFont(new Font("Arial", Font.BOLD, 14));
		b1.addActionListener(this);
		b1.setBounds(198, 205, 160, 30);
		screenimg.add(b1);
		
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
		else if(ae.getSource() == b1)
		{
			String rs = amount.getText();
			if(rs.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please Enter some amount.");
			}
			else
			{
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss aaa");
				String tDate = sdf.format(date);
				try
				{					
					Conn c = new Conn();
					
					if(type.equals("Deposite"))
					{						
						String query1 = "insert into bank values ('" + pin +"', '" + tDate +"', '" + type +"', '" + rs +"')";
						c.s.executeUpdate(query1);
						String query2 = "update user_balance set balance = balance + '"+rs+"' where pin_number = '"+pin+"'";
						c.s.executeUpdate(query2);
						JOptionPane.showMessageDialog(null, rs + " " + type + "ed Successfully.");
					}
					else
					{
						ResultSet set = c.s.executeQuery("select * from user_balance where pin_number = '"+pin+"'");
						set.next();
						int oldBalance = Integer.parseInt(set.getString("balance")); 
						int amount = Integer.parseInt(rs);
						
						if(oldBalance > amount)
						{			
							String query1 = "insert into bank values ('" + pin +"', '" + tDate +"', '" + type +"', '" + rs +"')";
							c.s.executeUpdate(query1);
							String query2 = "update user_balance set balance = balance - '"+rs+"' where pin_number = '"+pin+"'";
							c.s.executeUpdate(query2);
							JOptionPane.showMessageDialog(null, rs + " " + type + "ed Successfully.");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Insufficient Balance");
						}
					}
					
					setVisible(false);
					new Screen(pin);
				}
				catch(Exception e)
				{
					System.out.println(e);
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String args[])
	{
		new DepositeWithdraw("", "");
	}
}
