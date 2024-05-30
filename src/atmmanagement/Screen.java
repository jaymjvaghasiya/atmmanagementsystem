package atmmanagement;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Screen extends JFrame implements ActionListener
{
	
	JButton b1, b2, b3, b4, b5, b6, b7;
	String pin;
	
	public Screen(String pin)
	{
		this.pin = pin;
		
		setLayout(null);
		
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/screen.jpg"));
		Image screen = i.getImage().getScaledInstance(380, 308, Image.SCALE_DEFAULT);
		ImageIcon img = new ImageIcon(screen);
		JLabel screenimg = new JLabel(img);
		screenimg.setBounds(0, 0, 380, 308);
		add(screenimg);
		
		JLabel title = new JLabel("Please select your Transaction");
		title.setFont(new Font("Ralewat", Font.BOLD, 17));
		title.setForeground(Color.WHITE);
		title.setBounds(58, 20, 250, 25);
		screenimg.add(title);
		
		b1 = new JButton("Deposite");
		b1.setFont(new Font("Arial", Font.BOLD, 14));
		b1.addActionListener(this);
		b1.setBounds(5, 135, 160, 30);
		screenimg.add(b1);
		
		b2 = new JButton("Cash Withdrawl");
		b2.setFont(new Font("Arial", Font.BOLD, 14));
		b2.addActionListener(this);
		b2.setBounds(198, 135, 160, 30);
		screenimg.add(b2);
		
		b3 = new JButton("Fast Cash");
		b3.setFont(new Font("Arial", Font.BOLD, 14));
		b3.addActionListener(this);
		b3.setBounds(5, 170, 160, 30);
		screenimg.add(b3);
		
		b4 = new JButton("Mini Statement");
		b4.setFont(new Font("Arial", Font.BOLD, 14));
		b4.addActionListener(this);
		b4.setBounds(198, 170, 160, 30);
		screenimg.add(b4);
		
		b5 = new JButton("Pin Change");
		b5.setFont(new Font("Arial", Font.BOLD, 14));
		b5.addActionListener(this);
		b5.setBounds(5, 205, 160, 30);
		screenimg.add(b5);
		
		b6 = new JButton("Balance Enquiry");
		b6.setFont(new Font("Arial", Font.BOLD, 14));
		b6.addActionListener(this);
		b6.setBounds(198, 205, 160, 30);
		screenimg.add(b6);
		
		b7 = new JButton("Exit");
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
			System.exit(0);
		}
		else if(ae.getSource() == b1 || ae.getSource() == b2)
		{
			setVisible(false);
			String type = null;
			if(ae.getSource() == b1)
			{
				type = "Deposite";
			}
			else
			{
				type = "Withdraw";
			}
			new DepositeWithdraw(pin, type).setVisible(true);
		}
		else if(ae.getSource() == b3)
		{
			setVisible(false);
			new FastCash(pin).setVisible(true);
		}
		else if(ae.getSource() == b4)
		{
			setVisible(false);
			new MiniStatements(pin);
		}
		else if(ae.getSource() == b5)
		{
			setVisible(false);
			new PinChange(pin).setVisible(true);
		}
		else if(ae.getSource() == b6)
		{ 
			new BalanceEnquiry(pin).setVisible(true);
		}
	}
	
	public static void main(String[] args) 
	{
		new Screen("");
	}

}
