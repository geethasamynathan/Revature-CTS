import java.util.*;

class Student {
	int id;
	String email;

	Student(int id, String email) {
		this.id = id;
		this.email = email;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Student))
			return false;
		Student other = (Student) o;
		return this.id == other.id; // unique by id
	}

	public int hashCode() {
		return Integer.hashCode(id);
	}

	public String toString() {
		return id + "-" + email;
	}
}


class Employee{
	int id;
	
	public Employee(int id) {
		this.id=id;
	}
}
public class HashSetWithCustomType {

	public static void main(String[] args) {
		Set<Student> students = new HashSet<>();
		students.add(new Student(101, "arun@gmail.com"));
		students.add(new Student(102, "divya@gmail.com"));
		students.add(new Student(101, "arun_new@gmail.com")); // duplicate by id

		System.out.println(students);
		System.out.println("Total unique students: " + students.size());
		
		Student s1=new Student(103,"Gem");
		
		Student s2=new Student(101, "arun@gmail.com");
		Student s3=new Student(102, "divya@gmail.com");
		Student s4=new Student(103,"Geetha@mail.com");
		Employee e1=new Employee(103);
		students.add(s1);
	    // 1) Print hashCodes before adding
        System.out.println("s1 hashCode: " + s1.hashCode());
        System.out.println("s2 hashCode: " + s2.hashCode());
        System.out.println("s3 hashCode: " + s3.hashCode());
		
        
        //Equals Method
        System.out.println("\nManual equals checks:");
        System.out.println("s1.equals(e1)? " + s1.equals(e1)); // true (same id)
        System.out.println("s1.equals(s2)? " + s1.equals(s2)); // false
        
        
        // print Each student Hashcode
        for(Student st:students)
        {
        	System.out.println(st + " ->  hashcode "+st.hashCode());
        }
	}

}
