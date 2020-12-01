import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSpinner;
import java.util.*;
public class SeatingMap {

	
	private JFrame frame;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						SeatingMap window = new SeatingMap();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the application.
		 */
		public SeatingMap() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			table = new JTable();
			frame.getContentPane().add(table, BorderLayout.CENTER);

			String[] columnNames = {"1","2","3","4","5"};
			Object[][] rowNames = new Object[51][5];
			
			for(int i = 0; i<51; i++){
				for(int j=1; j<5 ; j++){
					
				}
			}
			int count = 1;
			for(int i = 1; i<51; i++){
				for(int j=0; j<1 ; j++){
					rowNames[i][j] = count;
					count++;
				}
			}
			
			for(int i = 1; i<5; i++){
				rowNames[0][i]=i;
			}
			
			
			
			rowNames[0][0] = "Row/Column";
			
			
			
			table = new JTable(rowNames, columnNames);
			table.setEnabled(false);
			
			JPanel panel = new JPanel();	
			panel.add(table);

			JScrollPane scrollPane = new JScrollPane(panel);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			frame.getContentPane().add(scrollPane, BorderLayout.EAST);
			frame.setVisible(true);
		}
			
		public void setCell(int row, int col, int ID){
				table.setValueAt(ID, row, col);   
		}
		
		public void dest()
		{
			frame.setVisible(false);
		}
		
	}


