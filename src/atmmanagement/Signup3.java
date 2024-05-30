package atmmanagement;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener 
{
	JRadioButton b1, b2, b3, b4;
	JCheckBox c1, c2, c3, c4, c5, c6, c7;
	JButton submit, cancel, back;
	String formno;
	Random ran = new Random();
	
	public Signup3(String formno)
	{
		this.formno = formno;
		
		setLayout(null);
		
		setTitle("NEW ACCOUNT APPLICATION PAGE: 3");
		
		JLabel additionalDetails = new JLabel("Page 3: Account Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 26));
		additionalDetails.setBounds(290, 80, 300, 35);
		add(additionalDetails);
		
		JLabel account = new JLabel("Accoutn Type:");
		account.setFont(new Font("Raleway", Font.BOLD, 22));
		account.setBounds(100, 150, 400, 40);
		add(account);
		
		b1 = new JRadioButton("Saving Account");
		b1.setFont(new Font("Raleway", Font.PLAIN, 18));
		b1.setBackground(Color.WHITE);
		b1.setBounds(100, 200, 210, 20);
		add(b1);
		
		b2 = new JRadioButton("Current Account");
		b2.setFont(new Font("Raleway", Font.PLAIN, 18));
		b2.setBackground(Color.WHITE);
		b2.setBounds(400, 200, 210, 20);
		add(b2);
		
		b3 = new JRadioButton("Fixed Deposite Account");
		b3.setFont(new Font("Raleway", Font.PLAIN, 18));
		b3.setBackground(Color.WHITE);
		b3.setBounds(100, 250, 300, 20);
		add(b3);
		
		b4 = new JRadioButton("Recurring Deposite Account");
		b4.setFont(new Font("Raleway", Font.PLAIN, 18));
		b4.setBackground(Color.WHITE);
		b4.setBounds(400, 250, 300, 20);
		add(b4);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(b1);
		bg.add(b2);
		bg.add(b3);
		bg.add(b4);
		
		JLabel cno = new JLabel("Account Number: ");
		cno.setFont(new Font("Raleway", Font.BOLD, 22));
		cno.setBounds(100, 300, 400, 30);
		add(cno);

		JLabel desc1 = new JLabel("Your 12 Digit Account number");
		desc1.setFont(new Font("Raleway", Font.BOLD, 13));
		desc1.setBounds(100, 330, 230, 20);
		add(desc1);
		
		JLabel cnosample = new JLabel("XXXX-XXXX-1234");
		cnosample.setFont(new Font("Raleway", Font.BOLD, 22));
		cnosample.setBounds(380, 300, 400, 30);
		add(cnosample);
		
		
		JLabel pno = new JLabel("PIN Number: ");
		pno.setFont(new Font("Raleway", Font.BOLD, 22));
		pno.setBounds(100, 370, 400, 30);
		add(pno);
		
		JLabel desc2 = new JLabel("Youe 4 Digit PIN");
		desc2.setFont(new Font("Raleway", Font.BOLD, 13));
		desc2.setBounds(100, 400, 200, 20);
		add(desc2);
		
		JLabel pnosample = new JLabel("XXXX");
		pnosample.setFont(new Font("Raleway", Font.BOLD, 22));
		pnosample.setBounds(380, 370, 200, 30);
		add(pnosample);
		
		JLabel serveice = new JLabel("Serveices Required:");
		serveice.setFont(new Font("Raleway", Font.BOLD, 22));
		serveice.setBounds(100, 450, 300, 30);
		add(serveice);
		
		c1 = new JCheckBox("ATM Card");
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("Raleway", Font.PLAIN, 18));
		c1.setBounds(100, 500, 250, 20);
		add(c1);
		
		c2 = new JCheckBox("Mobile Banking");
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("Raleway", Font.PLAIN, 18));
		c2.setBounds(100, 540, 250, 20);
		add(c2);
		
		c3 = new JCheckBox("Cheque Book");
		c3.setBackground(Color.WHITE);
		c3.setFont(new Font("Raleway", Font.PLAIN, 18));
		c3.setBounds(100, 580, 250, 20);
		add(c3);
		
		c4 = new JCheckBox("Internet Banking");
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font("Raleway", Font.PLAIN, 18));
		c4.setBounds(400, 500, 250, 20);
		add(c4);
		
		c5 = new JCheckBox("EMAIL & SMS Alerts");
		c5.setBackground(Color.WHITE);
		c5.setFont(new Font("Raleway", Font.PLAIN, 18));
		c5.setBounds(400, 540, 250, 20);
		add(c5);
		
		c6 = new JCheckBox("E-Statements");
		c6.setBackground(Color.WHITE);
		c6.setFont(new Font("Raleway", Font.PLAIN, 18));
		c6.setBounds(400, 580, 250, 20);
		add(c6);
		
		c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.");
		c7.setBackground(Color.WHITE);
		c7.setFont(new Font("Raleway", Font.PLAIN, 16));
		c7.addActionListener(this);
		c7.setBounds(100, 650, 700, 20);
		add(c7);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Raleway", Font.BOLD, 16));
		submit.addActionListener(this);
		submit.setEnabled(false);
		submit.setBounds(185, 700, 130, 30);
		add(submit);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Raleway", Font.BOLD, 16));
		back.addActionListener(this);
		back.setBounds(355, 700, 130, 30);
		add(back);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Raleway", Font.BOLD, 16));
		cancel.addActionListener(this);
		cancel.setBounds(525, 700, 130, 30);
		add(cancel);
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(340, 10, 850, 800);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == c7)
		{
			submit.setEnabled(true);
		}
		else if(ae.getSource() == cancel)
		{
			try
			{
				Conn c = new Conn();
				String q1 = "delete from signup1 where formno = '" + formno + "'";
				String q2 = "delete from signup2 where formno = '" + formno + "'";
				c.s.executeUpdate(q1);
				c.s.executeUpdate(q2);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			setVisible(false);
			new Login();
		}
		else if(ae.getSource() == back)
		{
			try
			{
				Conn c = new Conn();
				String q = "delete from signup2 where formno = '" + formno + "'";
				c.s.executeUpdate(q);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			setVisible(false);
			new Signup2(formno);
		}
		else
		{
			String account_type = "";
			if(b1.isSelected())
			{
				account_type = "Saving Account";
			}
			else if(b2.isSelected())
			{
				account_type = "Current Account";
			}
			else if(b3.isSelected())
			{
				account_type = "Fixed Deposite Account";
			}
			else if(b4.isSelected())
			{
				account_type = "Recurroing Deposite Account";
			}
			
			String accNumber = "" + (ran.nextLong(100000000000L, 999999999999L));
			String pinNumber = "" + ran.nextInt(1000, 9999);
			
			String serveices = "";
			if(c1.isSelected())
			{
				serveices += "ATM Card, ";
			}
			if(c2.isSelected())
			{
				serveices += "Mobile Banking, ";
			}
			if(c3.isSelected())
			{
				serveices += "Cheque Book, ";
			}
			if(c4.isSelected())
			{
				serveices += "Internet Banking, ";
			}
			if(c5.isSelected())
			{
				serveices += "EMAIL & SMS Alerts, ";
			}
			if(c6.isSelected())
			{
				serveices += "E-Statements, ";
			}
			
			try
			{
				Conn c = new Conn();
				String query1 = "insert into signup3 values ('" + formno + "', '" + account_type + "', '" + accNumber + "', '" + pinNumber + "', '" + serveices + "')";
				c.s.executeUpdate(query1);
				
				String query2 = "insert into login values ('" + formno + "', '" + accNumber + "', '" + pinNumber + "')";
				c.s.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null, "Your Account number: " + accNumber + "\nYour PIN: " + pinNumber + "\nPlease Not It.");
				String amount = JOptionPane.showInputDialog("Please Enter Amount: ");
				String query3 = "insert into user_balance values ('"+pinNumber+"', '"+accNumber+"', '"+account_type+"', '"+amount+"')";
				c.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null, "Now, your accoutn is opened.\nRs. "+amount+" Deposited successfully.");
				
				setVisible(false);
				new Login();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
	}
	
	public static void main(String args[])
	{
		new Signup3("");
	}
}
