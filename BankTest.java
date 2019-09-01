# BankTest
/* Exercise 02 Design a class to represent a bank account. Include the following members. 
Data Members (properties)
 Name of the depositor
 Account Number
 Type of Account 
 Balance amount in the account   
Methods
 To assign initial values
 To deposit amount 
 To withdraw and amount after checking balance 
 To display the name of balance    
Modify the above program to incorporate a constructor to provide initial values   
Assume that bank maintain two kinds of account for its customer, one called savings account and the other Fixed Deposit Account.   
Savings Account Provides 
 When opening a new savings account minimum deposit amount must be 500
 Can deposit money
 Interest Rate 4% per month 
 Withdrawal facility – When withdrawing money account balance cannot be less than 100. */

import java.util.Scanner;
public abstract class Bank{
	private String Name, AccountNumber ,Type;
	private double Balance;
	
	public Bank(String n,String A,String T,double bal){
		Name=n;
		AccountNumber=A;
		Type=T;
		Balance=bal;
	}
	public void setName(String n){
		Name=n;
	}
	
	public void setAcNumber(String ac){
		AccountNumber=ac;
	}
	
	public void setType(String typ){
		Type=typ;
	}
	
	public void setBalance(double bal){
		Balance=bal;
	}
	
	public String getName(){
		return Name;
	}
	public String getAcNumber(){
		return AccountNumber;
	}
	public String getType(){
		return Type;
	}
	
	public double getBalance(){
		return Balance;
	}
	
	public abstract double calcint();
	public abstract double updateBal();
	//Deposite money
	public double deposite(double newAmount){
		Balance=Balance+newAmount;
		return Balance;
	}
	
	//withdraw
	public double withdaraw(double withdrawAmount){
		Balance=Balance-withdrawAmount;
		return Balance;
	}
	
	public void display(){
		System.out.println("Name:"+Name+"\nAccountNumber:"+AccountNumber+"\nBalance:"+Balance);
	}
}


public class SavingAccount extends Bank{
	private double amount;
	public SavingAccount(String n,String A,String T,double bal,double amount){
		super(n,A,T,bal);
		this.amount=amount;
		
	}
	
	//public SavingAccount(){}
	
	public void setAmount(double amount){
		amount=amount;
	}
	public double getAmount(){
		return amount;
	}
	public  double calcint(){
		//getBalance()=getBalance()+(getBalance()*0.04);
		//return getBalance();
		  return getBalance()*0.01;
	}
	
	public double updateBal(){
		return getBalance()+calcint();
	}
	
	public boolean checkBal(){
		if(getBalance()==0.00)
			return true;
		return false;
	}
	//public double amount;
	
	public void depositeMoney(){
		if(checkBal()==true){
			if(amount<500){
				System.out.println("You cannot deposite");
			}
		
			else{super.deposite(amount);}
		}
		else{super.deposite(amount);}
		
	}
	/*@Override
	public void display(){
		System.out.println("Name:"+Name+"\nAccountNumber:"+AccountNumber+"\nBalance:"+Balance);
	}*/
	
	
	
}


import java.util.Scanner;
public class BankTest{
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		String name,acNum,type;
		double amount;
		double balance=0;
		
		System.out.print("Enter name:");
		name=input.nextLine();
		System.out.print("Enter Acnumber:");
		acNum=input.nextLine();
		System.out.print("Enter type:");
		type=input.nextLine();
		System.out.print("Enter amount:");
		amount=input.nextDouble();
	
		System.out.println("");
		
		

		//Bank obj=new Bank(name,acNum,type,balance);
		
		//obj.display();
		SavingAccount obj1=new SavingAccount(name,acNum,type,balance,amount);
	//SavingAccount obj2=new SavingAccount();
		
		//obj1.deposite(amount);
		obj1.depositeMoney();
		obj1.display();
		
	}

}
