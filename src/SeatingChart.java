import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class SeatingChart {


		// TODO Auto-generated method stub
SeatingMap map = new SeatingMap();
		
		//create a 2d array of 200 seats
		private int[][] chart = new int[4][50];
		private boolean busy = true;
		// Object whose lock threads synchronize on.
		Object lockObject = new Object ();
		/**
		 * This method is used to know the status of the seat. 
		 * @param x the row of the seat
		 * @param y the column of the seat
		 * @return result the current status of the seat 
		 */
		synchronized public int getSeat(int x, int y){
			assert x > 0 && x < 4 : ("Violated Precondition");
			assert y > 0 && y < 51 : ("Violatetd Predcondititon");
			int result = this.chart[x][y];
			assert result >= 0 && result < 4 : ("Violated Postcondition");
			return result;
			
		}
		/**
		 * This method is used to assign seats 
		 * @param x the row of the seat
		 * @param y column of the seat
		 * @param id the unique ID of the producer
		 */
		synchronized public void setSeat(int x, int y, int id){
			assert x > 0 && x < 4 : ("Violated Precondition");
			assert y > 0 && y < 51 : ("Violatetd Predcondititon");
			assert id > 0 && id < 4 : ("Violatetd Predcondititon");
			
			while(busy)
				try{
					wait();
				}catch(InterruptedException e) { }
				
			this.chart[x][y] = id;
			map.setCell(y+1, x+1, id);
				
			busy = true;
			notify();
	
		}
		
		/**
		 * This method checks to see if the given seat is available or not
		 * @param x
		 * @param y
		 * @return boolean this returns {@code true} if seat exist. {@code false} if seat is taken.
		 */
		synchronized public boolean checkSeat(int x, int y){
			assert x > 0 || x < 4 : ("Violated Precondition");
			assert y > 0 || y < 51 : ("Violatetd Predcondititon");
			while(!busy)
				try{
					wait();
				}catch(InterruptedException e){}
			
			if (chart[x][y] == 0){
				busy = false;
				notify();
				return true;
			}else{
				busy = true;
				notify();
				return false;
			}
			
		}
		/**
		 * This method checks if the 2D Array chart is full or not 
		 * @return boolean this returns {@code true} if chart is full. {@code false} if chart is not full.
		 */
		synchronized public boolean isFull(){
			for(int i = 0; i<4;i++){
				for(int j = 0; j<50;j++){
					if(chart[i][j]==0){
						return false;
					}
				}
			}
			return true;
		}
		
	
	}


