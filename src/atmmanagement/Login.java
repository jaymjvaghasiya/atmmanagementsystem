package atmmanagement;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener 
{
	
	JButton signin, signup, clear;
	
	JTextField ctext;
	JPasswordField ptext;
	
	Login()
	{
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image img1 = i1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(img1);
		JLabel logo = new JLabel(i2);
		logo.setBounds(150, 10, 120, 120);
		add(logo);
		
		JLabel heading = new JLabel("Welcome to ATM");
		heading.setFont(new Font("Oswars", Font.BOLD, 30));
		heading.setBounds(300, 20, 500, 100);
		add(heading);
		
		JLabel cardno = new JLabel("Enter Account no.:");
		cardno.setFont(new Font("Raleway", Font.BOLD, 18));
		cardno.setBounds(127, 165, 200, 30);
		add(cardno);
		
		ctext = new JTextField();
		ctext.setFont(new Font("Raleway", Font.PLAIN, 18));
		ctext.setBounds(320, 165, 300, 30);
		add(ctext);
		
		JLabel pin = new JLabel("Enter PIN:");
		pin.setFont(new Font("Raleway", Font.BOLD, 18));
		pin.setBounds(208, 225, 200, 30);
		add(pin);
		
		ptext = new JPasswordField();
		ptext.setFont(new Font("Raleway", Font.BOLD, 30));
		ptext.setBounds(320, 225, 300, 30);
		add(ptext);
		
		signin = new JButton("Sign in");
		signin.setFont(new Font("Oswars", Font.BOLD, 16));
		signin.setBackground(Color.BLACK);
		signin.setForeground(Color.WHITE);
		signin.addActionListener(this);
		signin.setBounds(320, 290, 130, 30);
		add(signin);
		
		clear = new JButton("Clear");
		clear.setFont(new Font("Osward", Font.BOLD, 16));
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		clear.setBounds(490, 290, 130, 30);
		add(clear);
		
		signup = new JButton("Sign up");
		signup.setFont(new Font("Osward", Font.BOLD, 16));
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		signup.setBounds(320, 345, 301, 30);
		add(signup);

		setBounds(350, 150, 800, 480);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == signup)
		{
			setVisible(false);
			new Signup1();
		}
		else if(e.getSource() == signin)
		{
			Conn c = new Conn();
			String ano = ctext.getText();
			String pin = ptext.getText();
			
			String query = "select * from login where account_number = '" + ano + "' and pin_number = '" + pin +"'";
			try
			{				
				ResultSet result = c.s.executeQuery(query);
				if(result.next())
				{
					setVisible(false);
					new Home(pin);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect Account no. or PIN");
				}
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
		else
		{
			ctext.setText("");
			ptext.setText(""); 
		}
	}
	
	public static void main(String args[])
	{
		new Login();
	}
}
