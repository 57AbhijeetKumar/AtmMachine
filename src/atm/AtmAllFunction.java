package atm;

import java.util.HashMap;
import java.util.Scanner;

class Data{
	float balance;
}

public class AtmAllFunction {
	Scanner sc = new Scanner(System.in);
	
	HashMap<Integer, Data> map = new HashMap<>();
	public AtmAllFunction() {
		System.out.println("Welcome to Atm");
		op();
	}
	
	public void op() {
		System.out.println("Enter Valid Pin");
		int pin = sc.nextInt();
		if(map.containsKey(pin)) {
			Data obj = map.get(pin);
			menu(obj);
		}
		else {
			System.out.println("Please Create Account First");
			System.out.println("Set Pin Greater than 2 digit and Less than 5 digit");
			int setpin = sc.nextInt();
			Data obj = new Data();
			if(Integer.toString(setpin).length()>2 && Integer.toString(setpin).length()<5) {
				obj.balance = 0;
				map.put(setpin, obj);
				menu(obj);
			}
			else {
				System.out.println("Invalid Pin System Terminate");
			}
		}
	}
	
	public void menu(Data obj) {
		System.out.println("Enter Your Choice");
		System.out.println("1-> Check Balance");
		System.out.println("2-> Withdrawl Money");
		System.out.println("3-> Deposit Money");
		System.out.println("4-> Exit");
		System.out.println("5-> Check Another Account");
		System.out.println("Enter Option Choose");
		int x = sc.nextInt();
		
		if(x==1) {
			checkBal(obj);
		}
		else if(x==2) {
			Withdrawl(obj);
		}
		else if(x==3) {
			Deposit(obj);
		}
		else if(x==4) {
			System.out.println("Thank You For Using Our ATM");
		}
		else if(x==5) {
			op();
		}
		else {
			System.out.println("Enter Valid Option");
			menu(obj);
		}
	}
	
	// Check Balance in Your Account

	public void checkBal(Data obj) {
		System.out.println("Your Current Balance is "+obj.balance);
		menu(obj);
	}
	
	// Deposit Amount In Your Account

	public void Deposit(Data obj) {
		System.out.println("Enter Amount");
		float d = sc.nextFloat();
		obj.balance = obj.balance+d;
		System.out.println("Amount Deposited Successfully");
		menu(obj);
	}

	// Withdrawl Amount from your Account
	
	public void Withdrawl(Data obj) {
		System.out.println("Enter Amount");
		float d = sc.nextFloat();
		if(d<=obj.balance) {
			obj.balance = obj.balance-d;
			System.out.println("Amount Withdrawl Successfully");
			menu(obj);
		}
		else {
			System.out.println("Insufficient Amount in your Account");
			menu(obj);
		}
		
	}


}
