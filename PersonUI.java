import javax.swing.*;

public class PersonUI
{
	JTextField t1,t2,t3;
	JLabel l1,l2,l3;
	JPanel p;
	
	public PersonUI()
	{
		createComponents();
		addComponents();
	}
	
	void createComponents()
	{
		t1 = new JTextField();
		t1.setBounds(250,20,200,30);
		
		t2 = new JTextField();
		t2.setBounds(250,80,200,30);
		
		t3 = new JTextField();
		t3.setBounds(250,140,200,30);
		
		l1 = new JLabel("Name :  ");
		l1.setBounds(100,20,100,30);
		
		l2 = new JLabel("age:  ");
		l2.setBounds(100,80,100,30);
		
		l3 = new JLabel("id:  ");
		l3.setBounds(100,140,100,30);

		p = new JPanel(null);
		p.setBounds(0,0,600,400);
	}
	
	void addComponents()
	{
		p.add(l1);
		p.add(t1);
		p.add(l2);
		p.add(t2);
		p.add(l3);
		p.add(t3);
	
		//add(p1);
	}
}