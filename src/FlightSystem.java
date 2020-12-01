import java.awt.Container;


import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import java.util.concurrent.*; 

import javax.swing.*; 

import java.awt.*; 
import java.awt.event.*; 
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*; 
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;



class MyFrame4 extends JFrame implements ActionListener { 
	  
    // Components of the Form 
    private Container c; 
    private JButton a1;
    private JButton a2;
    private JButton a3;
    private JButton a4;
    private JLabel a;
    
    private JLabel b1;
    private JLabel b;
    private JTextField b2;
    private JLabel b3;
    private JPasswordField b4;
    private JTextField b5;
    
    private String username;
    private String password;
    
    
    public MyFrame4() throws IOException 
		    { 
    	
    	
    	
    	
        setTitle("Flight Booking Portal"); 
   
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
        setBounds(300,90,1000,1000);
        setResizable(true); 
        
        
        
        BufferedImage img = ImageIO.read(new File("C:/Users/kashish/Desktop/imgs/b1.jpg"));
        JLabel background = new JLabel(new ImageIcon(img));
        background.setSize(1000,1000);
        
        setContentPane(background);
        setLayout(null);
        
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        
        b = new JLabel("Welcome to Kashish's Airport!"); 
        b.setFont(new Font("Arial", Font.ITALIC, 45)); 
        b.setSize(1500, 40); 
        b.setLocation(400, 40);
        b.setForeground(Color.WHITE);
        add(b);
        
        b1 = new JLabel("Username"); 
        b1.setFont(new Font("Arial", Font.PLAIN, 20)); 
        b1.setSize(300, 40); 
        b1.setLocation(450, 150);

        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        //id.setForeground(Color.WHITE);
        add(b1); 
  
        b2 = new JTextField(); 
        b2.setFont(new Font("Arial", Font.PLAIN, 20)); 
        b2.setSize(300, 40); 
        b2.setLocation(550, 150); 

        b2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        add(b2); 
        
        b3 = new JLabel("Password"); 
        b3.setFont(new Font("Arial", Font.PLAIN, 20)); 
        b3.setSize(300, 40); 
        b3.setLocation(450, 200);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        add(b3); 
  
        b4 = new JPasswordField(); 
        b4.setFont(new Font("Arial", Font.PLAIN, 20)); 
        b4.setSize(300, 40); 
        b4.setLocation(550, 200); 
        b4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
     
        add(b4); 
       
        
        b5 = new JTextField(); 
        b5.setFont(new Font("Arial", Font.PLAIN, 20)); 
        b5.setSize(500, 40); 
        b5.setLocation(450, 400); 
        b5.setBackground(Color.darkGray);
        b5.setForeground(Color.WHITE);
        add(b5); 
        
        a1 = new JButton("Sign In"); 
        a1.setBounds(550,300,100,50);
        a1.setBackground(Color.yellow); 
        a1.setForeground(Color.BLACK);
        a1.setFont(new Font("Arial", Font.PLAIN, 15));
        a1.setOpaque(true);
        a1.addActionListener(this); 
        a1.setBorder(border);
        add(a1);
        
        a2 = new JButton("Sign Up"); 
        a2.setBounds(350,300,100,50);
        a2.setBackground(Color.CYAN); 
        a2.setForeground(Color.BLACK);
        a2.setFont(new Font("Arial", Font.PLAIN, 15));
        a2.setOpaque(true);
        a2.addActionListener(this); 
        a2.setBorder(border);
        add(a2);
        
        a3 = new JButton("Reset"); 
        a3.setBounds(750,300,100,50);
        a3.setBackground(Color.green); 
        a3.setForeground(Color.BLACK);
        a3.setFont(new Font("Arial", Font.PLAIN, 15));
        a3.setOpaque(true);
        a3.addActionListener(this); 
        a3.setBorder(border);
        add(a3);
        
        a4 = new JButton("Guidelines"); 
        a4.setBounds(950,300,100,50);
        a4.setBackground(Color.RED); 
        a4.setForeground(Color.BLACK);
        a4.setFont(new Font("Arial", Font.PLAIN, 15));
        a4.setOpaque(true);
        a4.addActionListener(this); 
        a4.setBorder(border);
        add(a4);
 
        setVisible(true);

    	
    
    } 
    
    
    public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == a1) 
        	
        {
        	username = b2.getText();
        	password = b4.getText();
        	String s = null;
        	
        	try 
    		{
    				String url = "jdbc:mysql://localhost:3306/airport";		
    		        Connection conn = DriverManager.getConnection(url,"root","Kashish310311");
    		        Statement stmt = conn.createStatement();
    		        ResultSet rs;
    		        rs = stmt.executeQuery("SELECT * FROM users where Username='" + username + "';");
    		        while ( rs.next() )
    		        {
    		        	s = rs.getString("password");
    		            
    	            
    		        }
    		        conn.close();
    		} 
    		catch (Exception e2) 
    		{
    		       
    		        System.err.println(e2.getMessage());
    	    }	
        	
        	if (password.equalsIgnoreCase("authority") &&  password.equalsIgnoreCase(s))
        	{
        	
        		b5.setText("Authority Succesfully Logged In");
	        	Authority aut = new Authority(); 
	        	try 
	        	{
					aut.main(new String[0]);
				} catch (InterruptedException e1) 
	        	{
			
					e1.printStackTrace();
				}
        	}
        	
        	else if (password.equalsIgnoreCase("employee") &&  password.equalsIgnoreCase(s))
        	{
        		b5.setText("Employee Succesfully Logged In");
        		Employee emp = new Employee(); 
        		emp.main(new String[0]);
        	}
        	
        	else if (password.equalsIgnoreCase("passenger") &&  password.equalsIgnoreCase(s))
        	{
        	
        		b5.setText("Passenger Succesfully Logged In");
        		Passenger pas = new Passenger(); try {
    				pas.main(new String[0]);
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
        	}
        	else
        	{
        		
        		b5.setText("Invalid credentials");
        	}
    
        
        
       
        
        
        }
        
        if (e.getSource() == a2) 
        {
        	
        	username = b2.getText();
        	password = b4.getText();
        	String s = null;
        	try 
    		{
    				String url = "jdbc:mysql://localhost:3306/airport";		
    		        Connection conn = DriverManager.getConnection(url,"root","Kashish310311");
    		        Statement stmt = conn.createStatement();
    		        Statement stmt1 = conn.createStatement();
    		        
    		        ResultSet rs;
    		        rs = stmt.executeQuery("SELECT * FROM users where Username='" + username + "';");
    		        if( rs.next())
    		        {
    		        	b5.setText("User already exists.");
    		                	            
    		        }
    		        else
    		        {
    		        	
    		        	stmt1.executeUpdate("insert into users values (null,'" + username +  "','" + password + "');");
    		        	b5.setText("New user account created.");
    		        }
    		        conn.close();
    		} 
    		catch (Exception e2) 
    		{
    		       
    		        System.err.println(e2.getMessage());
    	    }	
        	
        	
        }
        
        
        
        if (e.getSource() == a3) 
        {
        	
        	String def = ""; 
            
            b2.setText(def);
            b5.setText(def);
            b4.setText(def);
        	
        	
        }
        
        if(e.getSource() == a4)
        {
        	guidelines g = new guidelines(); try {
				g.main(new String[0]);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
       
    
    }
    
    
    
    
}


public class FlightSystem {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		MyFrame4 f = new MyFrame4();

	}

}
