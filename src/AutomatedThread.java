import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;
import java.util.*;


public class AutomatedThread implements Runnable{

	
		// TODO Auto-generated method stub
		private SeatingChart chart;
		private int ID;
		private int b_id;
		private int f_id;
		private int qty;
		private ArrayList<Integer> rows ;
		private ArrayList<Integer> cols;
		
		/**
		 * Constructor for AutomatedThread
		 * @param chart
		 * @param ID
		 */
		AutomatedThread(SeatingChart chart, int ID, int b_id , int f_id, int qt){
			assert ID == 1 || ID == 2 : ("Violated Precondition. ID must be 1 or 2 for AutomatedThread");
			this.chart = chart; 
			this.ID = ID;
			this.b_id = b_id;
			this.f_id = f_id;
			this.qty = qt;
			rows = new ArrayList<Integer>();
			cols = new ArrayList<Integer>();
			
			
			try 
			{
		            String url = "jdbc:mysql://localhost:3306/airport";
		            Connection conn = DriverManager.getConnection(url,"root","Kashish310311");
		            Statement stmt = conn.createStatement();
		            ResultSet rs;
		 
		            rs = stmt.executeQuery("SELECT * FROM tickets where flight_code ='" + this.f_id + "';");
		            while ( rs.next() ) 
		            {
		            	
		            	int x = rs.getInt("seat_row");
			            int y = rs.getInt("seat_column");
			            System.out.println("\n" + x+" " + y);
			            //chart.setSeat( x, 	y, 1);
			            rows.add(x);
			            cols.add(y);
		            }
	            conn.close();
	            
	        } 
			catch (Exception e) 
			{
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	        }
			
			
			
		}
		public void run()
		{
			try
			{
			
				
				
				int z = this.qty;
				
				while((chart.isFull() == false))
				{
					
						if(z==0)
						{
							System.out.println("All booked");
							break;
						}
						Thread.sleep ((300));	
						if(ID == 1 || ID ==2)
						{
									//generates random row
									Random x = new Random();
									int xLow = 0;
									int xHigh = 4;
									int row = x.nextInt(xHigh-xLow) + xLow;
									//generates random column 
									Random y = new Random();
									int yLow = 0;
									int yHigh = 50;
									int column = y.nextInt(yHigh-yLow) + yLow;
									
									int check = 0;
									for (int i=0;i<rows.size();i++)
									{
										if(rows.get(i)==column-1 && cols.get(i)==row-1)
										{
											check = 1;
											System.out.println("\nIn database");
										}
									}
									
									if(chart.checkSeat(row, column) == true && check==0 )
									{ //checking if seat is available
										
										
												chart.setSeat(row, column, ID); //booking the seat
												System.out.println(row+1 + "," + (column+1) + " is booked by: " + ID);
												try 
											    {	    	
											            String url = "jdbc:mysql://localhost:3306/airport";
											            Connection conn = DriverManager.getConnection(url,"root","Kashish310311");
											            Statement stmt = conn.createStatement();	         
											           
											            stmt.executeUpdate("insert into tickets(seat_row,seat_column,booking_id, flight_code) values ('" + row + "','" + column +  "','" + b_id +  "','" + f_id + "');");	    
											            
											            conn.close();
										        } 
											    catch (Exception e) 
											    {
										            System.err.println("Got an exception! ");
										            System.err.println(e.getMessage());
										        }
												
										
									}
									else
									{
										System.out.println(row+1 + "," + (column+1) + " is taken by: " + chart.getSeat(row, column));
									}
						}
						
						z--;
					}
			}
			
			catch(InterruptedException exception){}
		}
	}


