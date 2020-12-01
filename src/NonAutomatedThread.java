import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class NonAutomatedThread implements Runnable{

	private SeatingChart chart;
	private int ID;
	private int b_id;
	private int f_id;
	/**
	 * Constructor for class NonAutomatedThread
	 * @param chart
	 * @param ID
	 */
	NonAutomatedThread(SeatingChart chart, int ID , int b_id, int f_id){
		assert ID == 3 : ("Violated Precondition. ID must be 1 or 2 for AutomatedThread");
		this.chart = chart;
		this.ID = ID;
		this.b_id = b_id;
		this.f_id = f_id;
	}
	public void run()
	{
			
			if(ID == 3)
			{
				if(chart.isFull()==false)
				{
					BookingForm form = new BookingForm(chart,b_id, f_id);		
					form.visible();
				}else
				{
					System.out.println("There are no more seats on this plane");
				}
			}
			
			
			
			
	}
    

}
