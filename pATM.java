interface ATM
{
	void viewBalance();
	String pinChange();
	double withDrawal(double amount);
	double deposit(double amount);
	void viewMiniStatement();
}
class atmOperations implements ATM
{
	static java.util.Scanner sc=new java.util.Scanner(System.in);
	static double amount=10000;
	String name="MR/Miss HR";
	private String phNo="9988776655";
	private String atmPin="14341";
	String getphNo()
	{
		return phNo;
	}
	void setphNo(String phNo)
	{
		this.phNo=phNo;
	}
	String getatmPin()
	{
		return atmPin;
	}
	void setatmPin(String atmPin)
	{
		this.atmPin=atmPin;
	}
	public void viewBalance()
	{
		System.out.println("Amount in your acoount "+amount);
	}
	static int otpGenarator()
	{
		return (int)(Math.random()*100000);
	}
	public String pinChange()
	{
		int OTP=otpGenarator();
		System.out.println("OTP : "+OTP);
		System.out.print("ENTER otp : ");
		int Enteredotp=sc.nextInt();
		if(Enteredotp==OTP)
		{
			System.out.println("ENTER new ATM pin");
			int newPin=sc.nextInt();
			new atmOperations().setatmPin(newPin+"");
			return "ATM password Reseted";
		}
		else
		{
			return "Worng OTP\nTRY After Some Time";
		}
	}
	public double withDrawal(double amount)
	{
		double Amount =this.amount-amount;
		if(Amount<0)
		{
			System.out.print("Not Enough Money\nYour balance : ");
			return this.amount;
		}
		else
		{
			this.amount=Amount;
			System.out.print("Amount drawn :");
			return amount;
		}
	}
	public double deposit(double amount)
	{
		this.amount=this.amount+amount;
		return this.amount;
	}
	public void viewMiniStatement()
	{
		System.out.println("Account holder name : "+name);
		System.out.println("Account Balance : "+amount);
	}
}
class Main
{
	static atmOperations op=new atmOperations();
	void checkpin(String phno,String pin)
	{
		if(((phno).equals(op.getphNo())) && (pin).equals(op.getatmPin()))
		{
			System.out.println("Login Successfully\n\n");
			menu();
		}
		else
		{
			System.out.println("WORNG DETAILS ENTERED");
			System.out.println("DO YOU WANT RESET PIN\nPRESS \n1 --> Reset PIN \n2 --> exit");
			int option=atmOperations.sc.nextInt();
			if(1==option)
			{
				System.out.print("OTP : ");
				int otp=(int)(Math.random()*1000);
				System.out.println(otp);
				System.out.println("PLEASE enter OTP");
				int Otp=atmOperations.sc.nextInt();
				if(Otp==otp)
				{
					System.out.println("ENTER new pin");
					int newPIN=atmOperations.sc.nextInt();
					op.setatmPin(newPIN+"");
					System.out.println("NEW PIN ENTERED SUCCESSFULLY...!");
					System.out.println("Enter Number \n1 -->  main MENU\n2 --> Exit");
					int num=op.sc.nextInt();
					if(num==1)
					{
						menu();
					}
					else
					{
						Exit();
					}
				}
				else
				{
					System.out.println("Worng otp entered \nTHANK YOU");
					System.exit(0);
				}
			}
			else
			{
				Exit();
				System.exit(0);
			}
		}
	}
	
	void execution(int option)
	{
		
		switch(option)
		{
			case 1:
				op.viewBalance();
				Exit();
				break;
			case 2:
				System.out.println(op.pinChange());
				Exit();
				break;
			case 3:
				System.out.print("ENTER Withdrawal Amount : ");
				System.out.println(op.withDrawal(atmOperations.sc.nextDouble()));
				Exit();
				/*
				System.out.println("Please Collect CASH & CARD\nPress 1 --> Show Balance \n2 --> exit");
				int OPtion=atmOperations.sc.nextInt();
				if(OPtion==1)
				{
					op.viewBalance();
				}
				else
				{
					System.out.println("Thank you...!");
					System.exit(0);
				}
				*/
				break;
			case 4:
				System.out.println("Enter Deposit Amount");
				int amount =atmOperations.sc.nextInt();
				System.out.println("AMOUNT CREDITED : "+amount);
				System.out.println("your account balance : "+op.deposit(amount));
				break;
			case 5:
				System.out.println("	MINI STATEMENT ");
				op.viewMiniStatement();
				break;
			default:
				System.out.println("Worng Option/nPlease choose valid option");
				menu();
		}
		
	}
	String Exit()
	{
		return "Thank YOU\n PLEASE visit once again";
	}
	void menu()
	{
		System.out.println("ENTER 1 --> View Balance");
		System.out.println("ENTER 2 --> Pin Change");
		System.out.println("ENTER 3 --> With Drawal");
		System.out.println("ENTER 4 --> Deposit");
		System.out.println("ENTER 5 --> Mini Statement");
		System.out.print("CHOOSE AN OPTION : ");
		int option=atmOperations.sc.nextInt();
		execution(option);
	}
	public static void main(String[] V)
	{
		System.out.print("Enter PHONE Number : ");
		String phno=atmOperations.sc.next();
		System.out.print("\nEnter ATM PIN : ");
		String Pin=atmOperations.sc.next();
		Main m=new Main();
		m.checkpin(phno,Pin);		
	}
}