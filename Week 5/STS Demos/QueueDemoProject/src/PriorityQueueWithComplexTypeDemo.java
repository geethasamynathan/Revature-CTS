import java.util.*;

class Employee implements Comparable<Employee> {
	private String name;
	private double salary;

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Employee employee = (Employee) o;
		return Double.compare(employee.salary, salary) == 0 && Objects.equals(name, employee.name);
	}

	public int hashCode() {
		return Objects.hash(name, salary);
	}

	public String toString ()
	{
		return "Employee{" + "name='" + name + '\'' + ", salary=" + salary + '}';
	}

// Compare two employee objects by their salary
	public int compareTo (Employee employee)
	{
		if (this.getSalary () > employee.getSalary ())
		{
			return 1;
		}
		else if (this.getSalary () < employee.getSalary ())
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
}

public class PriorityQueueWithComplexTypeDemo {

	public static void main(String[] args) {
		// Create a PriorityQueue
		PriorityQueue < Employee > employeePriorityQueue = new PriorityQueue <> ();
		// Add items to the Priority Queue
		employeePriorityQueue.add (new Employee ("Rajeev", 100000.00));
		employeePriorityQueue.add (new Employee ("Chris", 145000.00));
		employeePriorityQueue.add (new Employee ("Andrea", 115000.00));
		employeePriorityQueue.add (new Employee ("Jack", 167000.00));
		/*
		The compareTo() method implemented in the Employee class is used to determine
		in what order the objects should be dequeued.
		*/
		while (!employeePriorityQueue.isEmpty ())
		{
		System.out.println (employeePriorityQueue.remove ());
		}
		}

	}

