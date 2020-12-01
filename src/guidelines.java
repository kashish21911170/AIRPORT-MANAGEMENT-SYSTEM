

import java.awt.Color;
import java.awt.Container;


import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
import java.sql.Statement;

import javax.swing.*; 
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;



class MyFrame12 extends JFrame implements ActionListener 
{ 
	  
    // Components of the Form 
    private Container c; 
    private JTextArea a1;
    private JLabel a;
    private JButton b;
    private JButton b1;

    public MyFrame12() throws IOException 
    { 
    	
    	setTitle("Rulebook for Application Usage"); 
    	setBounds(300,90,700,700);
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
        setResizable(true); 
        setBackground(Color.BLACK);
      
        
        
        
        BufferedImage img = ImageIO.read(new File("C:/Users/kashish/Desktop/imgs/guidelines.jpg"));
        JLabel background = new JLabel(new ImageIcon(img));
        background.setSize(7000,7000);
        
        setContentPane(background);
        setLayout(null);
 
        
        
        
        
        /////////////////////////////////////////////////////////
        
        a1 = new JTextArea();
        a1.setText("\nA. To Operate as Authority");
        a1.append("\n\t1- Sign up and create an account with password authority\n\t2- Click check status to see the current status of every plane currently on your airport, to make sure everything is as \n\t    planned\n\t3- Click see departments to view the sectors of the airport that are under your supervision\n\t4- Click allocate duties to distribute the tasks among worker threads. Once they are completed, you will be informed.");
        a1.append("\n\nB. To Operate as Employee ");
        a1.append("\n\t1- Sign up and create account with password employee\n\t2- Click main flight database and view flights to see the latest flight dashboard\n\t3- Click runway operations and go to the runway portal to schedule takeoffs.\n\t4- You can see the current flights arriving and in hangar, which you can add to the arrival and departures runway, and will \n\t    be queued for landing/takeoff.\n\t5-  You can also remove flights from the runway by priority. \n\t6- Finally you can simulate the runway after you have set it up, and the system will automatically queue and send\n\t     the planes on appropriate routes.");
        a1.append("\n\nC. To Operate as Passenger");
        a1.append("\n\t1- Sign up and create account with password passenger\n\t2- Click book to book new tickets, and enter the details of the flight that you want from the dashboard above the form. \n\t3- You can book tickets using either manual entry or a bot.\n\t4- If you choose manual entry, you will be directed to a form, that allows you to enter seat row and column.\n\t5- If you choose bot entry, the bot will automatically book all the seats \n\t6- To cancel your ticket simply enter your booking id into cancellation window \n\t7- To modify the booking, enter new number of tickets in the modification window. ");
        a1.setFont(new Font("Arial", Font.BOLD, 20)); 
        a1.setBounds(30, 20 , 1310 ,670); 
        a1.setBackground(Color.BLACK);
        a1.setForeground(Color.WHITE);
        a1.setBorder(BorderFactory.createLineBorder(Color.blue, 10));
        add(a1); 
        
       
        setVisible(true);
    }


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
					if(e.getSource()==b)
					{
						
						server aut = new server(); 
			        	try 
			        	{
							aut.main(new String[0]);
						} catch (InterruptedException e1) 
			        	{
					
							e1.printStackTrace();
						} catch (Exception e1) 
			        	{
							// TODO Auto-generated catch block
							e1.printStackTrace();
			        	}
					}
					
					
					
	}
	
}

    









public class guidelines 
{
	
	public static void main(String[] args) throws IOException
	{
		MyFrame12 f = new MyFrame12();
	}

}
