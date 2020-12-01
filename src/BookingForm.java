import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;
/**
 *
 * @author kashish
 */
public class BookingForm {
    
    
    private JFrame frame;

	public BookingForm(SeatingChart chart, int b_id, int f_id){
		frame = new JFrame();
		
		final int FIELD_WIDTH = 7;
		
		JLabel colName = new JLabel("Enter Column:");
		final JTextField columnField = new JTextField(FIELD_WIDTH);
		
		JLabel rowName = new JLabel("Enter Row:");
		final JTextField rowField = new JTextField(FIELD_WIDTH);
		
		JButton seatButton = new JButton("Book Seat");
		
		final JTextField pendingField = new JTextField(12);
		pendingField.getSelectionColor();
		pendingField.setText("Pending");
		
		ArrayList<Integer> rows = new ArrayList<Integer>();
		ArrayList<Integer> cols = new ArrayList<Integer>();
		
		
		try 
		{
	            String url = "jdbc:mysql://localhost:3306/airport";
	            Connection conn = DriverManager.getConnection(url,"root","Kashish310311");
	            Statement stmt = conn.createStatement();
	            ResultSet rs;
	 
	            rs = stmt.executeQuery("SELECT * FROM tickets where flight_code ='" + f_id + "';");
	            while ( rs.next() ) 
	            {
	            	
		            int x = rs.getInt("seat_row");
		            int y = rs.getInt("seat_column");
		            //chart.setSeat(x, y, 1);
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
		
		
		
		
		seatButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						int row = Integer.parseInt(rowField.getText());
						int column = Integer.parseInt(columnField.getText());
						if(chart.isFull() == false){
							if(column>0 && column<5 && row>0 && row<51){
								rowField.setText("");
								columnField.setText("");
								int check = 0;
								for (int i=0;i<rows.size();i++)
								{
									if(rows.get(i)==column-1 && cols.get(i)==row-1)
									{
										check = 1;
										System.out.println("\nIn database");
									}
								}
								
						
								if(chart.checkSeat(column-1,row-1) == true && check==0)
								{
									chart.setSeat(column-1, row-1, 3);
									System.out.println(column + "," + row + " is booked by: #");
									pendingField.setText("(" + column + "," + row + ") has been booked");
											try 
										    {	    	
										            String url = "jdbc:mysql://localhost:3306 /airport";
										            Connection conn = DriverManager.getConnection(url,"root","Kashish310311");
										            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("insert into tickets(seat_row,seat_column,booking_id) values ( '" +  (column-1) + "','" + (row-1) +  "','" + b_id  + "');");          
											       										        								           
										            stmt.executeUpdate();
										            conn.close();
									        } 
										    catch (Exception e) 
										    {
									            System.err.println("Got an exception! ");
									            System.err.println(e.getMessage());
									        }
								}else{
									rowField.setText("");
									columnField.setText("");
									pendingField.setText("(" + column + "," + row + ") is taken");
									
								}
							}else{
								rowField.setText("");
								columnField.setText("");
								pendingField.setText("(" + column + "," + row + ") doesn't exist");
							}
						}else{
							pendingField.setText("Plane is full!");
						}
						
						
					}
				});
		
		
		
		JButton close = new JButton("Close form");
		close.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		       frame.dispose();
		    }
		});
	
		
		frame.setLayout(new FlowLayout());
		
		
		
		frame.add(colName);
		frame.add(columnField);
		frame.add(rowName);
		frame.add(rowField);
		frame.add(seatButton);
		frame.add(pendingField);
		frame.add(close);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		
		
	}
	
	public void visible(){
		this.frame.setVisible(true);
	}
}
