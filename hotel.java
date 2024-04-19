import javax.swing.*;
import java.awt.event.*;
import java.lang.*;
import java.sql.*;
import java.awt.Color;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
//javac hotel.java
//java -cp mysqlconnector.jar; hotel

class mainwindow extends JFrame implements ActionListener
{
	JButton addr,showr,delr, searchr;
	JLabel userid, bgimage;
	public int employid;
	public String ename;
	mainwindow()
	{
		super("HOTEL MARYOT.exe");
		bgimage=new JLabel(new ImageIcon("C:\\Users\\jaima\\OneDrive\\Desktop\\hari\\jai2a.jpg"));
		add(bgimage);
		bgimage.setBounds(0,0,700,700);
		addr=new JButton("Add Reservation");
		addr.setBounds(200, 200,200,45);
		showr=new JButton("Show Reservation");
		showr.setBounds(200,260,200,45);
		delr=new JButton("Cancel Reservation");
		delr.setBounds(200,320,200,45);
		searchr=new JButton("Search Reservation");
		searchr.setBounds(200,380,200,45);
		userid=new JLabel("HOTEL MARYOT INTERNATIONAL");	
		userid.setBounds(200,70,200,200);
		userid.setForeground(Color.WHITE);
		bgimage.add(addr);
		bgimage.add(showr);
		bgimage.add(delr);
		bgimage.add(searchr);
		bgimage.add(userid);
		setSize(700,700);
		setLayout(null);
		setVisible(true);
		addr.setBackground(Color.LIGHT_GRAY);
    	addr.setForeground(Color.BLACK);
		delr.setBackground(Color.LIGHT_GRAY);
    	delr.setForeground(Color.BLACK);	
		showr.setBackground(Color.LIGHT_GRAY);
    	showr.setForeground(Color.BLACK);
		searchr.setBackground(Color.LIGHT_GRAY);
    	searchr.setForeground(Color.BLACK);	
		addr.addActionListener(this);
		delr.addActionListener(this);
		showr.addActionListener(this);
		searchr.addActionListener(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{	
		try	
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","1234");
			Statement stm=con.createStatement();
			if(ae.getSource()==addr)
				new addroom();
			else if(ae.getSource()==showr)
				new showroom();
			else if(ae.getSource()==delr)
				new delroom();
			else if(ae.getSource()==searchr)
				new searchroom();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

class addroom extends JFrame implements ActionListener
{
    JLabel name,address,phone,cind,cod,adhr,status, rn, rt, bgimage;
    JTextField nmid,adr,phn,cid, codt, adhrt, rnt, rtp;
    JButton submit;
    addroom()
    {
		super("HOTEL MARYOT.exe");
		bgimage=new JLabel(new ImageIcon("C:\\Users\\jaima\\OneDrive\\Desktop\\hari\\jai2a.jpg"));
		add(bgimage);
		bgimage.setBounds(0,0,700,700);
		name=new JLabel("Name");
		name.setForeground(Color.WHITE);
        name.setBounds(180,100,200,30);
        nmid=new JTextField(100);
        nmid.setBounds(400,100,140,30);
        address=new JLabel("Address");
		address.setForeground(Color.WHITE);
        address.setBounds(180,150,200,30);
        adr=new JTextField(100);
        adr.setBounds(400,150,140,30);
        phone=new JLabel("Phone number");
		phone.setForeground(Color.WHITE);
        phone.setBounds(180,200,200,30);
        phn=new JTextField(100);
        phn.setBounds(400,200,140,30);
        cind=new JLabel("Check in date(YYYY-MM-DD)");
		cind.setForeground(Color.WHITE);
        cind.setBounds(180,250,200,30);
        cid=new JTextField(100);
        cid.setBounds(400,250,140,30);
		cod=new JLabel("Check out date(YYYY-MM-DD)");
		cod.setForeground(Color.WHITE);
    	cod.setBounds(180,300,200,30);
        codt=new JTextField(100);
        codt.setBounds(400,300,140,30);
		adhr=new JLabel("Adhaar number");
		adhr.setForeground(Color.WHITE);
    	adhr.setBounds(180,350,200,30);
        adhrt=new JTextField(100);
        adhrt.setBounds(400,350,140,30);
		rn=new JLabel("Room number");
		rn.setForeground(Color.WHITE);
    	rn.setBounds(180,400,200,30);
        rnt=new JTextField(100);
        rnt.setBounds(400,400,140,30);
		rt=new JLabel("Room type(A/B/C/D)");
    	rt.setBounds(180,450,200,30);
		rt.setForeground(Color.WHITE);
        rtp=new JTextField(100);
        rtp.setBounds(400,450,140,30);
        submit=new JButton("SUBMIT");
        submit.setBounds(250,510,200,30);
        status=new JLabel();
		status.setForeground(Color.WHITE);
        status.setBounds(400,600,200,30);
        bgimage.add(name);
        bgimage.add(address);
        bgimage.add(phone);
        bgimage.add(cind);
        bgimage.add(nmid);
        bgimage.add(adr);
        bgimage.add(phn);
        bgimage.add(cid);
		bgimage.add(cod);
		bgimage.add(codt);
		bgimage.add(rn);
		bgimage.add(rnt);
		bgimage.add(rt);
		bgimage.add(rtp);
		bgimage.add(adhr);
		bgimage.add(adhrt);
        bgimage.add(submit);
        bgimage.add(status);
		submit.setBackground(Color.LIGHT_GRAY);
    	submit.setForeground(Color.BLACK);
	    setSize(700,700);
        setLayout(null);
        setVisible(true);
        submit.addActionListener(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae)
    {
       
        Object source=ae.getSource();
        if(source==submit)
		{
	   		try
        	{
            	Class.forName("com.mysql.jdbc.Driver");
            	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","1234");
            	Statement stm=con.createStatement();
            	String inm=nmid.getText();
            	String iadr=adr.getText();
				String iphn=phn.getText();
            	String icid=cid.getText();
				String icodt=codt.getText();
				String iadhr=adhrt.getText();
				String irnt=rnt.getText();
				String irt=rtp.getText();
				String qry="insert into addroom values(\'"+inm+"\',\'"+iadr+"\',"+iphn+",\'"+icid+"\',\'"+icodt+"\', \'"+iadhr+"\', \'"+irnt+"\', \'"+irt+"\')";
    	        stm.executeUpdate(qry);
				nmid.setText("");
				adr.setText("");
				phn.setText("");
				cid.setText("");
				codt.setText("");
				adhrt.setText("");
				rnt.setText("");
				rtp.setText("");
        	    status.setText("SUCCESS");
        	}
        	catch(Exception e)
       	 	{
           	 	e.printStackTrace();
            	status.setText("ERROR PLEASE CHECK THE DETAILS AGAIN!!!");
				nmid.setText("");
				adr.setText("");
				phn.setText("");
				cid.setText("");
				codt.setText("");
				adhrt.setText("");
				rnt.setText("");
				rtp.setText("");
        	}
		}   
    }
}

class showroom extends JFrame implements ActionListener
{
    JButton room;
    JTextField num1;
    JTextArea res=new JTextArea();
    JLabel op,status , title, bgimage, ha;
    showroom()
    {
		super("HOTEL MARYOT.exe");
		bgimage=new JLabel(new ImageIcon("C:\\Users\\jaima\\OneDrive\\Desktop\\hari\\jai2a.jpg"));
		add(bgimage);
		bgimage.setBounds(0,0,700,700);
	  	room=new JButton("View All Room");
      	op=new JLabel("List          : ");
		ha=new JLabel("");
	    status=new JLabel();
      	bgimage.add(room);
      	bgimage.add(res);
      	bgimage.add(op);
      	bgimage.add(status); 
		bgimage.add(ha);
      	setLayout(null);
      	op.setBounds(130,140,150,50);
	  	status.setBounds(250,520,200,30);
		ha.setBounds(10, 200, 710, 50);
      	res.setBounds(10,250,710,400);
      	room.setBounds(250,45,120,120);
		res.setOpaque(false);
		op.setForeground(Color.WHITE);
		ha.setForeground(Color.WHITE);
		status.setForeground(Color.WHITE);
		res.setForeground(Color.WHITE);
      	this.getContentPane().setBackground(Color.LIGHT_GRAY);  
      	setSize(720,720);
      	setVisible(true);
		room.setBackground(Color.LIGHT_GRAY);
    	room.setForeground(Color.BLACK);
			
      	room.addActionListener(this);
	  	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae)
    {
		int cnt=0;
        Object source=ae.getSource();
        if(source==room)
        {
			res.setText("");
			ha.setText("Name             Address                                    Phone             CheckIn            CheckOut           Aadhar                      No    Type");
        	try
			{
				
			    cnt++;
				Class.forName("com.mysql.jdbc.Driver");
		  		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","1234");
	  			Statement stm=con.createStatement();
	  			String qry="select *from addroom";
	  			ResultSet rs=stm.executeQuery(qry);
	  			while(rs.next())
	  			{
					String name=rs.getString(1);
					String address=rs.getString(2);
					String phone=rs.getString(3);
					String cin=rs.getString(4);
					String cod=rs.getString(5);
					String aadhr=rs.getString(6);
					String rno=rs.getString(7);
					String rtype=rs.getString(8);
					
       		 		res.append(name+"  |  "+address+"  |   "+phone+"  |   "+cin+"  |   "+cod+"  |   "+aadhr+"   |  "+rno+"  |  "+rtype+" \n\n\n");
		  		}
				
				status.setText("SUCCESS");
       			stm.close();
       			con.close();
       			rs.close();
    		}
		
    		catch(Exception e)
			{
				e.printStackTrace();
            	status.setText("ERROR");		
			}      
    	}
		
	}
}

class delroom extends JFrame implements ActionListener
{
    JButton met;
    JTextField rno, res;
    JLabel tn,label, status, bgimage;
    delroom()
    {
		super("HOTEL MARYOT.exe");
		met=new JButton("CANCEL");
		bgimage=new JLabel(new ImageIcon("C:\\Users\\jaima\\OneDrive\\Desktop\\hari\\jai2a.jpg"));
		add(bgimage);
		bgimage.setBounds(0,0,700,700);
        rno=new JTextField(10);
	    res=new JTextField(10);
		status=new JLabel();
        tn=new JLabel("Room No : ");
        label=new JLabel("Status: ");
        bgimage.add(met);
        bgimage.add(tn);
        bgimage.add(res);
        bgimage.add(label);
		bgimage.add(status);
	    bgimage.add(rno);
        setLayout(null);
	    rno.setBounds(120, 100, 160, 28);
        tn.setBounds(30,105,100,28);
		tn.setForeground(Color.WHITE);
		status.setBounds(250,520,200,30);
        label.setBounds(30,138,100,28);
		label.setForeground(Color.WHITE);
        res.setBounds(120,138,160,28);
        met.setBounds(300,105,120,100);
		status.setForeground(Color.WHITE);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);  
        setSize(700,700);
        setVisible(true);
		met.setBackground(Color.LIGHT_GRAY);
    	met.setForeground(Color.BLACK);
		
        met.addActionListener(this);
	  	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  	}
  	public void actionPerformed(ActionEvent ae)
    {
       	String t=rno.getText();
		int flag=0;
       	Object source=ae.getSource();
       	try
		{
			if(source==met)
       		{
				Class.forName("com.mysql.jdbc.Driver");
				Connection 	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","1234");
				Statement stm=con.createStatement();
				String qry1="select *from addroom";
				ResultSet rs=stm.executeQuery(qry1);
	  			while(rs.next())
				{
					String rno1=rs.getString(7);
					
					if(rno1.compareTo(t)==0)

						flag=1;
				}
			
				if(flag==1)
				{
					String qry="delete from addroom where rno = \'"+t+"\'";
					stm.executeUpdate(qry);
					res.setText("RESERVATION CANCELLED");
				}

				stm.close();
				con.close();
			
			}
			if(flag==0)
				res.setText("ROOM IS NOT ALLOTED");
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
            status.setText("ERROR");
		}       
    }
}

class searchroom extends JFrame implements ActionListener
{
    JButton met;
    JTextField rno, res;
	JTextArea rep=new JTextArea();
    JLabel tn, label, status, bgimage, ha;
    searchroom()
	{
        super("HOTEL MARYOT.exe");
		bgimage=new JLabel(new ImageIcon("C:\\Users\\jaima\\OneDrive\\Desktop\\hari\\jai2a.jpg"));
		add(bgimage);
		bgimage.setBounds(0,0,700,700);
        met=new JButton("SEARCH");
        rno=new JTextField(10);
	    res=new JTextField(10);
		rep.setOpaque(false);
		ha=new JLabel("");
		ha.setForeground(Color.WHITE);
		rep.setForeground(Color.WHITE);
		status=new JLabel();
		status.setForeground(Color.WHITE);
        tn=new JLabel("Room No : ");
		tn.setForeground(Color.WHITE);
		label=new JLabel("Status: ");
		label.setForeground(Color.WHITE);
        bgimage.add(met);
        bgimage.add(tn);
		bgimage.add(label);
        bgimage.add(res);
		bgimage.add(ha);
		bgimage.add(rep);
        bgimage.add(status);
	    bgimage.add(rno);
        setLayout(null);
	    rno.setBounds(120, 100, 160, 28);
        tn.setBounds(30,105,100,28);
		label.setBounds(30,138,100,28);
		rep.setBounds(10, 250,680,70);
		status.setBounds(250,520,200,30);
        res.setBounds(120,138,160,28);
		ha.setBounds(10, 200, 710, 50);
        met.setBounds(300, 75,120,100);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);  
		met.setBackground(Color.LIGHT_GRAY);
    	met.setForeground(Color.BLACK);
        setSize(700,700);
        setVisible(true);
        met.addActionListener(this);
	  	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  	}
  	public void actionPerformed(ActionEvent ae)
    {
	   	String t=rno.getText();
     	int flag=0;	
		Object source=ae.getSource();
       	try
		{
			if(source==met)
       		{
				rep.setText("");
				ha.setText("Name        Address                                             Phone             CheckIn            CheckOut           Aadhar                      No    Type");
				Class.forName("com.mysql.jdbc.Driver");
				Connection 	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","1234");
				Statement stm=con.createStatement();
				String qry1="select *from addroom where rno = \'"+t+"\'";
				ResultSet rs=stm.executeQuery(qry1);
	  			while(rs.next())
				{
					flag=1;
					String name=rs.getString(1);
					String address=rs.getString(2);
					String phone=rs.getString(3);
					String cin=rs.getString(4);
					String cod=rs.getString(5);
					String aadhr=rs.getString(6);
					String rno=rs.getString(7);
					String rtype=rs.getString(8);
       		 		rep.append(name+"    "+address+"     "+phone+"     "+cin+"     "+cod+"     "+aadhr+"     "+rno+"    "+rtype+" \n\n\n");
				}
				if(flag==0)
					res.setText("Room is vacant");
				else
					res.setText("Success");
				stm.close();
				con.close();
			}
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
            status.setText("ERROR");
		}       
    }
}

class addemp extends JFrame implements ActionListener
{
 	JLabel id,name,acc, pass, status, bgimage;
	JPasswordField tpass = new JPasswordField(100);
 	JTextField tid,tname,tacc;
 	JButton but;
 	addemp()
	{
		super("HOTEL MARYOT.exe");
		bgimage=new JLabel(new ImageIcon("C:\\Users\\jaima\\OneDrive\\Desktop\\hari\\jai2a.jpg"));
		add(bgimage);
		bgimage.setBounds(0,0,700,700);
		id=new JLabel("EMP ID");
		id.setForeground(Color.WHITE);
		id.setBounds(90,150,120,30);
		tid=new JTextField(100);
		tid.setBounds(210,150,140,30);
		name=new JLabel("NAME");
		name.setForeground(Color.WHITE);
		name.setBounds(90,181,120,30);
		tname=new JTextField(100);
		tname.setBounds(210,181,140,30);
		acc=new JLabel("ACC NO");
		acc.setForeground(Color.WHITE);
		acc.setBounds(90,212,120,30);
		tacc=new JTextField(100);
		tacc.setBounds(210,212,140,30);
		pass=new JLabel("PASSWORD");
		pass.setForeground(Color.WHITE);
		pass.setBounds(90,243,120,30);
		tpass.setEchoChar('*');
		tpass.setBounds(210,243,140,30);
		but=new JButton("SUBMIT");
		but.setBounds(120,300,200,30);
		status=new JLabel();	
		status.setBounds(120,350,200,200);
		status.setForeground(Color.WHITE);
		but.setBackground(Color.LIGHT_GRAY);
    	but.setForeground(Color.BLACK);
		
		bgimage.add(status);
		bgimage.add(name);
		bgimage.add(acc);
		bgimage.add(pass);

		bgimage.add(id);
		bgimage.add(tname);
		bgimage.add(tacc);
		bgimage.add(but);
		bgimage.add(tid);
		bgimage.add(tpass);
		setSize(500,500);
		setLayout(null);
		setVisible(true);
		but.addActionListener(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
	public void actionPerformed(ActionEvent ae)
    {    
		Object source=ae.getSource();
		if(source==but)
		{
			try
			{
 				Class.forName("com.mysql.jdbc.Driver");
 				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","1234");
 				Statement stm=con.createStatement();
 				String id=tid.getText();
 				String name=tname.getText();
 				String acc=tacc.getText();
 				String pass=tpass.getText();
 				String qry="insert into empdetails values(\'"+id+"\',\'"+name+"\',"+acc+",\'"+pass+"\')";
 				stm.executeUpdate(qry);
 				tid.setText("");
 				tname.setText("");
 				tacc.setText("");
 				tpass.setText("");
			}
			catch(Exception e)
			{
  				e.printStackTrace();
   				status.setText("ERROR PLEASE CHECK THE DETAILS AGAIN!!!");
    			tid.setText("");
    			tname.setText("");
    			tacc.setText("");
    			tpass.setText("");
			}
		}
	}
}

class hotel extends JFrame implements ActionListener
{
	JTextField username;
	JPasswordField password = new JPasswordField(100);
	JToggleButton p1;
	JButton check, sign;
	JLabel status,userl,passl,bgimage;
	hotel()
	{
		super("HOTEL MARYOT.exe");
		bgimage=new JLabel(new ImageIcon("C:\\Users\\jaima\\OneDrive\\Desktop\\hari\\jai2a.jpg"));
		add(bgimage);
		bgimage.setBounds(0,0,500,500);
		username=new JTextField(100);
		username.setBounds(120,150,140,30);
		password.setEchoChar('*');
		password.setBounds(120,180,140,30);
		userl=new JLabel("USERNAME");	
		userl.setForeground(Color.WHITE);
		userl.setBounds(40,140,200,40);
		passl=new JLabel("PASSWORD");
		passl.setForeground(Color.WHITE);	
		passl.setBounds(40,170,200,40);
		status=new JLabel();	
		status.setBounds(180,300,200,40);
		status.setForeground(Color.WHITE);	
		check=new JButton("SUBMIT");
		check.setBounds(120,220,200,30);
		sign=new JButton("SIGN UP");
		p1=new JToggleButton("SHOW");
		p1.setBounds(270, 180, 80,35);
		check.setBackground(Color.LIGHT_GRAY);
    	check.setForeground(Color.BLACK);
		p1.setBackground(Color.LIGHT_GRAY);
		p1.setForeground(Color.BLACK);
		sign.setBackground(Color.LIGHT_GRAY);
    	sign.setForeground(Color.BLACK);	
		sign.setBounds(120, 251, 200, 30);
		bgimage.add(username);
		bgimage.add(password);
		bgimage.add(check);
		bgimage.add(p1);
		bgimage.add(sign);
		bgimage.add(status);
		bgimage.add(userl);
		bgimage.add(passl);
		setSize(500,500);
		setLayout(null);
		setVisible(true);
		check.addActionListener(this);
		sign.addActionListener(this);
		p1.addActionListener(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{	
		Object source=ae.getSource();
		if(p1.isSelected())
		{
    		password.setEchoChar((char)0); 
			p1.setBackground(Color.LIGHT_GRAY);
			p1.setForeground(Color.BLACK);
			p1.setText("Hide");
		}
		else
		{
    		password.setEchoChar('*');
			p1.setBackground(Color.LIGHT_GRAY);
			p1.setForeground(Color.BLACK);
    		p1.setText("Show");
		}
		
		if(source==check)
		{
			try	
			{
				int flag=0;
				String usern=username.getText();
				String passw=password.getText();
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","1234");
				Statement stm=con.createStatement();
				ResultSet rs=stm.executeQuery("select * from empdetails");
				while(rs.next())
				{
					if((rs.getString(1)).equals(usern))
					{
						if((rs.getString(4)).equals(passw))
						{
							flag=1;
							setVisible(false);
							new mainwindow();
						}		
					}
				}
				if(flag==0)
				{
					status.setText("INCORRECT CREDENTIALS");
					username.setText("");
					password.setText("");
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else if(source==sign)
		{
			new addemp();
		}
	}
    public static void main(String args[])
	{
		new hotel();
	}
}