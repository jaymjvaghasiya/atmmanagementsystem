package atmmanagement;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener
{
	
	JComboBox rbox, cbox, ibox, qbox, obox;
	JTextField adhartext, pantext;
	JRadioButton syes, sno, eayes, eano;
	String formno;
	JButton next, back;
	
	public Signup2(String formno)
	{
		setLayout(null);
		
		this.formno = formno;
		
		setTitle("NEW ACCOUNT APPLICATION PAGE: 2");
		
		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		additionalDetails.setBounds(290, 110, 300, 35);
		add(additionalDetails);
		
		JLabel religion  = new JLabel("Religion:");
		religion.setFont(new Font("Raleway", Font.BOLD, 20));
		religion.setBounds(100, 150, 100, 30);
		add(religion);
		
		String religions[] = {"Hindu", "Sikh", "Muslim", "Christion"};
		rbox = new JComboBox(religions);
		rbox.setFont(new Font("Raleway", Font.BOLD, 20));
		rbox.setBackground(Color.WHITE);
		rbox.setBounds(300, 150, 430, 30);
		add(rbox);
		
		JLabel category  = new JLabel("Category:");
		category.setFont(new Font("Raleway", Font.BOLD, 20));
		category.setBounds(100, 200, 100, 30);
		add(category);
		
		String categories[] = {"General", "OBS", "SC", "ST", "Others"};
		cbox = new JComboBox(categories);
		cbox.setFont(new Font("Raleway", Font.BOLD, 20));
		cbox.setBackground(Color.WHITE);
		cbox.setBounds(300, 200, 430, 30);
		add(cbox);
		
		JLabel income  = new JLabel("Income:");
		income.setFont(new Font("Raleway", Font.BOLD, 20));
		income.setBounds(100, 250, 100, 30);
		add(income);
		
		String incomes[] = {"NULL", "0 - 50000", "50000 - 150000", "150000 - 200000", "200000 - 500000", "500000 - 700000", "700000 - Above"};
		ibox = new JComboBox(incomes);
		ibox.setFont(new Font("Raleway", Font.BOLD, 20));
		ibox.setBackground(Color.WHITE);
		ibox.setBounds(300, 250, 430, 30);
		add(ibox);
		
		JLabel qualification  = new JLabel("Qualification:");
		qualification.setFont(new Font("Raleway", Font.BOLD, 20));
		qualification.setBounds(100, 300, 140, 30);
		add(qualification);
		
		String qualifications[] = {"10th", "12th", "Graduate", "Post-Graduate", "Other"};
		qbox = new JComboBox(qualifications);
		qbox.setFont(new Font("Raleway", Font.BOLD, 20));
		qbox.setBackground(Color.WHITE);
		qbox.setBounds(300, 300, 430, 30);
		add(qbox);
		
		JLabel occupation  = new JLabel("Occupation:");
		occupation.setFont(new Font("Raleway", Font.BOLD, 20));
		occupation.setBounds(100, 350, 140, 30);
		add(occupation);
		
		String occupations[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Ex-Service man", "Other"};
		obox = new JComboBox(occupations);
		obox.setFont(new Font("Raleway", Font.BOLD, 20));
		obox.setBackground(Color.WHITE);
		obox.setBounds(300, 350, 430, 30);
		add(obox);		
		
		JLabel adhar  = new JLabel("Adhar Number:");
		adhar.setFont(new Font("Raleway", Font.BOLD, 20));
		adhar.setBounds(100, 400, 160, 30);
		add(adhar);
		
		adhartext = new JTextField();
		adhartext.setFont(new Font("Raleway", Font.BOLD, 20));
		adhartext.setBounds(300, 400, 430, 30);
		add(adhartext);
		
		JLabel panno  = new JLabel("PAN Number:");
		panno.setFont(new Font("Raleway", Font.BOLD, 20));
		panno.setBounds(100, 450, 140, 30);
		add(panno);
		
		pantext = new JTextField();
		pantext.setFont(new Font("Raleway", Font.BOLD, 20));
		pantext.setBounds(300, 450, 430, 30);
		add(pantext);
		
		JLabel senior  = new JLabel("Senior Citizen:");
		senior.setFont(new Font("Raleway", Font.BOLD, 20));
		senior.setBounds(100, 500, 140, 30);
		add(senior);
		
		syes = new JRadioButton("Yes");
		syes.setBackground(Color.WHITE);
		syes.setFont(new Font("Raleway", Font.BOLD, 20));
		syes.setBounds(300, 500, 200, 30);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBackground(Color.WHITE);
		sno.setFont(new Font("Raleway", Font.BOLD, 20));
		sno.setBounds(500, 500, 200, 30);
		add(sno);
		
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(syes);
		bg1.add(sno);
		
		JLabel exaccount  = new JLabel("Exisiting Account:");
		exaccount.setFont(new Font("Raleway", Font.BOLD, 20));
		exaccount.setBounds(100, 550, 180, 30);
		add(exaccount);
		
		eayes = new JRadioButton("Yes");
		eayes.setBackground(Color.WHITE);
		eayes.setFont(new Font("Raleway", Font.BOLD, 20));
		eayes.setBounds(300, 550, 200, 30);
		add(eayes);
		
		eano = new JRadioButton("No");
		eano.setBackground(Color.WHITE);
		eano.setFont(new Font("Raleway", Font.BOLD, 20));
		eano.setBounds(500, 550, 200, 30);
		add(eano);
		
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(eayes);
		bg2.add(eano);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Osward", Font.BOLD, 16));
		back.addActionListener(this);
		back.setBounds(450, 680, 130, 30);
		add(back);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Osward", Font.BOLD, 16));
		next.addActionListener(this);
		next.setBounds(600, 680, 130, 30);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(340, 10, 850, 800);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource() == back)
		{
			try
			{				
				Conn c = new Conn();
				String query = "delete from signup1 where formno = '" + formno + "'";
				c.s.executeUpdate(query);
				setVisible(false);
				new Signup1();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
		else {
			
			String sr = (String)rbox.getSelectedItem();
			String sc = (String)cbox.getSelectedItem();
			String si = (String)ibox.getSelectedItem();
			String sq = (String)qbox.getSelectedItem();
			String so = (String)obox.getSelectedItem();
			String sa = adhartext.getText();
			String sp = pantext.getText();
			
			String senior_citizen = null;
			if(syes.isSelected())
			{
				senior_citizen = "Yes";
			}
			else if(sno.isSelected())
			{
				senior_citizen = "No";
			}
			
			String exisiting_account = null;
			if(eayes.isSelected())
			{
				exisiting_account = "Yes";
			}
			else if(eano.isSelected())
			{
				exisiting_account = "No";
			}
			
			try
			{
				Conn c = new Conn();
				String query = "insert into signup2 values ('" + formno + "', '" + sr + "', '" + sc + "', '" + si + "', '" + sq + "', '" + so + "', '" + sa + "', '" + sp + "', '" + senior_citizen + "', '" + exisiting_account + "')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new Signup3(formno);
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
	}
	
	public static void main(String args[])
	{
		new Signup2("");
	}
}
