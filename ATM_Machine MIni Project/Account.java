package ATM;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Account {
	Scanner input=new Scanner(System.in);
	DecimalFormat money_format=new DecimalFormat("'Rs. '###,##0.00");
	
	ArrayList<Double> cur_acc=new ArrayList<Double>();
	ArrayList<Double> sav_acc=new ArrayList<Double>();
	
	private double currentBalance;
	private double savingsBalance;
	private int Accountno;
	private int Pinno;
	double amount;
	public int key;
	
	public int setAccountno(int Accountno)
	{
		this.Accountno=Accountno;
		return Accountno;
	}
	public int setPinno(int Pinno)
	{
		this.Pinno=Pinno;
		return Pinno;
	}
	
	public int getAccountno()
	{
		return Accountno;
	}
	
	public int getPinno()
	{
		return Pinno;
	}
	
	public double getCurrentBalance(int key)
	{
	
		cur_acc.add((double)0);
		cur_acc.add((double)0);
		cur_acc.add((double)0);
		cur_acc.add((double)0);
		cur_acc.add((double)0);
		
		currentBalance=cur_acc.get(key);
		return currentBalance;
	}
	
	public double getSavingsBalance(int key)
	{
		
		sav_acc.add((double)0);
		sav_acc.add((double)0);
		sav_acc.add((double)0);
		sav_acc.add((double)0);
		sav_acc.add((double)0);
		
		savingsBalance=sav_acc.get(key);
		return savingsBalance;
	}
	
	public double calCurrentWithdraw(double amount)
	{
		cur_acc.set(key,(getCurrentBalance(key)-amount));
		return currentBalance;
	}
	
	public double calSavingsWithdraw(double amount)
	{
		sav_acc.set(key,(getSavingsBalance(key)-amount));
		return savingsBalance;
	}
	
	public double calCurrentDeposit(double amount)
	{
		cur_acc.set(key,(getCurrentBalance(key)+amount));
		return currentBalance;
	}
	
	public double calSavingsDeposit(double amount)
	{
		sav_acc.set(key,(getSavingsBalance(key)+amount));
		return savingsBalance;
	}
	
	public void getCurrentWithdraw()
	{
		System.out.println("Current Account Balance is ["+money_format.format(getCurrentBalance(key))+"]");
		System.out.println("Amount You Want To Withdraw From Your Current Account");
		System.out.print("Input: ");
		
		amount=input.nextDouble();
		
		if((getCurrentBalance(key)-amount)>0)
		{
			calCurrentWithdraw(amount);
			System.out.println("New Current Account Balance is ["+money_format.format(getCurrentBalance(key))+"]");
		}
		else
		{
			System.out.println("************Withdraw Failed***********");
			System.out.println("*****Balance must not be Negative*****");
		}
	}
	
	public void getSavingsWithdraw()
	{
		System.out.println("Savings Account Balance is ["+money_format.format(getSavingsBalance(key))+"]");
		System.out.println("Amount You Want To Withdraw From Your Savings Account");
		System.out.print("Input: ");
		
		amount=input.nextDouble();
		
		if((getSavingsBalance(key)-amount)>0)
		{
			calSavingsWithdraw(amount);
			System.out.println("New Savings Account Balance is ["+money_format.format(getSavingsBalance(key))+"]");
		}
		else
		{
			System.out.println("************Withdraw Failed***********");
			System.out.println("*****Balance must not be Negative*****");
		}
	}
	public void getCurrentDeposit()
	{
		System.out.println("Amount You Want To Deposit In your Current Account");
		System.out.print("Input: ");
		
		amount=input.nextDouble();
		
		if(amount>0)
		{
			calCurrentDeposit(amount);
			System.out.println("New Current Account Balance is ["+money_format.format(getCurrentBalance(key))+"]");
		}
		else
		{
			System.out.println("************Deposit Failed***********");
		}
	}
	
	public void getSavingsDeposit()
	{
		System.out.println("Amount You Want To Deposit In your Savings Account");
		System.out.print("Input: ");
		
		amount=input.nextDouble();
		
		if(amount>0)
		{
			calSavingsDeposit(amount);
			System.out.println("New Savings Account Balance is ["+money_format.format(getSavingsBalance(key))+"]");
		}
		else
		{
			System.out.println("************Deposit Failed***********");
		}
	}
}
