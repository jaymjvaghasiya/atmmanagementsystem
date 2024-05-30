package atmmanagement;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;;

public class Home extends JFrame implements ActionListener 
{
	String pin;
	public Home(String pin)
	{
		this.pin = pin;
		
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image img = i.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon atm = new ImageIcon(img);
		JLabel atmimg = new JLabel(atm);
		atmimg.setBounds(0, 0, 900, 900);
		add(atmimg);
		
		
		setSize(900, 870);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
		new Screen(pin);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
	}
	
	public static void main(String args[])
	{
		new Home("");
	}
}
