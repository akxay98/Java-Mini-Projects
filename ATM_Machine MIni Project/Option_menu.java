package ATM;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Option_menu extends Account {
	
	Scanner input=new Scanner(System.in);
	
	ArrayList<Integer> accno=new ArrayList<Integer>();
	ArrayList<Integer> pin=new ArrayList<Integer>();
	DecimalFormat money_format=new DecimalFormat("'Rs. '###,##0.00");

	public void getLogin()
	{
		
		accno.add(123454);
		accno.add(123454);
		accno.add(123456);
		accno.add(123457);
		accno.add(123458);
		
		pin.add(1234);
		pin.add(1235);
		pin.add(1236);
		pin.add(1237);
		pin.add(1238);
		
		while(true)
		{
			System.out.println("-----Welcome-----");
			System.out.println("1. Banking");
			System.out.println("2. Exit");
			System.out.print("Input: ");
			
			String open=input.next();
			
			if(open.equals("1"))
			{
				System.out.println("Enter Account Number");
				System.out.print("Input: ");
					setAccountno(input.nextInt());
				System.out.println("Enter Pin Number");
				System.out.print("Input: ");
					setPinno(input.nextInt());
					
				int y=accno.size();
				int temp=0;
				
				for(int i=0;i<=y-1;i++)
				{
					if(accno.get(i)==getAccountno() && pin.get(i)==getPinno())
					{
						key=i;
						getAcctype();
					}
					else
					{
						temp++;
					}
				}
				if(temp!=y-1)
				{
					System.out.println("*****Account Number Or Pin Not Correct*****");
					System.out.println("*****Please Enter valid Input*****");
				}
				
			}
			else if(open.equals("2"))
			{
				System.out.println("Terminated");
				break;
			}
			else
			{
				System.out.println("*****Please Enter valid Input*****");
			}

		}
		
	}
	
	public void getAcctype()
	{
		System.out.println("-----Select Account Type-----");
		System.out.println("1. Current Acount");
		System.out.println("2. Savings Account");
		System.out.println("3. Exit");
		System.out.println("Input: ");
		
		String acc_type=input.next();
		
		if(acc_type.equals("1"))
		{
			getCurrent();
		}
		else if(acc_type.equals("2"))
		{
			getSavings();
		}
		else if(acc_type.equals("3"))
		{
			System.out.println("Thank You for using our service");
			System.out.println("++++HAVE A GOOD DAY++++");
		}
		else
		{
			System.out.println("*****Please Enter valid Input*****");
			getAcctype();
		}
		
	}
	
	public void getCurrent()
	{
		System.out.println("________CURRENT ACCOUNT________");
		System.out.println("1. Check Balance");
		System.out.println("2. Withdraw Money");
		System.out.println("3. Deposit Money");
		System.out.println("4. Exit");
		System.out.print("Input: ");
		
		String cur_val=input.next();
		
		if(cur_val.equals("1"))
		{
			System.out.println("Current Account Balance is ["+money_format.format(getCurrentBalance(key))+"]");
			getAcctype();
		}
		else if(cur_val.equals("2"))
		{
			getCurrentWithdraw();
			getAcctype();
		}
		else if(cur_val.equals("3"))
		{
			getCurrentDeposit();
			getAcctype();
		}
		else if(cur_val.equals("4"))
		{
			System.out.println("Thank You for using our service");
			System.out.println("++++HAVE A GOOD DAY++++");
		}
		else
		{
			System.out.println("*****Please Enter valid Input*****");
			getCurrent();
		}
		
	}
	
	public void getSavings()
	{
		System.out.println("________SAVINGS ACCOUNT________");
		System.out.println("1. Check Balance");
		System.out.println("2. Withdraw Money");
		System.out.println("3. Deposit Money");
		System.out.println("4. Exit");
		System.out.print("Input: ");
		
		String sav_val=input.next();
		
		if(sav_val.equals("1"))
		{
			System.out.println("Savings Account Balance is ["+money_format.format(getSavingsBalance(key))+"]");
			getAcctype();
		}
		else if(sav_val.equals("2"))
		{
			getSavingsWithdraw();
			getAcctype();
		}
		else if(sav_val.equals("3"))
		{
			getSavingsDeposit();
			getAcctype();
		}
		else if(sav_val.equals("4"))
		{
			System.out.println("Thank You for using our service");
			System.out.println("++++HAVE A GOOD DAY++++");
		}
		else
		{
			System.out.println("*****Please Enter valid Input*****");
			getSavings();
		}
		
	}

}
