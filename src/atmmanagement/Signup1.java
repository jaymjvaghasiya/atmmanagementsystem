package atmmanagement;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class Signup1 extends JFrame implements ActionListener
{
	
	JTextField nameText, fnameText, emailText, addText, cityText, stateText, pinText;
	JButton back, next;
	JRadioButton male, female, married, unmarried;
	JDateChooser birthdate;
	Random ran = new Random();
	int random;
	Signup1()
	{	
		random = ran.nextInt(100, 9999);
		
		setLayout(null);
		
		JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
		formno.setFont(new Font("Raleway", Font.BOLD, 38));
		formno.setBounds(140, 40, 600, 45);
		add(formno);
		
		JLabel personalDetails = new JLabel("Page 1: Personal details");
		personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		personalDetails.setBounds(290, 110, 300, 30);
		add(personalDetails);
		
		JLabel name = new JLabel("Name: ");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100, 150, 100, 30);
		add(name);
		
		nameText = new JTextField();
		nameText.setFont(new Font("Raleway", Font.BOLD, 16));
		nameText.setBounds(300, 150, 430, 30);
		add(nameText);
		
		JLabel fname = new JLabel("Father's name: ");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(100, 200, 190, 30);
		add(fname);
		
		fnameText = new JTextField();
		fnameText.setFont(new Font("Raleway", Font.BOLD, 16));
		fnameText.setBounds(300, 200, 430, 30);
		add(fnameText);
		
		JLabel dob = new JLabel("Date of Birth: ");
		dob.setFont(new Font("Raleway", Font.BOLD, 20));
		dob.setBounds(100, 250, 190, 30);
		add(dob);
		
		birthdate = new JDateChooser();
		birthdate.setFont(new Font("Raleway", Font.BOLD, 16));
		birthdate.setForeground(new Color(105, 105, 105));
		birthdate.setBounds(300, 250, 430, 30);
		add(birthdate);
		
		JLabel gdr = new JLabel("Gender: ");
		gdr.setFont(new Font("Raleway", Font.BOLD, 20));
		gdr.setBounds(100, 300, 190, 30);
		add(gdr);
		
		male = new JRadioButton("Male");
		male.setFont(new Font("Raleway", Font.BOLD, 20));
		male.setBackground(Color.WHITE);
		male.setBounds(300, 300, 200, 30);
		add(male);
		
		female = new JRadioButton("Female");
		female.setFont(new Font("Raleway", Font.BOLD, 20));
		female.setBackground(Color.WHITE);
		female.setBounds(500, 300, 200, 30);
		add(female);
		
		ButtonGroup bgroup1  = new ButtonGroup();
		bgroup1.add(male);
		bgroup1.add(female);

		JLabel email = new JLabel("Email Address: ");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 350, 190, 30);
		add(email);

		emailText = new JTextField();
		emailText.setFont(new Font("Raleway", Font.BOLD, 16));
		emailText.setBounds(300, 350, 430, 30);
		add(emailText);
		
		JLabel marital = new JLabel("Marital Status: ");
		marital.setFont(new Font("Raleway", Font.BOLD, 20));
		marital.setBounds(100, 400, 190, 30);
		add(marital);
		
		married = new JRadioButton("Married");
		married.setBackground(Color.WHITE);
		married.setFont(new Font("Raleway", Font.BOLD, 20));
		married.setBounds(300, 400, 200, 30);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBackground(Color.WHITE);
		unmarried.setFont(new Font("Raleway", Font.BOLD, 20));
		unmarried.setBounds(500, 400, 200, 30);
		add(unmarried);
		
		ButtonGroup bgroup2 = new ButtonGroup();
		bgroup2.add(married);
		bgroup2.add(unmarried);
		
		JLabel address = new JLabel("Address: ");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 450, 190, 30);
		add(address);
		
		addText = new JTextField();
		addText.setFont(new Font("Raleway", Font.BOLD, 16));
		addText.setBounds(300, 450, 430, 30);
		add(addText);
		
		JLabel city = new JLabel("City: ");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 500, 190, 30);
		add(city);
		
		cityText = new JTextField();
		cityText.setFont(new Font("Raleway", Font.BOLD, 16));
		cityText.setBounds(300, 500, 430, 30);
		add(cityText);
		
		JLabel state = new JLabel("State: ");
		state.setFont(new Font("Ralewat", Font.BOLD, 20));
		state.setBounds(100, 550, 190, 30);
		add(state);
		
		stateText = new JTextField();
		stateText.setFont(new Font("Raleway", Font.BOLD, 16));
		stateText.setBounds(300, 550, 430, 30);
		add(stateText);
		
		JLabel pincode = new JLabel("Pincode: ");
		pincode.setFont(new Font("Raleway", Font.BOLD, 20));
		pincode.setBounds(100, 600, 190, 30);
		add(pincode);
		
		pinText = new JTextField();
		pinText.setFont(new Font("Raleway", Font.BOLD, 16));
		pinText.setBounds(300, 600, 430, 30);
		add(pinText);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Osward", Font.BOLD, 16));
		next.addActionListener(this);
		next.setBounds(600, 680, 130, 30);
		add(next);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Osward", Font.BOLD, 16));
		back.addActionListener(this);
		back.setBounds(425, 680, 130, 30);
		add(back);
		
		setSize(850, 800);
		getContentPane().setBackground(Color.WHITE);
		setLocation(340, 10);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == back)
		{
			setVisible(false);
			new Login();
		}
		else
		{
			String formno = "" + random;
			String name = nameText.getText();
			String fname = fnameText.getText();
			String bdate = ((JTextField)(birthdate.getDateEditor().getUiComponent())).getText();
			
			String gender = null;
			if(male.isSelected())
			{
				gender = "Male";
			}
			else if(female.isSelected())
			{
				gender = "Female";
			}
			
			String email = emailText.getText();
			
			String marital_status = null;
			if(married.isSelected())
			{
				marital_status = "Married";
			}
			else if(unmarried.isSelected())
			{
				marital_status = "Unmarried";
			}
			
			String address = addText.getText();
			String city = cityText.getText();
			String state = stateText.getText();
			String pin = pinText.getText();
			
			try
			{
				if(name.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Name is Required.");
				}
				else
				{					
					Conn c = new Conn();
					String query = "insert into signup1 values ('" + formno + "', '" + name + "', '" + fname + "', '" + bdate + "', '" + gender + "', '" + email + "', '" + marital_status + "', '" + address + "', '" + city + "', '" + state + "', '" + pin + "')";
					System.out.println(formno);
					c.s.executeUpdate(query);
					
					setVisible(false);
					new Signup2(formno);
				}
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
			
		}
	}
	
	public static void main(String args[])
	{
		new Signup1();
	}
}
