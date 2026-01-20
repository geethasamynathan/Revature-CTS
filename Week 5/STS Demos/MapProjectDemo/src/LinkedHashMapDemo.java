import java.util.*;

public class LinkedHashMapDemo {

	public static void main(String[] args) {
		 Map<Integer, String> empMap = new LinkedHashMap<>();
	        empMap.put(101, "Arun");
	        empMap.put(102, "Divya");
	        empMap.put(105, "Riya");
	        empMap.put(103, "Ravi");

	        System.out.println(empMap); 

	}

}
