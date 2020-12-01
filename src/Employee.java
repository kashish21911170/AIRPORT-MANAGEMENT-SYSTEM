
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*; 

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class MyFrame8 extends JFrame implements ActionListener { 
	  
    // Components of the Form 
    private Container c; 
    private JButton a1;
    private JTextArea a2;


    public MyFrame8() 
    { 
        setTitle("Main Flight Database"); 
        setBounds(300, 200, 100, 40); 
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
        setResizable(true); 
  
        BufferedImage img = null;
		try {
			img = ImageIO.read(new File("C:/Users/kashish/Desktop/imgs/a12.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JLabel background = new JLabel(new ImageIcon(img));
        background.setSize(2000,2000);
        
        setContentPane(background);
        setLayout(null);
        
        /////////////////////////////////////////////////////////
        
        a1 = new JButton("View Flights "); 
        a1.setFont(new Font("Arial", Font.PLAIN, 30)); 
        a1.setSize(400, 100); 
        a1.setLocation(450, 50); 
        a1.setBackground(Color.white); 
        a1.setForeground(Color.darkGray);
       
        a1.addActionListener(this); 
        add(a1); 
  
        a2 = new JTextArea(); 
        a2.setFont(new Font("Arial", Font.PLAIN, 20)); 
        a2.setSize(500, 600); 
        a2.setLocation(400, 170);  
        a2.setBackground(Color.darkGray); 
        a2.setForeground(Color.WHITE);
        add(a2);
        
        setVisible(true); 
        
    }
        
        public void actionPerformed(ActionEvent e) 
        { 
        	
        	if (e.getSource() == a1) 
            {
        		try {
                    String url = "jdbc:mysql://localhost:3306/airport";
                    Connection conn = DriverManager.getConnection(url,"root","Kashish310311");
                    Statement stmt = conn.createStatement();
                    ResultSet rs;
         
                    rs = stmt.executeQuery("SELECT * FROM flights;");
                    while ( rs.next() ) {
                    	
                    	a2.append("\nFlight Code: " + rs.getInt("flight_code")+ "   Airline: " +rs.getString("airline"));       
                		       
                		
       
                        
                    }
                    conn.close();
                } catch (Exception e3) {
                    System.err.println("Got an exception! ");
                    System.err.println(e3.getMessage());
                }
        		
        		 
            }
        	
        	
        	
        }
        
        
    }


class MyFrame9 extends JFrame implements ActionListener { 
	  
    // Components of the Form 
    private Container c; 
    private JButton a1;
    private JButton b1;
    private JButton c1;

    private JTextField a3;
    private JLabel a4;

    private JTextArea a2;
    private JTextArea a5;
    private JTextArea b2;
    private JTextArea c2;
    private JTextArea d2;
    PriorityQueue<Integer> runway_departing;
    PriorityQueue<Integer> runway_arriving;
    TreeMap<Integer, Flight> flights_available;  
    TreeMap<Integer, Flight> flights_departed;
    TreeMap<Integer, Flight> flights_arriving;
	TreeMap<Integer, Flight> flights_arrived;

    public MyFrame9() 
    { 
  	
    	
        setTitle("Runway Operations"); 
        setBounds(300, 90, 1000, 1000); 
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
      
    	
    	setResizable(true); 
    	  
        BufferedImage img = null;
		try {
			img = ImageIO.read(new File("C:/Users/kashish/Desktop/imgs/n1.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JLabel background = new JLabel(new ImageIcon(img));
      background.setSize(1000,1000);
        
        setContentPane(background);
        setLayout(null);
    	
    	
    	
    	
    	runway_departing = new PriorityQueue<Integer>();
  		 runway_arriving = new PriorityQueue<Integer>();
  		 flights_available =  new TreeMap<Integer, Flight>();  
  		 flights_departed =  new TreeMap<Integer, Flight>();
  		 flights_arriving =  new TreeMap<Integer, Flight>();
  		 flights_arrived=  new TreeMap<Integer, Flight>();
  		 
  		 
   		 
   		 
    		try {
                String url = "jdbc:mysql://localhost:3306/airport";
                Connection conn = DriverManager.getConnection(url,"root","Kashish310311");
                Statement stmt = conn.createStatement();
                ResultSet rs;
     
                rs = stmt.executeQuery("SELECT * FROM flights;");
                while ( rs.next() ) {
                	Flight f = new Flight();
                	f.priority =rs.getInt("priority");
            		f.status = rs.getString("status");
            		f.flight_code = rs.getInt("flight_code");       
            		f.airline = rs.getString("airline");        
            		f.date_of_departure = rs.getString("date_of_departure");
            		f.date_of_arrival =rs.getString("date_of_arrival");
            		f.time_of_departure = rs.getString("time_of_departure");
            		f.time_of_arrival =rs.getString("time_of_departure");
            		f.destination_code = rs.getString("destination_code"); 
            		f.source_code = rs.getString("source_code"); 
            		f.fuel = rs.getInt("fuel");
            		
            		if(f.status.equals("In Hangar"))
            		{
            			flights_available.put(f.flight_code,f);
            		}
            		else if(f.status.equals("Arriving"))
            		{
            			flights_arriving.put(f.flight_code,f);
            		}
                	
                    
                    
                }
                conn.close();
            } catch (Exception e3) {
                System.err.println("Got an exception! ");
                System.err.println(e3.getMessage());
            }
    		
  		 
  
  
        
        
        
        
        /////////////////////////////////////////////////////////
        
        a1 = new JButton("Add flight"); 
        a1.setFont(new Font("Arial", Font.PLAIN, 30)); 
        a1.setSize(300, 40); 
        a1.setLocation(80, 40); 
        a1.addActionListener(this); 
        a1.setBackground(Color.BLACK ); 
        a1.setForeground(Color.WHITE);
        add(a1); 
        
        b1 = new JButton("Remove Flight"); 
        b1.setFont(new Font("Arial", Font.PLAIN, 30)); 
        b1.setSize(300, 40); 
        b1.setLocation(500, 40); 
        b1.addActionListener(this); 
        b1.setBackground(Color.BLACK ); 
        b1.setForeground(Color.WHITE);
        add(b1);
        
        c1 = new JButton("Simulate Runway "); 
        c1.setFont(new Font("Arial", Font.PLAIN, 30)); 
        c1.setSize(300, 40); 
        c1.setLocation(920, 40); 
        c1.addActionListener(this); 
        c1.setBackground(Color.BLACK ); 
        c1.setForeground(Color.WHITE);
        add(c1);
        
        
        
        a4 = new JLabel("Enter Flight Code");
        a4.setFont(new Font("Arial", Font.PLAIN, 30)); 
        a4.setSize(300,40); 
        a4.setLocation(400, 100); 
        a4.setBackground(Color.BLACK ); 
        a4.setForeground(Color.WHITE);
        add(a4);
        
        a3 = new JTextField();
        a3.setFont(new Font("Arial", Font.PLAIN, 30)); 
        a3.setSize(300,40); 
        a3.setLocation(700, 100); 
        a3.setBackground(Color.BLACK ); 
        a3.setForeground(Color.WHITE);
        add(a3);
  
        a2 = new JTextArea(); 
        a2.setFont(new Font("Arial", Font.PLAIN, 15)); 
        a2.setSize(400,500); 
        a2.setLocation(100, 180); 
        a2.setBackground(Color.BLACK ); 
        a2.setForeground(Color.WHITE);
        add(a2);
       
        
        a2.append("\n\nAvailable flights in hangar:");
			a2.append("\nFlight Code"+"\tPriority");
			for (Map.Entry<Integer, Flight> e4 : flights_available.entrySet()) 
			{
				a2.append("\n"+e4.getKey()+ "\t"
                       + e4.getValue().priority);
			}
			
			a2.append("\n\nAvailable flights arriving from air:");
			a2.append("\nFlight Code"+"\tPriority");
			for (Map.Entry<Integer, Flight> e5 : flights_arriving.entrySet()) 
			{
				a2.append("\n"+e5.getKey()+ "\t"
                       + e5.getValue().priority);
			}
			
			
        
        
        b2 = new JTextArea(); 
        b2.setFont(new Font("Arial", Font.PLAIN,20)); 
        b2.setSize(400,500); 
        b2.setBackground(Color.BLACK ); 
        b2.setForeground(Color.WHITE);
        b2.setLocation(850, 180); 
        add(b2);
        
        
        
        setVisible(true); 
        
    }
        
        public void actionPerformed(ActionEvent e) 
        { 
        	
        	
        	
        	if (e.getSource() == b1) 
            {
        		a2.setText("");
        		b2.setText("");
        		
       				a2.setText("\n\nAvailable flights in hangar:");
       				a2.append("\nFlight Code"+"\tPriority");
       				for (Map.Entry<Integer, Flight> e4 : flights_available.entrySet()) 
       				{
       					a2.append("\n"+e4.getKey()+ "\t"
                                   + e4.getValue().priority);
       				}
       				
       				a2.append("\n\nAvailable flights arriving from air:");
       				a2.append("\nFlight Code"+"\tPriority");
       				for (Map.Entry<Integer, Flight> e5 : flights_arriving.entrySet()) 
       				{
       					a2.append("\n"+e5.getKey()+ "\t"
                                   + e5.getValue().priority);
       				}
       				
       			
       		            		
       			int fc = Integer.parseInt(a3.getText());
       			
       			
       								if(flights_available.containsKey(fc))
       								{
       									Flight x = flights_available.get(fc);
       									runway_departing.add(x.priority);
       									flights_available.remove(fc);
       									flights_departed.put(fc,x);
       								}
       								else if(flights_arriving.containsKey(fc))
       								{
       									Flight x = flights_arriving.get(fc);
       									runway_arriving.add(x.priority);
       									flights_arriving.remove(fc);
       									flights_arrived.put(fc,x);
       								}
       			
       								b2.append("\n\n\nRunway 1: Departures");
       								Iterator itr2 = runway_departing.iterator(); 
       								while (itr2.hasNext()) 
       									b2.append("\n" + itr2.next());
       								
       								b2.append("\n\n\n\nRunway 2: Arrivals");
       								Iterator itr1 = runway_arriving.iterator(); 
       								while (itr1.hasNext()) 
       									b2.append("\n"+ itr1.next());
       								
       								
       							
       						
       			}
        
        
        
        
        	if(e.getSource() ==a1)
        	{
        		
        		
        		
        	
        		a2.setText("");
        		b2.setText("");
        	
        		a2.setText("\n\nAvailable flights in hangar:");
   				a2.append("\nFlight Code"+"\tPriority");
   				for (Map.Entry<Integer, Flight> e4 : flights_available.entrySet()) 
   				{
   					a2.append("\n"+e4.getKey()+ "\t"
                               + e4.getValue().priority);
   				}
   				
   				a2.append("\n\nAvailable flights arriving from air:");
   				a2.append("\nFlight Code"+"\tPriority");
   				for (Map.Entry<Integer, Flight> e5 : flights_arriving.entrySet()) 
   				{
   					a2.append("\n"+e5.getKey()+ "\t"
                               + e5.getValue().priority);
   				}
   				
        		int pa = Integer.parseInt(a3.getText());
					if(flights_departed.containsKey(pa))
					{
						Flight x = flights_departed.get(pa);
						runway_departing.remove(x.priority);
						flights_departed.remove(pa);
						flights_available.put(pa,x);
					}
					else if(flights_arrived.containsKey(pa))
					{
						Flight x = flights_arrived.get(pa);
						runway_arriving.remove(x.priority);
						flights_arriving.put(pa,x);
						flights_arrived.remove(pa);
					}
					
					b2.append("\n\n\nRunway 1: Departures");
						Iterator itr2 = runway_departing.iterator(); 
						while (itr2.hasNext()) 
							b2.append(""+itr2.next());
						
						b2.append("\n\n\n\nRunway 2: Arrivals");
						Iterator itr1 = runway_arriving.iterator(); 
						while (itr1.hasNext()) 
							b2.append(""+ itr1.next());
		
		
				
        	}
        	
        	
        	
        
        
        	
        	if(e.getSource() ==c1)
        	{
        		a2.setText("");
        		b2.setText("");
        		
        		
        		a2.append("\n\n\n\nRunway 1: Departures");
					int y = 0;
					Flight t = new Flight();
			        while (runway_departing.size()>0) 
			        {
			        int x =runway_departing.poll();
			        for (Map.Entry<Integer, Flight> e6 : flights_departed.entrySet()) 
					{
			        	
			        	if(e6.getValue().priority==x)
			        	{
			        		t.priority = e6.getValue().priority;
			        		t.status = e6.getValue().status;
			        		t.flight_code =e6.getValue().flight_code ;       
			        		t.airline = e6.getValue().airline;        
			        		t.date_of_departure = e6.getValue().date_of_departure;
			        		t.date_of_arrival = e6.getValue().date_of_arrival;
			        		t.time_of_departure = e6.getValue().time_of_departure;
			        		t.time_of_arrival = e6.getValue().time_of_arrival;
			        		t.destination_code = e6.getValue().destination_code; 
			        		t.source_code = e6.getValue().source_code; 
			        		t.fuel = e6.getValue().fuel;
			        		a2.append("\nFlight " + t.flight_code + " Leaving Runway");
			        	}     
					}
			  
		            a2.append("\n\nFlight " + t.flight_code + " of priority " + t.priority + " Departed"); 
		            t.status = "Departed";
		            modify_status(t.flight_code,t.status);
		            flights_available.remove(x);
		            try
		            {
		                Thread.sleep(1000);
		            }
		            catch(InterruptedException ex)
		            {
		                Thread.currentThread().interrupt();
		            }
			        }
			        a2.append("\n\n\nRunway 1 empty");
			        
			        
			        b2.setText("\n\n\n\nRunway 2: Arrivals");
					int y1 = 0;
					int x1;
			        while (runway_arriving.size()>0) 
			        {
			        x1 =runway_arriving.poll();
			        Flight t1 = new Flight();
			        for (Map.Entry<Integer, Flight> e7 : flights_arrived.entrySet()) 
					{
			        	
			        	if(e7.getValue().priority==x1)
			        	{
			        		t1.priority = e7.getValue().priority;
			        		t1.status = e7.getValue().status;
			        		t1.flight_code =e7.getValue().flight_code ;       
			        		t1.airline = e7.getValue().airline;        
			        		
			        		t1.date_of_departure = e7.getValue().date_of_departure;
			        		t1.date_of_arrival = e7.getValue().date_of_arrival;
			        		t1.time_of_departure = e7.getValue().time_of_departure;
			        		t1.time_of_arrival = e7.getValue().time_of_arrival;
			        		t1.destination_code = e7.getValue().destination_code; 
			        		t1.source_code = e7.getValue().source_code; 
			        		t1.fuel = e7.getValue().fuel;
			        		b2.append("\nFlight " + t1.flight_code + " Approaching Hangar");
			        	}     
					}
			        
			  
		            b2.append("\nFlight " + t1.flight_code + " of priority " + t1.priority + " Arrived"); 
		            t1.priority = t1.priority  + 10;
		            t1.status = "In Hangar";
		            flights_available.put(t1.flight_code,t1);
		            try
		            {
		                Thread.sleep(1000);
		            }
		            catch(InterruptedException ex)
		            {
		                Thread.currentThread().interrupt();
		            }
			        }
			        b2.append("\n\n\nRunway 2 empty");
			        modify_status(t.flight_code,t.status);
			        modify_priority(t.flight_code,t.priority);
			   
			        
        		
        	}
        
        
        	}
        
        
        
       	     
        
        
        static void modify_status(int x, String y)
    	{
    		
    		try {
                String url = "jdbc:mysql://localhost:3306/airport";
                Connection conn = DriverManager.getConnection(url,"root","Kashish310311");
            
                ResultSet rs;
               
                String sqlUpdate = "UPDATE flights "
                        + "SET status = ? "
                        + "WHERE flight_code = ?";

                PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
          
                
                pstmt.setString(1, y);
                pstmt.setInt(2, x);
                int rowAffected = pstmt.executeUpdate();
                            
                    
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }
    		
    		
    	}
    		
    	static void modify_priority(int x, int y)
    	{
    		
    		try {
                String url = "jdbc:mysql://localhost:3306/airport";
                Connection conn = DriverManager.getConnection(url,"root","Kashish310311");
            
                ResultSet rs;
               
                String sqlUpdate = "UPDATE flights "
                        + "SET priority = ? "
                        + "WHERE flight_code = ?";

                PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
          
                
                pstmt.setInt(1, y);
                pstmt.setInt(2, x);
                int rowAffected = pstmt.executeUpdate();
                            
                    
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }
    		
    		
    	}
    		
        
        
    }





















































class MyFrame7 extends JFrame implements ActionListener { 
	  
    // Components of the Form 
    private Container c; 
    private JButton a1;
    private JButton a2;


    public MyFrame7() 
    { 
        setTitle("Employee Portal"); 
        setBounds(300, 90, 700, 700); 
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
        setResizable(true); 
        
        BufferedImage img = null;
		try {
			img = ImageIO.read(new File("C:/Users/kashish/Desktop/imgs/runway.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JLabel background = new JLabel(new ImageIcon(img));
        background.setSize(1000,1000);
        
        setContentPane(background);
        setLayout(null);
        
 
        
        
        
        
        /////////////////////////////////////////////////////////
        
        a1 = new JButton("Main Flight Database "); 
        a1.setFont(new Font("Arial", Font.PLAIN, 40)); 
        a1.setSize(500, 200); 
        a1.setLocation(200, 150); 
        a1.addActionListener(this); 
        a1.setBackground(Color.BLACK);
        a1.setForeground(Color.WHITE);
        add(a1); 
  
        a2 = new JButton("Runway Operations"); 
        a2.setFont(new Font("Arial", Font.PLAIN, 40)); 
        a2.setSize(500, 200); 
        a2.setLocation(800, 150); 
        a2.addActionListener(this);
        a2.setBackground(Color.BLACK);
        a2.setForeground(Color.WHITE);
        add(a2);
        
        setVisible(true); 
        
    }
        
        public void actionPerformed(ActionEvent e) 
        { 
        	
        	if (e.getSource() == a1) 
            {
        		MyFrame8 f = new MyFrame8();
            }
        	
        	if (e.getSource() == a2) 
            {
        		MyFrame9 f = new MyFrame9();
            }
        	
        }
        
        
    }










class Flight
{
	
	public int priority;			 // Airport employee can assign flight priority
	public String status;            //Eg. In hangar or On Runway or Departing or Landing
	public String destination_code;  //Eg. LAX or PNX
	public String source_code;       //Eg. LAX or PNX
	public int fuel;                 // Current fuel situation
	public int flight_code;       // The special code that each flight is assigned like F1007
	public String airline;           // Eg. Indigo or AirIndia
	public String date_of_departure;
	public String date_of_arrival;
	public String time_of_departure;
	public String time_of_arrival;
	
	public void Flight()
	{
		priority = 0;
		status = "In hangar";
		flight_code = 0;       
		airline = "XYZ";          
		date_of_departure = "2020-20-20";
		date_of_arrival = "2020-20-20";
		time_of_departure = "00:00:00";
		time_of_arrival = "00:00:00";
		destination_code = "ABC";  
		source_code = "ABC"; 
		fuel = 5;
	}




}

public class Employee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		MyFrame7 f = new MyFrame7();
		
		}
		

	
	
	
	
		
		
		
	}



