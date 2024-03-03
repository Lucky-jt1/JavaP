class bank1
{
	private int A_positive=20;
	private int A_negative=10;
	private int B_positive=10;
	private int B_negative=15;
	private int AB_positive=20;
	private int AB_negative=11;
	private int O_positive=15;
	private int O_negative=25;
	static void display()
	{
		System.out.println("                    -------------------------------------------------------------------------");
		System.out.println("                   |       Apollo Hospitals Jubilee Hills Hyderabad                         |");
		System.out.println("                   |       Address: Rd Number 72, opposite Bharatiya Vidya Bhavan School    |");
		System.out.println("                   |       Film Nagar, Hyderabad, Telangana 500033                          |");
		System.out.println("                   |       Areas served: Hyderabad and nearby areas                         |");
		System.out.println("                   |       Hours: Open 24 hours Phone: 040 2360 7777                        |");
		System.out.println("                    -------------------------------------------------------------------------");

	}
	void incApos(int Apos)
	{
		System.out.println("                   Apos blood qunatity added");
		this.A_positive=this.A_positive+Apos;
		//setter method
	}
	void incAneg(int Aneg)
	{
		System.out.println("                   Aneg blood qunatity added");
		this.A_negative=this.A_negative+Aneg;
	}
	void incBpos(int Bpos)
	{
		System.out.println("                   Bpos blood qunatity added");
		this.B_positive=this.B_positive+Bpos;
	}
	void incBneg(int Bneg)
	{
		System.out.print("                   Bneg blood qunatity added");
		this.B_negative=this.B_negative+Bneg;
	}
	void incABpos(int ABpos)
	{
		System.out.println("                   ABpos blood qunatity added");
		this.AB_positive=this.AB_positive+ABpos;
	}
	void incABneg(int ABneg)
	{
		System.out.println("                   ABneg blood qunatity added");
		this.AB_negative=this.AB_negative+ABneg;
	}
	void incOpos(int Opos)
	{
		System.out.println("                   Opos blood qunatity added");
		this.O_positive=this.O_positive+Opos;
	}
	void incOneg(int Oneg)
	{
		System.out.println("                   Oneg blood qunatity added");
		this.O_negative=this.O_negative+Oneg;
	}
	int countApos()
	{
		System.out.print("                   present Apos blood qunatity = ");
		return this.A_positive;
	}
	int countAneg()
	{
		System.out.print("                   present Aneg blood qunatity = ");
		return this.A_negative;
	}
	int countBpos()
	{
		System.out.print("                   present Apos blood qunatity = ");
		return this.B_positive;
	}
	int countBneg()
	{
		System.out.print("                   present Bneg blood qunatity = ");
		return this.B_negative;
	}
	int countABpos()
	{
		System.out.print("                   present ABpos blood qunatity = ");
		return this.AB_positive;
	}
	int countABneg()
	{
		System.out.print("                   present ABneg blood qunatity = ");
		return this.AB_negative;
	}
	int countOpos()
	{
		System.out.print("                   present Opos blood qunatity = ");
		return this.O_positive;
	}
	int countOneg()
	{
		System.out.print("                   present Oneg blood qunatity = ");
		return this.O_negative;
	}
	
}
class user 
{
	static void meth()
	{
		java.util.Scanner sc=new java.util.Scanner(System.in);
		bank1 b1=new bank1();
		//System.out.print("show blood quantity\nenter(1-8)\n1 --> Apos    2 --> Aneg \n3 --> Bpos    4 --> Bneg \n5 --> ABpos   6 --> ABneg \n7 --> Opos    8 --> Oneg \nAND \nenter other key to show all the data");
		System.out.println("                    --------------------------------------------------");		
		System.out.println("                   |     \n                   |     SHOW BLOOD QUANTITY\n                   |     enter(1-8)\n                   |     _________\n                   |     1 --> Apos    2 --> Aneg \n                   |     3 --> Bpos    4 --> Bneg \n                   |     5 --> ABpos   6 --> ABneg \n                   |     7 --> Opos    8 --> Oneg \n                   |     OR\n                   |     \n                   |     enter other NUMBERS to show all the data\n                   |");
		System.out.println("                    --------------------------------------------------");
		int n=sc.nextInt();
		if(n==1)
		{
			System.out.print(b1.countApos());
		}
		else if(n==2)
		{
			System.out.print(b1.countAneg());
		}
		else if(n==3)
		{
			System.out.print(b1.countBpos());
		}
		else if(n==4)
		{
			System.out.print(b1.countBneg());
		}
		else if(n==5)
		{
			System.out.print(b1.countABpos());
		}
		else if(n==6)
		{
			System.out.print(b1.countABneg());
		}
		else if(n==7)
		{
			System.out.print(b1.countOpos());
		}
		else if(n==8)
		{
			System.out.print(b1.countOneg());
		}
		else
		{
			System.out.println(b1.countApos());
			System.out.println(b1.countAneg());
			System.out.println(b1.countBpos());
			System.out.println(b1.countBneg());
			System.out.println(b1.countABpos());
			System.out.println(b1.countABneg());
			System.out.println(b1.countOpos());
			System.out.println(b1.countOneg());			
		}
		System.out.print("\n\n");
		System.out.println("                    --------------------------------------------------------------");
		System.out.println("                   |          PRESS --> 1 to display the HOSPITAL LOCATION        |");
		System.out.println("                   |          PRESS --> other NUMBERS to continue                 |");
		System.out.println("                    --------------------------------------------------------------");
		int x=sc.nextInt();
		if(x==1)
		{
			b1.display();
		}
		System.out.println("                    ----------------------------------------------------");
		System.out.println("                   |    PRESS 1 to exit or another NUMBERS to recheck   |");
		System.out.println("                    ----------------------------------------------------");
		int c=sc.nextInt();
		if(c!=1)
		{
			meth();
		}
		
	}
	
}
class Hemp extends user
{
	static void m()
	{
		java.util.Scanner sc=new java.util.Scanner(System.in);
		bank1 b1=new bank1();
		System.out.println("                    ----------------------------------------");
		System.out.println("                   |     \n                   |     ADD BLOOD QUANTITY\n                   |     enter(1-8)\n                   |     _________\n                   |     1 --> Apos    2 --> Aneg \n                   |     3 --> Bpos    4 --> Bneg \n                   |     5 --> ABpos   6 --> ABneg \n                   |     7 --> Opos    8 --> Oneg \n                   |     AND \n                   |     then enter how much quantity to add \n                   |     OR\n                   |     \n                   |     enter other NUMBERS to show all the data\n                   |");
		System.out.println("                    ----------------------------------------");
		int n=sc.nextInt();
		if(n==1)
		{
			b1.incApos(sc.nextInt());
			System.out.println(b1.countApos());
		}
		else if(n==2)
		{
			b1.incAneg(sc.nextInt());
			System.out.println(b1.countAneg());
		}
		else if(n==3)
		{
			b1.incBpos(sc.nextInt());
			System.out.println(b1.countBpos());
		}
		else if(n==4)
		{
			b1.incBneg(sc.nextInt());
			System.out.println(b1.countBneg());
		}
		else if(n==5)
		{
			b1.incABpos(sc.nextInt());
			System.out.println(b1.countABpos());
		}
		else if(n==6)
		{
			b1.incABneg(sc.nextInt());
			System.out.print(b1.countABneg());
		}
		else if(n==7)
		{
			b1.incOpos(sc.nextInt());
			System.out.print(b1.countOpos());
		}
		else if(n==8)
		{
			b1.incOneg(sc.nextInt());
			System.out.print(b1.countOneg());
		}
		else
		{
			System.out.println("                   "+b1.countApos());
			System.out.println("                   "+b1.countAneg());
			System.out.println("                   "+b1.countBpos());
			System.out.println("                   "+b1.countBneg());
			System.out.println("                   "+b1.countABpos());
			System.out.println("                   "+b1.countABneg());
			System.out.println("                   "+b1.countOpos());
			System.out.println("                   "+b1.countOneg());
												
		}
		System.out.print("\n\n");
		System.out.println("                    --------------------------------------------------------------");
		System.out.println("                   |          PRESS 1 to display the HOSPITAL LOCATION            |");
		System.out.println("                   |          PRESS --> other NUMBERS to continue                 |");
		System.out.println("                    --------------------------------------------------------------");
		int x=sc.nextInt();
		if(x==1)
		{
			b1.display();
		}
		System.out.print("PRESS 1 to exit or another key to recheck");
		int c=sc.nextInt();
		if(c!=1)
		{
			m();
		}
		
		
	}

}
class APP extends Hemp
{
	static java.util.Scanner sc=new java.util.Scanner(System.in);
	
	
	void method(APP A)
	{
		System.out.println("                    -----------------------------------------");
		System.out.println("                   |                                         |");
		System.out.println("                   |               ENTER                     |");
		System.out.println("                   |        1 --> Hospital employee          |");
		System.out.println("                   |        2 --> Random user                |");
		System.out.println("                   |                                         |");
		System.out.println("                    -----------------------------------------");
		int a=sc.nextInt();
		if(a==1)
		{
			A.m();
		}
		if(a==2)
		{
			A.meth();
		}
	}
	public static void main(String[] VL)
	{
		APP A=new APP();
		A.method(A);
	}
}