import java.util.ArrayList;
class Employee
{
	private int id;
	private String name;
	private int age;
	private String department;
	private double salary;
	void setId(int id)
	{
		this.id=id;
	}
	int getId()
	{
		return id;
	}
	void setName(String name)
	{
		this.name=name;
	}
	String getName()
	{
		return name;
	}
	void setAge(int age)
	{
		this.age=age;
	}
	int getAge()
	{
		return age;
	}
	void setDepartment(String department)
	{
		this.department=department;
	}
	String getDepartment()
	{
		return department;
	}
	void setSalary(double salary)
	{
		this.salary=salary;
	}
	double getSalary()
	{
		return salary;
	}
	public String toString()
	{
		return "\n	Id : "+id+"	Name : "+name+"	Age : "+age+"	Department : "+department+"		Salary : "+salary;
	}
	Employee(int id,String name,int age,String department,double salary)
	{
		this.id=id;
		this.name=name;
		this.age=age;
		this.department=department;
		this.salary=salary;
	}
	
}

class EmpServices
{
	static ArrayList<Employee> al=new ArrayList();
	static java.util.Scanner sc=new java.util.Scanner(System.in);
	static
	{
		Employee e1=new Employee(101,"Narayan",22,"IT",20000);
		Employee e2=new Employee(102,"Naveen",23,"IT",25000);
		Employee e3=new Employee(103,"Srinivas",22,"Core",24500);
		Employee e4=new Employee(104,"Aditya",18,"Non IT",17000);
		Employee e5=new Employee(105,"Tanuja",21,"IT",25000);
		al.add(e1);
		al.add(e2);
		al.add(e3);
		al.add(e4);
		al.add(e5);
	}
	static void addDetails()
	{ 
		System.out.println("Enter details");
		System.out.println("Enter Employee Id ");
		int id=sc.nextInt();
		System.out.println("Enter Employee Name ");
		String name=sc.next();
		System.out.println("Enter Employee Age ");
		int age=sc.nextInt();
		System.out.println("Enter Employee Department ");
		String department=sc.next();
		System.out.println("Enter Employee Salary ");
		double salary=sc.nextDouble();
		Employee e=new Employee(id,name,age,department,salary);
		al.add(e);
		System.out.println("New Details added\n"+e);
		
	}
	void search(int id)
	{
		boolean print=false;
		for(Employee e:al)
		{
			if(e.getId()==id)
			{
				System.out.println(e);
				print=true;
			}
		}
		if(!print)
		{
			System.out.println("Not found");
		}
	}
	String update(int id)
	{
		for(Employee e:al)
		{
			if(e.getId()==id)
			{
				System.out.println("Enter details");
				System.out.println("Enter Employee Name ");
				String name=sc.next();
				e.setName(name);
				System.out.println("Enter Employee Age ");
				int age=sc.nextInt();
				e.setAge(age);
				System.out.println("Enter Employee Department ");
				String department=sc.next();
				e.setDepartment(department);				
				System.out.println("Enter Employee Salary ");
				e.setSalary(sc.nextDouble());
				System.out.println("Values Updated ");
				return e+" ";				
			}
		}
		return "Id not found";
	}
	String delete(int id)
	{
		for(Employee e:al)
		{
			if(e.getId()==id)
			{
				al.remove(e);
				return "Employee id : "+id+" details Removed";
			}
		}
		return "Id "+id+" not found";
	}
}

class EmpDetails
{
	static void exit()
	{
		System.out.println("\n\n\nPress 1 to enter main MENU");
		System.out.println("Press Other keys to EXIT");
		if(("1").equals(EmpServices.sc.next()))
		{
			String[] a1=null;
				main(a1);
		}
		else
		{
			System.out.println("THANK YOU");
		}
	}
	static void Options(int option)
	{
		switch(option)
		{
			case 1:
				System.out.println("Employees Details \n"+EmpServices.al);
				exit();
				break;
			case 2:
				EmpServices.addDetails();
				exit();
				break;
			case 3:
				System.out.println("Enter ID to search");
				int id=EmpServices.sc.nextInt();
				new EmpServices().search(id);
				exit();
				break;
			case 4:
				System.out.println("Enter Update value by using ID");
				int Id=EmpServices.sc.nextInt();
				System.out.println(new EmpServices().update(Id));
				exit();
				break;
			case 5:
				System.out.println("Enter Id to delete");
				System.out.println(new EmpServices().delete(EmpServices.sc.nextInt()));
				exit();
				break;
			default:
				System.out.println("----INVALID option \nplease ENTER once again\n\n\n");
				exit();
		}
	}
	static void menu()
	{
		System.out.println("\n\n\nSelect an Option");
		System.out.println("1 --> View all data");
		System.out.println("2 --> Add details of emp");
		System.out.println("3 --> Search by Id");
		System.out.println("4 --> Update Values");
		System.out.println("5 --> Delete row\n\n");
	}
	public static void main(String[] VLMJ)
	{
		menu();
		int option=EmpServices.sc.nextInt();
		Options(option);
	}
}