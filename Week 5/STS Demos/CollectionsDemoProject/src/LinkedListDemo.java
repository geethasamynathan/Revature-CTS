import java.util.Iterator;
import java.util.*;

class Student {
	String name;
	int age;

	Student(String na, int ag) {
		name = na;
		age = ag;
	}

	public String toString() {
		return "Name : " + name + " Age : " + age;
	}
}

public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList<String> animals = new LinkedList<>();
		// Add elements to LinkedList
		animals.add("Dog");
		animals.add("Cat");
		animals.add("Horse");
		System.out.println("LinkedList: " + animals);
		// Get the element from the linked list
		String str = animals.get(1);
		System.out.print("Element at index 1: " + str);
		System.out.println(" ");
		// Iterator method
		Iterator<String> itr = animals.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		LinkedList<Student> list1 = new LinkedList<Student>();
		list1.add(new Student("Haj", 20));
		list1.add(new Student("Raj", 19));
		list1.add(new Student("Sar", 18));
		list1.add(new Student("Kan", 17));
		for (Student x : list1) {
			System.out.println(x);
		}

	}
}
