import java.util.Arrays;
import java.util.function.Predicate;
import java.util.*;

class Employee {
	int id;
	String name;
	double salary;

	Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public String toString() {
		return id + " - " + name + " - " + salary;
	}
}

public class LambdawithCollectionDemo {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
				new Employee(101, "Sam", 78000), 
				new Employee(102, "Tina", 38000),
				new Employee(103, "Yash", 58000),
				new Employee(104, "Peter", 78000));
		
		Predicate<Employee> elgibleForBonus= e -> e.salary>50000;
		
		for(Employee e : employees)
		{
			if(elgibleForBonus.test(e)) {
				System.out.println(e.id + " - "+e.name+" is Eligible for Bonus");
			}
		}

	}
}
