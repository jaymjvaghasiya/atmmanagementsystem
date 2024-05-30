package atmmanagement;

import javax.swing.*;

import java.awt.*;
import java.sql.*;

public class MiniStatements extends JFrame
{

	String pin;
	int totalAmount = 0, x = 0;
	
	public MiniStatements(String pin)
	{
		this.pin = pin;
		
		setLayout(null);
		
		JLabel heading = new JLabel("Mini Statement");
		heading.setFont(new Font("Raleway", Font.BOLD, 23));
		heading.setBounds(160, 30, 250, 25);
		add(heading);
		
		try
		{
			Conn c = new Conn();
			String query = "select * from user_balance where pin_number = '"+pin+"'";
			ResultSet rs = c.s.executeQuery(query);
			rs.next();
			String a_no = rs.getString("account_number");
			JLabel acc = new JLabel("Account number: " + a_no);
			acc.setFont(new Font("Raleway", Font.BOLD, 17));
			acc.setBounds(20, 76, 300, 20);
			add(acc);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		JLabel title = new JLabel("PIN     Date       Time              Tran type    Amount");
		title.setFont(new Font("Raleway", Font.BOLD, 15));
		title.setBounds(20, 110, 450, 25);
		add(title);
		
		try
		{
			Conn c = new Conn();
			String row = "";
			String query = "select * from bank where pin_number = '"+pin+"'";
			ResultSet rs = c.s.executeQuery(query);
			
			while(rs.next())
			{
				row = rs.getString("pin_number") + "   " + rs.getString("date") + "   " + rs.getString("transaction_type") + "      " + rs.getString("amount");
				totalAmount += Integer.parseInt(rs.getString("amount"));
				
				JLabel s = new JLabel(row);
				s.setFont(new Font("Raleway", Font.BOLD, 14));
				s.setBounds(20, 140 + x, 370, 20);
				add(s);
				
				x+=30;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		JLabel totalTransaction = new JLabel("Total Transaction: " + totalAmount);
		totalTransaction.setFont(new Font("Ralewat", Font.BOLD, 17));
		totalTransaction.setBounds(20, 560, 300, 25);
		add(totalTransaction);
		
		
		getContentPane().setBackground(Color.WHITE);
		setLocation(50, 50);
		setSize(500, 700);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MiniStatements("");
	}

}
