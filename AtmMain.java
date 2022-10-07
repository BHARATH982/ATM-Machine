package ass1;

//---BHARATH 20L309 Karpagam College Of Engineering-----//
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class AtmMain {

	public static void main(String[] args) throws Exception {
	  	
	  		
  		   Class.forName("com.mysql.cj.jdbc.Driver");	 
	       Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Algorithm","root","mysqlB7&");
	       Statement st=   c.createStatement();
	       ResultSet rs;
	       CashToAtm ctm=new CashToAtm();
		   CustomerDetails cd=new CustomerDetails();
	   	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1 for filling ATM machine");
		System.out.println("Enter 2 for to add new customer details");
		System.out.println("Enter 3 for check amount in ATM");
		System.out.println("Enter 4 for check Balance");
        System.out.println("Enter 5 for withdraw");
		int choice=sc.nextInt();
		
		
	switch(choice) {
	case 1:
	
		 if(ctm.checkEmpty()) {
		 System.out.println("ATM machine is out of Currency");	
		 ctm.addAmount(); 
	     st.execute("insert into Atm values("+ctm.twoThousand+","+ctm.fiveHundred+","+ctm.hundred+")");
		 System.out.println(ctm);
		}
		break;
	case 2:
		
		System.out.println("To Add Cutomer details");	
	    cd.addCustomerDetails();
		st.execute("insert into cust_details values("+cd.Accno+",'"+cd.name+"',"+cd.pin+","+cd.balance+")");
	    System.out.println(" ----------Customer Details succesfully added----------------");
	   break;
	
	case 3:
		System.out.println("-------------------------Denomination------------------------");
		System.out.println("2000     500     100");
		rs=st.executeQuery("select * from atm");
		while(rs.next()) {
			System.out.println(+rs.getInt(1)+"       "+rs.getInt(2)+"       "+rs.getInt(3));
			System.out.println(2000*rs.getInt(1)+"   "+500*rs.getInt(2)+"   "
					+ " "+100*rs.getInt(3));
		}
		break;	
		
	case 4:
		System.out.println("Enter the Acccount number and pin");
		int acc=sc.nextInt();
		int pin1=sc.nextInt();
	
		rs=st.executeQuery("select balance from cust_details where acc_no="+acc);
		while(rs.next())
		System.out.println("Balance="+rs.getInt(1));
		break;
		
	case 5:
		System.out.println("Enter the Acccount number and pin");
	    int acc1=sc.nextInt();
		int pin11=sc.nextInt();
		System.out.println("Enter the amount to withdraw");
		int amount=sc.nextInt();
		rs=st.executeQuery("select balance from cust_details where acc_no="+acc1);
		    rs.next();
			if(amount<=rs.getInt(1)) {
				System.out.println("Balance="+rs.getInt(1));

				st.execute("update  cust_details set balance="+(rs.getInt(1)-amount)+" where acc_no="+acc1);
	        	System.out.println("Amount is withdrawed");
			}
			else
				System.out.println("Insufficient balance");
				
	break;

		
	 } //End of switch
  }
}
