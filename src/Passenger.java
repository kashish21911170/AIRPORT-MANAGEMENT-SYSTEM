import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.util.concurrent.*; 

import javax.swing.*; 

import java.awt.*; 
import java.awt.event.*; 
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*; 
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

class Booking
{
	
	           
	public int flight_code;       // The special code that each flight is assigned like F1007
	public String airline;           // Eg. Indigo or AirIndia
	public String date_of_departure;
	public int booking_id;
	public String date_of_arrival;
	public String time_of_departure;
	public String time_of_arrival;
	public int ticket_price;
	public int quantity;
	public int passenger_id;
	public String destination_code;  //Eg. LAX or PNX
	public String source_code;       //Eg. LAX or PNX
	public String booking_status;    // On Time or Cancelled

	
	public Booking()
	{
		
		flight_code = 0;       
		airline = "XYZ";          
		date_of_departure = "2020-20-20";
		booking_id = 0 ;
		date_of_arrival = "2020-20-20";
		time_of_departure = "00:00:00";
		time_of_arrival = "00:00:00";
		ticket_price = 0;
		quantity = 0;
		passenger_id = 0;
		destination_code = "ABC";  
		source_code = "ABC"; 
		booking_status = "On Time";
		
	}

}










class MyFrame10 extends JFrame implements ActionListener { 
	  
    // Components of the Form 
    //private Container c; 
    private JButton a1;
    private JButton a2;
    private JButton a3;
    private JButton a4;

    public MyFrame10() throws IOException 
    { 
        setTitle("Passenger Portal"); 
        setBounds(300, 90, 700, 700); 
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        setResizable(true); 
  
      
        
        
        
        BufferedImage img = ImageIO.read(new File("C:/Users/kashish/Desktop/imgs/bookings.jpg"));
        JLabel background = new JLabel(new ImageIcon(img));
        background.setSize(7000,7000);

       // Border border = BorderFactory.createLineBorder(Color.WHITE);
        
        setContentPane(background);
        setLayout(null);
 
        
        
        
        
        /////////////////////////////////////////////////////////
        
        a1 = new JButton("Book "); 
        a1.setFont(new Font("Arial", Font.PLAIN, 40)); 
        a1.setBounds(50, 100 , 200 ,100); 
        a1.setBackground(Color.BLACK);
        a1.setForeground(Color.WHITE);
        a1.addActionListener(this); 
        a1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        add(a1); 
  
        a2 = new JButton("Cancel"); 
        a2.setFont(new Font("Arial", Font.PLAIN, 40)); 
        a2.setBounds(300, 100 , 200 ,100);
        a2.addActionListener(this); 
        a2.setBackground(Color.BLACK);
        a2.setForeground(Color.WHITE);
        a2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        add(a2);
        
        a3 = new JButton("Modify "); 
        a3.setFont(new Font("Arial", Font.PLAIN, 40)); 
        a3.setBounds(850, 100 , 200 ,100);
        a3.addActionListener(this); 
        a3.setBackground(Color.BLACK);
        a3.setForeground(Color.WHITE);
        a3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        add(a3); 
  
        a4 = new JButton("View"); 
        a4.setFont(new Font("Arial", Font.PLAIN, 40)); 
        a4.setBounds(1100, 100 , 200 ,100);
        a4.addActionListener(this); 
        a4.setBackground(Color.BLACK);
        a4.setForeground(Color.WHITE);
        a4.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        add(a4);
        
        setVisible(true); 
        
    }
        
        public void actionPerformed(ActionEvent e) 
        { 
        	
        	if(e.getSource() ==a1) 
    		{
    			try {
					MyFrame f = new MyFrame();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		}
    		
        	if(e.getSource() ==a2)
    		{
    		
    		try {
				MyFrame1 f = new MyFrame1();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		
    	    }
    		
        	if(e.getSource() ==a3) 
        	{
    		
    	     try {
				MyFrame3 f = new MyFrame3();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	    
    	    
    	    }
        	if(e.getSource() ==a4)
        	{
    		
    		
    		MyFrame2 f = new MyFrame2();

    	    	
        	
        	}
        
        
        }
        
}



  
class MyFrame extends JFrame implements ActionListener 

{ 
  
    // Components of the Form 
    private Container c; 
    private JLabel title; 
    private JLabel nameair;  
    private JLabel id; 
    private JTextField tid;
    private JTextField tname2;
    private JTextField tname3;
    private JLabel time; 
    private JLabel time1; 
    private JLabel mno; 
    private JTextField tmno; 
    private JLabel qty;
    private JTextField qty1;
    private JLabel fid;
    private JTextField tfid;
    private JLabel ch;
    private JTextField choice;
    private JLabel dod;
    private JLabel doa;
    private JLabel ticket;
    private JComboBox price;
    private JComboBox date; 
    private JComboBox month; 
    private JComboBox year; 
    private JComboBox date1; 
    private JComboBox month1; 
    private JComboBox year1; 
    private JComboBox airline1; 
    private JButton sub; 
    private JButton reset; 
    private JLabel dest; 
    private JTextField dest1; 
    private JTextArea dets; 
    private JLabel src; 
    private JTextField src1; 
    private JLabel res;
    private JRadioButton j1; 
    private JRadioButton j2;
    private ButtonGroup G;
    private JTable table;
    private JPanel controlPanel;
    private String dates[] 
        = { "1", "2", "3", "4", "5", 
            "6", "7", "8", "9", "10", 
            "11", "12", "13", "14", "15", 
            "16", "17", "18", "19", "20", 
            "21", "22", "23", "24", "25", 
            "26", "27", "28", "29", "30", 
            "31" }; 
    private String months[] 
        = { "Jan", "feb", "Mar", "Apr", 
            "May", "Jun", "July", "Aug", 
            "Sept", "Oct", "Nov", "Dec" }; 
    private String years[] 
        = { "2020", "2021", "2022", "2023", 
            "2024", "2025", "2026", "2027", 
            "2028", "2029", "2030", "2031" 
             }; 
    
    private String planes[] 
            = { "Air India", "Air Asia", "Emirates", "British", 
                "Singapore", "Indigo", "Delta", "Southwest", 
                "Ethiad", "Air Japan" 
                 }; 
    
    private String prices[] 
            = { "10000", "20000", "30000", "40000", "50000", 
                "60000", "70000", "80000", "90000", "100000"};
    
    
   
    
    
    
    
    public MyFrame() throws IOException 
    { 
    	setTitle("Flight Booking Portal"); 
        setBounds(300, 90, 1500, 1500); 
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
        setResizable(true);       
        
        fid = new JLabel("Flight Code"); 
        fid.setFont(new Font("Arial", Font.PLAIN, 20)); 
        fid.setSize(300, 20); 
        fid.setLocation(40, 400); 
        //fid.setForeground(Color.WHITE);
        add(fid); 
  
        tfid = new JTextField(); 
        tfid.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tfid.setSize(300, 20); 
        tfid.setLocation(320, 400); 
        
        add(tfid); 
        ///////////////////////////////////////////
        nameair = new JLabel("Airline Name"); 
        nameair.setFont(new Font("Arial", Font.PLAIN, 20)); 
        nameair.setSize(300, 20); 
        nameair.setLocation(750, 500); 
       // nameair.setForeground(Color.WHITE);
        add(nameair);
        
        
        airline1 = new JComboBox(planes); 
        airline1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        airline1.setSize(300, 20); 
        airline1.setLocation(1050, 500); 

        add(airline1); 
  
        
        /////////////////////////////////////////////
        
        dod = new JLabel("Date of Departure"); 
        dod.setFont(new Font("Arial", Font.PLAIN, 20)); 
        dod.setSize(200, 20); 
        dod.setLocation(750, 400); 
       // dod.setForeground(Color.WHITE);
        add(dod); 
        
        doa = new JLabel("Date of Arrival"); 
        doa.setFont(new Font("Arial", Font.PLAIN, 20)); 
        doa.setSize(200, 20); 
        doa.setLocation(750, 450); 
       // doa.setForeground(Color.WHITE);
        add(doa); 
  
        date = new JComboBox(dates); 
        date.setFont(new Font("Arial", Font.PLAIN, 15)); 
        date.setSize(50, 20); 
        date.setLocation(1050, 400); 
        add(date); 
  
        month = new JComboBox(months); 
        month.setFont(new Font("Arial", Font.PLAIN, 15)); 
        month.setSize(60, 20); 
        month.setLocation(1150, 400); 
        add(month); 
  
        year = new JComboBox(years); 
        year.setFont(new Font("Arial", Font.PLAIN, 15)); 
        year.setSize(60, 20); 
        year.setLocation(1250, 400); 
        add(year); 
        
        
        
        date1 = new JComboBox(dates); 
        date1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        date1.setSize(50, 20); 
        date1.setLocation(1050, 450); 
        add(date1); 
  
        month1 = new JComboBox(months); 
        month1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        month1.setSize(60, 20); 
        month1.setLocation(1150, 450); 
        add(month1); 
  
        year1 = new JComboBox(years); 
        year1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        year1.setSize(60, 20); 
        year1.setLocation(1250, 450); 
        add(year1);
        
        ////////////////////////////////////////////////////////////////
        
        time = new JLabel("Departure Time (in HH:MM:SS)"); 
        time.setFont(new Font("Arial", Font.PLAIN, 20)); 
        time.setSize(300, 20); 
        time.setLocation(750, 550); 
       // time.setForeground(Color.WHITE);
      //  time.setForeground(Color.WHITE);
        add(time); 
  
        tname2 = new JTextField(); 
        tname2.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname2.setSize(300, 20); 
        tname2.setLocation(1050, 550); 
        add(tname2); 
        
        
        time1= new JLabel("Arrival Time (in HH:MM:SS)"); 
        time1.setFont(new Font("Arial", Font.PLAIN, 20)); 
        time1.setSize(300, 20); 
        time1.setLocation(750, 600); 
       // time1.setForeground(Color.WHITE);
       // time1.setForeground(Color.WHITE);
        add(time1); 
  
        tname3 = new JTextField(); 
        tname3.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname3.setSize(300, 20); 
        tname3.setLocation(1050, 600); 
        add(tname3); 
        
        
        /////////////////////////////////////////////////////////
        
        ticket = new JLabel("Select price for your ticket: "); 
        ticket.setFont(new Font("Arial", Font.PLAIN, 20)); 
        ticket.setSize(300, 20); 
        ticket.setLocation(40, 450); 
      //  ticket.setForeground(Color.WHITE);
      //  ticket.setForeground(Color.WHITE);
        add(ticket); 
        
        
        price = new JComboBox(prices); 
        price.setFont(new Font("Arial", Font.PLAIN, 15)); 
        price.setSize(300, 20); 
        price.setLocation(320, 450); 
        
        add(price); 
        
        
        
        /////////////////////////////////////////////////////////
        
        
        qty= new JLabel("Number of tickets: "); 
        qty.setFont(new Font("Arial", Font.PLAIN, 20)); 
        qty.setSize(300, 20); 
        qty.setLocation(40, 500); 
       // qty.setForeground(Color.WHITE);
       // qty.setForeground(Color.WHITE);
        add(qty); 
        
        qty1 = new JTextField(); 
        qty1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        qty1.setSize(300, 20); 
        qty1.setLocation(320, 500); 
        add(qty1); 
        
        /////////////////////////////////////////////////////////
        
        
        dest = new JLabel("Destination Code"); 
        dest.setFont(new Font("Arial", Font.PLAIN, 20)); 
        dest.setSize(300, 20); 
        dest.setLocation(40, 550);
      //  dest.setForeground(Color.WHITE);
      //  dest.setForeground(Color.WHITE);
        add(dest); 
  
        dest1 = new JTextField(); 
        dest1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        dest1.setSize(300, 20); 
        dest1.setLocation(320, 550); 
        add(dest1); 
        
        
        src= new JLabel("Source Code"); 
        src.setFont(new Font("Arial", Font.PLAIN, 20)); 
        src.setSize(300, 20); 
        src.setLocation(40, 600);
      //  src.setForeground(Color.WHITE);
      //  src.setForeground(Color.WHITE);
        add(src); 
  
        src1 = new JTextField(); 
        src1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        src1.setSize(300, 20); 
        src1.setLocation(320, 600); 
        
        add(src1); 
        
        /////////////////////////////////////////////////////////
        
        j1 = new JRadioButton("Manually");
        j1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        j1.setSize(300, 20); 
        j1.setLocation(120, 650); 
      //  j1.setForeground(Color.WHITE);
      //  j1.setBackground(Color.BLACK);
        add(j1); 
        
        j2 = new JRadioButton("Bot Service");
        j2.setFont(new Font("Arial", Font.PLAIN, 15)); 
        j2.setSize(300, 20); 
        j2.setLocation(450, 650); 
     //   j2.setForeground(Color.WHITE);
     //   j2.setBackground(Color.BLACK);
        add(j2);
        
        
        sub = new JButton("Submit"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 30)); 
        sub.setSize(200, 50); 
        sub.setLocation(800, 650); 
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.WHITE);
        sub.addActionListener(this); 
        add(sub); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 30)); 
        reset.setSize(200, 50); 
        reset.setLocation(1100, 650); 
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.addActionListener(this); 
        add(reset);
        
        res= new JLabel(""); 
        res.setFont(new Font("Arial", Font.PLAIN, 5)); 
        res.setSize(400, 20); 
        res.setLocation(40, 750); 
        add(res); 
        
        
        
     
        
        String column[] = {"flight_code","priority", "status", "destination_code","source_code","fuel", "airline", "date_of_departure", "date_of_arrival","time_of_departure","time_of_arrival"};
        
         String data[][] = {    	};
       
       DefaultTableModel model = new DefaultTableModel(data, column);
       table = new JTable(model);
        
        try 
	    {	    String url = "jdbc:mysql://localhost:3306/airport";	
	    Connection conn = DriverManager.getConnection(url,"root","Kashish310311");
	            Statement stmt = conn.createStatement();	         
	                     
	            ResultSet rs = stmt.executeQuery("Select * from flights;");	


	            while(rs.next())
	            {
	                String d = rs.getString("flight_code");
	                String e = rs.getString("priority");
	                String f = rs.getString("status");
	                String d1 = rs.getString("destination_code");
	                String e1 = rs.getString("source_code");
	                String f1 = rs.getString("fuel");
	                String d2 = rs.getString("airline");
	                String e2 = rs.getString("date_of_departure");
	                String f2 = rs.getString("date_of_arrival");
	                String e3 = rs.getString("time_of_departure");
	                String f3 = rs.getString("time_of_arrival");
	                model.addRow(new Object[]{d, e, f, d1, e1, f1, d2, e2 , f2 , e3, f3});
	            }
	            conn.close();
        } 
	    catch (Exception e2) 
	    {
            System.err.println("Got an exception! ");
            System.err.println(e2.getMessage());
        }
        
       
        
        
        add(table.getTableHeader(), BorderLayout.PAGE_START);
        add(table, BorderLayout.CENTER);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        
        
       
        
        
        
        
        
  
        setVisible(true); 
    } 
    
    /////////////////////////////////////////////////////
  
    // method actionPerformed() 
    // to get the action performed 
    // by the user and act accordingly 
    public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == sub) { 
          
        		int choice1;
                int flight_code;       // The special code that each flight is assigned like F1007
        		String airline;           // Eg. Indigo or AirIndia
        		String date_of_departure;
        		int booking_id;
        		String date_of_arrival;
        		String time_of_departure;
        		String time_of_arrival;
        		int ticket_price;
        		int quantity;
        		int passenger_id;
        		String destination_code;  //Eg. LAX or PNX
        		String source_code;       //Eg. LAX or PNX
        		
        		if(j1.isSelected())
        		{
        			choice1 = 1;
        		}
        		else
        		{
        			choice1 = 2;
        		}
                flight_code = (Integer) Integer.parseInt(tfid.getText()); 
                airline = (String)airline1.getSelectedItem(); 
                ticket_price = Integer.parseInt((String)price.getSelectedItem());
                time_of_departure = tname2.getText();
                time_of_arrival = tname3.getText();
                quantity = Integer.parseInt(qty1.getText());
                destination_code = dest1.getText();
                source_code = src1.getText();         		
                date_of_departure = (String)year.getSelectedItem() + "-" + (String)month.getSelectedItem() + "-" + (String)date.getSelectedItem() ; 
                date_of_arrival = (String)year1.getSelectedItem() + "-" + (String)month1.getSelectedItem() + "-" + (String)date1.getSelectedItem() ; 
                
                
                res.setText("Booking Successfully.."); 
                
                Booking b = new Booking();
                b.flight_code = flight_code;       
        		b.airline =  airline;          
        		b.date_of_departure =  date_of_departure;
        		b.date_of_arrival = date_of_arrival;
        		b.time_of_departure = time_of_departure;
        		b.time_of_arrival = time_of_arrival;
        		b.ticket_price =ticket_price;
        		b.quantity =quantity;
        		b.destination_code = destination_code;  
        		b.source_code = source_code; 
        		SeatingChart chart = new SeatingChart();
        		
        		if(choice1==1)
        		{
        			 
        			b.booking_status = "On Time";
        			
        			try 
        		    {	    	
        		            String url = "jdbc:mysql://localhost:3306/airport";
        		            Connection conn = DriverManager.getConnection(url,"root","Kashish310311");
        		            Statement stmt = conn.createStatement();	         
        		            
        		            stmt.executeUpdate("insert into bookings(flight_code, destination_code, source_code, airline, date_of_departure, date_of_arrival, time_of_departure, time_of_arrival, ticket_price, quantity, booking_status ) values ( '"  + b.flight_code + "','" +b.destination_code + "','" +b.source_code+ "','" +b.airline+ "','" +b.date_of_departure+ "','" +b.date_of_arrival+ "','" +b.time_of_departure+ "','" + b.time_of_arrival+ "','" +b.ticket_price+ "','" +b.quantity+ "','" +b.booking_status+ "');");	           
        		            conn.close();
        	        } 
        		    catch (Exception e1) 
        		    {
        	            System.err.println("Got an exception! ");
        	            System.err.println(e1.getMessage());
        	        }
        			
        			
        			try 
        		    {	    	
        		            String url = "jdbc:mysql://localhost:3306/airport";
        		            Connection conn = DriverManager.getConnection(url,"root","Kashish310311");
        		            Statement stmt = conn.createStatement();	         
        		            ResultSet rs;
        		            rs = stmt.executeQuery("Select MAX(booking_id) as MaxLevel from bookings;");	    
        		            while(rs.next())
        		            {
        		            	b.booking_id = rs.getInt("MaxLevel");
        		            	
        		            }
        		            conn.close();
        	        } 
        		    catch (Exception e1) 
        		    {
        	            System.err.println("Got an exception! ");
        	            System.err.println(e1.getMessage());
        	        }
        			
        			res.setText("\n Please remember that your booking id is : " + b.booking_id + "\n If you want to cancel/modify your ticket in the future, use this id");
        			
        			NonAutomatedThread producer3 = new NonAutomatedThread(chart, 3 , b.booking_id , b.flight_code);
        			Thread pro3 = new Thread(producer3);
        		    pro3.start();
        		}
        		else if(choice1==2)
        		{
        		
        			
        			b.booking_status = "On Time";
        			
        			try 
        		    {	    	
        		            String url = "jdbc:mysql://localhost:3306/airport";
        		            Connection conn = DriverManager.getConnection(url,"root","Kashish310311");
        		            Statement stmt = conn.createStatement();	         
        		           
        		            stmt.executeUpdate("insert into bookings(flight_code, destination_code, source_code, airline, date_of_departure, date_of_arrival, time_of_departure, time_of_arrival, ticket_price, quantity,booking_status ) values ( '"  + b.flight_code + "','" +b.destination_code + "','" +b.source_code+ "','" +b.airline+ "','" +b.date_of_departure+ "','" +b.date_of_arrival+ "','" +b.time_of_departure+ "','" + b.time_of_arrival+ "','" +b.ticket_price+ "','" +b.quantity+ "','" +b.booking_status+ "');");	           
        		            conn.close();
        	        } 
        		    catch (Exception e2) 
        		    {
        	            System.err.println("Got an exception! ");
        	            System.err.println(e2.getMessage());
        	        }
        	        
        	        
        			
        			try 
        		    {	    	
        		            String url = "jdbc:mysql://localhost:3306/airport";
        		            Connection conn = DriverManager.getConnection(url,"root","Kashish310311");
        		            Statement stmt = conn.createStatement();	         
        		            ResultSet rs;
        		            rs = stmt.executeQuery("Select MAX(booking_id) as MaxLevel from bookings;");	    
        		            while(rs.next())
        		            {
        		            	b.booking_id = rs.getInt("MaxLevel");
        		            }
        		            conn.close();
        	        } 
        		    catch (Exception e1) 
        		    {
        	            System.err.println("Got an exception! ");
        	            System.err.println(e1.getMessage());
        	        }
        			
        			
        			res.setText("\n Please remember that your booking id is : " + b.booking_id + "\n If you want to cancel/modify your ticket in the future, use this id");
        		
        			AutomatedThread producer1 = new AutomatedThread(chart, 1 , b.booking_id , b.flight_code, b.quantity);
         			Thread pro1 = new Thread(producer1);
         		    pro1.start();
        			 
           
        } 
  
        else if (e.getSource() == reset) { 
            String def = ""; 
             
            tid.setText(def); 
            tfid.setText(def); 
            tname2.setText(def); 
            tname3.setText(def); 
            tmno.setText(def); 
            qty1.setText(def); 
            dest1.setText(def); 
            src1.setText(def); 
            
            
            date.setSelectedIndex(0); 
            month.setSelectedIndex(0); 
            year.setSelectedIndex(0); 
            date1.setSelectedIndex(0); 
            month1.setSelectedIndex(0); 
            year1.setSelectedIndex(0); 
            
            price.setSelectedIndex(0); 
            airline1.setSelectedIndex(0); 
            
   
         
        } 
   
        }
    }
}

//----------------------------------------------------------------------------------------------------------





class MyFrame1 extends JFrame implements ActionListener 
{ 
	  
    // Components of the Form 
    private Container c; 
    private JLabel title; 
   
    private JLabel id; 
    private JTextField tid;
    private JTextField tid1;
    private JLabel qty;
    private JTextField qty1;
    private JButton sub; 
    private JButton reset;
    private JLabel res;
 
  
    // constructor, to initialize the components 
    // with default values. 
    public MyFrame1() throws IOException 
    { 
        setTitle("Flight Booking Portal"); 
        setBounds(300, 90, 1500, 1500); 
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
        setResizable(true); 
        
        BufferedImage img = ImageIO.read(new File("C:/Users/kashish/Desktop/imgs/cancellation.jpg"));
        JLabel background = new JLabel(new ImageIcon(img));
        background.setSize(1000,1000);
        
        setContentPane(background);
        setLayout(null);
        
  
        
 
        title = new JLabel("Cancellation Page"); 
        title.setFont(new Font("Arial", Font.PLAIN, 50)); 
        title.setSize(800, 50); 
        title.setLocation(500, 20); 
        title.setForeground(Color.BLACK);
        add(title); 
  
        id = new JLabel("Booking ID"); 
        id.setFont(new Font("Arial", Font.BOLD, 35)); 
        id.setSize(200, 40); 
        id.setForeground(Color.BLACK);
        id.setLocation(450, 200); 
        add(id); 
  
        tid = new JTextField(); 
        tid.setFont(new Font("Arial", Font.PLAIN, 30)); 
        tid.setSize(300, 50); 
        tid.setLocation(650, 200); 
        tid.setForeground(Color.BLACK);
        add(tid); 
  
        
        
        tid1 = new JTextField(); 
        tid1.setFont(new Font("Arial", Font.PLAIN, 30)); 
        tid1.setSize(600, 50); 
        tid1.setLocation(400, 350); 
        tid1.setBackground(Color.darkGray);
        tid1.setForeground(Color.WHITE);
        add(tid1); 
        
        
        
        /////////////////////////////////////////////////////////
        
        sub = new JButton("Submit"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 30)); 
        sub.setSize(200, 40); 
        sub.setLocation(300, 450); 
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.WHITE);
        sub.addActionListener(this); 
        add(sub); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 30)); 
        reset.setSize(200, 40); 
        reset.setLocation(900, 450);
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.addActionListener(this); 
        add(reset);
        
       
        setVisible(true); 
    } 
    
    /////////////////////////////////////////////////////
  
    // method actionPerformed() 
    // to get the action performed 
    // by the user and act accordingly 
    public void actionPerformed(ActionEvent e) 
    { 
		        if (e.getSource() == sub) 
		        { 
		          
		        		
		        		int id;
		        		
		        		
		                id = Integer.parseInt(tid.getText());
		               	
		        			try 
		        		    {	    	
		        		            String url = "jdbc:mysql://localhost:3306/airport";
		        		            Connection conn = DriverManager.getConnection(url,"root","Kashish310311");
		        		            Statement stmt = conn.createStatement();	         
		        		            stmt.executeUpdate("Delete FROM bookings where booking_id ='" + id + "';");
		        		                  
		        		            conn.close();
		        	        } 
		        		    catch (Exception e2) 
		        		    {
		        	            System.err.println("Got an exception! ");
		        	            System.err.println(e2.getMessage());
		        	        }
		        			
		        			
		        			try 
		        		    {	    	
		        		            String url = "jdbc:mysql://localhost:3306/airport";
		        		            Connection conn = DriverManager.getConnection(url,"root","Kashish310311");
		        		            Statement stmt = conn.createStatement();	         
		        		            stmt.executeUpdate("Delete FROM tickets where booking_id ='" + id + "';");
		        		                  
		        		            conn.close();
		        	        } 
		        		    catch (Exception e2) 
		        		    {
		        	            System.err.println("Got an exception! ");
		        	            System.err.println(e2.getMessage());
		        	        }
		        			
		        			 tid1.setText("Cancellation successful. ");
		        			
		        			 
		           
		        } 
		  
		        else if (e.getSource() == reset) 
		        { 
		            String def = ""; 
		             
		            tid.setText(def); 
		          
		            
		   
		         
		        } 
   
        }
    }







//------------------------------------------------------------------------------------------------------------------






class MyFrame3 extends JFrame implements ActionListener { 
	  
    // Components of the Form 
    private Container c; 
    private JLabel title; 
    private JLabel nameair;  
    private JLabel id; 
    private JTextField tid;
    private JTextField tid1;
    private JLabel qty;
    private JTextField qty1;
    private JButton sub; 
    private JButton reset; 
    private JLabel res;

  
    public MyFrame3() throws IOException 
    { 
        setTitle("Flight Booking Portal"); 
        setBounds(300, 90, 1500, 1500); 
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
        setResizable(true); 
        
        BufferedImage img = ImageIO.read(new File("C:/Users/kashish/Desktop/imgs/modify.jpg"));
        JLabel background = new JLabel(new ImageIcon(img));
        background.setSize(7000,7000);
        
        setContentPane(background);
        setLayout(null);
 
        title = new JLabel("Modify Tickets"); 
        title.setFont(new Font("Arial", Font.PLAIN, 50)); 
        title.setSize(800, 50); 
        title.setLocation(550, 20); 
        title.setForeground(Color.WHITE);
        add(title); 
  
        id = new JLabel("Booking Id"); 
        id.setFont(new Font("Arial", Font.PLAIN, 30)); 
        id.setSize(300, 40); 
        id.setForeground(Color.WHITE);
        id.setLocation(450, 200); 
        add(id); 
  
        tid = new JTextField(); 
        tid.setFont(new Font("Arial", Font.PLAIN, 30)); 
        tid.setSize(300, 40); 
        tid.setLocation(650, 200); 
        tid.setForeground(Color.BLACK);
        add(tid); 
        
        tid1 = new JTextField(); 
        tid1.setFont(new Font("Arial", Font.PLAIN, 30)); 
        tid1.setSize(600, 50); 
        tid1.setLocation(400, 400); 
        tid1.setBackground(Color.darkGray);
        tid1.setForeground(Color.WHITE);
        add(tid1); 
  
        
        
        
        
        /////////////////////////////////////////////////////////
        
        sub = new JButton("Submit"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 30)); 
        sub.setSize(200, 40); 
        sub.setLocation(300, 500); 
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.WHITE);
        sub.addActionListener(this); 
        add(sub); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 30)); 
        reset.setSize(200, 40); 
        reset.setLocation(900, 500);
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.addActionListener(this); 
        add(reset);
  
        
        
        
        /////////////////////////////////////////////////////////
        
        
        qty= new JLabel("Number of tickets"); 
        qty.setFont(new Font("Arial", Font.PLAIN, 30)); 
        qty.setForeground(Color.WHITE);
        qty.setSize(400, 40); 
        qty.setLocation(450, 300); 
        add(qty); 
        
        qty1 = new JTextField(); 
        qty1.setFont(new Font("Arial", Font.PLAIN, 30)); 
        qty1.setSize(300, 40); 
        qty1.setForeground(Color.BLACK);
        qty1.setLocation(700, 300); 
        add(qty1); 
        
       
        
        
      
  
        setVisible(true); 
    } 
    
    /////////////////////////////////////////////////////
  
    // method actionPerformed() 
    // to get the action performed 
    // by the user and act accordingly 
    public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == sub) 
        { 
          
        		int quantity;
        		int bid;
        		
        		
      
        		bid = (Integer) Integer.parseInt(tid.getText());
                quantity = Integer.parseInt(qty1.getText());
                
           
                	
        			try 
        		    {	    	
        		            String url = "jdbc:mysql://localhost:3306/airport";
        		            Connection conn = DriverManager.getConnection(url,"root","Kashish310311");
        		            Statement stmt = conn.createStatement();	         
        		            stmt.executeUpdate("Update bookings set  quantity ='" +quantity+ "' where booking_id ='" + bid + "';");
        		          	           
        		            conn.close();
        	        } 
        		    catch (Exception e1) 
        		    {
        	            System.err.println("Got an exception! ");
        	            System.err.println(e1.getMessage());
        	        }
        			
        			tid1.setText("Modification Succesful");
        			
        			
        			
        }
        			
        			
        		
  
        else if (e.getSource() == reset) { 
            String def = ""; 
             
            tid.setText(def);
            qty1.setText(def); 
                    
   
         
        } 
   
        }
    }






//---------------------------------------------------------------------------------------------------------


class MyFrame2 extends JFrame implements ActionListener { 
	  
    // Components of the Form 
    private Container c; 
    private JLabel title; 
    private JLabel nameair;  
    private JLabel id; 
    private JTextField tid;
    private JLabel qty;
    private JTextArea qty1;
    private JButton sub; 
    private JButton reset; 
    private JLabel res;

  
    public MyFrame2() 
    { 
        setTitle("View Status"); 
        setBounds(300, 90, 1500, 1500); 
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
        setResizable(true); 
        
        BufferedImage img = null;
        
		try {
			img = ImageIO.read(new File("C:/Users/kashish/Desktop/imgs/view.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JLabel background = new JLabel(new ImageIcon(img));
        background.setSize(1000,1000);
        
        setContentPane(background);
        setLayout(null);
        
        
        title = new JLabel("Flight Status Portal"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(300, 50); 
        title.setLocation(600, 20); 
        title.setForeground(Color.WHITE);
        add(title); 
  
        id = new JLabel("Booking Id"); 
        id.setFont(new Font("Arial", Font.PLAIN, 30)); 
        id.setSize(300, 50); 
        id.setLocation(500, 200); 
        id.setForeground(Color.WHITE);
        add(id); 
  
        tid = new JTextField(); 
        tid.setFont(new Font("Arial", Font.PLAIN, 30)); 
        tid.setSize(300, 50); 
        tid.setLocation(650, 200); 
        add(tid); 
  
        
        
        
        /////////////////////////////////////////////////////////
        
        
       
        
        qty1 = new JTextArea(); 
        qty1.setFont(new Font("Arial", Font.PLAIN, 30)); 
        qty1.setSize(650, 300); 
        qty1.setLocation(400, 400);
        qty1.setBackground(Color.darkGray);
        qty1.setForeground(Color.WHITE);
        add(qty1); 
        
       
        
        
        
        
        /////////////////////////////////////////////////////////
        
        sub = new JButton("Submit"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 30)); 
        sub.setSize(300, 50); 
        sub.setLocation(300, 300); 
        sub.addActionListener(this); 
        add(sub); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 30)); 
        reset.setSize(300, 50); 
        reset.setLocation(900, 300); 
        reset.addActionListener(this); 
        add(reset);
        
  
        setVisible(true); 
    } 
    
    /////////////////////////////////////////////////////
  
    // method actionPerformed() 
    // to get the action performed 
    // by the user and act accordingly 
    public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == sub) 
        { 
          
        		
      
        		int id = (Integer) Integer.parseInt(tid.getText());
           
                 
        				HashMap<Integer, String> status_booked =  new HashMap<Integer, String>();  
        				
        				try 
        				{
        					
        				        String url = "jdbc:mysql://localhost:3306/airport";
        				        Connection conn = DriverManager.getConnection(url,"root","Kashish310311");
        				        Statement stmt = conn.createStatement();
        				        ResultSet rs;

        				        rs = stmt.executeQuery("SELECT * FROM bookings where booking_id ='" + id + "';");
        				        while ( rs.next() )
        				        {
        				        	
        				        	int p = rs.getInt("flight_code");
        				        	String s = rs.getString("booking_status");
        				            status_booked.put(p,s);
        				        }
        				        conn.close();
        				} 
        				catch (Exception e7) 
        				{
        					qty1.append("Got an exception! ");
        					qty1.append(e7.getMessage());
        				}
        				qty1.append("\n\nShowing your booking  statuses:"); 
        				qty1.append("\n\nFlight Code\tStatus"); 
        				for (Map.Entry<Integer, String> e1 : status_booked.entrySet()) 
        					qty1.append("\n"+e1.getKey() 
        				                       + "\t"
        				                       + e1.getValue());  

        	        
        			
        }		
        		
  
        else if (e.getSource() == reset)
        {
        	String def = "";
            tid.setText(def);
    
                    
   
         
        } 
   
   }
    
        
   }



//---------------------------------------------------------------------------------------------




//-----------------------------------------------------------------------------------------------------------

public  class Passenger 

{

	/**
	 * @param args
	 * @throws IOException 
	 * @throws Exception 
	 */
	@SuppressWarnings("resource")
	public void main(String[] args) throws IOException  
	{
		
		MyFrame10 f = new MyFrame10();
		
		

	}
	
	
	

}

	
