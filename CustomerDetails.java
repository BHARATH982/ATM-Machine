package ass1;

import java.util.*;

public class CustomerDetails {
	Scanner sc=new Scanner(System.in);
	
	public int Accno,pin;
	public String name;
	public double balance;
	List cust=new ArrayList();
	
    public void addCustomerDetails() {
    	System.out.println("Enter the account no");
    	 Accno=sc.nextInt();
    	System.out.println("Enter the name of Account Holder");
    	name=sc.next();
    	System.out.println("Enter the pin number");
    	pin=sc.nextInt();
    	System.out.println("Enter the balance");
        balance=sc.nextDouble(); 
    	  	
    }
    }
