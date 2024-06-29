import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class car {
	private String carId;
	private String brand;
	private String model;
	private double basePricePerDay;
	private boolean availability;
	public car(String carId,String brand,String model,double basePricePerDay)
	{
		this.carId=carId;
		this.brand=brand;
		this.model=model;
		this.basePricePerDay=basePricePerDay;
		this.availability=true;
	}
	String getcarId()
	{
		return carId;
	}
	void setcarId(String carId)
	{
		this.carId=carId;
	}
	String getbrand()
	{
		return brand;
	}
	void setbrand(String brand)
	{
		this.brand=brand;
	}
	String getmodel()
	{
		return model;
	}
	void setmodel(String model)
	{
		this.model=model;
	}
	double getbasePricePerDay()
	{
		return basePricePerDay;
	}
	void setbasePricePerDay(double basePricePerDay)
	{
		this.basePricePerDay=basePricePerDay;
	}
	boolean isavailable()
	{
		return availability;
	}
	
	double calculatePrice(int rentalDays)
	{
		return basePricePerDay*rentalDays;
	}
	void rent()
	{
		availability=false;
	}
	void returnCar()
	{
		availability=true;
	}
}

class customer
{
	private String customerId;
	private String name;
	String getcustomerId()
	{
		return customerId;
	}
	void setcustomerId(String customerId)
	{
		this.customerId=customerId;
	}
	String getname()
	{
		return name;
	}
	void setname(String name)
	{
		this.name=name;
	}
	customer(String customerId,String name)
	{
		this.customerId=customerId;
		this.name=name;
	}
}
class Rental
{
	private car Car;
	private customer Customer;
	private int days;
	car getcar()
	{
		return Car;
	}
	customer getcustomer()
	{
		return Customer;
	}
	Rental(car Car,customer Customer,int days)
	{
		this.Car=Car;
		this.Customer=Customer;
		this.days=days;
	}
}
class RentalSystem
{
	private List<car> cars;
	private List<customer> customers;
	private List<Rental> rentals;
	RentalSystem()
	{
		cars = new ArrayList();
		customers=new ArrayList();
		rentals =new ArrayList();
	}
	void addcar(car Car)
	{
		cars.add(Car);
	}
	void addCustomer(customer Customer)
	{
		customers.add(Customer);
	}
	void rentCar(car Car,customer Customer,int days)
	{
		if(Car.isavailable())
		{
			Car.rent();
			rentals.add(new Rental(Car,Customer,days));
		}
		else
		{
			System.out.println("Car is not available for rent.");
		}
	}
	public void returnCar(car Car)
	{
		Car.returnCar();
		Rental rentalToRemove=null;
		for(Rental rental:rentals)
		{
			if(rental.getcar()==Car)
			{
				rentalToRemove=rental;
				break;
			}
		}
		if(rentalToRemove != null)
		{
			rentals.remove(rentalToRemove);
			System.out.println("Car returned Successfully.");
		}
		else
		{
			System.out.println("car was not returned");
		}
	}
	public void menu()
	{
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("		car RENTAL system");
			System.out.println("	1. Rent a car");
			System.out.println("	2. Return a car");
			System.out.println("	3. Exit\n\n");
			System.out.println("	Enter your choice");
			int choice=sc.nextInt();
			sc.nextLine();
			if(choice==1)
			{
				System.out.println("\n  RENT a car\n");
				System.out.println("Enter your name");
				String customerName=sc.nextLine();
				System.out.println("\n Availabile Cars");
				for(car Car:cars)
				{
					if(Car.isavailable())
					{
						System.out.println(Car.getcarId()+"  "+Car.getbrand()+"  "+Car.getmodel());
					}
				}
				System.out.println("\n Enter the car Id you want to rent:");
				String carId=sc.nextLine();
				System.out.println("Enter the number of days for RENTAL");
				int rentalDays=sc.nextInt();
				sc.nextLine();
				customer newCustomer=new customer("CUS"+(customers.size()+1),customerName);
				addCustomer(newCustomer);
				//40:46
				car selectedCar=null;
				for(car Car:cars)
				{
					if(Car.getcarId().equals(carId) && Car.isavailable())
					{
						selectedCar= Car;
						break;
					}
				}
				
				if(selectedCar != null)
				{
					double totalPrice=selectedCar.calculatePrice(rentalDays);
					System.out.println("		Rental information");
					System.out.println("	Customer Id : "+newCustomer.getcustomerId());
					System.out.println("	Customer Name : "+newCustomer.getname());
					System.out.println("	Car : "+selectedCar.getbrand()+" "+selectedCar.getmodel());
					System.out.println("	Rental Days :"+rentalDays);
					System.out.printf("	Total Price : %.2f\n",totalPrice);
					
					System.out.println("\n	Confirm rental(Y/N): ");
					String confirm = sc.nextLine();
					if(confirm.equalsIgnoreCase("Y"))
					{
						rentCar(selectedCar, newCustomer, rentalDays);
						System.out.println("\nCar Rented successfully");
					}
					else
					{
						System.out.println("\nRental canceled.");
					}
				}
				else
				{
					System.out.println("\nInvalid car selection or car not available for rent.");
				}
			}
			else if(choice==2)
			{
				System.out.println("\n		Return a car");
				System.out.println("Enter the car Id you want to return : ");
				String carId=sc.nextLine();
				
				car carToReturn=null;
				for(car Car:cars)
				{
					if(Car.getcarId().equals(carId) && !Car.isavailable())
					{
						carToReturn = Car;
						break;
					}
				}
				
				if(carToReturn != null)
				{
					customer Customer = null;
					for(Rental rental:rentals)
					{
						if(rental.getcar() == carToReturn)
						{
							Customer = rental.getcustomer();
							break;
						}
					}
				
					if(Customer != null)
					{
						returnCar(carToReturn);
						System.out.println("Car returned successfully by "+Customer.getname());
					}
					else
					{
						System.out.println("car was not rental ot rental informatin is missing");
					}
				}
			}
			else if(choice==3)
			{
				break;
			}
			else
			{
				System.out.println("Invalid choice. Please enter a valid option.");
			}
		}
		System.out.println("\n\nTHANK YOU for using the Car rental System!");
	}
}

class Main
{
	public static void main(String[] VLMJ)
	{
		RentalSystem rs=new RentalSystem();
		car c1=new car("c001","maruthi","800",600.00);
		car c2=new car("c002","Mahindra","scorpio",800.00);
		car c3=new car("c003","toyoto","inova",700.00);
		car c4=new car("c004","benz","X-series",2000.00);
		rs.addcar(c1);
		rs.addcar(c2);
		rs.addcar(c3);
		rs.addcar(c4);
		rs.menu();
	}
}