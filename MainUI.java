import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class MainUI extends JFrame implements ActionListener
{
	challanUI ob1;
	PersonUI ob2;
	VehicleUI ob3;
	PolicyUI ob4;
	
	JButton submit,modify,delete,m1,m2,m3,m4;
	JPanel p1,p2,p3,p4,pb;
	JMenuBar mb;
	
	public MainUI()
	{
		setSize(600,550);
		setLayout(null);
		setVisible(true);
		setTitle("policy for delay payments");
		
		
		
	ob1 = new challanUI() ;
	ob2 = new PersonUI ();
	ob3= new VehicleUI ();
	ob4= new PolicyUI ();
		
		
		createPanels();
		createMenu();	
		createButtons();
		addComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void createPanels()
	{
		p1 = ob1.p;
		p2 = ob2.p;
		p3 = ob3.p;
		p4	= ob4.p;	
		
		pb = new JPanel(new FlowLayout(FlowLayout.CENTER,50,0));
		pb.setBounds(0,400,600,150);
	}
	
	void createMenu()
	{
		mb = new JMenuBar();
		
		m1 = new JButton("challan");
		m1.setFocusable(false);
		
		m2 = new JButton("Person");
		m2.setFocusable(false);
		
		
		m3 = new JButton("Vehicle");
		m3.setFocusable(false);
		
		m4 = new JButton("policy");
		m4.setFocusable(false);
		
		m1.addActionListener(this);
		m2.addActionListener(this);
		m3.addActionListener(this);
		m4.addActionListener(this);
		
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		remove(p1);
		remove(p2);
		remove(p3);
		remove(p4);
		
		if(e.getSource()==m1)
			add(p1);
		
		else if(e.getSource()==m2)
			add(p2);
		
		else if(e.getSource()==m3)
			add(p3);
		
		else
			add(p4);
	}
	
	void createButtons()
	{
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try{
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shiva","vasavi");
					Statement stmt=con.createStatement();

					int no1 = Integer.parseInt(ob2.t3.getText());
					int no2 = Integer.parseInt(ob2.t2.getText());
					int s = stmt.executeUpdate("insert into Person values ("+no1+",'"+ob2.t1.getText()+"',"+no2+")");
					con.close();
				}
				catch(Exception e){
					System.out.println(e);
				}
				JOptionPane.showMessageDialog(new JFrame(),"Successfully Inserted!","NOTICE",JOptionPane.INFORMATION_MESSAGE); 
			}
		});
		
		
		modify = new JButton("Modify");
		modify.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				JOptionPane.showMessageDialog(new JFrame(),"Successfully Modified!","NOTICE",JOptionPane.INFORMATION_MESSAGE); 
			}
		});
		
		
		delete = new JButton("Delete");
		delete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				JOptionPane.showMessageDialog(new JFrame(),"Successfully Deleted!","NOTICE",JOptionPane.INFORMATION_MESSAGE); 
			}
		});
		
		pb.add(submit);
		pb.add(modify);
		pb.add(delete);
	}
	
	void addComponents()
	{
		add(p1);
		add(pb);
		setJMenuBar(mb);
	}
	
	public static void main(String args[])
	{
		new MainUI();
	}
}