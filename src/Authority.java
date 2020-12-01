
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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


class Test<T> 
{ 
    // An object of type T is declared 
    T obj; 
    Test(T obj) {  this.obj = obj;  }  // constructor 
    public T getObject()  { return this.obj; } 
    
    
} 



class MyFrame6 extends JFrame implements ActionListener { 
	  
    // Components of the Form 
    private Container c; 
    private JButton a1;
    private JButton a2;
    private JButton a3;
   
    private static JTextArea src1;
    private JTextArea src3;
    
    
    public MyFrame6() 
    { 
         setTitle("Flight Booking Portal"); 
    	 setBounds(550, 40, 100, 50); 
        
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); 
        setResizable(true); 
  	  
        BufferedImage img = null;
		try {
			img = ImageIO.read(new File("C:/Users/kashish/Desktop/imgs/p1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JLabel background = new JLabel(new ImageIcon(img));
        background.setSize(1000,1000);
        
        setContentPane(background);
        setLayout(null);
        
        
        
        
        /////////////////////////////////////////////////////////
        
        a1 = new JButton("Check status"); 
        a1.setFont(new Font("Arial", Font.BOLD, 20)); 
        a1.setSize(220, 60); 
        a1.setLocation(550, 200); 
        a1.setBackground(Color.GREEN ); 
        a1.setForeground(Color.BLACK);
        a1.addActionListener(this); 
        add(a1); 
  
        a2 = new JButton("See Departments"); 
        a2.setFont(new Font("Arial", Font.BOLD, 20)); 
        a2.setSize(220, 60); 
        a2.setLocation(150, 200); 
        a2.setBackground(Color.GREEN ); 
        a2.setForeground(Color.BLACK);
        a2.addActionListener(this); 
        add(a2);
        
        a3 = new JButton("Allocate Duties"); 
        a3.setFont(new Font("Arial", Font.BOLD, 20)); 
        a3.setSize(220, 60); 
        a3.setLocation(950, 200); 
        a3.setBackground(Color.GREEN ); 
        a3.setForeground(Color.BLACK);
        a3.addActionListener(this); 
        add(a3);
        
        src1 = new JTextArea(); 
        src1.setFont(new Font("Arial", Font.PLAIN, 20)); 
        src1.setSize(400, 370); 
        src1.setLocation(450, 330); 
        src1.setBackground(Color.BLACK); 
        src1.setForeground(Color.GREEN);
        src1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        add(src1); 
             
        
  
        setVisible(true); 
    } 
    
    
    public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == a1) 
        {
        	src1.setText("");
        	ArrayList<String> status_available = new ArrayList<String>();
    		HashSet<String> statuses = new HashSet<String>(); 
    		HashMap<String, Integer> map  = new HashMap<String, Integer>(); 
    		try 
    		{
    				String url = "jdbc:mysql://localhost:3306/airport";		
    		        Connection conn = DriverManager.getConnection(url,"root","Kashish310311");
    		        Statement stmt = conn.createStatement();
    		        ResultSet rs;
    		        rs = stmt.executeQuery("SELECT * FROM flights;");
    		        while ( rs.next() )
    		        {
    		        	String s = rs.getString("status");
    		            status_available.add(s);
    		            statuses.add(s);
    	            
    		        }
    		        conn.close();
    		} 
    		catch (Exception e2) 
    		{
    		        src1.append("Got an exception! ");
    		        System.err.println(e2.getMessage());
    	    }		
            Iterator<String> ig = statuses.iterator(); 
            while (ig.hasNext()) 
            {
            	int count =0;
            	String y = ig.next();
            	src1.append("\nCounting for status " + y);
            	for (int i = 0; i < status_available.size(); i++) 
            	{
                    	String x =status_available.get(i); 
    			      
    					        if(y.equals(x))
    					        {
    					        	count++;
    					        }
    			        	
    			 }
    			       map.put(y,count);
            }
           
            
            for (Map.Entry<String, Integer> e3 : map.entrySet()) 
                src1.append("\n" + e3.getKey() + " " + e3.getValue()); 
    		
        }
    
        if (e.getSource() == a2) 
        {
        	src1.setText("");
        	Scanner sc= new Scanner(System.in);
			String dept;
			Test <String> sObj1 =  new Test<String>("Security"); 
			Test <String> sObj2 =  new Test<String>("Finance"); 
			Test <String> sObj3 =  new Test<String>("Food and Beverages"); 
			ArrayList <Test <String>> arrayList = new ArrayList<Test <String>>();
			arrayList.add(sObj1);
			arrayList.add(sObj2);
			arrayList.add(sObj3);
			   for (int i = 0; i < arrayList.size(); i++) 
						{
						genericDisplay(arrayList.get(i).getObject());
						}
												
									
				
        }
        
        if (e.getSource() == a3) 
        {
        	
        	src1.setText("");
        	asynchduties aut = new asynchduties(); try {
				aut.main(new String[0]);
				
				
				src1.append("\n Allocated Duties Successfully");
				
				
				
			} catch (InterruptedException e1) 
        	{
		
				e1.printStackTrace();
			}
        	
        }
        
        
      
    
    }
    
    static <T> void genericDisplay (T element) 
    { 
        src1.append("\n" + element); 
    } 
    
    
}







public class Authority {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException 
	{
	MyFrame6 f = new MyFrame6();
	}

}
