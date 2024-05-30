package atmmanagement;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener
{
	String pin;
	JPasswordField pin_no, re_pin_no;
	JButton b1, b2;
	
	public PinChange(String pin)
	{
		this.pin = pin;
		
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/screen.jpg"));
		Image screen = i.getImage().getScaledInstance(380, 308, Image.SCALE_DEFAULT);
		ImageIcon img = new ImageIcon(screen);
		JLabel screenimg = new JLabel(img);
		screenimg.setBounds(0, 0, 380, 308);
		add(screenimg);
		
		JLabel p1 = new JLabel("Enter new PIN : ");
		p1.setFont(new Font("Raleway", Font.BOLD, 17));
		p1.setBackground(Color.BLACK);
		p1.setForeground(Color.WHITE);
		p1.setBounds(30, 30, 160, 25);
		screenimg.add(p1);
		
		pin_no = new JPasswordField();
		pin_no.setFont(new Font("Raleway", Font.BOLD, 17));
		pin_no.setBounds(170, 30, 160, 25);
		screenimg.add(pin_no);
		
		JLabel p2 = new JLabel("Re-enter PIN : ");
		p2.setFont(new Font("Raleway", Font.BOLD, 17));
		p2.setBackground(Color.BLACK);
		p2.setForeground(Color.WHITE);
		p2.setBounds(30, 75, 160, 25);
		screenimg.add(p2);
		
		re_pin_no = new JPasswordField();
		re_pin_no.setFont(new Font("Raleway", Font.BOLD, 17));
		re_pin_no.setBounds(170, 75, 160, 25);
		screenimg.add(re_pin_no);
		
		b1 = new JButton("Change");
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
		else
		{
			String pin1 = pin_no.getText();
			String pin2 = re_pin_no.getText();
			
			if(!pin1.equals(pin2))
			{
				JOptionPane.showMessageDialog(null, "Entered PIN does not match");
			}
			else if(pin1.equals("") || pin2.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please fill up both the fields.");
			}
			else
			{
				try
				{	
					String exists_pin;
					boolean flag = true;
					Conn c = new Conn();
					
					ResultSet rs = c.s.executeQuery("select * from login");
					while(rs.next())
					{
						exists_pin = rs.getString("pin_number");
						if(pin1.equals(exists_pin))
						{
							flag = false;
							break;
						}
					}
					
					if(flag == false)
					{
						JOptionPane.showMessageDialog(null, "This PIN is already exists.\nPlease choose any other.");
					}
					else
					{							
						String q1 = "update bank set pin_number = '"+pin1+"' where pin_number = '"+pin+"'";
						String q2 = "update user_balance set pin_number = '"+pin1+"' where pin_number = '"+pin+"'";
						String q3 = "update signup3 set pin_number = '"+pin1+"' where pin_number = '"+pin+"'";
						String q4 = "update login set pin_number = '"+pin1+"' where pin_number = '"+pin+"'";
						
						c.s.executeUpdate(q1);
						c.s.executeUpdate(q2);
						c.s.executeUpdate(q3);
						c.s.executeUpdate(q4);
						
						JOptionPane.showMessageDialog(null, "PIN has been changed successfully.");
						setVisible(false);
						new Screen(pin);
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
	}
	
	public static void main(String args[])
	{
		new PinChange("");
	}
}
