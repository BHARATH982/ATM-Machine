package ass1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;

public class CashToAtm {
	Scanner sc=new Scanner(System.in);
	
 private int totalAmount;
public int twoThousand,fiveHundred, hundred;
 
 
 public boolean checkEmpty() {
	 if(totalAmount==0)
		 return true;
	 return false;
 }
  
  public void addAmount() {
	    
	  System.out.println("Enter the count of Two Thousand rs");
	  twoThousand=sc.nextInt();
	  System.out.println("Enter the count of five hundred rs");
	  fiveHundred=sc.nextInt();
	  System.out.println("Enter the count of hundred rs");
	  hundred=sc.nextInt();
	  totalAmount=twoThousand*2000+fiveHundred*500+hundred*100;
		  
	  
  }
 
  
  
}
